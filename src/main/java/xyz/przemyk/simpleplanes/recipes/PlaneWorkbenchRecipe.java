package xyz.przemyk.simpleplanes.recipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import xyz.przemyk.simpleplanes.setup.SimplePlanesRecipes;

public record PlaneWorkbenchRecipe(ResourceLocation id,
                                   Ingredient ingredient, int ingredientAmount,
                                   int materialAmount,
                                   ItemStack result) implements Recipe<Container> {

    public boolean canCraft(ItemStack ingredientStack, ItemStack materialStack) {
        return ingredientStack.getCount() >= ingredientAmount && materialStack.getCount() >= materialAmount && ingredient.test(ingredientStack);
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SimplePlanesRecipes.PLANE_WORKBENCH_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return SimplePlanesRecipes.PLANE_WORKBENCH_RECIPE_TYPE;
    }

    @Override
    public boolean matches(Container p_77569_1_, Level p_77569_2_) {
        return false;
    }

    @Override
    public ItemStack assemble(Container p_77572_1_) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return false;
    }
}
