package net.claudio.chemmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.networking.ModMessages;
import net.claudio.chemmod.networking.packet.RadiationS2CPacket;
import net.claudio.chemmod.radiation.PlayerRadiation;
import net.claudio.chemmod.radiation.PlayerRadiationProvider;
import net.claudio.chemmod.villager.ModVillagers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.BadRespawnPointDamage;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.crafting.conditions.ItemExistsCondition;
import net.minecraftforge.common.extensions.IForgeItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.Explosion;

import java.util.List;

@Mod.EventBusSubscriber(modid = ChemMod.MOD_ID)

public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.CLERIC)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.DECONSTRUCTOR.get(), 1);
            int villagerlevel = 1;

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CHEMICAL.get(), 3),
                    stack, 10, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.CHEMIST.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.DECONSTRUCTOR.get(), 1);
            int villagerlevel = 1;

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CHEMICAL.get(), 3),
                    stack, 10, 8, 0.02F));
                        //Max Uses,EXP for Villager,Multiplier for Price
        }

    }






    //Radiation Code
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerRadiationProvider.PLAYER_RADS).isPresent())
            {
                event.addCapability(new ResourceLocation(ChemMod.MOD_ID, "properties"), new PlayerRadiationProvider());
            }
        }
    }


    //For when players die. They retain the rad cap
    /*
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerRadiationProvider.PLAYER_RADS).ifPresent(oldStore ->
            {
                event.getOriginal().getCapability(PlayerRadiationProvider.PLAYER_RADS).ifPresent(newStore ->
                {
                    newStore.copyfrom(oldStore);
                });
            });
        }
    }
    */


    //Just for registration
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerRadiation.class);
    }

    //Decrease Rads as time goes on.
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER)
        {
            event.player.getCapability(PlayerRadiationProvider.PLAYER_RADS).ifPresent(radiation ->
            {
                //event.player.getRandom().nextFloat() < 0.005f
                if(radiation.getRads() > 0 && event.player.tickCount % 400 == 0)
                { // Once Every 20 Seconds on Avg
                    radiation.subRads(1);
                    ModMessages.sendToPlayer(new RadiationS2CPacket(radiation.getRads()), ((ServerPlayer) event.player));
                }
                if (event.player.tickCount % 2 == 0)
                {
                    ModMessages.sendToPlayer(new RadiationS2CPacket(radiation.getRads()), ((ServerPlayer) event.player));

                }
            });
        }
    }

    //Test for detecting rads
    @SubscribeEvent
    public static void detectRadiationNearPlayer(TickEvent.PlayerTickEvent event)
    {
        if(event.side == LogicalSide.SERVER)
        {
            event.player.getCapability(PlayerRadiationProvider.PLAYER_RADS).ifPresent(radiation ->
            {
                //event.player.getRandom().nextFloat() < 0.005f
                if(radiation.getRads() <= 10 && radioactiveItemDetectedInInventory(event.player) > 0 && event.player.tickCount % 50 == 0)
                {
                    if(radioactiveItemDetectedInInventory(event.player) == 4)
                    {
                        radiation.addRads((radioactiveItemDetectedInInventory(event.player)*5));
                    }
                    radiation.addRads((radioactiveItemDetectedInInventory(event.player)));
                }
                if(radiation.getRads() < 10 && radioactiveItemDetectedOnGround(event.player) > 0 && event.player.tickCount % 50 == 0)
                {
                    //Plan on using this for on ground items. But for now it will be empty
                }
                if(radiation.getRads() == 10 && event.player.tickCount % 10 == 0) {
                    if (radioactiveItemDetectedInInventory(event.player) != 4) {
                        //poison
                        event.player.hurt(DamageSource.WITHER, (float) (radioactiveItemDetectedInInventory(event.player) * radioactiveItemDetectedInInventory(event.player)) / 2 + 1);

                    }
                    else
                    {
                        event.player.hurt(DamageSource.WITHER, 30);
                    }
                }
            });
        }
    }


    //I need to fix this IT WORKS! Just too well lmao
    //Now returns the highest radiation number, rather than just the first it finds
    public static int radioactiveItemDetectedInInventory(Player player)
    {
        int largestRAD = 0;
        int tempRAD = 0;
        for(ItemStack stack : player.inventoryMenu.getItems())
        {

            //If needed
            //ForgeRegistries.ITEMS.getKey(stack.getItem()).getNamespace().equals("chemmod")
            if(!stack.isEmpty() && stack.getItem().getClass() == ChemicalItem.class)
            {
                ChemicalItem chemicalItem = (ChemicalItem) stack.getItem();
                tempRAD = chemicalItem.getcRAD();
                if(tempRAD > largestRAD)
                {
                    largestRAD = chemicalItem.getcRAD();
                }
            }
        }
        return largestRAD;
    }

    //detecting stability of items in player inventory.
    //Just copied over rad code. Need to adjust.
    public static int itemStabilityDetectedInInventory(Player player)
    {
        int smallestSTAB = 4;
        int tempSTAB = 0;
        for(ItemStack stack : player.inventoryMenu.getItems())
        {

            //If needed
            //ForgeRegistries.ITEMS.getKey(stack.getItem()).getNamespace().equals("chemmod")
            if(!stack.isEmpty() && stack.getItem().getClass() == ChemicalItem.class)
            {
                ChemicalItem chemicalItem = (ChemicalItem) stack.getItem();
                tempSTAB = chemicalItem.getcSTAB();
                if(smallestSTAB > tempSTAB)
                {
                    smallestSTAB = chemicalItem.getcSTAB();
                }
                //potential if statement:
                if(chemicalItem.getcSTAB()<3)
                {
                    //do something
                    //maybe nested if for each , 1,2,0.
                }
            }

        }
        return smallestSTAB;
    }

    //Okay now I need a method to detect if a radioactive item is on the ground nearby the player
    //Maybe can't do a range just yet.

    public static int radioactiveItemDetectedOnGround(Player player)
    {

        return 0;
    }



    //TODO: Fix double activation. Static is necessary, and having int count hasn't worked so far.
    @SubscribeEvent
    public static void onLivingEntityFinishUseItem(LivingEntityUseItemEvent.Finish event)
    {
        if(event.getEntity() instanceof Player player)
        {
            if(event.getItem().getItem().getClass() == ChemicalItem.class)
            {

                ChemicalItem chemicalItem = (ChemicalItem) event.getItem().getItem();
                //Leftover if statement from int count
                if(true)
                {
                    //Kills player
                    if (chemicalItem.getcFOOD().equals("TOXIC")) {
                        player.hurt(DamageSource.GENERIC, 30);
                    }
                    //Blows up player
                    if (chemicalItem.getcFOOD().equals("EXP")) {

                        player.level.explode(player, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator)null, player.getX(), player.getY(), player.getZ(), 3.0f,false, Explosion.BlockInteraction.DESTROY);
                        player.hurt(DamageSource.explosion(new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(),3.0f)), 20);

                    }
                    //Can add others
                }
            }
        }
    }


    //ItemSupplier

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerRadiationProvider.PLAYER_RADS).ifPresent(radiation -> {
                    ModMessages.sendToPlayer(new RadiationS2CPacket(radiation.getRads()), player);
                });
            }
        }


    }










//END OF CODE
}
