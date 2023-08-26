package net.claudio.chemmod.event;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.client.RadiationHudOverlay;
import net.claudio.chemmod.networking.ModMessages;
import net.claudio.chemmod.networking.packet.ExampleC2SPacket;
import net.claudio.chemmod.networking.packet.RadiationC2SPacket;
import net.claudio.chemmod.networking.packet.RadiationS2CPacket;
import net.claudio.chemmod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ChemMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){

        if(KeyBinding.STATUS_KEY.consumeClick()) {

            //THIS TO SEND PACKET INSTEAD OF SYSTEM MESSAGE DIRECTLY
            ModMessages.sendToServer(new RadiationC2SPacket());
            //ModMessages.sendToServer(new RadiationC2SPacket());
        }
        }

    }

    @Mod.EventBusSubscriber(modid = ChemMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.STATUS_KEY);
        }


        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("rads", RadiationHudOverlay.HUD_RADS);
        }


    }


}
