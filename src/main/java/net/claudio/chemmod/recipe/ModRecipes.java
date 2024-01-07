package net.claudio.chemmod.recipe;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.custom.LabTableBlock;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChemMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<DeconstructorBlockRecipe>> DECONSTRUCTOR_SERIALIZER =
            SERIALIZERS.register("deconstructor", () -> DeconstructorBlockRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<RadicalizerBlockRecipe>> RADICALIZER_SERIALIZER =
            SERIALIZERS.register("radicalizer", () -> RadicalizerBlockRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<LabTableBlockRecipe>> LAB_TABLE_SERIALIZER =
            SERIALIZERS.register("lab_table", () -> LabTableBlockRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<ReconstructorBlockRecipe>> RECONSTRUCTOR_SERIALIZER =
            SERIALIZERS.register("reconstructor", () -> ReconstructorBlockRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus)
    {
        SERIALIZERS.register(eventBus);
    }


}
