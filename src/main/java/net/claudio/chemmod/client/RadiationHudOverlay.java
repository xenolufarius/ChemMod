package net.claudio.chemmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.claudio.chemmod.ChemMod;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class RadiationHudOverlay
{
    private static final ResourceLocation FILLED_RADS = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/radiation_indicator.png");
    private static final ResourceLocation EMPTY_RADS = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/empty_rads.png");

    private static final ResourceLocation RAD_1 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_1.png");
    private static final ResourceLocation RAD_2 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_2.png");
    private static final ResourceLocation RAD_3 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_3.png");
    private static final ResourceLocation RAD_4 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_4.png");
    private static final ResourceLocation RAD_5 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_5.png");
    private static final ResourceLocation RAD_6 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_6.png");
    private static final ResourceLocation RAD_7 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_7.png");
    private static final ResourceLocation RAD_8 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_8.png");
    private static final ResourceLocation RAD_9 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_9.png");
    private static final ResourceLocation RAD_10 = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/rad_state_10.png");



    public static final IGuiOverlay HUD_RADS = ((gui, poseStack, partialTick, width, height) ->
    {
       //Will get rendered
        int x = width / 2;
        int y = height;


        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        /*
        RenderSystem.setShaderTexture(0, EMPTY_RADS);
        //empty
        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack,x - 94 + (i * 9), y - 54,0,0,12,12,
                    12,12);
        }


         */
        //filled
        RenderSystem.setShaderTexture(0, RAD_1);
            if(ClientRadiationData.getPlayerRads() > 0) {
                GuiComponent.blit(poseStack,x - 92 + (0 * 9),y - 59,0,0,12,12,
                        12,12);
            }

        RenderSystem.setShaderTexture(0, RAD_2);
        if(ClientRadiationData.getPlayerRads() > 1) {
            GuiComponent.blit(poseStack,x - 92 + (1 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_3);
        if(ClientRadiationData.getPlayerRads() > 2) {
            GuiComponent.blit(poseStack,x - 92 + (2 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_4);
        if(ClientRadiationData.getPlayerRads() > 3) {
            GuiComponent.blit(poseStack,x - 92 + (3 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_5);
        if(ClientRadiationData.getPlayerRads() > 4) {
            GuiComponent.blit(poseStack,x - 92 + (4 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_6);
        if(ClientRadiationData.getPlayerRads() > 5) {
            GuiComponent.blit(poseStack,x - 92 + (5 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_7);
        if(ClientRadiationData.getPlayerRads() > 6) {
            GuiComponent.blit(poseStack,x - 92 + (6 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_8);
        if(ClientRadiationData.getPlayerRads() > 7) {
            GuiComponent.blit(poseStack,x - 92 + (7 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_9);
        if(ClientRadiationData.getPlayerRads() > 8) {
            GuiComponent.blit(poseStack,x - 92 + (8 * 8),y - 59,0,0,12,12,
                    12,12);
        }
        RenderSystem.setShaderTexture(0, RAD_10);
        if(ClientRadiationData.getPlayerRads() > 9) {
            GuiComponent.blit(poseStack,x - 92 + (9 * 8),y - 59,0,0,12,12,
                    12,12);
        }


    });



}
