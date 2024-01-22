package net.claudio.chemmod.block.entity;

import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.recipe.DeconstructorBlockRecipe;
import net.claudio.chemmod.screen.DeconstructorBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DeconstructorBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public DeconstructorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DECONSTRUCTOR_BLOCK.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> DeconstructorBlockEntity.this.progress;
                    case 1 -> DeconstructorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> DeconstructorBlockEntity.this.progress = value;
                    case 1 -> DeconstructorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Deconstructor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new DeconstructorBlockMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("deconstructor.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("deconstructor.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DeconstructorBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe(pEntity)) {
            pEntity.progress++;
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
        //will potentially move the 2nd slot into the first once depleted
        if (pEntity.itemHandler.getStackInSlot(0).isEmpty() && !pEntity.itemHandler.getStackInSlot(1).isEmpty())
        {
            pEntity.itemHandler.setStackInSlot(0,pEntity.itemHandler.getStackInSlot(1));
            int backup = pEntity.itemHandler.getStackInSlot(1).getCount();
            pEntity.itemHandler.extractItem(1, backup,false);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(DeconstructorBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<DeconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(DeconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        //potentially useless if statement
        if (pEntity.itemHandler.getStackInSlot(0).isEmpty() && !pEntity.itemHandler.getStackInSlot(1).isEmpty())
        {
            pEntity.itemHandler.setStackInSlot(0,pEntity.itemHandler.getStackInSlot(1));
            int backup = pEntity.itemHandler.getStackInSlot(1).getCount();
            pEntity.itemHandler.extractItem(1, backup,false);
        }
        if (hasRecipe(pEntity)) {
            recipe.ifPresent(deconstructorBlockRecipe -> {
                NonNullList<Ingredient> inputs = deconstructorBlockRecipe.getIngredients();

                NonNullList<ItemStack> outputs = deconstructorBlockRecipe.getOutput();
                //This if statement checks every slot to see if an output can be placed into its slot or if the slot is empty.
                if(pEntity.itemHandler.getStackInSlot(2).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(2).getCount() + outputs.get(0).getCount() &&
                        (outputs.size() < 2 || (outputs.size()>1 && pEntity.itemHandler.getStackInSlot(3).getMaxStackSize() > pEntity.itemHandler.getStackInSlot(3).getCount() + outputs.get(1).getCount() &&
                                (pEntity.itemHandler.getStackInSlot(3).getItem().equals(outputs.get(1).getItem()) || pEntity.itemHandler.getStackInSlot(3).isEmpty())))&&
                        (outputs.size() < 3 || (outputs.size()>2 && pEntity.itemHandler.getStackInSlot(4).getMaxStackSize() > pEntity.itemHandler.getStackInSlot(4).getCount() + outputs.get(2).getCount() &&
                                (pEntity.itemHandler.getStackInSlot(4).getItem().equals(outputs.get(2).getItem()) || pEntity.itemHandler.getStackInSlot(4).isEmpty())))&&
                        (outputs.size() < 4 || (outputs.size()>3 && pEntity.itemHandler.getStackInSlot(5).getMaxStackSize() > pEntity.itemHandler.getStackInSlot(5).getCount() + outputs.get(3).getCount() &&
                                (pEntity.itemHandler.getStackInSlot(5).getItem().equals(outputs.get(3).getItem()) || pEntity.itemHandler.getStackInSlot(5).isEmpty())))&&
                        (outputs.size() < 5 || (outputs.size()>4 && pEntity.itemHandler.getStackInSlot(6).getMaxStackSize() > pEntity.itemHandler.getStackInSlot(6).getCount() + outputs.get(4).getCount() &&
                                (pEntity.itemHandler.getStackInSlot(6).getItem().equals(outputs.get(4).getItem()) || pEntity.itemHandler.getStackInSlot(6).isEmpty())))
                ) {
                    //Comment for slot 0
                    pEntity.itemHandler.extractItem(0, 1, false);
                    ItemStack empty = new ItemStack(ModItems.EMPTY.get(), 1);
                    for (ItemStack output : outputs) {
                            if (output.getItem() == outputs.get(0).getItem()) {
                                if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(2).isEmpty()) {
                                    if (pEntity.itemHandler.getStackInSlot(2).isEmpty()) {
                                        pEntity.itemHandler.setStackInSlot(2, output.copy());
                                        //vvv Need to make sure it doesn't go past max stack size
                                    } else if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(2).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(2).getCount() + output.getCount()) {
                                        pEntity.itemHandler.getStackInSlot(2).grow(output.getCount());
                                    }
                                }
                            } else if (output.getItem() == outputs.get(1).getItem() && outputs.size() >= 2 && output.getItem() != empty.getItem()) {
                                if (pEntity.itemHandler.getStackInSlot(3).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(3).isEmpty()) {
                                    if (pEntity.itemHandler.getStackInSlot(3).isEmpty()) {
                                        pEntity.itemHandler.setStackInSlot(3, output.copy());
                                        //vvv Need to make sure it doesn't go past max stack size
                                    } else if (pEntity.itemHandler.getStackInSlot(3).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(3).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(3).getCount() + output.getCount()) {
                                        pEntity.itemHandler.getStackInSlot(3).grow(output.getCount());
                                    }
                                }
                            } else if (output.getItem() == outputs.get(2).getItem() && outputs.size() >= 3 && output.getItem() != empty.getItem()) {
                                if (pEntity.itemHandler.getStackInSlot(4).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(4).isEmpty()) {
                                    if (pEntity.itemHandler.getStackInSlot(4).isEmpty()) {
                                        pEntity.itemHandler.setStackInSlot(4, output.copy());
                                        //vvv Need to make sure it doesn't go past max stack size
                                    } else if (pEntity.itemHandler.getStackInSlot(4).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(4).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(4).getCount() + output.getCount()) {
                                        pEntity.itemHandler.getStackInSlot(4).grow(output.getCount());
                                    }
                                }
                            }
                            //Trace Items
                            else if (output.getItem() == outputs.get(3).getItem() && outputs.size() >= 4) {
                                int x = (int) (Math.random()*1000);
                                if(x % 10 == 0) {
                                    if (pEntity.itemHandler.getStackInSlot(5).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(5).isEmpty()) {
                                        if (pEntity.itemHandler.getStackInSlot(5).isEmpty()) {
                                            pEntity.itemHandler.setStackInSlot(5, output.copy());
                                            //vvv Need to make sure it doesn't go past max stack size
                                        } else if (pEntity.itemHandler.getStackInSlot(5).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(5).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(5).getCount() + output.getCount()) {
                                            pEntity.itemHandler.getStackInSlot(5).grow(output.getCount());
                                        }
                                    }
                                }
                            } else if (output.getItem() == outputs.get(4).getItem() && outputs.size() >= 5) {
                                int x = (int) (Math.random()*1000);
                                if(x % 10 == 0) {
                                    if (pEntity.itemHandler.getStackInSlot(6).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(6).isEmpty()) {
                                        if (pEntity.itemHandler.getStackInSlot(6).isEmpty()) {
                                            pEntity.itemHandler.setStackInSlot(6, output.copy());
                                            //vvv Need to make sure it doesn't go past max stack size
                                        } else if (pEntity.itemHandler.getStackInSlot(6).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(6).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(6).getCount() + output.getCount()) {
                                            pEntity.itemHandler.getStackInSlot(6).grow(output.getCount());
                                        }
                                    }
                                }
                            }
                    }
                } else pEntity.resetProgress();
            });

            pEntity.resetProgress();
        }
    }


    private static boolean hasRecipe(DeconstructorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        //recipe
        Optional<DeconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(DeconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() &&
                //canInsertAmountIntoOutputSlot(inventory) &&
                rightIngredientsPresent(inventory, recipe.get().getIngredients()) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getOutput());
    }

    //TODO: This may be where I can put if statements to hinder the deconstruction process.
    //Has recipe method uses this as part of its output, so it must be.
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, NonNullList<ItemStack> stack) {
        return inventory.getItem(2).getItem() == stack.get(0).getItem() || inventory.getItem(2).isEmpty() && inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount() + stack.get(0).getCount();
        //else if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(2).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(2).getCount() + output.getCount()) {
        //Practice
        //Need to figure out how to do multiple outputs
        // return (inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty()) && (inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty()) ;
    }
    private static boolean rightIngredientsPresent(SimpleContainer inventory, NonNullList<Ingredient> stack) {
        int check = 0;
        for(int i = 0; i < stack.size(); i++)
        {
            ItemStack empty = new ItemStack(ModItems.EMPTY.get(), 1);
            //adjust this for loop for the number of outputs. For deconstructor: size = 7, but only 1 of those is an ingredient so -6
            for(int s = 0; s < inventory.getContainerSize()-6; s++)
            {
                if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem() || (stack.get(i).getItems()[0].getItem() == empty.getItem() && inventory.getItem(i).isEmpty()))
                {
                    check++;
                }
            }
        }
        return check == stack.size();
    }

    private static int getFreeOutputSlot(ItemStackHandler itemHandler) {
        int freeslots = 0;
        for (int i = 2; i < itemHandler.getSlots(); i++) {
            ItemStack itemStack = itemHandler.getStackInSlot(i);
            if (itemStack.isEmpty() || itemStack.getCount() < itemStack.getMaxStackSize()) {
                return i;
            }
        }
        return 1;
    }


    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}