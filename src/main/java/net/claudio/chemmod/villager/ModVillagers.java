package net.claudio.chemmod.villager;

import com.google.common.collect.ImmutableSet;
import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.tools.obfuscation.ObfuscationData;

import javax.annotation.concurrent.Immutable;
import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ChemMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession>   VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ChemMod.MOD_ID);

    public static final RegistryObject<PoiType> JUMPY_BLOCK_POI = POI_TYPES.register("jumpy_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.JUMPY_BlOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CHEMIST = VILLAGER_PROFESSIONS.register("chemist",
            () -> new VillagerProfession("chemist", x -> x.get() == JUMPY_BLOCK_POI.get(),
                    x -> x.get() == JUMPY_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));

    public static void registerPOIs()
    {
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
            "registerBlockStates", PoiType.class).invoke(null, JUMPY_BLOCK_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
