package net.claudio.chemmod.recipe;

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

public class LabTableBlockRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final NonNullList<ItemStack> output;
    private final NonNullList<Ingredient> recipeItems;

    public LabTableBlockRecipe(ResourceLocation id, NonNullList<ItemStack> output,
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
        //Comment for slot 0
        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.get(0).copy();
    }
    public NonNullList<ItemStack> getOutput() { return output;}

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

    public static class Type implements RecipeType<LabTableBlockRecipe>
    {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "lab_table";
    }

    public static class Serializer implements RecipeSerializer<LabTableBlockRecipe>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(ChemMod.MOD_ID, "lab_table");


        //might be where I get the multiple outputs
        @Override
        public LabTableBlockRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            // Deserialize the outputs from JSON
            NonNullList<ItemStack> outputs = NonNullList.create();
            JsonArray outputsArray = GsonHelper.getAsJsonArray(pSerializedRecipe, "output");

            for (int i = 0; i < outputsArray.size(); i++) {
                outputs.add(ShapedRecipe.itemStackFromJson(outputsArray.get(i).getAsJsonObject()));
            }

            // Deserialize the inputs from JSON
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new LabTableBlockRecipe(pRecipeId, outputs, inputs);

        }

        @Override
        public @Nullable LabTableBlockRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            NonNullList<ItemStack> outputs = NonNullList.create();
            int numOutputs = buf.readInt();

            for (int i = 0; i < numOutputs; i++) {
                outputs.add(buf.readItem());
            }

            return new LabTableBlockRecipe(id, outputs, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, LabTableBlockRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeInt(recipe.getOutput().size());

            for (ItemStack output : recipe.getOutput()) {
                buf.writeItem(output);
            }
        }


    }



}