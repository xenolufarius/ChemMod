package net.claudio.chemmod.block;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.custom.JumpyBlock;
import net.claudio.chemmod.block.custom.LavaLampBlock;
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
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.CHEM_TAB);

    public static final RegistryObject<Block> JUMPY_BlOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.CHEM_TAB);
 public static final RegistryObject<Block> LAVA_LAMP = registerBlock("lava_lamp",
            () -> new LavaLampBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(LavaLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.CHEM_TAB);

    public static final RegistryObject<Block> LAB2_BLOCK = registerBlock("lab2_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.CHEM_TAB);


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
