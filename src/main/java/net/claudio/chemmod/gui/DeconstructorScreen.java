package net.claudio.chemmod.gui;

import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;

public class DeconstructorScreen  extends ContainerScreen {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("your_mod:textures/gui/handheld_destructor.png");


    public DeconstructorScreen(ChestMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    /*
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
        blit(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

     */
}
