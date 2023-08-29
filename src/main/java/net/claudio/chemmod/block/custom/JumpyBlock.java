package net.claudio.chemmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;


//If class is grey, it is not being used. Same if method is not yellow.
public class JumpyBlock  extends Block {
    public JumpyBlock(Properties properties) {
        super(properties);

    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {

        //Currently is called 4 times.
        //Maybe use if statements to check if level is for main/off hand
        //or if client/server side.


        player.sendSystemMessage(Component.literal("Right Clicked This!"));


        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity)
        {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200));

        }


        super.stepOn(level, pos, state, entity);
    }
}


