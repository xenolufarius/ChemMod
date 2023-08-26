package net.claudio.chemmod.item;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.item.custom.DeconstructorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChemMod.MOD_ID);

    public static final RegistryObject<Item> CHEMICAL = Items.register( "chemical",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CHEMICAL2 = Items.register( "chemical2",
                () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> DECONSTRUCTOR = Items.register( "deconstructor",
                () -> new DeconstructorItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).stacksTo(1)));


    //Actual Items STart

    public static final RegistryObject<Item> HYDROGEN = Items.register( "hydrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 2, "H2", 1, 4, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is commonly referred to as Hydrogen Gas."));
    public static final RegistryObject<Item> HELIUM = Items.register( "helium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 4, "He", 3, 4, "\nDesc: Helium is the first of the noble gases, and is commonly found involved in the fusion reactions in the Sun."));
    public static final RegistryObject<Item> LITHIUM = Items.register( "lithium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BERYLLIUM = Items.register( "beryllium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BORON = Items.register( "boron",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CARBON = Items.register( "carbon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NITROGEN = Items.register( "nitrogen",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> OXYGEN = Items.register( "oxygen",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> FLUORINE = Items.register( "fluorine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NEON = Items.register( "neon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SODIUM = Items.register( "sodium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MAGNESIUM = Items.register( "magnesium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ALUMINUM = Items.register( "aluminum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SILICON = Items.register( "silicon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PHOSPHOROUS = Items.register( "phosphorous",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SULFUR = Items.register( "sulfur",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CHLORINE = Items.register( "chlorine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ARGON = Items.register( "argon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> POTASSIUM = Items.register( "potassium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CALCIUM = Items.register( "calcium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SCANDIUM = Items.register( "scandium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TITANIUM = Items.register( "titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> VANADIUM = Items.register( "vanadium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CHROMIUM = Items.register( "chromium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MANGANESE = Items.register( "manganese",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> IRON = Items.register( "iron",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> COBALT = Items.register( "cobalt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NICKEL = Items.register( "nickel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> COPPER = Items.register( "copper",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ZINC = Items.register( "zinc",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> GALLIUM = Items.register( "gallium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> GERMANIUM = Items.register( "germanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ARSENIC = Items.register( "arsenic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SELENIUM = Items.register( "selenium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BROMINE = Items.register( "bromine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> KRYPTON = Items.register( "krypton",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RUBIDIUM = Items.register( "rubidium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> STRONTIUM = Items.register( "strontium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> YTTRIUM = Items.register( "yttrium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM = Items.register( "zirconium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NIOBIUM = Items.register( "niobium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MOLYBDENUM = Items.register( "molybdenum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TECHNETIUM = Items.register( "technetium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RUTHENIUM = Items.register( "ruthenium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PALLADIUM = Items.register( "palladium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SILVER = Items.register( "silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CADMIUM = Items.register( "cadmium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> INDIUM = Items.register( "indium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TIN = Items.register( "tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ANTIMONY = Items.register( "antimony",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TELLURIUM = Items.register( "tellurium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> IODINE = Items.register( "iodine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> XENON = Items.register( "xenon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CESIUM = Items.register( "cesium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BARIUM = Items.register( "barium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> LANTHANUM = Items.register( "lanthanum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CERIUM = Items.register( "cerium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PRASEODYMIUM = Items.register( "praseodymium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NEODYMIUM = Items.register( "neodymium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PROMETHIUM = Items.register( "promethium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SAMARIUM = Items.register( "samarium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> EUROPIUM = Items.register( "europium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> GADOLINIUM = Items.register( "gadolinium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TERBIUM = Items.register( "terbium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> DYSPROSIUM = Items.register( "dysprosium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> HOLMIUM = Items.register( "holmium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ERBIUM = Items.register( "erbium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> THULIUM = Items.register( "thulium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> YTTERBIUM = Items.register( "ytterbium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> LUTETIUM = Items.register( "lutetium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> HAFNIUM = Items.register( "hafnium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TANTALUM = Items.register( "tantalum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TUNGSTEN = Items.register( "tungsten",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RHENIUM = Items.register( "rhenium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> OSMIUM = Items.register( "osmium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> IRIDIUM = Items.register( "iridium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PLATINUM = Items.register( "platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> GOLD = Items.register( "gold",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MERCURY = Items.register( "mercury",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> THALLIUM = Items.register( "thallium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> LEAD = Items.register( "lead",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BISMUTH = Items.register( "bismuth",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> POLONIUM = Items.register( "polonium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ASTATINE = Items.register( "astatine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RADON = Items.register( "radon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> FRANCIUM = Items.register( "francium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RADIUM = Items.register( "radium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ACTINIUM = Items.register( "actinium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> THORIUM = Items.register( "thorium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PROTACTINIUM = Items.register( "protactinium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> URANIUM = Items.register( "uranium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NEPTUNIUM = Items.register( "neptunium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> PLUTONIUM = Items.register( "plutonium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> AMERICIUM = Items.register( "americium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CURIUM = Items.register( "curium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BERKELIUM = Items.register( "berkelium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CALIFORNIUM = Items.register( "californium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> EINSTEINIUM = Items.register( "einsteinium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> FERMIUM = Items.register( "fermium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MENDELEVIUM = Items.register( "mendelevium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NOBELIUM = Items.register( "nobelium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> LAWRENCIUM = Items.register( "lawrencium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> RUTHERFORDIUM = Items.register( "rutherfordium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> DUBNIUM = Items.register( "dubnium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SEABORGIUM = Items.register( "seaborgium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> BOHRIUM = Items.register( "bohrium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> HASSIUM = Items.register( "hassium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MEITNERIUM = Items.register( "meitnerium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> DARMSTADTIUM = Items.register( "darmstadtium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> ROENTGENIUM = Items.register( "roentgenium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> COPERNICIUM = Items.register( "copernicium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> NIHONIUM = Items.register( "nihonium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> FLEROVIUM = Items.register( "flerovium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MOSCOVIUM = Items.register( "moscovium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> LIVERMORIUM = Items.register( "livermorium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> TENNESSINE = Items.register( "tennessine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> OGANESSON = Items.register( "oganesson",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));

    //Molecules
    public static final RegistryObject<Item> WATER = Items.register( "water",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> CARBON_DIOXIDE = Items.register( "carbon_dioxide",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> AMMONIA = Items.register( "ammonia",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> SODIUM_CHLORIDE = Items.register( "sodium_chloride",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> POTASSIUM_OXIDE = Items.register( "potassium_oxide",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = Items.register( "magnesium_oxide",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));


    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }



}
