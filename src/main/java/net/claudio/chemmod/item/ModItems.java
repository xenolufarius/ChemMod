package net.claudio.chemmod.item;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.item.custom.DeconstructorItem;
import net.minecraft.server.commands.KillCommand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.Event;
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

    //TODO: Solve mob effects for food consumption
    public static final RegistryObject<Item> HYDROGEN = Items.register( "hydrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(1).effect(new MobEffectInstance(MobEffects.WITHER,600,7),1f).build()), 2.02, "H2", 0, 4, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is commonly referred to as Hydrogen Gas."));
    public static final RegistryObject<Item> HELIUM = Items.register( "helium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 4.00, "He", 0, 4, "\nDesc: Helium is the first of the noble gases, and is commonly found involved in the fusion reactions in the Sun."));
    public static final RegistryObject<Item> LITHIUM = Items.register( "lithium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 6.94, "Li", 0, 1, "\nDesc: Lithium is a highly reactive metal and the lightest solid element. It's often used in batteries."));
    public static final RegistryObject<Item> BERYLLIUM = Items.register( "beryllium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 9.01, "Be", 0, 2, "\nDesc: Beryllium is a relatively stable metal known for its high melting point and use in various applications, including aerospace components."));
    public static final RegistryObject<Item> BORON = Items.register( "boron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 10.81, "B", 0, 4, "\nDesc: Boron is a nonmetallic element used in various industrial applications, including the production of ceramics and high-strength materials."));
    public static final RegistryObject<Item> CARBON = Items.register( "carbon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 12.01, "C", 0, 4, "\nDesc: Carbon is a versatile element that forms the basis of organic chemistry. It exists in various forms, including diamond and graphite."));
    public static final RegistryObject<Item> NITROGEN = Items.register( "nitrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 28.02, "N2", 0, 4, "\nDesc: Nitrogen is a diatomic gas (N2) and an essential element for life. It makes up a significant portion of Earth's atmosphere."));
    public static final RegistryObject<Item> OXYGEN = Items.register( "oxygen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 32.00, "O2", 0, 4, "\nDesc: Oxygen is a diatomic gas (O2) essential for respiration and combustion. It's the most abundant element in the Earth's crust."));
    public static final RegistryObject<Item> FLUORINE = Items.register( "fluorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 38.00, "F2", 0, 1, "\nDesc: Fluorine is a highly reactive diatomic gas (F2) known for its strong oxidizing properties. It's used in various industrial applications."));
    public static final RegistryObject<Item> NEON = Items.register( "neon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 20.18, "Ne", 0, 4, "\nDesc: Neon is a noble gas known for its bright and colorful light emission in neon signs. It's chemically inert and non-reactive."));
    public static final RegistryObject<Item> SODIUM = Items.register( "sodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 22.99, "Na", 0, 1, "\nDesc: Sodium is a highly reactive metal known for its vigorous reaction with water. It's commonly used in various chemical and industrial processes."));
    public static final RegistryObject<Item> MAGNESIUM = Items.register( "magnesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 24.31, "Mg", 0, 2, "\nDesc: Magnesium is a lightweight and strong metal used in various applications, including alloys and as a reducing agent in the production of metals."));
    public static final RegistryObject<Item> ALUMINUM = Items.register( "aluminum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 26.98, "Al", 0, 2, "\nDesc: Aluminum is a versatile metal used extensively in construction, transportation, and various industrial applications. It's known for its low density and corrosion resistance."));
    public static final RegistryObject<Item> SILICON = Items.register( "silicon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 28.09, "Si", 0, 4, "\nDesc: Silicon is a fundamental element in semiconductors and electronics. It's also a major component of Earth's crust and is used in various materials."));
    public static final RegistryObject<Item> PHOSPHORUS = Items.register( "phosphorus",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 30.97, "P", 0, 4, "\nDesc: Phosphorus is an essential element for life, found in DNA, RNA, and ATP. It's used in various industries, including fertilizers and detergents."));
    public static final RegistryObject<Item> SULFUR = Items.register( "sulfur",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 32.07, "S", 0, 4, "\nDesc: Sulfur is a non-metal essential for life and used in various industrial processes, including the production of sulfuric acid."));
    public static final RegistryObject<Item> CHLORINE = Items.register( "chlorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 70.91, "Cl2", 0, 4, "\nDesc: Chlorine is a highly reactive diatomic element used in disinfectants, plastics, and as a component of table salt (sodium chloride)."));
    public static final RegistryObject<Item> ARGON = Items.register( "argon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 39.95, "Ar", 0, 4, "\nDesc: Argon is a noble gas known for its inertness. It's used in various applications, including welding and lighting."));
    public static final RegistryObject<Item> POTASSIUM = Items.register( "potassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 39.10, "K", 0, 1, "\nDesc: Potassium is an essential mineral for plant and animal nutrition. It's highly reactive with water."));
    public static final RegistryObject<Item> CALCIUM = Items.register( "calcium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 40.08, "Ca", 0, 4, "\nDesc: Calcium is vital for the formation of bones and teeth. It's not highly reactive under normal conditions."));
    public static final RegistryObject<Item> SCANDIUM = Items.register( "scandium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 44.96, "Sc", 0, 4, "\nDesc: Scandium is a rare and moderately stable transition metal. It's used in aerospace and lighting applications."));
    public static final RegistryObject<Item> TITANIUM = Items.register( "titanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 47.87, "Ti", 0, 4, "\nDesc: Titanium is a strong and lightweight metal used in aerospace and medical implants."));
    public static final RegistryObject<Item> VANADIUM = Items.register( "vanadium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 50.94, "V", 0, 4, "\nDesc: Vanadium is a transition metal known for its strength and resistance to corrosion."));
    public static final RegistryObject<Item> CHROMIUM = Items.register( "chromium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 51.99, "Cr", 0, 4, "\nDesc: Chromium is used in stainless steel production and has a shiny, reflective surface."));
    public static final RegistryObject<Item> MANGANESE = Items.register( "manganese",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 54.94, "Mn", 0, 4, "\nDesc: Manganese is essential for steel production and is used in batteries."));
    public static final RegistryObject<Item> IRON = Items.register( "iron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 55.85, "Fe", 0, 4, "\nDesc: Iron is a crucial element in many industrial applications, including construction and transportation."));
    public static final RegistryObject<Item> COBALT = Items.register( "cobalt",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 58.93, "Co", 0, 4, "\nDesc: Cobalt is used in alloys, magnets, and medical devices due to its magnetic properties."));
    public static final RegistryObject<Item> NICKEL = Items.register( "nickel",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 58.69, "Ni", 0, 4, "\nDesc: Nickel is used in alloys, batteries, and as a protective coating for other metals."));
    public static final RegistryObject<Item> COPPER = Items.register( "copper",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 63.55, "Cu", 0, 4, "\nDesc: Copper is a highly conductive metal used in electrical wiring and various applications."));
    public static final RegistryObject<Item> ZINC = Items.register( "zinc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 65.38, "Zn", 0, 4, "\nDesc: Zinc is used in galvanizing, alloys, and as a dietary supplement."));
    public static final RegistryObject<Item> GALLIUM = Items.register( "gallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 69.72, "Ga", 0, 4, "\nDesc: Gallium is used in semiconductors and can melt in your hand due to its low melting point."));
    public static final RegistryObject<Item> GERMANIUM = Items.register( "germanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 72.63, "Ge", 0, 4, "\nDesc: Germanium is used in transistors and has semiconductor properties."));
    public static final RegistryObject<Item> ARSENIC = Items.register( "arsenic",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 74.92, "As", 0, 4, "\nDesc: Arsenic is known for its toxicity and is used in some electronic devices and semiconductors."));
    public static final RegistryObject<Item> SELENIUM = Items.register( "selenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 78.97, "Se", 0, 4, "\nDesc: Selenium is used in electronics and as a dietary supplement."));
    public static final RegistryObject<Item> BROMINE = Items.register( "bromine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 159.81, "Br2", 0, 4, "\nDesc: Bromine is a reddish-brown liquid at room temperature and is used in flame retardants."));
    public static final RegistryObject<Item> KRYPTON = Items.register( "krypton",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 83.80, "Kr", 0, 4, "\nDesc: Krypton is a noble gas used in lighting and lasers."));
    public static final RegistryObject<Item> RUBIDIUM = Items.register( "rubidium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 85.47, "Rb", 0, 2, "\nDesc: Rubidium is an alkali metal used in research and electronics."));
    public static final RegistryObject<Item> STRONTIUM = Items.register( "strontium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 87.62, "Sr", 0, 4, "\nDesc: Strontium is used in fireworks and flares to produce red colors."));
    public static final RegistryObject<Item> YTTRIUM = Items.register( "yttrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 88.91, "Y", 0, 4, "\nDesc: Yttrium is used in alloys and phosphors for color television tubes."));
    public static final RegistryObject<Item> ZIRCONIUM = Items.register( "zirconium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 91.22, "Zr", 0, 4, "\nDesc: Zirconium is used in nuclear reactors and as an alloying agent."));
    public static final RegistryObject<Item> NIOBIUM = Items.register( "niobium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 92.91, "Nb", 0, 4, "\nDesc: Niobium is used in superconductors and alloys for jet engines."));
    public static final RegistryObject<Item> MOLYBDENUM = Items.register( "molybdenum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 95.94, "Mo", 0, 4, "\nDesc: Molybdenum is used in steel alloys and as a catalyst in chemical reactions."));
    public static final RegistryObject<Item> TECHNETIUM = Items.register( "technetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 98.00, "Tc", 0, 4, "\nDesc: Technetium is a synthetic element used in medical imaging and research."));
    public static final RegistryObject<Item> RUTHENIUM = Items.register( "ruthenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 101.07, "Ru", 0, 4, "\nDesc: Ruthenium is used in electronics, catalysts, and jewelry for its durability."));
    public static final RegistryObject<Item> RHODIUM = Items.register( "rhodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 102.91, "Rh", 0, 4, "\nDesc: Rhodium is used in catalytic converters, jewelry, and electrical contacts."));
    public static final RegistryObject<Item> PALLADIUM = Items.register( "palladium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 106.42, "Pd", 0, 4, "\nDesc: Palladium is used in catalytic converters, electronics, and jewelry."));
    public static final RegistryObject<Item> SILVER = Items.register( "silver",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 107.87, "Ag", 0, 4, "\nDesc: Silver is valued for its use in currency, jewelry, and electronics."));
    public static final RegistryObject<Item> CADMIUM = Items.register( "cadmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 112.41, "Cd", 0, 4, "\nDesc: Cadmium is used in batteries, pigments, and nuclear reactors."));
    public static final RegistryObject<Item> INDIUM = Items.register( "indium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 114.82, "In", 0, 4, "\nDesc: Indium is used in semiconductors, solar panels, and as a solder."));
    public static final RegistryObject<Item> TIN = Items.register( "tin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 118.71, "Sn", 0, 4, "\nDesc: Tin is used in solder, coatings, and alloys."));
    public static final RegistryObject<Item> ANTIMONY = Items.register( "antimony",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 121.76, "Sb", 0, 4, "\nDesc: Antimony is used in flame retardants and alloys."));
    public static final RegistryObject<Item> TELLURIUM = Items.register( "tellurium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 127.60, "Te", 0, 4, "\nDesc: Tellurium is used in solar panels and alloys."));
    public static final RegistryObject<Item> IODINE = Items.register( "iodine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 253.81, "I2", 0, 4, "\nDesc: Iodine is commonly used in medicine, particularly in the form of iodine solutions for disinfection."));
    public static final RegistryObject<Item> XENON = Items.register( "xenon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 131.29, "Xe", 0, 4, "\nDesc: Xenon is employed in various applications, including lighting and anesthesia."));
    public static final RegistryObject<Item> CESIUM = Items.register( "cesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 132.91, "Cs", 0, 1, "\nDesc: Cesium has uses in atomic clocks and drilling fluids, but it requires careful handling due to its reactivity with air and water."));
    public static final RegistryObject<Item> BARIUM = Items.register( "barium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 137.33, "Ba", 0, 4, "\nDesc: Barium is employed in various industries, including the production of drilling fluids and glass."));
    public static final RegistryObject<Item> LANTHANUM = Items.register( "lanthanum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 138.91, "La", 0, 4, "\nDesc: Lanthanum is a rare earth element with various applications, including in catalysts and optics."));
    public static final RegistryObject<Item> CERIUM = Items.register( "cerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 140.12, "Ce", 0, 4, "\nDesc: Cerium is a rare earth metal known for its use in catalytic converters and in making glass."));
    public static final RegistryObject<Item> PRASEODYMIUM = Items.register( "praseodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 140.91, "Pr", 0, 4, "\nDesc: Praseodymium is a rare earth element used in magnets, lasers, and as a catalyst."));
    public static final RegistryObject<Item> NEODYMIUM = Items.register( "neodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 144.24, "Nd", 0, 4, "\nDesc: Neodymium is used in powerful magnets, lasers, and as a coloring agent in glasses and ceramics."));
    public static final RegistryObject<Item> PROMETHIUM = Items.register( "promethium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 145.00, "Pm", 3, 4, "\nDesc: Promethium is a radioactive rare earth element used in atomic batteries and luminous paints."));
    public static final RegistryObject<Item> SAMARIUM = Items.register( "samarium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 150.36, "Sm", 0, 4, "\nDesc: Samarium is used in magnets, nuclear reactors, and as a neutron absorber in control rods."));
    public static final RegistryObject<Item> EUROPIUM = Items.register( "europium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 152.00, "Eu", 3, 4, "\nDesc: Europium is a radioactive rare earth element used in phosphors for color displays and as a neutron absorber."));
    public static final RegistryObject<Item> GADOLINIUM = Items.register( "gadolinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 157.25, "Gd", 0, 4, "\nDesc: Gadolinium is used in MRI contrast agents, neutron capture therapy, and in fuel rods for nuclear reactors."));
    public static final RegistryObject<Item> TERBIUM = Items.register( "terbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 158.93, "Tb", 0, 4, "\nDesc: Terbium is used in phosphors for color displays and as a dopant in solid-state devices."));
    public static final RegistryObject<Item> DYSPROSIUM = Items.register( "dysprosium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 162.50, "Dy", 0, 4, "\nDesc: Dysprosium is used in permanent magnets, control rods for nuclear reactors, and in lighting applications."));
    public static final RegistryObject<Item> HOLMIUM = Items.register( "holmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 164.93, "Ho", 0, 4, "\nDesc: Holmium is used in lasers, control rods for nuclear reactors, and as a flux in certain types of iron and steel."));
    public static final RegistryObject<Item> ERBIUM = Items.register( "erbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 167.26, "Er", 0, 4, "\nDesc: Erbium is used in lasers, fiber optics, and as a neutron-absorbing control rod material in nuclear reactors."));
    public static final RegistryObject<Item> THULIUM = Items.register( "thulium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 168.93, "Tm", 0, 4, "\nDesc: Thulium is used in portable X-ray devices and as a dopant in some solid-state lasers."));
    public static final RegistryObject<Item> YTTERBIUM = Items.register( "ytterbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 173.05, "Yb", 0, 4, "\nDesc: Ytterbium is used in certain types of lasers, nuclear medicine, and as a dopant in fiber optic amplifiers."));
    public static final RegistryObject<Item> LUTETIUM = Items.register( "lutetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 175.94, "Lu", 0, 4, "\nDesc: Lutetium is used in certain types of radiation therapy for cancer treatment and as a catalyst in various chemical reactions."));
    public static final RegistryObject<Item> HAFNIUM = Items.register( "hafnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 178.49, "Hf", 0, 4, "\nDesc: Hafnium is used in nuclear reactors as control rods, in semiconductor manufacturing, and as an alloying agent in superalloys."));
    public static final RegistryObject<Item> TANTALUM = Items.register( "tantalum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 180.95, "Ta", 0, 4, "\nDesc: Tantalum is used in electronics, aircraft, and medical implants due to its corrosion resistance and high melting point."));
    public static final RegistryObject<Item> TUNGSTEN = Items.register( "tungsten",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 183.84, "W", 0, 4, "\nDesc: Tungsten has the highest melting point of all elements and is used in various applications, including light bulb filaments and aerospace components."));
    public static final RegistryObject<Item> RHENIUM = Items.register( "rhenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 186.21, "Re", 0, 4, "\nDesc: Rhenium is used in high-temperature superalloys for jet engines and in the production of filaments for mass spectrometry and X-ray tubes."));
    public static final RegistryObject<Item> OSMIUM = Items.register( "osmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 190.23, "Os", 0, 4, "\nDesc: Osmium is the densest naturally occurring element and is used in fountain pen tips, electrical contacts, and as an alloying agent in the platinum industry."));
    public static final RegistryObject<Item> IRIDIUM = Items.register( "iridium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 192.22, "Ir", 0, 4, "\nDesc: Iridium is known for its high density and is used in spark plugs, electrical contacts, and in the manufacture of crucibles and other equipment that must withstand high temperatures."));
    public static final RegistryObject<Item> PLATINUM = Items.register( "platinum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 195.08, "Pt", 0, 4, "\nDesc: Platinum is valued for its use in jewelry, catalytic converters, and as a standard for measuring mass and weight in the metric system."));
    public static final RegistryObject<Item> GOLD = Items.register( "gold",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 196.97, "Au", 0, 4, "\nDesc: Gold is known for its beauty and is used in jewelry, coinage, and electronics. It does not tarnish and is an excellent conductor of electricity."));
    public static final RegistryObject<Item> MERCURY = Items.register( "mercury",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 200.59, "Hg", 0, 4, "\nDesc: Mercury is a unique metal that is liquid at room temperature. It has been used in thermometers, barometers, and dental fillings, although its use is declining due to its toxicity."));
    public static final RegistryObject<Item> THALLIUM = Items.register( "thallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 204.38, "Tl", 1, 4, "\nDesc: Thallium is a toxic metal that has various industrial applications."));
    public static final RegistryObject<Item> LEAD = Items.register( "lead",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 207.2, "Pb", 0, 4, "\nDesc: Lead is a dense metal commonly used in construction and batteries."));
    public static final RegistryObject<Item> BISMUTH = Items.register( "bismuth",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 208.98, "Bi", 0, 4, "\nDesc: Bismuth is a heavy metal often used in pharmaceuticals and cosmetics."));
    public static final RegistryObject<Item> POLONIUM = Items.register( "polonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 208.98, "Po", 2, 4, "\nDesc: Polonium is a highly radioactive element, and its most common isotope is extremely toxic."));
    public static final RegistryObject<Item> ASTATINE = Items.register( "astatine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 210.00, "At", 3, 0, "\nDesc: Astatine is a rare and highly radioactive element with no stable isotopes."));
    public static final RegistryObject<Item> RADON = Items.register( "radon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 222.00, "Rn", 3, 4, "\nDesc: Radon is a colorless, odorless, and highly radioactive noble gas that poses health risks when inhaled."));
    public static final RegistryObject<Item> FRANCIUM = Items.register( "francium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 223.00, "Fr", 4, 0, "\nDesc: Francium is an extremely rare and highly radioactive element, often considered the rarest naturally occurring element on Earth."));
    public static final RegistryObject<Item> RADIUM = Items.register( "radium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 226.00, "Ra", 3, 2, "\nDesc: Radium is a highly radioactive element known for its luminescence and was once used in glow-in-the-dark paint."));
    public static final RegistryObject<Item> ACTINIUM = Items.register( "actinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 227.00, "Ac", 3, 2, "\nDesc: Actinium is a highly radioactive element often used in radiation therapy for cancer treatment."));
    public static final RegistryObject<Item> THORIUM = Items.register( "thorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 232.04, "Th", 4, 2, "\nDesc: Thorium is a radioactive element with applications in nuclear reactors and potential as a nuclear fuel."));
    public static final RegistryObject<Item> PROTACTINIUM = Items.register( "protactinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 231.04, "Pa", 3, 2, "\nDesc: Protactinium is a radioactive element with limited practical uses but plays a role in the decay chain of uranium."));
    public static final RegistryObject<Item> URANIUM = Items.register( "uranium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 238.03, "U", 4, 2, "\nDesc: Uranium is a radioactive element with applications in nuclear reactors, nuclear weapons, and as a fuel in nuclear power."));
    public static final RegistryObject<Item> NEPTUNIUM = Items.register( "neptunium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 237.00, "Np", 3, 2, "\nDesc: Neptunium is a radioactive element used in nuclear reactors and has potential applications in nuclear weapons."));
    public static final RegistryObject<Item> PLUTONIUM = Items.register( "plutonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 244.00, "Pu", 3, 2, "\nDesc: Plutonium is a radioactive element used in nuclear reactors, nuclear weapons, and as a fuel in nuclear power."));
    public static final RegistryObject<Item> AMERICIUM = Items.register( "americium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 243.00, "Am", 3, 2, "\nDesc: Americium is a radioactive element used in smoke detectors and some nuclear reactors."));
    public static final RegistryObject<Item> CURIUM = Items.register( "curium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 247.00, "Cm", 3, 2, "\nDesc: Curium is a radioactive element used in the production of neutron sources and some types of nuclear reactors."));
    public static final RegistryObject<Item> BERKELIUM = Items.register( "berkelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 247.00, "Bk", 3, 2, "\nDesc: Berkelium is a radioactive element used in the synthesis of heavier elements and scientific research."));
    public static final RegistryObject<Item> CALIFORNIUM = Items.register( "californium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 251.00, "Cf", 3, 2, "\nDesc: Californium is a radioactive element used in neutron sources and as a target in nuclear physics experiments."));
    public static final RegistryObject<Item> EINSTEINIUM = Items.register( "einsteinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 252.00, "Es", 3, 2, "\nDesc: Einsteinium is a highly radioactive element used in scientific research and the production of heavier elements."));
    public static final RegistryObject<Item> FERMIUM = Items.register( "fermium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 257.00, "Fm", 3, 2, "\nDesc: Fermium is a highly radioactive element used in scientific research and the production of heavier elements."));
    public static final RegistryObject<Item> MENDELEVIUM = Items.register( "mendelevium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 258.00, "Md", 4, 2, "\nDesc: Mendelevium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> NOBELIUM = Items.register( "nobelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 259.00, "No", 4, 0, "\nDesc: Nobelium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> LAWRENCIUM = Items.register( "lawrencium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 266.00, "Lr", 4, 0, "\nDesc: Lawrencium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> RUTHERFORDIUM = Items.register( "rutherfordium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 267.00, "Rf", 4, 0, "\nDesc: Rutherfordium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> DUBNIUM = Items.register( "dubnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 268.00, "Db", 4, 0, "\nDesc: Dubnium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> SEABORGIUM = Items.register( "seaborgium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 269.00, "Sg", 4, 0, "\nDesc: Seaborgium is a radioactive element used in nuclear research and the synthesis of heavier elements."));
    public static final RegistryObject<Item> BOHRIUM = Items.register( "bohrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 270.134, "Bh", 4, 0, "\nDesc: A highly radioactive element with an exceptionally short half-life measured in milliseconds. Bohrium is synthesized in particle accelerators and is crucial for the study of nuclear physics and the formation of superheavy elements."));
    public static final RegistryObject<Item> HASSIUM = Items.register( "hassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 277.152, "Hs", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Hassium is synthesized in laboratories and contributes to the exploration of nuclear physics and superheavy elements."));
    public static final RegistryObject<Item> MEITNERIUM = Items.register( "meitnerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 278.156, "Mt", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Meitnerium is produced in particle accelerators and aids in the exploration of nuclear physics and superheavy elements."));
    public static final RegistryObject<Item> DARMSTADTIUM = Items.register( "darmstadtium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 281.162, "Ds", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Darmstadtium is produced in controlled laboratory environments and plays a critical role in advancing nuclear physics research and the understanding of superheavy elements."));
    public static final RegistryObject<Item> ROENTGENIUM = Items.register( "roentgenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 282.166, "Rg", 4, 0, "\nDesc: An extremely radioactive element with an incredibly short half-life measured in milliseconds. Roentgenium is synthesized in particle accelerators and is invaluable for nuclear physics research and superheavy element studies."));
    public static final RegistryObject<Item> COPERNICIUM = Items.register( "copernicium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 285.178, "Cn", 4, 0, "\nDesc: A highly radioactive element with a brief half-life measured in milliseconds. Copernicium is created in controlled laboratory environments and contributes to advances in nuclear physics and superheavy element investigations."));
    public static final RegistryObject<Item> NIHONIUM = Items.register( "nihonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 286.190, "Nh", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Nihonium is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies."));
    public static final RegistryObject<Item> FLEROVIUM = Items.register( "flerovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 289.193, "Fl", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Flerovium is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations."));
    public static final RegistryObject<Item> MOSCOVIUM = Items.register( "moscovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 290.196, "Mc", 4, 0, "\nDesc: An extremely radioactive element with an exceptionally brief half-life measured in milliseconds. Moscovium is produced in particle accelerators and plays a crucial role in nuclear physics research and superheavy element investigations."));
    public static final RegistryObject<Item> LIVERMORIUM = Items.register( "livermorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 293.205, "Lv", 4, 0, "\nDesc: An extremely radioactive element with an exceedingly short half-life measured in milliseconds. Livermorium is created in controlled laboratory environments and contributes significantly to nuclear physics research and superheavy element studies."));
    public static final RegistryObject<Item> TENNESSINE = Items.register( "tennessine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 294.211, "Ts", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Tennessine is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies."));
    public static final RegistryObject<Item> OGANESSON = Items.register( "oganesson",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB), 294.214, "Og", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Oganesson is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations."));

    //Molecules
    public static final RegistryObject<Item> WATER = Items.register( "water",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));
    public static final RegistryObject<Item> CARBON_DIOXIDE = Items.register( "carbon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));
    public static final RegistryObject<Item> AMMONIA = Items.register( "ammonia",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));
    public static final RegistryObject<Item> SODIUM_CHLORIDE = Items.register( "sodium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));
    public static final RegistryObject<Item> POTASSIUM_OXIDE = Items.register( "potassium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = Items.register( "magnesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB),0,"",0,4,"\n"));


    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }



}
