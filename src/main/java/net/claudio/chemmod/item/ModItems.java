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
    //TODO: convert to ChemicalItem
    //TODO: Change AMU to be Double or Float. I want to have to 2 decimal places, when rounding is not feasible.

    public static final RegistryObject<Item> HYDROGEN = Items.register( "hydrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 2, "H2", 0, 4, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is commonly referred to as Hydrogen Gas."));
    public static final RegistryObject<Item> HELIUM = Items.register( "helium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 4, "He", 0, 4, "\nDesc: Helium is the first of the noble gases, and is commonly found involved in the fusion reactions in the Sun."));
    public static final RegistryObject<Item> LITHIUM = Items.register( "lithium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 7, "Li", 0, 1, "\nDesc: Lithium is a highly reactive metal and the lightest solid element. It's often used in batteries."));
    public static final RegistryObject<Item> BERYLLIUM = Items.register( "beryllium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 9, "Be", 0, 2, "\nDesc: Beryllium is a relatively stable metal known for its high melting point and use in various applications, including aerospace components."));
    public static final RegistryObject<Item> BORON = Items.register( "boron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 10, "B", 0, 4, "\nDesc: Boron is a nonmetallic element used in various industrial applications, including the production of ceramics and high-strength materials."));
    public static final RegistryObject<Item> CARBON = Items.register( "carbon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NITROGEN = Items.register( "nitrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> OXYGEN = Items.register( "oxygen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> FLUORINE = Items.register( "fluorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NEON = Items.register( "neon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SODIUM = Items.register( "sodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MAGNESIUM = Items.register( "magnesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ALUMINUM = Items.register( "aluminum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SILICON = Items.register( "silicon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PHOSPHOROUS = Items.register( "phosphorous",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SULFUR = Items.register( "sulfur",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CHLORINE = Items.register( "chlorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ARGON = Items.register( "argon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> POTASSIUM = Items.register( "potassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CALCIUM = Items.register( "calcium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SCANDIUM = Items.register( "scandium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TITANIUM = Items.register( "titanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> VANADIUM = Items.register( "vanadium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CHROMIUM = Items.register( "chromium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MANGANESE = Items.register( "manganese",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> IRON = Items.register( "iron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> COBALT = Items.register( "cobalt",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NICKEL = Items.register( "nickel",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> COPPER = Items.register( "copper",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ZINC = Items.register( "zinc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> GALLIUM = Items.register( "gallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> GERMANIUM = Items.register( "germanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ARSENIC = Items.register( "arsenic",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SELENIUM = Items.register( "selenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> BROMINE = Items.register( "bromine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> KRYPTON = Items.register( "krypton",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RUBIDIUM = Items.register( "rubidium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> STRONTIUM = Items.register( "strontium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> YTTRIUM = Items.register( "yttrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ZIRCONIUM = Items.register( "zirconium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NIOBIUM = Items.register( "niobium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MOLYBDENUM = Items.register( "molybdenum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TECHNETIUM = Items.register( "technetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RUTHENIUM = Items.register( "ruthenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PALLADIUM = Items.register( "palladium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SILVER = Items.register( "silver",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CADMIUM = Items.register( "cadmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> INDIUM = Items.register( "indium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TIN = Items.register( "tin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ANTIMONY = Items.register( "antimony",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TELLURIUM = Items.register( "tellurium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> IODINE = Items.register( "iodine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> XENON = Items.register( "xenon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CESIUM = Items.register( "cesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> BARIUM = Items.register( "barium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> LANTHANUM = Items.register( "lanthanum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CERIUM = Items.register( "cerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PRASEODYMIUM = Items.register( "praseodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NEODYMIUM = Items.register( "neodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PROMETHIUM = Items.register( "promethium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SAMARIUM = Items.register( "samarium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> EUROPIUM = Items.register( "europium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> GADOLINIUM = Items.register( "gadolinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TERBIUM = Items.register( "terbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> DYSPROSIUM = Items.register( "dysprosium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> HOLMIUM = Items.register( "holmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ERBIUM = Items.register( "erbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> THULIUM = Items.register( "thulium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> YTTERBIUM = Items.register( "ytterbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> LUTETIUM = Items.register( "lutetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> HAFNIUM = Items.register( "hafnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TANTALUM = Items.register( "tantalum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TUNGSTEN = Items.register( "tungsten",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RHENIUM = Items.register( "rhenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> OSMIUM = Items.register( "osmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> IRIDIUM = Items.register( "iridium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PLATINUM = Items.register( "platinum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> GOLD = Items.register( "gold",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MERCURY = Items.register( "mercury",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> THALLIUM = Items.register( "thallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> LEAD = Items.register( "lead",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> BISMUTH = Items.register( "bismuth",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> POLONIUM = Items.register( "polonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ASTATINE = Items.register( "astatine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RADON = Items.register( "radon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> FRANCIUM = Items.register( "francium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RADIUM = Items.register( "radium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ACTINIUM = Items.register( "actinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> THORIUM = Items.register( "thorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PROTACTINIUM = Items.register( "protactinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> URANIUM = Items.register( "uranium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NEPTUNIUM = Items.register( "neptunium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> PLUTONIUM = Items.register( "plutonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> AMERICIUM = Items.register( "americium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CURIUM = Items.register( "curium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> BERKELIUM = Items.register( "berkelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CALIFORNIUM = Items.register( "californium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> EINSTEINIUM = Items.register( "einsteinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> FERMIUM = Items.register( "fermium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MENDELEVIUM = Items.register( "mendelevium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NOBELIUM = Items.register( "nobelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> LAWRENCIUM = Items.register( "lawrencium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> RUTHERFORDIUM = Items.register( "rutherfordium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> DUBNIUM = Items.register( "dubnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SEABORGIUM = Items.register( "seaborgium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> BOHRIUM = Items.register( "bohrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> HASSIUM = Items.register( "hassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MEITNERIUM = Items.register( "meitnerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> DARMSTADTIUM = Items.register( "darmstadtium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> ROENTGENIUM = Items.register( "roentgenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> COPERNICIUM = Items.register( "copernicium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> NIHONIUM = Items.register( "nihonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> FLEROVIUM = Items.register( "flerovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MOSCOVIUM = Items.register( "moscovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> LIVERMORIUM = Items.register( "livermorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> TENNESSINE = Items.register( "tennessine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> OGANESSON = Items.register( "oganesson",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));

    //Molecules
    public static final RegistryObject<Item> WATER = Items.register( "water",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> CARBON_DIOXIDE = Items.register( "carbon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> AMMONIA = Items.register( "ammonia",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> SODIUM_CHLORIDE = Items.register( "sodium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> POTASSIUM_OXIDE = Items.register( "potassium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = Items.register( "magnesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,0,"\n"));


    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }



}
