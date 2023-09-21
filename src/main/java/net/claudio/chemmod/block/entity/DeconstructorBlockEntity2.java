package net.claudio.chemmod.block.entity;
/*
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
import net.minecraft.world.item.ItemStack;
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

public class DeconstructorBlockEntity2 extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public DeconstructorBlockEntity2(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DECONSTRUCTOR_BLOCK.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> DeconstructorBlockEntity2.this.progress;
                    case 1 -> DeconstructorBlockEntity2.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> DeconstructorBlockEntity2.this.progress = value;
                    case 1 -> DeconstructorBlockEntity2.this.maxProgress = value;
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

    public static void tick(Level level, BlockPos pos, BlockState state, DeconstructorBlockEntity2 pEntity) {
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

    private static void craftItem(DeconstructorBlockEntity2 pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<DeconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(DeconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(pEntity)) {
            recipe.ifPresent(deconstructorBlockRecipe -> {
                NonNullList<ItemStack> outputs = deconstructorBlockRecipe.getOutput();
                for (ItemStack output : outputs) {
                    int slot = getFreeOutputSlot(pEntity.itemHandler);
                    if (slot != -1) {
                        ItemStack currentOutputStack = pEntity.itemHandler.getStackInSlot(slot);
                        if (currentOutputStack.isEmpty()) {
                            pEntity.itemHandler.setStackInSlot(slot, output.copy());
                        } else if (currentOutputStack.getItem() == output.getItem()) {
                            currentOutputStack.grow(output.getCount());
                        }
                    }
                }
            });

            pEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(DeconstructorBlockEntity2 entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<DeconstructorBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(DeconstructorBlockRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(entity.itemHandler) &&
                canInsertItemIntoOutputSlot(entity.itemHandler, recipe.get().getOutput());
    }

    private static boolean canInsertItemIntoOutputSlot(ItemStackHandler itemHandler, NonNullList<ItemStack> outputs) {
        for (ItemStack output : outputs) {
            int slot = getFreeOutputSlot(itemHandler);
            if (slot != -1) {
                ItemStack currentOutputStack = itemHandler.getStackInSlot(slot);
                if (currentOutputStack.isEmpty() || currentOutputStack.getItem() == output.getItem()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getFreeOutputSlot(ItemStackHandler itemHandler) {
        for (int i = 2; i < itemHandler.getSlots(); i++) {
            ItemStack itemStack = itemHandler.getStackInSlot(i);
            if (itemStack.isEmpty() || itemStack.getCount() < itemStack.getMaxStackSize()) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canInsertAmountIntoOutputSlot(ItemStackHandler itemHandler) {
        for (int i = 2; i < itemHandler.getSlots(); i++) {
            ItemStack itemStack = itemHandler.getStackInSlot(i);
            if (itemStack.getCount() < itemStack.getMaxStackSize()) {
                return true;
            }
        }
        return false;
    }
}

 */