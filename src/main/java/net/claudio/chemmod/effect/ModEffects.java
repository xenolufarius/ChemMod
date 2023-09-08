package net.claudio.chemmod.effect;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.effect.custom.ChemicalEffect;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MobEffects =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChemMod.MOD_ID);

    public static final RegistryObject<MobEffect> CHEMICAL = MobEffects.register( "chemical",
            () -> new ChemicalEffect(MobEffectCategory.HARMFUL, 16773073));

    public static final MobEffect CHEMICAL3 = register(32, "chemical3", new ChemicalEffect(MobEffectCategory.HARMFUL, 2293580));

    private static MobEffect register(int pId, String pKey, MobEffect pEffect) {
        return Registry.registerMapping(Registry.MOB_EFFECT, pId, pKey, pEffect);
    }
    public static void register(IEventBus eventBus) {
        MobEffects.register(eventBus);
    }


}
