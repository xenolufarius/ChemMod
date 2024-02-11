package net.claudio.chemmod.event;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.ModBlocks;
import net.claudio.chemmod.item.ModCreativeModeTab;
import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.item.custom.SolutionItem;
import net.claudio.chemmod.networking.ModMessages;
import net.claudio.chemmod.networking.packet.RadiationS2CPacket;
import net.claudio.chemmod.radiation.PlayerRadiation;
import net.claudio.chemmod.radiation.PlayerRadiationProvider;
import net.claudio.chemmod.villager.ModVillagers;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.damagesource.BadRespawnPointDamage;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
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
import net.minecraftforge.registries.RegistryObject;

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

        if(event.getType() == ModVillagers.ORGANIC_CHEMIST.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //For Result Items

            ItemStack sodium_ethoxide = new ItemStack(ModItems.SODIUM_ETHOXIDE.get(), 5);
            ItemStack lab_table = new ItemStack(ModBlocks.LAB_TABLE_BLOCK.get(), 1);
            ItemStack potassium_tert_butoxide = new ItemStack(ModItems.POTASSIUM_TERT_BUTOXIDE.get(),3);
            ItemStack tert_butyl_alcohol = new ItemStack(ModItems.TERT_BUTYL_ALCOHOL.get(),3);
            ItemStack hydrogen_bromide = new ItemStack(ModItems.HYDROGEN_BROMIDE.get(),5);
            ItemStack hydrogen_peroxide = new ItemStack(ModItems.HYDROGEN_PEROXIDE.get(),5);
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
                    new ItemStack(ModItems.BROMOMETHANE.get(), 1),
                    sodium_ethoxide, 6, 1, 0.02F));

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.BROMOETHANE.get(), 1),
                    lab_table, 1, 6, 0.02F));

            //Apprentice ~64xp
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    //Currency, Cost, stack = Result
                    new ItemStack(ModItems.ETHENE.get(), 1),
                    potassium_tert_butoxide, 8, 4, 0.02F));
            //Max Uses,EXP for Villager,Multiplier for Price
            trades.get(villagerlevel+1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.PROPENE.get(), 1),
                    tert_butyl_alcohol, 8, 4, 0.02F));

            //Journeyman ~80xp
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems._1_BUTENE.get(), 1),
                    hydrogen_bromide, 12, 3, 0.02F));
            trades.get(villagerlevel+2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems._2_BUTENE.get(), 1),
                    hydrogen_peroxide, 9, 6, 0.02F));

            //Expert ~100xp
            trades.get(villagerlevel+3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems._1_BROMOPROPANE.get(), 1),
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
        if(event.getType() == ModVillagers.SALT_TRADER.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //For Result Items

            ItemStack sodium_chloride = new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 1);
            ItemStack sodium_oxide = new ItemStack(ModItems.SODIUM_OXIDE.get(), 1);
            ItemStack sodium_fluoride = new ItemStack(ModItems.SODIUM_FLUORIDE.get(), 1);
            ItemStack sodium_sulfide = new ItemStack(ModItems.SODIUM_SULFIDE.get(), 1);
            ItemStack sodium_nitride = new ItemStack(ModItems.SODIUM_NITRIDE.get(), 1);
            ItemStack sodium_bromide = new ItemStack(ModItems.SODIUM_BROMIDE.get(), 1);
            ItemStack sodium_iodide = new ItemStack(ModItems.SODIUM_IODIDE.get(), 1);
            ItemStack sodium_arsenate = new ItemStack(ModItems.SODIUM_ARSENATE.get(), 1);
            ItemStack sodium_arsenite = new ItemStack(ModItems.SODIUM_ARSENITE.get(), 1);
            ItemStack sodium_phosphate = new ItemStack(ModItems.SODIUM_PHOSPHATE.get(), 1);
            ItemStack sodium_dihydrogen_phosphate = new ItemStack(ModItems.SODIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack sodium_sulfate = new ItemStack(ModItems.SODIUM_SULFATE.get(), 1);
            ItemStack sodium_hydrogen_sulfate = new ItemStack(ModItems.SODIUM_HYDROGEN_SULFATE.get(), 1);
            ItemStack sodium_thiosulfate = new ItemStack(ModItems.SODIUM_THIOSULFATE.get(), 1);
            ItemStack sodium_sulfite = new ItemStack(ModItems.SODIUM_SULFITE.get(), 1);
            ItemStack sodium_nitrate = new ItemStack(ModItems.SODIUM_NITRATE.get(), 1);
            ItemStack sodium_nitrite = new ItemStack(ModItems.SODIUM_NITRITE.get(), 1);
            ItemStack sodium_perchlorate = new ItemStack(ModItems.SODIUM_PERCHLORATE.get(), 1);
            ItemStack sodium_chlorate = new ItemStack(ModItems.SODIUM_CHLORATE.get(), 1);
            ItemStack sodium_chlorite = new ItemStack(ModItems.SODIUM_CHLORITE.get(), 1);
            ItemStack sodium_hypochlorite = new ItemStack(ModItems.SODIUM_HYPOCHLORITE.get(), 1);
            ItemStack sodium_iodate = new ItemStack(ModItems.SODIUM_IODATE.get(), 1);
            ItemStack sodium_bromate = new ItemStack(ModItems.SODIUM_BROMATE.get(), 1);
            ItemStack sodium_carbonate = new ItemStack(ModItems.SODIUM_CARBONATE.get(), 1);
            ItemStack sodium_bicarbonate = new ItemStack(ModItems.SODIUM_BICARBONATE.get(), 1);
            ItemStack sodium_chromate = new ItemStack(ModItems.SODIUM_CHROMATE.get(), 1);
            ItemStack sodium_dichromate = new ItemStack(ModItems.SODIUM_DICHROMATE.get(), 1);
            ItemStack sodium_acetate = new ItemStack(ModItems.SODIUM_ACETATE.get(), 1);
            ItemStack sodium_formate = new ItemStack(ModItems.SODIUM_FORMATE.get(), 1);
            ItemStack sodium_cyanide = new ItemStack(ModItems.SODIUM_CYANIDE.get(), 1);
            ItemStack sodium_cyanate = new ItemStack(ModItems.SODIUM_CYANATE.get(), 1);
            ItemStack sodium_thiocyanate = new ItemStack(ModItems.SODIUM_THIOCYANATE.get(), 1);
            ItemStack sodium_peroxide = new ItemStack(ModItems.SODIUM_PEROXIDE.get(), 1);
            ItemStack sodium_oxalate = new ItemStack(ModItems.SODIUM_OXALATE.get(), 1);
            ItemStack sodium_hydroxide = new ItemStack(ModItems.SODIUM_HYDROXIDE.get(), 1);
            ItemStack sodium_permanganate = new ItemStack(ModItems.SODIUM_PERMANGANATE.get(), 1);
            ItemStack lithium_oxide = new ItemStack(ModItems.LITHIUM_OXIDE.get(), 1);
            ItemStack lithium_fluoride = new ItemStack(ModItems.LITHIUM_FLUORIDE.get(), 1);
            ItemStack lithium_sulfide = new ItemStack(ModItems.LITHIUM_SULFIDE.get(), 1);
            ItemStack lithium_chloride= new ItemStack(ModItems.LITHIUM_CHLORIDE.get(), 1);
            ItemStack lithium_nitride = new ItemStack(ModItems.LITHIUM_NITRIDE.get(), 1);
            ItemStack lithium_bromide = new ItemStack(ModItems.LITHIUM_BROMIDE.get(), 1);
            ItemStack lithium_iodide = new ItemStack(ModItems.LITHIUM_IODIDE.get(), 1);
            ItemStack lithium_arsenate = new ItemStack(ModItems.LITHIUM_ARSENATE.get(), 1);
            ItemStack lithium_phosphate = new ItemStack(ModItems.LITHIUM_PHOSPHATE.get(), 1);
            ItemStack lithium_sulfate = new ItemStack(ModItems.LITHIUM_SULFATE.get(), 1);
            ItemStack lithium_hydrogen_sulfate = new ItemStack(ModItems.LITHIUM_HYDROGEN_SULFATE.get(), 1);
            ItemStack lithium_thiosulfate = new ItemStack(ModItems.LITHIUM_THIOSULFATE.get(), 1);
            ItemStack lithium_sulfite = new ItemStack(ModItems.LITHIUM_SULFITE.get(), 1);
            ItemStack lithium_nitrate = new ItemStack(ModItems.LITHIUM_NITRATE.get(), 1);
            ItemStack lithium_nitrite = new ItemStack(ModItems.LITHIUM_NITRITE.get(), 1);
            ItemStack lithium_perchlorate = new ItemStack(ModItems.LITHIUM_PERCHLORATE.get(), 1);
            ItemStack lithium_chlorate = new ItemStack(ModItems.LITHIUM_CHLORATE.get(), 1);
            ItemStack lithium_chlorite = new ItemStack(ModItems.LITHIUM_CHLORITE.get(), 1);
            ItemStack lithium_hypochlorite = new ItemStack(ModItems.LITHIUM_HYPOCHLORITE.get(), 1);
            ItemStack lithium_iodate = new ItemStack(ModItems.LITHIUM_IODATE.get(), 1);
            ItemStack lithium_carbonate = new ItemStack(ModItems.LITHIUM_CARBONATE.get(), 1);
            ItemStack lithium_bicarbonate = new ItemStack(ModItems.LITHIUM_BICARBONATE.get(), 1);
            ItemStack lithium_chromate = new ItemStack(ModItems.LITHIUM_CHROMATE.get(), 1);
            ItemStack lithium_dichromate = new ItemStack(ModItems.LITHIUM_DICHROMATE.get(), 1);
            ItemStack lithium_acetate = new ItemStack(ModItems.LITHIUM_ACETATE.get(), 1);
            ItemStack lithium_cyanide = new ItemStack(ModItems.LITHIUM_CYANIDE.get(), 1);
            ItemStack lithium_thiocyanate = new ItemStack(ModItems.LITHIUM_THIOCYANATE.get(), 1);
            ItemStack lithium_peroxide = new ItemStack(ModItems.LITHIUM_PEROXIDE.get(), 1);
            ItemStack lithium_oxalate = new ItemStack(ModItems.LITHIUM_OXALATE.get(), 1);
            ItemStack lithium_hydroxide = new ItemStack(ModItems.LITHIUM_HYDROXIDE.get(), 1);
            ItemStack beryllium_oxide = new ItemStack(ModItems.BERYLLIUM_OXIDE.get(), 1);
            ItemStack beryllium_fluoride = new ItemStack(ModItems.BERYLLIUM_FLUORIDE.get(), 1);
            ItemStack beryllium_sulfide = new ItemStack(ModItems.BERYLLIUM_SULFIDE.get(), 1);
            ItemStack beryllium_chloride= new ItemStack(ModItems.BERYLLIUM_CHLORIDE.get(), 1);
            ItemStack beryllium_nitride = new ItemStack(ModItems.BERYLLIUM_NITRIDE.get(), 1);
            ItemStack beryllium_bromide = new ItemStack(ModItems.BERYLLIUM_BROMIDE.get(), 1);
            ItemStack beryllium_iodide = new ItemStack(ModItems.BERYLLIUM_IODIDE.get(), 1);
            ItemStack beryllium_sulfate = new ItemStack(ModItems.BERYLLIUM_SULFATE.get(), 1);
            ItemStack beryllium_nitrate = new ItemStack(ModItems.BERYLLIUM_NITRATE.get(), 1);
            ItemStack beryllium_perchlorate = new ItemStack(ModItems.BERYLLIUM_PERCHLORATE.get(), 1);
            ItemStack beryllium_iodate = new ItemStack(ModItems.BERYLLIUM_IODATE.get(), 1);
            ItemStack beryllium_carbonate = new ItemStack(ModItems.BERYLLIUM_CARBONATE.get(), 1);
            ItemStack beryllium_chromate = new ItemStack(ModItems.BERYLLIUM_CHROMATE.get(), 1);
            ItemStack beryllium_cyanide = new ItemStack(ModItems.BERYLLIUM_CYANIDE.get(), 1);
            ItemStack beryllium_thiocyanate = new ItemStack(ModItems.BERYLLIUM_THIOCYANATE.get(), 1);
            ItemStack beryllium_oxalate = new ItemStack(ModItems.BERYLLIUM_OXALATE.get(), 1);
            ItemStack beryllium_hydroxide = new ItemStack(ModItems.BERYLLIUM_HYDROXIDE.get(), 1);
            ItemStack calcium_oxide = new ItemStack(ModItems.CALCIUM_OXIDE.get(), 1);
            ItemStack calcium_fluoride = new ItemStack(ModItems.CALCIUM_FLUORIDE.get(), 1);
            ItemStack calcium_sulfide = new ItemStack(ModItems.CALCIUM_SULFIDE.get(), 1);
            ItemStack calcium_chloride= new ItemStack(ModItems.CALCIUM_CHLORIDE.get(), 1);
            ItemStack calcium_nitride = new ItemStack(ModItems.CALCIUM_NITRIDE.get(), 1);
            ItemStack calcium_bromide = new ItemStack(ModItems.CALCIUM_BROMIDE.get(), 1);
            ItemStack calcium_iodide = new ItemStack(ModItems.CALCIUM_IODIDE.get(), 1);
            ItemStack calcium_arsenate = new ItemStack(ModItems.CALCIUM_ARSENATE.get(), 1);
            ItemStack calcium_arsenite = new ItemStack(ModItems.CALCIUM_ARSENITE.get(), 1);
            ItemStack calcium_phosphate = new ItemStack(ModItems.CALCIUM_PHOSPHATE.get(), 1);
            ItemStack calcium_dihydrogen_phosphate = new ItemStack(ModItems.CALCIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack calcium_sulfate = new ItemStack(ModItems.CALCIUM_SULFATE.get(), 1);
            ItemStack calcium_hydrogen_sulfate = new ItemStack(ModItems.CALCIUM_HYDROGEN_SULFATE.get(), 1);
            ItemStack calcium_thiosulfate = new ItemStack(ModItems.CALCIUM_THIOSULFATE.get(), 1);
            ItemStack calcium_sulfite = new ItemStack(ModItems.CALCIUM_SULFITE.get(), 1);
            ItemStack calcium_nitrate = new ItemStack(ModItems.CALCIUM_NITRATE.get(), 1);
            ItemStack calcium_nitrite = new ItemStack(ModItems.CALCIUM_NITRITE.get(), 1);
            ItemStack calcium_perchlorate = new ItemStack(ModItems.CALCIUM_PERCHLORATE.get(), 1);
            ItemStack calcium_chlorate = new ItemStack(ModItems.CALCIUM_CHLORATE.get(), 1);
            ItemStack calcium_chlorite = new ItemStack(ModItems.CALCIUM_CHLORITE.get(), 1);
            ItemStack calcium_hypochlorite = new ItemStack(ModItems.CALCIUM_HYPOCHLORITE.get(), 1);
            ItemStack calcium_iodate = new ItemStack(ModItems.CALCIUM_IODATE.get(), 1);
            ItemStack calcium_bromate = new ItemStack(ModItems.CALCIUM_BROMATE.get(), 1);
            ItemStack calcium_carbonate = new ItemStack(ModItems.CALCIUM_CARBONATE.get(), 1);
            ItemStack calcium_bicarbonate = new ItemStack(ModItems.CALCIUM_BICARBONATE.get(), 1);
            ItemStack calcium_chromate = new ItemStack(ModItems.CALCIUM_CHROMATE.get(), 1);
            ItemStack calcium_dichromate = new ItemStack(ModItems.CALCIUM_DICHROMATE.get(), 1);
            ItemStack calcium_acetate = new ItemStack(ModItems.CALCIUM_ACETATE.get(), 1);
            ItemStack calcium_formate = new ItemStack(ModItems.CALCIUM_FORMATE.get(), 1);
            ItemStack calcium_cyanide = new ItemStack(ModItems.CALCIUM_CYANIDE.get(), 1);
            ItemStack calcium_cyanate = new ItemStack(ModItems.CALCIUM_CYANATE.get(), 1);
            ItemStack calcium_thiocyanate = new ItemStack(ModItems.CALCIUM_THIOCYANATE.get(), 1);
            ItemStack calcium_peroxide = new ItemStack(ModItems.CALCIUM_PEROXIDE.get(), 1);
            ItemStack calcium_oxalate = new ItemStack(ModItems.CALCIUM_OXALATE.get(), 1);
            ItemStack calcium_hydroxide = new ItemStack(ModItems.CALCIUM_HYDROXIDE.get(), 1);
            ItemStack calcium_permanganate = new ItemStack(ModItems.CALCIUM_PERMANGANATE.get(), 1);
            ItemStack potassium_oxide = new ItemStack(ModItems.POTASSIUM_OXIDE.get(), 1);
            ItemStack potassium_fluoride = new ItemStack(ModItems.POTASSIUM_FLUORIDE.get(), 1);
            ItemStack potassium_sulfide = new ItemStack(ModItems.POTASSIUM_SULFIDE.get(), 1);
            ItemStack potassium_chloride= new ItemStack(ModItems.POTASSIUM_CHLORIDE.get(), 1);
            ItemStack potassium_nitride = new ItemStack(ModItems.POTASSIUM_NITRIDE.get(), 1);
            ItemStack potassium_bromide = new ItemStack(ModItems.POTASSIUM_BROMIDE.get(), 1);
            ItemStack potassium_iodide = new ItemStack(ModItems.POTASSIUM_IODIDE.get(), 1);
            ItemStack potassium_arsenate = new ItemStack(ModItems.POTASSIUM_ARSENATE.get(), 1);
            ItemStack potassium_arsenite = new ItemStack(ModItems.POTASSIUM_ARSENITE.get(), 1);
            ItemStack potassium_phosphate = new ItemStack(ModItems.POTASSIUM_PHOSPHATE.get(), 1);
            ItemStack potassium_dihydrogen_phosphate = new ItemStack(ModItems.POTASSIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack potassium_sulfate = new ItemStack(ModItems.POTASSIUM_SULFATE.get(), 1);
            ItemStack potassium_hydrogen_sulfate = new ItemStack(ModItems.POTASSIUM_HYDROGEN_SULFATE.get(), 1);
            ItemStack potassium_thiosulfate = new ItemStack(ModItems.POTASSIUM_THIOSULFATE.get(), 1);
            ItemStack potassium_sulfite = new ItemStack(ModItems.POTASSIUM_SULFITE.get(), 1);
            ItemStack potassium_nitrate = new ItemStack(ModItems.POTASSIUM_NITRATE.get(), 1);
            ItemStack potassium_nitrite = new ItemStack(ModItems.POTASSIUM_NITRITE.get(), 1);
            ItemStack potassium_perchlorate = new ItemStack(ModItems.POTASSIUM_PERCHLORATE.get(), 1);
            ItemStack potassium_chlorate = new ItemStack(ModItems.POTASSIUM_CHLORATE.get(), 1);
            ItemStack potassium_chlorite = new ItemStack(ModItems.POTASSIUM_CHLORITE.get(), 1);
            ItemStack potassium_hypochlorite = new ItemStack(ModItems.POTASSIUM_HYPOCHLORITE.get(), 1);
            ItemStack potassium_iodate = new ItemStack(ModItems.POTASSIUM_IODATE.get(), 1);
            ItemStack potassium_bromate = new ItemStack(ModItems.POTASSIUM_BROMATE.get(), 1);
            ItemStack potassium_carbonate = new ItemStack(ModItems.POTASSIUM_CARBONATE.get(), 1);
            ItemStack potassium_bicarbonate = new ItemStack(ModItems.POTASSIUM_BICARBONATE.get(), 1);
            ItemStack potassium_chromate = new ItemStack(ModItems.POTASSIUM_CHROMATE.get(), 1);
            ItemStack potassium_dichromate = new ItemStack(ModItems.POTASSIUM_DICHROMATE.get(), 1);
            ItemStack potassium_acetate = new ItemStack(ModItems.POTASSIUM_ACETATE.get(), 1);
            ItemStack potassium_formate = new ItemStack(ModItems.POTASSIUM_FORMATE.get(), 1);
            ItemStack potassium_cyanide = new ItemStack(ModItems.POTASSIUM_CYANIDE.get(), 1);
            ItemStack potassium_cyanate = new ItemStack(ModItems.POTASSIUM_CYANATE.get(), 1);
            ItemStack potassium_thiocyanate = new ItemStack(ModItems.POTASSIUM_THIOCYANATE.get(), 1);
            ItemStack potassium_peroxide = new ItemStack(ModItems.POTASSIUM_PEROXIDE.get(), 1);
            ItemStack potassium_oxalate = new ItemStack(ModItems.POTASSIUM_OXALATE.get(), 1);
            ItemStack potassium_hydroxide = new ItemStack(ModItems.POTASSIUM_HYDROXIDE.get(), 1);
            ItemStack potassium_permanganate = new ItemStack(ModItems.POTASSIUM_PERMANGANATE.get(), 1);
            ItemStack aluminum_oxide = new ItemStack(ModItems.ALUMINUM_OXIDE.get(), 1);
            ItemStack aluminum_fluoride = new ItemStack(ModItems.ALUMINUM_FLUORIDE.get(), 1);
            ItemStack aluminum_sulfide = new ItemStack(ModItems.ALUMINUM_SULFIDE.get(), 1);
            ItemStack aluminum_chloride= new ItemStack(ModItems.ALUMINUM_CHLORIDE.get(), 1);
            ItemStack aluminum_nitride = new ItemStack(ModItems.ALUMINUM_NITRIDE.get(), 1);
            ItemStack aluminum_bromide = new ItemStack(ModItems.ALUMINUM_BROMIDE.get(), 1);
            ItemStack aluminum_iodide = new ItemStack(ModItems.ALUMINUM_IODIDE.get(), 1);
            ItemStack aluminum_arsenate = new ItemStack(ModItems.ALUMINUM_ARSENATE.get(), 1);
            ItemStack aluminum_phosphate = new ItemStack(ModItems.ALUMINUM_PHOSPHATE.get(), 1);
            ItemStack aluminum_dihydrogen_phosphate = new ItemStack(ModItems.ALUMINUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack aluminum_sulfate = new ItemStack(ModItems.ALUMINUM_SULFATE.get(), 1);
            ItemStack aluminum_thiosulfate = new ItemStack(ModItems.ALUMINUM_THIOSULFATE.get(), 1);
            ItemStack aluminum_nitrate = new ItemStack(ModItems.ALUMINUM_NITRATE.get(), 1);
            ItemStack aluminum_perchlorate = new ItemStack(ModItems.ALUMINUM_PERCHLORATE.get(), 1);
            ItemStack aluminum_chlorate = new ItemStack(ModItems.ALUMINUM_CHLORATE.get(), 1);
            ItemStack aluminum_bromate = new ItemStack(ModItems.ALUMINUM_BROMATE.get(), 1);
            ItemStack aluminum_carbonate = new ItemStack(ModItems.ALUMINUM_CARBONATE.get(), 1);
            ItemStack aluminum_bicarbonate = new ItemStack(ModItems.ALUMINUM_BICARBONATE.get(), 1);
            ItemStack aluminum_acetate = new ItemStack(ModItems.ALUMINUM_ACETATE.get(), 1);
            ItemStack aluminum_formate = new ItemStack(ModItems.ALUMINUM_FORMATE.get(), 1);
            ItemStack aluminum_cyanide = new ItemStack(ModItems.ALUMINUM_CYANIDE.get(), 1);
            ItemStack aluminum_oxalate = new ItemStack(ModItems.ALUMINUM_OXALATE.get(), 1);
            ItemStack aluminum_hydroxide = new ItemStack(ModItems.ALUMINUM_HYDROXIDE.get(), 1);
            ItemStack ammonium_fluoride = new ItemStack(ModItems.AMMONIUM_FLUORIDE.get(), 1);
            ItemStack ammonium_sulfide = new ItemStack(ModItems.AMMONIUM_SULFIDE.get(), 1);
            ItemStack ammonium_chloride= new ItemStack(ModItems.AMMONIUM_CHLORIDE.get(), 1);
            ItemStack ammonium_bromide = new ItemStack(ModItems.AMMONIUM_BROMIDE.get(), 1);
            ItemStack ammonium_iodide = new ItemStack(ModItems.AMMONIUM_IODIDE.get(), 1);
            ItemStack ammonium_arsenate = new ItemStack(ModItems.AMMONIUM_ARSENATE.get(), 1);
            ItemStack ammonium_phosphate = new ItemStack(ModItems.AMMONIUM_PHOSPHATE.get(), 1);
            ItemStack ammonium_dihydrogen_phosphate = new ItemStack(ModItems.AMMONIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack ammonium_sulfate = new ItemStack(ModItems.AMMONIUM_SULFATE.get(), 1);
            ItemStack ammonium_hydrogen_sulfate = new ItemStack(ModItems.AMMONIUM_HYDROGEN_SULFATE.get(), 1);
            ItemStack ammonium_thiosulfate = new ItemStack(ModItems.AMMONIUM_THIOSULFATE.get(), 1);
            ItemStack ammonium_sulfite = new ItemStack(ModItems.AMMONIUM_SULFITE.get(), 1);
            ItemStack ammonium_nitrate = new ItemStack(ModItems.AMMONIUM_NITRATE.get(), 1);
            ItemStack ammonium_nitrite = new ItemStack(ModItems.AMMONIUM_NITRITE.get(), 1);
            ItemStack ammonium_perchlorate = new ItemStack(ModItems.AMMONIUM_PERCHLORATE.get(), 1);
            ItemStack ammonium_chlorate = new ItemStack(ModItems.AMMONIUM_CHLORATE.get(), 1);
            ItemStack ammonium_iodate = new ItemStack(ModItems.AMMONIUM_IODATE.get(), 1);
            ItemStack ammonium_carbonate = new ItemStack(ModItems.AMMONIUM_CARBONATE.get(), 1);
            ItemStack ammonium_bicarbonate = new ItemStack(ModItems.AMMONIUM_BICARBONATE.get(), 1);
            ItemStack ammonium_chromate = new ItemStack(ModItems.AMMONIUM_CHROMATE.get(), 1);
            ItemStack ammonium_dichromate = new ItemStack(ModItems.AMMONIUM_DICHROMATE.get(), 1);
            ItemStack ammonium_acetate = new ItemStack(ModItems.AMMONIUM_ACETATE.get(), 1);
            ItemStack ammonium_formate = new ItemStack(ModItems.AMMONIUM_FORMATE.get(), 1);
            ItemStack ammonium_cyanide = new ItemStack(ModItems.AMMONIUM_CYANIDE.get(), 1);
            ItemStack ammonium_cyanate = new ItemStack(ModItems.AMMONIUM_CYANATE.get(), 1);
            ItemStack ammonium_thiocyanate = new ItemStack(ModItems.AMMONIUM_THIOCYANATE.get(), 1);
            ItemStack ammonium_oxalate = new ItemStack(ModItems.AMMONIUM_OXALATE.get(), 1);
            ItemStack ammonium_permanganate = new ItemStack(ModItems.AMMONIUM_PERMANGANATE.get(), 1);
            ItemStack barium_oxide = new ItemStack(ModItems.BARIUM_OXIDE.get(), 1);
            ItemStack barium_fluoride = new ItemStack(ModItems.BARIUM_FLUORIDE.get(), 1);
            ItemStack barium_sulfide = new ItemStack(ModItems.BARIUM_SULFIDE.get(), 1);
            ItemStack barium_chloride= new ItemStack(ModItems.BARIUM_CHLORIDE.get(), 1);
            ItemStack barium_nitride = new ItemStack(ModItems.BARIUM_NITRIDE.get(), 1);
            ItemStack barium_bromide = new ItemStack(ModItems.BARIUM_BROMIDE.get(), 1);
            ItemStack barium_iodide = new ItemStack(ModItems.BARIUM_IODIDE.get(), 1);
            ItemStack barium_arsenate = new ItemStack(ModItems.BARIUM_ARSENATE.get(), 1);
            ItemStack barium_phosphate = new ItemStack(ModItems.BARIUM_PHOSPHATE.get(), 1);
            ItemStack barium_dihydrogen_phosphate = new ItemStack(ModItems.BARIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack barium_sulfate = new ItemStack(ModItems.BARIUM_SULFATE.get(), 1);
            ItemStack barium_sulfite = new ItemStack(ModItems.BARIUM_SULFITE.get(), 1);
            ItemStack barium_nitrate = new ItemStack(ModItems.BARIUM_NITRATE.get(), 1);
            ItemStack barium_nitrite = new ItemStack(ModItems.BARIUM_NITRITE.get(), 1);
            ItemStack barium_perchlorate = new ItemStack(ModItems.BARIUM_PERCHLORATE.get(), 1);
            ItemStack barium_chlorate = new ItemStack(ModItems.BARIUM_CHLORATE.get(), 1);
            ItemStack barium_hypochlorite = new ItemStack(ModItems.BARIUM_HYPOCHLORITE.get(), 1);
            ItemStack barium_iodate = new ItemStack(ModItems.BARIUM_IODATE.get(), 1);
            ItemStack barium_bromate = new ItemStack(ModItems.BARIUM_BROMATE.get(), 1);
            ItemStack barium_carbonate = new ItemStack(ModItems.BARIUM_CARBONATE.get(), 1);
            ItemStack barium_chromate = new ItemStack(ModItems.BARIUM_CHROMATE.get(), 1);
            ItemStack barium_acetate = new ItemStack(ModItems.BARIUM_ACETATE.get(), 1);
            ItemStack barium_cyanide = new ItemStack(ModItems.BARIUM_CYANIDE.get(), 1);
            ItemStack barium_thiocyanate = new ItemStack(ModItems.BARIUM_THIOCYANATE.get(), 1);
            ItemStack barium_peroxide = new ItemStack(ModItems.BARIUM_PEROXIDE.get(), 1);
            ItemStack barium_oxalate = new ItemStack(ModItems.BARIUM_OXALATE.get(), 1);
            ItemStack barium_hydroxide = new ItemStack(ModItems.BARIUM_HYDROXIDE.get(), 1);
            ItemStack barium_permanganate = new ItemStack(ModItems.BARIUM_PERMANGANATE.get(), 1);
            ItemStack chromium_ii_oxide = new ItemStack(ModItems.CHROMIUM_II_OXIDE.get(), 1);
            ItemStack chromium_ii_fluoride = new ItemStack(ModItems.CHROMIUM_II_FLUORIDE.get(), 1);
            ItemStack chromium_ii_sulfide = new ItemStack(ModItems.CHROMIUM_II_SULFIDE.get(), 1);
            ItemStack chromium_ii_chloride= new ItemStack(ModItems.CHROMIUM_II_CHLORIDE.get(), 1);
            ItemStack chromium_ii_bromide = new ItemStack(ModItems.CHROMIUM_II_BROMIDE.get(), 1);
            ItemStack chromium_ii_iodide = new ItemStack(ModItems.CHROMIUM_II_IODIDE.get(), 1);
            ItemStack chromium_ii_chromate = new ItemStack(ModItems.CHROMIUM_II_CHROMATE.get(), 1);
            ItemStack chromium_ii_acetate = new ItemStack(ModItems.CHROMIUM_II_ACETATE.get(), 1);
            ItemStack chromium_ii_oxalate = new ItemStack(ModItems.CHROMIUM_II_OXALATE.get(), 1);
            ItemStack chromium_iii_oxide = new ItemStack(ModItems.CHROMIUM_III_OXIDE.get(), 1);
            ItemStack chromium_iii_fluoride = new ItemStack(ModItems.CHROMIUM_III_FLUORIDE.get(), 1);
            ItemStack chromium_iii_sulfide = new ItemStack(ModItems.CHROMIUM_III_SULFIDE.get(), 1);
            ItemStack chromium_iii_chloride= new ItemStack(ModItems.CHROMIUM_III_CHLORIDE.get(), 1);
            ItemStack chromium_iii_nitride = new ItemStack(ModItems.CHROMIUM_III_NITRIDE.get(), 1);
            ItemStack chromium_iii_bromide = new ItemStack(ModItems.CHROMIUM_III_BROMIDE.get(), 1);
            ItemStack chromium_iii_iodide = new ItemStack(ModItems.CHROMIUM_III_IODIDE.get(), 1);
            ItemStack chromium_iii_phosphate = new ItemStack(ModItems.CHROMIUM_III_PHOSPHATE.get(), 1);
            ItemStack chromium_iii_sulfate = new ItemStack(ModItems.CHROMIUM_III_SULFATE.get(), 1);
            ItemStack chromium_iii_nitrate = new ItemStack(ModItems.CHROMIUM_III_NITRATE.get(), 1);
            ItemStack chromium_iii_perchlorate = new ItemStack(ModItems.CHROMIUM_III_PERCHLORATE.get(), 1);
            ItemStack chromium_iii_chromate = new ItemStack(ModItems.CHROMIUM_III_CHROMATE.get(), 1);
            ItemStack chromium_iii_oxalate = new ItemStack(ModItems.CHROMIUM_III_OXALATE.get(), 1);
            ItemStack chromium_iii_hydroxide = new ItemStack(ModItems.CHROMIUM_III_HYDROXIDE.get(), 1);
            ItemStack copper_i_oxide = new ItemStack(ModItems.COPPER_I_OXIDE.get(), 1);
            ItemStack copper_i_fluoride = new ItemStack(ModItems.COPPER_I_FLUORIDE.get(), 1);
            ItemStack copper_i_sulfide = new ItemStack(ModItems.COPPER_I_SULFIDE.get(), 1);
            ItemStack copper_i_chloride= new ItemStack(ModItems.COPPER_I_CHLORIDE.get(), 1);
            ItemStack copper_i_bromide = new ItemStack(ModItems.COPPER_I_BROMIDE.get(), 1);
            ItemStack copper_i_iodide = new ItemStack(ModItems.COPPER_I_IODIDE.get(), 1);
            ItemStack copper_i_sulfate = new ItemStack(ModItems.COPPER_I_SULFATE.get(), 1);
            ItemStack copper_i_cyanide = new ItemStack(ModItems.COPPER_I_CYANIDE.get(), 1);
            ItemStack copper_i_thiocyanate = new ItemStack(ModItems.COPPER_I_THIOCYANATE.get(), 1);
            ItemStack copper_i_hydroxide = new ItemStack(ModItems.COPPER_I_HYDROXIDE.get(), 1);
            ItemStack copper_ii_oxide = new ItemStack(ModItems.COPPER_II_OXIDE.get(), 1);
            ItemStack copper_ii_fluoride = new ItemStack(ModItems.COPPER_II_FLUORIDE.get(), 1);
            ItemStack copper_ii_sulfide = new ItemStack(ModItems.COPPER_II_SULFIDE.get(), 1);
            ItemStack copper_ii_chloride= new ItemStack(ModItems.COPPER_II_CHLORIDE.get(), 1);
            ItemStack copper_ii_bromide = new ItemStack(ModItems.COPPER_II_BROMIDE.get(), 1);
            ItemStack copper_ii_arsenate = new ItemStack(ModItems.COPPER_II_ARSENATE.get(), 1);
            ItemStack copper_ii_phosphate = new ItemStack(ModItems.COPPER_II_PHOSPHATE.get(), 1);
            ItemStack copper_ii_sulfate = new ItemStack(ModItems.COPPER_II_SULFATE.get(), 1);
            ItemStack copper_ii_nitrate = new ItemStack(ModItems.COPPER_II_NITRATE.get(), 1);
            ItemStack copper_ii_perchlorate = new ItemStack(ModItems.COPPER_II_PERCHLORATE.get(), 1);
            ItemStack copper_ii_chlorate = new ItemStack(ModItems.COPPER_II_CHLORATE.get(), 1);
            ItemStack copper_ii_carbonate = new ItemStack(ModItems.COPPER_II_CARBONATE.get(), 1);
            ItemStack copper_ii_chromate = new ItemStack(ModItems.COPPER_II_CHROMATE.get(), 1);
            ItemStack copper_ii_acetate = new ItemStack(ModItems.COPPER_II_ACETATE.get(), 1);
            ItemStack copper_ii_formate = new ItemStack(ModItems.COPPER_II_FORMATE.get(), 1);
            ItemStack copper_ii_thiocyanate = new ItemStack(ModItems.COPPER_II_THIOCYANATE.get(), 1);
            ItemStack copper_ii_peroxide = new ItemStack(ModItems.COPPER_II_PEROXIDE.get(), 1);
            ItemStack copper_ii_oxalate = new ItemStack(ModItems.COPPER_II_OXALATE.get(), 1);
            ItemStack copper_ii_hydroxide = new ItemStack(ModItems.COPPER_II_HYDROXIDE.get(), 1);
            ItemStack iron_ii_oxide = new ItemStack(ModItems.IRON_II_OXIDE.get(), 1);
            ItemStack iron_ii_fluoride = new ItemStack(ModItems.IRON_II_FLUORIDE.get(), 1);
            ItemStack iron_ii_sulfide = new ItemStack(ModItems.IRON_II_SULFIDE.get(), 1);
            ItemStack iron_ii_chloride= new ItemStack(ModItems.IRON_II_CHLORIDE.get(), 1);
            ItemStack iron_ii_bromide = new ItemStack(ModItems.IRON_II_BROMIDE.get(), 1);
            ItemStack iron_ii_iodide = new ItemStack(ModItems.IRON_II_IODIDE.get(), 1);
            ItemStack iron_ii_arsenate = new ItemStack(ModItems.IRON_II_ARSENATE.get(), 1);
            ItemStack iron_ii_phosphate = new ItemStack(ModItems.IRON_II_PHOSPHATE.get(), 1);
            ItemStack iron_ii_sulfate = new ItemStack(ModItems.IRON_II_SULFATE.get(), 1);
            ItemStack iron_ii_nitrate = new ItemStack(ModItems.IRON_II_NITRATE.get(), 1);
            ItemStack iron_ii_perchlorate = new ItemStack(ModItems.IRON_II_PERCHLORATE.get(), 1);
            ItemStack iron_ii_carbonate = new ItemStack(ModItems.IRON_II_CARBONATE.get(), 1);
            ItemStack iron_ii_acetate = new ItemStack(ModItems.IRON_II_ACETATE.get(), 1);
            ItemStack iron_ii_thiocyanate = new ItemStack(ModItems.IRON_II_THIOCYANATE.get(), 1);
            ItemStack iron_ii_oxalate = new ItemStack(ModItems.IRON_II_OXALATE.get(), 1);
            ItemStack iron_ii_hydroxide = new ItemStack(ModItems.IRON_II_HYDROXIDE.get(), 1);
            ItemStack iron_iii_oxide = new ItemStack(ModItems.IRON_III_OXIDE.get(), 1);
            ItemStack iron_iii_fluoride = new ItemStack(ModItems.IRON_III_FLUORIDE.get(), 1);
            ItemStack iron_iii_chloride= new ItemStack(ModItems.IRON_III_CHLORIDE.get(), 1);
            ItemStack iron_iii_bromide = new ItemStack(ModItems.IRON_III_BROMIDE.get(), 1);
            ItemStack iron_iii_iodide = new ItemStack(ModItems.IRON_III_IODIDE.get(), 1);
            ItemStack iron_iii_arsenate = new ItemStack(ModItems.IRON_III_ARSENATE.get(), 1);
            ItemStack iron_iii_phosphate = new ItemStack(ModItems.IRON_III_PHOSPHATE.get(), 1);
            ItemStack iron_iii_sulfate = new ItemStack(ModItems.IRON_III_SULFATE.get(), 1);
            ItemStack iron_iii_nitrate = new ItemStack(ModItems.IRON_III_NITRATE.get(), 1);
            ItemStack iron_iii_oxalate = new ItemStack(ModItems.IRON_III_OXALATE.get(), 1);
            ItemStack lead_ii_oxide = new ItemStack(ModItems.LEAD_II_OXIDE.get(), 1);
            ItemStack lead_ii_fluoride = new ItemStack(ModItems.LEAD_II_FLUORIDE.get(), 1);
            ItemStack lead_ii_sulfide = new ItemStack(ModItems.LEAD_II_SULFIDE.get(), 1);
            ItemStack lead_ii_chloride= new ItemStack(ModItems.LEAD_II_CHLORIDE.get(), 1);
            ItemStack lead_ii_bromide = new ItemStack(ModItems.LEAD_II_BROMIDE.get(), 1);
            ItemStack lead_ii_iodide = new ItemStack(ModItems.LEAD_II_IODIDE.get(), 1);
            ItemStack lead_ii_arsenite = new ItemStack(ModItems.LEAD_II_ARSENITE.get(), 1);
            ItemStack lead_ii_phosphate = new ItemStack(ModItems.LEAD_II_PHOSPHATE.get(), 1);
            ItemStack lead_ii_sulfate = new ItemStack(ModItems.LEAD_II_SULFATE.get(), 1);
            ItemStack lead_ii_thiosulfate = new ItemStack(ModItems.LEAD_II_THIOSULFATE.get(), 1);
            ItemStack lead_ii_nitrate = new ItemStack(ModItems.LEAD_II_NITRATE.get(), 1);
            ItemStack lead_ii_perchlorate = new ItemStack(ModItems.LEAD_II_PERCHLORATE.get(), 1);
            ItemStack lead_ii_iodate = new ItemStack(ModItems.LEAD_II_IODATE.get(), 1);
            ItemStack lead_ii_carbonate = new ItemStack(ModItems.LEAD_II_CARBONATE.get(), 1);
            ItemStack lead_ii_chromate = new ItemStack(ModItems.LEAD_II_CHROMATE.get(), 1);
            ItemStack lead_ii_acetate = new ItemStack(ModItems.LEAD_II_ACETATE.get(), 1);
            ItemStack lead_ii_cyanide = new ItemStack(ModItems.LEAD_II_CYANIDE.get(), 1);
            ItemStack lead_ii_thiocyanate = new ItemStack(ModItems.LEAD_II_THIOCYANATE.get(), 1);
            ItemStack lead_ii_hydroxide = new ItemStack(ModItems.LEAD_II_HYDROXIDE.get(), 1);
            ItemStack magnesium_oxide = new ItemStack(ModItems.MAGNESIUM_OXIDE.get(), 1);
            ItemStack magnesium_fluoride = new ItemStack(ModItems.MAGNESIUM_FLUORIDE.get(), 1);
            ItemStack magnesium_sulfide = new ItemStack(ModItems.MAGNESIUM_SULFIDE.get(), 1);
            ItemStack magnesium_chloride= new ItemStack(ModItems.MAGNESIUM_CHLORIDE.get(), 1);
            ItemStack magnesium_nitride = new ItemStack(ModItems.MAGNESIUM_NITRIDE.get(), 1);
            ItemStack magnesium_bromide = new ItemStack(ModItems.MAGNESIUM_BROMIDE.get(), 1);
            ItemStack magnesium_iodide = new ItemStack(ModItems.MAGNESIUM_IODIDE.get(), 1);
            ItemStack magnesium_arsenate = new ItemStack(ModItems.MAGNESIUM_ARSENATE.get(), 1);
            ItemStack magnesium_dihydrogen_phosphate = new ItemStack(ModItems.MAGNESIUM_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack magnesium_sulfate = new ItemStack(ModItems.MAGNESIUM_SULFATE.get(), 1);
            ItemStack magnesium_thiosulfate = new ItemStack(ModItems.MAGNESIUM_THIOSULFATE.get(), 1);
            ItemStack magnesium_nitrate = new ItemStack(ModItems.MAGNESIUM_NITRATE.get(), 1);
            ItemStack magnesium_perchlorate = new ItemStack(ModItems.MAGNESIUM_PERCHLORATE.get(), 1);
            ItemStack magnesium_chlorate = new ItemStack(ModItems.MAGNESIUM_CHLORATE.get(), 1);
            ItemStack magnesium_carbonate = new ItemStack(ModItems.MAGNESIUM_CARBONATE.get(), 1);
            ItemStack magnesium_chromate = new ItemStack(ModItems.MAGNESIUM_CHROMATE.get(), 1);
            ItemStack magnesium_acetate = new ItemStack(ModItems.MAGNESIUM_ACETATE.get(), 1);
            ItemStack magnesium_formate = new ItemStack(ModItems.MAGNESIUM_FORMATE.get(), 1);
            ItemStack magnesium_peroxide = new ItemStack(ModItems.MAGNESIUM_PEROXIDE.get(), 1);
            ItemStack magnesium_oxalate = new ItemStack(ModItems.MAGNESIUM_OXALATE.get(), 1);
            ItemStack magnesium_hydroxide = new ItemStack(ModItems.MAGNESIUM_HYDROXIDE.get(), 1);
            ItemStack magnesium_permanganate = new ItemStack(ModItems.MAGNESIUM_PERMANGANATE.get(), 1);
            ItemStack manganese_ii_oxide = new ItemStack(ModItems.MANGANESE_II_OXIDE.get(), 1);
            ItemStack manganese_ii_fluoride = new ItemStack(ModItems.MANGANESE_II_FLUORIDE.get(), 1);
            ItemStack manganese_ii_sulfide = new ItemStack(ModItems.MANGANESE_II_SULFIDE.get(), 1);
            ItemStack manganese_ii_chloride= new ItemStack(ModItems.MANGANESE_II_CHLORIDE.get(), 1);
            ItemStack manganese_ii_bromide = new ItemStack(ModItems.MANGANESE_II_BROMIDE.get(), 1);
            ItemStack manganese_ii_iodide = new ItemStack(ModItems.MANGANESE_II_IODIDE.get(), 1);
            ItemStack manganese_ii_phosphate = new ItemStack(ModItems.MANGANESE_II_PHOSPHATE.get(), 1);
            ItemStack manganese_ii_sulfate = new ItemStack(ModItems.MANGANESE_II_SULFATE.get(), 1);
            ItemStack manganese_ii_nitrate = new ItemStack(ModItems.MANGANESE_II_NITRATE.get(), 1);
            ItemStack manganese_ii_chlorate = new ItemStack(ModItems.MANGANESE_II_CHLORATE.get(), 1);
            ItemStack manganese_ii_carbonate = new ItemStack(ModItems.MANGANESE_II_CARBONATE.get(), 1);
            ItemStack manganese_ii_acetate = new ItemStack(ModItems.MANGANESE_II_ACETATE.get(), 1);
            ItemStack manganese_ii_oxalate = new ItemStack(ModItems.MANGANESE_II_OXALATE.get(), 1);
            ItemStack manganese_ii_hydroxide = new ItemStack(ModItems.MANGANESE_II_HYDROXIDE.get(), 1);
            ItemStack manganese_iii_oxide = new ItemStack(ModItems.MANGANESE_III_OXIDE.get(), 1);
            ItemStack manganese_iii_fluoride = new ItemStack(ModItems.MANGANESE_III_FLUORIDE.get(), 1);
            ItemStack manganese_iii_phosphate = new ItemStack(ModItems.MANGANESE_III_PHOSPHATE.get(), 1);
            ItemStack manganese_iii_sulfate = new ItemStack(ModItems.MANGANESE_III_SULFATE.get(), 1);
            ItemStack manganese_iii_acetate = new ItemStack(ModItems.MANGANESE_III_ACETATE.get(), 1);
            ItemStack mercury_i_oxide = new ItemStack(ModItems.MERCURY_I_OXIDE.get(), 1);
            ItemStack mercury_i_fluoride = new ItemStack(ModItems.MERCURY_I_FLUORIDE.get(), 1);
            ItemStack mercury_i_chloride= new ItemStack(ModItems.MERCURY_I_CHLORIDE.get(), 1);
            ItemStack mercury_i_bromide = new ItemStack(ModItems.MERCURY_I_BROMIDE.get(), 1);
            ItemStack mercury_i_iodide = new ItemStack(ModItems.MERCURY_I_IODIDE.get(), 1);
            ItemStack mercury_i_sulfate = new ItemStack(ModItems.MERCURY_I_SULFATE.get(), 1);
            ItemStack mercury_i_nitrate = new ItemStack(ModItems.MERCURY_I_NITRATE.get(), 1);
            ItemStack mercury_ii_oxide = new ItemStack(ModItems.MERCURY_II_OXIDE.get(), 1);
            ItemStack mercury_ii_fluoride = new ItemStack(ModItems.MERCURY_II_FLUORIDE.get(), 1);
            ItemStack mercury_ii_sulfide = new ItemStack(ModItems.MERCURY_II_SULFIDE.get(), 1);
            ItemStack mercury_ii_chloride= new ItemStack(ModItems.MERCURY_II_CHLORIDE.get(), 1);
            ItemStack mercury_ii_bromide = new ItemStack(ModItems.MERCURY_II_BROMIDE.get(), 1);
            ItemStack mercury_ii_iodide = new ItemStack(ModItems.MERCURY_II_IODIDE.get(), 1);
            ItemStack mercury_ii_sulfate = new ItemStack(ModItems.MERCURY_II_SULFATE.get(), 1);
            ItemStack mercury_ii_nitrate = new ItemStack(ModItems.MERCURY_II_NITRATE.get(), 1);
            ItemStack mercury_ii_acetate = new ItemStack(ModItems.MERCURY_II_ACETATE.get(), 1);
            ItemStack mercury_ii_cyanide = new ItemStack(ModItems.MERCURY_II_CYANIDE.get(), 1);
            ItemStack mercury_ii_thiocyanate = new ItemStack(ModItems.MERCURY_II_THIOCYANATE.get(), 1);
            ItemStack mercury_ii_hydroxide = new ItemStack(ModItems.MERCURY_II_HYDROXIDE.get(), 1);
            ItemStack nitronium_fluoride = new ItemStack(ModItems.NITRONIUM_FLUORIDE.get(), 1);
            ItemStack nitronium_chloride= new ItemStack(ModItems.NITRONIUM_CHLORIDE.get(), 1);
            ItemStack nitronium_perchlorate = new ItemStack(ModItems.NITRONIUM_PERCHLORATE.get(), 1);
            ItemStack silver_oxide = new ItemStack(ModItems.SILVER_OXIDE.get(), 1);
            ItemStack silver_fluoride = new ItemStack(ModItems.SILVER_FLUORIDE.get(), 1);
            ItemStack silver_sulfide = new ItemStack(ModItems.SILVER_SULFIDE.get(), 1);
            ItemStack silver_chloride= new ItemStack(ModItems.SILVER_CHLORIDE.get(), 1);
            ItemStack silver_nitride = new ItemStack(ModItems.SILVER_NITRIDE.get(), 1);
            ItemStack silver_bromide = new ItemStack(ModItems.SILVER_BROMIDE.get(), 1);
            ItemStack silver_iodide = new ItemStack(ModItems.SILVER_IODIDE.get(), 1);
            ItemStack silver_arsenate = new ItemStack(ModItems.SILVER_ARSENATE.get(), 1);
            ItemStack silver_arsenite = new ItemStack(ModItems.SILVER_ARSENITE.get(), 1);
            ItemStack silver_phosphate = new ItemStack(ModItems.SILVER_PHOSPHATE.get(), 1);
            ItemStack silver_sulfate = new ItemStack(ModItems.SILVER_SULFATE.get(), 1);
            ItemStack silver_nitrate = new ItemStack(ModItems.SILVER_NITRATE.get(), 1);
            ItemStack silver_nitrite = new ItemStack(ModItems.SILVER_NITRITE.get(), 1);
            ItemStack silver_perchlorate = new ItemStack(ModItems.SILVER_PERCHLORATE.get(), 1);
            ItemStack silver_chlorate = new ItemStack(ModItems.SILVER_CHLORATE.get(), 1);
            ItemStack silver_chlorite = new ItemStack(ModItems.SILVER_CHLORITE  .get(), 1);
            ItemStack silver_hypochlorite = new ItemStack(ModItems.SILVER_HYPOCHLORITE.get(), 1);
            ItemStack silver_iodate = new ItemStack(ModItems.SILVER_IODATE.get(), 1);
            ItemStack silver_bromate = new ItemStack(ModItems.SILVER_BROMATE.get(), 1);
            ItemStack silver_carbonate = new ItemStack(ModItems.SILVER_CARBONATE.get(), 1);
            ItemStack silver_chromate = new ItemStack(ModItems.SILVER_CHROMATE.get(), 1);
            ItemStack silver_dichromate = new ItemStack(ModItems.SILVER_DICHROMATE.get(), 1);
            ItemStack silver_acetate = new ItemStack(ModItems.SILVER_ACETATE.get(), 1);
            ItemStack silver_cyanide = new ItemStack(ModItems.SILVER_CYANIDE.get(), 1);
            ItemStack silver_thiocyanate = new ItemStack(ModItems.SILVER_THIOCYANATE.get(), 1);
            ItemStack silver_oxalate = new ItemStack(ModItems.SILVER_OXALATE.get(), 1);
            ItemStack silver_hydroxide = new ItemStack(ModItems.SILVER_HYDROXIDE.get(), 1);
            ItemStack silver_permanganate = new ItemStack(ModItems.SILVER_PERMANGANATE.get(), 1);
            ItemStack strontium_oxide = new ItemStack(ModItems.STRONTIUM_OXIDE.get(), 1);
            ItemStack strontium_fluoride = new ItemStack(ModItems.STRONTIUM_FLUORIDE.get(), 1);
            ItemStack strontium_sulfide = new ItemStack(ModItems.STRONTIUM_SULFIDE.get(), 1);
            ItemStack strontium_chloride= new ItemStack(ModItems.STRONTIUM_CHLORIDE.get(), 1);
            ItemStack strontium_nitride = new ItemStack(ModItems.STRONTIUM_NITRIDE.get(), 1);
            ItemStack strontium_bromide = new ItemStack(ModItems.STRONTIUM_BROMIDE.get(), 1);
            ItemStack strontium_iodide = new ItemStack(ModItems.STRONTIUM_IODIDE.get(), 1);
            ItemStack strontium_sulfate = new ItemStack(ModItems.STRONTIUM_SULFATE.get(), 1);
            ItemStack strontium_nitrate = new ItemStack(ModItems.STRONTIUM_NITRATE.get(), 1);
            ItemStack strontium_perchlorate = new ItemStack(ModItems.STRONTIUM_PERCHLORATE.get(), 1);
            ItemStack strontium_chlorate = new ItemStack(ModItems.STRONTIUM_CHLORATE.get(), 1);
            ItemStack strontium_bromate = new ItemStack(ModItems.STRONTIUM_BROMATE.get(), 1);
            ItemStack strontium_carbonate = new ItemStack(ModItems.STRONTIUM_CARBONATE.get(), 1);
            ItemStack strontium_chromate = new ItemStack(ModItems.STRONTIUM_CHROMATE.get(), 1);
            ItemStack strontium_acetate = new ItemStack(ModItems.STRONTIUM_ACETATE.get(), 1);
            ItemStack strontium_formate = new ItemStack(ModItems.STRONTIUM_FORMATE.get(), 1);
            ItemStack strontium_peroxide = new ItemStack(ModItems.STRONTIUM_PEROXIDE.get(), 1);
            ItemStack strontium_oxalate = new ItemStack(ModItems.STRONTIUM_OXALATE.get(), 1);
            ItemStack strontium_hydroxide = new ItemStack(ModItems.STRONTIUM_HYDROXIDE.get(), 1);
            ItemStack tin_ii_oxide = new ItemStack(ModItems.TIN_II_OXIDE.get(), 1);
            ItemStack tin_ii_fluoride = new ItemStack(ModItems.TIN_II_FLUORIDE.get(), 1);
            ItemStack tin_ii_sulfide = new ItemStack(ModItems.TIN_II_SULFIDE.get(), 1);
            ItemStack tin_ii_chloride= new ItemStack(ModItems.TIN_II_CHLORIDE.get(), 1);
            ItemStack tin_ii_bromide = new ItemStack(ModItems.TIN_II_BROMIDE.get(), 1);
            ItemStack tin_ii_iodide = new ItemStack(ModItems.TIN_II_IODIDE.get(), 1);
            ItemStack tin_ii_sulfate = new ItemStack(ModItems.TIN_II_SULFATE.get(), 1);
            ItemStack tin_ii_acetate = new ItemStack(ModItems.TIN_II_ACETATE.get(), 1);
            ItemStack tin_ii_oxalate = new ItemStack(ModItems.TIN_II_OXALATE.get(), 1);
            ItemStack tin_ii_hydroxide = new ItemStack(ModItems.TIN_II_HYDROXIDE.get(), 1);
            ItemStack tin_iv_oxide = new ItemStack(ModItems.TIN_IV_OXIDE.get(), 1);
            ItemStack tin_iv_fluoride = new ItemStack(ModItems.TIN_IV_FLUORIDE.get(), 1);
            ItemStack tin_iv_sulfide = new ItemStack(ModItems.TIN_IV_SULFIDE.get(), 1);
            ItemStack tin_iv_chloride= new ItemStack(ModItems.TIN_IV_CHLORIDE.get(), 1);
            ItemStack tin_iv_bromide = new ItemStack(ModItems.TIN_IV_BROMIDE.get(), 1);
            ItemStack tin_iv_iodide = new ItemStack(ModItems.TIN_IV_IODIDE.get(), 1);
            ItemStack tin_iv_arsenate = new ItemStack(ModItems.TIN_IV_ARSENATE.get(), 1);
            ItemStack tin_iv_nitrate = new ItemStack(ModItems.TIN_IV_NITRATE.get(), 1);
            ItemStack tin_iv_hydroxide = new ItemStack(ModItems.TIN_IV_HYDROXIDE.get(), 1);
            ItemStack zinc_oxide = new ItemStack(ModItems.ZINC_OXIDE.get(), 1);
            ItemStack zinc_fluoride = new ItemStack(ModItems.ZINC_FLUORIDE.get(), 1);
            ItemStack zinc_sulfide = new ItemStack(ModItems.ZINC_SULFIDE.get(), 1);
            ItemStack zinc_chloride= new ItemStack(ModItems.ZINC_CHLORIDE.get(), 1);
            ItemStack zinc_nitride = new ItemStack(ModItems.ZINC_NITRIDE.get(), 1);
            ItemStack zinc_bromide = new ItemStack(ModItems.ZINC_BROMIDE.get(), 1);
            ItemStack zinc_iodide = new ItemStack(ModItems.ZINC_IODIDE.get(), 1);
            ItemStack zinc_arsenate = new ItemStack(ModItems.ZINC_ARSENATE.get(), 1);
            ItemStack zinc_arsenite = new ItemStack(ModItems.ZINC_ARSENITE.get(), 1);
            ItemStack zinc_phosphate = new ItemStack(ModItems.ZINC_PHOSPHATE.get(), 1);
            ItemStack zinc_dihydrogen_phosphate = new ItemStack(ModItems.ZINC_DIHYDROGEN_PHOSPHATE.get(), 1);
            ItemStack zinc_sulfate = new ItemStack(ModItems.ZINC_SULFATE.get(), 1);
            ItemStack zinc_sulfite = new ItemStack(ModItems.ZINC_SULFITE.get(), 1);
            ItemStack zinc_nitrate = new ItemStack(ModItems.ZINC_NITRATE.get(), 1);
            ItemStack zinc_perchlorate = new ItemStack(ModItems.ZINC_PERCHLORATE.get(), 1);
            ItemStack zinc_chlorate = new ItemStack(ModItems.ZINC_CHLORATE.get(), 1);
            ItemStack zinc_bromate = new ItemStack(ModItems.ZINC_BROMATE.get(), 1);
            ItemStack zinc_carbonate = new ItemStack(ModItems.ZINC_CARBONATE.get(), 1);
            ItemStack zinc_chromate = new ItemStack(ModItems.ZINC_CHROMATE.get(), 1);
            ItemStack zinc_dichromate = new ItemStack(ModItems.ZINC_DICHROMATE.get(), 1);
            ItemStack zinc_acetate = new ItemStack(ModItems.ZINC_ACETATE.get(), 1);
            ItemStack zinc_formate = new ItemStack(ModItems.ZINC_FORMATE.get(), 1);
            ItemStack zinc_cyanide = new ItemStack(ModItems.ZINC_CYANIDE.get(), 1);
            ItemStack zinc_thiocyanate = new ItemStack(ModItems.ZINC_THIOCYANATE.get(), 1);
            ItemStack zinc_peroxide = new ItemStack(ModItems.ZINC_PEROXIDE.get(), 1);
            ItemStack zinc_hydroxide = new ItemStack(ModItems.ZINC_HYDROXIDE.get(), 1);
            ItemStack zinc_permanganate = new ItemStack(ModItems.ZINC_PERMANGANATE.get(), 1);
            ItemStack caesium_oxide = new ItemStack(ModItems.CAESIUM_OXIDE.get(), 1);
            ItemStack caesium_fluoride = new ItemStack(ModItems.CAESIUM_FLUORIDE.get(), 1);
            ItemStack caesium_sulfide = new ItemStack(ModItems.CAESIUM_SULFIDE.get(), 1);
            ItemStack caesium_chloride= new ItemStack(ModItems.CAESIUM_CHLORIDE.get(), 1);
            ItemStack caesium_bromide = new ItemStack(ModItems.CAESIUM_BROMIDE.get(), 1);
            ItemStack caesium_iodide = new ItemStack(ModItems.CAESIUM_IODIDE.get(), 1);
            ItemStack caesium_arsenate = new ItemStack(ModItems.CAESIUM_ARSENATE.get(), 1);
            ItemStack caesium_sulfate = new ItemStack(ModItems.CAESIUM_SULFATE.get(), 1);
            ItemStack caesium_nitrate = new ItemStack(ModItems.CAESIUM_NITRATE.get(), 1);
            ItemStack caesium_perchlorate = new ItemStack(ModItems.CAESIUM_PERCHLORATE.get(), 1);
            ItemStack caesium_carbonate = new ItemStack(ModItems.CAESIUM_CARBONATE.get(), 1);
            ItemStack caesium_bicarbonate = new ItemStack(ModItems.CAESIUM_BICARBONATE.get(), 1);
            ItemStack caesium_chromate = new ItemStack(ModItems.CAESIUM_CHROMATE.get(), 1);
            ItemStack caesium_acetate = new ItemStack(ModItems.CAESIUM_ACETATE.get(), 1);
            ItemStack caesium_formate = new ItemStack(ModItems.CAESIUM_FORMATE.get(), 1);
            ItemStack caesium_cyanide = new ItemStack(ModItems.CAESIUM_CYANIDE.get(), 1);
            ItemStack caesium_hydroxide = new ItemStack(ModItems.CAESIUM_HYDROXIDE.get(), 1);
            ItemStack rubidium_oxide = new ItemStack(ModItems.RUBIDIUM_OXIDE.get(), 1);
            ItemStack rubidium_fluoride = new ItemStack(ModItems.RUBIDIUM_FLUORIDE.get(), 1);
            ItemStack rubidium_sulfide = new ItemStack(ModItems.RUBIDIUM_SULFIDE.get(), 1);
            ItemStack rubidium_chloride= new ItemStack(ModItems.RUBIDIUM_CHLORIDE.get(), 1);
            ItemStack rubidium_bromide = new ItemStack(ModItems.RUBIDIUM_BROMIDE.get(), 1);
            ItemStack rubidium_iodide = new ItemStack(ModItems.RUBIDIUM_IODIDE.get(), 1);
            ItemStack rubidium_sulfate = new ItemStack(ModItems.RUBIDIUM_SULFATE.get(), 1);
            ItemStack rubidium_perchlorate = new ItemStack(ModItems.RUBIDIUM_PERCHLORATE.get(), 1);
            ItemStack rubidium_carbonate = new ItemStack(ModItems.RUBIDIUM_CARBONATE.get(), 1);
            ItemStack rubidium_acetate = new ItemStack(ModItems.RUBIDIUM_ACETATE.get(), 1);
            ItemStack rubidium_cyanide = new ItemStack(ModItems.RUBIDIUM_CYANIDE.get(), 1);
            ItemStack rubidium_hydroxide = new ItemStack(ModItems.RUBIDIUM_HYDROXIDE.get(), 1);
            ItemStack rubidium_permanganate = new ItemStack(ModItems.RUBIDIUM_PERMANGANATE.get(), 1);

            int villagerlevel = 1;

            //TODO: Add every salt lol
            //todo: Add every salt for each trade level
            //What should be currency?

            for(int i = 0; i < 5; i++) {
                //Novice ~12xp
                //I guess can only have 2 trades at this level at a given time? Can I adjust this?
                //Don't know but adding numbers = higher level of villager
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_sulfide, 64, 1, 0.02F));
            /* Comment in case sodium chloride no longer is the currency
            trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                    sodium_chloride, 64, 1, 0.02F));
             */
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_hydrogen_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_chlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_cyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        sodium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_hydrogen_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_chlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lithium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        beryllium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_hydrogen_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_chlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_cyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        calcium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_hydrogen_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_chlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_cyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        potassium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        aluminum_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_hydrogen_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_cyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        ammonium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        barium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_ii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        chromium_iii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_i_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        copper_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        iron_iii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        lead_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_thiosulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        magnesium_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_iii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_iii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_iii_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_iii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        manganese_iii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_i_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        mercury_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        nitronium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        nitronium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        nitronium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_nitrite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_chlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_hypochlorite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_iodate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        silver_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        strontium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_oxalate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_ii_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        tin_iv_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_nitride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_arsenite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_dihydrogen_phosphate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_sulfite, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_chlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_bromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_dichromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_thiocyanate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_peroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        zinc_permanganate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_arsenate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_nitrate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_bicarbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_chromate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_formate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        caesium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_oxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_fluoride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_sulfide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_chloride, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_bromide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_iodide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_sulfate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_perchlorate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_carbonate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_acetate, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_cyanide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_hydroxide, 64, 1, 0.02F));
                trades.get(villagerlevel+i).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SODIUM_CHLORIDE.get(), 2),
                        rubidium_permanganate, 64, 1, 0.02F));


            }



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
            //PotionBrewing.bootStrap().addMix(Potions.WEAKNESS, Items.REDSTONE, Potions.LONG_WEAKNESS);;

            if (event.player.tickCount % 2 == 0)
            {
                findBeakers(event.player);
            }
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
                //TODO: This is where flammability cod is ran
                if (event.player.tickCount % 20 == 0) {
                    flammableItemDetectedInInventory(event.player);
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

    //TODO: ADD A METHOD THAT DESTROYS FLAMMABLE CHEMS IF PLAYER ON FIRE done
    public static void flammableItemDetectedInInventory(Player player) {
        for (ItemStack stack : player.inventoryMenu.getItems()) {

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

            if (!stack.isEmpty() && stack.getItem().getClass() == ChemicalItem.class) {
                ChemicalItem chemicalItem = (ChemicalItem) stack.getItem();
                String[] SDSfragments = chemicalItem.getcSDS().split(",");

                for (String sds : SDSfragments) {
                    if (sds.equals("F") && player.isOnFire()) {
                        int count = stack.getCount();
                        if(count > 2)
                        {
                            stack = new ItemStack(chemicalItem, count - 1);
                            player.getInventory().items.set(slot,stack);
                        }
                        if (count <= 2)
                        {
                            stack = new ItemStack((Item)null);
                            player.getInventory().items.set(slot,stack);
                        }
                    }
                }


            }

        }
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

    //TODO: FIX DETECTION ON GROUND still impossible
    public static int radioactiveItemDetectedOnGround(Player player)
    {
        BlockPos pos = player.getOnPos();

        return 0;
    }

    //todo: freaks out with inventory sizes vvvvvv
    public static void findBeakers(Player player)
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
            //If needed
            //ForgeRegistries.ITEMS.getKey(stack.getItem()).getNamespace().equals("chemmod")
            if(stack.getItem().equals(ModItems.BEAKER.get().asItem()))
            {
                stack = rxns(stack, player);
                player.getInventory().items.set(slot,stack);
            }
        }
    }



    //vvv The logic for reactions in solution
    public static ItemStack rxns(ItemStack beaker, Player player)
    {
        CompoundTag nbt = beaker.getTag();
        if(nbt == null)
        {
            SolutionItem be = (SolutionItem) beaker.getItem();
            beaker = be.createNewBeaker();
            nbt = beaker.getTag();
        }

        String chem1 = nbt.getString("Chemical1Name");
        String chem2 = nbt.getString("Chemical2Name");
        String chem3 = nbt.getString("Chemical3Name");
        String chem4 = nbt.getString("Chemical4Name");
        String chem5 = nbt.getString("Chemical5Name");
        String chem6 = nbt.getString("Chemical6Name");
        String solv = nbt.getString("SolventName");
        Double chem1m = nbt.getDouble("Chemical1MoleAmount");
        Double chem2m = nbt.getDouble("Chemical2MoleAmount");
        Double chem3m = nbt.getDouble("Chemical3MoleAmount");
        Double chem4m = nbt.getDouble("Chemical4MoleAmount");
        Double chem5m = nbt.getDouble("Chemical5MoleAmount");
        Double chem6m = nbt.getDouble("Chemical6MoleAmount");
        Double solvm = nbt.getDouble("SolventMoleAmount");

        String[] chems = {chem1,chem2,chem3,chem4,chem5,chem6};


        if (solv.equals("Water"))
        {
            if(anyChemEquals(chems, "Sodium"))
            {
                explosiveRXN(player);
                return ItemStack.EMPTY;
            }
        }

        beaker.setTag(nbt);
        return beaker;
    }
    public static void explosiveRXN(Player player)
    {
        player.level.explode(player, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator)null, player.getX(), player.getY(), player.getZ(), 3.0f,false, Explosion.BlockInteraction.DESTROY);
        player.hurt(DamageSource.explosion(new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(),3.0f)), 20);
    }
    public static void destroyBeaker(Player player, ItemStack beaker)
    {

    }
    public static boolean anyChemEquals(String [] chems, String target)
    {
        for (int x = 0; x < chems.length; x++)
        {
            if (chems[x].equals(target))
                return true;
        }
        return false;
    }

    //^^^ Reaction Logic



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
                    String[] SDSfragments = chemicalItem.getcSDS().split(",");

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
                    //S1:explosive
                    //S2:nausea
                    //SA:nausea that lasts longer for alcohol
                    //S3:pyrophoric
                    //S4:shock sensitive
                    //SSp1:speed boost small
                    //SSp2:speed boost medium
                    //SSp3:speed boost large
                    //SM:medicine
                    //SG:growth stim for plants
                    //This works :)
                    for(String sds : SDSfragments)
                    {
                        //SPECIAL CASE
                        //Blows up player
                        if (sds.equals("S1")) {

                            player.level.explode(player, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator)null, player.getX(), player.getY(), player.getZ(), 3.0f,false, Explosion.BlockInteraction.DESTROY);
                            player.hurt(DamageSource.explosion(new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(),3.0f)), 20);

                        }
                        //SPECIAL CASE speed boost 1
                        //Grants speed boost. Rn for 3 seconds. I suspect 20 ticks = 1 s, so 60 = 3
                        if (sds.equals("SSp1")) {
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100,0));
                        }
                        //SPECIAL CASE speed boost 2
                        //Grants speed boost. Rn for 3 seconds. I suspect 20 ticks = 1 s, so 60 = 3
                        if (sds.equals("SSp2")) {
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200,1));
                        }
                        //SPECIAL CASE speed boost 3
                        //Grants speed boost. Rn for 3 seconds. I suspect 20 ticks = 1 s, so 60 = 3
                        if (sds.equals("SSp3")) {
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,600,2));
                        }
                        //SPECIAL CASE nausea
                        //Gives nausea debuff
                        if (sds.equals("S2")) {
                            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,200,2));
                        }
                        //SPECIAL CASE nausea but for alcohol
                        //Gives nausea debuff
                        if (sds.equals("SA")) {
                            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,600,2));
                        }
                        //SPECIAL CASE medicine
                        if (sds.equals("SM")) {
                            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 3));
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
        ModItems.registerCHEM();


    }










//END OF CODE
}
