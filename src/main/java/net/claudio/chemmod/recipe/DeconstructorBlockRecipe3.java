package net.claudio.chemmod.recipe;
/*
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.claudio.chemmod.ChemMod;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class DeconstructorBlockRecipe3 implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public DeconstructorBlockRecipe3(ResourceLocation id, ItemStack output,
                                     NonNullList<Ingredient> recipeItems)
    {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }


    //Brain of the recipe
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide())
        {
            return false;
        }



        //gets first item in recipe list
        return recipeItems.get(0).test(pContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<DeconstructorBlockRecipe3>
    {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "deconstructor";
    }

    public static class Serializer implements RecipeSerializer<DeconstructorBlockRecipe3>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(ChemMod.MOD_ID, "deconstructor");


        //might be where I get the multiple outputs
        @Override
        public DeconstructorBlockRecipe3 fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new DeconstructorBlockRecipe3(pRecipeId, output, inputs);
        }

        @Override
        public @Nullable DeconstructorBlockRecipe3 fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new DeconstructorBlockRecipe3(id, output, inputs);
        }
        //Episode 23 ~10 min in
        @Override
        public void toNetwork(FriendlyByteBuf buf, DeconstructorBlockRecipe3 recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }


    }


}

 */
