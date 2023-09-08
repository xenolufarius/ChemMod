package net.claudio.chemmod.effect.custom;

import net.claudio.chemmod.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ChemicalEffect extends MobEffect {
    public ChemicalEffect(MobEffectCategory pCategory, int pColor) {

        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == MobEffects.REGENERATION) {
            if (pLivingEntity.getHealth() < pLivingEntity.getMaxHealth()) {
                pLivingEntity.heal(1.0F);
            }
        } else if (this == MobEffects.POISON) {
            if (pLivingEntity.getHealth() > 1.0F) {
                pLivingEntity.hurt(DamageSource.MAGIC, 1.0F);
            }
        } else if (this == MobEffects.WITHER) {
            pLivingEntity.hurt(DamageSource.WITHER, 1.0F);
        } else if (this == MobEffects.HUNGER && pLivingEntity instanceof Player) {
            ((Player) pLivingEntity).causeFoodExhaustion(0.005F * (float) (pAmplifier + 1));
        } else if (this == MobEffects.SATURATION && pLivingEntity instanceof Player) {
            if (!pLivingEntity.level.isClientSide) {
                ((Player) pLivingEntity).getFoodData().eat(pAmplifier + 1, 1.0F);
            }
        } else if ((this != MobEffects.HEAL || pLivingEntity.isInvertedHealAndHarm()) && (this != MobEffects.HARM || !pLivingEntity.isInvertedHealAndHarm())) {
            if (this == MobEffects.HARM && !pLivingEntity.isInvertedHealAndHarm() || this == MobEffects.HEAL && pLivingEntity.isInvertedHealAndHarm()) {
                pLivingEntity.hurt(DamageSource.MAGIC, (float) (6 << pAmplifier));
            }
        } else {
                pLivingEntity.heal((float) Math.max(4 << pAmplifier, 0));
            }

        }
    }

