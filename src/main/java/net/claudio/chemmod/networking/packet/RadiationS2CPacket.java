package net.claudio.chemmod.networking.packet;

import net.claudio.chemmod.client.ClientRadiationData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

//FOR REFERENCE ONLY
public class RadiationS2CPacket {

    private final int rads;
    public RadiationS2CPacket(int rads) {
        this.rads = rads;
    }

    public RadiationS2CPacket(FriendlyByteBuf buf) {
        this.rads = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(rads);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientRadiationData.set(rads);
        });
        return true;
    }

}