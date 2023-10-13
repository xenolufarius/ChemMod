package net.claudio.chemmod.screen;


import net.claudio.chemmod.block.ModBlocks;
import net.claudio.chemmod.block.entity.ReconstructorBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ReconstructorBlockMenu extends AbstractContainerMenu {
    public final ReconstructorBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public ReconstructorBlockMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        //Maybe 2
        this(id, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public ReconstructorBlockMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.RECONSTRUCTOR_BLOCK_MENU.get(), id);
        //?? Maybe need to adjust? 3
        checkContainerSize(inv, 26);
        blockEntity = (ReconstructorBlockEntity) entity;
        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 12, 10));
            this.addSlot(new SlotItemHandler(handler, 1, 32, 10));
            this.addSlot(new SlotItemHandler(handler, 2, 52, 10));
            this.addSlot(new SlotItemHandler(handler, 3, 72, 10));
            this.addSlot(new SlotItemHandler(handler, 4, 92, 10));

            this.addSlot(new SlotItemHandler(handler, 5, 12, 25));
            this.addSlot(new SlotItemHandler(handler, 6, 32, 25));
            this.addSlot(new SlotItemHandler(handler, 7, 52, 25));
            this.addSlot(new SlotItemHandler(handler, 8, 72, 25));
            this.addSlot(new SlotItemHandler(handler, 9, 92, 25));

            this.addSlot(new SlotItemHandler(handler, 10, 12, 40));
            this.addSlot(new SlotItemHandler(handler, 11, 32, 40));
            this.addSlot(new SlotItemHandler(handler, 12, 52, 40));
            this.addSlot(new SlotItemHandler(handler, 13, 72, 40));
            this.addSlot(new SlotItemHandler(handler, 14, 92, 40));

            this.addSlot(new SlotItemHandler(handler, 15, 12, 55));
            this.addSlot(new SlotItemHandler(handler, 16, 32, 55));
            this.addSlot(new SlotItemHandler(handler, 17, 52, 55));
            this.addSlot(new SlotItemHandler(handler, 18, 72, 55));
            this.addSlot(new SlotItemHandler(handler, 19, 92, 55));

            this.addSlot(new SlotItemHandler(handler, 20, 12, 70));
            this.addSlot(new SlotItemHandler(handler, 21, 32, 70));
            this.addSlot(new SlotItemHandler(handler, 22, 52, 70));
            this.addSlot(new SlotItemHandler(handler, 23, 72, 70));
            this.addSlot(new SlotItemHandler(handler, 24, 92, 70));

            this.addSlot(new SlotItemHandler(handler, 25, 112, 40));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 26; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 26;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.RECONSTRUCTOR_BLOCK.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}