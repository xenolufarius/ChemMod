package net.claudio.chemmod.block;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.custom.DeconstructorBlock;
import net.claudio.chemmod.block.custom.JumpyBlock;
import net.claudio.chemmod.block.custom.LavaLampBlock;
import net.claudio.chemmod.block.custom.ReconstructorBlock;
import net.claudio.chemmod.item.ModCreativeModeTab;
import net.claudio.chemmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChemMod.MOD_ID);

    public static final RegistryObject<Block> LAB_BLOCK = registerBlock("lab_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);



    public static final RegistryObject<Block> JUMPY_BlOCK = registerBlock("jumpy_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);



    public static final RegistryObject<Block> LAVA_LAMP = registerBlock("lava_lamp",
            () -> new LavaLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(LavaLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.BLOCKS_TAB);

    public static final RegistryObject<Block> LAB2_BLOCK = registerBlock("lab2_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);

    public static final RegistryObject<Block> DECONSTRUCTOR_BLOCK = registerBlock("deconstructor_block",
            () -> new DeconstructorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RECONSTRUCTOR_BLOCK = registerBlock("reconstructor_block",
            () -> new ReconstructorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BLOCKS_TAB);

    //Village Job Blocks
    public static final RegistryObject<Block> ALCHEMY_TABLE = registerBlock("alchemy_table",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)), ModCreativeModeTab.BLOCKS_TAB);






    //elemental blocks
    public static final RegistryObject<Block> LITHIUM_BLOCK = registerBlock("lithium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BERYLLIUM_BLOCK = registerBlock("beryllium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> FLUORINE_BLOCK = registerBlock("fluorine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SODIUM_BLOCK = registerBlock("sodium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PHOSPHORUS_BLOCK = registerBlock("phosphorus_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CHLORINE_BLOCK = registerBlock("chlorine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> POTASSIUM_BLOCK = registerBlock("potassium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CALCIUM_BLOCK = registerBlock("calcium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SCANDIUM_BLOCK = registerBlock("scandium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> VANADIUM_BLOCK = registerBlock("vanadium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CHROMIUM_BLOCK = registerBlock("chromium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("manganese_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> GALLIUM_BLOCK = registerBlock("gallium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> GERMANIUM_BLOCK = registerBlock("germanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SELENIUM_BLOCK = registerBlock("selenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RUBIDIUM_BLOCK = registerBlock("rubidium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> STRONTIUM_BLOCK = registerBlock("strontium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> YTTRIUM_BLOCK = registerBlock("yttrium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = registerBlock("zirconium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> NIOBIUM_BLOCK = registerBlock("niobium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TECHNETIUM_BLOCK = registerBlock("technetium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RUTHENIUM_BLOCK = registerBlock("ruthenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RHODIUM_BLOCK = registerBlock("rhodium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PALLADIUM_BLOCK = registerBlock("palladium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CADMIUM_BLOCK = registerBlock("cadmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> INDIUM_BLOCK = registerBlock("indium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBlock("antimony_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TELLURIUM_BLOCK = registerBlock("tellurium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> IODINE_BLOCK = registerBlock("iodine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CAESIUM_BLOCK = registerBlock("caesium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BARIUM_BLOCK = registerBlock("barium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> LANTHANUM_BLOCK = registerBlock("lanthanum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CERIUM_BLOCK = registerBlock("cerium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PRASEODYMIUM_BLOCK = registerBlock("praseodymium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = registerBlock("neodymium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PROMETHIUM_BLOCK = registerBlock("promethium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SAMARIUM_BLOCK = registerBlock("samarium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> EUROPIUM_BLOCK = registerBlock("europium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> GADOLINIUM_BLOCK = registerBlock("gadolinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TERBIUM_BLOCK = registerBlock("terbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> DYSPROSIUM_BLOCK = registerBlock("dysprosium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> HOLMIUM_BLOCK = registerBlock("holmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ERBIUM_BLOCK = registerBlock("erbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> THULIUM_BLOCK = registerBlock("thulium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> YTTERBIUM_BLOCK = registerBlock("ytterbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> LUTETIUM_BLOCK = registerBlock("lutetium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> HAFNIUM_BLOCK = registerBlock("hafnium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TANTALUM_BLOCK = registerBlock("tantalum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RHENIUM_BLOCK = registerBlock("rhenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> THALLIUM_BLOCK = registerBlock("thallium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> POLONIUM_BLOCK = registerBlock("polonium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ASTATINE_BLOCK = registerBlock("astatine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> FRANCIUM_BLOCK = registerBlock("francium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RADIUM_BLOCK = registerBlock("radium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ACTINIUM_BLOCK = registerBlock("actinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> THORIUM_BLOCK = registerBlock("thorium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PROTACTINIUM_BLOCK = registerBlock("protactinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> NEPTUNIUM_BLOCK = registerBlock("neptunium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> PLUTONIUM_BLOCK = registerBlock("plutonium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> AMERICIUM_BLOCK = registerBlock("americium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CURIUM_BLOCK = registerBlock("curium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BERKELIUM_BLOCK = registerBlock("berkelium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> CALIFORNIUM_BLOCK = registerBlock("californium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> EINSTEINIUM_BLOCK = registerBlock("einsteinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> FERMIUM_BLOCK = registerBlock("fermium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> MENDELEVIUM_BLOCK = registerBlock("mendelevium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> NOBELIUM_BLOCK = registerBlock("nobelium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> LAWRENCIUM_BLOCK = registerBlock("lawrencium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> RUTHERFORDIUM_BLOCK = registerBlock("rutherfordium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> DUBNIUM_BLOCK = registerBlock("dubnium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> SEABORGIUM_BLOCK = registerBlock("seaborgium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> BOHRIUM_BLOCK = registerBlock("bohrium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> HASSIUM_BLOCK = registerBlock("hassium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> MEITNERIUM_BLOCK = registerBlock("meitnerium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> DARMSTADTIUM_BLOCK = registerBlock("darmstadtium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> ROENTGENIUM_BLOCK = registerBlock("roentgenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);
    public static final RegistryObject<Block> COPERNICIUM_BLOCK = registerBlock("copernicium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS_TAB);










    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn, tab);
            return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
