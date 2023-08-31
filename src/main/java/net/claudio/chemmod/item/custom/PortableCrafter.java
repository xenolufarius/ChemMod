package net.claudio.chemmod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Properties;

public class PortableCrafter{// extends Item {//implements ISmartItemModel {
/*
    public static final String PC_NAME = "portable_crafter";

    public PortableCrafter(Properties properties) {
        super(properties);

//        setHasSubtypes(true);
    }


    /**
     * Should disable the item bobbing up and down when the NBT data is saved.
     * @param oldStack - the old instance of this item
     * @param newStack - the new one
     * @param slotChanged - the slot to check
     * @return - if it should do the animation
     */
//    @Override
//    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
//        return !oldStack.getItem().equals(newStack.getItem());
//    }
//
//    /**
//     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
//     */
//
//
//    /**
//     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
//     *
//     * @param world - the world of the event
//     * @param player - the player doing the clicking
//     */
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
//        ItemStack itemStack = player.getHeldItem(handIn);
//
//        if (!world.isRemote) {
//            NBTHelper.setUUID(itemStack);
//
//            player.openGui(PortableCrafting.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
//        }
//        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
//    }
//
//    /**
//     * Allows items to add custom lines of information to the mouseover description
//     */
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        TextFormatting hl = TextFormatting.WHITE;
//        TextFormatting rst = TextFormatting.GRAY;
//
//        tooltip.add(hl + GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode()) + rst + " key to balance stacks");
//        tooltip.add(hl + GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode()) + rst + " key to clear the grid");
//        tooltip.add(hl + GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode()) + rst + " and " + hl + GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode()) + rst + " keys to spin");
//
//    }
//
}
