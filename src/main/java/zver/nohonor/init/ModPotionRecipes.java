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

            //==================================================УДАЧА 5==================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.FIVELEAF_CLOVER), Potions.LUCK);
            builder.registerPotionRecipe(Potions.LUCK, Ingredient.of(Items.REDSTONE), ModPotions.LONG_LUCK_POTION);
            builder.registerPotionRecipe(Potions.LUCK, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_LUCK_POTION);
            builder.registerPotionRecipe(ModPotions.STRONG_LUCK_POTION, Ingredient.of(ModItems.GOLDEN_FIVELEAF_CLOVER), ModPotions.ABSURD_LUCK_POTION);

            //===================================================СЛЕПОТА======================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.ALCOHOL), ModPotions.BLINDNESS_POTION);
            builder.registerPotionRecipe(ModPotions.BLINDNESS_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_BLINDNESS_POTION);


            //=================================================ДАКРНЕС ТЬМА=====================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.ECHO_SHARD), ModPotions.DARKNESS_POTION);
            builder.registerPotionRecipe(ModPotions.DARKNESS_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_DARKNESS_POTION);

            //==================================================ДЕЛЬФИН=====================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.SEA_STONE), ModPotions.DOLPHINS_GRACE_POTION);
            builder.registerPotionRecipe(ModPotions.DOLPHINS_GRACE_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_DOLPHINS_GRACE_POTION);

            //============================================ХЕАЛТХ БУСТ ЗДОРОВЬЯ===================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.SHULKER_SHELL), ModPotions.LEVITATION_POTION);
            builder.registerPotionRecipe(ModPotions.LEVITATION_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_LEVITATION_POTION);
            builder.registerPotionRecipe(ModPotions.LEVITATION_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_LEVITATION_POTION);
            builder.registerPotionRecipe(ModPotions.STRONG_LEVITATION_POTION, Ingredient.of(ModItems.DISENTGILIL), ModPotions.ABSURD_LEVITATION_POTION);

            //==================================================ЛЕВИТАЦИЯ=================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.MAKOSH_BERRIES), ModPotions.HEALTH_BOOST_POTION);
            builder.registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_HEALTH_BOOST_POTION);
            builder.registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_HEALTH_BOOST_POTION);
            builder.registerPotionRecipe(ModPotions.STRONG_HEALTH_BOOST_POTION, Ingredient.of(ModItems.DISENTGILIL), ModPotions.ABSURD_HEALTH_BOOST_POTION);

            //=================================================ВИТХЕР ВИЗЕР=====================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.BLACK_BONE), ModPotions.WITHERING_POTION);
            builder.registerPotionRecipe(ModPotions.WITHERING_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_WITHERING_POTION);
            builder.registerPotionRecipe(ModPotions.WITHERING_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_WITHERING_POTION);

            //===============================================ШАТТЕР РАСКОЛ===========================================================
                                        //Из какого зелья?----------------------Предмет для варки-------------Результат
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.YELLOW_ARKADY_THORN), ModPotions.SHATTER_POTION);
            builder.registerPotionRecipe(ModPotions.SHATTER_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_SHATTER_POTION);
            builder.registerPotionRecipe(ModPotions.SHATTER_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_SHATTER_POTION);

            //====================================================ОЖОГ==========================================================
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModItems.CHARRED_STONE), ModPotions.SCORCH_POTION);
            builder.registerPotionRecipe(ModPotions.SCORCH_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_SCORCH_POTION);
            builder.registerPotionRecipe(ModPotions.SCORCH_POTION, Ingredient.of(Items.GLOWSTONE_DUST), ModPotions.STRONG_SCORCH_POTION);

            //==================================================ОТРАЖЕНИЕ======================================================
            builder.registerPotionRecipe(Potions.TURTLE_MASTER, Ingredient.of(Items.NETHER_STAR), ModPotions.REFLECTION_POTION);
            builder.registerPotionRecipe(Potions.LONG_TURTLE_MASTER, Ingredient.of(Items.NETHER_STAR), ModPotions.REFLECTION_POTION);
            builder.registerPotionRecipe(Potions.STRONG_TURTLE_MASTER, Ingredient.of(Items.NETHER_STAR), ModPotions.REFLECTION_POTION);
            builder.registerPotionRecipe(ModPotions.REFLECTION_POTION, Ingredient.of(Items.REDSTONE), ModPotions.LONG_REFLECTION_POTION);
            builder.registerPotionRecipe(ModPotions.REFLECTION_POTION, Ingredient.of(Items.GLOWSTONE), ModPotions.STRONG_REFLECTION_POTION);
            builder.registerPotionRecipe(ModPotions.STRONG_REFLECTION_POTION, Ingredient.of(ModItems.DISENTGILIL), ModPotions.ABSURD_REFLECTION_POTION);

        });
    }

}
