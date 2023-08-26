package net.claudio.chemmod.painting;

import net.claudio.chemmod.ChemMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, ChemMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> PLANT = PAINTING_VARIANTS.register("plant",
            () -> new PaintingVariant(16, 16));


    public static void register(IEventBus eventBus)
    {
        PAINTING_VARIANTS.register(eventBus);
    }
}
