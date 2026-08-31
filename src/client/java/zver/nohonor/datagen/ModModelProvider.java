package zver.nohonor.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.Broken;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.block.custom.ModLampBlock;
import zver.nohonor.block.custom.ModBerryBushBlocks;
import zver.nohonor.block.custom.ModCropBlocks;
import zver.nohonor.block.custom.ModWaterCropBlocks;
import zver.nohonor.item.ModArmorMaterials;
import zver.nohonor.item.ModItems;

import java.util.Optional;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
//=============================================БЛОКИ====================================================
//==========================================ПРОСТЫЕ БЛОКИ================================================
        blockModelGenerators.createTrivialCube(ModBlocks.MEGAHAROSH_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.LEDLAMP);

        //blockModelGenerators.createNonTemplateModelBlock(ModBlocks.PLUSHE_SHARK);
        blockModelGenerators.createNonTemplateHorizontalBlock(ModBlocks.PLUSHE_SHARK);
        blockModelGenerators.createNonTemplateHorizontalBlock(ModBlocks.PLUSHE_WHALE);

        //ХРАМОВЫЕ
        blockModelGenerators.createTrivialCube(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE);
        blockModelGenerators.createTrivialCube(ModBlocks.CUT_KHRAMOVAYA_STONE);
        blockModelGenerators.createTrivialCube(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS);
        blockModelGenerators.createTrivialCube(ModBlocks.KHRAMOVAYA_STONE_BRICKS);
        blockModelGenerators.createTrivialCube(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS);

        blockModelGenerators.family(ModBlocks.KHRAMOVAYA_STONE)
                .generateFor(ModBlocks.KHRAMOVAYA_STONE_FAMILY);
        blockModelGenerators.family(ModBlocks.POLISHED_KHRAMOVAYA_STONE)
                .generateFor(ModBlocks.POLISHED_KHRAMOVAYA_STONE_FAMILY);
        blockModelGenerators.family(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS)
                .generateFor(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_FAMILY);

        //ТЕМНЫЕ ХРАМОВЫЕ
        blockModelGenerators.createTrivialCube(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE);

        blockModelGenerators.family(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE)
                .generateFor(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_FAMILY);
        blockModelGenerators.family(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS)
                .generateFor(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_FAMILY);

        //ПЪЕДЕСТАЛ
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.PEDESTAL);

        //АРК
        //blockModelGenerators.createHorizontallyRotatedBlock(ModBlocks.ARC_CRUCIBLE, TexturedModel.ORIENTABLE);
        blockModelGenerators.createFurnace(ModBlocks.ARC_CRUCIBLE, TexturedModel.ORIENTABLE);

//================================================РУДЫ=============================================
        blockModelGenerators.createTrivialCube(ModBlocks.PYRITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_PYRITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.GALENA_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_GALENA_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BAUXITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_BAUXITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.SPODUMENE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_SPODUMENE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.END_STONE_CROCOITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_LUMEL_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_SHCHERBARUNE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.END_STONE_BISMUTH_ORE);

//===========================================МЕТАЛЛИЧЕСКИЕ БЛОКИ========================================
        blockModelGenerators.createTrivialCube(ModBlocks.PYRITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.GLINIY_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.TITANIUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.LUMEL_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.KARELITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.HELLESTEROY_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.VIVARIUM_BLOCK);

//==============================================ЛАМПЫ================================================
        Identifier KhramovayalampOffIdentifier = TexturedModel.CUBE.create(ModBlocks.KHRAMOVAYA_STONE_LAMP, blockModelGenerators.modelOutput);
        Identifier KhramovayalampOnIdentifier = blockModelGenerators.createSuffixedVariant(ModBlocks.KHRAMOVAYA_STONE_LAMP,"_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.KHRAMOVAYA_STONE_LAMP)
                .with(BlockModelGenerators.createBooleanModelDispatch(ModLampBlock.CLICKED,
                new MultiVariant(WeightedList.<Variant>builder().add(new Variant(KhramovayalampOnIdentifier)).build()),
                new MultiVariant(WeightedList.<Variant>builder().add(new Variant(KhramovayalampOffIdentifier)).build())))
        );

        Identifier DarkKhramovayalampOffIdentifier = TexturedModel.CUBE.create(ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP, blockModelGenerators.modelOutput);
        Identifier DarkKhramovayalampOnIdentifier = blockModelGenerators.createSuffixedVariant(ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP,"_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP)
                .with(BlockModelGenerators.createBooleanModelDispatch(ModLampBlock.CLICKED,
                        new MultiVariant(WeightedList.<Variant>builder().add(new Variant(DarkKhramovayalampOnIdentifier)).build()),
                        new MultiVariant(WeightedList.<Variant>builder().add(new Variant(DarkKhramovayalampOffIdentifier)).build())))
        );


//===============================================САПЛИНГ=========================================================
        blockModelGenerators.createCrossBlockWithDefaultItem(ModBlocks.HESPERIDES_SAPLING,BlockModelGenerators
                .PlantType.NOT_TINTED, TextureMapping.cross(ModBlocks.HESPERIDES_SAPLING));
        TextureMapping pottedMapping = TextureMapping.pottedAzalea(ModBlocks.POTTED_HESPERIDES_SAPLING);
        Identifier pottedModel = ModelTemplates.POTTED_FLOWERING_AZALEA.create(
                ModBlocks.POTTED_HESPERIDES_SAPLING,
                pottedMapping,
                blockModelGenerators.modelOutput
        );

        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createSimpleBlock(
                        ModBlocks.POTTED_HESPERIDES_SAPLING,
                        plainVariant(pottedModel)
                )
        );

//=============================================ГЕСПЕРИДА============================================
        blockModelGenerators.createTrivialBlock(ModBlocks.HESPERIDES_LEAVES, TexturedModel.LEAVES);
        blockModelGenerators.createAxisAlignedPillarBlock(ModBlocks.HESPERIDES_LOG, TexturedModel.COLUMN_ALT);
        blockModelGenerators.createAxisAlignedPillarBlock(ModBlocks.HESPERIDES_WOOD, TexturedModel.CUBE);
        blockModelGenerators.createAxisAlignedPillarBlock(ModBlocks.STRIPPED_HESPERIDES_LOG, TexturedModel.COLUMN_ALT);
        blockModelGenerators.createAxisAlignedPillarBlock(ModBlocks.STRIPPED_HESPERIDES_WOOD, TexturedModel.CUBE);

        blockModelGenerators.family(ModBlocks.HESPERIDES_PLANKS) // <----Эта дурь генерит сразу всё, что описано в family,в том числе и базовый блок
                .generateFor(ModBlocks.HESPERIDES_FAMILY);

//Шкаф
        blockModelGenerators.createShelf(
                ModBlocks.HESPERIDES_SHELF,
                ModBlocks.STRIPPED_HESPERIDES_LOG
        );

//======================================ИНЫЕ ДЕКОРАТИВНЫЕ БЛОКИ====================================================

//Золотистые цветочки
        //Я их случайно сделал я не думал что это сработает
        blockModelGenerators.createFlowerBed(ModBlocks.GOLDEN_PETALS);

//=================================================КРОПС====================================================
        blockModelGenerators.createCropBlock(ModBlocks.MERCURILLIA_CROP,
                ModCropBlocks.AGE, 0, 1, 2, 3, 4, 5);
        blockModelGenerators.createCropBlock(ModBlocks.BEAN_CROP,
                ModCropBlocks.AGE, 0, 1, 2, 3, 4, 5);

//==============================================ВАТЕР КРОПС===================================================
        blockModelGenerators.createCrossBlock(ModBlocks.LOTUS_CROP, BlockModelGenerators.PlantType.NOT_TINTED,
                ModWaterCropBlocks.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockModelGenerators.createCropBlock(ModBlocks.RICE_CROP,
                ModWaterCropBlocks.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockModelGenerators.createCropBlock(ModBlocks.ADVACADO_CROP,
                ModWaterCropBlocks.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockModelGenerators.createCrossBlock(ModBlocks.YELLOW_ARKADY_CROP, BlockModelGenerators.PlantType.NOT_TINTED,
                ModWaterCropBlocks.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        blockModelGenerators.createCrossBlock(ModBlocks.LOTUS_STEM, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createTrivialBlock(ModBlocks.RICE_STEM, TexturedModel.SEAGRASS);
        blockModelGenerators.createTrivialBlock(ModBlocks.ADVACADO_STEM, TexturedModel.SEAGRASS);
        blockModelGenerators.createCrossBlock(ModBlocks.YELLOW_ARKADY_STEM, BlockModelGenerators.PlantType.NOT_TINTED);

//==============================================СВИТ БУШ (КРОСС БЛОК)===============================================
        blockModelGenerators.createCrossBlock(ModBlocks.GREEN_APPLE_BERRY_BUSH, BlockModelGenerators.PlantType.NOT_TINTED,
                ModBerryBushBlocks.AGE, 0, 1, 2, 3);
        blockModelGenerators.createCrossBlock(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH, BlockModelGenerators.PlantType.TINTED,
                ModBerryBushBlocks.AGE, 0, 1, 2, 3);


//====================================================================================================================
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
//==========================================ПРЕДМЕТЫ=========================================================
        //itemModelGenerators.generateFlatItem(ModItems.BLESSING, ModelTemplates.FLAT_ITEM);
        //CustomItemModelGenerator.registerScaled2x(ModItems.BLESSING, itemModelGenerators);
        CustomItemModelGenerator.wide_frame(ModItems.BLESSING, itemModelGenerators);

//=====================================ПРОСТЫЕ МАТЕРИАЛЫ + ХИМИЯ=======================================
        itemModelGenerators.generateFlatItem(ModItems.SEA_STONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.YELLOW_ARKADY_THORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLACK_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHARRED_STONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PYRITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GALENA, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BAUXITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SPODUMENE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CROCOITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLACK_RESIN_CLUMP, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEOV, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.declareCustomModelItem(ModItems.ION_SPHERE);
        //itemModelGenerators.generateFlatItem(ModItems.LOTUS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FRUM_FRUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ALCOHOL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTHIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_SYNTHETIC, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KERASENE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DISENTGILIL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FAZAMISANTROL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.AUERIENNE, ModelTemplates.FLAT_ITEM);

//============================================ВАЛЮТА===================================================
        itemModelGenerators.generateFlatItem(ModItems.PEARL_GARANT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_TITAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIVELEAF_CLOVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_FIVELEAF_CLOVER, ModelTemplates.FLAT_ITEM);

//=========================================МЕТАЛЛЫ + МАТЕРИАЛЫ=================================
        itemModelGenerators.generateFlatItem(ModItems.RAW_CAST_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAST_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAST_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_WHITE_CAST_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WHITE_CAST_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WHITE_CAST_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_MALLEABLE_CAST_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MALLEABLE_CAST_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MALLEABLE_CAST_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_UKLAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.UKLAD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.UKLAD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_CAST_BULAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAST_BULAT_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CAST_BULAT_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_PLYMBLUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PLYMBLUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PLYMBLUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_PEARL_SILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_ZUBETS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ZUBETS_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ZUBETS_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_GLINIY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GLINIY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GLINIY_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_TITANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TITANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TITANIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_LYUTYY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LYUTYY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LYUTYY_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_CHROMIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHROMIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHROMIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_SHCHERBARUNE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHCHERBARUNE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHCHERBARUNE_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_LUMEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LUMEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LUMEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_BISMUTH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_NUGGET, ModelTemplates.FLAT_ITEM);

//===============================================СПЛАВЫ==================================================
        itemModelGenerators.generateFlatItem(ModItems.RAW_KOLDOVSKAYA_BRASS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KOLDOVSKAYA_BRASS_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KOLDOVSKAYA_BRASS_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_KARELITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KARELITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KARELITE_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_KHRAMOVAYA_STEEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KHRAMOVAYA_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KHRAMOVAYA_STEEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_VIVARIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIVARIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIVARIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_HELLESTEROY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HELLESTEROY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HELLESTEROY_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_DURANSTEEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DURANSTEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DURANSTEEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_NOUS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NOUS_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NOUS_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.STAR_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STAR_IRON_NUGGET, ModelTemplates.FLAT_ITEM);

//==========================================СОКРОВИЩА и ТД=====================================================
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_KEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STAR_KEY, ModelTemplates.FLAT_ITEM);
        CustomItemModelGenerator.registerScaled2x(ModItems.SYMBOL_OF_THE_UNIVERSE, itemModelGenerators);

//================================================ЕДА===================================================
        //itemModelGenerators.generateFlatItem(ModItems.GREEN_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NUTRITIONAL_JELLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HEARTY_JELLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROTTEN_JELLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SPOILED_JELLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHAWARMA, ModelTemplates.FLAT_ITEM);
        //itemModelGenerators.generateFlatItem(ModItems.RICE_SHOOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEANS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADVACADO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ONIGIRI, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SUSHI, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MEBER_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SPACE_WATERMELON, ModelTemplates.FLAT_ITEM);

//===============================================ДРУГОЕ===================================================
        itemModelGenerators.generateFlatItem(ModItems.ARROW_RED, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ARROW_GREEN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ARROW_BLUE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ARROW_YELLOW, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_AME_IRO_RONDO, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_FULL_CONFESSION, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_MY_ONLY_CHANCE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_LOST_MY_PIECES, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_V_MOYEY_GOLOVE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ModItems.DISC_FRAGMENT_LOST_MY_PIECES, ModelTemplates.FLAT_ITEM);

//==========================================ИТЕМС ДЛЯ БЛОКОВ===============================================
        //itemModelGenerators.generateFlatItem(Item.byBlock(ModBlocks.HESPERIDES_SAPLING), ModelTemplates.FLAT_ITEM); //я не уверен, что это нужно. Нужно объяснение

//========================================НЕ ПОДДАЕТСЯ ОБЪЯСНЕНИЮ========================================
        //itemModelGenerators.generateFlatItem(ModBoats.HESPERIDES_BOAT_ITEM, ModelTemplates.FLAT_ITEM);
        //itemModelGenerators.generateFlatItem(ModBoats.HESPERIDES_CHEST_BOAT_ITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HESPERIDES_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HESPERIDES_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

//=================================================ОРУЖИЕ======================================================
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.PEARL_SILVER_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_MACE, ModelTemplates.FLAT_HANDHELD_ITEM);

//=================================================ИНСТРУМЕНТЫ=================================================
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

//======================================================ЭЛИТРЫ======================================================
        CustomItemModelGenerator.generateStormElytra(ModItems.STORM_ELYTRA, itemModelGenerators);
        CustomItemModelGenerator.generateExterminationElytra(ModItems.EXTERMINATION_ELYTRA, itemModelGenerators);

//=====================================================БРОНЯ==========================================================
        itemModelGenerators.generateTrimmableItem(ModItems.PEARL_SILVER_HELMET, ModArmorMaterials.PEARL_SILVER_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.PEARL_SILVER_CHESTPLATE, ModArmorMaterials.PEARL_SILVER_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.PEARL_SILVER_LEGGINGS, ModArmorMaterials.PEARL_SILVER_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.PEARL_SILVER_BOOTS, ModArmorMaterials.PEARL_SILVER_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_WOLF_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEARL_SILVER_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

//======================================================БАКЕТ================================================
        itemModelGenerators.generateFlatItem(ModItems.ACID_BUCKET, ModelTemplates.FLAT_ITEM);

//====================================================================================================================
    }

//====================================КАСТОМНЫЙ ГЕНЕРАТОР=================================================================
    //я ниче не понимаю, оставлю пока так
    public static class CustomItemModelGenerator {
        //:::custom-item-model:::
        public static final ModelTemplate SCALED2X = item("scaled2x", TextureSlot.LAYER0);
        public static final ModelTemplate WIDE_FRAME = item("wide_frame", TextureSlot.LAYER0);

        //:::custom-item-model:::
        //:::custom-item-datagen-method
        public static void registerScaled2x(Item item, ItemModelGenerators generator) {
            Identifier itemModel = SCALED2X.create(item, TextureMapping.singleSlot(TextureSlot.LAYER0, new Material(ModelLocationUtils.getModelLocation(item))), generator.modelOutput);
            generator.itemModelOutput.accept(item, ItemModelUtils.plainModel(itemModel));
        }
        public static void wide_frame(Item item, ItemModelGenerators generator) {
        Identifier itemModel = WIDE_FRAME.create(item, TextureMapping.singleSlot(TextureSlot.LAYER0, new Material(ModelLocationUtils.getModelLocation(item))), generator.modelOutput);
        generator.itemModelOutput.accept(item, ItemModelUtils.plainModel(itemModel));
        }

    public static void generateStormElytra(Item item, ItemModelGenerators generator) {
        ItemModel.Unbaked normal = ItemModelUtils.plainModel(Identifier.withDefaultNamespace("item/elytra"));
        ItemModel.Unbaked broken = ItemModelUtils.plainModel(Identifier.withDefaultNamespace("item/elytra_broken"));
        generator.generateBooleanDispatch(item, new Broken(), broken, normal);
    }

    public static void generateExterminationElytra(Item item, ItemModelGenerators generator) {
        ItemModel.Unbaked normal = ItemModelUtils.plainModel(Identifier.withDefaultNamespace("item/elytra"));
        ItemModel.Unbaked broken = ItemModelUtils.plainModel(Identifier.withDefaultNamespace("item/elytra_broken"));
        generator.generateBooleanDispatch(item, new Broken(), broken, normal);
    }

        //:::custom-item-datagen-method
        @SuppressWarnings("SameParameterValue")
        //:::custom-item-model:::
        private static ModelTemplate item(String parent, TextureSlot requiredTextureKeys) {
            return new ModelTemplate(Optional.of(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
        }

        //:::custom-item-model:::
    }

    @Override
    public String getName() {
        return "NOHONOR Mod Models Provider";
    }

}
