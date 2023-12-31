package net.claudio.chemmod.screen;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.custom.LabTableBlock;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChemMod.MOD_ID);

    public static final RegistryObject<MenuType<DeconstructorBlockMenu>> DECONSTRUCTOR_BLOCK_MENU =
            registerMenuType(DeconstructorBlockMenu::new, "deconstructor_block_menu");
    public static final RegistryObject<MenuType<RadicalizerBlockMenu>> RADICALIZER_BLOCK_MENU =
            registerMenuType(RadicalizerBlockMenu::new, "radicalizer_block_menu");
    public static final RegistryObject<MenuType<LabTableBlockMenu>> LAB_TABLE_BLOCK_MENU =
            registerMenuType(LabTableBlockMenu::new, "lab_table_block_menu");

    public static final RegistryObject<MenuType<ReconstructorBlockMenu>> RECONSTRUCTOR_BLOCK_MENU =
            registerMenuType(ReconstructorBlockMenu::new, "reconstructor_block_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}