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


}
