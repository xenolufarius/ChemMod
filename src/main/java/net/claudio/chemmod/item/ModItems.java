package net.claudio.chemmod.item;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.effect.ModEffects;

import net.claudio.chemmod.item.custom.ChemicalItem;
import net.claudio.chemmod.item.custom.DeconstructorItem;
import net.claudio.chemmod.item.custom.SolutionItem;
import net.minecraft.server.commands.KillCommand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChemMod.MOD_ID);

    public static void registerChem(String name, RegistryObject<Item> item)
    {
        CHEMICAL_ITEMS.put(name, item);
    }
    private static final Map<String, RegistryObject<Item>> CHEMICAL_ITEMS = new HashMap<>();

    public static final int getHashSize()
    {
        return CHEMICAL_ITEMS.size();
    }


    public static RegistryObject<Item> getByName(String name)
    {
        return CHEMICAL_ITEMS.get(name);
    }

    public static final RegistryObject<Item> CHEMICAL = Items.register( "chemical",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> HOT_PLATE = Items.register( "hot_plate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB)));
    public static final RegistryObject<Item> COPPER_NUGGET = Items.register( "copper_nugget",
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
    //TODO: Recipes (DONE) MOSTLY, STAB (DONE), Villagers (Mostly done. Need to refine later), PNG files (DONE)
    //.food(new FoodProperties.Builder().nutrition(1).effect(new MobEffectInstance(MobEffects.WITHER,600,7),1f).build())
    public static final RegistryObject<Item> HYDROGEN = Items.register( "hydrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 1.01, "H", 0, 1, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> HYDROGEN_GAS = Items.register( "hydrogen_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 2.02, "H2", 0, 4, "\nDesc: Hydrogen is most commonly found as a diatomic gas as H2 (g). It is commonly referred to as Hydrogen Gas.","T", 1));
    public static final RegistryObject<Item> HELIUM = Items.register( "helium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 4.00, "He", 0, 4, "\nDesc: Helium is the first of the noble gases, and is commonly found involved in the fusion reactions in the Sun.","T", 1));
    public static final RegistryObject<Item> LITHIUM = Items.register( "lithium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 6.94, "Li", 0, 1, "\nDesc: Lithium is a highly reactive metal and the lightest solid element. It's often used in batteries.","T", 1));
    public static final RegistryObject<Item> BERYLLIUM = Items.register( "beryllium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 9.01, "Be", 0, 2, "\nDesc: Beryllium is a relatively stable metal known for its high melting point and use in various applications, including aerospace components.","T", 1));
    public static final RegistryObject<Item> BORON = Items.register( "boron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 10.81, "B", 0, 4, "\nDesc: Boron is a nonmetallic element used in various industrial applications, including the production of ceramics and high-strength materials.","T", 1));
    public static final RegistryObject<Item> CARBON = Items.register( "carbon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 12.01, "C", 0, 4, "\nDesc: Carbon is a versatile element that forms the basis of organic chemistry. It exists in various forms, including diamond and graphite.","T", 1));
    public static final RegistryObject<Item> NITROGEN = Items.register( "nitrogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 14.01, "N", 0, 1, "\nDesc: Nitrogen is a diatomic gas (N2) and an essential element for life. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> NITROGEN_GAS = Items.register( "nitrogen_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 28.02, "N2", 0, 4, "\nDesc: Nitrogen is a diatomic gas (N2) and an essential element for life. It makes up a significant portion of Earth's atmosphere.","T", 1));
    public static final RegistryObject<Item> OXYGEN = Items.register( "oxygen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 16.00, "O", 0, 1, "\nDesc: Oxygen is a diatomic gas (O2) essential for respiration and combustion. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> OXYGEN_GAS = Items.register( "oxygen_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 32.00, "O2", 0, 4, "\nDesc: Oxygen is a diatomic gas (O2) essential for respiration and combustion. It's the most abundant element in the Earth's crust.","T", 1));
    public static final RegistryObject<Item> FLUORINE = Items.register( "fluorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 19.00, "F", 0, 1, "\nDesc: Fluorine is a highly reactive diatomic gas (F2) known for its strong oxidizing properties. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> FLUORINE_GAS = Items.register( "fluorine_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 38.00, "F2", 0, 1, "\nDesc: Fluorine is a highly reactive diatomic gas (F2) known for its strong oxidizing properties. It's used in various industrial applications.","T", 1));
    public static final RegistryObject<Item> NEON = Items.register( "neon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 20.18, "Ne", 0, 4, "\nDesc: Neon is a noble gas known for its bright and colorful light emission in neon signs. It's chemically inert and non-reactive.","T", 1));
    public static final RegistryObject<Item> SODIUM = Items.register( "sodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 22.99, "Na", 0, 1, "\nDesc: Sodium is a highly reactive metal known for its vigorous reaction with water. It's commonly used in various chemical and industrial processes.","T", 1));
    public static final RegistryObject<Item> MAGNESIUM = Items.register( "magnesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 24.31, "Mg", 0, 2, "\nDesc: Magnesium is a lightweight and strong metal used in various applications, including alloys and as a reducing agent in the production of metals.","T", 1));
    public static final RegistryObject<Item> ALUMINUM = Items.register( "aluminum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 26.98, "Al", 0, 2, "\nDesc: Aluminum is a versatile metal used extensively in construction, transportation, and various industrial applications. It's known for its low density and corrosion resistance.","T", 1));
    public static final RegistryObject<Item> SILICON = Items.register( "silicon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 28.09, "Si", 0, 4, "\nDesc: Silicon is a fundamental element in semiconductors and electronics. It's also a major component of Earth's crust and is used in various materials.","T", 1));
    public static final RegistryObject<Item> PHOSPHORUS = Items.register( "phosphorus",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 30.97, "P", 0, 1, "\nDesc: Phosphorus is an essential element for life, found in DNA, RNA, and ATP. It is often found as white phosphorous as a cluster of 4 atoms in a tetrahedral orientation. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> WHITE_PHOSPHORUS = Items.register( "white_phosphorus",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 123.90, "P4", 0, 4, "\nDesc: White Phosphorus is the most common stable form of Phosphorus found on Earth. Phosphorus is an essential element for life, found in DNA, RNA, and ATP. It's used in various industries, including fertilizers and detergents.","T", 1));
    public static final RegistryObject<Item> SULFUR = Items.register( "sulfur",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 32.07, "S", 0, 1, "\nDesc: Sulfur is a non-metal essential for life and used in various industrial processes. It often forms rings of 8, known as octasulfur. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> OCTASULFUR = Items.register( "octasulfur",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 256.52, "S8", 0, 4, "\nDesc: Octasulfur is the most common stable form of sulfur. Sulfur is a non-metal essential for life and used in various industrial processes, including the production of sulfuric acid.","T", 1));
    public static final RegistryObject<Item> CHLORINE = Items.register( "chlorine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 35.45, "Cl", 0, 1, "\nDesc: Chlorine is a highly reactive diatomic element used in disinfectants, plastics, and as a component of table salt (sodium chloride). It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> CHLORINE_GAS = Items.register( "chlorine_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 70.90, "Cl2", 0, 4, "\nDesc: Chlorine is a highly reactive diatomic element used in disinfectants, plastics, and as a component of table salt (sodium chloride).","T", 1));
    public static final RegistryObject<Item> ARGON = Items.register( "argon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 39.95, "Ar", 0, 4, "\nDesc: Argon is a noble gas known for its inertness. It's used in various applications, including welding and lighting.","T", 1));
    public static final RegistryObject<Item> POTASSIUM = Items.register( "potassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 39.10, "K", 0, 1, "\nDesc: Potassium is an essential mineral for plant and animal nutrition. It's highly reactive with water.","S1", 1));
    public static final RegistryObject<Item> CALCIUM = Items.register( "calcium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 40.08, "Ca", 0, 4, "\nDesc: Calcium is vital for the formation of bones and teeth. It's not highly reactive under normal conditions.","T", 1));
    public static final RegistryObject<Item> SCANDIUM = Items.register( "scandium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 44.96, "Sc", 0, 4, "\nDesc: Scandium is a rare and moderately stable transition metal. It's used in aerospace and lighting applications.","T", 1));
    public static final RegistryObject<Item> TITANIUM = Items.register( "titanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 47.87, "Ti", 0, 4, "\nDesc: Titanium is a strong and lightweight metal used in aerospace and medical implants.","T", 1));
    public static final RegistryObject<Item> VANADIUM = Items.register( "vanadium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 50.94, "V", 0, 4, "\nDesc: Vanadium is a transition metal known for its strength and resistance to corrosion.","T", 1));
    public static final RegistryObject<Item> CHROMIUM = Items.register( "chromium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 51.99, "Cr", 0, 4, "\nDesc: Chromium is used in stainless steel production and has a shiny, reflective surface.","T", 1));
    public static final RegistryObject<Item> MANGANESE = Items.register( "manganese",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 54.94, "Mn", 0, 4, "\nDesc: Manganese is essential for steel production and is used in batteries.","T", 1));
    public static final RegistryObject<Item> IRON = Items.register( "iron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 55.85, "Fe", 0, 4, "\nDesc: Iron is a crucial element in many industrial applications, including construction and transportation.","T", 1));
    public static final RegistryObject<Item> COBALT = Items.register( "cobalt",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 58.93, "Co", 0, 4, "\nDesc: Cobalt is used in alloys, magnets, and medical devices due to its magnetic properties.","T", 1));
    public static final RegistryObject<Item> NICKEL = Items.register( "nickel",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 58.69, "Ni", 0, 4, "\nDesc: Nickel is used in alloys, batteries, and as a protective coating for other metals.","T", 1));
    public static final RegistryObject<Item> COPPER = Items.register( "copper",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 63.55, "Cu", 0, 4, "\nDesc: Copper is a highly conductive metal used in electrical wiring and various applications.","T", 1));
    public static final RegistryObject<Item> ZINC = Items.register( "zinc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 65.38, "Zn", 0, 4, "\nDesc: Zinc is used in galvanizing, alloys, and as a dietary supplement.","T", 1));
    public static final RegistryObject<Item> GALLIUM = Items.register( "gallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 69.72, "Ga", 0, 4, "\nDesc: Gallium is used in semiconductors and can melt in your hand due to its low melting point.","T", 1));
    public static final RegistryObject<Item> GERMANIUM = Items.register( "germanium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 72.63, "Ge", 0, 4, "\nDesc: Germanium is used in transistors and has semiconductor properties.","T", 1));
    public static final RegistryObject<Item> ARSENIC = Items.register( "arsenic",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 74.92, "As", 0, 4, "\nDesc: Arsenic is known for its toxicity and is used in some electronic devices and semiconductors.","T", 1));
    public static final RegistryObject<Item> SELENIUM = Items.register( "selenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 78.97, "Se", 0, 4, "\nDesc: Selenium is used in electronics and as a dietary supplement.","T", 1));
    public static final RegistryObject<Item> BROMINE = Items.register( "bromine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 79.90, "Br", 0, 1, "\nDesc: Bromine is a reddish-brown liquid at room temperature and is used in flame retardants. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> BROMINE_GAS = Items.register( "bromine_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 159.80, "Br2", 0, 4, "\nDesc: Bromine is a reddish-brown liquid at room temperature and is used in flame retardants.","T", 1));
    public static final RegistryObject<Item> KRYPTON = Items.register( "krypton",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 83.80, "Kr", 0, 4, "\nDesc: Krypton is a noble gas used in lighting and lasers.","T", 1));
    public static final RegistryObject<Item> RUBIDIUM = Items.register( "rubidium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 85.47, "Rb", 0, 2, "\nDesc: Rubidium is an alkali metal used in research and electronics.","T", 1));
    public static final RegistryObject<Item> STRONTIUM = Items.register( "strontium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 87.62, "Sr", 0, 4, "\nDesc: Strontium is used in fireworks and flares to produce red colors.","T", 1));
    public static final RegistryObject<Item> YTTRIUM = Items.register( "yttrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 88.91, "Y", 0, 4, "\nDesc: Yttrium is used in alloys and phosphors for color television tubes.","T", 1));
    public static final RegistryObject<Item> ZIRCONIUM = Items.register( "zirconium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 91.22, "Zr", 0, 4, "\nDesc: Zirconium is used in nuclear reactors and as an alloying agent.","T", 1));
    public static final RegistryObject<Item> NIOBIUM = Items.register( "niobium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 92.91, "Nb", 0, 4, "\nDesc: Niobium is used in superconductors and alloys for jet engines.","T", 1));
    public static final RegistryObject<Item> MOLYBDENUM = Items.register( "molybdenum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 95.94, "Mo", 0, 4, "\nDesc: Molybdenum is used in steel alloys and as a catalyst in chemical reactions.","T", 1));
    public static final RegistryObject<Item> TECHNETIUM = Items.register( "technetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 98.00, "Tc", 0, 4, "\nDesc: Technetium is a synthetic element used in medical imaging and research.","T", 1));
    public static final RegistryObject<Item> RUTHENIUM = Items.register( "ruthenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 101.07, "Ru", 0, 4, "\nDesc: Ruthenium is used in electronics, catalysts, and jewelry for its durability.","T", 1));
    public static final RegistryObject<Item> RHODIUM = Items.register( "rhodium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 102.91, "Rh", 0, 4, "\nDesc: Rhodium is used in catalytic converters, jewelry, and electrical contacts.","T", 1));
    public static final RegistryObject<Item> PALLADIUM = Items.register( "palladium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 106.42, "Pd", 0, 4, "\nDesc: Palladium is used in catalytic converters, electronics, and jewelry.","T", 1));
    public static final RegistryObject<Item> SILVER = Items.register( "silver",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 107.87, "Ag", 0, 4, "\nDesc: Silver is valued for its use in currency, jewelry, and electronics.","T", 1));
    public static final RegistryObject<Item> CADMIUM = Items.register( "cadmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 112.41, "Cd", 0, 4, "\nDesc: Cadmium is used in batteries, pigments, and nuclear reactors.","T", 1));
    public static final RegistryObject<Item> INDIUM = Items.register( "indium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 114.82, "In", 0, 4, "\nDesc: Indium is used in semiconductors, solar panels, and as a solder.","T", 1));
    public static final RegistryObject<Item> TIN = Items.register( "tin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 118.71, "Sn", 0, 4, "\nDesc: Tin is used in solder, coatings, and alloys.","T", 1));
    public static final RegistryObject<Item> ANTIMONY = Items.register( "antimony",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 121.76, "Sb", 0, 4, "\nDesc: Antimony is used in flame retardants and alloys.","T", 1));
    public static final RegistryObject<Item> TELLURIUM = Items.register( "tellurium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 127.60, "Te", 0, 4, "\nDesc: Tellurium is used in solar panels and alloys.","T", 1));
    public static final RegistryObject<Item> IODINE = Items.register( "iodine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 126.90, "I", 0, 1, "\nDesc: Iodine is commonly used in medicine, particularly in the form of iodine solutions for disinfection. It is unstable in its monoatomic state.","T", 1));
    public static final RegistryObject<Item> IODINE_GAS = Items.register( "iodine_gas",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 253.80, "I2", 0, 4, "\nDesc: Iodine is commonly used in medicine, particularly in the form of iodine solutions for disinfection.","T", 1));
    public static final RegistryObject<Item> XENON = Items.register( "xenon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 131.29, "Xe", 0, 4, "\nDesc: Xenon is employed in various applications, including lighting and anesthesia.","T", 1));
    public static final RegistryObject<Item> CAESIUM = Items.register( "caesium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 132.91, "Cs", 0, 1, "\nDesc: Caesium has uses in atomic clocks and drilling fluids, but it requires careful handling due to its reactivity with air and water.","T", 1));
    public static final RegistryObject<Item> BARIUM = Items.register( "barium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 137.33, "Ba", 0, 4, "\nDesc: Barium is employed in various industries, including the production of drilling fluids and glass.","T", 1));
    public static final RegistryObject<Item> LANTHANUM = Items.register( "lanthanum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 138.91, "La", 0, 4, "\nDesc: Lanthanum is a rare earth element with various applications, including in catalysts and optics.","T", 1));
    public static final RegistryObject<Item> CERIUM = Items.register( "cerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 140.12, "Ce", 0, 4, "\nDesc: Cerium is a rare earth metal known for its use in catalytic converters and in making glass.","T", 1));
    public static final RegistryObject<Item> PRASEODYMIUM = Items.register( "praseodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 140.91, "Pr", 0, 4, "\nDesc: Praseodymium is a rare earth element used in magnets, lasers, and as a catalyst.","T", 1));
    public static final RegistryObject<Item> NEODYMIUM = Items.register( "neodymium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 144.24, "Nd", 0, 4, "\nDesc: Neodymium is used in powerful magnets, lasers, and as a coloring agent in glasses and ceramics.","T", 1));
    public static final RegistryObject<Item> PROMETHIUM = Items.register( "promethium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 145.00, "Pm", 3, 4, "\nDesc: Promethium is a radioactive rare earth element used in atomic batteries and luminous paints.","T", 1));
    public static final RegistryObject<Item> SAMARIUM = Items.register( "samarium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 150.36, "Sm", 0, 4, "\nDesc: Samarium is used in magnets, nuclear reactors, and as a neutron absorber in control rods.","T", 1));
    public static final RegistryObject<Item> EUROPIUM = Items.register( "europium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 152.00, "Eu", 3, 4, "\nDesc: Europium is a radioactive rare earth element used in phosphors for color displays and as a neutron absorber.","T", 1));
    public static final RegistryObject<Item> GADOLINIUM = Items.register( "gadolinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 157.25, "Gd", 0, 4, "\nDesc: Gadolinium is used in MRI contrast agents, neutron capture therapy, and in fuel rods for nuclear reactors.","T", 1));
    public static final RegistryObject<Item> TERBIUM = Items.register( "terbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 158.93, "Tb", 0, 4, "\nDesc: Terbium is used in phosphors for color displays and as a dopant in solid-state devices.","T", 1));
    public static final RegistryObject<Item> DYSPROSIUM = Items.register( "dysprosium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 162.50, "Dy", 0, 4, "\nDesc: Dysprosium is used in permanent magnets, control rods for nuclear reactors, and in lighting applications.","T", 1));
    public static final RegistryObject<Item> HOLMIUM = Items.register( "holmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 164.93, "Ho", 0, 4, "\nDesc: Holmium is used in lasers, control rods for nuclear reactors, and as a flux in certain types of iron and steel.","T", 1));
    public static final RegistryObject<Item> ERBIUM = Items.register( "erbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 167.26, "Er", 0, 4, "\nDesc: Erbium is used in lasers, fiber optics, and as a neutron-absorbing control rod material in nuclear reactors.","T", 1));
    public static final RegistryObject<Item> THULIUM = Items.register( "thulium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 168.93, "Tm", 0, 4, "\nDesc: Thulium is used in portable X-ray devices and as a dopant in some solid-state lasers.","T", 1));
    public static final RegistryObject<Item> YTTERBIUM = Items.register( "ytterbium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 173.05, "Yb", 0, 4, "\nDesc: Ytterbium is used in certain types of lasers, nuclear medicine, and as a dopant in fiber optic amplifiers.","T", 1));
    public static final RegistryObject<Item> LUTETIUM = Items.register( "lutetium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 175.94, "Lu", 0, 4, "\nDesc: Lutetium is used in certain types of radiation therapy for cancer treatment and as a catalyst in various chemical reactions.","T", 1));
    public static final RegistryObject<Item> HAFNIUM = Items.register( "hafnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 178.49, "Hf", 0, 4, "\nDesc: Hafnium is used in nuclear reactors as control rods, in semiconductor manufacturing, and as an alloying agent in superalloys.","T", 1));
    public static final RegistryObject<Item> TANTALUM = Items.register( "tantalum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 180.95, "Ta", 0, 4, "\nDesc: Tantalum is used in electronics, aircraft, and medical implants due to its corrosion resistance and high melting point.","T", 1));
    public static final RegistryObject<Item> TUNGSTEN = Items.register( "tungsten",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 183.84, "W", 0, 4, "\nDesc: Tungsten has the highest melting point of all elements and is used in various applications, including light bulb filaments and aerospace components.","T", 1));
    public static final RegistryObject<Item> RHENIUM = Items.register( "rhenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 186.21, "Re", 0, 4, "\nDesc: Rhenium is used in high-temperature superalloys for jet engines and in the production of filaments for mass spectrometry and X-ray tubes.","T", 1));
    public static final RegistryObject<Item> OSMIUM = Items.register( "osmium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 190.23, "Os", 0, 4, "\nDesc: Osmium is the densest naturally occurring element and is used in fountain pen tips, electrical contacts, and as an alloying agent in the platinum industry.","T", 1));
    public static final RegistryObject<Item> IRIDIUM = Items.register( "iridium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 192.22, "Ir", 0, 4, "\nDesc: Iridium is known for its high density and is used in spark plugs, electrical contacts, and in the manufacture of crucibles and other equipment that must withstand high temperatures.","T", 1));
    public static final RegistryObject<Item> PLATINUM = Items.register( "platinum",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 195.08, "Pt", 0, 4, "\nDesc: Platinum is valued for its use in jewelry, catalytic converters, and as a standard for measuring mass and weight in the metric system.","T", 1));
    public static final RegistryObject<Item> GOLD = Items.register( "gold",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 196.97, "Au", 0, 4, "\nDesc: Gold is known for its beauty and is used in jewelry, coinage, and electronics. It does not tarnish and is an excellent conductor of electricity.","T", 1));
    public static final RegistryObject<Item> MERCURY = Items.register( "mercury",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 200.59, "Hg", 0, 4, "\nDesc: Mercury is a unique metal that is liquid at room temperature. It has been used in thermometers, barometers, and dental fillings, although its use is declining due to its toxicity.","T", 1));
    public static final RegistryObject<Item> THALLIUM = Items.register( "thallium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 204.38, "Tl", 1, 4, "\nDesc: Thallium is a toxic metal that has various industrial applications.","T", 1));
    public static final RegistryObject<Item> LEAD = Items.register( "lead",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 207.2, "Pb", 0, 4, "\nDesc: Lead is a dense metal commonly used in construction and batteries.","T", 1));
    public static final RegistryObject<Item> BISMUTH = Items.register( "bismuth",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 208.98, "Bi", 0, 4, "\nDesc: Bismuth is a heavy metal often used in pharmaceuticals and cosmetics.","T", 1));
    public static final RegistryObject<Item> POLONIUM = Items.register( "polonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 208.98, "Po", 2, 4, "\nDesc: Polonium is a highly radioactive element, and its most common isotope is extremely toxic.","T", 1));
    public static final RegistryObject<Item> ASTATINE = Items.register( "astatine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 210.00, "At", 3, 0, "\nDesc: Astatine is a rare and highly radioactive element with no stable isotopes.","T", 1));
    public static final RegistryObject<Item> RADON = Items.register( "radon",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 222.00, "Rn", 3, 4, "\nDesc: Radon is a colorless, odorless, and highly radioactive noble gas that poses health risks when inhaled.","T", 1));
    public static final RegistryObject<Item> FRANCIUM = Items.register( "francium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 223.00, "Fr", 4, 0, "\nDesc: Francium is an extremely rare and highly radioactive element, often considered the rarest naturally occurring element on Earth.","T", 1));
    public static final RegistryObject<Item> RADIUM = Items.register( "radium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 226.00, "Ra", 3, 2, "\nDesc: Radium is a highly radioactive element known for its luminescence and was once used in glow-in-the-dark paint.","T", 1));
    public static final RegistryObject<Item> ACTINIUM = Items.register( "actinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 227.00, "Ac", 3, 2, "\nDesc: Actinium is a highly radioactive element often used in radiation therapy for cancer treatment.","T", 1));
    public static final RegistryObject<Item> THORIUM = Items.register( "thorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 232.04, "Th", 4, 2, "\nDesc: Thorium is a radioactive element with applications in nuclear reactors and potential as a nuclear fuel.","T", 1));
    public static final RegistryObject<Item> PROTACTINIUM = Items.register( "protactinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 231.04, "Pa", 3, 2, "\nDesc: Protactinium is a radioactive element with limited practical uses but plays a role in the decay chain of uranium.","T", 1));
    public static final RegistryObject<Item> URANIUM = Items.register( "uranium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 238.03, "U", 4, 2, "\nDesc: Uranium is a radioactive element with applications in nuclear reactors, nuclear weapons, and as a fuel in nuclear power.","T", 1));
    public static final RegistryObject<Item> NEPTUNIUM = Items.register( "neptunium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 237.00, "Np", 3, 2, "\nDesc: Neptunium is a radioactive element used in nuclear reactors and has potential applications in nuclear weapons.","T", 1));
    public static final RegistryObject<Item> PLUTONIUM = Items.register( "plutonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 244.00, "Pu", 3, 2, "\nDesc: Plutonium is a radioactive element used in nuclear reactors, nuclear weapons, and as a fuel in nuclear power.","T", 1));
    public static final RegistryObject<Item> AMERICIUM = Items.register( "americium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 243.00, "Am", 3, 2, "\nDesc: Americium is a radioactive element used in smoke detectors and some nuclear reactors.","T", 1));
    public static final RegistryObject<Item> CURIUM = Items.register( "curium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 247.00, "Cm", 3, 2, "\nDesc: Curium is a radioactive element used in the production of neutron sources and some types of nuclear reactors.","T", 1));
    public static final RegistryObject<Item> BERKELIUM = Items.register( "berkelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 247.00, "Bk", 3, 2, "\nDesc: Berkelium is a radioactive element used in the synthesis of heavier elements and scientific research.","T", 1));
    public static final RegistryObject<Item> CALIFORNIUM = Items.register( "californium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 251.00, "Cf", 3, 2, "\nDesc: Californium is a radioactive element used in neutron sources and as a target in nuclear physics experiments.","T", 1));
    public static final RegistryObject<Item> EINSTEINIUM = Items.register( "einsteinium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 252.00, "Es", 3, 2, "\nDesc: Einsteinium is a highly radioactive element used in scientific research and the production of heavier elements.","T", 1));
    public static final RegistryObject<Item> FERMIUM = Items.register( "fermium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 257.00, "Fm", 3, 2, "\nDesc: Fermium is a highly radioactive element used in scientific research and the production of heavier elements.","T", 1));
    public static final RegistryObject<Item> MENDELEVIUM = Items.register( "mendelevium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 258.00, "Md", 4, 2, "\nDesc: Mendelevium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> NOBELIUM = Items.register( "nobelium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 259.00, "No", 4, 0, "\nDesc: Nobelium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> LAWRENCIUM = Items.register( "lawrencium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 266.00, "Lr", 4, 0, "\nDesc: Lawrencium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> RUTHERFORDIUM = Items.register( "rutherfordium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 267.00, "Rf", 4, 0, "\nDesc: Rutherfordium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> DUBNIUM = Items.register( "dubnium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 268.00, "Db", 4, 0, "\nDesc: Dubnium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> SEABORGIUM = Items.register( "seaborgium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 269.00, "Sg", 4, 0, "\nDesc: Seaborgium is a radioactive element used in nuclear research and the synthesis of heavier elements.","T", 1));
    public static final RegistryObject<Item> BOHRIUM = Items.register( "bohrium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 270.134, "Bh", 4, 0, "\nDesc: A highly radioactive element with an exceptionally short half-life measured in milliseconds. Bohrium is synthesized in particle accelerators and is crucial for the study of nuclear physics and the formation of superheavy elements.","T", 1));
    public static final RegistryObject<Item> HASSIUM = Items.register( "hassium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 277.152, "Hs", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Hassium is synthesized in laboratories and contributes to the exploration of nuclear physics and superheavy elements.","T", 1));
    public static final RegistryObject<Item> MEITNERIUM = Items.register( "meitnerium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 278.156, "Mt", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Meitnerium is produced in particle accelerators and aids in the exploration of nuclear physics and superheavy elements.","T", 1));
    public static final RegistryObject<Item> DARMSTADTIUM = Items.register( "darmstadtium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 281.162, "Ds", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Darmstadtium is produced in controlled laboratory environments and plays a critical role in advancing nuclear physics research and the understanding of superheavy elements.","T", 1));
    public static final RegistryObject<Item> ROENTGENIUM = Items.register( "roentgenium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 282.166, "Rg", 4, 0, "\nDesc: An extremely radioactive element with an incredibly short half-life measured in milliseconds. Roentgenium is synthesized in particle accelerators and is invaluable for nuclear physics research and superheavy element studies.","T", 1));
    public static final RegistryObject<Item> COPERNICIUM = Items.register( "copernicium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 285.178, "Cn", 4, 0, "\nDesc: A highly radioactive element with a brief half-life measured in milliseconds. Copernicium is created in controlled laboratory environments and contributes to advances in nuclear physics and superheavy element investigations.","T", 1));
    public static final RegistryObject<Item> NIHONIUM = Items.register( "nihonium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 286.190, "Nh", 4, 0, "\nDesc: A highly radioactive element with an exceedingly short half-life measured in milliseconds. Nihonium is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies.","T", 1));
    public static final RegistryObject<Item> FLEROVIUM = Items.register( "flerovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 289.193, "Fl", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Flerovium is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations.","T", 1));
    public static final RegistryObject<Item> MOSCOVIUM = Items.register( "moscovium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 290.196, "Mc", 4, 0, "\nDesc: An extremely radioactive element with an exceptionally brief half-life measured in milliseconds. Moscovium is produced in particle accelerators and plays a crucial role in nuclear physics research and superheavy element investigations.","T", 1));
    public static final RegistryObject<Item> LIVERMORIUM = Items.register( "livermorium",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 293.205, "Lv", 4, 0, "\nDesc: An extremely radioactive element with an exceedingly short half-life measured in milliseconds. Livermorium is created in controlled laboratory environments and contributes significantly to nuclear physics research and superheavy element studies.","T", 1));
    public static final RegistryObject<Item> TENNESSINE = Items.register( "tennessine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 294.211, "Ts", 4, 0, "\nDesc: An extremely radioactive element with an incredibly brief half-life measured in milliseconds. Tennessine is synthesized in particle accelerators and contributes significantly to nuclear physics research and superheavy element studies.","T", 1));
    public static final RegistryObject<Item> OGANESSON = Items.register( "oganesson",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 294.214, "Og", 4, 0, "\nDesc: An extremely radioactive element with an extremely brief half-life measured in milliseconds. Oganesson is created in controlled laboratory environments and is essential for the progress of nuclear physics research and superheavy element investigations.","T", 1));

    //Molecules
    public static final RegistryObject<Item> WATER = Items.register( "water",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),18.02,"H2O",0,4,"\nDesc: This is perhaps the most important molecule for life.","", 1));
    public static final RegistryObject<Item> CARBON_DIOXIDE = Items.register( "carbon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),44.01,"CO2",0,4,"\nDesc: This is the primary source of carbon for life.","", 1));
    public static final RegistryObject<Item> AMMONIA = Items.register( "ammonia",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),17.03,"NH3",0,4,"\nDesc: This is a common precursor to fertilizers.","G,C,T,A", 1));
    //Salts:
    //list out anions: Cl, C03, SO4, HCO3, OH, NO3, Cr2O7, CN, ClO3, PO4,
    //list out cations: Li, Be, Na, Mg, K, Ca, Rb, Sr, Cs, Ba, Fr, Ra, NH4
    //sodium salts
    public static final RegistryObject<Item> SODIUM_OXIDE = Items.register( "sodium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),61.98,"Na2O",0,4,"\nDesc: A widely used compound, which finds use in the production of ceramics and glasses.","C,S1", 3));
    public static final RegistryObject<Item> SODIUM_FLUORIDE = Items.register( "sodium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),41.99,"NaF",0,4,"\nDesc: Sodium Fluoride has medicinal uses, used as an active ingredient in toothpastes to prevent decay.","T,I,H", 0));
    public static final RegistryObject<Item> SODIUM_SULFIDE = Items.register( "sodium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),78.05,"Na2S",0,4,"\nDesc: This compound finds its use in the paper and pulp production industries.","C,T,I,A", 1));
    public static final RegistryObject<Item> SODIUM_CHLORIDE = Items.register( "sodium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.44,"NaCl",0,4,"\nDesc: This compound is widely used, most known for its culinary use as table salt.","", 2));
    public static final RegistryObject<Item> SODIUM_NITRIDE = Items.register( "sodium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),82.98,"Na3N",0,0,"\nDesc: Unfortunately, Sodium Nitride is too unstable to be used for much.","", 1));
    public static final RegistryObject<Item> SODIUM_BROMIDE = Items.register( "sodium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),102.89,"NaBr",0,4,"\nDesc: It finds use as a readily available form of bromide ions for other processes.","", 1));
    public static final RegistryObject<Item> SODIUM_IODIDE = Items.register( "sodium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.89,"NaI",0,4,"\nDesc: This nutritional supplement also finds use in organic chemistry.","I,A", 1));
    public static final RegistryObject<Item> SODIUM_ARSENATE = Items.register( "sodium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),207.89,"Na3AsO4",0,4,"\nDesc: It is most commonly handled as a dodecahydrate (+12 H20).","T,H,A", 1));
    public static final RegistryObject<Item> SODIUM_ARSENITE = Items.register( "sodium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),129.91,"NaAsO2",0,4,"\nDesc: Useful as a pesticide.","T,H,A", 1));
    public static final RegistryObject<Item> SODIUM_PHOSPHATE = Items.register( "sodium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),163.94,"Na3PO4",0,4,"\nDesc: Known as Trisodium Phosphate (TSP), and used for cleaning.","C,I", 1));
    public static final RegistryObject<Item> SODIUM_DIHYDROGEN_PHOSPHATE = Items.register( "sodium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.98,"NaH2P04",0,4,"\nDesc: Known as Monosodium Phosphate (MSP), and used as a thickening agent in water treatment.","", 1));
    public static final RegistryObject<Item> SODIUM_SULFATE = Items.register( "sodium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),142.04,"Na2SO4",0,4,"\nDesc: Handled most commonly in its dodecahydrate form, and is found in laundry detergent.","I", 1));
    public static final RegistryObject<Item> SODIUM_HYDROGEN_SULFATE = Items.register( "sodium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),120.06,"NaHSO4",0,4,"\nDesc: It is useful in lowering the pH of a solution, and can also be used for cleaning.","C", 1));
    public static final RegistryObject<Item> SODIUM_THIOSULFATE = Items.register( "sodium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.11,"Na2S2O3",0,4,"\nDesc: Useful as a bleaching agent, especially to make colorless dyes.","I", 1));
    public static final RegistryObject<Item> SODIUM_SULFITE = Items.register( "sodium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.04,"Na2SO3",0,4,"\nDesc: Sodium Sulfite finds use in the paper / pulp industry.","", 1));
    public static final RegistryObject<Item> SODIUM_NITRATE = Items.register( "sodium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.99,"NaNO3",0,4,"\nDesc: A useful fertilizer, also known as Chile Saltpeter.","O,I", 1));
    public static final RegistryObject<Item> SODIUM_NITRITE = Items.register( "sodium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),69.00,"NaNO2",0,4,"\nDesc: This compound has a wide range of use, from being used as a food additive to pesticides and pharmacology.","O,T,A", 1));
    public static final RegistryObject<Item> SODIUM_PERCHLORATE = Items.register( "sodium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.44,"NaClO4",0,4,"\nDesc: This has been found on planet Mars, and is used as a precursor to other perchlorates.","O,I,H", 1));
    public static final RegistryObject<Item> SODIUM_CHLORATE = Items.register( "sodium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),106.44,"NaClO3",0,4,"\nDesc: Finds use in the production of chlorine dioxide.","O,I,A", 1));
    public static final RegistryObject<Item> SODIUM_CHLORITE = Items.register( "sodium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.44,"NaClO2",0,4,"\nDesc: Finds use in the production of chlorine dioxide.","O,C,T,A", 1));
    public static final RegistryObject<Item> SODIUM_HYPOCHLORITE = Items.register( "sodium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.44,"NaClO",0,4,"\nDesc: This is also known as household bleach.","O,C,A", 1));
    public static final RegistryObject<Item> SODIUM_IODATE = Items.register( "sodium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),197.89,"NaIO3",0,4,"\nDesc: This is also known as iodized salt.","O,I,A", 1));
    public static final RegistryObject<Item> SODIUM_BROMATE = Items.register( "sodium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.89,"NaBrO3",0,4,"\nDesc: Sodium Bromate is used in the dyeing industry in vat dyes.","O,I,H", 1));
    public static final RegistryObject<Item> SODIUM_CARBONATE = Items.register( "sodium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),105.99,"Na2CO3",0,4,"\nDesc: Also known as soda ash, this compound has a wide range of uses.","I", 1));
    public static final RegistryObject<Item> SODIUM_BICARBONATE = Items.register( "sodium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.00,"NaHCO3",0,4,"\nDesc: Also known as baking soda, this compound has a wide range of uses.","I", 1));
    public static final RegistryObject<Item> SODIUM_CHROMATE = Items.register( "sodium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),161.97,"Na2CrO4",0,4,"\nDesc: Mainly used to produce other chromium compounds and in organic chemistry.","C,T,I,H,A", 1));
    public static final RegistryObject<Item> SODIUM_DICHROMATE = Items.register( "sodium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),261.97,"Na2Cr2O7",0,4,"\nDesc: Can be used as a way to store chromium in a stable and readily available form.","O,C,T,I,H,A", 1));
    public static final RegistryObject<Item> SODIUM_ACETATE = Items.register( "sodium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),82.03,"NaC2H3O2",0,4,"\nDesc: This has a wide range use, mainly as the salt form of acetic acid for ready use.","I", 1));
    public static final RegistryObject<Item> SODIUM_FORMATE = Items.register( "sodium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.00,"NaHCO2",0,4,"\nDesc: Useful for fabric dyeing and printing.","", 1));
    public static final RegistryObject<Item> SODIUM_CYANIDE = Items.register( "sodium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),49.01,"NaCN",0,4,"\nDesc: This heavily toxic compound is useful in gold mining.","T,A", 1));
    public static final RegistryObject<Item> SODIUM_CYANATE = Items.register( "sodium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.01,"NaOCN",0,4,"\nDesc: Sodium Cyanate is detoxified Sodium Cyanide and is used in steel hardening","I", 1));
    public static final RegistryObject<Item> SODIUM_THIOCYANATE = Items.register( "sodium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),81.07,"NaSCN",0,4,"\nDesc: Used in the synthesis of pharmaceuticals.","C,I", 1));
    public static final RegistryObject<Item> SODIUM_PEROXIDE = Items.register( "sodium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),77.98,"NA2O2",0,4,"\nDesc: Mainly used in mineral extraction.","O,C", 1));
    public static final RegistryObject<Item> SODIUM_OXALATE = Items.register( "sodium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),134.00,"Na2C2O4",0,4,"\nDesc: This compound is the sodium salt of oxalic acid.","I", 1));
    public static final RegistryObject<Item> SODIUM_HYDROXIDE = Items.register( "sodium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),40.00,"NaOH",0,4,"\nDesc: This compound has a wide range of application, popularly as a base.","C,I", 1));
    public static final RegistryObject<Item> SODIUM_PERMANGANATE = Items.register( "sodium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),141.93,"NaMnO4",0,4,"\nDesc: Finds use in water treatment operations.","O", 1));
    //lithium salts
    public static final RegistryObject<Item> LITHIUM_OXIDE = Items.register( "lithium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),29.88,"Li2O",0,4,"\nDesc: Often used as flux for the production of ceramic glasses.","C,S1,S2", 1));
    public static final RegistryObject<Item> LITHIUM_FLUORIDE = Items.register( "lithium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),25.94,"LiF",0,4,"\nDesc: A component in molten salts.","T,S2", 1));
    public static final RegistryObject<Item> LITHIUM_SULFIDE = Items.register( "lithium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),45.95,"Li2S",0,4,"\nDesc: This material has been proposed for use in a lithium-sulfur battery.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_CHLORIDE = Items.register( "lithium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),42.39,"LiCl",0,4,"\nDesc: Used in the production of lithium metal, and also as a flame colorant.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_NITRIDE = Items.register( "lithium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),34.83,"Li3N",0,4,"\nDesc: This compound reacts violently with water to produce ammonia.","F,C,S1,S2", 1));
    public static final RegistryObject<Item> LITHIUM_BROMIDE = Items.register( "lithium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),86.85,"LiBr",0,4,"\nDesc: Useful as a desiccant in air conditioning units.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_IODIDE = Items.register( "lithium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.85,"LiI",0,2,"\nDesc: This compound can be found in artificial pacemakers.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_ARSENATE = Items.register( "lithium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.80,"Li3AsO4",0,4,"\nDesc: Not much is known about this molecule.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_PHOSPHATE = Items.register( "lithium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.79,"Li3PO4",0,4,"\nDesc: Can be found in lithium batteries.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_SULFATE = Items.register( "lithium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),109.94,"Li2SO4",0,4,"\nDesc: This drug can be used as a mood stabilizer for bipolar disorder.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_HYDROGEN_SULFATE = Items.register( "lithium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),104.00,"LiHSO4",0,4,"\nDesc: Not much is known about this compound.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_THIOSULFATE = Items.register( "lithium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.00,"Li2S2O3",0,4,"\nDesc: This compound shows promising use in inorganic chemistry.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_SULFITE = Items.register( "lithium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),93.94,"Li2SO3",0,4,"\nDesc: Not much is known about this compound.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_NITRATE = Items.register( "lithium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.95,"LiNO3",0,4,"\nDesc: In pyrotechnics, it is used in the production of red fireworks and flares.","O,I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_NITRITE = Items.register( "lithium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),52.95,"LiNO2",0,4,"\nDesc: Is used in mortar as a corrosion inhibitor, and has been used to make explosives.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_PERCHLORATE = Items.register( "lithium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),106.39,"LiClO4",0,4,"\nDesc: Found in lithium batteries, and has applications in chemistry labs.","O,I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_CHLORATE = Items.register( "lithium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.39,"LiClO3",0,4,"\nDesc: Has potential use in the production of flow-batteries.","O,S2", 1));
    public static final RegistryObject<Item> LITHIUM_CHLORITE = Items.register( "lithium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.40,"LiClO2",0,4,"\nDesc: Not Much is know about this compound.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_HYPOCHLORITE = Items.register( "lithium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.39,"LiClO",0,4,"\nDesc: Commonly used as a pool disinfectant.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_IODATE = Items.register( "lithium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),181.84,"LiIO3",0,4,"\nDesc: Used to make 347 nm ruby lasers.","O,I,H,S2", 1));
    public static final RegistryObject<Item> LITHIUM_CARBONATE = Items.register( "lithium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),73.89,"Li2CO3",0,4,"\nDesc: This molecule in on the World Health Organization's list of essential medicines. Used to treat mood disorders.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_BICARBONATE = Items.register( "lithium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),67.96,"LiHCO3",0,4,"\nDesc: Not much is known about this molecule.","S2", 1));
    public static final RegistryObject<Item> LITHIUM_CHROMATE = Items.register( "lithium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),129.90,"Li2CrO4",0,4,"\nDesc: Used in the processes of leather and metal finishing.","T,I,H,A,S2", 1));
    public static final RegistryObject<Item> LITHIUM_DICHROMATE = Items.register( "lithium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),229.90,"Li2Cr2O7",0,4,"\nDesc: This molecule has little to no industrial application or use.","O,I,H,S2", 1));
    public static final RegistryObject<Item> LITHIUM_ACETATE = Items.register( "lithium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.98,"LiC2H3O2",0,4,"\nDesc: An buffer ingredient for the gel electrophoresis of DNA and RNA.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_CYANIDE = Items.register( "lithium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),32.96,"LiCN",0,4,"\nDesc: Useful in organic chemistry reactions, specifically cyanation.","F,T,A,S2", 1));
    public static final RegistryObject<Item> LITHIUM_THIOCYANATE = Items.register( "lithium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.02,"LiSCN",0,0,"\nDesc: This compound is too unstable to use.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_PEROXIDE = Items.register( "lithium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),45.88,"Li2O2",0,4,"\nDesc: Used in the air purification systems of spacecraft.","O,C,S2", 1));
    public static final RegistryObject<Item> LITHIUM_OXALATE = Items.register( "lithium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),102.00,"Li2C2O2",0,4,"\nDesc: Finds use in pyrotechnics as a red flame colorant.","I,S2", 1));
    public static final RegistryObject<Item> LITHIUM_HYDROXIDE = Items.register( "lithium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),23.95,"LiOH",0,4,"\nDesc: This chemical is mainly used to produce cathodes in lithium batteries.","C,S2", 1));
    //beryllium salts
    public static final RegistryObject<Item> BERYLLIUM_OXIDE = Items.register( "beryllium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),25.01,"BeO",0,4,"\nDesc: Used in rocket engines.","T,H,A", 1));
    public static final RegistryObject<Item> BERYLLIUM_FLUORIDE = Items.register( "beryllium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),47.01,"BeF2",0,4,"\nDesc: Useful in the production of beryllium metal.","C,T,H,A", 1));
    public static final RegistryObject<Item> BERYLLIUM_SULFIDE = Items.register( "beryllium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),41.08,"BeS",0,4,"\nDesc: Not much is known about this compound.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_CHLORIDE = Items.register( "beryllium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),79.92,"BeCl2",0,4,"\nDesc: Finds use in the electrolysis of beryllium and can be used as a catalyst in Friedel Crafts reactions.","I,H", 1));
    public static final RegistryObject<Item> BERYLLIUM_NITRIDE = Items.register( "beryllium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),55.05,"Be3N2",0,4,"\nDesc: Useful in refractory ceramics and nuclear reactors.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_BROMIDE = Items.register( "beryllium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),168.82,"BeBr2",0,4,"\nDesc: Not much is known about this compound's use.","T,H,A", 1));
    public static final RegistryObject<Item> BERYLLIUM_IODIDE = Items.register( "beryllium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),262.82,"BeI2",0,4,"\nDesc: Useful in the production of the beryllium metal.","S1,H", 1));
    public static final RegistryObject<Item> BERYLLIUM_SULFATE = Items.register( "beryllium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),105.68,"BeSO4",0,4,"\nDesc: A compound that played a part in the discovery of nuclear fission as a source of neutrons.","T,H,A", 1));
    public static final RegistryObject<Item> BERYLLIUM_NITRATE = Items.register( "beryllium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.02,"Be(NO3)2",0,4,"\nDesc: Not much is know about this compound's use.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_PERCHLORATE = Items.register( "beryllium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),207.91,"Be(ClO4)2",0,4,"\nDesc: This chemical is often used as a solvent for cellulose.","O,H", 1));
    public static final RegistryObject<Item> BERYLLIUM_IODATE = Items.register( "beryllium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),358.82,"Be(IO3)2",0,4,"\nDesc: Not much is known about this chemical's use.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_CARBONATE = Items.register( "beryllium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),69.02,"BeCO3",0,2,"\nDesc: Not much is known about this compound's use.","T,I,H,A", 1));
    public static final RegistryObject<Item> BERYLLIUM_CHROMATE = Items.register( "beryllium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.01,"BeCrO4",0,4,"\nDesc: This chemical has only been hypothesized to be possible.","T,H", 1));
    public static final RegistryObject<Item> BERYLLIUM_CYANIDE = Items.register( "beryllium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),61.05,"Be(CN)2",0,4,"\nDesc: Not much is known about this chemical's use.","T,H", 1));
    public static final RegistryObject<Item> BERYLLIUM_THIOCYANATE = Items.register( "beryllium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.18,"Be(SCN)2",0,4,"\nDesc: Not much is know about this compound's use.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_OXALATE = Items.register( "beryllium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.03,"BeC2O4",0,4,"\nDesc: This chemical is used in the preparation of beryllium oxide.","H", 1));
    public static final RegistryObject<Item> BERYLLIUM_HYDROXIDE = Items.register( "beryllium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),43.03,"Be(OH)2",0,4,"\nDesc: Produced as a byproduct of beryllium extraction from ores.","T,H,A", 1));
   //calcium salts
    public static final RegistryObject<Item> CALCIUM_OXIDE = Items.register( "calcium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.08,"CaO",0,4,"\nDesc: Also known as quicklime, has a lot of industrial uses.","C,I", 1));
    public static final RegistryObject<Item> CALCIUM_FLUORIDE = Items.register( "calcium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),78.08,"CaF2",0,4,"\nDesc: This compound occurs naturally as the mineral fluorite.","", 1));
    public static final RegistryObject<Item> CALCIUM_SULFIDE = Items.register( "calcium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),72.14,"CaS",0,2,"\nDesc: This chemical is phosphorescent, giving off a blood red glow. ","C,I,A", 1));
    public static final RegistryObject<Item> CALCIUM_CHLORIDE = Items.register( "calcium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),110.98,"CaCl2",0,4,"\nDesc: This compound can act as a desiccant. It is especially useful as a de-icing agent.","I", 1));
    public static final RegistryObject<Item> CALCIUM_NITRIDE = Items.register( "calcium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),148.25,"Ca3N2",0,4,"\nDesc: Not much is known about this chemical's use.","", 1));
    public static final RegistryObject<Item> CALCIUM_BROMIDE = Items.register( "calcium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),199.89,"CaBr2",0,4,"\nDesc: This compound finds use in drilling fluids.","", 1));
    public static final RegistryObject<Item> CALCIUM_IODIDE = Items.register( "calcium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),293.89,"CaI2",0,4,"\nDesc: A compound used in photography and in cat food as a dietary supplement.","", 1));
    public static final RegistryObject<Item> CALCIUM_ARSENATE = Items.register( "calcium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),398.07,"Ca3(AsO4)2",0,4,"\nDesc: This chemical was formerly used as a pesticide.","H", 1));
    public static final RegistryObject<Item> CALCIUM_ARSENITE = Items.register( "calcium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),253.92,"Ca(AsO2)2",0,4,"\nDesc: This chemical was formerly used as a pesticide.","H", 1));
    public static final RegistryObject<Item> CALCIUM_PHOSPHATE = Items.register( "calcium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),310.18,"Ca3(PO4)2",0,4,"\nDesc: This compound is structural for bones. It also hold some nutritional value.","I", 1));
    public static final RegistryObject<Item> CALCIUM_DIHYDROGEN_PHOSPHATE = Items.register( "calcium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),234.05,"Ca(H2PO4)2",0,4,"\nDesc: This compound is used as a fertilizer and as a leavening agent.","", 1));
    public static final RegistryObject<Item> CALCIUM_SULFATE = Items.register( "calcium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),136.14,"CaSO4",0,4,"\nDesc: This compound is used to produce plaster of paris.","", 1));
    public static final RegistryObject<Item> CALCIUM_HYDROGEN_SULFATE = Items.register( "calcium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),202.20,"Ca(HSO3)2",0,4,"\nDesc: This chemical is often used as a food additive, a firming agent.","T", 1));
    public static final RegistryObject<Item> CALCIUM_THIOSULFATE = Items.register( "calcium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),152.20,"CaS2O3",0,4,"\nDesc: Finds use as a fungicide.","I,H", 1));
    public static final RegistryObject<Item> CALCIUM_SULFITE = Items.register( "calcium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),120.17,"CaSO3",0,4,"\nDesc: This substance is an intermediate in the production of gypsum.","", 1));
    public static final RegistryObject<Item> CALCIUM_NITRATE = Items.register( "calcium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),164.09,"Ca(NO3)2",0,4,"\nDesc: This chemical is often used as a fertilizer.","O,C,I", 1));
    public static final RegistryObject<Item> CALCIUM_NITRITE = Items.register( "calcium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),132.09,"Ca(NO2)2",0,4,"\nDesc: This chemical has been used both as an antifreeze and as a rust inhibitor.","O,T,I,H,A", 1));
    public static final RegistryObject<Item> CALCIUM_PERCHLORATE = Items.register( "calcium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),238.98,"Ca(ClO4)2",0,4,"\nDesc: Remarkably, this has been found on the soils of Mars.","O", 1));
    public static final RegistryObject<Item> CALCIUM_CHLORATE = Items.register( "calcium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),206.98,"Ca(ClO3)2",0,4,"\nDesc: Herbicidal, and can be added to pyrotechnics for a pink flame.","O", 1));
    public static final RegistryObject<Item> CALCIUM_CHLORITE = Items.register( "calcium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),174.98,"Ca(ClO2)2",0,4,"\nDesc: Not much is known about this substance's use.","T,C,H,I,O", 1));
    public static final RegistryObject<Item> CALCIUM_HYPOCHLORITE = Items.register( "calcium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),142.98,"Ca(ClO)2",0,4,"\nDesc: An active ingredient in bleaching powder.","O,C,I,A", 1));
    public static final RegistryObject<Item> CALCIUM_IODATE = Items.register( "calcium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),389.88,"Ca(IO3)2",0,4,"\nDesc: Used in chicken feed as a dietary supplement.","", 1));
    public static final RegistryObject<Item> CALCIUM_BROMATE = Items.register( "calcium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),295.88,"Ca(BrO3)2",0,4,"\nDesc: Can be found in bread dough. It serves as a flour improver.","", 1));
    public static final RegistryObject<Item> CALCIUM_CARBONATE = Items.register( "calcium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),100.09,"CaCO3",0,4,"\nDesc: A major constituent of many rocks, such as calcite, aragonite, chalk, limestone, etc....","", 1));
    public static final RegistryObject<Item> CALCIUM_BICARBONATE = Items.register( "calcium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),162.11,"Ca(HCO3)2",0,4,"\nDesc: This is used to treat hyperkalemia.","I", 1));
    public static final RegistryObject<Item> CALCIUM_CHROMATE = Items.register( "calcium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),156.07,"CaCrO4",0,4,"\nDesc: This chemical is often used as a yellow pigment.","O,H,T", 1));
    public static final RegistryObject<Item> CALCIUM_DICHROMATE = Items.register( "calcium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),256.07,"CaCr2O7",0,4,"\nDesc: This compound is often used as a corrosion inhibitor.","I,H,A", 1));
    public static final RegistryObject<Item> CALCIUM_ACETATE = Items.register( "calcium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.17,"Ca(C2H3O2)2",0,4,"\nDesc: This chemical has a variety of use, from treating kidney disease to tofu production.","", 1));
    public static final RegistryObject<Item> CALCIUM_FORMATE = Items.register( "calcium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),130.11,"Ca(HCO2)2",0,4,"\nDesc: Often added to animal feed as a preservative.","C,I", 1));
    public static final RegistryObject<Item> CALCIUM_CYANIDE = Items.register( "calcium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),92.11,"Ca(CN)2",0,4,"\nDesc: Used in gold and silver mining.","T", 1));
    public static final RegistryObject<Item> CALCIUM_CYANATE = Items.register( "calcium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),124.11,"Ca(OCN)2",0,4,"\nDesc: Not much is known about this compound's use.","I", 1));
    public static final RegistryObject<Item> CALCIUM_THIOCYANATE = Items.register( "calcium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),156.20,"Ca(SCN)2",0,4,"\nDesc: Not much is known about this compound's use.","I", 1));
    public static final RegistryObject<Item> CALCIUM_PEROXIDE = Items.register( "calcium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),72.08,"CaO2",0,4,"\nDesc: Finds use in the extraction of precious metals from ores.","O,I", 1));
    public static final RegistryObject<Item> CALCIUM_OXALATE = Items.register( "calcium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),128.10,"CaC2O4",0,4,"\nDesc: A major constituent of kidney stones, around ~76%.","T,I", 1));
    public static final RegistryObject<Item> CALCIUM_HYDROXIDE = Items.register( "calcium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.09,"Ca(OH)2",0,4,"\nDesc: Also known as slaked lime. Used to prepare lime mortar, and in sewage treatment.","C,I", 1));
    public static final RegistryObject<Item> CALCIUM_PERMANGANATE = Items.register( "calcium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),277.95,"Ca(MnO4)2",0,4,"\nDesc: Finds use in the textile industry, in water sterilization, and in the production of deodorizer.","O", 1));
    //potassium salts
    public static final RegistryObject<Item> POTASSIUM_OXIDE = Items.register( "potassium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),94.20,"K2O",0,4,"\nDesc: Used as a metric in composition assays.","C,S1", 1));
    public static final RegistryObject<Item> POTASSIUM_FLUORIDE = Items.register( "potassium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.10,"KF",0,4,"\nDesc: A primary source of fluoride ions in manufacturing and chemistry.","T", 1));
    public static final RegistryObject<Item> POTASSIUM_SULFIDE = Items.register( "potassium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),110.26,"K2S",0,4,"\nDesc: A byproduct formed when black powder burns.","C,A", 1));
    public static final RegistryObject<Item> POTASSIUM_CHLORIDE = Items.register( "potassium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.56,"KCl",0,4,"\nDesc: Has wide use, from fertilizer, to medicinal, to food production.","", 1));
    public static final RegistryObject<Item> POTASSIUM_NITRIDE = Items.register( "potassium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),131.30,"K3N",0,0,"\nDesc: This compound is too unstable to use.","", 1));
    public static final RegistryObject<Item> POTASSIUM_BROMIDE = Items.register( "potassium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.00,"KBr",0,4,"\nDesc: Has medical and veterinary use. It is also a sedative.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_IODIDE = Items.register( "potassium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),166.00,"KI",0,4,"\nDesc: This substance is on the World Health Organization's list of essential medicines.","", 1));
    public static final RegistryObject<Item> POTASSIUM_ARSENATE = Items.register( "potassium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.03,"KH2AsO4",0,4,"\nDesc: Not much is known.","T,H,A", 1));
    public static final RegistryObject<Item> POTASSIUM_ARSENITE = Items.register( "potassium_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),146.02,"KAsO2",0,4,"\nDesc: Used most commonly as a rodentcide.","T,H", 1));
    public static final RegistryObject<Item> POTASSIUM_PHOSPHATE = Items.register( "potassium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),212.27,"K3PO4",0,4,"\nDesc: Found in dry cereal products. It also has use in organic chemistry.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_DIHYDROGEN_PHOSPHATE = Items.register( "potassium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),136.09,"KH2PO4",0,4,"\nDesc: Found in sports drinks.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_SULFATE = Items.register( "potassium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),174.26,"K2SO4",0,4,"\nDesc: Can be used as a fertilizer.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_HYDROGEN_SULFATE = Items.register( "potassium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),136.17,"KHSO4",0,4,"\nDesc: Has use in wine making.","C,I", 1));
    public static final RegistryObject<Item> POTASSIUM_THIOSULFATE = Items.register( "potassium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),190.32,"K2S2O3",0,4,"\nDesc: Can be used as a fertilizer.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_SULFITE = Items.register( "potassium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.26,"K2SO3",0,4,"\nDesc: A preservative for both food and beverage.","", 1));
    public static final RegistryObject<Item> POTASSIUM_NITRATE = Items.register( "potassium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),101.10,"KNO3",0,4,"\nDesc: Also known as salt peter. Used as fertilizer, in fireworks, and rockets.","O,I", 1));
    public static final RegistryObject<Item> POTASSIUM_NITRITE = Items.register( "potassium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),85.10,"KNO2",0,4,"\nDesc: Has potential medical use.","O,T,A", 1));
    public static final RegistryObject<Item> POTASSIUM_PERCHLORATE = Items.register( "potassium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),138.55,"KClO4",0,4,"\nDesc: An antithyroid agent, and surprisingly solid rocket propellant.","O,I", 1));
    public static final RegistryObject<Item> POTASSIUM_CHLORATE = Items.register( "potassium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.55,"KClO3",0,4,"\nDesc: Used in safety matches, fireworks, and explosives.","O,I,A", 1));
    public static final RegistryObject<Item> POTASSIUM_CHLORITE = Items.register( "potassium_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),106.55,"KClO2",0,4,"\nDesc: Not much is known about this chemical's use.","O", 1));
    public static final RegistryObject<Item> POTASSIUM_HYPOCHLORITE = Items.register( "potassium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.55,"KClO",0,4,"\nDesc: This compound finds use as a sanitizer and as a water disinfectant.","O,I,A", 1));
    public static final RegistryObject<Item> POTASSIUM_IODATE = Items.register( "potassium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),214.00,"KIO3",0,4,"\nDesc: Used in the iodination of salt. Found in baby formula.","O,C,I", 1));
    public static final RegistryObject<Item> POTASSIUM_BROMATE = Items.register( "potassium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),167.00,"KBrO3",0,4,"\nDesc: This substance is often used as a flour improver.","O,T,H", 1));
    public static final RegistryObject<Item> POTASSIUM_CARBONATE = Items.register( "potassium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),138.21,"K2CO3",0,4,"\nDesc: Used in the production of soap and glass.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_BICARBONATE = Items.register( "potassium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),100.12,"KHCO3",0,4,"\nDesc: Can be used as a substitute for baking soda. Found in chemical fire extinguishers.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_CHROMATE = Items.register( "potassium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),194.19,"K2CrO4",0,4,"\nDesc: Has some laboratory applications.","C,H,I", 1));
    public static final RegistryObject<Item> POTASSIUM_DICHROMATE = Items.register( "potassium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),294.19,"K2Cr2O7",0,4,"\nDesc: Has some use in leather tanning.","O,C,T,H,A", 1));
    public static final RegistryObject<Item> POTASSIUM_ACETATE = Items.register( "potassium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),98.14,"KC2H3O2",0,4,"\nDesc: Useful in deicing, and found in fire extinguishers.","", 1));
    public static final RegistryObject<Item> POTASSIUM_FORMATE = Items.register( "potassium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.12,"KHCO2",0,4,"\nDesc: Has some potential as a deicing salt.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_CYANIDE = Items.register( "potassium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.12,"KCN",0,4,"\nDesc: Like other cyanide salts, finds use in gold mining.","C,T,H,A", 1));
    public static final RegistryObject<Item> POTASSIUM_CYANATE = Items.register( "potassium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),81.12,"KOCN",0,4,"\nDesc: This compound is used in the production of herbicide.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_THIOCYANATE = Items.register( "potassium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.18,"KSCN",0,4,"\nDesc: Was a popular substance for the creation of fake blood on film.","C,I", 1));
    public static final RegistryObject<Item> POTASSIUM_PEROXIDE = Items.register( "potassium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),110.20,"K2O2",0,4,"\nDesc: A bleaching agent which can be used in air purification systems."," O,I,S1", 1));
    public static final RegistryObject<Item> POTASSIUM_OXALATE = Items.register( "potassium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),166.22,"K2C2O4",0,4,"\nDesc: Used in mouthwash. Has anticorrosive properties.","I", 1));
    public static final RegistryObject<Item> POTASSIUM_HYDROXIDE = Items.register( "potassium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.11,"KOH",0,4,"\nDesc: Is used interchangeably with sodium hydroxide.","C,I", 1));
    public static final RegistryObject<Item> POTASSIUM_PERMANGANATE = Items.register( "potassium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.03,"KMnO4",0,4,"\nDesc: On the World Health Organization's list of essential medicines. Also has wide chemical and laboratory use.","O,I,A", 1));
    //aluminum salts
    public static final RegistryObject<Item> ALUMINUM_OXIDE = Items.register( "aluminum_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),101.96,"Al2O3",0,4,"\nDesc: Found in a variety of precious minerals. Also used in the production of aluminum metal.","I", 1));
    public static final RegistryObject<Item> ALUMINUM_FLUORIDE = Items.register( "aluminum_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),83.98,"AlF3",0,4,"\nDesc: Used to produce aluminum metal via electrolysis.","C,T,I,H", 1));
    public static final RegistryObject<Item> ALUMINUM_SULFIDE = Items.register( "aluminum_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.16,"Al2S3",0,2,"\nDesc: Not much is known about its use.","F,I", 1));
    public static final RegistryObject<Item> ALUMINUM_CHLORIDE = Items.register( "aluminum_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.34,"AlCl3",0,4,"\nDesc: Used to produce aluminum metal. Has some use in organic chemistry.","C", 1));
    public static final RegistryObject<Item> ALUMINUM_NITRIDE = Items.register( "aluminum_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),40.99,"AlN",0,4,"\nDesc: Found in cell phones, and is used in optoelectrics.","I,H,A", 1));
    public static final RegistryObject<Item> ALUMINUM_BROMIDE = Items.register( "aluminum_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),266.69,"AlBr3",0,4,"\nDesc: Used as a catalyst in organic chemistry.","C,I", 1));
    public static final RegistryObject<Item> ALUMINUM_IODIDE = Items.register( "aluminum_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),407.70,"AlI3",0,4,"\nDesc: Used as a catalyst in organic chemistry.","C", 1));
    public static final RegistryObject<Item> ALUMINUM_ARSENATE = Items.register( "aluminum_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),165.90,"AlAsO4",0,4,"\nDesc: Found naturally as the mansfieldite mineral.","", 1));
    public static final RegistryObject<Item> ALUMINUM_PHOSPHATE = Items.register( "aluminum_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),121.95,"AlPO4",0,4,"\nDesc: Found naturally as the mineral berlinite. Used to make molecular sieves.","C,I", 1));
    public static final RegistryObject<Item> ALUMINUM_DIHYDROGEN_PHOSPHATE = Items.register( "aluminum_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),317.94,"Al(H2PO4)3",0,4,"\nDesc: Used in fireproofing. Also used to produce specialized glasses.","C", 1));
    public static final RegistryObject<Item> ALUMINUM_SULFATE = Items.register( "aluminum_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),342.15,"Al2(SO4)3",0,4,"\nDesc: This compound is used as a coagulating agent. Especially useful in water treatment.","", 1));
    public static final RegistryObject<Item> ALUMINUM_THIOSULFATE = Items.register( "aluminum_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),390.35,"Al2(S2O2)3",0,4,"\nDesc: This compound is used as a coagulating agent in water treatment.","I,H", 1));
    public static final RegistryObject<Item> ALUMINUM_NITRATE = Items.register( "aluminum_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),213.00,"Al(NO3)3",0,4,"\nDesc: This has a variety of uses, such as leather tanning, use as an antiperspirant, etc....","O,C,T,I,H", 1));
    public static final RegistryObject<Item> ALUMINUM_PERCHLORATE = Items.register( "aluminum_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),325.33,"Al(ClO4)3",0,4,"\nDesc: Not much is known about this compound's use.","O,I,H", 1));
    public static final RegistryObject<Item> ALUMINUM_CHLORATE = Items.register( "aluminum_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),277.34,"Al(ClO3)3",0,4,"\nDesc: Can be used as a disinfectant. Used in the production of ClO2.","O,I", 1));
    public static final RegistryObject<Item> ALUMINUM_BROMATE = Items.register( "aluminum_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),410.69,"Al(BrO3)3",0,4,"\nDesc: Has some uses in organic chemistry.","I", 1));
    public static final RegistryObject<Item> ALUMINUM_CARBONATE = Items.register( "aluminum_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),233.99,"Al2(CO3)3",0,4,"\nDesc: Finds use as veterinary medicine for dogs and cats.","I", 1));
    public static final RegistryObject<Item> ALUMINUM_BICARBONATE = Items.register( "aluminum_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),210.03,"Al(HCO3)3",0,4,"\nDesc: Is often used as a medicine to treat indigestion and heartburn.","I", 1));
    public static final RegistryObject<Item> ALUMINUM_ACETATE = Items.register( "aluminum_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),204.11,"Al(C2H3O2)3",0,4,"\nDesc: This compound has various medical applications. Can also be used as a mordant in dyeing.","", 1));
    public static final RegistryObject<Item> ALUMINUM_FORMATE = Items.register( "aluminum_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),162.03,"Al(HCO2)3",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> ALUMINUM_CYANIDE = Items.register( "aluminum_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),105.04,"Al(CN)3",0,4,"\nDesc: Not much is known about its use.","T,S1", 1));
    public static final RegistryObject<Item> ALUMINUM_OXALATE = Items.register( "aluminum_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),318.02,"Al2(C2O4)3",0,4,"\nDesc: Often used as a mordant for dyeing textiles.","I", 1));
    public static final RegistryObject<Item> ALUMINUM_HYDROXIDE = Items.register( "aluminum_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),78.00,"Al(OH)3",0,4,"\nDesc: Has some medicinal use, such as being used as an antacid.","I", 1));
   //ammonium salts
    public static final RegistryObject<Item> AMMONIUM_FLUORIDE = Items.register( "ammonium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),37.04,"NH4F",0,4,"\nDesc: Used for preserving wood, and also for mothproofing.","C,T", 1));
    public static final RegistryObject<Item> AMMONIUM_SULFIDE = Items.register( "ammonium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.15,"(NH4)2S",0,4,"\nDesc: Is most commonly associated with its use as a stink bomb.","T,C,A,F", 1));
    public static final RegistryObject<Item> AMMONIUM_CHLORIDE = Items.register( "ammonium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),53.49,"NH4Cl",0,4,"\nDesc: This compound has a wide variety of uses. Often used as fertilizer, and as liquorice flavoring.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_BROMIDE = Items.register( "ammonium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.94,"NH4Br",0,4,"\nDesc: Used in photography, and has been used in fireproofing.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_IODIDE = Items.register( "ammonium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),144.94,"NH4I",0,4,"\nDesc: A photographic chemical. It also can be used as a medicine.","", 1));
    public static final RegistryObject<Item> AMMONIUM_ARSENATE = Items.register( "ammonium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),176.00,"(NH4)3AsO4",0,4,"\nDesc: Finds use as a herbicide, an insecticide, and as rodentcide.","H", 1));
    public static final RegistryObject<Item> AMMONIUM_PHOSPHATE = Items.register( "ammonium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.09,"(NH4)3PO4",0,4,"\nDesc: Can be used as fertilizer.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_DIHYDROGEN_PHOSPHATE = Items.register( "ammonium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.03,"(NH4)H2PO4",0,4,"\nDesc: This compound has been used as a fertilizer, in fire extinguishers, and in optics.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_SULFATE = Items.register( "ammonium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),132.14,"(NH4)2SO4",0,4,"\nDesc: Can be used as fertilizer. Has some laboratory use.","I,A", 1));
    public static final RegistryObject<Item> AMMONIUM_HYDROGEN_SULFATE = Items.register( "ammonium_hydrogen_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.11,"(NH4)HSO4",0,4,"\nDesc: Used in the production of ammonium sulfate.","H", 1));
    public static final RegistryObject<Item> AMMONIUM_THIOSULFATE = Items.register( "ammonium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),148.20,"(NH4)2S2O3",0,4,"\nDesc: In photography, it is used as a photographic fixer. It is also used in gold and silver leaching.","", 1));
    public static final RegistryObject<Item> AMMONIUM_SULFITE = Items.register( "ammonium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),116.14,"(NH4)2SO3",0,4,"\nDesc: This has been used in the cosmetics industry. It has also been used as caramel food coloring.","C,I", 1));
    public static final RegistryObject<Item> AMMONIUM_NITRATE = Items.register( "ammonium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),80.04,"NH4NO3",0,4,"\nDesc: This explosive compound can be used as a fertilizer, and in the production of explosives.","I,O,E", 1));
    public static final RegistryObject<Item> AMMONIUM_NITRITE = Items.register( "ammonium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),64.04,"NH4NO2",0,0,"\nDesc: Not much is known about its use.","I,E", 1));
    public static final RegistryObject<Item> AMMONIUM_PERCHLORATE = Items.register( "ammonium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),117.49,"NH4ClO4",0,4,"\nDesc: Can be used as a rocket propellant.","E,O,I,H", 1));
    public static final RegistryObject<Item> AMMONIUM_CHLORATE = Items.register( "ammonium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),101.49,"NH4ClO3",0,0,"\nDesc: Not much is known about this compound.","O,E", 1));
    public static final RegistryObject<Item> AMMONIUM_IODATE = Items.register( "ammonium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),192.94,"NH4IO3",0,4,"\nDesc: Not much is known about this compound's use.","O", 1));
    public static final RegistryObject<Item> AMMONIUM_CARBONATE = Items.register( "ammonium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),96.09,"(NH4)2CO3",0,4,"\nDesc: Also known as baker's ammonia, this compound is a leavening agent, as well as a smelling salt.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_BICARBONATE = Items.register( "ammonium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),79.06,"(NH4)HCO3",0,2,"\nDesc: This compound is a leavening agent. It is also used in ceramics.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_CHROMATE = Items.register( "ammonium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),152.07,"(NH4)2CrO4",0,4,"\nDesc: Finds some use in photography, and in textile printing.","O,C,H,A", 1));
    public static final RegistryObject<Item> AMMONIUM_DICHROMATE = Items.register( "ammonium_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),252.07,"(NH4)2Cr2O7",0,4,"\nDesc: Also known as vesuvian fire. Has been used as a mordant, and was formerly used in the science lab volcano demonstrations.","E,O,C,T,H,A", 1));
    public static final RegistryObject<Item> AMMONIUM_ACETATE = Items.register( "ammonium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),77.08,"NH4C2H3O2",0,4,"\nDesc: Is a diuretic. Has some lab use, and can be used for de-icing.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_FORMATE = Items.register( "ammonium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),63.06,"(NH4)HCO2",0,4,"\nDesc: Is a precursor to formamdide.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_CYANIDE = Items.register( "ammonium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),44.06,"NH4CN",0,1,"\nDesc: Has some usage in organic chemistry.","T", 1));
    public static final RegistryObject<Item> AMMONIUM_CYANATE = Items.register( "ammonium_cyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),60.06,"NH4OCN",0,4,"\nDesc: Is a precursor to urea in its synthesis.","", 1));
    public static final RegistryObject<Item> AMMONIUM_THIOCYANATE = Items.register( "ammonium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),76.12,"NH4SCN",0,4,"\nDesc: This compound as a wide range of uses, but is most commonly used as a herbicide.","I,A", 1));
    public static final RegistryObject<Item> AMMONIUM_OXALATE = Items.register( "ammonium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),124.10,"(NH4)2C2O4",0,4,"\nDesc: This molecule occurs naturally in plants and vegetables.","I", 1));
    public static final RegistryObject<Item> AMMONIUM_PERMANGANATE = Items.register( "ammonium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),135.97,"NH4MnO4",0,4,"\nDesc: Not much is known about this compound's use.","O,A,H,E", 1));
    //barium salts
    public static final RegistryObject<Item> BARIUM_OXIDE = Items.register( "barium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),153.33,"BaO",0,4,"\nDesc: Used for coating hot cathodes.","C,T,I,A", 1));
    public static final RegistryObject<Item> BARIUM_FLUORIDE = Items.register( "barium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),175.32,"BaF2",0,4,"\nDesc: Has been used in the production of welding agents. Metallurgic uses.","I,T", 1));
    public static final RegistryObject<Item> BARIUM_SULFIDE = Items.register( "barium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),169.39,"BaS",0,4,"\nDesc: This compound is a precursor to other barium compounds.","I,A,F,T", 1));
    public static final RegistryObject<Item> BARIUM_CHLORIDE = Items.register( "barium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),208.23,"BaCl2",0,4,"\nDesc: Is used in the purification of brine solutions in chlorine plants.","T,C", 1));
    public static final RegistryObject<Item> BARIUM_NITRIDE = Items.register( "barium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),440.00,"Ba3N2",0,4,"\nDesc:Not much is known about this compound's use.","T,I", 1));
    public static final RegistryObject<Item> BARIUM_BROMIDE = Items.register( "barium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),297.14,"BaBr2",0,4,"\nDesc: Finds use in photography. Was used by Marie Curie for radium purification.","T,I", 1));
    public static final RegistryObject<Item> BARIUM_IODIDE = Items.register( "barium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),391.14,"BaI2",0,4,"\nDesc: Not much is known about this compound's use.","T", 1));
    public static final RegistryObject<Item> BARIUM_ARSENATE = Items.register( "barium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),689.80,"Ba3(AsO4)2",0,4,"\nDesc: Not much is known.","T", 1));
    public static final RegistryObject<Item> BARIUM_PHOSPHATE = Items.register( "barium_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),601.93,"Ba3(PO4)2",0,4,"\nDesc: Has been used in the production of pulse lasers and glasses.","T,I", 1));
    public static final RegistryObject<Item> BARIUM_DIHYDROGEN_PHOSPHATE = Items.register( "barium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),331.30,"Ba(H2PO4)2",0,4,"\nDesc: Not much is known.","T,I", 1));
    public static final RegistryObject<Item> BARIUM_SULFATE = Items.register( "barium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),233.39,"BaSO4",0,4,"\nDesc: This compound has wide use. Occurs as the mineral barite, which is our main source of barium.","", 1));
    public static final RegistryObject<Item> BARIUM_SULFITE = Items.register( "barium_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),217.39,"BaSO3",0,4,"\nDesc: This compound does not find much use.","", 1));
    public static final RegistryObject<Item> BARIUM_NITRATE = Items.register( "barium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),261.34,"Ba(NO3)2",0,4,"\nDesc: Has some use in pyrotechnics. Formerly used in the production of baratol.","O,I,T", 1));
    public static final RegistryObject<Item> BARIUM_NITRITE = Items.register( "barium_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),229.34,"Ba(NO2)2",0,4,"\nDesc: Used in the preparation of other metal nitrites.","T", 1));
    public static final RegistryObject<Item> BARIUM_PERCHLORATE = Items.register( "barium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),336.23,"Ba(ClO4)2",0,4,"\nDesc: Used to make explosives.","T,O", 1));
    public static final RegistryObject<Item> BARIUM_CHLORATE = Items.register( "barium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),304.23,"Ba(ClO3)2",0,4,"\nDesc: In pyrotechnics, can be used to add a green color.","O,T,I,A", 1));
    public static final RegistryObject<Item> BARIUM_HYPOCHLORITE = Items.register( "barium_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),240.23,"Ba(ClO)2",0,4,"\nDesc: Is a bleaching agent. Used in the decontamination of explosives.","S1,T,O", 1));
    public static final RegistryObject<Item> BARIUM_IODATE = Items.register( "barium_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),487.13,"Ba(IO3)2",0,4,"\nDesc: Not much is known.","T", 1));
    public static final RegistryObject<Item> BARIUM_BROMATE = Items.register( "barium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),393.13,"Ba(BrO3)2",0,4,"\nDesc: Not much is known.","T,O,I", 1));
    public static final RegistryObject<Item> BARIUM_CARBONATE = Items.register( "barium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),197.34,"BaCO3",0,4,"\nDesc: Is used to remove sulfate impurities from feedstock.","I", 1));
    public static final RegistryObject<Item> BARIUM_CHROMATE = Items.register( "barium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),253.37,"BaCrO4",0,4,"\nDesc: Is used as a chromium carrier. Has been used in pyrotechnics.","O,I,T,H,A", 1));
    public static final RegistryObject<Item> BARIUM_ACETATE = Items.register( "barium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),255.42,"Ba(C2H3O2)2",0,4,"\nDesc: Finds use as a mordant in fabrics.","T", 1));
    public static final RegistryObject<Item> BARIUM_CYANIDE = Items.register( "barium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),189.36,"Ba(CN)2",0,4,"\nDesc: Useful for electroplating.","T,A", 1));
    public static final RegistryObject<Item> BARIUM_THIOCYANATE = Items.register( "barium_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),253.49,"Ba(SCN)2",0,4,"\nDesc: Can be used for dyeing textiles or in photography.","T,I", 1));
    public static final RegistryObject<Item> BARIUM_PEROXIDE = Items.register( "barium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),169.33,"BaO2",0,4,"\nDesc: This peroxide is the first to be discovered. It finds use in pyrotechnics.","T,O,I", 1));
    public static final RegistryObject<Item> BARIUM_OXALATE = Items.register( "barium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),225.35,"BaC2O4",0,4,"\nDesc: Finds some use in pyrotechnics.","I", 1));
    public static final RegistryObject<Item> BARIUM_HYDROXIDE = Items.register( "barium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),171.34,"Ba(OH)2",0,4,"\nDesc: A precursor to other barium compounds.","C,I,T", 1));
    public static final RegistryObject<Item> BARIUM_PERMANGANATE = Items.register( "barium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),375.20,"Ba(MnO4)2",0,4,"\nDesc: Not much is known about this compound's use.","O,T", 1));
    //chromium II
    public static final RegistryObject<Item> CHROMIUM_II_OXIDE = Items.register( "chromium_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.00,"CrO",0,4,"\nDesc: Has been observed in red novae.","", 1));
    public static final RegistryObject<Item> CHROMIUM_II_FLUORIDE = Items.register( "chromium_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),90.00,"CrF2",0,4,"\nDesc: Not much is known.","C,I", 1));
    public static final RegistryObject<Item> CHROMIUM_II_SULFIDE = Items.register( "chromium_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.06,"CrS",0,4,"\nDesc: Is a semiconductor.","", 1));
    public static final RegistryObject<Item> CHROMIUM_II_CHLORIDE = Items.register( "chromium_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.90,"CrCl2",0,4,"\nDesc: Used in the synthesis of other chromium compounds.","I", 1));
    public static final RegistryObject<Item> CHROMIUM_II_BROMIDE = Items.register( "chromium_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),211.80,"CrBr2",0,4,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> CHROMIUM_II_IODIDE = Items.register( "chromium_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),305.81,"CrI2",0,4,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> CHROMIUM_II_CHROMATE = Items.register( "chromium_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),167.99,"Cr2O4",0,4,"\nDesc: Not much is known.","H", 1));
    public static final RegistryObject<Item> CHROMIUM_II_ACETATE = Items.register( "chromium_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),340.18,"Cr2(C2H3O2)4",0,4,"\nDesc: This compound was formerly used as a target product for chemistry students to produce as a challenge.","", 1));
    public static final RegistryObject<Item> CHROMIUM_II_OXALATE = Items.register( "chromium_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),140.02,"CrC2O4",0,4,"\nDesc: Not much is known.","", 1));
    //chromium_iii
    public static final RegistryObject<Item> CHROMIUM_III_OXIDE = Items.register( "chromium_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.99,"Cr2O3",0,4,"\nDesc: Is a pigment.","I,H", 1));
    public static final RegistryObject<Item> CHROMIUM_III_FLUORIDE = Items.register( "chromium_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),108.99,"CrF3",0,4,"\nDesc: Has been used as a mordant, and as a corrosion inhibitor.","T", 1));
    public static final RegistryObject<Item> CHROMIUM_III_SULFIDE = Items.register( "chromium_iii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),200.19,"Cr2S3",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> CHROMIUM_III_CHLORIDE = Items.register( "chromium_iii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.36,"CrCl3",0,4,"\nDesc: Used in the dyeing of wool.","C,I,A", 1));
    public static final RegistryObject<Item> CHROMIUM_III_NITRIDE = Items.register( "chromium_iii_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),66.00,"CrN",0,4,"\nDesc: Can be applied as a corrosion resistant coating.","", 1));
    public static final RegistryObject<Item> CHROMIUM_III_BROMIDE = Items.register( "chromium_iii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),291.71,"CrBr3",0,4,"\nDesc: A precursor for the catalyst used for the oligomerization of ethylene.","", 1));
    public static final RegistryObject<Item> CHROMIUM_III_IODIDE = Items.register( "chromium_iii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),432.71,"CrI3",0,4,"\nDesc: This compound is special in that it is a magnetic material that is also 2D.","", 1));
    public static final RegistryObject<Item> CHROMIUM_III_PHOSPHATE = Items.register( "chromium_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),146.97,"CrPO4",0,4,"\nDesc: Can be applied as an anti-corrosive coating.","", 1));
    public static final RegistryObject<Item> CHROMIUM_III_SULFATE = Items.register( "chromium_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),392.16,"Cr2(SO4)3",0,4,"\nDesc: Finds some use in leather tanning.","C,I,H,A", 1));
    public static final RegistryObject<Item> CHROMIUM_III_NITRATE = Items.register( "chromium_iii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),238.01,"Cr(NO3)3",0,4,"\nDesc: Used in the dyeing industry. Also has some lab uses.","O,H", 1));
    public static final RegistryObject<Item> CHROMIUM_III_PERCHLORATE = Items.register( "chromium_iii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),350.35,"Cr(ClO4)3",0,4,"\nDesc: Not much is known about this compound's use.","C,T,H", 1));
    public static final RegistryObject<Item> CHROMIUM_III_CHROMATE = Items.register( "chromium_iii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),451.97,"Cr2(CrO4)3",0,4,"\nDesc: Used as a mordant, and has anti-corrosive properties.","O,C,I,H,A", 1));
    public static final RegistryObject<Item> CHROMIUM_III_OXALATE = Items.register( "chromium_iii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),368.05,"Cr2(C2O4)3",0,4,"\nDesc: Not much is known about this compound's use.","C,I,H", 1));
    public static final RegistryObject<Item> CHROMIUM_III_HYDROXIDE = Items.register( "chromium_iii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),103.02,"Cr(OH)3",0,4,"\nDesc: Used both as a pigment and as a mordant.","", 1));
    //COPPER I SALTS
    public static final RegistryObject<Item> COPPER_I_OXIDE = Items.register( "copper_i_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),143.09,"Cu2O",0,4,"\nDesc: Useful as a pigment and as a fungicide.","C,I,A", 1));
    public static final RegistryObject<Item> COPPER_I_FLUORIDE = Items.register( "copper_i_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),82.54,"CuF",0,1,"\nDesc: Not much is known.","T,A", 1));
    public static final RegistryObject<Item> COPPER_I_SULFIDE = Items.register( "copper_i_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.16,"Cu2S",0,4,"\nDesc: Occurs naturally as the mineral chalcosite.","", 1));
    public static final RegistryObject<Item> COPPER_I_CHLORIDE = Items.register( "copper_i_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),99.00,"CuCl",0,4,"\nDesc: Is often used to produce fungicide. Also has some use in organic chemistry.","I,A,T", 1));
    public static final RegistryObject<Item> COPPER_I_BROMIDE = Items.register( "copper_i_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),143.45,"CuBr",0,4,"\nDesc: Finds use in organic chemistry.","", 1));
    public static final RegistryObject<Item> COPPER_I_IODIDE = Items.register( "copper_i_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),190.45,"CuI",0,4,"\nDesc: Finds use in organic chemistry and in cloud seeding.","C,I,A", 1));
    public static final RegistryObject<Item> COPPER_I_SULFATE = Items.register( "copper_i_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),223.15,"Cu2SO4",0,4,"\nDesc:Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> COPPER_I_CYANIDE = Items.register( "copper_i_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),89.56,"CuCN",0,4,"\nDesc: Used in the electroplating of copper. Is also a catalyst.","T,A", 1));
    public static final RegistryObject<Item> COPPER_I_THIOCYANATE = Items.register( "copper_i_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),121.63,"CuSCN",0,4,"\nDesc: This compound is a semiconductor. Cna be used as anti-fouling paint.","", 1));
    public static final RegistryObject<Item> COPPER_I_HYDROXIDE = Items.register( "copper_i_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),80.55,"CuOH",0,2,"\nDesc: This compound is a precursor to copper I oxide.","", 1));
    //copper ii salts
    public static final RegistryObject<Item> COPPER_II_OXIDE = Items.register( "copper_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),79.55,"CuO",0,4,"\nDesc: Occurs naturally as the mineral tenorite. It is also a precursor to other copper compounds.","A", 1));
    public static final RegistryObject<Item> COPPER_II_FLUORIDE = Items.register( "copper_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),101.54,"CuF2",0,4,"\nDesc: Finds some uses in organic chemistry.","", 1));
    public static final RegistryObject<Item> COPPER_II_SULFIDE = Items.register( "copper_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),95.61,"CuS",0,4,"\nDesc: Finds use in photovoltaics.","A", 1));
    public static final RegistryObject<Item> COPPER_II_CHLORIDE = Items.register( "copper_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),134.45,"CuCl2",0,4,"\nDesc: This compound is used in the Wacker process in organic chemistry.","C,T,I,A", 1));
    public static final RegistryObject<Item> COPPER_II_BROMIDE = Items.register( "copper_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),223.37,"CuBr2",0,4,"\nDesc: Has been used in photography, and in the cosmetics industry for skin rejuvenation.","H", 1));
    public static final RegistryObject<Item> COPPER_II_ARSENATE = Items.register( "copper_ii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),468.48,"Cu3(AsO4)2",0,4,"\nDesc: This compound is an insecticide, a herbicide, a rodenticide, and a fungicide.","", 1));
    public static final RegistryObject<Item> COPPER_II_PHOSPHATE = Items.register( "copper_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),380.58,"Cu3(PO4)2",0,4,"\nDesc: Can be used as both a fertilizer and as a fungicide.","", 1));
    public static final RegistryObject<Item> COPPER_II_SULFATE = Items.register( "copper_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.60,"CuSO4",0,4,"\nDesc: Has a wide range of use. Most often used as a fungicide, but has some uses in organic chemistry.","I,A", 1));
    public static final RegistryObject<Item> COPPER_II_NITRATE = Items.register( "copper_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),187.56,"Cu(NO3)2",0,4,"\nDesc: This compound often is converted to copper II oxide. It is used in organic chemistry.","I,O", 1));
    public static final RegistryObject<Item> COPPER_II_PERCHLORATE = Items.register( "copper_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),262.45,"Cu(ClO4)2",0,4,"\nDesc: Not much is known about this compound.","O,I", 1));
    public static final RegistryObject<Item> COPPER_II_CHLORATE = Items.register( "copper_ii_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),230.45,"Cu(ClO3)2",0,4,"\nDesc: Used in the production of the TACC explosive.","O", 1));
    public static final RegistryObject<Item> COPPER_II_CARBONATE = Items.register( "copper_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),123.55,"CuCO3",0,2,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> COPPER_II_CHROMATE = Items.register( "copper_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),179.54,"CuCrO4",0,4,"\nDesc: Can be used as a fungicide.","I,H,A", 1));
    public static final RegistryObject<Item> COPPER_II_ACETATE = Items.register( "copper_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),181.63,"Cu(C2H3O2)2",0,4,"\nDesc: Finds some use in organic chemistry.","C,T,I,A", 1));
    public static final RegistryObject<Item> COPPER_II_FORMATE = Items.register( "copper_ii_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),153.58,"Cu(HCO2)2",0,4,"\nDesc: An insecticide and biocide. Used as an antibacterial agent in cellulose materials.","I,A", 1));
    public static final RegistryObject<Item> COPPER_II_THIOCYANATE = Items.register( "copper_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),179.71,"Cu(SCN)2",0,4,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> COPPER_II_PEROXIDE = Items.register( "copper_ii_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),95.95,"CuO2",0,2,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> COPPER_II_OXALATE = Items.register( "copper_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),153.58,"CuC2O4",0,4,"\nDesc: Used in organic chemistry. Has also been used in seed treatment.","I", 1));
    public static final RegistryObject<Item> COPPER_II_HYDROXIDE = Items.register( "copper_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.56,"Cu(OH)2",0,4,"\nDesc: Can be used as a fungicide. An ingredient in Schweizer's reagent.","I", 1));
    //IRON II SALTS
    public static final RegistryObject<Item> IRON_II_OXIDE = Items.register( "iron_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),71.84,"FeO",0,4,"\nDesc: Used as a pigment.","", 1));
    public static final RegistryObject<Item> IRON_II_FLUORIDE = Items.register( "iron_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),93.84,"FeF2",0,4,"\nDesc: This is often used in organic chemistry as a catalyst.","C,H,A", 1));
    public static final RegistryObject<Item> IRON_II_SULFIDE = Items.register( "iron_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),87.91,"FeS",0,2,"\nDesc: This substance is pyrophoric. It is the green part of overcooked hard boiled eggs.","S3", 1));
    public static final RegistryObject<Item> IRON_II_CHLORIDE = Items.register( "iron_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.75,"FeCl2",0,4,"\nDesc: This substance has some laboratory use. Used in wastewater treatment for odor.","H", 1));
    public static final RegistryObject<Item> IRON_II_BROMIDE = Items.register( "iron_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),215.65,"FeBr2",0,4,"\nDesc: Not much is known.","", 1));
    public static final RegistryObject<Item> IRON_II_IODIDE = Items.register( "iron_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),309.65,"FeI2",0,4,"\nDesc: In the homeopathy, it finds use as a medicine.","", 1));
    public static final RegistryObject<Item> IRON_II_ARSENATE = Items.register( "iron_ii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),445.37,"Fe3(AsO4)2",0,4,"\nDesc: An insecticide, and a pesticide.","T,H,I", 1));
    public static final RegistryObject<Item> IRON_II_PHOSPHATE = Items.register( "iron_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),357.48,"Fe3(PO4)2",0,4,"\nDesc: Occurs naturally as the mineral vivianite.","I", 1));
    public static final RegistryObject<Item> IRON_II_SULFATE = Items.register( "iron_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.91,"FeSO4",0,4,"\nDesc: This is on the World Health Organization's list of essential medicines. It is an iron supplement, and a precursor to other iron compounds.","I", 1));
    public static final RegistryObject<Item> IRON_II_NITRATE = Items.register( "iron_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),179.86,"Fe(NO3)2",0,4,"\nDesc: It has been considered as a potential dye remover.","", 1));
    public static final RegistryObject<Item> IRON_II_PERCHLORATE = Items.register( "iron_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),272.76,"Fe(ClO4)2",0,4,"\nDesc: Found in batteries, and used in pyrotechnics.","O,I", 1));
    public static final RegistryObject<Item> IRON_II_CARBONATE = Items.register( "iron_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.85,"FeCO3",0,4,"\nDesc: Useful as an iron supplement.","", 1));
    public static final RegistryObject<Item> IRON_II_ACETATE = Items.register( "iron_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),173.93,"Fe(C2H3O2)2",0,4,"\nDesc: Used as a mordant in the dyeing industry.","I", 1));
    public static final RegistryObject<Item> IRON_II_THIOCYANATE = Items.register( "iron_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),172.01,"Fe(SCN)2",0,2,"\nDesc: In organic chemistry, it can be used to detect peroxides.","", 1));
    public static final RegistryObject<Item> IRON_II_OXALATE = Items.register( "iron_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),143.86,"FeC2O4",0,4,"\nDesc: Occurs naturally as the mineral humboldtine","I", 1));
    public static final RegistryObject<Item> IRON_II_HYDROXIDE = Items.register( "iron_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),89.86,"Fe(OH)2",0,4,"\nDesc: Used in nickel-iron batteries. It has also been used as a detoxing agent for wetlands.","", 1));
    //iron iii salts
    public static final RegistryObject<Item> IRON_III_OXIDE = Items.register( "iron_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.69,"Fe2O3",0,4,"\nDesc: Finds use in the production of iron, steen, and other alloys.","I", 1));
    public static final RegistryObject<Item> IRON_III_FLUORIDE = Items.register( "iron_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),112.84,"FeF3",0,4,"\nDesc: This substance is used in ceramics.","C,I", 1));
    public static final RegistryObject<Item> IRON_III_CHLORIDE = Items.register( "iron_iii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),162.20,"FeCl3",0,4,"\nDesc: Used in sewage treatment, and in the general production of clean water.","C,I", 1));
    public static final RegistryObject<Item> IRON_III_BROMIDE = Items.register( "iron_iii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),295.56,"FeBr3",0,4,"\nDesc: Used in organic chemistry.","C,I", 1));
    public static final RegistryObject<Item> IRON_III_IODIDE = Items.register( "iron_iii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),436.56,"FeI3",0,1,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> IRON_III_ARSENATE = Items.register( "iron_iii_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),194.76,"FeAsO4",0,4,"\nDesc: Insecticide.","H,A,T", 1));
    public static final RegistryObject<Item> IRON_III_PHOSPHATE = Items.register( "iron_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.82,"FePO4",0,4,"\nDesc: Finds use in the production of steel, as a pesticide, and occurs naturally as the mineral strengite.","I", 1));
    public static final RegistryObject<Item> IRON_III_SULFATE = Items.register( "iron_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),399.88,"Fe2(SO4)3",0,4,"\nDesc: This substance can act as a mordant, and a coagulant for industrial waste.","", 1));
    public static final RegistryObject<Item> IRON_III_NITRATE = Items.register( "iron_iii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),241.86,"Fe(NO3)3",0,4,"\nDesc: Has uses in organic chemistry. Used to etch silver.","O,I", 1));
    public static final RegistryObject<Item> IRON_III_OXALATE = Items.register( "iron_iii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),375.75,"Fe2(C2O4)3",0,4,"\nDesc: Has used in organic chemistry, photography, and in batteries.","", 1));
    //LEAD II
    public static final RegistryObject<Item> LEAD_II_OXIDE = Items.register( "lead_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),223.20,"PbO",0,4,"\nDesc: Found in lead based glass and in ceramics.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_FLUORIDE = Items.register( "lead_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),245.20,"PbF2",0,4,"\nDesc: Used to make low melting glass.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_SULFIDE = Items.register( "lead_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),239.30,"PbS",0,4,"\nDesc: This substance is a semiconductor. It occurs naturally as the mineral galena.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_CHLORIDE = Items.register( "lead_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),278.10,"PbCl2",0,4,"\nDesc: This compound is considered one of the most important lead based reagents. It occurs naturally as the mineral cotunnite.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_BROMIDE = Items.register( "lead_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),367.01,"PbBr2",0,4,"\nDesc: A byproduct of leaded-gasoline combustion.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_IODIDE = Items.register( "lead_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),461.01,"PbI2",0,4,"\nDesc: Used in solar cells, and was formerly used as the paint Iodide Yellow.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_ARSENITE = Items.register( "lead_ii_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),421.00,"Pb(AsO2)2",0,4,"\nDesc: An insecticide.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_PHOSPHATE = Items.register( "lead_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),811.54,"Pb3(PO4)2",0,4,"\nDesc: Not much is known about this compound.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_SULFATE = Items.register( "lead_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),303.26,"PbSO4",0,4,"\nDesc: Used in lead-acid storage batteries. It is also used for paint pigments.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_THIOSULFATE = Items.register( "lead_ii_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),319.00,"PbS2O3",0,4,"\nDesc: This compound is useful in photography.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_NITRATE = Items.register( "lead_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),331.20,"Pb(NO3)2",0,4,"\nDesc: This substance is used to heat stabilize nylon and polyesters.","C,I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_PERCHLORATE = Items.register( "lead_ii_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),406.10,"Pb(ClO4)2",0,4,"\nDesc: Not much is known about this compound's use.","O,I,T,A", 1));
    public static final RegistryObject<Item> LEAD_II_IODATE = Items.register( "lead_ii_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),557.01,"Pb(IO3)2",0,4,"\nDesc: This compound is often used in the volumetric determination of lead content in ore.","O,I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_CARBONATE = Items.register( "lead_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),267.21,"PbCO3",0,4,"\nDesc: Finds some lab uses. Occurs naturally as the mineral cerussite.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_CHROMATE = Items.register( "lead_ii_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),323.19,"PbCrO4",0,4,"\nDesc: Is known as the paint Chrome Yellow.","T,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_ACETATE = Items.register( "lead_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),325.29,"Pb(C2H3O2)2",0,4,"\nDesc: Formerly used as a sweetener and in cosmetics.","H,A", 1));
    public static final RegistryObject<Item> LEAD_II_CYANIDE = Items.register( "lead_ii_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),259.00,"Pb(CN)2",0,4,"\nDesc: Useful in metallurgy.","T,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_THIOCYANATE = Items.register( "lead_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),323.36,"Pb(SCN)2",0,4,"\nDesc: Is often used in the production of explosives.","I,H,A", 1));
    public static final RegistryObject<Item> LEAD_II_HYDROXIDE = Items.register( "lead_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),241.20,"Pb(OH)2",0,4,"\nDesc: This compound was potentially used by chemists in the past.","T,I,H,A", 1));
    //magnesium salts
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = Items.register( "magnesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),40.30,"MgO",0,4,"\nDesc: This compound is a refractory material.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_FLUORIDE = Items.register( "magnesium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),62.30,"MgF2",0,4,"\nDesc: Used in the production of optics.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_SULFIDE = Items.register( "magnesium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.38,"MgS",0,2,"\nDesc: A byproduct in steel-making.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_CHLORIDE = Items.register( "magnesium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),95.21,"MgCl2",0,4,"\nDesc: This substance has wide use, such as magnesium metal production, de-icing, and in the food industry.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_NITRIDE = Items.register( "magnesium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),100.95,"Mg3N2",0,4,"\nDesc: Has some laboratory uses.","F,I", 1));
    public static final RegistryObject<Item> MAGNESIUM_BROMIDE = Items.register( "magnesium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),184.11,"MgBr2",0,4,"\nDesc: This compound has uses in organic chemistry. It also is a tranquilizer.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_IODIDE = Items.register( "magnesium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),278.11,"MgI2",0,4,"\nDesc: Finds use in organic chemistry.","I,C", 1));
    public static final RegistryObject<Item> MAGNESIUM_ARSENATE = Items.register( "magnesium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),350.75,"Mg3(AsO4)2",0,4,"\nDesc: This compound is an insecticide. It is also used in the production of fluorescent lamps.","H", 1));
    public static final RegistryObject<Item> MAGNESIUM_DIHYDROGEN_PHOSPHATE = Items.register( "magnesium_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),218.28,"Mg(H2PO4)2",0,4,"\nDesc: This substance is often used as a food additive. It functions as an acid regulator.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_SULFATE = Items.register( "magnesium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),120.37,"MgSO4",0,4,"\nDesc: Also known as bath salts or epsom salt.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_THIOSULFATE = Items.register( "magnesium_thiosulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),136.44,"MgS2O3",0,4,"\nDesc: Often used as fertilizer.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_NITRATE = Items.register( "magnesium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),148.32,"Mg(NO3)2",0,4,"\nDesc: Used in the production of nitric acid.","O,I", 1));
    public static final RegistryObject<Item> MAGNESIUM_PERCHLORATE = Items.register( "magnesium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),223.21,"Mg(ClO4)2",0,4,"\nDesc: Functions as a desiccant.","O,I", 1));
    public static final RegistryObject<Item> MAGNESIUM_CHLORATE = Items.register( "magnesium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),191.20,"Mg(ClO3)2",0,4,"\nDesc: Functions as a desiccant, and as a defoliant. It is also used as eye drop lubricant.","O,I", 1));
    public static final RegistryObject<Item> MAGNESIUM_CARBONATE = Items.register( "magnesium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.31,"MgCO3",0,4,"\nDesc: Used in the production of magnesium oxide. It is also a food additive and a laxative.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_CHROMATE = Items.register( "magnesium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),140.30,"MbCrO4",0,4,"\nDesc: Can be used as corrosion inhibitor. Is used in the cosmetics industry.","I,H,A", 1));
    public static final RegistryObject<Item> MAGNESIUM_ACETATE = Items.register( "magnesium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),142.39,"Mg(C2H3O2)2",0,4,"\nDesc: Is often used in the production of calcium magnesium acetate.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_FORMATE = Items.register( "magnesium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),114.33,"Mg(HCO2)2",0,4,"\nDesc: Used in organic chemistry.","", 1));
    public static final RegistryObject<Item> MAGNESIUM_PEROXIDE = Items.register( "magnesium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.30,"MgO2",0,4,"\nDesc: Used in the reduction of contamination of groundwater.","O", 1));
    public static final RegistryObject<Item> MAGNESIUM_OXALATE = Items.register( "magnesium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),112.32,"MgC2O4",0,4,"\nDesc: Has some lab use.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_HYDROXIDE = Items.register( "magnesium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.32,"Mg(OH)2",0,4,"\nDesc: This compound can be used as an antacid. Also known as milk of magnesia.","I", 1));
    public static final RegistryObject<Item> MAGNESIUM_PERMANGANATE = Items.register( "magnesium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),262.18,"Mg(MnO4)2",0,4,"\nDesc: This substance is a wood impregnation agent.","", 1));
    //MANGANESE II SALTS
    public static final RegistryObject<Item> MANGANESE_II_OXIDE = Items.register( "manganese_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),70.94,"MnO",0,4,"\nDesc: Can be used as a fertilizer or as a food additive.","", 1));
    public static final RegistryObject<Item> MANGANESE_II_FLUORIDE = Items.register( "manganese_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),92.93,"MnF2",0,4,"\nDesc: Used in the production of glass and lasers.","I", 1));
    public static final RegistryObject<Item> MANGANESE_II_SULFIDE = Items.register( "manganese_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),87.00,"MnS",0,4,"\nDesc: Occurs naturally as the minerals alabandite and rambergite.","I", 1));
    public static final RegistryObject<Item> MANGANESE_II_CHLORIDE = Items.register( "manganese_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.84,"MnCl2",0,4,"\nDesc: Finds use in organic chemistry. It is also used in the production of dry cell batteries.","", 1));
    public static final RegistryObject<Item> MANGANESE_II_BROMIDE = Items.register( "manganese_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),214.75,"MnBr2",0,4,"\nDesc: In organic chemistry, it is used in the Stille reaction.","I", 1));
    public static final RegistryObject<Item> MANGANESE_II_IODIDE = Items.register( "manganese_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),308.75,"MnI2",0,4,"\nDesc: Finds use in the lighting industry.","H", 1));
    public static final RegistryObject<Item> MANGANESE_II_PHOSPHATE = Items.register( "manganese_ii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),354.76,"Mn3(PO4)2",0,4,"\nDesc: Is often used as an anti-corrosion coating.","I,H", 1));
    public static final RegistryObject<Item> MANGANESE_II_SULFATE = Items.register( "manganese_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.00,"MnSO4",0,4,"\nDesc: This is an important precursor salt.","H,A", 1));
    public static final RegistryObject<Item> MANGANESE_II_NITRATE = Items.register( "manganese_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),178.95,"Mn(NO3)2",0,4,"\nDesc: Useful in the production of fertilizers.","", 1));
    public static final RegistryObject<Item> MANGANESE_II_CHLORATE = Items.register( "manganese_ii_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),221.84,"Mn(ClO3)2",0,1,"\nDesc: This compound does not find much use, since it explodes at room temperature.","E", 1));
    public static final RegistryObject<Item> MANGANESE_II_CARBONATE = Items.register( "manganese_ii_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),114.95,"MnCO3",0,4,"\nDesc: Used in fertilizers, ceramics and in healthy foods.","", 1));
    public static final RegistryObject<Item> MANGANESE_II_ACETATE = Items.register( "manganese_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),173.03,"Mn(C2H3O2)2",0,4,"\nDesc: Finds use as a fertilizer, and as a catalyst in the lab.","", 1));
    public static final RegistryObject<Item> MANGANESE_II_OXALATE = Items.register( "manganese_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),142.96,"MnC2O4",0,4,"\nDesc: This compound is often used as a siccative for oil based paints.","I", 1));
    public static final RegistryObject<Item> MANGANESE_II_HYDROXIDE = Items.register( "manganese_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),88.95,"Mn(OH)2",0,2,"\nDesc: This compound is also known as pyrochroite.","", 1));
    //manganese iii salts
    public static final RegistryObject<Item> MANGANESE_III_OXIDE = Items.register( "manganese_iii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),157.87,"Mn2O3",0,4,"\nDesc: Used in the production of thermistors. It also occurs as the mineral bixbyite.","", 1));
    public static final RegistryObject<Item> MANGANESE_III_FLUORIDE = Items.register( "manganese_iii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),111.94,"MnF3",0,4,"\nDesc: This is often used as a fluorination agent.","T,O", 1));
    public static final RegistryObject<Item> MANGANESE_III_PHOSPHATE = Items.register( "manganese_iii_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.91,"MnPO4",0,4,"\nDesc: Occurs naturally as the mineral purpurite.","", 1));
    public static final RegistryObject<Item> MANGANESE_III_SULFATE = Items.register( "manganese_iii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),398.10,"Mn2(SO4)3",0,4,"\nDesc: Is used often in the production of sulfuric acid.","", 1));
    public static final RegistryObject<Item> MANGANESE_III_ACETATE = Items.register( "manganese_iii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),232.09,"Mn(C2H3O2)3",0,4,"\nDesc: This finds some use in organic chemistry.","I", 1));
    //MERCURY I SALTS
    public static final RegistryObject<Item> MERCURY_I_OXIDE = Items.register( "mercury_i_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),417.18,"Hg2O",0,2,"\nDesc: Not much is known.","T,H,I", 1));
    public static final RegistryObject<Item> MERCURY_I_FLUORIDE = Items.register( "mercury_i_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),439.18,"Hg2F2",0,4,"\nDesc: This compound has some use in organic chemistry.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_I_CHLORIDE = Items.register( "mercury_i_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),472.09,"Hg2Cl2",0,4,"\nDesc: This substance is often used in electrochemistry.","I,A", 1));
    public static final RegistryObject<Item> MERCURY_I_BROMIDE = Items.register( "mercury_i_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),560.99,"Hg2Br2",0,4,"\nDesc: This is often used in the production of acousto-optical devices.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_I_IODIDE = Items.register( "mercury_i_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),654.99,"Hg2I2",0,1,"\nDesc: This medicine is now banned. It was formerly known as protiodide of mercury.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_I_SULFATE = Items.register( "mercury_i_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),497.24,"Hg2SO4",0,4,"\nDesc: Can be implemented in electrochemical cells.","", 1));
    public static final RegistryObject<Item> MERCURY_I_NITRATE = Items.register( "mercury_i_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),525.19,"Hg2(NO3)2",0,4,"\nDesc: This compound has some laboratory uses.","", 1));
    //mercury ii salts
    public static final RegistryObject<Item> MERCURY_II_OXIDE = Items.register( "mercury_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),216.59,"HgO",0,4,"\nDesc: This is often used in the production of mercury metal.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_FLUORIDE = Items.register( "mercury_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),238.59,"HgF2",0,4,"\nDesc: This is used in organic chemistry.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_SULFIDE = Items.register( "mercury_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),232.66,"HgS",0,4,"\nDesc: This compound is also known as cinnabar. It is often used as a pigment, known as vermilion.","T,I,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_CHLORIDE = Items.register( "mercury_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),271.52,"HgCl",0,4,"\nDesc: This was formerly used as a medicine to treat syphilis.","C,T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_BROMIDE = Items.register( "mercury_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),360.41,"HgBr2",0,4,"\nDesc: Has some laboratory use.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_IODIDE = Items.register( "mercury_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),454.40,"HgI2",0,4,"\nDesc: This substance was used to make Nessier's reagent. It occurs naturally as the mineral coccinite","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_SULFATE = Items.register( "mercury_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),296.65,"HgSO40",0,4,"\nDesc: This is used in organic chemistry.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_NITRATE = Items.register( "mercury_ii_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),324.60,"Hg(NO3)2",0,4,"\nDesc: Is often used in organic chemistry.","O,T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_ACETATE = Items.register( "mercury_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),318.68,"Hg(C2H3O2)2",0,4,"\nDesc: This compound finds some use in organic chemistry.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_CYANIDE = Items.register( "mercury_ii_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),252.63,"Hg(CN)2",0,4,"\nDesc: This was formerly used as an antiseptic. It is also used in photography.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_THIOCYANATE = Items.register( "mercury_ii_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),316.76,"Hg(SCN)2",0,4,"\nDesc: This compound creates what is known as the pharaoh's serpent when ignited.","T,H,A", 1));
    public static final RegistryObject<Item> MERCURY_II_HYDROXIDE = Items.register( "mercury_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),234.61,"Hg(OH)2",0,4,"\nDesc: Not much is known about this compound's use.","T,H,A", 1));
    //NITRONIUM SALTS
    public static final RegistryObject<Item> NITRONIUM_FLUORIDE = Items.register( "nitronium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),65.00,"NO2F",0,4,"\nDesc: This could potentially be used as a rocket propellant.","", 1));
    public static final RegistryObject<Item> NITRONIUM_CHLORIDE = Items.register( "nitronium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),81.46,"NO2Cl",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> NITRONIUM_PERCHLORATE = Items.register( "nitronium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),145.45,"NO2ClO4",0,4,"\nDesc: This was formerly used as an oxidizer in solid fuel rocket propellants.","E,O", 1));
    //silver salts
    public static final RegistryObject<Item> SILVER_OXIDE = Items.register( "silver_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),231.74,"Ag2O",0,4,"\nDesc: This is used in the preparation of other silver compounds.","O,I", 1));
    public static final RegistryObject<Item> SILVER_FLUORIDE = Items.register( "silver_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.87,"AgF",0,4,"\nDesc: This has some use in organic chemistry.","C", 1));
    public static final RegistryObject<Item> SILVER_SULFIDE = Items.register( "silver_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),247.80,"Ag2S",0,4,"\nDesc: This has some use in photography, and is the tarnish that appears on silverware.","I", 1));
    public static final RegistryObject<Item> SILVER_CHLORIDE = Items.register( "silver_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),143.32,"AgCl",0,4,"\nDesc: This has some use in photography, and in pH meters.","", 1));
    public static final RegistryObject<Item> SILVER_NITRIDE = Items.register( "silver_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),337.62,"Ag3N",0,4,"\nDesc: This compound is extremely explosive, reacting with even a drop of water.","E,F,S1,S4", 1));
    public static final RegistryObject<Item> SILVER_BROMIDE = Items.register( "silver_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),187.77,"AgBr",0,4,"\nDesc: This is used in photographic film.","A", 1));
    public static final RegistryObject<Item> SILVER_IODIDE = Items.register( "silver_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),234.77,"AgI",0,4,"\nDesc: This is used in photography, and can act as an antiseptic.","A", 1));
    public static final RegistryObject<Item> SILVER_ARSENATE = Items.register( "silver_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),462.52,"Ag3AsO4",0,4,"\nDesc: This compound has some laboratory use.","T,H,A", 1));
    public static final RegistryObject<Item> SILVER_ARSENITE = Items.register( "silver_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),446.52,"Ag3AsO3",0,4,"\nDesc: This is used in the production of dyes, and can act as antiseptic.","T,H,A", 1));
    public static final RegistryObject<Item> SILVER_PHOSPHATE = Items.register( "silver_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),418.57,"Ag3PO4",0,4,"\nDesc: This has some laboratory uses, and is often used in photography.","", 1));
    public static final RegistryObject<Item> SILVER_SULFATE = Items.register( "silver_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),311.79,"Ag2SO4",0,4,"\nDesc: Not much is known about this compound's use.","C,A", 1));
    public static final RegistryObject<Item> SILVER_NITRATE = Items.register( "silver_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),169.87,"AgNO3",0,4,"\nDesc: This compound is a precursor to other mercury compounds, and can act as an antiseptic.","O,C,T,A", 1));
    public static final RegistryObject<Item> SILVER_NITRITE = Items.register( "silver_nitrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),153.87,"AgNO2",0,4,"\nDesc: This has some use in organic chemistry.","O,I,A", 1));
    public static final RegistryObject<Item> SILVER_PERCHLORATE = Items.register( "silver_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),207.32,"AgClO4",0,4,"\nDesc: This compound is a catalyst in organic chemistry.","O,C", 1));
    public static final RegistryObject<Item> SILVER_CHLORATE = Items.register( "silver_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),191.32,"AgClO3",0,4,"\nDesc: Not much is known about this compound's use.","O,E,S4", 1));
    public static final RegistryObject<Item> SILVER_CHLORITE = Items.register( "silver_chlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),175.32,"AgClO2",0,4,"\nDesc: Not much is known about this compound's use.","O,E,S4", 1));
    public static final RegistryObject<Item> SILVER_HYPOCHLORITE = Items.register( "silver_hypochlorite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.32,"AgClO",0,1,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> SILVER_IODATE = Items.register( "silver_iodate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),282.77,"AgIO3",0,4,"\nDesc: This is used to detect traces of chlorides in blood.","", 1));
    public static final RegistryObject<Item> SILVER_BROMATE = Items.register( "silver_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),235.77,"AgBrO3",0,4,"\nDesc: This has some use in organic chemistry.","T,I,O", 1));
    public static final RegistryObject<Item> SILVER_CARBONATE = Items.register( "silver_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),275.75,"Ag2CO3",0,4,"\nDesc: This is used to produce silver powder.","C,A", 1));
    public static final RegistryObject<Item> SILVER_CHROMATE = Items.register( "silver_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),331.73,"Ag2CrO4",0,4,"\nDesc: Found in artificial pacemakers. It is also used in wastewater treatment.","O,H,I,A", 1));
    public static final RegistryObject<Item> SILVER_DICHROMATE = Items.register( "silver_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),431.76,"Ag2Cr2O7",0,4,"\nDesc: This is used in organic chemistry.","O,H,I,A", 1));
    public static final RegistryObject<Item> SILVER_ACETATE = Items.register( "silver_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),166.91,"AgC2H3O2",0,4,"\nDesc: This compound has been utilized and added to products to deter smokers from smoking.","I,A", 1));
    public static final RegistryObject<Item> SILVER_CYANIDE = Items.register( "silver_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),133.89,"AgCN",0,4,"\nDesc: Used often in silver cyanidation extraction.","C,T,A", 1));
    public static final RegistryObject<Item> SILVER_THIOCYANATE = Items.register( "silver_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.95,"AgSCN",0,4,"\nDesc: Not much is known about this compound's use.","I,A", 1));
    public static final RegistryObject<Item> SILVER_OXALATE = Items.register( "silver_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),303.76,"Ag2C2O4",0,4,"\nDesc: This substance finds use in petrology.","H,E,S4", 1));
    public static final RegistryObject<Item> SILVER_HYDROXIDE = Items.register( "silver_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),124.88,"AgOH",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> SILVER_PERMANGANATE = Items.register( "silver_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),226.80,"AgMnO4",0,4,"\nDesc: This is used in the production of gas masks.","O,I,E", 1));
    //STRONTIUM SALTS
    public static final RegistryObject<Item> STRONTIUM_OXIDE = Items.register( "strontium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),103.62,"SrO",0,4,"\nDesc: Found in cathode ray tubes.","", 1));
    public static final RegistryObject<Item> STRONTIUM_FLUORIDE = Items.register( "strontium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.62,"SrF2",0,4,"\nDesc: An optical material, it also occurs naturally as the mineral strontium-fluorite.","", 1));
    public static final RegistryObject<Item> STRONTIUM_SULFIDE = Items.register( "strontium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.68,"SrS",0,4,"\nDesc: This is an intermediate to other strontium compounds.","", 1));
    public static final RegistryObject<Item> STRONTIUM_CHLORIDE = Items.register( "strontium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.53,"SrCl2",0,4,"\nDesc: This can be used in pyrotechnics to add red colors.","I", 1));
    public static final RegistryObject<Item> STRONTIUM_NITRIDE = Items.register( "strontium_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),290.87,"Sr3N2",0,4,"\nDesc: Not much is known about this compound's use.","I", 1));
    public static final RegistryObject<Item> STRONTIUM_BROMIDE = Items.register( "strontium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),247.43,"SrBr2",0,4,"\nDesc: This is used in flares.","C", 1));
    public static final RegistryObject<Item> STRONTIUM_IODIDE = Items.register( "strontium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),341.43,"SrI2",0,4,"\nDesc: This is used a medicine. It is also used in scintillation gamma radiation detectors.","C", 1));
    public static final RegistryObject<Item> STRONTIUM_SULFATE = Items.register( "strontium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),183.68,"SrSO4",0,4,"\nDesc: This compound is a precursor to other strontium compounds. It occurs naturally as the mineral celestine.","", 1));
    public static final RegistryObject<Item> STRONTIUM_NITRATE = Items.register( "strontium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),211.63,"Sr(NO3)2",0,4,"\nDesc: This is used in pyrotechnics, and is used to strengthen the effect of glycolic acid.","I,O", 1));
    public static final RegistryObject<Item> STRONTIUM_PERCHLORATE = Items.register( "strontium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),286.51,"Sr(ClO4)2",0,4,"\nDesc: This is used in the liquid injection thrust vectors in control rockets.","O", 1));
    public static final RegistryObject<Item> STRONTIUM_CHLORATE = Items.register( "strontium_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),254.52,"Sr(ClO3)2",0,4,"\nDesc: Not much is known about this compound's use.","O", 1));
    public static final RegistryObject<Item> STRONTIUM_BROMATE = Items.register( "strontium_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),343.42,"Sr(BrO3)2",0,4,"\nDesc: This compound does not have much use.","T,H,I", 1));
    public static final RegistryObject<Item> STRONTIUM_CARBONATE = Items.register( "strontium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),147.63,"SrCO3",0,4,"\nDesc: This is used in pyrotechnics. It also occurs naturally as the mineral strontianite","", 1));
    public static final RegistryObject<Item> STRONTIUM_CHROMATE = Items.register( "strontium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),203.61,"SrCrO4",0,4,"\nDesc: This is used as a corrosion inhibitor, in pyrotechnics, and as the pigment Strontium Yellow.","T,H,A", 1));
    public static final RegistryObject<Item> STRONTIUM_ACETATE = Items.register( "strontium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),205.93,"Sr(C2H3O2)2",0,4,"\nDesc: This has some laboratory use.","", 1));
    public static final RegistryObject<Item> STRONTIUM_FORMATE = Items.register( "strontium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),177.65,"Sr(HCO2)2",0,4,"\nDesc: This is used in the production of formic acid.","", 1));
    public static final RegistryObject<Item> STRONTIUM_PEROXIDE = Items.register( "strontium_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.62,"SrO2",0,4,"\nDesc: This is used in pyrotechnics, can be used as a bleaching agent, and as an antiseptic.","O,I,C", 1));
    public static final RegistryObject<Item> STRONTIUM_OXALATE = Items.register( "strontium_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),175.64,"SrC2O4",0,4,"\nDesc: Finds some use in pyrotechnics.","I", 1));
    public static final RegistryObject<Item> STRONTIUM_HYDROXIDE = Items.register( "strontium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),121.63,"Sr(OH)2",0,4,"\nDesc: This compound is used in the refining of beet sugar, and can be used as a stabilizer in plastic.","I", 1));
    //tin ii salts
    public static final RegistryObject<Item> TIN_II_OXIDE = Items.register( "tin_ii_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),134.71,"SnO",0,4,"\nDesc: This is a precursor to other tin compounds. It is also used in the production of ruby glass.","", 1));
    public static final RegistryObject<Item> TIN_II_FLUORIDE = Items.register( "tin_ii_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),156.69,"SnF2",0,4,"\nDesc: This can be found in toothpaste.","", 1));
    public static final RegistryObject<Item> TIN_II_SULFIDE = Items.register( "tin_ii_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.78,"SnS",0,4,"\nDesc: This has some potential use in photovoltaic cells.","I", 1));
    public static final RegistryObject<Item> TIN_II_CHLORIDE = Items.register( "tin_ii_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),189.60,"SnCl2",0,4,"\nDesc: Is often used in tin plating, and as a mordant in textile dyeing.","C,I,H,A", 1));
    public static final RegistryObject<Item> TIN_II_BROMIDE = Items.register( "tin_ii_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),278.52,"SnBr2",0,4,"\nDesc: This has some use in organic chemistry.","C", 1));
    public static final RegistryObject<Item> TIN_II_IODIDE = Items.register( "tin_ii_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),372.52,"SnI2",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> TIN_II_SULFATE = Items.register( "tin_ii_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),214.77,"SnSO4",0,4,"\nDesc: This acts as a good source of tin II ions.","", 1));
    public static final RegistryObject<Item> TIN_II_ACETATE = Items.register( "tin_ii_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),236.80,"Sn(C2H3O2)2",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> TIN_II_OXALATE = Items.register( "tin_ii_oxalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),206.73,"SnC2O4",0,4,"\nDesc: This compound finds uses in organic chemistry and in dyeing.","C,I", 1));
    public static final RegistryObject<Item> TIN_II_HYDROXIDE = Items.register( "tin_ii_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),152.73,"Sn(OH)2",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    //TIN IV SALTS
    public static final RegistryObject<Item> TIN_IV_OXIDE = Items.register( "tin_iv_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),150.71,"SnO2",0,4,"\nDesc: This is used in the production of ceramic glass. It also occurs as the mineral cassiterite.","", 1));
    public static final RegistryObject<Item> TIN_IV_FLUORIDE = Items.register( "tin_iv_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),194.70,"SnF4",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> TIN_IV_SULFIDE = Items.register( "tin_iv_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),182.83,"SnS2",0,4,"\nDesc: This substance is a semiconductor. It also occurs as the mineral berndtite.","I", 1));
    public static final RegistryObject<Item> TIN_IV_CHLORIDE = Items.register( "tin_iv_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),260.50,"SnCl4",0,4,"\nDesc: This has some use in organic chemistry. It was also used as a chemical weapon in World War II.","C,I", 1));
    public static final RegistryObject<Item> TIN_IV_BROMIDE = Items.register( "tin_iv_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),438.73,"SnBr4",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> TIN_IV_IODIDE = Items.register( "tin_iv_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),626.33,"SnI4",0,4,"\nDesc: This has some use in organic chemistry.","", 1));
    public static final RegistryObject<Item> TIN_IV_ARSENATE = Items.register( "tin_iv_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),911.80,"Sn3(AsO4)4",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> TIN_IV_NITRATE = Items.register( "tin_iv_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),366.73,"Sn(NO3)4",0,4,"\nDesc: Not much is known about this compound's use.","O,C", 1));
    public static final RegistryObject<Item> TIN_IV_HYDROXIDE = Items.register( "tin_iv_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),190.77,"Sn(OH)4",0,4,"\nDesc: This is often used as a pigment.","", 1));
    //zinc
    public static final RegistryObject<Item> ZINC_OXIDE = Items.register( "zinc_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),81.41,"ZnO",0,4,"\nDesc: This substance sees wide use. It occurs naturally as the mineral zincite.","A", 1));
    public static final RegistryObject<Item> ZINC_FLUORIDE = Items.register( "zinc_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),103.41,"ZnF2",0,4,"\nDesc: Not much is known about this compound's use.","C,I,T", 1));
    public static final RegistryObject<Item> ZINC_SULFIDE = Items.register( "zinc_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.47,"ZnS",0,4,"\nDesc: This material is used in optics. It occurs naturally as the mineral spharelite.","", 1));
    public static final RegistryObject<Item> ZINC_CHLORIDE = Items.register( "zinc_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),136.32,"ZnCl2",0,4,"\nDesc: This compound sees use in both organic chemistry and in textile processing.","C,T,I,A", 1));
    public static final RegistryObject<Item> ZINC_NITRIDE = Items.register( "zinc_nitride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),224.15,"Zn3N2",0,4,"\nDesc: This material is a semiconductor.","I,S1", 1));
    public static final RegistryObject<Item> ZINC_BROMIDE = Items.register( "zinc_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),225.20,"ZnBr2",0,4,"\nDesc: This compound is used in organic chemistry. It can also be used to create radiation shields.","", 1));
    public static final RegistryObject<Item> ZINC_IODIDE = Items.register( "zinc_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),319.19,"ZnI2",0,4,"\nDesc: This compound is most commonly used in industrial radiography.","", 1));
    public static final RegistryObject<Item> ZINC_ARSENATE = Items.register( "zinc_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),474.00,"Zn3(AsO4)2",0,4,"\nDesc: This has been used as an insecticide. It can also be used as a wood preservative.","T,H,A", 1));
    public static final RegistryObject<Item> ZINC_ARSENITE = Items.register( "zinc_arsenite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),442.00,"Zn3(AsO3)2",0,4,"\nDesc: This has been used as an insecticide. It can also be used as a wood preservative.","T,H,A", 1));
    public static final RegistryObject<Item> ZINC_PHOSPHATE = Items.register( "zinc_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),386.11,"Zn3(PO4)2",0,4,"\nDesc: A common application of this substance is as an anti-corrosion coating.","", 1));
    public static final RegistryObject<Item> ZINC_DIHYDROGEN_PHOSPHATE = Items.register( "zinc_dihydrogen_phosphate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),259.40,"Zn(H2PO4)2",0,4,"\nDesc: This compound is often used as a plasticiser.","I,A", 1));
    public static final RegistryObject<Item> ZINC_SULFATE = Items.register( "zinc_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),161.44,"ZnSO4",0,4,"\nDesc: This compound is used to produce rayon. It also has various nutritional applications.","C,I,A", 1));
    public static final RegistryObject<Item> ZINC_SULFITE = Items.register( "zinc_sulfite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),145.40,"ZnSO3",0,4,"\nDesc: This is used to produce sulfurous acid.","C,I", 1));
    public static final RegistryObject<Item> ZINC_NITRATE = Items.register( "zinc_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),189.36,"Zn(NO3)2",0,4,"\nDesc: This compound finds some laboratory use.","O,I", 1));
    public static final RegistryObject<Item> ZINC_PERCHLORATE = Items.register( "zinc_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),264.29,"Zn(ClO4)2",0,4,"\nDesc: This compound finds some laboratory use.","O", 1));
    public static final RegistryObject<Item> ZINC_CHLORATE = Items.register( "zinc_chlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),232.29,"Zn(ClO3)2",0,4,"\nDesc: This substance is used to produce explosives.","O", 1));
    public static final RegistryObject<Item> ZINC_BROMATE = Items.register( "zinc_bromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),321.20,"Zn(BrO3)2",0,4,"\nDesc: Used in the production of bromic acid.","A,H,I,C,T", 1));
    public static final RegistryObject<Item> ZINC_CARBONATE = Items.register( "zinc_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),125.40,"ZnCO3",0,4,"\nDesc: This occurs naturally as the mineral smithsonite.","A", 1));
    public static final RegistryObject<Item> ZINC_CHROMATE = Items.register( "zinc_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),181.40,"ZnCrO4",0,4,"\nDesc: This is also known as the pigment Zinc Yellow, and used in industrial painting.","I,H,A,O", 1));
    public static final RegistryObject<Item> ZINC_DICHROMATE = Items.register( "zinc_dichromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),281.40,"ZnCr2O7",0,4,"\nDesc: This is used often as a pigment in industrial painting.","I,H,A,O", 1));
    public static final RegistryObject<Item> ZINC_ACETATE = Items.register( "zinc_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),219.50,"Zn(C2H3O2)2",0,4,"\nDesc: This medicine also acts as a dietary supplement, and as a food additive.","C,I,A", 1));
    public static final RegistryObject<Item> ZINC_FORMATE = Items.register( "zinc_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),155.40,"Zn(HCO2)2",0,4,"\nDesc: This finds use in both organic chemistry and in the textile industry.","I", 1));
    public static final RegistryObject<Item> ZINC_CYANIDE = Items.register( "zinc_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),117.44,"Zn(CN)2",0,4,"\nDesc: This is used in organic chemistry and in the electroplating of zinc.","T,A", 1));
    public static final RegistryObject<Item> ZINC_THIOCYANATE = Items.register( "zinc_thiocyanate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),181.50,"Zn(SCN)2",0,4,"\nDesc: This is used to produce thiocyanic acid.","I,H,A", 1));
    public static final RegistryObject<Item> ZINC_PEROXIDE = Items.register( "zinc_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),97.41,"ZnO2",0,4,"\nDesc: This compound is used as a medicine. It is also used in pyrotechnics.","O,I,C,H", 1));
    public static final RegistryObject<Item> ZINC_HYDROXIDE = Items.register( "zinc_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),99.42,"Zn(OH)2",0,4,"\nDesc: This substance can be used as an absorbent in surgical dressings.","", 1));
    public static final RegistryObject<Item> ZINC_PERMANGANATE = Items.register( "zinc_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),303.30,"Zn(MnO4)2",0,4,"\nDesc: This substance exhibits antiseptic properties.","O,H,I", 1));
    //CAESIUM SALTS
    public static final RegistryObject<Item> CAESIUM_OXIDE = Items.register( "caesium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),281.81,"Cs2O",0,4,"\nDesc: This compound is used in photocathodes.","C,H,S1", 1));
    public static final RegistryObject<Item> CAESIUM_FLUORIDE = Items.register( "caesium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.90,"CsF",0,4,"\nDesc: This finds some use in organic chemistry.","C,T,H", 1));
    public static final RegistryObject<Item> CAESIUM_SULFIDE = Items.register( "caesium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),297.88,"Cs2S",0,4,"\nDesc: Not much is known about this compound's use.","C,A", 1));
    public static final RegistryObject<Item> CAESIUM_CHLORIDE = Items.register( "caesium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),168.36,"CsCl",0,4,"\nDesc: This is used in both organic chemistry and in centrifugation.","I,H", 1));
    public static final RegistryObject<Item> CAESIUM_BROMIDE = Items.register( "caesium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),212.81,"CsBr",0,4,"\nDesc: This is a beam-splitter component in spectrophotometers.","I", 1));
    public static final RegistryObject<Item> CAESIUM_IODIDE = Items.register( "caesium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),259.81,"CsI",0,4,"\nDesc: This is a beam-splitter component in Fourier transform infrared spectrophotometers.","I,A,H", 1));
    public static final RegistryObject<Item> CAESIUM_ARSENATE = Items.register( "caesium_arsenate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),537.64,"Cs3AsO4",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> CAESIUM_SULFATE = Items.register( "caesium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),361.87,"Cs2SO4",0,4,"\nDesc: Useful in isopycnic centrifugation.","I,H", 1));
    public static final RegistryObject<Item> CAESIUM_NITRATE = Items.register( "caesium_nitrate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),194.91,"CsNO3",0,4,"\nDesc: This is used in infrared spectroscopy.","O", 1));
    public static final RegistryObject<Item> CAESIUM_PERCHLORATE = Items.register( "caesium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),232.36,"CsClO4",0,4,"\nDesc: This finds use in gravimetric analysis","O", 1));
    public static final RegistryObject<Item> CAESIUM_CARBONATE = Items.register( "caesium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),325.82,"Cs2CO3",0,4,"\nDesc: This is used in both organic chemistry and in solar cells.","", 1));
    public static final RegistryObject<Item> CAESIUM_BICARBONATE = Items.register( "caesium_bicarbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),193.92,"CsHCO3",0,4,"\nDesc: This compound finds some laboratory use.","", 1));
    public static final RegistryObject<Item> CAESIUM_CHROMATE = Items.register( "caesium_chromate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),381.80,"Cs2CrO4",0,4,"\nDesc: This substance was formerly used for vacuum tube manufacturing.","O,I,H,A", 1));
    public static final RegistryObject<Item> CAESIUM_ACETATE = Items.register( "caesium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),191.95,"CsC2H3O2",0,4,"\nDesc: This is used in organic chemistry.","", 1));
    public static final RegistryObject<Item> CAESIUM_FORMATE = Items.register( "caesium_formate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),177.92,"CsHCO2",0,4,"\nDesc: This is one of many drilling fluids.","I,H", 1));
    public static final RegistryObject<Item> CAESIUM_CYANIDE = Items.register( "caesium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),158.92,"CsCN",0,4,"\nDesc: This compound is reported to have a smell reminiscent of bitter almonds.","I,T", 1));
    public static final RegistryObject<Item> CAESIUM_HYDROXIDE = Items.register( "caesium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.91,"CsOH",0,4,"\nDesc: This serves an analytical purpose in the glass industry.","C,H", 1));
    //rubidium salts
    public static final RegistryObject<Item> RUBIDIUM_OXIDE = Items.register( "rubidium_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),186.94,"Rb2O",0,4,"\nDesc: Not much is known about this compound's use.","C,S1", 1));
    public static final RegistryObject<Item> RUBIDIUM_FLUORIDE = Items.register( "rubidium_fluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),104.47,"RbF",0,4,"\nDesc: This finds some laboratory use.","H", 1));
    public static final RegistryObject<Item> RUBIDIUM_SULFIDE = Items.register( "rubidium_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),203.00,"Rb2S",0,4,"\nDesc: Not much is known about this compound's use.","T,C,A", 1));
    public static final RegistryObject<Item> RUBIDIUM_CHLORIDE = Items.register( "rubidium_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),120.92,"RbCl",0,4,"\nDesc: This compound sees use in electrochemistry and in molecular biology.","", 1));
    public static final RegistryObject<Item> RUBIDIUM_BROMIDE = Items.register( "rubidium_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),165.37,"RbBr",0,4,"\nDesc: Not much is known about this compound's use.","", 1));
    public static final RegistryObject<Item> RUBIDIUM_IODIDE = Items.register( "rubidium_iodide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),212.37,"RbI",0,4,"\nDesc: This finds use in both organic chemistry and as an ingredient for certain eye drops.","", 1));
    public static final RegistryObject<Item> RUBIDIUM_SULFATE = Items.register( "rubidium_sulfate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),267.00,"Rb2SO4",0,4,"\nDesc: Not much is known about this compound's use.","I", 1));
    public static final RegistryObject<Item> RUBIDIUM_PERCHLORATE = Items.register( "rubidium_perchlorate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),184.92,"RbClO4",0,4,"\nDesc: Not much is known about this compound's use.","O,I", 1));
    public static final RegistryObject<Item> RUBIDIUM_CARBONATE = Items.register( "rubidium_carbonate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),230.95,"Rb2CO3",0,4,"\nDesc: This is the most common form that rubidium is sold in.","I", 1));
    public static final RegistryObject<Item> RUBIDIUM_ACETATE = Items.register( "rubidium_acetate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),144.51,"RbC2H3O2",0,4,"\nDesc: This compound is used in synthesis.","", 1));
    public static final RegistryObject<Item> RUBIDIUM_CYANIDE = Items.register( "rubidium_cyanide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),111.49,"RbCN",0,4,"\nDesc: This compound is reported to have a smell reminiscent of bitter almonds.","T", 1));
    public static final RegistryObject<Item> RUBIDIUM_HYDROXIDE = Items.register( "rubidium_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),102.48,"RbOH",0,4,"\nDesc: This has limited industrial use.","C", 1));
    public static final RegistryObject<Item> RUBIDIUM_PERMANGANATE = Items.register( "rubidium_permanganate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.SALT_TAB).food(new FoodProperties.Builder().nutrition(0).build()),204.40,"RbMnO4",0,4,"\nDesc: Used to detect the presence of perchlorate ions.","", 1));

    //TODO: FINISH THE SALTS. DONE
    //TODO: MARKER FOR END OF SALTS
    //Oxides:
    public static final RegistryObject<Item> SILICON_DIOXIDE = Items.register( "silicon_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),60.08,"SiO2",0,4,"\nDesc: This is a major constituent of many minerals found on earth.","", 1));
    public static final RegistryObject<Item> NITROGEN_DIOXIDE = Items.register( "nitrogen_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),46.01,"NO2",0,4,"\nDesc: This often an intermediate in the production of nitric acid.","O,H,T,C,G", 1));
    public static final RegistryObject<Item> SULFUR_DIOXIDE = Items.register( "sulfur_dioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),64.07,"SO2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> SULFUR_TRIOXIDE = Items.register( "sulfur_trioxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),80.07,"SO3",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> HYDROGEN_PEROXIDE = Items.register( "hydrogen_peroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),34.01,"H2O2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> NITRIC_OXIDE = Items.register( "nitric_oxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),30.01,"NO",0,4,"\nDesc: ","", 1));

    //Oxides^^^^^
    public static final RegistryObject<Item> POLYVINYL_CHLORIDE = Items.register( "polyvinyl_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),62.50,"(C2H3Cl)n",0,4,"\nDesc: Also known as PVC, this is the 3rd most widely produced synthetic polymer of plastic.","", 1));
    public static final RegistryObject<Item> CHLOROETHENE = Items.register( "chloroethene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),62.50,"C2H3Cl",0,4,"\nDesc: Also known as vinyl chloride, it is used to produce PVC.","F,H", 1));
    public static final RegistryObject<Item> BEESWAX = Items.register( "beeswax",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),677.20,"C46H92O2",0,4,"\nDesc: A natural wax produced by bees. It is the main structural component to honeycombs and hives in general.","", 1));
    //Main beeswax constituents vvv
    public static final RegistryObject<Item> TRIACONTANYL_PALMITATE = Items.register( "triacontanyl_palmitate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),677.20,"C46H92O2",0,4,"\nDesc: A wax ester that is the main constituent to beeswax.","", 1));
    public static final RegistryObject<Item> TRIACONTANOL = Items.register( "triacontanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),438.81,"C30H62O",0,4,"\nDesc: This acts as a growth stimulant for many plants.","Sg", 1));
    public static final RegistryObject<Item> PALMITIC_ACID = Items.register( "palmitic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),256.43,"C16H32O2",0,4,"\nDesc: Used to make soaps, napalm, and has been used as a food additive.","I", 1));
    public static final RegistryObject<Item> CEROTIC_ACID = Items.register( "cerotic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),396.70,"C26H52O2",0,4,"\nDesc: A saturated fatty acid found in beeswax.","I", 1));
    //^^^
    public static final RegistryObject<Item> HYDROXYAPATITE = Items.register( "hydroxyapatite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),502.31,"Ca5(PO4)3OH",0,4,"\nDesc: Constitutes 50% by volume and 70% by weight of human bone. This has potential dental use.","", 1));
    public static final RegistryObject<Item> COLLAGEN_TYPE_1 = Items.register( "collagen_type_1",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),000,"Unknown",0,4,"\nDesc: The most abundant protein in humans. It is very large and complex.","", 1));
    public static final RegistryObject<Item> PROLINE = Items.register( "proline",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),115.13,"C5H9NO2",0,4,"\nDesc: An amino acid used to produce proteins.","", 1));
    //Spider Silk vvvv
    public static final RegistryObject<Item> GLYCINE = Items.register( "glycine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),75.07,"C2H5NO2",0,4,"\nDesc: An amino acid used to produce proteins.","", 1));
    public static final RegistryObject<Item> ALANINE = Items.register( "alanine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),89.09,"C3H7NO2",0,4,"\nDesc: An amino acid used to produce proteins.","", 1));
    //^^^^
    public static final RegistryObject<Item> EUMELANIN = Items.register( "eumelanin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),000,"Unknown",0,4,"\nDesc: The most common type of melanin, a group of natural pigments.","", 1));
    public static final RegistryObject<Item> DHI = Items.register( "dhi",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),149.15,"C8H7NO2",0,4,"\nDesc: An intermediate in the production of eumelanin.","C,I,A", 1));
    public static final RegistryObject<Item> DHICA = Items.register( "dhica",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),193.16,"C9H7NO4",0,4,"\nDesc: An intermediate in the biosynthesis of eumelanin","", 1));

    //Concrete vvv
    public static final RegistryObject<Item> ALITE = Items.register( "alite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),228.32,"Ca3SiO5",0,4,"\nDesc: Used in cement, alite is the impure mineral of tricalcium silicate.","", 1));
    public static final RegistryObject<Item> BELITE = Items.register( "belite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),172.24,"Ca2SiO4",0,4,"\nDesc: Used in cement, belite is known in nature as larnite.","I", 1));
    public static final RegistryObject<Item> TRICALCIUM_SILICATE = Items.register( "tricalcium_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),228.32,"Ca3SiO5",0,1,"\nDesc: The main constituent of alite, but unstable as its pure form.","C,I", 1));
    public static final RegistryObject<Item> DICALCIUM_SILICATE = Items.register( "dicalcium_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),172.24,"Ca2SiO4",0,4,"\nDesc: Occurs naturally as the mineral larnite.","I", 1));

    //^^^
    public static final RegistryObject<Item> CELLULOSE = Items.register( "cellulose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),162.14,"(C6H10O5)n",0,4,"\nDesc: The structural component of plant cell walls, it is the most abundant organic polymer.","", 1));
    //Standin for keratin  vvvv
    public static final RegistryObject<Item> CYSTEINE = Items.register( "cysteine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),121.15,"C3H7NO2S",0,4,"\nDesc: An amino acid used to produce proteins.","", 1));
    public static final RegistryObject<Item> BERYLLIUM_ALUMINUM_SILICATE = Items.register( "beryllium_aluminum_silicate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),537.50,"Be3Al2Si6O18",0,4,"\nDesc: The mineral form of this compound is known as beryl. Certain gemstones are the impure forms of beryl.","", 1));
    public static final RegistryObject<Item> SILICATE_TETRAHEDRON = Items.register( "silicate_tetrahedron",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,4,"\nDesc:","", 1));
    public static final RegistryObject<Item> NITROGLYCERIN = Items.register( "nitroglycerin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),227.09,"C3H5N3O9",0,4,"\nDesc: An explosive liquid used to make explosives, such as dynamite.","F,T,H,E", 1));
    //Fish output vvv
    public static final RegistryObject<Item> FISH_OIL = Items.register( "fish_oil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),000,"Unknown",0,4,"\nDesc: Derived from the tissue of oily fish, it is a good source of omega-3 fatty acids.","", 1));
    public static final RegistryObject<Item> EICOSAPENTAENOIC_ACID = Items.register( "eicosapentaenoic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),302.45,"C20H30O2",0,4,"\nDesc: An omega-3 fatty acid that has seen wide medicinal use.","C", 1));
    public static final RegistryObject<Item> DOCOSAHEXAENOIC_ACID = Items.register( "docosahexaenoic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),328.49,"C22H32O2",0,4,"\nDesc: An omega-3 fatty acid with various health benefits.","", 1));
    // ^^^^
    //Frog Secretions vvv
    //Dermorphin is stronger than morphine. Drug tag needed
    public static final RegistryObject<Item> DERMORPHIN = Items.register( "dermorphin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),802.89,"C40H50N8O10",0,4,"\nDesc: A natural opioid secreted by certain frogs.","SM", 1));
    public static final RegistryObject<Item> DELTORPHIN = Items.register( "deltorphin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),955.15,"C44H62N10S10S2",0,4,"\nDesc: A natural opioid secreted by certain frogs.","SM", 1));
    //^^^
    //Mushrooms vvv
    public static final RegistryObject<Item> CHITIN = Items.register( "chitin",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),203.19,"(C8H13O5N)n",0,4,"\nDesc: The primary component to the cell walls of fungi.","", 1));
    public static final RegistryObject<Item> N_ACETYLGLUCOSAMINE = Items.register( "n_acetylglucosamine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),221.21,"C8H15NO6",0,4,"\nDesc: A component of various cell wall types, seen in bacteria and fungi.","", 1));
    public static final RegistryObject<Item> GLYCOGEN = Items.register( "glycogen",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.16,"(C6H12O6)n",0,4,"\nDesc: A polysaccharide composed of glucose. The primary storage of glucose, also known as animal starch.","", 1));
    //^^^
    public static final RegistryObject<Item> LAZURITE = Items.register( "lazurite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),000,"(Na,Ca)8[(S,Cl,SO4,OH)2|(Al6Si6O24)]",0,4,"\nDesc: The primary constituent of lapis lazuli","", 1));
     //Red Quartz (Red Stone) 2nd vvv
    public static final RegistryObject<Item> HEMATITE = Items.register( "hematite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.69,"Fe2O3",0,4,"\nDesc: The mineral form of iron III oxide, found widely in rocks and soils.","", 1));
    //Slime vvv
    public static final RegistryObject<Item> POLYVINYL_ALCOHOL = Items.register( "polyvinyl_alcohol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),44.06,"(C2H4O)n",0,4,"\nDesc: Also known as PVOH. This polymer has a wide range of uses.","", 1));
    public static final RegistryObject<Item> ETHENOL = Items.register( "ethenol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),44.06,"C2H4O",0,1,"\nDesc: Also known as vinyl alcohol. Despite being the monomer of PVOH, it is too unstable and is not its precursor.","SA", 1));

    public static final RegistryObject<Item> SODIUM_TETRABORATE = Items.register( "sodium_tetraborate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),201.16,"Na2B4O7",0,4,"\nDesc: Also known as borax. It has many uses such as in glass making, as a pesticide, in skins tanning, etc...","H", 1));
    //^^^
    //Alcohols
    public static final RegistryObject<Item> PROPANOL = Items.register( "propanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),60.10,"C3H8O",0,4,"\nDesc: Produced naturally during fermentation. It is used as a solvent in pharmaceuticals.","F,H,SA", 1));
    public static final RegistryObject<Item> METHANOL = Items.register( "methanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),32.04,"MeOH",0,4,"\nDesc: ","SA", 1));
    public static final RegistryObject<Item> ETHANOL = Items.register( "ethanol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),46.07,"EtOH",0,4,"\nDesc: ","SA", 1));

    public static final RegistryObject<Item> POLYETHYLENE_TEREPHTHALATE = Items.register( "polyethylene_terephthalate",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),192.18,"(C10H8O4)n",0,4,"\nDesc: Also known as polyester PET. A polyester polymer with a wide range of manufacturing uses.","", 1));
    public static final RegistryObject<Item> TEREPHTHALIC_ACID = Items.register( "terephthalic_acid",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),166.13,"C8H6O4",0,4,"\nDesc: A commodity chemical and a precursor to polyester PET.","I", 1));
    public static final RegistryObject<Item> ETHYLENE_GLYCOL = Items.register( "ethylene_glycol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),62.07,"C2H6O2",0,4,"\nDesc: Raw material of polyester fibers and is used in antifreeze formulations.","I,H", 1));

    //minerals
    public static final RegistryObject<Item> KAOLINITE = Items.register( "kaolinite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),258.18,"Al2Si2O5(OH)4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> OLIVINE = Items.register( "olivine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),000.00,"(Mg,Fe)2SiO4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> PYRITE = Items.register( "pyrite",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),119.98,"FeS2",0,4,"\nDesc: Also known as Fool's Gold.","", 1));

    //Sugars:
    public static final RegistryObject<Item> SUCROSE = Items.register( "sucrose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),342.30,"C12H22O11",0,4,"\nDesc: Also known as table sugar, it is produced naturally in plants.","SSp1", 1));
    public static final RegistryObject<Item> GLUCOSE = Items.register( "glucose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.16,"C6H12O6",0,4,"\nDesc: The most important source of energy in all organisms.","SSp1", 1));
    public static final RegistryObject<Item> FRUCTOSE = Items.register( "fructose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.16,"C6H12O6",0,4,"\nDesc: Also known as fruit sugar. It is an important sweetener added to most foods. It is 1.7 times sweeter than sucrose.","SSp2", 1));
    public static final RegistryObject<Item> LACTOSE = Items.register( "lactose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),342.30,"C12H22O11",0,4,"\nDesc: Also known as milk sugar. It is added to baby formula.","SSp1", 1));
    public static final RegistryObject<Item> GALACTOSE = Items.register( "galactose",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.16,"C6H12O6",0,4,"\nDesc: Also known as brain sugar. It is as sweet as glucose.","SSp1", 1));

    //Sugars^^^^^
    //candle Wax vvv and other alkanes
    public static final RegistryObject<Item> DOCOSANE = Items.register( "docosane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),310.60,"C22H46",0,4,"\nDesc: This has some use in organic chemistry, and is used in temperature sensing devices.","I", 1));
    public static final RegistryObject<Item> OCTADECANE = Items.register( "octadecane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),254.50,"C18H38",0,4,"\nDesc: This is used in organic chemistry.","H", 1));
    //^^^
    public static final RegistryObject<Item> METHANE = Items.register( "methane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),16.04,"CH4",0,4,"\nDesc: The simplest alkane. It is the main constituent of natural gas and greenhouse gases.","F", 1));
    public static final RegistryObject<Item> ETHANE = Items.register( "ethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),30.07,"C2H6",0,4,"\nDesc: This is often isolated from natural gas. It is used to make feedstock and ethylene.","F", 1));
    public static final RegistryObject<Item> PROPANE = Items.register( "propane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),44.10,"C3H8",0,4,"\nDesc: A byproduct of natural gas and petroleum refining. This is a popular fuel for bbq, stoves, etc...","F,G", 1));
    public static final RegistryObject<Item> BUTANE = Items.register( "butane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),58.12,"C4H10",0,4,"\nDesc: Used in gasoline blending and ethylene production. Isobutane is used as a refrigerant.","F,G", 1));
    public static final RegistryObject<Item> PENTANE = Items.register( "pentane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),72.15,"C5H12",0,4,"\nDesc: Similar to butane and hexane. Used commonly as a fuel. It can act as a solvent for laboratories.","F,I,H,A", 1));
    public static final RegistryObject<Item> HEXANE = Items.register( "hexane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),86.18,"C6H14",0,4,"\nDesc: Hexane can be used to make glue for shoes. It is also used to extract cooking oil from seeds, and can be used for cleaning and degreasing.","F,I,H,A", 1));


    //Acids and Bases
    public static final RegistryObject<Item> CARBONIC_ACID_DIL = Items.register( "carbonic_acid_dil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),62.03,"H2CO3",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> HYDROCHLORIC_ACID_DIL = Items.register( "hydrochloric_acid_dil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),36.46,"HCl",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> SULFURIC_ACID_DIL = Items.register( "sulfuric_acid_dil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),98.08,"H2SO4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> SULFURIC_ACID_CONC = Items.register( "sulfuric_acid_conc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),98.08,"H2SO4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> NITRIC_ACID_DIL = Items.register( "nitric_acid_dil",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),63.01,"HNO3",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> VINEGAR = Items.register( "vinegar",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),60.05,"CH3COOH",0,4,"\nDesc: ","", 1));

    //
    public static final RegistryObject<Item> COPPER_II_CARBONATE_HYDROXIDE = Items.register( "copper_ii_carbonate_hydroxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),221.11,"Cu2CO3(OH)2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> HYDROGEN_SULFIDE = Items.register( "hydrogen_sulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),34.08,"H2S",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> SODIUM_HYDROSULFIDE = Items.register( "sodium_hydrosulfide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.06,"NaSH",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> EDT = Items.register( "edt",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),94.19,"C2H6S2",0,4,"\nDesc: Its IUPAC name is Ethane-1,2-dithiol.","", 1));

    public static final RegistryObject<Item> _1_2_DICHLOROETHANE = Items.register( "1_2_dichloroethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),98.95,"C2H4Cl2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> BROMINE_WATER = Items.register( "bromine_water",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),159.80,"Br2",0,4,"\nDesc: ","", 1));

    //Drugs
    public static final RegistryObject<Item> THEOBROMINE = Items.register( "theobromine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),180.17,"C7H8N4O2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> CAFFEINE = Items.register( "caffeine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),194.19,"C8H10N4O2",0,4,"\nDesc: ","SSp3", 1));

    //Fluorides
    public static final RegistryObject<Item> NITROGEN_TRIFLUORIDE = Items.register( "nitrogen_trifluoride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),71.00,"NF3",0,4,"\nDesc: ","", 1));

    //Amides

    //TODO: ADD TRINITROTOLUENE

    //Organic Molecules (Non-pure alkanes)
    //Brominated Alkanes
    public static final RegistryObject<Item> BROMOMETHANE = Items.register( "bromomethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),94.94,"CH3Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> BROMOETHANE = Items.register( "bromoethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),108.97,"C2H5Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMOPROPANE = Items.register( "1_bromopropane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.99,"C3H7Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMOPROPANE = Items.register( "2_bromopropane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),122.99,"C3H7Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMOBUTANE = Items.register( "1_bromobutane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),137.02,"C4H9Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMOBUTANE = Items.register( "2_bromobutane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),137.02,"C4H9Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMOPENTANE = Items.register( "1_bromopentane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.05,"C5H11Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMOPENTANE = Items.register( "2_bromopentane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),151.05,"C5H11Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMOHEXANE = Items.register( "1_bromohexane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),165.07,"C6H13Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMOHEXANE = Items.register( "2_bromohexane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),165.07,"C6H13Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMODOCOSANE = Items.register( "1_bromodocosane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),390.54,"C22H45Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMODOCOSANE = Items.register( "2_bromodocosane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),390.54,"C22H45Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BROMOOCTADECANE = Items.register( "1_bromooctadecane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),334.43,"C18H38Br",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BROMOOCTADECANE = Items.register( "2_bromooctadecane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),334.43,"C18H38Br",0,4,"\nDesc: ","", 1));

    //Alkenes
    //TODO: ADD BASIC STUFF FOR THESE (LANG, MODEL, DECON)
    public static final RegistryObject<Item> ETHENE = Items.register( "ethene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),28.05,"C2H4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> PROPENE = Items.register( "propene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),42.08,"C3H6",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _1_BUTENE = Items.register( "1_butene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.11,"C4H8",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> _2_BUTENE = Items.register( "2_butene",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),56.11,"C4H8",0,4,"\nDesc: ","", 1));


    //OChem reagents
    public static final RegistryObject<Item> POTASSIUM_TERT_BUTOXIDE = Items.register( "potassium_tert_butoxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),112.21,"t-BuOK",0,4,"\nDesc: Performs E2 elimination in tert-Butyl Alcohol","", 1));
    public static final RegistryObject<Item> TERT_BUTYL_ALCOHOL = Items.register( "tert_butyl_alcohol",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.12,"t-BuOH",0,4,"\nDesc: A common solvent for Potassium tert-Butoxide","", 1));
    public static final RegistryObject<Item> SODIUM_ETHOXIDE = Items.register( "sodium_ethoxide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),68.05,"NaOEt",0,4,"\nDesc: Performs E1 elimination in Ethanol","", 1));
    //TODO: Ethanol is higher up in the alcohols section
    public static final RegistryObject<Item> HYDROGEN_BROMIDE = Items.register( "hydrogen_bromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),80.91,"HBr",0,4,"\nDesc: ","", 1));
    //TODO: ROOR will be any peroxide salt, which will suck. So I'll start with only using H2O2 and maybe Na,K,Li all of which are up there already
    //TODO: Acid Catalyzed Hydration will use dil. sulfuric acid
    //TODO: All H3O+ will be with dil. sulfuric acid to start...
    //TODO: Mercuric Acetate (Hg(OAc)2) is higher up in the Mercury ii salts
    //TODO: Water is already up there duh
    public static final RegistryObject<Item> SODIUM_BOROHYDRIDE = Items.register( "sodium_borohydride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),37.83,"NaBH4",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> BORANE_TETRAHYDROFURAN = Items.register( "borane_tetrahydrofuran",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),85.94,"BH3*THF",0,4,"\nDesc: ","", 1));
    //TODO: NaOH is already up there
    //TODO: H2 is already up there, as well as Pt, Pd, and Ni, duh
    //TODO: Br2 is already up there
    public static final RegistryObject<Item> OZONE = Items.register( "ozone",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),48.00,"03",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> DMS = Items.register( "dms",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),126.13,"C2H6O4S",0,4,"\nDesc: Its IUPAC name is Dimethyl Sulfate.","", 1));
    public static final RegistryObject<Item> SODIUM_AMIDE = Items.register( "sodium_amide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),39.01,"NaNH2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> LINDLARS_CATALYST = Items.register( "lindlars_catalyst",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"PdCaCO3",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> SODIUM_HYDRIDE = Items.register( "sodium_hydride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),24.00,"NaH",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> LITHIUM_ALUMINUM_HYDRIDE = Items.register( "lithium_aluminum_hydride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),37.95,"LiAlH4",0,4,"\nDesc: ","", 1));
    //TODO: Mg is already up there, duh
    //TODO: Diethyl Ether will be used as Ether for Grignard
    public static final RegistryObject<Item> DIETHYL_ETHER = Items.register( "diethyl_ether",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),74.12,"C4H10O",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> PHOSPHORUS_TRIBROMIDE = Items.register( "phosphorus_tribromide",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),270.69,"PBr3",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> THIONYL_CHLORIDE = Items.register( "thionyl_chloride",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),118.97,"SOCl2",0,4,"\nDesc: ","", 1));
    public static final RegistryObject<Item> PYRIDINE = Items.register( "pyridine",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),79.10,"C5H5N",0,4,"\nDesc: ","", 1));
    //TODO: Sodium Dichromate is one of the salts, so already up there
    public static final RegistryObject<Item> PCC = Items.register( "pcc",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),215.56,"C5H6ClCrNO3",0,4,"\nDesc: Its IUPAC name is Pyridinium chlorochromate.","", 1));
    public static final RegistryObject<Item> DICHLOROMETHANE = Items.register( "dichloromethane",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),84.93,"CH2Cl2",0,4,"\nDesc: ","", 1));
    //TODO: THIS CONCLUDES THE REAGENTS FOR OCHEM 1






    public static final RegistryObject<Item> EMPTY = Items.register( "empty",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,0,"\nDess: Placeholder item. If you are reading this (not in creative), let me know. Something must be wrong.","", 1));
    public static final RegistryObject<Item> ONE_LITRE = Items.register( "one_litre",
            () -> new ChemicalItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()),0,"",0,0,"\nDesc: Placeholder item. If you are reading this (not in creative), let me know. Something must be wrong.","", 1));



    /*
    public static final RegistryObject<Item> BEAKER = Items.register( "beaker",
            () -> new SolutionItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).food(new FoodProperties.Builder().nutrition(0).build()), 0.00, (ChemicalItem) EMPTY.get(),
                    0.0, (ChemicalItem) EMPTY.get(), 0.0, (ChemicalItem) EMPTY.get(), 0.0, (ChemicalItem) EMPTY.get(), 0.0, (ChemicalItem) EMPTY.get(), 0.0, (ChemicalItem) EMPTY.get(), 0.0, 4, "\nDesc: A solution of ",""));


     */
    public static final RegistryObject<Item> BEAKER = Items.register( "beaker",
            () -> new SolutionItem(new Item.Properties().tab(ModCreativeModeTab.CHEM_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }

    public static final void registerCHEM()
    {
        for (int x = 0; x< Items.getEntries().size(); x++)
        {
            List<RegistryObject<Item>> list = Items.getEntries().stream().toList();
            if(list.get(x).get().asItem().getClass().equals(ChemicalItem.class))
            {
                ChemicalItem chem = (ChemicalItem) list.get(x).get().asItem();
                registerChem(chem.getName(), list.get(x));
            }

        }

    }





}
