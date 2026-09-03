package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.datagen.recipe.ArcCrucibleRecipeBuilder;
import zver.nohonor.entity.boat.ModBoats;
import zver.nohonor.item.ModItems;
import zver.nohonor.tag.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {

            @Override
            public void buildRecipes(){
//============================================================СМЕЛТАБЛЫ===========================================================
                //Лист делается для того, чтобы условный raw материал вписать несколько раз
                List<ItemLike> PYRITE_ORE_SMELTABLES = List.of(ModBlocks.PYRITE_ORE, ModBlocks.DEEPSLATE_PYRITE_ORE);
                oreSmelting(PYRITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE, 0.2f, 200, "pyrite");
                oreBlasting(PYRITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE, 0.2f, 100, "pyrite");

                List<ItemLike> GALENA_ORE_SMELTABLES = List.of(ModBlocks.GALENA_ORE, ModBlocks.DEEPSLATE_GALENA_ORE);
                oreSmelting(GALENA_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.GALENA, 0.1f, 200, "galena");
                oreBlasting(GALENA_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.GALENA, 0.1f, 100, "galena");

                List<ItemLike> BAUXITE_ORE_SMELTABLES = List.of(ModBlocks.BAUXITE_ORE, ModBlocks.DEEPSLATE_BAUXITE_ORE);
                oreSmelting(BAUXITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BAUXITE, 0.1f, 200, "bauxite");
                oreBlasting(BAUXITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BAUXITE, 0.1f, 100, "bauxite");

                List<ItemLike> SPODUMENE_ORE_SMELTABLES = List.of(ModBlocks.SPODUMENE_ORE, ModBlocks.DEEPSLATE_SPODUMENE_ORE);
                oreSmelting(SPODUMENE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SPODUMENE, 0.1f, 200, "spodumene");
                oreBlasting(SPODUMENE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SPODUMENE, 0.1f, 100, "spodumene");

                List<ItemLike> CROCOITE_ORE_SMELTABLES = List.of(ModBlocks.END_STONE_CROCOITE_ORE);
                oreSmelting(CROCOITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SPODUMENE, 0.1f, 200, "crocoite");
                oreBlasting(CROCOITE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SPODUMENE, 0.1f, 100, "crocoite");

                //==========================
                List<ItemLike> PEARL_SILVER_SMELTABLES = List.of(ModItems.RAW_PEARL_SILVER);
                oreSmelting(PEARL_SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PEARL_SILVER_INGOT, 0.6f, 200, "pearl_sliver");
                oreBlasting(PEARL_SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PEARL_SILVER_INGOT, 0.6f, 100, "pearl_sliver");

                //==========================
                List<ItemLike> LUMEL_SMELTABLES = List.of(ModItems.RAW_LUMEL);
                List<ItemLike> LUMEL_ORE_SMELTABLES = List.of(ModBlocks.NETHER_LUMEL_ORE);
                oreSmelting(LUMEL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LUMEL_INGOT, 0.25f, 200, "lumel");
                oreBlasting(LUMEL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LUMEL_INGOT, 0.25f, 100, "lumel");
                oreSmelting(LUMEL_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LUMEL_INGOT, 0.25f, 100, "lumel");
                oreBlasting(LUMEL_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LUMEL_INGOT, 0.25f, 100, "lumel");

                List<ItemLike> SHCHERBARUNE_SMELTABLES = List.of(ModItems.RAW_SHCHERBARUNE);
                List<ItemLike> SHCHERBARUNE_ORE_SMELTABLES = List.of(ModBlocks.NETHER_SHCHERBARUNE_ORE);
                oreSmelting(SHCHERBARUNE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SHCHERBARUNE, 0.25f, 200, "shcherbarune");
                oreBlasting(SHCHERBARUNE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SHCHERBARUNE, 0.25f, 100, "shcherbarune");
                oreSmelting(SHCHERBARUNE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SHCHERBARUNE, 0.25f, 100, "shcherbarune");
                oreBlasting(SHCHERBARUNE_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SHCHERBARUNE, 0.25f, 100, "shcherbarune");

                List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH);
                List<ItemLike> BISMUTH_ORE_SMELTABLES = List.of(ModBlocks.END_STONE_BISMUTH_ORE);
                oreSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH, 0.25f, 200, "bismuth");
                oreBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH, 0.25f, 100, "bismuth");
                oreSmelting(BISMUTH_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH, 0.1f, 100, "bismuth");
                oreBlasting(BISMUTH_ORE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH, 0.1f, 100, "bismuth");

                //nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.DISC_FRAGMENT_LOST_MY_PIECES, RecipeCategory.BUILDING_BLOCKS, ModItems.MUSIC_DISC_LOST_MY_PIECES);

                shapeless(RecipeCategory.MISC, ModItems.MUSIC_DISC_LOST_MY_PIECES, 1)
                        .requires(Ingredient.of(ModItems.DISC_FRAGMENT_LOST_MY_PIECES), 9)
                        .unlockedBy(getHasName(ModItems.DISC_FRAGMENT_LOST_MY_PIECES), has(ModItems.MUSIC_DISC_LOST_MY_PIECES))
                        .save(output);

//=============================================================ЕДА=======================================================
                shapeless(RecipeCategory.MISC, ModItems.RICE, 1)
                        .requires(Ingredient.of(ModItems.RICE_SHOOT), 9)
                        .unlockedBy(getHasName(ModItems.RICE_SHOOT), has(ModItems.RICE_SHOOT))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.BEANS, 2)
                        .requires(Ingredient.of(ModItems.BEAN_POD), 1)
                        .unlockedBy(getHasName(ModItems.BEAN_POD), has(ModItems.BEAN_POD))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.ADVACADO_SEED, 1)
                        .requires(Ingredient.of(ModItems.ADVACADO), 1)
                        .unlockedBy(getHasName(ModItems.ADVACADO), has(ModItems.ADVACADO))
                        .save(output);

//=================================================МЕТАЛЛЫ (преимущественно)===============================================

                //это для железных блоков и слитков, не для предметов
                //генерирует ОБА рецепта: 9 маленьких --> 1 большой  И  1 большой --> 9 маленьких
                nineBlockStorageRecipes(
                        RecipeCategory.MISC,              //категория маленького (при 1 в 9)
                        ModItems.CAST_IRON_NUGGET,        //маленький предмет
                        RecipeCategory.MISC,              //категория большого (при 9 в 1(может быть и блок))
                        ModItems.CAST_IRON_INGOT          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,              //категория маленького (при 1 в 9)
                        ModItems.WHITE_CAST_IRON_NUGGET,  //маленький предмет
                        RecipeCategory.MISC,              //категория большого (при 9 в 1(может быть и блок))
                        ModItems.WHITE_CAST_IRON_INGOT    //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,                 //категория маленького (при 1 в 9)
                        ModItems.MALLEABLE_CAST_IRON_NUGGET, //маленький предмет
                        RecipeCategory.MISC,              //категория большого (при 9 в 1(может быть и блок))
                        ModItems.MALLEABLE_CAST_IRON_INGOT   //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,          //категория маленького (при 1 в 9)
                        ModItems.UKLAD_NUGGET,        //маленький предмет
                        RecipeCategory.MISC,          //категория большого (при 9 в 1(может быть и блок))
                        ModItems.UKLAD_INGOT          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.CAST_BULAT_NUGGET,     //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.CAST_BULAT_INGOT       //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,             //категория маленького (при 1 в 9)
                        ModItems.PLYMBLUM_NUGGET,        //маленький предмет
                        RecipeCategory.MISC,             //категория большого (при 9 в 1(может быть и блок))
                        ModItems.PLYMBLUM_INGOT          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,              //категория маленького (при 1 в 9)
                        ModItems.PEARL_SILVER_NUGGET,     //маленький предмет
                        RecipeCategory.MISC,              //категория большого (при 9 в 1(может быть и блок))
                        ModItems.PEARL_SILVER_INGOT       //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,           //категория маленького (при 1 в 9)
                        ModItems.ZUBETS_NUGGET,        //маленький предмет
                        RecipeCategory.MISC,           //категория большого (при 9 в 1(может быть и блок))
                        ModItems.ZUBETS_INGOT          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,          //категория маленького (при 1 в 9)
                        ModItems.GLINIY_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,          //категория большого (при 9 в 1(может быть и блок))
                        ModItems.GLINIY_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.TITANIUM_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.TITANIUM_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,         //категория маленького (при 1 в 9)
                        ModItems.LYUTYY_NUGGET,      //маленький предмет
                        RecipeCategory.MISC,         //категория большого (при 9 в 1(может быть и блок))
                        ModItems.LYUTYY_INGOT        //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.CHROMIUM_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.CHROMIUM_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,          //категория маленького (при 1 в 9)
                        ModItems.SHCHERBARUNE_SHARD,  //маленький предмет
                        RecipeCategory.MISC,          //категория большого (при 9 в 1(может быть и блок))
                        ModItems.SHCHERBARUNE         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,         //категория маленького (при 1 в 9)
                        ModItems.LUMEL_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,         //категория большого (при 9 в 1(может быть и блок))
                        ModItems.LUMEL_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,      //категория маленького (при 1 в 9)
                        ModItems.BISMUTH_NUGGET,  //маленький предмет
                        RecipeCategory.MISC,      //категория большого (при 9 в 1(может быть и блок))
                        ModItems.BISMUTH          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,              //категория маленького (при 1 в 9)
                        ModItems.KOLDOVSKAYA_BRASS_NUGGET,//маленький предмет
                        RecipeCategory.MISC,              //категория большого (при 9 в 1(может быть и блок))
                        ModItems.KOLDOVSKAYA_BRASS_INGOT  //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.KARELITE_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.KARELITE_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,             //категория маленького (при 1 в 9)
                        ModItems.KHRAMOVAYA_STEEL_NUGGET,//маленький предмет
                        RecipeCategory.MISC,             //категория большого (при 9 в 1(может быть и блок))
                        ModItems.KHRAMOVAYA_STEEL_INGOT  //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.VIVARIUM_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.VIVARIUM_INGOT         //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,            //категория маленького (при 1 в 9)
                        ModItems.HELLESTEROY_NUGGET,    //маленький предмет
                        RecipeCategory.MISC,            //категория большого (при 9 в 1(может быть и блок))
                        ModItems.HELLESTEROY_INGOT      //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,             //категория маленького (при 1 в 9)
                        ModItems.DURANSTEEL_NUGGET,      //маленький предмет
                        RecipeCategory.MISC,             //категория большого (при 9 в 1(может быть и блок))
                        ModItems.DURANSTEEL_INGOT        //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,         //категория маленького (при 1 в 9)
                        ModItems.NOUS_NUGGET,        //маленький предмет
                        RecipeCategory.MISC,         //категория большого (при 9 в 1(может быть и блок))
                        ModItems.NOUS_INGOT          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,             //категория маленького (при 1 в 9)
                        ModItems.STAR_IRON_NUGGET,       //маленький предмет
                        RecipeCategory.MISC,             //категория большого (при 9 в 1(может быть и блок))
                        ModItems.STAR_IRON_INGOT         //большой предмет
                );

                //металлические блоки
                nineBlockStorageRecipes(
                        RecipeCategory.MISC,             //категория маленького (при 1 в 9)
                        ModItems.PYRITE,                //маленький предмет
                        RecipeCategory.BUILDING_BLOCKS, //категория большого (при 9 в 1(может быть и блок))
                        ModBlocks.PYRITE_BLOCK          //большой предмет
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.GLINIY_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.GLINIY_BLOCK,
                        "gliniy_block",
                        "gliniy_ingot",
                        "gliniy_ingot_from_block",
                        "gliniy_block"
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.TITANIUM_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.TITANIUM_BLOCK,
                        "titanium_block",
                        "titanium_ingot",
                        "titanium_ingot_from_block",
                        "titanium_block"
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.LUMEL_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.LUMEL_BLOCK,
                        "lumel_block",
                        "lumel_ingot",
                        "lumel_ingot_from_block",
                        "lumel_block"
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.KARELITE_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.KARELITE_BLOCK,
                        "karelite_block",
                        "karelite_ingot",
                        "karelite_ingot_from_block",
                        "karelite_block"
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.HELLESTEROY_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.HELLESTEROY_BLOCK,
                        "hellesteroy_block",
                        "hellesteroy_ingot",
                        "hellesteroy_ingot_from_block",
                        "hellesteroy_block"
                );

                nineBlockStorageRecipes(
                        RecipeCategory.MISC,
                        ModItems.VIVARIUM_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.VIVARIUM_BLOCK,
                        "vivarium_block",
                        "vivarium_ingot",
                        "vivarium_ingot_from_block",
                        "vivarium_block"
                );

//=========================================КРАФТЫ ГЕСПЕРИДЫ===========================================================
                planksFromLogs(ModBlocks.HESPERIDES_PLANKS, ModTags.Items.HESPERIDES_LOGS, 4);

                woodFromLogs(ModBlocks.HESPERIDES_WOOD, ModBlocks.HESPERIDES_LOG);
                woodFromLogs(ModBlocks.STRIPPED_HESPERIDES_WOOD, ModBlocks.STRIPPED_HESPERIDES_LOG);

                stairBuilder(ModBlocks.HESPERIDES_STAIRS, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HESPERIDES_SLAB, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                fenceBuilder(ModBlocks.HESPERIDES_FENCE, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                fenceGateBuilder(ModBlocks.HESPERIDES_FENCE_GATE, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                doorBuilder(ModBlocks.HESPERIDES_DOOR, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                trapdoorBuilder(ModBlocks.HESPERIDES_TRAPDOOR, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.HESPERIDES_PRESSURE_PLATE, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                buttonBuilder(ModBlocks.HESPERIDES_BUTTON, Ingredient.of(ModBlocks.HESPERIDES_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shelf(ModBlocks.HESPERIDES_SHELF, ModBlocks.STRIPPED_HESPERIDES_LOG);

                signBuilder(ModBlocks.HESPERIDES_SIGN, Ingredient.of(ModBlocks.HESPERIDES_PLANKS));

                hangingSignBuilder(ModBlocks.HESPERIDES_HANGING_SIGN, Ingredient.of(ModBlocks.STRIPPED_HESPERIDES_LOG));

                woodenBoat(ModItems.HESPERIDES_BOAT, ModBlocks.HESPERIDES_PLANKS);
                chestBoat(ModItems.HESPERIDES_CHEST_BOAT, ModBlocks.HESPERIDES_PLANKS);

                shaped(RecipeCategory.COMBAT, Items.WOODEN_SWORD)
                        .pattern("A")
                        .pattern("A")
                        .pattern("B")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shaped(RecipeCategory.COMBAT, Items.WOODEN_SPEAR)
                        .pattern("  A")
                        .pattern(" B ")
                        .pattern("B  ")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shaped(RecipeCategory.TOOLS, Items.WOODEN_PICKAXE)
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shaped(RecipeCategory.TOOLS, Items.WOODEN_SHOVEL)
                        .pattern("A")
                        .pattern("B")
                        .pattern("B")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shaped(RecipeCategory.TOOLS, Items.WOODEN_AXE)
                        .pattern("AA")
                        .pattern("BA")
                        .pattern("B ")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

                shaped(RecipeCategory.TOOLS, Items.WOODEN_HOE)
                        .pattern("AA")
                        .pattern("B ")
                        .pattern("B ")
                        .define('A', ModBlocks.HESPERIDES_PLANKS)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.HESPERIDES_PLANKS), has(ModBlocks.HESPERIDES_PLANKS))
                        .group("hesperides")
                        .save(output);

//=====================================================ХРАМОВАЯ============================================================
                //КАМЕНЬ
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE, 5)
                        .pattern("ABA")
                        .pattern("BAB")
                        .pattern("ABA")
                        .define('A', ModItems.KHRAMOVAYA_STEEL_NUGGET)
                        .define('B', Blocks.COBBLESTONE)
                        .unlockedBy(getHasName(ModItems.KHRAMOVAYA_STEEL_INGOT), has(ModItems.KHRAMOVAYA_STEEL_INGOT))
                        .unlockedBy(getHasName(ModItems.KHRAMOVAYA_STEEL_NUGGET), has(ModItems.KHRAMOVAYA_STEEL_NUGGET))
                        .group("khramovaya_stone")
                        .save(output);
                //ТЕМНЫЙ
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, 8)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .define('A', ModBlocks.POLISHED_KHRAMOVAYA_STONE)
                        .define('B', Items.DYE.pick(DyeColor.BLACK))
                        .unlockedBy(getHasName(ModItems.KHRAMOVAYA_STEEL_INGOT), has(ModItems.KHRAMOVAYA_STEEL_INGOT))
                        .unlockedBy(getHasName(ModItems.KHRAMOVAYA_STEEL_NUGGET), has(ModItems.KHRAMOVAYA_STEEL_NUGGET))
                        .unlockedBy(getHasName(ModBlocks.KHRAMOVAYA_STONE), has(ModBlocks.KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                //ПРОИЗВОДНЫЕ КАМНЯ
                stairBuilder(ModBlocks.KHRAMOVAYA_STONE_STAIRS, Ingredient.of(ModBlocks.KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.KHRAMOVAYA_STONE), has(ModBlocks.KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_SLAB, Ingredient.of(ModBlocks.KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.KHRAMOVAYA_STONE), has(ModBlocks.KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_WALL, ModBlocks.KHRAMOVAYA_STONE);

                //ПОЛИРОВАННЫЙ
                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.KHRAMOVAYA_STONE), has(ModBlocks.KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output); //Цепочка: камень -> полированный -> полированные кирпичи -> чизель -> чизельные кирпичи -> обычный кирпичь -> большой кирпичь -> полированный

                stairBuilder(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL, ModBlocks.POLISHED_KHRAMOVAYA_STONE);

                buttonBuilder(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                //ПОЛИРОВАННЫЕ КИРПИЧИ
                bricksBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                stairBuilder(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);

                cutBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                //ЧИЗЕЛЬ
                chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                //ЧИЗЕЛЬНЫЙ КИРПИЧ
                bricksBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS, Ingredient.of(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                //КИРПИЧь
                bricksBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_BRICKS, Ingredient.of(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                //БОЛЬШОЙ КИРПИЧЬ
                bricksBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS, Ingredient.of(ModBlocks.KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                //и обратный рецепт
                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS))
                        .group("khramovaya_stone")
                        .save(output, ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID,
                                        "polished_khramovaya_stone_from_big_bricks"))); //Цепочка: камень -> полированный -> полированные кирпичи -> чизель -> чизельные кирпичи -> обычный кирпичь -> большой кирпичь -> полированный

                //ТЕМНЫЕ БЛОКИ
                bricksBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                cutBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CUT_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, Ingredient.of(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE), has(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output, ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID,
                                        "dark_polished_khramovaya_stone_from_dark_cut")));

                stairBuilder(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);

                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                buttonBuilder(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                stairBuilder(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, Ingredient.of(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS), has(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                        .group("khramovaya_stone")
                        .save(output);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_LAMP)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', ModBlocks.POLISHED_KHRAMOVAYA_STONE)
                        .define('B', Blocks.GLOWSTONE)
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE)
                        .define('B', Blocks.GLOWSTONE)
                        .unlockedBy(getHasName(ModBlocks.POLISHED_KHRAMOVAYA_STONE), has(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                        .group("khramovaya_stone")
                        .save(output);

                //СТОНКУТТЕР
                //надо доделать подрецепты
                //база
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_STAIRS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_SLAB, ModBlocks.KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.KHRAMOVAYA_STONE_WALL, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB, ModBlocks.KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, ModBlocks.KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_KHRAMOVAYA_STONE, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_BRICKS, ModBlocks.KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS, ModBlocks.KHRAMOVAYA_STONE);
                //полированный
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB, ModBlocks.POLISHED_KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, ModBlocks.POLISHED_KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE);
                //полированный кирпич
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_KHRAMOVAYA_STONE, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);
                //чизель и тд
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_BRICKS, ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KHRAMOVAYA_STONE_BRICKS, ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS, ModBlocks.KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS, ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS);
                //темные блоки
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, ModBlocks.DARK_CUT_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CUT_KHRAMOVAYA_STONE, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CUT_KHRAMOVAYA_STONE, ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);

//========================================================СЕРЕБРО====================================================
                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_SWORD)
                        .pattern("A")
                        .pattern("A")
                        .pattern("B")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_SPEAR)
                        .pattern("  A")
                        .pattern(" B ")
                        .pattern("B  ")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PEARL_SILVER_PICKAXE)
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PEARL_SILVER_SHOVEL)
                        .pattern("A")
                        .pattern("B")
                        .pattern("B")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PEARL_SILVER_AXE)
                        .pattern("AA")
                        .pattern("BA")
                        .pattern("B ")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PEARL_SILVER_HOE)
                        .pattern("AA")
                        .pattern("B ")
                        .pattern("B ")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_HELMET)
                        .pattern("AAA")
                        .pattern("A A")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_CHESTPLATE)
                        .pattern("A A")
                        .pattern("AAA")
                        .pattern("AAA")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_LEGGINGS)
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("A A")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.PEARL_SILVER_BOOTS)
                        .pattern("A A")
                        .pattern("A A")
                        .define('A', ModItems.PEARL_SILVER_INGOT)
                        .unlockedBy(getHasName(ModItems.PEARL_SILVER_INGOT), has(ModItems.PEARL_SILVER_INGOT))
                        .group("pearl_silver")
                        .save(output);

//========================================================СТАНКИ===========================================================
                //Арк Горнило
                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModItems.BAUXITE), ModItems.RAW_TITANIUM, 2)
                        .unlockedBy(getHasName(ModItems.BAUXITE), has(ModItems.BAUXITE))
                        .save(output, "nohonor:bauxite_item_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.BAUXITE_ORE), ModItems.RAW_TITANIUM, 2)
                        .unlockedBy(getHasName(ModBlocks.BAUXITE_ORE), has(ModBlocks.BAUXITE_ORE))
                        .save(output, "nohonor:bauxite_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.DEEPSLATE_BAUXITE_ORE), ModItems.RAW_TITANIUM, 2)
                        .unlockedBy(getHasName(ModBlocks.DEEPSLATE_BAUXITE_ORE), has(ModBlocks.DEEPSLATE_BAUXITE_ORE))
                        .save(output, "nohonor:bauxite_deepslate_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModItems.GALENA), ModItems.RAW_PEARL_SILVER, 2)
                        .unlockedBy(getHasName(ModItems.GALENA), has(ModItems.GALENA))
                        .save(output, "nohonor:galena_item_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.GALENA_ORE), ModItems.RAW_PEARL_SILVER, 2)
                        .unlockedBy(getHasName(ModBlocks.GALENA_ORE), has(ModBlocks.GALENA_ORE))
                        .save(output, "nohonor:galena_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.DEEPSLATE_GALENA_ORE), ModItems.RAW_PEARL_SILVER, 2)
                        .unlockedBy(getHasName(ModBlocks.DEEPSLATE_GALENA_ORE), has(ModBlocks.DEEPSLATE_GALENA_ORE))
                        .save(output, "nohonor:galena_deepslate_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModItems.SPODUMENE), ModItems.RAW_LYUTYY, 2)
                        .unlockedBy(getHasName(ModItems.SPODUMENE), has(ModItems.SPODUMENE))
                        .save(output, "nohonor:spodumene_item_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.SPODUMENE_ORE), ModItems.RAW_LYUTYY, 2)
                        .unlockedBy(getHasName(ModBlocks.SPODUMENE_ORE), has(ModBlocks.SPODUMENE_ORE))
                        .save(output, "nohonor:spodumene_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.DEEPSLATE_SPODUMENE_ORE), ModItems.RAW_LYUTYY, 2)
                        .unlockedBy(getHasName(ModBlocks.DEEPSLATE_SPODUMENE_ORE), has(ModBlocks.DEEPSLATE_SPODUMENE_ORE))
                        .save(output, "nohonor:spodumene_deepslate_block_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModItems.CROCOITE), ModItems.RAW_CHROMIUM, 2)
                        .unlockedBy(getHasName(ModItems.CROCOITE), has(ModItems.CROCOITE))
                        .save(output, "nohonor:crocoite_item_melting_from_arc_process");

                ArcCrucibleRecipeBuilder.arcProcessRecipe(RecipeCategory.MISC, Ingredient.of(ModBlocks.END_STONE_CROCOITE_ORE), ModItems.RAW_CHROMIUM, 2)
                        .unlockedBy(getHasName(ModBlocks.END_STONE_CROCOITE_ORE), has(ModBlocks.END_STONE_CROCOITE_ORE))
                        .save(output, "nohonor:crocoite_block_melting_from_arc_process");

            }

        };
    }

    @Override
    public String getName() {
        return "NOHONOR Mod Recipes Provider";
    }
}
