package net.claudio.chemmod;

import com.mojang.logging.LogUtils;
import net.claudio.chemmod.block.ModBlocks;
import net.claudio.chemmod.block.entity.ModBlockEntities;
import net.claudio.chemmod.effect.ModEffects;
import net.claudio.chemmod.item.ModItems;
import net.claudio.chemmod.networking.ModMessages;
import net.claudio.chemmod.painting.ModPaintings;
import net.claudio.chemmod.recipe.ModRecipes;
import net.claudio.chemmod.screen.DeconstructorBlockScreen;
import net.claudio.chemmod.screen.LabTableBlockScreen;
import net.claudio.chemmod.screen.ModMenuTypes;
import net.claudio.chemmod.screen.RadicalizerBlockScreen;
import net.claudio.chemmod.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ChemMod.MOD_ID)
public class ChemMod
{
    public static final String MOD_ID = "chemmod";
    private static final Logger LOGGER = LogUtils.getLogger();// Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public ChemMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register((modEventBus));
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);


        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
           ModMessages.register();
           ModVillagers.registerPOIs();
        });

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.DECONSTRUCTOR_BLOCK_MENU.get(), DeconstructorBlockScreen::new);
            MenuScreens.register(ModMenuTypes.RADICALIZER_BLOCK_MENU.get(), RadicalizerBlockScreen::new);
            MenuScreens.register(ModMenuTypes.LAB_TABLE_BLOCK_MENU.get(), LabTableBlockScreen::new);

        }
    }
}
