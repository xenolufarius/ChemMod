package net.claudio.chemmod.item;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.effect.ModEffects;

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

import java.util.function.Supplier;

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
    //TODO: convert to ChemicalItem Done
    //TODO: Change AMU to be Double or Float. I want to have to 2 decimal places, when rounding is not feasible. Done

    //TODO: Solve mob effects for food consumption. Solved kinda. Need to give all food properties now. Done
    //TODO: Maybe Change FOOD param to be more flexible and include SDS pictograms. Done
    //TODO: Update SDS to reflect new system Done
    //TODO: Recipes, STAB, Villagers (Mostly done. Need to refine later), PNG files (DONE)
    //.food(new FoodProperties.Builder().nutrition(1).effect(new MobEffectInstance(MobEffects.WITHER,600,7),1f).build())
    public static final RegistryObject<Item> HYDROGEN = Items.register( "hydrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 1.01, "H", 0, 4, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is commonly referred to as Hydrogen Gas.","T"));
    public static final RegistryObject<Item> HELIUM = Items.register( "helium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 4.00, "He", 0, 4, "\nDesc: Helium is the first of the noble gases, and is commonly found involved in the fusion reactions in the Sun.","T"));
    public static final RegistryObject<Item> LITHIUM = Items.register( "lithium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 6.94, "Li", 0, 1, "\nDesc: Lithium is a highly reactive metal and the lightest solid element. It's often used in batteries.","T"));
    public static final RegistryObject<Item> BERYLLIUM = Items.register( "beryllium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 9.01, "Be", 0, 2, "\nDesc: Beryllium is a relatively stable metal known for its high melting point and use in various applications, including aerospace components.","T"));
    public static final RegistryObject<Item> BORON = Items.register( "boron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 10.81, "B", 0, 4, "\nDesc: Boron is a nonmetallic element used in various industrial applications, including the production of ceramics and high-strength materials.","T"));
    public static final RegistryObject<Item> CARBON = Items.register( "carbon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 12.01, "C", 0, 4, "\nDesc: Carbon is a versatile element that forms the basis of organic chemistry. It exists in various forms, including diamond and graphite.","T"));
    public static final RegistryObject<Item> NITROGEN = Items.register( "nitrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 14.01, "N", 0, 4, "\nDesc: Nitrogen is a diatomic gas (N2) and an essential element for life. It makes up a significant portion of Earth's atmosphere.","T"));
    public static final RegistryObject<Item> OXYGEN = Items.register( "oxygen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 16.00, "O", 0, 4, "\nDesc: Oxygen is a diatomic gas (O2) essential for respiration and combustion. It's the most abundant element in the Earth's crust.","T"));
    public static final RegistryObject<Item> FLUORINE = Items.register( "fluorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 19.00, "F", 0, 1, "\nDesc: Fluorine is a highly reactive diatomic gas (F2) known for its strong oxidizing properties. It's used in various industrial applications.","T"));
    public static final RegistryObject<Item> NEON = Items.register( "neon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 20.18, "Ne", 0, 4, "\nDesc: Neon is a noble gas known for its bright and colorful light emission in neon signs. It's chemically inert and non-reactive.","T"));
    public static final RegistryObject<Item> SODIUM = Items.register( "sodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 22.99, "Na", 0, 1, "\nDesc: Sodium is a highly reactive metal known for its vigorous reaction with water. It's commonly used in various chemical and industrial processes.","T"));
    public static final RegistryObject<Item> MAGNESIUM = Items.register( "magnesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 24.31, "Mg", 0, 2, "\nDesc: Magnesium is a lightweight and strong metal used in various applications, including alloys and as a reducing agent in the production of metals.","T"));
    public static final RegistryObject<Item> ALUMINUM = Items.register( "aluminum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 26.98, "Al", 0, 2, "\nDesc: Aluminum is a versatile metal used extensively in construction, transportation, and various industrial applications. It's known for its low density and corrosion resistance.","T"));
    public static final RegistryObject<Item> SILICON = Items.register( "silicon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 28.09, "Si", 0, 4, "\nDesc: Silicon is a fundamental element in semiconductors and electronics. It's also a major component of Earth's crust and is used in various materials.","T"));
    public static final RegistryObject<Item> PHOSPHORUS = Items.register( "phosphorus",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 30.97, "P", 0, 4, "\nDesc: Phosphorus is an essential element for life, found in DNA, RNA, and ATP. It's used in various industries, including fertilizers and detergents.","T"));
    public static final RegistryObject<Item> SULFUR = Items.register( "sulfur",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 32.07, "S", 0, 4, "\nDesc: Sulfur is a non-metal essential for life and used in various industrial processes, including the production of sulfuric acid.","T"));
    public static final RegistryObject<Item> CHLORINE = Items.register( "chlorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 35.45, "Cl", 0, 4, "\nDesc: Chlorine is a highly reactive diatomic element used in disinfectants, plastics, and as a component of table salt (sodium chloride).","T"));
    public static final RegistryObject<Item> ARGON = Items.register( "argon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 39.95, "Ar", 0, 4, "\nDesc: Argon is a noble gas known for its inertness. It's used in various applications, including welding and lighting.","T"));
    public static final RegistryObject<Item> POTASSIUM = Items.register( "potassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 39.10, "K", 0, 1, "\nDesc: Potassium is an essential mineral for plant and animal nutrition. It's highly reactive with water.","S1"));
    public static final RegistryObject<Item> CALCIUM = Items.register( "calcium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 40.08, "Ca", 0, 4, "\nDesc: Calcium is vital for the formation of bones and teeth. It's not highly reactive under normal conditions.","T"));
    public static final RegistryObject<Item> SCANDIUM = Items.register( "scandium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 44.96, "Sc", 0, 4, "\nDesc: Scandium is a rare and moderately stable transition metal. It's used in aerospace and lighting applications.","T"));
    public static final RegistryObject<Item> TITANIUM = Items.register( "titanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 47.87, "Ti", 0, 4, "\nDesc: Titanium is a strong and lightweight metal used in aerospace and medical implants.","T"));
    public static final RegistryObject<Item> VANADIUM = Items.register( "vanadium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 50.94, "V", 0, 4, "\nDesc: Vanadium is a transition metal known for its strength and resistance to corrosion.","T"));
    public static final RegistryObject<Item> CHROMIUM = Items.register( "chromium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 51.99, "Cr", 0, 4, "\nDesc: Chromium is used in stainless steel production and has a shiny, reflective surface.","T"));
    public static final RegistryObject<Item> MANGANESE = Items.register( "manganese",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 54.94, "Mn", 0, 4, "\nDesc: Manganese is essential for steel production and is used in batteries.","T"));
    public static final RegistryObject<Item> IRON = Items.register( "iron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 55.85, "Fe", 0, 4, "\nDesc: Iron is a crucial element in many industrial applications, including construction and transportation.","T"));
    public static final RegistryObject<Item> COBALT = Items.register( "cobalt",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 58.93, "Co", 0, 4, "\nDesc: Cobalt is used in alloys, magnets, and medical devices due to its magnetic properties.","T"));
    public static final RegistryObject<Item> NICKEL = Items.register( "nickel",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 58.69, "Ni", 0, 4, "\nDesc: Nickel is used in alloys, batteries, and as a protective coating for other metals.","T"));
    public static final RegistryObject<Item> COPPER = Items.register( "copper",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 63.55, "Cu", 0, 4, "\nDesc: Copper is a highly conductive metal used in electrical wiring and various applications.","T"));
    public static final RegistryObject<Item> ZINC = Items.register( "zinc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 65.38, "Zn", 0, 4, "\nDesc: Zinc is used in galvanizing, alloys, and as a dietary supplement.","T"));
    public static final RegistryObject<Item> GALLIUM = Items.register( "gallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 69.72, "Ga", 0, 4, "\nDesc: Gallium is used in semiconductors and can melt in your hand due to its low melting point.","T"));
    public static final RegistryObject<Item> GERMANIUM = Items.register( "germanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 72.63, "Ge", 0, 4, "\nDesc: Germanium is used in transistors and has semiconductor properties.","T"));
    public static final RegistryObject<Item> ARSENIC = Items.register( "arsenic",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 74.92, "As", 0, 4, "\nDesc: Arsenic is known for its toxicity and is used in some electronic devices and semiconductors.","T"));
    public static final RegistryObject<Item> SELENIUM = Items.register( "selenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 78.97, "Se", 0, 4, "\nDesc: Selenium is used in electronics and as a dietary supplement.","T"));
    public static final RegistryObject<Item> BROMINE = Items.register( "bromine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 79.90, "Br", 0, 4, "\nDesc: Bromine is a reddish-brown liquid at room temperature and is used in flame retardants.","T"));
    public static final RegistryObject<Item> KRYPTON = Items.register( "krypton",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 83.80, "Kr", 0, 4, "\nDesc: Krypton is a noble gas used in lighting and lasers.","T"));
    public static final RegistryObject<Item> RUBIDIUM = Items.register( "rubidium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 85.47, "Rb", 0, 2, "\nDesc: Rubidium is an alkali metal used in research and electronics.","T"));
    public static final RegistryObject<Item> STRONTIUM = Items.register( "strontium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 87.62, "Sr", 0, 4, "\nDesc: Strontium is used in fireworks and flares to produce red colors.","T"));
    public static final RegistryObject<Item> YTTRIUM = Items.register( "yttrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 88.91, "Y", 0, 4, "\nDesc: Yttrium is used in alloys and phosphors for color television tubes.","T"));
    public static final RegistryObject<Item> ZIRCONIUM = Items.register( "zirconium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 91.22, "Zr", 0, 4, "\nDesc: Zirconium is used in nuclear reactors and as an alloying agent.","T"));
    public static final RegistryObject<Item> NIOBIUM = Items.register( "niobium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 92.91, "Nb", 0, 4, "\nDesc: Niobium is used in superconductors and alloys for jet engines.","T"));
    public static final RegistryObject<Item> MOLYBDENUM = Items.register( "molybdenum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 95.94, "Mo", 0, 4, "\nDesc: Molybdenum is used in steel alloys and as a catalyst in chemical reactions.","T"));
    public static final RegistryObject<Item> TECHNETIUM = Items.register( "technetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 98.00, "Tc", 0, 4, "\nDesc: Technetium is a synthetic element used in medical imaging and research.","T"));
    public static final RegistryObject<Item> RUTHENIUM = Items.register( "ruthenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 101.07, "Ru", 0, 4, "\nDesc: Ruthenium is used in electronics, catalysts, and jewelry for its durability.","T"));
    public static final RegistryObject<Item> RHODIUM = Items.register( "rhodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 102.91, "Rh", 0, 4, "\nDesc: Rhodium is used in catalytic converters, jewelry, and electrical contacts.","T"));
    public static final RegistryObject<Item> PALLADIUM = Items.register( "palladium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 106.42, "Pd", 0, 4, "\nDesc: Palladium is used in catalytic converters, electronics, and jewelry.","T"));
    public static final RegistryObject<Item> SILVER = Items.register( "silver",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 107.87, "Ag", 0, 4, "\nDesc: Silver is valued for its use in currency, jewelry, and electronics.","T"));
    public static final RegistryObject<Item> CADMIUM = Items.register( "cadmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 112.41, "Cd", 0, 4, "\nDesc: Cadmium is used in batteries, pigments, and nuclear reactors.","T"));
    public static final RegistryObject<Item> INDIUM = Items.register( "indium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 114.82, "In", 0, 4, "\nDesc: Indium is used in semiconductors, solar panels, and as a solder.","T"));
    public static final RegistryObject<Item> TIN = Items.register( "tin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 118.71, "Sn", 0, 4, "\nDesc: Tin is used in solder, coatings, and alloys.","T"));
    public static final RegistryObject<Item> ANTIMONY = Items.register( "antimony",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 121.76, "Sb", 0, 4, "\nDesc: Antimony is used in flame retardants and alloys.","T"));
    public static final RegistryObject<Item> TELLURIUM = Items.register( "tellurium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 127.60, "Te", 0, 4, "\nDesc: Tellurium is used in solar panels and alloys.","T"));
    public static final RegistryObject<Item> IODINE = Items.register( "iodine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 126.90, "I", 0, 4, "\nDesc: Iodine is commonly used in medicine, particularly in the form of iodine solutions for disinfection.","T"));
    public static final RegistryObject<Item> XENON = Items.register( "xenon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 131.29, "Xe", 0, 4, "\nDesc: Xenon is employed in various applications, including lighting and anesthesia.","T"));
    public static final RegistryObject<Item> CAESIUM = Items.register( "caesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 132.91, "Cs", 0, 1, "\nDesc: Caesium has uses in atomic clocks and drilling fluids, but it requires careful handling due to its reactivity with air and water.","T"));
    public static final RegistryObject<Item> BARIUM = Items.register( "barium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 137.33, "Ba", 0, 4, "\nDesc: Barium is employed in various industries, including the production of drilling fluids and glass.","T"));
    public static final RegistryObject<Item> LANTHANUM = Items.register( "lanthanum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 138.91, "La", 0, 4, "\nDesc: Lanthanum is a rare earth element with various applications, including in catalysts and optics.","T"));
    public static final RegistryObject<Item> CERIUM = Items.register( "cerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 140.12, "Ce", 0, 4, "\nDesc: Cerium is a rare earth metal known for its use in catalytic converters and in making glass.","T"));
    public static final RegistryObject<Item> PRASEODYMIUM = Items.register( "praseodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 140.91, "Pr", 0, 4, "\nDesc: Praseodymium is a rare earth element used in magnets, lasers, and as a catalyst.","T"));
    public static final RegistryObject<Item> NEODYMIUM = Items.register( "neodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 144.24, "Nd", 0, 4, "\nDesc: Neodymium is used in powerful magnets, lasers, and as a coloring agent in glasses and ceramics.","T"));
    public static final RegistryObject<Item> PROMETHIUM = Items.register( "promethium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 145.00, "Pm", 3, 4, "\nDesc: Promethium is a radioactive rare earth element used in atomic batteries and luminous paints.","T"));
    public static final RegistryObject<Item> SAMARIUM = Items.register( "samarium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 150.36, "Sm", 0, 4, "\nDesc: Samarium is used in magnets, nuclear reactors, and as a neutron absorber in control rods.","T"));
    public static final RegistryObject<Item> EUROPIUM = Items.register( "europium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 152.00, "Eu", 3, 4, "\nDesc: Europium is a radioactive rare earth element used in phosphors for color displays and as a neutron absorber.","T"));
    public static final RegistryObject<Item> GADOLINIUM = Items.register( "gadolinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 157.25, "Gd", 0, 4, "\nDesc: Gadolinium is used in MRI contrast agents, neutron capture therapy, and in fuel rods for nuclear reactors.","T"));
    public static final RegistryObject<Item> TERBIUM = Items.register( "terbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 158.93, "Tb", 0, 4, "\nDesc: Terbium is used in phosphors for color displays and as a dopant in solid-state devices.","T"));
    public static final RegistryObject<Item> DYSPROSIUM = Items.register( "dysprosium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 162.50, "Dy", 0, 4, "\nDesc: Dysprosium is used in permanent magnets, control rods for nuclear reactors, and in lighting applications.","T"));
    public static final RegistryObject<Item> HOLMIUM = Items.register( "holmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 164.93, "Ho", 0, 4, "\nDesc: Holmium is used in lasers, control rods for nuclear reactors, and as a flux in certain types of iron and steel.","T"));
    public static final RegistryObject<Item> ERBIUM = Items.register( "erbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 167.26, "Er", 0, 4, "\nDesc: Erbium is used in lasers, fiber optics, and as a neutron-absorbing control rod material in nuclear reactors.","T"));
    public static final RegistryObject<Item> THULIUM = Items.register( "thulium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 168.93, "Tm", 0, 4, "\nDesc: Thulium is used in portable X-ray devices and as a dopant in some solid-state lasers.","T"));
    public static final RegistryObject<Item> YTTERBIUM = Items.register( "ytterbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 173.05, "Yb", 0, 4, "\nDesc: Ytterbium is used in certain types of lasers, nuclear medicine, and as a dopant in fiber optic amplifiers.","T"));
    public static final RegistryObject<Item> LUTETIUM = Items.register( "lutetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 175.94, "Lu", 0, 4, "\nDesc: Lutetium is used in certain types of radiation therapy for cancer treatment and as a catalyst in various chemical reactions.","T"));
    public static final RegistryObject<Item> HAFNIUM = Items.register( "hafnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 178.49, "Hf", 0, 4, "\nDesc: Hafnium is used in nuclear reactors as control rods, in semiconductor manufacturing, and as an alloying agent in superalloys.","T"));
    public static final RegistryObject<Item> TANTALUM = Items.register( "tantalum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 180.95, "Ta", 0, 4, "\nDesc: Tantalum is used in electronics, aircraft, and medical implants due to its corrosion resistance and high melting point.","T"));
    public static final RegistryObject<Item> TUNGSTEN = Items.register( "tungsten",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 183.84, "W", 0, 4, "\nDesc: Tungsten has the highest melting point of all elements and is used in various applications, including light bulb filaments and aerospace components.","T"));
    public static final RegistryObject<Item> RHENIUM = Items.register( "rhenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 186.21, "Re", 0, 4, "\nDesc: Rhenium is used in high-temperature superalloys for jet engines and in the production of filaments for mass spectrometry and X-ray tubes.","T"));
    public static final RegistryObject<Item> OSMIUM = Items.register( "osmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 190.23, "Os", 0, 4, "\nDesc: Osmium is the densest naturally occurring element and is used in fountain pen tips, electrical contacts, and as an alloying agent in the platinum industry.","T"));
    public static final RegistryObject<Item> IRIDIUM = Items.register( "iridium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 192.22, "Ir", 0, 4, "\nDesc: Iridium is known for its high density and is used in spark plugs, electrical contacts, and in the manufacture of crucibles and other equipment that must withstand high temperatures.","T"));
    public static final RegistryObject<Item> PLATINUM = Items.register( "platinum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 195.08, "Pt", 0, 4, "\nDesc: Platinum is valued for its use in jewelry, catalytic converters, and as a standard for measuring mass and weight in the metric system.","T"));
    public static final RegistryObject<Item> GOLD = Items.register( "gold",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 196.97, "Au", 0, 4, "\nDesc: Gold is known for its beauty and is used in jewelry, coinage, and electronics. It does not tarnish and is an excellent conductor of electricity.","T"));
    public static final RegistryObject<Item> MERCURY = Items.register( "mercury",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 200.59, "Hg", 0, 4, "\nDesc: Mercury is a unique metal that is liquid at room temperature. It has been used in thermometers, barometers, and dental fillings, although its use is declining due to its toxicity.","T"));
    public static final RegistryObject<Item> THALLIUM = Items.register( "thallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 204.38, "Tl", 1, 4, "\nDesc: Thallium is a toxic metal that has various industrial applications.","T"));
    public static final RegistryObject<Item> LEAD = Items.register( "lead",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 207.2, "Pb", 0, 4, "\nDesc: Lead is a dense metal commonly used in construction and batteries.","T"));
    public static final RegistryObject<Item> BISMUTH = Items.register( "bismuth",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 208.98, "Bi", 0, 4, "\nDesc: Bismuth is a heavy metal often used in pharmaceuticals and cosmetics.","T"));
    public static final RegistryObject<Item> POLONIUM = Items.register( "polonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 208.98, "Po", 2, 4, "\nDesc: Polonium is a highly radioactive element, and its most common isotope is extremely toxic.","T"));
    public static final RegistryObject<Item> ASTATINE = Items.register( "astatine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 210.00, "At", 3, 0, "\nDesc: Astatine is a rare and highly radioactive element with no stable isotopes.","T"));
    public static final RegistryObject<Item> RADON = Items.register( "radon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 222.00, "Rn", 3, 4, "\nDesc: Radon is a colorless, odorless, and highly radioactive noble gas that poses health risks when inhaled.","T"));
    public static final RegistryObject<Item> FRANCIUM = Items.register( "francium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 223.00, "Fr", 4, 0, "\nDesc: Francium is an extremely rare and highly radioactive element, often considered the rarest naturally occurring element on Earth.","T"));
    public static final RegistryObject<Item> RADIUM = Items.register( "radium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 226.00, "Ra", 3, 2, "\nDesc: Radium is a highly radioactive element known for its luminescence and was once used in glow-in-the-dark paint.","T"));
    public static final RegistryObject<Item> ACTINIUM = Items.register( "actinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 227.00, "Ac", 3, 2, "\nDesc: Actinium is a highly radioactive element often used in radiation therapy for cancer treatment.","T"));
    public static final RegistryObject<Item> THORIUM = Items.register( "thorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 232.04, "Th", 4, 2, "\nDesc: Thorium is a radioactive element with applications in nuclear reactors and potential as a nuclear fuel.","T"));
    public static final RegistryObject<Item> PROTACTINIUM = Items.register( "protactinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 231.04, "Pa", 3, 2, "\nDesc: Protactinium is a radioactive element with limited practical uses but plays a role in the decay chain of uranium.","T"));
    public static final RegistryObject<Item> URANIUM = Items.register( "uranium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 238.03, "U", 4, 2, "\nDesc: Uranium is a radioactive element with applications in nuclear reactors, nuclear weapons, and as a fuel in nuclear power.","T"));
    public static final RegistryObject<Item> NEPTUNIUM = Items.register( "neptunium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 237.00, "Np", 3, 2, "\nDesc: Neptunium is a radioactive element used in nuclear reactors and has potential applications in nuclear weapons.","T"));
    public static final RegistryObject<Item> PLUTONIUM = Items.register( "plutonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 244.00, "Pu", 3, 2, "\nDesc: Plutonium is a radioactive element used in nuclear reactors, nuclear weapons, and as a fuel in nuclear power.","T"));
    public static final RegistryObject<Item> AMERICIUM = Items.register( "americium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 243.00, "Am", 3, 2, "\nDesc: Americium is a radioactive element used in smoke detectors and some nuclear reactors.","T"));
    public static final RegistryObject<Item> CURIUM = Items.register( "curium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 247.00, "Cm", 3, 2, "\nDesc: Curium is a radioactive element used in the production of neutron sources and some types of nuclear reactors.","T"));
    public static final RegistryObject<Item> BERKELIUM = Items.register( "berkelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 247.00, "Bk", 3, 2, "\nDesc: Berkelium is a radioactive element used in the synthesis of heavier elements and scientific research.","T"));
    public static final RegistryObject<Item> CALIFORNIUM = Items.register( "californium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 251.00, "Cf", 3, 2, "\nDesc: Californium is a radioactive element used in neutron sources and as a target in nuclear physics experiments.","T"));
    public static final RegistryObject<Item> EINSTEINIUM = Items.register( "einsteinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 252.00, "Es", 3, 2, "\nDesc: Einsteinium is a highly radioactive element used in scientific research and the production of heavier elements.","T"));
    public static final RegistryObject<Item> FERMIUM = Items.register( "fermium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 257.00, "Fm", 3, 2, "\nDesc: Fermium is a highly radioactive element used in scientific research and the production of heavier elements.","T"));
    public static final RegistryObject<Item> MENDELEVIUM = Items.register( "mendelevium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 258.00, "Md", 4, 2, "\nDesc: Mendelevium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> NOBELIUM = Items.register( "nobelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 259.00, "No", 4, 0, "\nDesc: Nobelium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> LAWRENCIUM = Items.register( "lawrencium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 266.00, "Lr", 4, 0, "\nDesc: Lawrencium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> RUTHERFORDIUM = Items.register( "rutherfordium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 267.00, "Rf", 4, 0, "\nDesc: Rutherfordium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> DUBNIUM = Items.register( "dubnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 268.00, "Db", 4, 0, "\nDesc: Dubnium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> SEABORGIUM = Items.register( "seaborgium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 269.00, "Sg", 4, 0, "\nDesc: Seaborgium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T"));
    public static final RegistryObject<Item> BOHRIUM = Items.register( "bohrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 270.134, "Bh", 4, 0, "\nDesc: A highly radioactive element with an exceptionally short half-life measured in milliseconds. Bohrium is synthesized in particle accelerators and is crucial for the study of nuclear physics and the formation of superheavy elements.","T"));
    public static final RegistryObject<Item> HASSIUM = Items.register( "hassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 277.152, "Hs", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Hassium is synthesized in laboratories and contributes to the exploration of nuclear physics and superheavy elements.","T"));
    public static final RegistryObject<Item> MEITNERIUM = Items.register( "meitnerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 278.156, "Mt", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Meitnerium is produced in particle accelerators and aids in the exploration of nuclear physics and superheavy elements.","T"));
    public static final RegistryObject<Item> DARMSTADTIUM = Items.register( "darmstadtium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 281.162, "Ds", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Darmstadtium is produced in controlled laboratory environments and plays a critical role in advancing nuclear physics research and the understanding of superheavy elements.","T"));
    public static final RegistryObject<Item> ROENTGENIUM = Items.register( "roentgenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 282.166, "Rg", 4, 0, "\nDesc: An extremely radioactive element with an incredibly short half-life measured in milliseconds. Roentgenium is synthesized in particle accelerators and is invaluable for nuclear physics research and superheavy element studies.","T"));
    public static final RegistryObject<Item> COPERNICIUM = Items.register( "copernicium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 285.178, "Cn", 4, 0, "\nDesc: A highly radioactive element with a brief half-life measured in milliseconds. Copernicium is created in controlled laboratory environments and contributes to advances in nuclear physics and superheavy element investigations.","T"));
    public static final RegistryObject<Item> NIHONIUM = Items.register( "nihonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 286.190, "Nh", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Nihonium is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies.","T"));
    public static final RegistryObject<Item> FLEROVIUM = Items.register( "flerovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 289.193, "Fl", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Flerovium is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations.","T"));
    public static final RegistryObject<Item> MOSCOVIUM = Items.register( "moscovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 290.196, "Mc", 4, 0, "\nDesc: An extremely radioactive element with an exceptionally brief half-life measured in milliseconds. Moscovium is produced in particle accelerators and plays a crucial role in nuclear physics research and superheavy element investigations.","T"));
    public static final RegistryObject<Item> LIVERMORIUM = Items.register( "livermorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 293.205, "Lv", 4, 0, "\nDesc: An extremely radioactive element with an exceedingly short half-life measured in milliseconds. Livermorium is created in controlled laboratory environments and contributes significantly to nuclear physics research and superheavy element studies.","T"));
    public static final RegistryObject<Item> TENNESSINE = Items.register( "tennessine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 294.211, "Ts", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Tennessine is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies.","T"));
    public static final RegistryObject<Item> OGANESSON = Items.register( "oganesson",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 294.214, "Og", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Oganesson is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations.","T"));

    //Molecules
    public static final RegistryObject<Item> WATER = Items.register( "water",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CARBON_DIOXIDE = Items.register( "carbon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIA = Items.register( "ammonia",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Salts:
    //list out anions: Cl, C03, SO4, HCO3, OH, NO3, Cr2O7, CN, ClO3, PO4,
    //list out cations: Li, Be, Na, Mg, K, Ca, Rb, Sr, Cs, Ba, Fr, Ra, NH4
    //sodium salts
    public static final RegistryObject<Item> SODIUM_OXIDE = Items.register( "sodium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),61.98,"Na2O",0,4,"\nDesc: A widely used compound, which finds use in the production of ceramics and glasses.","C,S1"));
    public static final RegistryObject<Item> SODIUM_FLUORIDE = Items.register( "sodium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),41.99,"NaF",0,4,"\nDesc: Sodium Fluoride has medicinal uses, used as an active ingredient in toothpastes to prevent decay.","T,I,H"));
    public static final RegistryObject<Item> SODIUM_SULFIDE = Items.register( "sodium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),78.05,"Na2S",0,4,"\nDesc: This compound finds its use in the paper and pulp production industries.","C,T,I,A"));
    public static final RegistryObject<Item> SODIUM_CHLORIDE = Items.register( "sodium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.44,"NaCl",0,4,"\nDesc: This compound is widely used, most known for its culinary use as table salt.",""));
    public static final RegistryObject<Item> SODIUM_NITRIDE = Items.register( "sodium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),82.98,"Na3N",0,0,"\nDesc: Unfortunately, Sodium Nitride is too unstable to be used for much.",""));
    public static final RegistryObject<Item> SODIUM_BROMIDE = Items.register( "sodium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),102.89,"NaBr",0,4,"\nDesc: It finds use as a readily available form of bromide ions for other processes.",""));
    public static final RegistryObject<Item> SODIUM_IODIDE = Items.register( "sodium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.89,"NaI",0,4,"\nDesc: This nutritional supplement also finds use in organic chemistry.","I,A"));
    public static final RegistryObject<Item> SODIUM_ARSENATE = Items.register( "sodium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),207.89,"Na3AsO4",0,4,"\nDesc: It is most commonly handled as a dodecahydrate (+12 H20).","T,H,A"));
    public static final RegistryObject<Item> SODIUM_ARSENITE = Items.register( "sodium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),129.91,"NaAsO2",0,4,"\nDesc: Useful as a pesticide.","T,H,A"));
    public static final RegistryObject<Item> SODIUM_PHOSPHATE = Items.register( "sodium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),163.94,"Na3PO4",0,4,"\nDesc: Known as Trisodium Phosphate (TSP), and used for cleaning.","C,I"));
    public static final RegistryObject<Item> SODIUM_DIHYDROGEN_PHOSPHATE = Items.register( "sodium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.98,"NaH2P04",0,4,"\nDesc: Known as Monosodium Phosphate (MSP), and used as a thickening agent in water treatment.",""));
    public static final RegistryObject<Item> SODIUM_SULFATE = Items.register( "sodium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),142.04,"Na2SO4",0,4,"\nDesc: Handled most commonly in its dodecahydrate form, and is found in laundry detergent.","I"));
    public static final RegistryObject<Item> SODIUM_HYDROGEN_SULFATE = Items.register( "sodium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),120.06,"NaHSO4",0,4,"\nDesc: It is useful in lowering the pH of a solution, and can also be used for cleaning.","C"));
    public static final RegistryObject<Item> SODIUM_THIOSULFATE = Items.register( "sodium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.11,"Na2S2O3",0,4,"\nDesc: Useful as a bleaching agent, especially to make colorless dyes.","I"));
    public static final RegistryObject<Item> SODIUM_SULFITE = Items.register( "sodium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.04,"Na2SO3",0,4,"\nDesc: Sodium Sulfite finds use in the paper / pulp industry.",""));
    public static final RegistryObject<Item> SODIUM_NITRATE = Items.register( "sodium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.99,"NaNO3",0,4,"\nDesc: A useful fertilizer, also known as Chile Saltpeter.","O,I"));
    public static final RegistryObject<Item> SODIUM_NITRITE = Items.register( "sodium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),69.00,"NaNO2",0,4,"\nDesc: This compound has a wide range of use, from being used as a food additive to pesticides and pharmacology.","O,T,A"));
    public static final RegistryObject<Item> SODIUM_PERCHLORATE = Items.register( "sodium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.44,"NaClO4",0,4,"\nDesc: This has been found on planet Mars, and is used as a precursor to other perchlorates.","O,I,H"));
    public static final RegistryObject<Item> SODIUM_CHLORATE = Items.register( "sodium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),106.44,"NaClO3",0,4,"\nDesc: Finds use in the production of chlorine dioxide.","O,I,A"));
    public static final RegistryObject<Item> SODIUM_CHLORITE = Items.register( "sodium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.44,"NaClO2",0,4,"\nDesc: Finds use in the production of chlorine dioxide.","O,C,T,A"));
    public static final RegistryObject<Item> SODIUM_HYPOCHLORITE = Items.register( "sodium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.44,"NaClO",0,4,"\nDesc: This is also known as household bleach.","O,C,A"));
    public static final RegistryObject<Item> SODIUM_IODATE = Items.register( "sodium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),197.89,"NaIO3",0,4,"\nDesc: This is also known as iodized salt.","O,I,A"));
    public static final RegistryObject<Item> SODIUM_BROMATE = Items.register( "sodium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.89,"NaBrO3",0,4,"\nDesc: Sodium Bromate is used in the dyeing industry in vat dyes.","O,I,H"));
    public static final RegistryObject<Item> SODIUM_CARBONATE = Items.register( "sodium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),105.99,"Na2CO3",0,4,"\nDesc: Also known as soda ash, this compound has a wide range of uses.","I"));
    public static final RegistryObject<Item> SODIUM_BICARBONATE = Items.register( "sodium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.00,"NaHCO3",0,4,"\nDesc: Also known as baking soda, this compound has a wide range of uses.","I"));
    public static final RegistryObject<Item> SODIUM_CHROMATE = Items.register( "sodium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),161.97,"Na2CrO4",0,4,"\nDesc: Mainly used to produce other chromium compounds and in organic chemistry.","C,T,I,H,A"));
    public static final RegistryObject<Item> SODIUM_DICHROMATE = Items.register( "sodium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),261.97,"Na2Cr2O7",0,4,"\nDesc: Can be used as a way to store chromium in a stable and readily available form.","O,C,T,I,H,A"));
    public static final RegistryObject<Item> SODIUM_ACETATE = Items.register( "sodium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),82.03,"NaC2H3O2",0,4,"\nDesc: This has a wide range use, mainly as the salt form of acetic acid for ready use.","I"));
    public static final RegistryObject<Item> SODIUM_FORMATE = Items.register( "sodium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.00,"NaHCO2",0,4,"\nDesc: Useful for fabric dyeing and printing.",""));
    public static final RegistryObject<Item> SODIUM_CYANIDE = Items.register( "sodium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),49.01,"NaCN",0,4,"\nDesc: This heavily toxic compound is useful in gold mining.","T,A"));
    public static final RegistryObject<Item> SODIUM_CYANATE = Items.register( "sodium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.01,"NaOCN",0,4,"\nDesc: Sodium Cyanate is detoxified Sodium Cyanide and is used in steel hardening","I"));
    public static final RegistryObject<Item> SODIUM_THIOCYANATE = Items.register( "sodium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),81.07,"NaSCN",0,4,"\nDesc: Used in the synthesis of pharmaceuticals.","C,I"));
    public static final RegistryObject<Item> SODIUM_PEROXIDE = Items.register( "sodium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),77.98,"NA2O2",0,4,"\nDesc: Mainly used in mineral extraction.","O,C"));
    public static final RegistryObject<Item> SODIUM_OXALATE = Items.register( "sodium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),134.00,"Na2C2O4",0,4,"\nDesc: This compound is the sodium salt of oxalic acid.","I"));
    public static final RegistryObject<Item> SODIUM_HYDROXIDE = Items.register( "sodium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),40.00,"NaOH",0,4,"\nDesc: This compound has a wide range of application, popularly as a base.","C,I"));
    public static final RegistryObject<Item> SODIUM_PERMANGANATE = Items.register( "sodium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),141.93,"NaMnO4",0,4,"\nDesc: Finds use in water treatment operations.","O"));
    //lithium salts
    public static final RegistryObject<Item> LITHIUM_OXIDE = Items.register( "lithium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),29.88,"Li2O",0,4,"\nDesc: Often used as flux for the production of ceramic glasses.","C,S1,S2"));
    public static final RegistryObject<Item> LITHIUM_FLUORIDE = Items.register( "lithium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),25.94,"LiF",0,4,"\nDesc: A component in molten salts.","T,S2"));
    public static final RegistryObject<Item> LITHIUM_SULFIDE = Items.register( "lithium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),45.95,"Li2S",0,4,"\nDesc: This material has been proposed for use in a lithium-sulfur battery.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_CHLORIDE = Items.register( "lithium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),42.39,"LiCl",0,4,"\nDesc: Used in the production of lithium metal, and also as a flame colorant.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_NITRIDE = Items.register( "lithium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),34.83,"Li3N",0,4,"\nDesc: This compound reacts violently with water to produce ammonia.","F,C,S1,S2"));
    public static final RegistryObject<Item> LITHIUM_BROMIDE = Items.register( "lithium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),86.85,"LiBr",0,4,"\nDesc: Useful as a desiccant in air conditioning units.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_IODIDE = Items.register( "lithium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.85,"LiI",0,2,"\nDesc: This compound can be found in artificial pacemakers.","S2"));
    public static final RegistryObject<Item> LITHIUM_ARSENATE = Items.register( "lithium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.80,"Li3AsO4",0,4,"\nDesc: Not much is known about this molecule.","S2"));
    public static final RegistryObject<Item> LITHIUM_PHOSPHATE = Items.register( "lithium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.79,"Li3PO4",0,4,"\nDesc: Can be found in lithium batteries.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_SULFATE = Items.register( "lithium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),109.94,"Li2SO4",0,4,"\nDesc: This drug can be used as a mood stabilizer for bipolar disorder.","S2"));
    public static final RegistryObject<Item> LITHIUM_HYDROGEN_SULFATE = Items.register( "lithium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),104.00,"LiHSO4",0,4,"\nDesc: Not much is known about this compound.","S2"));
    public static final RegistryObject<Item> LITHIUM_THIOSULFATE = Items.register( "lithium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.00,"Li2S2O3",0,4,"\nDesc: This compound shows promising use in inorganic chemistry.","S2"));
    public static final RegistryObject<Item> LITHIUM_SULFITE = Items.register( "lithium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),93.94,"Li2SO3",0,4,"\nDesc: Not much is known about this compound.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_NITRATE = Items.register( "lithium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.95,"LiNO3",0,4,"\nDesc: In pyrotechnics, it is used in the production of red fireworks and flares.","O,I,S2"));
    public static final RegistryObject<Item> LITHIUM_NITRITE = Items.register( "lithium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),52.95,"LiNO2",0,4,"\nDesc: Is used in mortar as a corrosion inhibitor, and has been used to make explosives.","S2"));
    public static final RegistryObject<Item> LITHIUM_PERCHLORATE = Items.register( "lithium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),106.39,"LiClO4",0,4,"\nDesc: Found in lithium batteries, and has applications in chemistry labs.","O,I,S2"));
    public static final RegistryObject<Item> LITHIUM_CHLORATE = Items.register( "lithium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.39,"LiClO3",0,4,"\nDesc: Has potential use in the production of flow-batteries.","O,S2"));
    public static final RegistryObject<Item> LITHIUM_CHLORITE = Items.register( "lithium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.40,"LiClO2",0,4,"\nDesc: Not Much is know about this compound.","S2"));
    public static final RegistryObject<Item> LITHIUM_HYPOCHLORITE = Items.register( "lithium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.39,"LiClO",0,4,"\nDesc: Commonly used as a pool disinfectant.","S2"));
    public static final RegistryObject<Item> LITHIUM_IODATE = Items.register( "lithium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),181.84,"LiIO3",0,4,"\nDesc: Used to make 347 nm ruby lasers.","O,I,H,S2"));
    public static final RegistryObject<Item> LITHIUM_CARBONATE = Items.register( "lithium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),73.89,"Li2CO3",0,4,"\nDesc: This molecule in on the World Health Organization's list of essential medicines. Used to treat mood disorders.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_BICARBONATE = Items.register( "lithium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),67.96,"LiHCO3",0,4,"\nDesc: Not much is known about this molecule.","S2"));
    public static final RegistryObject<Item> LITHIUM_CHROMATE = Items.register( "lithium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),129.90,"Li2CrO4",0,4,"\nDesc: Used in the processes of leather and metal finishing.","T,I,H,A,S2"));
    public static final RegistryObject<Item> LITHIUM_DICHROMATE = Items.register( "lithium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),229.90,"Li2Cr2O7",0,4,"\nDesc: This molecule has little to no industrial application or use.","O,I,H,S2"));
    public static final RegistryObject<Item> LITHIUM_ACETATE = Items.register( "lithium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.98,"LiC2H3O2",0,4,"\nDesc: An buffer ingredient for the gel electrophoresis of DNA and RNA.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_CYANIDE = Items.register( "lithium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),32.96,"LiCN",0,4,"\nDesc: Useful in organic chemistry reactions, specifically cyanation.","F,T,A,S2"));
    public static final RegistryObject<Item> LITHIUM_THIOCYANATE = Items.register( "lithium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.02,"LiSCN",0,0,"\nDesc: This compound is too unstable to use.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_PEROXIDE = Items.register( "lithium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),45.88,"Li2O2",0,4,"\nDesc: Used in the air purification systems of spacecraft.","O,C,S2"));
    public static final RegistryObject<Item> LITHIUM_OXALATE = Items.register( "lithium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),102.00,"Li2C2O2",0,4,"\nDesc: Finds use in pyrotechnics as a red flame colorant.","I,S2"));
    public static final RegistryObject<Item> LITHIUM_HYDROXIDE = Items.register( "lithium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),23.95,"LiOH",0,4,"\nDesc: This chemical is mainly used to produce cathodes in lithium batteries.","C,S2"));
    //beryllium salts
    public static final RegistryObject<Item> BERYLLIUM_OXIDE = Items.register( "beryllium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),25.01,"BeO",0,4,"\nDesc: Used in rocket engines.","T,H,A"));
    public static final RegistryObject<Item> BERYLLIUM_FLUORIDE = Items.register( "beryllium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),47.01,"BeF2",0,4,"\nDesc: Useful in the production of beryllium metal.","C,T,H,A"));
    public static final RegistryObject<Item> BERYLLIUM_SULFIDE = Items.register( "beryllium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),41.08,"BeS",0,4,"\nDesc: Not much is known about this compound.","H"));
    public static final RegistryObject<Item> BERYLLIUM_CHLORIDE = Items.register( "beryllium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),79.92,"BeCl2",0,4,"\nDesc: Finds use in the electrolysis of beryllium and can be used as a catalyst in Friedel Crafts reactions.","I,H"));
    public static final RegistryObject<Item> BERYLLIUM_NITRIDE = Items.register( "beryllium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),55.05,"Be3N2",0,4,"\nDesc: Useful in refractory ceramics and nuclear reactors.","H"));
    public static final RegistryObject<Item> BERYLLIUM_BROMIDE = Items.register( "beryllium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),168.82,"BeBr2",0,4,"\nDesc: Not much is known about this compound's use.","T,H,A"));
    public static final RegistryObject<Item> BERYLLIUM_IODIDE = Items.register( "beryllium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),262.82,"BeI2",0,4,"\nDesc: Useful in the production of the beryllium metal.","S1,H"));
    public static final RegistryObject<Item> BERYLLIUM_SULFATE = Items.register( "beryllium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),105.68,"BeSO4",0,4,"\nDesc: A compound that played a part in the discovery of nuclear fission as a source of neutrons.","T,H,A"));
    public static final RegistryObject<Item> BERYLLIUM_NITRATE = Items.register( "beryllium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.02,"Be(NO3)2",0,4,"\nDesc: Not much is know about this compound's use.","H"));
    public static final RegistryObject<Item> BERYLLIUM_PERCHLORATE = Items.register( "beryllium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),207.91,"Be(ClO4)2",0,4,"\nDesc: This chemical is often used as a solvent for cellulose.","O,H"));
    public static final RegistryObject<Item> BERYLLIUM_IODATE = Items.register( "beryllium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),358.82,"Be(IO3)2",0,4,"\nDesc: Not much is known about this chemical's use.","H"));
    public static final RegistryObject<Item> BERYLLIUM_CARBONATE = Items.register( "beryllium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),69.02,"BeCO3",0,2,"\nDesc: Not much is known about this compound's use.","T,I,H,A"));
    public static final RegistryObject<Item> BERYLLIUM_CHROMATE = Items.register( "beryllium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.01,"BeCrO4",0,4,"\nDesc: This chemical has only been hypothesized to be possible.","T,H"));
    public static final RegistryObject<Item> BERYLLIUM_CYANIDE = Items.register( "beryllium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),61.05,"Be(CN)2",0,4,"\nDesc: Not much is known about this chemical's use.","T,H"));
    public static final RegistryObject<Item> BERYLLIUM_THIOCYANATE = Items.register( "beryllium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.18,"Be(SCN)2",0,4,"\nDesc: Not much is know about this compound's use.","H"));
    public static final RegistryObject<Item> BERYLLIUM_OXALATE = Items.register( "beryllium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.03,"BeC2O4",0,4,"\nDesc: This chemical is used in the preparation of beryllium oxide.","H"));
    public static final RegistryObject<Item> BERYLLIUM_HYDROXIDE = Items.register( "beryllium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),43.03,"Be(OH)2",0,4,"\nDesc: Produced as a byproduct of beryllium extraction from ores.","T,H,A"));
   //calcium salts
    public static final RegistryObject<Item> CALCIUM_OXIDE = Items.register( "calcium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_FLUORIDE = Items.register( "calcium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_SULFIDE = Items.register( "calcium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CHLORIDE = Items.register( "calcium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_NITRIDE = Items.register( "calcium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_BROMIDE = Items.register( "calcium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_IODIDE = Items.register( "calcium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_ARSENATE = Items.register( "calcium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_ARSENITE = Items.register( "calcium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_PHOSPHATE = Items.register( "calcium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_DIHYDROGEN_PHOSPHATE = Items.register( "calcium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_SULFATE = Items.register( "calcium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_HYDROGEN_SULFATE = Items.register( "calcium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_THIOSULFATE = Items.register( "calcium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_SULFITE = Items.register( "calcium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_NITRATE = Items.register( "calcium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_NITRITE = Items.register( "calcium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_PERCHLORATE = Items.register( "calcium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CHLORATE = Items.register( "calcium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CHLORITE = Items.register( "calcium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_HYPOCHLORITE = Items.register( "calcium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_IODATE = Items.register( "calcium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_BROMATE = Items.register( "calcium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CARBONATE = Items.register( "calcium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_BICARBONATE = Items.register( "calcium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CHROMATE = Items.register( "calcium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_DICHROMATE = Items.register( "calcium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_ACETATE = Items.register( "calcium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_FORMATE = Items.register( "calcium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CYANIDE = Items.register( "calcium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_CYANATE = Items.register( "calcium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_THIOCYANATE = Items.register( "calcium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_PEROXIDE = Items.register( "calcium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_OXALATE = Items.register( "calcium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_HYDROXIDE = Items.register( "calcium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CALCIUM_PERMANGANATE = Items.register( "calcium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //potassium salts
    public static final RegistryObject<Item> POTASSIUM_OXIDE = Items.register( "potassium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_FLUORIDE = Items.register( "potassium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_SULFIDE = Items.register( "potassium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CHLORIDE = Items.register( "potassium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_NITRIDE = Items.register( "potassium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_BROMIDE = Items.register( "potassium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_IODIDE = Items.register( "potassium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_ARSENATE = Items.register( "potassium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_ARSENITE = Items.register( "potassium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_PHOSPHATE = Items.register( "potassium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_DIHYDROGEN_PHOSPHATE = Items.register( "potassium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_SULFATE = Items.register( "potassium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_HYDROGEN_SULFATE = Items.register( "potassium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_THIOSULFATE = Items.register( "potassium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_SULFITE = Items.register( "potassium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_NITRATE = Items.register( "potassium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_NITRITE = Items.register( "potassium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_PERCHLORATE = Items.register( "potassium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CHLORATE = Items.register( "potassium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CHLORITE = Items.register( "potassium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_HYPOCHLORITE = Items.register( "potassium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_IODATE = Items.register( "potassium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_BROMATE = Items.register( "potassium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CARBONATE = Items.register( "potassium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_BICARBONATE = Items.register( "potassium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CHROMATE = Items.register( "potassium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_DICHROMATE = Items.register( "potassium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_ACETATE = Items.register( "potassium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_FORMATE = Items.register( "potassium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CYANIDE = Items.register( "potassium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_CYANATE = Items.register( "potassium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_THIOCYANATE = Items.register( "potassium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_PEROXIDE = Items.register( "potassium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_OXALATE = Items.register( "potassium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_HYDROXIDE = Items.register( "potassium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> POTASSIUM_PERMANGANATE = Items.register( "potassium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //aluminum salts
    public static final RegistryObject<Item> ALUMINUM_OXIDE = Items.register( "aluminum_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_FLUORIDE = Items.register( "aluminum_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_SULFIDE = Items.register( "aluminum_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_CHLORIDE = Items.register( "aluminum_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_NITRIDE = Items.register( "aluminum_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_BROMIDE = Items.register( "aluminum_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_IODIDE = Items.register( "aluminum_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_ARSENATE = Items.register( "aluminum_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_PHOSPHATE = Items.register( "aluminum_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_DIHYDROGEN_PHOSPHATE = Items.register( "aluminum_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_SULFATE = Items.register( "aluminum_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_THIOSULFATE = Items.register( "aluminum_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_NITRATE = Items.register( "aluminum_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_PERCHLORATE = Items.register( "aluminum_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_CHLORATE = Items.register( "aluminum_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_BROMATE = Items.register( "aluminum_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_CARBONATE = Items.register( "aluminum_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_BICARBONATE = Items.register( "aluminum_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_ACETATE = Items.register( "aluminum_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_FORMATE = Items.register( "aluminum_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_CYANIDE = Items.register( "aluminum_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_OXALATE = Items.register( "aluminum_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALUMINUM_HYDROXIDE = Items.register( "aluminum_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
   //ammonium salts
    public static final RegistryObject<Item> AMMONIUM_FLUORIDE = Items.register( "ammonium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_SULFIDE = Items.register( "ammonium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CHLORIDE = Items.register( "ammonium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_NITRIDE = Items.register( "ammonium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_BROMIDE = Items.register( "ammonium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_IODIDE = Items.register( "ammonium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_ARSENATE = Items.register( "ammonium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_PHOSPHATE = Items.register( "ammonium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_DIHYDROGEN_PHOSPHATE = Items.register( "ammonium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_SULFATE = Items.register( "ammonium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_HYDROGEN_SULFATE = Items.register( "ammonium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_THIOSULFATE = Items.register( "ammonium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_SULFITE = Items.register( "ammonium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_NITRATE = Items.register( "ammonium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_NITRITE = Items.register( "ammonium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_PERCHLORATE = Items.register( "ammonium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CHLORATE = Items.register( "ammonium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_IODATE = Items.register( "ammonium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CARBONATE = Items.register( "ammonium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_BICARBONATE = Items.register( "ammonium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CHROMATE = Items.register( "ammonium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_DICHROMATE = Items.register( "ammonium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_ACETATE = Items.register( "ammonium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_FORMATE = Items.register( "ammonium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CYANIDE = Items.register( "ammonium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_CYANATE = Items.register( "ammonium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_THIOCYANATE = Items.register( "ammonium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_OXALATE = Items.register( "ammonium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> AMMONIUM_PERMANGANATE = Items.register( "ammonium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //barium salts
    public static final RegistryObject<Item> BARIUM_OXIDE = Items.register( "barium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_FLUORIDE = Items.register( "barium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_SULFIDE = Items.register( "barium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_CHLORIDE = Items.register( "barium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_NITRIDE = Items.register( "barium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_BROMIDE = Items.register( "barium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_IODIDE = Items.register( "barium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_ARSENATE = Items.register( "barium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_PHOSPHATE = Items.register( "barium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_DIHYDROGEN_PHOSPHATE = Items.register( "barium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_SULFATE = Items.register( "barium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_SULFITE = Items.register( "barium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_NITRATE = Items.register( "barium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_NITRITE = Items.register( "barium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_PERCHLORATE = Items.register( "barium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_CHLORATE = Items.register( "barium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_HYPOCHLORITE = Items.register( "barium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_IODATE = Items.register( "barium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_BROMATE = Items.register( "barium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_CARBONATE = Items.register( "barium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_CHROMATE = Items.register( "barium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_ACETATE = Items.register( "barium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_CYANIDE = Items.register( "barium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_THIOCYANATE = Items.register( "barium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_PEROXIDE = Items.register( "barium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_OXALATE = Items.register( "barium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_HYDROXIDE = Items.register( "barium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BARIUM_PERMANGANATE = Items.register( "barium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //chromium II
    public static final RegistryObject<Item> CHROMIUM_II_OXIDE = Items.register( "chromium_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_FLUORIDE = Items.register( "chromium_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_SULFIDE = Items.register( "chromium_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_CHLORIDE = Items.register( "chromium_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_BROMIDE = Items.register( "chromium_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_IODIDE = Items.register( "chromium_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_CHROMATE = Items.register( "chromium_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_ACETATE = Items.register( "chromium_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_II_OXALATE = Items.register( "chromium_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //chromium_iii
    public static final RegistryObject<Item> CHROMIUM_III_OXIDE = Items.register( "chromium_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_FLUORIDE = Items.register( "chromium_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_SULFIDE = Items.register( "chromium_iii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_CHLORIDE = Items.register( "chromium_iii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_NITRIDE = Items.register( "chromium_iii_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_BROMIDE = Items.register( "chromium_iii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_IODIDE = Items.register( "chromium_iii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_PHOSPHATE = Items.register( "chromium_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_SULFATE = Items.register( "chromium_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_NITRATE = Items.register( "chromium_iii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_PERCHLORATE = Items.register( "chromium_iii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_CHROMATE = Items.register( "chromium_iii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_OXALATE = Items.register( "chromium_iii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHROMIUM_III_HYDROXIDE = Items.register( "chromium_iii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //COPPER I SALTS
    public static final RegistryObject<Item> COPPER_I_OXIDE = Items.register( "copper_i_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_FLUORIDE = Items.register( "copper_i_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_SULFIDE = Items.register( "copper_i_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_CHLORIDE = Items.register( "copper_i_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_BROMIDE = Items.register( "copper_i_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_IODIDE = Items.register( "copper_i_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_SULFATE = Items.register( "copper_i_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_CYANIDE = Items.register( "copper_i_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_THIOCYANATE = Items.register( "copper_i_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_I_HYDROXIDE = Items.register( "copper_i_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //copper ii salts
    public static final RegistryObject<Item> COPPER_II_OXIDE = Items.register( "copper_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_FLUORIDE = Items.register( "copper_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_SULFIDE = Items.register( "copper_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_CHLORIDE = Items.register( "copper_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_BROMIDE = Items.register( "copper_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_ARSENATE = Items.register( "copper_ii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_PHOSPHATE = Items.register( "copper_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_SULFATE = Items.register( "copper_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_NITRATE = Items.register( "copper_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_PERCHLORATE = Items.register( "copper_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_CHLORATE = Items.register( "copper_ii_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_CARBONATE = Items.register( "copper_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_CHROMATE = Items.register( "copper_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_ACETATE = Items.register( "copper_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_FORMATE = Items.register( "copper_ii_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_THIOCYANATE = Items.register( "copper_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_PEROXIDE = Items.register( "copper_ii_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_OXALATE = Items.register( "copper_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COPPER_II_HYDROXIDE = Items.register( "copper_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //IRON II SALTS
    public static final RegistryObject<Item> IRON_II_OXIDE = Items.register( "iron_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_FLUORIDE = Items.register( "iron_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_SULFIDE = Items.register( "iron_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_CHLORIDE = Items.register( "iron_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_BROMIDE = Items.register( "iron_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_IODIDE = Items.register( "iron_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_ARSENATE = Items.register( "iron_ii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_PHOSPHATE = Items.register( "iron_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_SULFATE = Items.register( "iron_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_NITRATE = Items.register( "iron_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_PERCHLORATE = Items.register( "iron_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_CARBONATE = Items.register( "iron_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_ACETATE = Items.register( "iron_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_THIOCYANATE = Items.register( "iron_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_OXALATE = Items.register( "iron_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_II_HYDROXIDE = Items.register( "iron_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //iron iii salts
    public static final RegistryObject<Item> IRON_III_OXIDE = Items.register( "iron_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_FLUORIDE = Items.register( "iron_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_CHLORIDE = Items.register( "iron_iii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_BROMIDE = Items.register( "iron_iii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_IODIDE = Items.register( "iron_iii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_ARSENATE = Items.register( "iron_iii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_PHOSPHATE = Items.register( "iron_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_SULFATE = Items.register( "iron_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_NITRATE = Items.register( "iron_iii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> IRON_III_OXALATE = Items.register( "iron_iii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //LEAD II
    public static final RegistryObject<Item> LEAD_II_OXIDE = Items.register( "lead_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_FLUORIDE = Items.register( "lead_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_SULFIDE = Items.register( "lead_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_CHLORIDE = Items.register( "lead_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_BROMIDE = Items.register( "lead_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_IODIDE = Items.register( "lead_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_ARSENITE = Items.register( "lead_ii_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_PHOSPHATE = Items.register( "lead_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_SULFATE = Items.register( "lead_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_THIOSULFATE = Items.register( "lead_ii_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_NITRATE = Items.register( "lead_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_PERCHLORATE = Items.register( "lead_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_IODATE = Items.register( "lead_ii_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_CARBONATE = Items.register( "lead_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_CHROMATE = Items.register( "lead_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_ACETATE = Items.register( "lead_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_CYANIDE = Items.register( "lead_ii_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_THIOCYANATE = Items.register( "lead_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LEAD_II_HYDROXIDE = Items.register( "lead_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //magnesium salts
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = Items.register( "magnesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_FLUORIDE = Items.register( "magnesium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_SULFIDE = Items.register( "magnesium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_CHLORIDE = Items.register( "magnesium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_NITRIDE = Items.register( "magnesium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_BROMIDE = Items.register( "magnesium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_IODIDE = Items.register( "magnesium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_ARSENATE = Items.register( "magnesium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_DIHYDROGEN_PHOSPHATE = Items.register( "magnesium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_SULFATE = Items.register( "magnesium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_THIOSULFATE = Items.register( "magnesium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_NITRATE = Items.register( "magnesium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_PERCHLORATE = Items.register( "magnesium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_CHLORATE = Items.register( "magnesium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_CARBONATE = Items.register( "magnesium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_CHROMATE = Items.register( "magnesium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_ACETATE = Items.register( "magnesium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_FORMATE = Items.register( "magnesium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_PEROXIDE = Items.register( "magnesium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_OXALATE = Items.register( "magnesium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_HYDROXIDE = Items.register( "magnesium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MAGNESIUM_PERMANGANATE = Items.register( "magnesium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //MANGANESE II SALTS
    public static final RegistryObject<Item> MANGANESE_II_OXIDE = Items.register( "manganese_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_FLUORIDE = Items.register( "manganese_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_SULFIDE = Items.register( "manganese_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_CHLORIDE = Items.register( "manganese_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_BROMIDE = Items.register( "manganese_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_IODIDE = Items.register( "manganese_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_PHOSPHATE = Items.register( "manganese_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_SULFATE = Items.register( "manganese_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_NITRATE = Items.register( "manganese_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_CHLORATE = Items.register( "manganese_ii_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_CARBONATE = Items.register( "manganese_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_ACETATE = Items.register( "manganese_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_OXALATE = Items.register( "manganese_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_II_HYDROXIDE = Items.register( "manganese_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //manganese iii salts
    public static final RegistryObject<Item> MANGANESE_III_OXIDE = Items.register( "manganese_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_III_FLUORIDE = Items.register( "manganese_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_III_PHOSPHATE = Items.register( "manganese_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_III_SULFATE = Items.register( "manganese_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MANGANESE_III_ACETATE = Items.register( "manganese_iii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //MERCURY I SALTS
    public static final RegistryObject<Item> MERCURY_I_OXIDE = Items.register( "mercury_i_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_FLUORIDE = Items.register( "mercury_i_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_CHLORIDE = Items.register( "mercury_i_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_BROMIDE = Items.register( "mercury_i_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_IODIDE = Items.register( "mercury_i_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_SULFATE = Items.register( "mercury_i_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_I_NITRATE = Items.register( "mercury_i_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //mercury ii salts
    public static final RegistryObject<Item> MERCURY_II_OXIDE = Items.register( "mercury_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_FLUORIDE = Items.register( "mercury_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_SULFIDE = Items.register( "mercury_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_CHLORIDE = Items.register( "mercury_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_BROMIDE = Items.register( "mercury_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_IODIDE = Items.register( "mercury_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_SULFATE = Items.register( "mercury_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_NITRATE = Items.register( "mercury_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_ACETATE = Items.register( "mercury_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_CYANIDE = Items.register( "mercury_ii_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_THIOCYANATE = Items.register( "mercury_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> MERCURY_II_HYDROXIDE = Items.register( "mercury_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //NITRONIUM SALTS
    public static final RegistryObject<Item> NITRONIUM_FLUORIDE = Items.register( "nitronium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> NITRONIUM_CHLORIDE = Items.register( "nitronium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> NITRONIUM_PERCHLORATE = Items.register( "nitronium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //silver salts
    public static final RegistryObject<Item> SILVER_OXIDE = Items.register( "silver_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_FLUORIDE = Items.register( "silver_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_SULFIDE = Items.register( "silver_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CHLORIDE = Items.register( "silver_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_NITRIDE = Items.register( "silver_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_BROMIDE = Items.register( "silver_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_IODIDE = Items.register( "silver_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_ARSENATE = Items.register( "silver_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_ARSENITE = Items.register( "silver_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_PHOSPHATE = Items.register( "silver_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_SULFATE = Items.register( "silver_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_NITRATE = Items.register( "silver_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_NITRITE = Items.register( "silver_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_PERCHLORATE = Items.register( "silver_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CHLORATE = Items.register( "silver_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CHLORITE = Items.register( "silver_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_HYPOCHLORITE = Items.register( "silver_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_IODATE = Items.register( "silver_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_BROMATE = Items.register( "silver_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CARBONATE = Items.register( "silver_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CHROMATE = Items.register( "silver_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_DICHROMATE = Items.register( "silver_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_ACETATE = Items.register( "silver_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_CYANIDE = Items.register( "silver_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_THIOCYANATE = Items.register( "silver_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_OXALATE = Items.register( "silver_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_HYDROXIDE = Items.register( "silver_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILVER_PERMANGANATE = Items.register( "silver_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //STRONTIUM SALTS
    public static final RegistryObject<Item> STRONTIUM_OXIDE = Items.register( "strontium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_FLUORIDE = Items.register( "strontium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_SULFIDE = Items.register( "strontium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_CHLORIDE = Items.register( "strontium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_NITRIDE = Items.register( "strontium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_BROMIDE = Items.register( "strontium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_IODIDE = Items.register( "strontium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_SULFATE = Items.register( "strontium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_NITRATE = Items.register( "strontium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_PERCHLORATE = Items.register( "strontium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_CHLORATE = Items.register( "strontium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_BROMATE = Items.register( "strontium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_CARBONATE = Items.register( "strontium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_CHROMATE = Items.register( "strontium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_ACETATE = Items.register( "strontium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_FORMATE = Items.register( "strontium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_PEROXIDE = Items.register( "strontium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_OXALATE = Items.register( "strontium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> STRONTIUM_HYDROXIDE = Items.register( "strontium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //tin ii salts
    public static final RegistryObject<Item> TIN_II_OXIDE = Items.register( "tin_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_FLUORIDE = Items.register( "tin_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_SULFIDE = Items.register( "tin_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_CHLORIDE = Items.register( "tin_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_BROMIDE = Items.register( "tin_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_IODIDE = Items.register( "tin_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_SULFATE = Items.register( "tin_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_ACETATE = Items.register( "tin_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_OXALATE = Items.register( "tin_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_II_HYDROXIDE = Items.register( "tin_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //TIN IV SALTS
    public static final RegistryObject<Item> TIN_IV_OXIDE = Items.register( "tin_iv_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_FLUORIDE = Items.register( "tin_iv_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_SULFIDE = Items.register( "tin_iv_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_CHLORIDE = Items.register( "tin_iv_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_BROMIDE = Items.register( "tin_iv_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_IODIDE = Items.register( "tin_iv_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_ARSENATE = Items.register( "tin_iv_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_NITRATE = Items.register( "tin_iv_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TIN_IV_HYDROXIDE = Items.register( "tin_iv_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //zinc
    public static final RegistryObject<Item> ZINC_OXIDE = Items.register( "zinc_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_FLUORIDE = Items.register( "zinc_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_SULFIDE = Items.register( "zinc_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_CHLORIDE = Items.register( "zinc_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_NITRIDE = Items.register( "zinc_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_BROMIDE = Items.register( "zinc_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_IODIDE = Items.register( "zinc_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_ARSENATE = Items.register( "zinc_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_ARSENITE = Items.register( "zinc_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_PHOSPHATE = Items.register( "zinc_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_DIHYDROGEN_PHOSPHATE = Items.register( "zinc_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_SULFATE = Items.register( "zinc_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_SULFITE = Items.register( "zinc_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_NITRATE = Items.register( "zinc_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_PERCHLORATE = Items.register( "zinc_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_CHLORATE = Items.register( "zinc_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_BROMATE = Items.register( "zinc_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_CARBONATE = Items.register( "zinc_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_CHROMATE = Items.register( "zinc_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_DICHROMATE = Items.register( "zinc_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_ACETATE = Items.register( "zinc_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_FORMATE = Items.register( "zinc_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_CYANIDE = Items.register( "zinc_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_THIOCYANATE = Items.register( "zinc_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_PEROXIDE = Items.register( "zinc_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_HYDROXIDE = Items.register( "zinc_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ZINC_PERMANGANATE = Items.register( "zinc_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //CAESIUM SALTS
    public static final RegistryObject<Item> CAESIUM_OXIDE = Items.register( "caesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_FLUORIDE = Items.register( "caesium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_SULFIDE = Items.register( "caesium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_CHLORIDE = Items.register( "caesium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_BROMIDE = Items.register( "caesium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_IODIDE = Items.register( "caesium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_ARSENATE = Items.register( "caesium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_SULFATE = Items.register( "caesium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_NITRATE = Items.register( "caesium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_PERCHLORATE = Items.register( "caesium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_CARBONATE = Items.register( "caesium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_BICARBONATE = Items.register( "caesium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_CHROMATE = Items.register( "caesium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_ACETATE = Items.register( "caesium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_FORMATE = Items.register( "caesium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_CYANIDE = Items.register( "caesium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CAESIUM_HYDROXIDE = Items.register( "caesium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //rubidium salts
    public static final RegistryObject<Item> RUBIDIUM_OXIDE = Items.register( "rubidium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_FLUORIDE = Items.register( "rubidium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_SULFIDE = Items.register( "rubidium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_CHLORIDE = Items.register( "rubidium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_BROMIDE = Items.register( "rubidium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_IODIDE = Items.register( "rubidium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_SULFATE = Items.register( "rubidium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_PERCHLORATE = Items.register( "rubidium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_CARBONATE = Items.register( "rubidium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_ACETATE = Items.register( "rubidium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_CYANIDE = Items.register( "rubidium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_HYDROXIDE = Items.register( "rubidium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> RUBIDIUM_PERMANGANATE = Items.register( "rubidium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    //TODO: MARKER FOR END OF SALTS
    //Oxides:
    public static final RegistryObject<Item> SILICON_DIOXIDE = Items.register( "silicon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> NITROGEN_DIOXIDE = Items.register( "nitrogen_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Oxides^^^^^
    public static final RegistryObject<Item> POLYVINYL_CHLORIDE = Items.register( "polyvinyl_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CHLOROETHENE = Items.register( "chloroethene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BEESWAX = Items.register( "beeswax",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Main beeswax constituents vvv
    public static final RegistryObject<Item> TRIACONTANYL_PALMITATE = Items.register( "triacontanyl_palmitate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TRIACONTANOL = Items.register( "triacontanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> PALMITIC_ACID = Items.register( "palmitic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> CEROTIC_ACID = Items.register( "cerotic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^
    public static final RegistryObject<Item> HYDROXYAPATITE = Items.register( "hydroxyapatite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> COLLAGEN_TYPE_1 = Items.register( "collagen_type_1",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> PROLINE = Items.register( "proline",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Spider Silk vvvv
    public static final RegistryObject<Item> GLYCINE = Items.register( "glycine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ALANINE = Items.register( "alanine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^^
    public static final RegistryObject<Item> MELANIN = Items.register( "melanin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    //Concrete vvv
    public static final RegistryObject<Item> ALITE = Items.register( "alite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BELITE = Items.register( "belite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TRICALCIUM_SILICATE = Items.register( "tricalcium_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> DICALCIUM_SILICATE = Items.register( "dicalcium_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    //^^^
    public static final RegistryObject<Item> CELLULOSE = Items.register( "cellulose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Standin for keratin  vvvv
    public static final RegistryObject<Item> CYSTEINE = Items.register( "cysteine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BERYLLIUM_ALUMINUM_SILICATE = Items.register( "beryllium_aluminum_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> SILICATE_TETRAHEDRON = Items.register( "silicate_tetrahedron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> NITROGLYCERIN = Items.register( "nitroglycerin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Fish output vvv
    public static final RegistryObject<Item> FISH_OIL = Items.register( "fish_oil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> EICOSAPENTAENOIC_ACID = Items.register( "eicosapentaenoic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> DOCOSAHEXAENOIC_ACID = Items.register( "docosahexaenoic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    // ^^^^
    //Frog Secretions vvv
    //Dermorphin is stronger than morphine. Drug tag needed
    public static final RegistryObject<Item> DERMORPHIN = Items.register( "dermorphin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> DELTORPHIN = Items.register( "deltorphin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^
    //Mushrooms vvv
    public static final RegistryObject<Item> CHITIN = Items.register( "chitin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> N_ACETYLGLUCOSAMINE = Items.register( "n_acetylglucosamine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> GLYCOGEN = Items.register( "glycogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^
    public static final RegistryObject<Item> LAZURITE = Items.register( "lazurite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
     //Red Quartz (Red Stone) 2nd vvv
    public static final RegistryObject<Item> HEMATITE = Items.register( "hematite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Slime vvv
    public static final RegistryObject<Item> POLYVINYL_ALCOHOL = Items.register( "polyvinyl_alcohol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ETHENOL = Items.register( "ethenol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    public static final RegistryObject<Item> SODIUM_TETRABORATE = Items.register( "sodium_tetraborate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^
    public static final RegistryObject<Item> PROPANOL = Items.register( "propanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    public static final RegistryObject<Item> POLYETHYLENE_TEREPHTHALATE = Items.register( "polyethylene_terephthalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> TEREPHTHALIC_ACID = Items.register( "terephthalic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ETHYLENE_GLYCOL = Items.register( "ethylene_glycol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //Sugars:
    public static final RegistryObject<Item> SUCROSE = Items.register( "sucrose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> GLUCOSE = Items.register( "glucose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> FRUCTOSE = Items.register( "fructose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> LACTOSE = Items.register( "lactose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> GALACTOSE = Items.register( "galactose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));

    //Sugars^^^^^
    //candle Wax vvv and other alkanes
    public static final RegistryObject<Item> DOCOSANE = Items.register( "docosane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> OCTADECANE = Items.register( "octadecane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    //^^^
    public static final RegistryObject<Item> METHANE = Items.register( "methane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> ETHANE = Items.register( "ethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> PROPANE = Items.register( "propane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> BUTANE = Items.register( "butane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> PENTANE = Items.register( "pentane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));
    public static final RegistryObject<Item> HEXANE = Items.register( "hexane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:",""));




    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }



}
