package net.claudio.chemmod.block.entity;

import net.claudio.chemmod.recipe.RadicalizerBlockRecipe;
import net.claudio.chemmod.screen.RadicalizerBlockMenu;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RadicalizerBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public RadicalizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RADICALIZER_BLOCK.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RadicalizerBlockEntity.this.progress;
                    case 1 -> RadicalizerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> RadicalizerBlockEntity.this.progress = value;
                    case 1 -> RadicalizerBlockEntity.this.maxProgress = value;
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
        return Component.literal("Radicalizer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new RadicalizerBlockMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
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
        nbt.putInt("radicalizer.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("radicalizer.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, RadicalizerBlockEntity pEntity) {
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
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(RadicalizerBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<RadicalizerBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(RadicalizerBlockRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(pEntity)) {
            recipe.ifPresent(radicalizerBlockRecipe -> {
                ItemStack input1 = radicalizerBlockRecipe.getIngredients().get(0).getItems()[0];
                ItemStack input2 = radicalizerBlockRecipe.getIngredients().get(1).getItems()[0];

                /*
                if(inputs[0] == pEntity.itemHandler.getStackInSlot(0) && inputs[1] == pEntity.itemHandler.getStackInSlot(1))
                {

                }
                */
                //TODO: SOLVE MULTIPLE INPUTS ISSUE. Working now
                if (input1.getItem() == pEntity.itemHandler.getStackInSlot(0).getItem() && input2.getItem() == pEntity.itemHandler.getStackInSlot(1).getItem()){


                    NonNullList<ItemStack> outputs = radicalizerBlockRecipe.getOutput();
                    if (pEntity.itemHandler.getStackInSlot(2).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(2).getCount() + outputs.get(0).getCount()) {
                        //Comment for slot 0
                        pEntity.itemHandler.extractItem(0, 1, false);
                        pEntity.itemHandler.extractItem(1, 1, false);
                        for (ItemStack output : outputs) {
                            if (output.getItem() == outputs.get(0).getItem()) {
                                if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(2).isEmpty()) {
                                    if (pEntity.itemHandler.getStackInSlot(2).isEmpty()) {
                                        pEntity.itemHandler.setStackInSlot(2, output.copy());
                                        //vvv Need to make sure it doesn't go past max stack size
                                    } else if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(2).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(2).getCount() + output.getCount()) {
                                        pEntity.itemHandler.getStackInSlot(2).grow(output.getCount());
                                    }
                                }
                            }
                        }
                    } else pEntity.resetProgress();
                }else pEntity.resetProgress();
            });

            pEntity.resetProgress();
        }
    }


    private static boolean hasRecipe(RadicalizerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        //recipe
        Optional<RadicalizerBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(RadicalizerBlockRecipe.Type.INSTANCE, inventory, level);

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
            //adjust this for loop for the number of outputs. For radicalizer: size = 3, but 2 of those are ingredients so -1
            for(int s = 0; s < inventory.getContainerSize()-1; s++)
            {
                if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem())
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