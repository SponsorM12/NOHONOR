package zver.nohonor.init;

import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import zver.nohonor.item.ModItems;
import zver.nohonor.potion.ModPotions;

public class ModPotionRecipes {

    public static void initialize() {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            //=================================================ВИТХЕР ВИЗЕР=====================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.BLACK_BONE), ModPotions.WITHERING_POTION);
            builder.registerPotionRecipe(ModPotions.WITHERING_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_WITHERING_POTION);
            builder.registerPotionRecipe(ModPotions.WITHERING_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_WITHERING_POTION);

            //===============================================ШАТТЕР РАСКОЛ===========================================================
                                        //Из какого зелья?----------------------Предмет для варки-------------Результат
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.DISENTGILIL), ModPotions.SHATTER_POTION);
            builder.registerPotionRecipe(ModPotions.SHATTER_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_SHATTER_POTION);
            builder.registerPotionRecipe(ModPotions.SHATTER_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_SHATTER_POTION);
            //====================================================ОЖОГ==========================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.CHARRED_STONE), ModPotions.SCORCH_POTION);
            builder.registerPotionRecipe(ModPotions.SCORCH_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_SCORCH_POTION);
            builder.registerPotionRecipe(ModPotions.SCORCH_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_SCORCH_POTION);

        });
    }

}
