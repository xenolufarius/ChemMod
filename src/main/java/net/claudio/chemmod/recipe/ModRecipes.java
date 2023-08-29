package net.claudio.chemmod.recipe;

import net.claudio.chemmod.ChemMod;
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


    public static void register(IEventBus eventBus)
    {
        SERIALIZERS.register(eventBus);
    }


}
