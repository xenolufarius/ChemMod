package net.claudio.chemmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHEM_TAB = new CreativeModeTab("chemtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CHEMICAL.get());
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
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ARSENIC.get());
        }
    };


}
