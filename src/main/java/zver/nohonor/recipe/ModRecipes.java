package zver.nohonor.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import zver.nohonor.NOHONOR;
import zver.nohonor.recipe.custom.arc_crucible.ArcCrucibleRecipe;

public class ModRecipes {
    public static final RecipeSerializer<ArcCrucibleRecipe> ARC_CRUCIBLE_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "ark_crucible_process"),
            new RecipeSerializer<>(ArcCrucibleRecipe.CODEC, ArcCrucibleRecipe.STREAM_CODEC));

    public static final RecipeType<ArcCrucibleRecipe> ARC_CRUCIBLE_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "ark_crucible_process"),
            new RecipeType<ArcCrucibleRecipe>() {
                @Override
                public String toString() {
                    return "ark_crucible_process";
                }
            });

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering ModRecipes for " + NOHONOR.MOD_ID);
    }

}