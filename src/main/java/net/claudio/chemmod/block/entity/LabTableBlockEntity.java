package net.claudio.chemmod.block.entity;

import net.claudio.chemmod.recipe.LabTableBlockRecipe;
import net.claudio.chemmod.recipe.RadicalizerBlockRecipe;
import net.claudio.chemmod.screen.LabTableBlockMenu;
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
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LabTableBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(14) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public LabTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAB_TABLE_BLOCK.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> LabTableBlockEntity.this.progress;
                    case 1 -> LabTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> LabTableBlockEntity.this.progress = value;
                    case 1 -> LabTableBlockEntity.this.maxProgress = value;
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
        return Component.literal("Lab Table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new LabTableBlockMenu(id, inventory, this, this.data);
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
        nbt.putInt("lab_table.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("lab_table.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LabTableBlockEntity pEntity) {
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

    private static void craftItem(LabTableBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<LabTableBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(LabTableBlockRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(pEntity)) {
            recipe.ifPresent(labtableBlockRecipe -> {
                ItemStack input1 = labtableBlockRecipe.getIngredients().get(0).getItems()[0];
                ItemStack input2 = labtableBlockRecipe.getIngredients().get(1).getItems()[0];
                int slots = labtableBlockRecipe.getIngredients().size();

                //TODO: SOLVE MULTIPLE INPUTS ISSUE. Working now

                    NonNullList<ItemStack> outputs = labtableBlockRecipe.getOutput();
                    if (pEntity.itemHandler.getStackInSlot(13).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(13).getCount() + outputs.get(0).getCount()) {
                        //Comment for slot 0
                        for(int d = 0; d < slots; d++)
                        {
                            if(d == 0) {
                                pEntity.itemHandler.extractItem(d, 1, false);
                            }
                            if(d > 0) {
                                pEntity.itemHandler.extractItem(d, 1, false);
                            }
                        }
                        for (ItemStack output : outputs) {
                            if (output.getItem() == outputs.get(0).getItem()) {
                                if (pEntity.itemHandler.getStackInSlot(13).getItem() == output.getItem() || pEntity.itemHandler.getStackInSlot(13).isEmpty()) {
                                    if (pEntity.itemHandler.getStackInSlot(13).isEmpty()) {
                                        pEntity.itemHandler.setStackInSlot(13, output.copy());
                                        //vvv Need to make sure it doesn't go past max stack size
                                    } else if (pEntity.itemHandler.getStackInSlot(13).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(13).getMaxStackSize() + 1 > pEntity.itemHandler.getStackInSlot(13).getCount() + output.getCount()) {
                                        pEntity.itemHandler.getStackInSlot(13).grow(output.getCount());
                                    }
                                }
                            }
                        }
                    } else pEntity.resetProgress();
            });

            pEntity.resetProgress();
        }
    }


    private static boolean hasRecipe(LabTableBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        //recipe
        Optional<LabTableBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(LabTableBlockRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() &&
                //canInsertAmountIntoOutputSlot(inventory) &&
                rightIngredientsPresent(inventory, recipe.get().getIngredients()) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getOutput());
    }

    //TODO: This may be where I can put if statements to hinder the deconstruction process.
    //Has recipe method uses this as part of its output, so it must be.
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, NonNullList<ItemStack> stack) {
        return inventory.getItem(13).getItem() == stack.get(0).getItem() || inventory.getItem(13).isEmpty() && inventory.getItem(13).getMaxStackSize() > inventory.getItem(13).getCount() + stack.get(0).getCount();
        //else if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(2).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(2).getCount() + output.getCount()) {
        //Practice
        //Need to figure out how to do multiple outputs
        // return (inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty()) && (inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty()) ;
    }
    private static boolean rightIngredientsPresent(SimpleContainer inventory, NonNullList<Ingredient> stack) {
        int check = 0;
        for(int i = 0; i < stack.size(); i++)
        {
            //adjust this for loop for the number of outputs. For lab table: size = 14, but the last slot is an output so -1
            for(int s = 0; s < inventory.getContainerSize()-1; s++)
            {

                if(stack.get(i).getItems()[0].getCount() == 0)
                {
                    if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem())
                    {
                        check++;
                    }
                }
                if(stack.get(i).getItems()[0].getCount() == 1)
                {
                    //TODO: RESOLVE CHECKING STEPS
                    if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem()
                         //   && (s == 1 || s == 2 || s == 3 || s == 4)
                    )
                    {
                        check++;
                    }
                }
                if(stack.get(i).getItems()[0].getCount() == 2)
                {
                    if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem() && s <= 8 && s >= 5)
                    {
                        check++;
                    }
                }
                if(stack.get(i).getItems()[0].getCount() == 3)
                {
                    if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem() && s <= 12 && s >= 9)
                    {
                        check++;
                    }
                }



                /*
                if(inventory.getItem(s).getItem() == stack.get(i).getItems()[0].getItem())
                {
                    check++;
                }
                 */


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