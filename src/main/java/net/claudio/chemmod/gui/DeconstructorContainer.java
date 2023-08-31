package net.claudio.chemmod.gui;

import java.awt.*;
/*
public class DeconstructorContainer extends Container {

    public HandheldDestructorContainer(int windowId, PlayerInventory playerInventory) {
        super(YourContainerType, windowId);

        // Input slot
        this.addSlot(new Slot(yourInputItemHandler, 0, xInputSlot, yInputSlot));

        // Output slots
        int xOutputSlot = ...; // Calculate the position of the first output slot
        int yOutputSlot = ...; // Calculate the position of the first output slot
        for (int i = 0; i < yourOutputItemHandler.getSlots(); i++) {
            this.addSlot(new Slot(yourOutputItemHandler, i + 1, xOutputSlot + (i * slotSize), yOutputSlot));
        }

        // Player inventory slots
        int playerInventoryStartX = ...; // Calculate the position of the player inventory slots
        int playerInventoryStartY = ...; // Calculate the position of the player inventory slots
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int index = col + row * 9 + 9;
                int x = playerInventoryStartX + col * slotSize;
                int y = playerInventoryStartY + row * slotSize;
                this.addSlot(new Slot(playerInventory, index, x, y));
            }
        }

        // Player hotbar slots
        int playerHotbarY = ...; // Calculate the position of the player hotbar slots
        for (int col = 0; col < 9; col++) {
            int x = playerInventoryStartX + col * slotSize;
            this.addSlot(new Slot(playerInventory, col, x, playerHotbarY));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}

 */
