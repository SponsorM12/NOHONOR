package zver.nohonor.recipe.custom.arc_crucible;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ArcCrucibleInput(ItemStack input) implements RecipeInput {

    @Override
    public ItemStack getItem(int index) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }

}