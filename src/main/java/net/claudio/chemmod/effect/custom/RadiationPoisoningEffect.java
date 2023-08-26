package net.claudio.chemmod.effect.custom;

import net.claudio.chemmod.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class RadiationPoisoningEffect extends MobEffect {


    public int Severity;
    public RadiationPoisoningEffect(MobEffectCategory mobEffectCategory, int aSuper) {
        super(mobEffectCategory, aSuper);
    }

    @Override
    public void applyEffectTick(LivingEntity Entity, int severity)
    {
        double doubleValue = 1.0 * severity;
        float floatValue = (float) doubleValue;
        if (false)
        {
            Entity.hurt(DamageSource.WITHER, floatValue);
        }
    }


}
