package net.claudio.chemmod.effect;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.effect.custom.RadiationPoisoningEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> Mob_Effects =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChemMod.MOD_ID);

    /*
    public static final RegistryObject<MobEffect> RADPOISONING = Mob_Effects.register(32, "radiation_poisoning",
            new RadiationPoisoningEffect(new MobEffect(MobEffectCategory.HARMFUL, 1)));
    */


    public static void register(IEventBus eventBus) {Mob_Effects.register(eventBus);
    }


}
