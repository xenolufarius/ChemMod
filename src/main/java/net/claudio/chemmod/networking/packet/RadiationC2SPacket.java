package net.claudio.chemmod.networking.packet;

import com.mojang.authlib.minecraft.TelemetrySession;
import net.claudio.chemmod.client.ClientRadiationData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.Random;
import java.util.function.Supplier;

//FOR REFERENCE ONLY
public class RadiationC2SPacket {

    public static final String MESSAGE_WELL_1 = "message.chemmod.mw1";
    public static final String MESSAGE_WELL_2 = "message.chemmod.mw2";
    public static final String MESSAGE_WELL_3 = "message.chemmod.mw3";
    public static final String MESSAGE_WELL_4 = "message.chemmod.mw4";
    public static final String MESSAGE_WELL_5 = "message.chemmod.mw5";
    public static final String MESSAGE_UNWELL_1 = "message.chemmod.muw1";
    public static final String MESSAGE_UNWELL_2 = "message.chemmod.muw2";
    public static final String MESSAGE_UNWELL_3 = "message.chemmod.muw3";
    public static final String MESSAGE_UNWELL_4 = "message.chemmod.muw4";

    public static final String MESSAGE_UNWELL_5 = "message.chemmod.muw5";


    public RadiationC2SPacket() {

    }

    public RadiationC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }



    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            Random random = new Random();


            //Not too bad if it doesn't work
            //Says random message on general well being
            if(ClientRadiationData.getPlayerRads() == 0)
            {
                int min = 1;
                int max = 5;
                int ran = random.nextInt(max - min + 1) + min;

                switch (ran)
                {
                    case 1:
                        player.sendSystemMessage(Component.translatable(MESSAGE_WELL_1).withStyle(ChatFormatting.YELLOW));
                        break;
                    case 2:
                        player.sendSystemMessage(Component.translatable(MESSAGE_WELL_2).withStyle(ChatFormatting.YELLOW));
                        break;
                    case 3:
                        player.sendSystemMessage(Component.translatable(MESSAGE_WELL_3).withStyle(ChatFormatting.YELLOW));
                        break;
                    case 4:
                        player.sendSystemMessage(Component.translatable(MESSAGE_WELL_4).withStyle(ChatFormatting.YELLOW));
                        break;
                    case 5:
                        player.sendSystemMessage(Component.translatable(MESSAGE_WELL_5).withStyle(ChatFormatting.YELLOW));
                        break;
                    default:
                        player.sendSystemMessage(Component.literal("Hey").withStyle(ChatFormatting.YELLOW));
                }

            }
            else if (ClientRadiationData.getPlayerRads() < 10 && ClientRadiationData.getPlayerRads() > 0)
            {
                int min = 1;
                int max = 5;
                int ran = random.nextInt(max - min + 1) + min;

                switch (ran)
                {
                    case 1:
                        player.sendSystemMessage(Component.translatable(MESSAGE_UNWELL_1).withStyle(ChatFormatting.GREEN));
                        break;
                    case 2:
                        player.sendSystemMessage(Component.translatable(MESSAGE_UNWELL_2).withStyle(ChatFormatting.GREEN));
                        break;
                    case 3:
                        player.sendSystemMessage(Component.translatable(MESSAGE_UNWELL_3).withStyle(ChatFormatting.GREEN));
                        break;
                    case 4:
                        player.sendSystemMessage(Component.translatable(MESSAGE_UNWELL_4).withStyle(ChatFormatting.GREEN));
                        break;
                    case 5:
                        player.sendSystemMessage(Component.translatable(MESSAGE_UNWELL_5).withStyle(ChatFormatting.GREEN));
                        break;
                    default:
                        player.sendSystemMessage(Component.literal("Ugh").withStyle(ChatFormatting.GREEN));
                }
            }
            else if (ClientRadiationData.getPlayerRads() == 10)
            {
                player.sendSystemMessage(Component.literal("Oh no").withStyle(ChatFormatting.DARK_RED));
            }
            //Can change depending on how much radiation has been absorbed
        });
        return true;
    }

}