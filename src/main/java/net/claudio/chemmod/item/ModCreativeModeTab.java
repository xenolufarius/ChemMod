package net.claudio.chemmod.item;

import net.claudio.chemmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHEM_TAB = new CreativeModeTab("chemtab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.HELIUM.get());
        }
    };
    public static final CreativeModeTab SALT_TAB = new CreativeModeTab("salttab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FLUORINE.get());
        }
    };
    public static final CreativeModeTab BLOCKS_TAB = new CreativeModeTab("blockstab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(ModBlocks.BERYLLIUM_BLOCK.get());
        }
    };


}
