package zver.nohonor.recipe.custom.arc_crucible;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import zver.nohonor.recipe.ModRecipes;

public record ArcCrucibleRecipe(Ingredient inputItem, ItemStackTemplate output) implements Recipe<ArcCrucibleInput> {

    public static final MapCodec<ArcCrucibleRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(ArcCrucibleRecipe::inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(ArcCrucibleRecipe::output)
            ).apply(instance, ArcCrucibleRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ArcCrucibleRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    ArcCrucibleRecipe::inputItem,

                    ItemStackTemplate.STREAM_CODEC,
                    ArcCrucibleRecipe::output,

                    ArcCrucibleRecipe::new);

    @Override
    public boolean matches(ArcCrucibleInput input, Level level) {
        if(level.isClientSide()) {
            return false;
        }

        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(ArcCrucibleInput input) {
        return output.create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "Crystallizing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<ArcCrucibleInput>> getSerializer() {
        return ModRecipes.ARC_CRUCIBLE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<ArcCrucibleInput>> getType() {
        return ModRecipes.ARC_CRUCIBLE_TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
}
