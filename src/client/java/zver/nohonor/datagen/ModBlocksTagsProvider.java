package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlocksTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlocksTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registeries) {

//==========================С ТОПОРА======================================
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WOOD))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_PLANKS))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SLAB))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_FENCE))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_FENCE_GATE))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_DOOR))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_TRAPDOOR))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_PRESSURE_PLATE))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SHELF))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SIGN))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WALL_SIGN))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_HANGING_SIGN))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WALL_HANGING_SIGN));

//=================================КИРКА==================================
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.MEGAHAROSH_BLOCK))
                //.add(ModBlocks.LEDLAMP)

                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE))
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL))
                .add(ModBlocks.getRK(ModBlocks.CUT_KHRAMOVAYA_STONE))
                .add(ModBlocks.getRK(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL))
                .add(ModBlocks.getRK(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE))

                .add(ModBlocks.getRK(ModBlocks.PEDESTAL))

                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.GALENA_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_GALENA_ORE))
                .add(ModBlocks.getRK(ModBlocks.BAUXITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_BAUXITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.SPODUMENE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_SPODUMENE_ORE))
                .add(ModBlocks.getRK(ModBlocks.NETHER_LUMEL_ORE))
                .add(ModBlocks.getRK(ModBlocks.NETHER_SHCHERBARUNE_ORE))
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));

//===============================МОТЫГА====================================
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_LEAVES));


//=============================НУЖЕН КАМЕНЬ=================================
        //tag(BlockTags.NEEDS_STONE_TOOL)

//=============================НУЖНО ЖЕЛЕЗО==================================
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.GALENA_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_GALENA_ORE))
                .add(ModBlocks.getRK(ModBlocks.BAUXITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_BAUXITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));

//=============================НУЖНО СЕРЕБРО============================
        tag(ModTags.Blocks.NEEDS_PEARL_SILVER_TOOL)
                .add(ModBlocks.getRK(ModBlocks.MEGAHAROSH_BLOCK))
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PEARL_SILVER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

//=============================НУЖЕН АЛМАЗ==================================
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.SPODUMENE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_SPODUMENE_ORE))
                .add(ModBlocks.getRK(ModBlocks.NETHER_LUMEL_ORE))
                .add(ModBlocks.getRK(ModBlocks.NETHER_SHCHERBARUNE_ORE));

//===============================КАМЕННЫЕ ТЭГИ===================================
        tag(BlockTags.SCULK_REPLACEABLE)
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE));

        //tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN)

        tag(BlockTags.NETHER_CARVER_REPLACEABLES)
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE));

//===============================САПЛИНГ=====================================
        tag(BlockTags.FLOWER_POTS)
         .add(ModBlocks.getRK(ModBlocks.POTTED_HESPERIDES_SAPLING));
        //временное решение
        tag(TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("saplings")))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SAPLING));

//================================ЛИСТВА====================================
        tag(BlockTags.LEAVES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_LEAVES));

//=================================ПЛАНКС====================================
        tag(BlockTags.PLANKS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_PLANKS));

//=============================ДЕР. ЛЕСТНИЦА================================
        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_STAIRS));

//===============================ЛЕСТНИЦА===================================
        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS));

//=============================ДЕР. СЛАБС====================================
        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SLAB));

//===============================СЛАБС========================================
        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB));

//============================ДЕР. ЗАБОР====================================
        tag(BlockTags.FENCES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_FENCE));
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_FENCE));

//==============================ВАЛЛ==============================
        tag(BlockTags.WALLS)
                .add(ModBlocks.getRK(ModBlocks.KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL));

//===========================ВРАТА==========================================
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_FENCE_GATE));

//==========================ДЕР. ДОРС=======================================
        tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_DOOR));
        tag(BlockTags.DOORS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_DOOR));
        tag(BlockTags.MOB_INTERACTABLE_DOORS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_DOOR));

//============================ДЕР. ТРАПЫ====================================
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_TRAPDOOR));

//=============================ДЕР. НАЖИМНАЯ ПЛИТЫ=============================
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_PRESSURE_PLATE));

//================================КАМЕННЫЕ ПЛИТЫ============================
        tag(BlockTags.STONE_PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE));

//============================ДЕР. КНОПКИ=====================================
        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_BUTTON));

//===============================КНОПКИ======================================
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON));

        tag(BlockTags.STONE_BUTTONS)
                .add(ModBlocks.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON));

//===========================ШКАФ=====================================
        tag(BlockTags.WOODEN_SHELVES)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SHELF));

//=============================ТАБЛИЧКИ=====================================
        tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_SIGN));

        tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WALL_SIGN));

        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_HANGING_SIGN));

        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WALL_HANGING_SIGN));

//===============================БЕДФЛОВЕРС==========================
        tag(BlockTags.FLOWERS)
                .add(ModBlocks.getRK(ModBlocks.GOLDEN_PETALS));

        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .add(ModBlocks.getRK(ModBlocks.GOLDEN_PETALS));

//===============================КРОПС================================
        tag(BlockTags.CROPS)
                .add(ModBlocks.getRK(ModBlocks.LOTUS_CROP))
                .add(ModBlocks.getRK(ModBlocks.MERCURILLIA_CROP))
                .add(ModBlocks.getRK(ModBlocks.BEAN_CROP))
                .add(ModBlocks.getRK(ModBlocks.RICE_CROP))
                .add(ModBlocks.getRK(ModBlocks.ADVACADO_CROP));

//===============================СВИТ БУШ================================
        tag(BlockTags.FALL_DAMAGE_RESETTING)
                .add(ModBlocks.getRK(ModBlocks.GREEN_APPLE_BERRY_BUSH))
                .add(ModBlocks.getRK(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH));

        tag(BlockTags.FOX_IMMUNE_TO)
                .add(ModBlocks.getRK(ModBlocks.GREEN_APPLE_BERRY_BUSH))
                .add(ModBlocks.getRK(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH));

        tag(BlockTags.HAPPY_GHAST_AVOIDS)
                .add(ModBlocks.getRK(ModBlocks.GREEN_APPLE_BERRY_BUSH))
                .add(ModBlocks.getRK(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH));

//==============================ПЧЁЛКИ=====================================
        tag(BlockTags.BEE_GROWABLES)
                .add(ModBlocks.getRK(ModBlocks.GREEN_APPLE_BERRY_BUSH))
                .add(ModBlocks.getRK(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH))
                .add(ModBlocks.getRK(ModBlocks.MERCURILLIA_CROP))
                .add(ModBlocks.getRK(ModBlocks.BEAN_CROP))
                .add(ModBlocks.getRK(ModBlocks.LOTUS_CROP))
                .add(ModBlocks.getRK(ModBlocks.RICE_CROP))
                .add(ModBlocks.getRK(ModBlocks.ADVACADO_CROP));

        tag(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.getRK(ModBlocks.GOLDEN_PETALS));

//=============================ПЛЮШЕВЫЙ=================================
        tag(ModTags.Blocks.PLUSHE)
                .add(ModBlocks.getRK(ModBlocks.PLUSHE_SHARK))
                .add(ModBlocks.getRK(ModBlocks.PLUSHE_WHALE));

//=============================РУДЫ БЛОКИ==================================
        tag(ModTags.Blocks.PYRITE_ORES)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE));

        tag(ModTags.Blocks.GALENA_ORES)
                .add(ModBlocks.getRK(ModBlocks.GALENA_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_GALENA_ORE));

        tag(ModTags.Blocks.BAUXITE_ORES)
                .add(ModBlocks.getRK(ModBlocks.BAUXITE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_BAUXITE_ORE));

        tag(ModTags.Blocks.SPODUMENE_ORES)
                .add(ModBlocks.getRK(ModBlocks.SPODUMENE_ORE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_SPODUMENE_ORE));

        tag(ModTags.Blocks.LUMEL_ORES)
                .add(ModBlocks.getRK(ModBlocks.NETHER_LUMEL_ORE));

        tag(ModTags.Blocks.SHCHERBARUNE_ORES)
                .add(ModBlocks.getRK(ModBlocks.NETHER_SHCHERBARUNE_ORE));

        tag(ModTags.Blocks.BISMUTH_ORES)
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));
        tag(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));
        tag(BlockTags.SUPPORTS_CHORUS_PLANT)
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));
        tag(BlockTags.SUPPORTS_CHORUS_FLOWER)
                .add(ModBlocks.getRK(ModBlocks.END_STONE_BISMUTH_ORE));

//===============================ЛОГС=======================================
        tag(ModTags.Blocks.HESPERIDES_LOGS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WOOD))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD));

//======================ТЫ ГАРИШЬ ААААААА================================
        //я ебалай, сюда нужно добовлять только Логи бервна
        tag(BlockTags.LOGS)
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.HESPERIDES_WOOD))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD));



        //.add(ModBlocks.HESPERIDES_LOG)
        //.add(ModBlocks.HESPERIDES_WOOD)
        //.add(ModBlocks.STRIPPED_HESPERIDES_LOG)
        //  .add(ModBlocks.STRIPPED_HESPERIDES_WOOD)
        //   .add(ModBlocks.HESPERIDES_PLANKS)
        //    .add(ModBlocks.HESPERIDES_STAIRS)
        //  .add(ModBlocks.HESPERIDES_SLAB)
        //  .add(ModBlocks.HESPERIDES_LEAVES)
        //  .add(ModBlocks.HESPERIDES_FENCE)
        //  .add(ModBlocks.HESPERIDES_FENCE_GATE)
        //  .add(ModBlocks.HESPERIDES_DOOR)
        //  .add(ModBlocks.HESPERIDES_TRAPDOOR)
        //    .add(ModBlocks.HESPERIDES_PRESSURE_PLATE)
        //   .add(ModBlocks.HESPERIDES_BUTTON)
        //   .add(ModBlocks.HESPERIDES_SHELF)
        //   .add(ModBlocks.HESPERIDES_SIGN)
        //   .add(ModBlocks.HESPERIDES_WALL_SIGN)
        //   .add(ModBlocks.HESPERIDES_HANGING_SIGN)
        //   .add(ModBlocks.HESPERIDES_WALL_HANGING_SIGN);

    }
}
