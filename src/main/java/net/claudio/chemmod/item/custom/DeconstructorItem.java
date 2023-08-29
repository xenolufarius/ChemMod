package net.claudio.chemmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class DeconstructorItem extends Item implements MenuProvider {


    private final ItemStackHandler itemHandler = new ItemStackHandler(3)
    {

    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public DeconstructorItem(Properties properties) {

        super(properties);
    }




    ////
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            //MenuProvider containerProvider = new DeconstructorScreenHandlerFactory();
            //player.openMenu(containerProvider);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown())
        {
            components.add(Component.literal("Right click to deconstruct an item!").withStyle(ChatFormatting.GREEN));
        }
        else
        {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.AQUA));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    private void popUpMenu(Player player)
    {
    }


    ////


    @Override
    public Component getDisplayName() {
        return Component.literal("Hand-held Deconstructor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }







}
