package net.claudio.chemmod.networking;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.networking.packet.ExampleC2SPacket;
import net.claudio.chemmod.networking.packet.RadiationC2SPacket;
import net.claudio.chemmod.networking.packet.RadiationS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;
    private static int id()
    {
        return packetID++;
    }

    public static void register()
    {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(ChemMod.MOD_ID, "messages"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

        INSTANCE = net;

        //put in packets


        //EXAMPLE EXAMPLE EXAMPLE
        net.messageBuilder(RadiationC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RadiationC2SPacket::new)
                .encoder(RadiationC2SPacket::toBytes)
                .consumerMainThread(RadiationC2SPacket::handle)
                .add();


        net.messageBuilder(RadiationS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(RadiationS2CPacket::new)
                .encoder(RadiationS2CPacket::toBytes)
                .consumerMainThread(RadiationS2CPacket::handle)
                .add();


    }

    public static <MSG> void sendToServer(MSG message)

    {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
