package net.claudio.chemmod.event;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class ItemRadiationDetector {

    private ItemProperties radiationPresent;

    public ItemRadiationDetector(ItemProperties radiation)
    {
        this.radiationPresent = radiation;
    }

    public boolean matches(ItemStack itemStack)
    {
        return itemStack.hasTag() && radiationPresent.equals(itemStack.getTag());
    }


}
