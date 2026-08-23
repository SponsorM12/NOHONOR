package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.entity.boat.ModBoats;
import zver.nohonor.item.ModItems;
import zver.nohonor.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemsTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemsTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture ) {
        super(output, providerCompletableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//========================================АББАТЫ===========================================
        tag(ModTags.Items.ABBOT)
                .add(ModItems.getRK(ModItems.BLESSING));

//========================================ПРОТОКОЛЫ===============================
        tag(ModTags.Items.PROTOCOLS)
                .add(ModItems.getRK(ModItems.BLESSING));

//======================================ТАГИ СЕРЕБРО==================================
//==========================================ОРУЖИЕ====================================
        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.PEARL_SILVER_SWORD));
        tag(ItemTags.SPEARS).add(ModItems.getRK(ModItems.PEARL_SILVER_SPEAR));
        tag(ItemTags.MACE_ENCHANTABLE).add(ModItems.getRK(ModItems.PEARL_SILVER_MACE));
//=======================================ИНСТРУМЕНТЫ=================================
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.PEARL_SILVER_PICKAXE));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.PEARL_SILVER_SHOVEL));
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.PEARL_SILVER_AXE));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.PEARL_SILVER_HOE));
//==========================================БРОНЯ==================================
        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.PEARL_SILVER_HELMET));
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModItems.getRK(ModItems.PEARL_SILVER_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.PEARL_SILVER_CHESTPLATE));
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModItems.getRK(ModItems.PEARL_SILVER_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.PEARL_SILVER_LEGGINGS));
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModItems.getRK(ModItems.PEARL_SILVER_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.PEARL_SILVER_BOOTS));
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModItems.getRK(ModItems.PEARL_SILVER_BOOTS));

//=====================================КАМЕНЬ ЛАЙК==================================
        tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModItems.getRK(ModBlocks.KHRAMOVAYA_STONE.asItem()));
        tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModItems.getRK(ModBlocks.KHRAMOVAYA_STONE.asItem()));

//======================================КНОПКИ======================================
        //tag(ItemTags.BU)
        //        .add(ModItems.getRK(ModBlocks.HESPERIDES_BUTTON.asItem())
        //        .add(ModItems.getRK(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem())
        //        .add(ModItems.getRK(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModItems.getRK(ModBlocks.HESPERIDES_BUTTON.asItem()));

        //tag(ItemTags.STONE)
        //        .add(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem())
        //        .add(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem());

//=====================================ФОКС ФУД=======================================
        tag(ItemTags.FOX_FOOD)
                .add(ModItems.getRK(ModItems.GREEN_APPLE))
                .add(ModItems.getRK(ModItems.MAKOSH_BERRIES));

//=====================================ТЕНАСИТИ ФУД ЕДА=======================================
        tag(ModTags.Items.TENACITY_FOOD)
                //.add(ModItems.getRK(ModItems.RICE))
                .add(ModItems.getRK(ModItems.RICE))
                .add(ModItems.getRK(ModItems.BEANS))
                .add(ModItems.getRK(ModItems.ADVACADO))
                .add(ModItems.getRK(ModItems.ONIGIRI))
                .add(ModItems.getRK(ModItems.SUSHI))
                .add(ModItems.getRK(ModItems.MEBER_APPLE))
                .add(ModItems.getRK(ModItems.SPACE_WATERMELON));

//=========================================ОРЫ=======================================
        tag(ModTags.Items.PYRITE_ORES)
                .add(ModItems.getRK(ModBlocks.PYRITE_ORE.asItem()))
                .add(ModItems.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE.asItem()));

        tag(ModTags.Items.GALENA_ORES)
                .add(ModItems.getRK(ModBlocks.GALENA_ORE.asItem()))
                .add(ModItems.getRK(ModBlocks.DEEPSLATE_GALENA_ORE.asItem()));

        tag(ModTags.Items.BAUXITE_ORES)
                .add(ModItems.getRK(ModBlocks.BAUXITE_ORE.asItem()))
                .add(ModItems.getRK(ModBlocks.DEEPSLATE_BAUXITE_ORE.asItem()));

        tag(ModTags.Items.SPODUMENE_ORES)
                .add(ModItems.getRK(ModBlocks.SPODUMENE_ORE.asItem()))
                .add(ModItems.getRK(ModBlocks.DEEPSLATE_SPODUMENE_ORE.asItem()));

        tag(ModTags.Items.CROCOITE_ORES)
                .add(ModItems.getRK(ModBlocks.END_STONE_CROCOITE_ORE.asItem()));

        tag(ModTags.Items.LUMEL_ORES)
                .add(ModItems.getRK(ModBlocks.NETHER_LUMEL_ORE.asItem()));

        tag(ModTags.Items.SHCHERBARUNE_ORES)
                .add(ModItems.getRK(ModBlocks.NETHER_SHCHERBARUNE_ORE.asItem()));

        tag(ModTags.Items.BISMUTH_ORES)
                .add(ModItems.getRK(ModBlocks.END_STONE_BISMUTH_ORE.asItem()));

//========================================ЛОГС=======================================
        tag(ModTags.Items.HESPERIDES_LOGS)
                .add(ModItems.getRK(ModBlocks.HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.HESPERIDES_WOOD.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD.asItem()));

        tag(ItemTags.LOGS)
                .add(ModItems.getRK(ModBlocks.HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.HESPERIDES_WOOD.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD.asItem()));

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModItems.getRK(ModBlocks.HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.HESPERIDES_WOOD.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_HESPERIDES_WOOD.asItem()));

//====================================ФАНТАСТИЧЕСКИЕ СПЛАВЫ==============================
        tag(ModTags.Items.FANTASTIC_INGOTS)
                .add(ModItems.getRK(ModItems.CAST_IRON_INGOT))
                .add(ModItems.getRK(ModItems.DURANSTEEL_INGOT))
                .add(ModItems.getRK(ModItems.HELLESTEROY_INGOT))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_INGOT))
                .add(ModItems.getRK(ModItems.KARELITE_INGOT))
                .add(ModItems.getRK(ModItems.KHRAMOVAYA_STEEL_INGOT))
                .add(ModItems.getRK(ModItems.LYUTYY_INGOT))
                .add(ModItems.getRK(ModItems.LUMEL_INGOT))
                .add(ModItems.getRK(ModItems.MALLEABLE_CAST_IRON_INGOT))
                .add(ModItems.getRK(ModItems.NOUS_INGOT))
                .add(ModItems.getRK(ModItems.STAR_IRON_INGOT))
                .add(ModItems.getRK(ModItems.VIVARIUM_INGOT))
                .add(ModItems.getRK(ModItems.WHITE_CAST_IRON_INGOT));

//=========================================КАСТОМ БРОНЯ====================================
        tag(ModTags.Items.PEARL_SILVER_ARMOR)
                .add(ModItems.getRK(ModItems.PEARL_SILVER_HELMET))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_CHESTPLATE))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_LEGGINGS))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_BOOTS));

//============================================ТРИМЫ==============================================
        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.getRK(ModItems.BISMUTH))
                .add(ModItems.getRK(ModItems.DURANSTEEL_INGOT))
                .add(ModItems.getRK(ModItems.HELLESTEROY_INGOT))
                .add(ModItems.getRK(ModItems.KARELITE_INGOT))
                .add(ModItems.getRK(ModItems.KHRAMOVAYA_STEEL_INGOT))
                .add(ModItems.getRK(ModItems.LUMEL_INGOT))
                .add(ModItems.getRK(ModItems.NOUS_INGOT))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_INGOT))
                .add(ModItems.getRK(ModItems.SHCHERBARUNE))
                .add(ModItems.getRK(ModItems.STAR_IRON_INGOT))
                .add(ModItems.getRK(ModItems.VIVARIUM_INGOT));

//======================================НАГЕТС============================================
        tag(ItemTags.METAL_NUGGETS)
                .add(ModItems.getRK(ModItems.BISMUTH_NUGGET))
                .add(ModItems.getRK(ModItems.CAST_BULAT_NUGGET))
                .add(ModItems.getRK(ModItems.CAST_IRON_NUGGET))
                .add(ModItems.getRK(ModItems.CHROMIUM_NUGGET))
                .add(ModItems.getRK(ModItems.DURANSTEEL_NUGGET))
                .add(ModItems.getRK(ModItems.GLINIY_NUGGET))
                .add(ModItems.getRK(ModItems.HELLESTEROY_NUGGET))
                .add(ModItems.getRK(ModItems.KARELITE_NUGGET))
                .add(ModItems.getRK(ModItems.KHRAMOVAYA_STEEL_NUGGET))
                .add(ModItems.getRK(ModItems.KOLDOVSKAYA_BRASS_NUGGET))
                .add(ModItems.getRK(ModItems.LUMEL_NUGGET))
                .add(ModItems.getRK(ModItems.LYUTYY_NUGGET))
                .add(ModItems.getRK(ModItems.MALLEABLE_CAST_IRON_NUGGET))
                .add(ModItems.getRK(ModItems.NOUS_NUGGET))
                .add(ModItems.getRK(ModItems.PEARL_SILVER_NUGGET))
                .add(ModItems.getRK(ModItems.STAR_IRON_NUGGET))
                .add(ModItems.getRK(ModItems.TITANIUM_NUGGET))
                .add(ModItems.getRK(ModItems.UKLAD_NUGGET))
                .add(ModItems.getRK(ModItems.VIVARIUM_NUGGET))
                .add(ModItems.getRK(ModItems.WHITE_CAST_IRON_NUGGET))
                .add(ModItems.getRK(ModItems.ZUBETS_NUGGET));

//=========================================САПЛИНГ==========================================
        tag(ItemTags.SAPLINGS)
                .add(ModItems.getRK(ModBlocks.HESPERIDES_SAPLING.asItem()));

//====================================ЭЭЭКСПЕРИМЕНТЫ=====================================
        tag(ItemTags.ZOMBIE_HORSE_FOOD)
                .add(ModItems.getRK(ModItems.BLACK_RESIN_CLUMP));
        tag(ItemTags.CAMEL_HUSK_FOOD)
                .add(ModItems.getRK(ModItems.BLACK_RESIN_CLUMP));

        tag(ItemTags.BEE_FOOD)
                .add(ModItems.getRK(ModBlocks.GOLDEN_PETALS.asItem()));
        tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.getRK(ModItems.RAW_KARELITE))
                .add(ModItems.getRK(ModItems.KARELITE_INGOT))
                .add(ModItems.getRK(ModItems.KARELITE_NUGGET))
                .add(ModItems.getRK(ModBlocks.GOLDEN_PETALS.asItem()));

//====================================ПАДЕНИЕ ПЛАСТИНОК===============================
        tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.getRK(ModItems.MUSIC_DISC_FULL_CONFESSION))
                .add(ModItems.getRK(ModItems.MUSIC_DISC_MY_ONLY_CHANCE));

//========================================БОАТС======================================
        tag(ItemTags.BOATS)
                .add(ModItems.getRK(ModItems.HESPERIDES_BOAT));
        tag(ItemTags.CHEST_BOATS)
                .add(ModItems.getRK(ModItems.HESPERIDES_CHEST_BOAT));

//========================================БАКЕТ========================================
        tag(ConventionalItemTags.BUCKETS)
                .add(ModItems.getRK(ModItems.ACID_BUCKET));

    }
}
