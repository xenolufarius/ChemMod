package net.claudio.chemmod.block.entity;

import net.claudio.chemmod.item.ModCreativeModeTab;
import net.claudio.chemmod.recipe.RadicalizerBlockRecipe;
import net.claudio.chemmod.recipe.ReconstructorBlockRecipe;
import net.claudio.chemmod.screen.ReconstructorBlockMenu;
import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.item.custom.SolutionItem;
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
import net.minecraft.world.food.FoodProperties;
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

import java.awt.*;
import java.util.Optional;

public class ReconstructorBlockEntity extends BlockEntity implements MenuProvider {

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

    public ReconstructorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RECONSTRUCTOR_BLOCK.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ReconstructorBlockEntity.this.progress;
                    case 1 -> ReconstructorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ReconstructorBlockEntity.this.progress = value;
                    case 1 -> ReconstructorBlockEntity.this.maxProgress = value;
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
        return Component.literal("Reconstructor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new ReconstructorBlockMenu(id, inventory, this, this.data);
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
        nbt.putInt("reconstructor.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("reconstructor.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ReconstructorBlockEntity pEntity) {
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

    private static void craftItem(ReconstructorBlockEntity pEntity) {
        Level level = pEntity.level;

        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<ReconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ReconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(pEntity)) {
            recipe.ifPresent(ReconstructorBlockRecipe -> {
                //ItemStack input1 = ReconstructorBlockRecipe.getIngredients().get(0).getItems()[0];
                //ItemStack input2 = ReconstructorBlockRecipe.getIngredients().get(1).getItems()[0];
                ItemStack input1 = pEntity.itemHandler.getStackInSlot(1);
                ItemStack input2 = pEntity.itemHandler.getStackInSlot(0);
                /*
                if(inputs[0] == pEntity.itemHandler.getStackInSlot(0) && inputs[1] == pEntity.itemHandler.getStackInSlot(1))
                {

                }
                */
                //TODO: SOLVE MULTIPLE INPUTS ISSUE. Working now

                SolutionItem beaker = (SolutionItem) input1.getItem();
                ChemicalItem inputChemical = (ChemicalItem) input2.getItem();
                if ((!beaker.getcCHEM1().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM1().equals(inputChemical))&&
                        (!beaker.getcCHEM2().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM2().equals(inputChemical))&&
                        (!beaker.getcCHEM3().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM3().equals(inputChemical))&&
                        (!beaker.getcCHEM4().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM4().equals(inputChemical))&&
                        (!beaker.getcCHEM5().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM5().equals(inputChemical))&&
                        (!beaker.getcCHEM6().equals(ModItems.EMPTY.get()) && !beaker.getcCHEM6().equals(inputChemical)))
                    pEntity.resetProgress();
                    pEntity.itemHandler.extractItem(0, 1, false);
                    pEntity.itemHandler.extractItem(1, 1, false);




                    if ((input1.getItem().equals(ModItems.BEAKER.get())))
                    {
                        if (beaker.getcCHEM1().equals(ModItems.EMPTY.get()) || beaker.getcCHEM1().equals(inputChemical)){
                            beaker.setcCHEM1(inputChemical);
                            beaker.setcMCHEM1(beaker.getcMCHEM1()+1.00);
                        }
                        else if (beaker.getcCHEM2().equals((ModItems.EMPTY.get())) || beaker.getcCHEM2().equals(inputChemical))
                        {
                            beaker.setcCHEM2(inputChemical);
                            beaker.setcMCHEM2(beaker.getcMCHEM2()+1.00);
                        }
                        else if (beaker.getcCHEM3().equals((ModItems.EMPTY.get())) || beaker.getcCHEM3().equals(inputChemical))
                        {
                            beaker.setcCHEM3(inputChemical);
                            beaker.setcMCHEM3(beaker.getcMCHEM3()+1.00);
                        }
                        else if (beaker.getcCHEM4().equals((ModItems.EMPTY.get())) || beaker.getcCHEM4().equals(inputChemical))
                        {
                            beaker.setcCHEM4(inputChemical);
                            beaker.setcMCHEM4(beaker.getcMCHEM4()+1.00);
                        }
                        else if (beaker.getcCHEM5().equals((ModItems.EMPTY.get())) || beaker.getcCHEM5().equals(inputChemical))
                        {
                            beaker.setcCHEM5(inputChemical);
                            beaker.setcMCHEM5(beaker.getcMCHEM5()+1.00);
                        }
                        else if (beaker.getcCHEM6().equals((ModItems.EMPTY.get())) || beaker.getcCHEM6().equals(inputChemical))
                        {
                            beaker.setcCHEM6(inputChemical);
                            beaker.setcMCHEM6(beaker.getcMCHEM6()+1.00);
                        }
                    }
                    pEntity.itemHandler.setStackInSlot(2, new ItemStack(beaker
                            /*
                            new SolutionItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),beaker.getcVOL()
                    ,beaker.getcCHEM1(),beaker.getcMCHEM1(),beaker.getcCHEM2(),beaker.getcMCHEM2(),beaker.getcCHEM3(),beaker.getcMCHEM3()
                    ,beaker.getcCHEM4(),beaker.getcMCHEM4(),beaker.getcCHEM5(),beaker.getcMCHEM5(),beaker.getcCHEM6(),beaker.getcMCHEM6()
                    ,beaker.getcSTAB(),beaker.getcDESC(),beaker.getcSDS())
                    */
                    ));

            });

            pEntity.resetProgress();
        }
    }


    private static boolean hasRecipe(ReconstructorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        //recipe
        Optional<ReconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ReconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent()
                &&
                //canInsertAmountIntoOutputSlot(inventory) &&
                //rightIngredientsPresent(inventory, recipe.get().getIngredients()) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getOutput())
                ;
    }

    //TODO: This may be where I can put if statements to hinder the deconstruction process.
    //Has recipe method uses this as part of its output, so it must be.
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, NonNullList<ItemStack> stack) {
        return inventory.getItem(2).isEmpty();
        //return inventory.getItem(2).getItem() == stack.get(0).getItem() || inventory.getItem(2).isEmpty() && inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount() + stack.get(0).getCount();
        //else if (pEntity.itemHandler.getStackInSlot(2).getItem() == output.getItem() && pEntity.itemHandler.getStackInSlot(2).getMaxStackSize()+1 > pEntity.itemHandler.getStackInSlot(2).getCount() + output.getCount()) {
        //Practice
        //Need to figure out how to do multiple outputs
        // return (inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty()) && (inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty()) ;
    }
    private static boolean rightIngredientsPresent(SimpleContainer inventory, NonNullList<Ingredient> stack) {
        int check = 0;
        for(int i = 0; i < stack.size(); i++)
        {
            //adjust this for loop for the number of outputs. For Reconstructor: size = 3, but 2 of those are ingredients so -1
            for(int s = 0; s < inventory.getContainerSize()-1; s++)
            {
                if(inventory.getItem(s).getItem().getClass() == SolutionItem.class)
                {
                    check = check+10;
                }
                if(inventory.getItem(s).getItem().getClass() == ChemicalItem.class)
                {
                    check++;
                }
            }
        }
        return check == stack.size()+9;
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(25).getMaxStackSize() > inventory.getItem(25).getCount();
    }
}

