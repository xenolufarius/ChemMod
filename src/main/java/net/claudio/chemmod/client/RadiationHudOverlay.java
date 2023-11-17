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
            "textures/radiation/filled_rads.png");
    private static final ResourceLocation EMPTY_RADS = new ResourceLocation(ChemMod.MOD_ID,
            "textures/radiation/empty_rads.png");

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
        RenderSystem.setShaderTexture(0, FILLED_RADS);

        for(int i = 0; i < 10; i++)
        {
            if(ClientRadiationData.getPlayerRads() > i) {
                GuiComponent.blit(poseStack,x - 94 + (i * 9),y - 54,0,0,12,12,
                        12,12);
            } else {
                break;
            }
        }


    });



}
