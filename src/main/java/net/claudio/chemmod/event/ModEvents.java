package net.claudio.chemmod.event;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.ModBlocks;
import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.networking.ModMessages;
import net.claudio.chemmod.networking.packet.RadiationS2CPacket;
import net.claudio.chemmod.radiation.PlayerRadiation;
import net.claudio.chemmod.radiation.PlayerRadiationProvider;
import net.claudio.chemmod.villager.ModVillagers;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.damagesource.BadRespawnPointDamage;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.block.Blocks;
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
import java.util.Map;

@Mod.EventBusSubscriber(modid = ChemMod.MOD_ID)

public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        /*
        if(event.getType() == VillagerProfession.CLERIC)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.DECONSTRUCTOR.get(), 1);
            int villagerlevel = 1;

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CHEMICAL.get(), 3),
                    stack, 10, 8, 0.02F));
        }

         */

        if(event.getType() == ModVillagers.CHEMIST.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            /*
            public static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> TRADES = Util.make(Maps.newHashMap(), (p_35633_) -> {
                        p_35633_.put(VillagerProfession.FARMER,
                                toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{new VillagerTrades.EmeraldForItems(Items.WHEAT, 20, 16, 2),
                                                new VillagerTrades.EmeraldForItems(Items.POTATO, 26, 16, 2),
                                                new VillagerTrades.EmeraldForItems(Items.CARROT, 22, 16, 2),
                                                new VillagerTrades.EmeraldForItems(Items.BEETROOT, 15, 16, 2),
                                                new VillagerTrades.ItemsForEmeralds(Items.BREAD, 1, 6, 16, 1)},
                                        2, new VillagerTrades.ItemListing[]{new VillagerTrades.EmeraldForItems(Blocks.PUMPKIN, 6, 12, 10), new VillagerTrades.ItemsForEmeralds(Items.PUMPKIN_PIE, 1, 4, 5), new VillagerTrades.ItemsForEmeralds(Items.APPLE, 1, 4, 16, 5)}, 3, new VillagerTrades.ItemListing[]{new VillagerTrades.ItemsForEmeralds(Items.COOKIE, 3, 18, 10), new VillagerTrades.EmeraldForItems(Blocks.MELON, 4, 12, 20)}, 4, new VillagerTrades.ItemListing[]{new VillagerTrades.ItemsForEmeralds(Blocks.CAKE, 1, 1, 12, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.NIGHT_VISION, 100, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.JUMP, 160, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.WEAKNESS, 140, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.BLINDNESS, 120, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.POISON, 280, 15), new VillagerTrades.SuspiciousStewForEmerald(MobEffects.SATURATION, 7, 15)}, 5, new VillagerTrades.ItemListing[]{new VillagerTrades.ItemsForEmeralds(Items.GOLDEN_CARROT, 3, 3, 30), new VillagerTrades.ItemsForEmeralds(Items.GLISTERING_MELON_SLICE, 4, 3, 30)})));
                    }
             */
                //For Result Items
            ItemStack deconstructor_block = new ItemStack(ModBlocks.DECONSTRUCTOR_BLOCK.get(), 1);
            ItemStack hydrogen_gas = new ItemStack(ModItems.HYDROGEN.get(), 2);
            ItemStack oxygen_gas = new ItemStack(ModItems.OXYGEN.get(), 1);
            ItemStack uranium = new ItemStack(ModItems.URANIUM.get(), 1);
            ItemStack nether_star = new ItemStack(Items.NETHER_STAR.asItem(), 1);

            int villagerlevel = 1;

            //TODO: Refine this trading list.
            //Novice
            //I guess can only have 2 trades at this level at a given time? Can I adjust this?
            //Don't know but adding numbers = higher level of villager
            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    hydrogen_gas, 3, 2, 0.02F));

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    oxygen_gas, 3, 2, 0.02F));

            //Apprentice
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    //Currency, Cost, stack = Result
                    new ItemStack(ModItems.WATER.get(), 6),
                    deconstructor_block, 2, 20, 0.02F));
                                    //Max Uses,EXP for Villager,Multiplier for Price
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 2),
                    oxygen_gas, 8, 8, 0.02F));
            //Journeyman
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 4),
                    uranium, 16, 30, 0.02F));
            //Expert
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 4),
                    uranium, 20, 40, 0.02F));
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 4),
                    uranium, 20, 40, 0.02F));
            //Master
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.URANIUM.get(), 4),
                    nether_star, 20, 40, 0.02F));
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.URANIUM.get(), 4),
                    nether_star, 20, 40, 0.02F));
        }

        if(event.getType() == ModVillagers.ALCHEMIST.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //For Result Items
            ItemStack deconstructor_block = new ItemStack(ModBlocks.DECONSTRUCTOR_BLOCK.get(), 1);
            ItemStack hydrogen_gas = new ItemStack(ModItems.HYDROGEN_GAS.get(), 8);
            ItemStack oxygen_gas = new ItemStack(ModItems.OXYGEN_GAS.get(), 2);
            ItemStack methane = new ItemStack(ModItems.METHANE.get(),1);
            ItemStack ethane = new ItemStack(ModItems.ETHANE.get(),1);
            ItemStack propane = new ItemStack(ModItems.PROPANE.get(),1);
            ItemStack ammonia = new ItemStack(ModItems.AMMONIA.get(),1);
            ItemStack sodium_chloride = new ItemStack(ModItems.SODIUM_CHLORIDE.get(),2);
            ItemStack water = new ItemStack(ModItems.WATER.get(),5);
            ItemStack sodium_carbonate = new ItemStack(ModItems.SODIUM_CARBONATE.get(),1);
            ItemStack nitrogen_gas = new ItemStack(ModItems.NITROGEN_GAS.get(),3);
            ItemStack uranium = new ItemStack(ModItems.URANIUM.get(), 1);
            ItemStack nether_star = new ItemStack(Items.NETHER_STAR.asItem(), 1);
            int villagerlevel = 1;

            //TODO: Refine this trading list.
            //TODO: Fix diatoms! Since I'm going to do realistic synthesis from now on, I want it to be correct.
            //Novice ~12xp
            //I guess can only have 2 trades at this level at a given time? Can I adjust this?
            //Don't know but adding numbers = higher level of villager
            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    hydrogen_gas, 6, 1, 0.02F));

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    oxygen_gas, 6, 1, 0.02F));

            //Apprentice ~64xp
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    //Currency, Cost, stack = Result
                    new ItemStack(ModItems.WATER.get(), 2),
                    methane, 7, 7, 0.02F));
            //Max Uses,EXP for Villager,Multiplier for Price
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.WATER.get(), 4),
                    ethane, 3, 8, 0.02F));

            //Journeyman ~80xp
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 1),
                    propane, 12, 3, 0.02F));
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CARBON_DIOXIDE.get(), 4),
                    nitrogen_gas, 9, 6, 0.02F));

            //Expert ~100xp
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.AMMONIA.get(), 2),
                    sodium_chloride, 5, 12, 0.02F));
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.AMMONIA.get(), 2),
                    water, 7, 8, 0.02F));

            //Master
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_CARBONATE.get(), 5),
                    deconstructor_block, 1, 20, 0.02F));
        }
        if(event.getType() == ModVillagers.ALCHEMIST_2.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //For Result Items
            ItemStack octasulfur = new ItemStack(ModItems.OCTASULFUR.get(), 1);
            ItemStack white_phosphorus = new ItemStack(ModItems.WHITE_PHOSPHORUS.get(), 2);
            ItemStack hydrogen_sulfide = new ItemStack(ModItems.HYDROGEN_SULFIDE.get(), 2);
            ItemStack sodium_hydroxide = new ItemStack(ModItems.SODIUM_HYDROXIDE.get(),2);
            ItemStack pyrite = new ItemStack(ModItems.PYRITE.get(),1);
            ItemStack hydrogen_peroxide = new ItemStack(ModItems.HYDROGEN_PEROXIDE.get(),2);
            ItemStack lithium_fluoride = new ItemStack(ModItems.LITHIUM_FLUORIDE.get(),3);
            ItemStack zinc = new ItemStack(ModItems.ZINC.get(),3);
            ItemStack lead_ii_iodate = new ItemStack(ModItems.LEAD_II_IODATE.get(),2);
            ItemStack _1_2_dichloroethane = new ItemStack(ModItems._1_2_DICHLOROETHANE.get(),1);
            ItemStack mercury = new ItemStack(ModItems.MERCURY.get(),5);
            int villagerlevel = 1;

            //TODO: Refine this trading list.
            //TODO: Fix diatoms! Since I'm going to do realistic synthesis from now on, I want it to be correct.
            //Novice ~12xp
            //I guess can only have 2 trades at this level at a given time? Can I adjust this?
            //Don't know but adding numbers = higher level of villager
            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 4),
                    octasulfur, 4, 2, 0.02F));

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SULFUR_DIOXIDE.get(), 2),
                    white_phosphorus, 4, 1, 0.02F));

            //Apprentice ~64xp
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    //Currency, Cost, stack = Result
                    new ItemStack(ModItems.HYDROGEN_SULFIDE.get(), 2),
                    sodium_hydroxide, 8, 4, 0.02F));
            //Max Uses,EXP for Villager,Multiplier for Price
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_II_SULFIDE.get(), 4),
                    pyrite, 7, 5, 0.02F));

            //Journeyman ~80xp
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_SULFIDE.get(), 1),
                    hydrogen_peroxide, 12, 3, 0.02F));
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_THIOSULFATE.get(), 2),
                    zinc, 9, 6, 0.02F));

            //Expert ~100xp
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.ZINC_SULFATE.get(), 1),
                    lead_ii_iodate, 5, 12, 0.02F));
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_SULFATE.get(), 1),
                    lithium_fluoride, 7, 8, 0.02F));

            //Master
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_HYDROSULFIDE.get(), 1),
                    _1_2_dichloroethane, 10, 10, 0.02F));
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EDT.get(), 1),
                    mercury, 10, 20, 0.02F));
        }
        if(event.getType() == ModVillagers.ALCHEMIST_3.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //For Result Items
            Potion potion = new Potion("healing", new MobEffectInstance(MobEffects.HEAL, 1, 1));
            ItemStack methanol = new ItemStack(ModItems.METHANOL.get(), 5);
            ItemStack tin = new ItemStack(ModItems.TIN.get(), 4);
            ItemStack potassium_chromate = new ItemStack(ModItems.POTASSIUM_CHROMATE.get(),2);
            ItemStack silver = new ItemStack(ModItems.SILVER.get(),10);
            ItemStack magnesium = new ItemStack(ModItems.MAGNESIUM.get(),5);
            ItemStack caesium_sulfide = new ItemStack(ModItems.CAESIUM_SULFIDE.get(),1);
            ItemStack aluminum = new ItemStack(ModItems.ALUMINUM.get(),10);
            ItemStack bromine = new ItemStack(ModItems.BROMINE_GAS.get(),5);
            ItemStack gold = new ItemStack(ModItems.GOLD.get(),9);
            ItemStack radicalizer_block = new ItemStack(ModBlocks.RADICALIZER_BLOCK.get(),1);
            int villagerlevel = 1;

            //TODO: Refine this trading list.
            //TODO: Fix diatoms! Since I'm going to do realistic synthesis from now on, I want it to be correct.
            //Novice ~12xp
            //I guess can only have 2 trades at this level at a given time? Can I adjust this?
            //Don't know but adding numbers = higher level of villager
            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.MERCURY_II_OXIDE.get(), 1),
                    methanol, 3, 1, 0.02F));

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.MERCURY_II_CHLORIDE.get(), 1),
                    tin, 9, 1, 0.02F));

            //Apprentice ~64xp
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    //Currency, Cost, stack = Result
                    new ItemStack(ModItems.MERCURY_II_SULFIDE.get(), 1),
                    potassium_chromate, 3, 8, 0.02F));
            //Max Uses,EXP for Villager,Multiplier for Price
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.MERCURY_II_SULFATE.get(), 1),
                    silver, 7, 7, 0.02F));

            //Journeyman ~80xp
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SILVER_OXIDE.get(), 1),
                    magnesium, 12, 3, 0.02F));
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SILVER_SULFIDE.get(), 1),
                    caesium_sulfide, 9, 6, 0.02F));

            //Expert ~100xp
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.NITRIC_ACID_DIL.get(), 1),
                    aluminum, 5, 12, 0.02F));
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.ALUMINUM_CHLORIDE.get(), 1),
                    bromine, 7, 8, 0.02F));

            //Master
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEAD.get(), 9),
                    gold, 10, 10, 0.02F));
            trades.get(villagerlevel+4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.ALUMINUM_BROMIDE.get(), 10),
                    radicalizer_block, 1, 40, 0.02F));
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
                //TODO: This is where stability code is ran
                if (event.player.tickCount % 200 == 0) {
                    itemStabilityDetectedInInventory(event.player);
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
    //TickEvent.PlayerTickEvent event
    public static void itemStabilityDetectedInInventory(Player player)
    {
        for(ItemStack stack : player.inventoryMenu.getItems())
        {
            int slot = 0;
            for(ItemStack stack1 : player.getInventory().items)
            {
                if (!stack.equals(stack1))
                {
                    slot++;

                }
                if(stack.equals(stack1))
                {
                    break;
                }
            }
            if(!stack.isEmpty() && stack.getItem().getClass() == ChemicalItem.class)
            {
                ChemicalItem chemicalItem = (ChemicalItem) stack.getItem();
                //potential if statement:
                if(chemicalItem.getcSTAB()<3)
                {
                    //do something
                    //maybe nested if for each , 1,2,0.
                    if(chemicalItem.getcSTAB() == 0)
                    {
                        stack = new ItemStack((Item)null);
                        player.getInventory().items.set(slot,stack);

                        //Need to send this back to Player inventory
                    }
                    if(chemicalItem.getcSTAB() == 1 || chemicalItem.getcSTAB() == 2)
                    {
                        //Craft the item into oxidized version / polyatoms from monoatoms
                        //Need to send this back to Player
                        if(chemicalItem.equals(ModItems.HYDROGEN.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.HYDROGEN_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.NITROGEN.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.NITROGEN_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.OXYGEN.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.OXYGEN_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.FLUORINE.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.FLUORINE_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.PHOSPHORUS.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.WHITE_PHOSPHORUS.get().asItem(), count/4);
                        }
                        if(chemicalItem.equals(ModItems.SULFUR.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.OCTASULFUR.get().asItem(), count/8);
                        }
                        if(chemicalItem.equals(ModItems.CHLORINE.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.CHLORINE_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.BROMINE.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.BROMINE_GAS.get().asItem(), count/2);
                        }
                        if(chemicalItem.equals(ModItems.IODINE.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.IODINE_GAS.get().asItem(), count/2);
                        }

                        //oxides
                        if(chemicalItem.equals(ModItems.RUBIDIUM.get()))
                        {
                            int count = stack.getCount();
                            stack = new ItemStack(ModItems.RUBIDIUM_OXIDE.get().asItem(), count);
                        }

                        player.getInventory().items.set(slot,stack);
                    }
                }
            }

        }
    }

    //Okay now I need a method to detect if a radioactive item is on the ground nearby the player
    //Maybe can't do a range just yet.

    public static int radioactiveItemDetectedOnGround(Player player)
    {

        return 0;
    }



    //TODO: Fix double activation. Static is necessary, and having int count hasn't worked so far.
    //TODO: Doesn't happen for hurt(), but for message?
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
                    //Splits SDS into fragments and puts them into an array.
                    String[] SDSfragments = chemicalItem.getcSDS().split(" & ");

                    //Might change to switch
                    //Might not. Don't know if this will handle multiple possible at once

                    /*
                    switch (chemicalItem.getcSDS())
                    {
                        //This will check for SDS pictogram tag.
                        //I wanna make it a single string that can be broken up into smaller fragments.
                        //Heirarchy. Explosive, before toxic
                        case "TOXIC":
                            break;

                        default:
                            break;
                     }

                     */


                    //Maybe for loop? For entire array?
                    //Let's list them out:
                    /*
                    H - Health Hazard. Maybe hurt player 10 on eat, but not in splash potion
                    F - Flammable. 1 - Regular, ignites easily. 2 - Self-Igniting
                    I - Exclamation Mark - Hurt player 2 on eat
                    G - Gas Cylinder - Explode if on fire
                    C - Corrosion - Death on eat, Harmful in splash potion?
                    E - Exploding Bomb - Explode on fire?
                    O - Flame Over Circle - Maybe Spreads fire if thrown in.
                    A - Environment - Pollutes water?
                    T - Skull & Crossbones - Death on eat

                    S - Special - Like Potassium explosion when contact w/ water/on eat
                        -- Maybe for tiered we do like S1, S2, etc...

                    Check for first Char, so that we can categorise by letter
                    Hierarchy: S,T,C,H,I,G,E,F,O,A
                    Handles Eating behaviors first, then explosions, then fire. A is gonna be non-functional for a while.



                     */
                    //This works :)
                    for(String sds : SDSfragments)
                    {
                        //SPECIAL CASE
                        //Blows up player
                        if (sds.equals("S1")) {

                            player.level.explode(player, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator)null, player.getX(), player.getY(), player.getZ(), 3.0f,false, Explosion.BlockInteraction.DESTROY);
                            player.hurt(DamageSource.explosion(new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(),3.0f)), 20);

                        }
                        //TOXIC
                        //Kills player
                        if (sds.equals("T")) {
                            player.hurt(DamageSource.GENERIC, 30);
                        }
                        //CORROSIVE
                        //Kills Player
                        if (sds.equals("C")) {
                            player.hurt(DamageSource.GENERIC, 30);
                        }
                        //HEALTH HAZARD
                        //Hurts player 5 hearts
                        if (sds.equals("H")) {
                            player.hurt(DamageSource.GENERIC, 10);
                        }
                        //EXCLAMATION MARK
                        //Hurts player 1 heart
                        if (sds.equals("I")) {
                            player.hurt(DamageSource.GENERIC, 2);
                        }
                        //What would these do on eat?
                        //Probably nothing for now
                        //GAS CYLINDER
                        if (sds.equals("G")) {

                        }
                        //EXPLODING BOMB
                        if (sds.equals("E")) {

                        }
                        //FLAMMABLE
                        if (sds.equals("F")) {

                        }
                        //OXIDIZER
                        if (sds.equals("O")) {

                        }
                        //HARMFUL TO ENVIRONMENT
                        if (sds.equals("A")) {

                        }
                    }
                    //I think that I will keep this for loop for future uses, such as when an item is thrown into fire or something to handle flammability, and explosives

                    /*
                    //Kills player
                    if (chemicalItem.getcSDS().equals("TOXIC")) {
                        player.hurt(DamageSource.GENERIC, 30);
                    }
                    //Blows up player
                    if (chemicalItem.getcSDS().equals("EXP")) {

                        player.level.explode(player, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator)null, player.getX(), player.getY(), player.getZ(), 3.0f,false, Explosion.BlockInteraction.DESTROY);
                        player.hurt(DamageSource.explosion(new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(),3.0f)), 20);

                    }
                    //Can add others

                     */
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
