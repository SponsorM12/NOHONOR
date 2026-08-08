package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.block.custom.ModBerryBushBlocks;
import zver.nohonor.block.custom.ModCropBlocks;
import zver.nohonor.block.custom.ModWaterCropBlocks;
import zver.nohonor.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected ModBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //Это нужно чтобы зачарования типа foutune работали
        //enchantments
        var enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        //Holder<Enchantment> fortune = this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);

//=============================================ПРОСТЫЕ БЛОКИ=======================================
        dropSelf(ModBlocks.MEGAHAROSH_BLOCK);
        dropSelf(ModBlocks.LEDLAMP);
        dropSelf(ModBlocks.PLUSHE_SHARK);
        dropSelf(ModBlocks.PLUSHE_WHALE);

        dropSelf(ModBlocks.KHRAMOVAYA_STONE_STAIRS);
        //dropSelf(ModBlocks.KHRAMOVAYA_STONE_SLAB);
        add(ModBlocks.KHRAMOVAYA_STONE_SLAB, createSlabItemTable(ModBlocks.KHRAMOVAYA_STONE_SLAB));
        dropSelf(ModBlocks.KHRAMOVAYA_STONE_WALL);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS);
        add(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB, createSlabItemTable(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB)); //Для слаб используем только криейтСлаб
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON);
        //dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB);
        dropSelf(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB));
        //dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL);
        dropSelf(ModBlocks.CUT_KHRAMOVAYA_STONE);
        dropSelf(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS);
        dropSelf(ModBlocks.KHRAMOVAYA_STONE_BRICKS);
        dropSelf(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS);
        dropSelf(ModBlocks.KHRAMOVAYA_STONE_LAMP);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS);
        add(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB, createSlabItemTable(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB));
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS);
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS);
        add(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB));
        dropSelf(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL);
        dropSelf(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE);
        dropSelf(ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP);

//=============================================КАМЕНЬ============================================
        dropSelf(ModBlocks.KHRAMOVAYA_STONE);

//=============================================РУДА==============================================
        add(ModBlocks.PYRITE_ORE, createMultipleOreDrops(ModBlocks.PYRITE_ORE, ModItems.PYRITE, 1.0f, 2.0f));
        add(ModBlocks.DEEPSLATE_PYRITE_ORE, createMultipleOreDrops(ModBlocks.DEEPSLATE_PYRITE_ORE, ModItems.PYRITE, 1.0f, 2.0f));
        add(ModBlocks.GALENA_ORE, createOreDrop(ModBlocks.GALENA_ORE, ModItems.GALENA));
        add(ModBlocks.DEEPSLATE_GALENA_ORE, createOreDrop(ModBlocks.DEEPSLATE_GALENA_ORE, ModItems.GALENA));
        add(ModBlocks.BAUXITE_ORE, createOreDrop(ModBlocks.BAUXITE_ORE, ModItems.BAUXITE));
        add(ModBlocks.DEEPSLATE_BAUXITE_ORE, createOreDrop(ModBlocks.DEEPSLATE_BAUXITE_ORE, ModItems.BAUXITE));
        add(ModBlocks.SPODUMENE_ORE, createOreDrop(ModBlocks.SPODUMENE_ORE, ModItems.SPODUMENE));
        add(ModBlocks.DEEPSLATE_SPODUMENE_ORE, createOreDrop(ModBlocks.DEEPSLATE_SPODUMENE_ORE, ModItems.SPODUMENE));
        add(ModBlocks.NETHER_LUMEL_ORE, createOreDrop(ModBlocks.NETHER_LUMEL_ORE, ModItems.RAW_LUMEL));
        add(ModBlocks.NETHER_SHCHERBARUNE_ORE, createOreDrop(ModBlocks.NETHER_SHCHERBARUNE_ORE, ModItems.RAW_SHCHERBARUNE));
        add(ModBlocks.END_STONE_BISMUTH_ORE, createMultipleOreDrops(ModBlocks.END_STONE_BISMUTH_ORE, ModItems.RAW_BISMUTH, 3.0f, 6.0f));

//============================================САПЛИНГ==============================================
        dropSelf(ModBlocks.HESPERIDES_SAPLING);
        this.add(ModBlocks.POTTED_HESPERIDES_SAPLING,
                this.createPotFlowerItemTable(ModBlocks.HESPERIDES_SAPLING));


//===========================================ЛИСТЬЯ================================================
        //add(ModBlocks.HESPERIDES_LEAVES, createSilkTouchOrShearsDispatchTable(
        //        ModBlocks.HESPERIDES_LEAVES,
        //        LootItem.lootTableItem(Items.STICK)
        //                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
        //));
        add(ModBlocks.HESPERIDES_LEAVES, createLeavesDrops(
                ModBlocks.HESPERIDES_LEAVES,
                ModBlocks.HESPERIDES_SAPLING,
                NORMAL_LEAVES_SAPLING_CHANCES
        ).withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(this.doesNotHaveShearsOrSilkTouch())
                .add(this.applyExplosionDecay(ModBlocks.HESPERIDES_LEAVES, LootItem.lootTableItem(Items.GOLDEN_APPLE))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                enchantments.getOrThrow(Enchantments.FORTUNE),
                                0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F
                        ))
                )
        ));

        dropSelf(ModBlocks.HESPERIDES_LOG);
        dropSelf(ModBlocks.HESPERIDES_WOOD);
        dropSelf(ModBlocks.STRIPPED_HESPERIDES_LOG);
        dropSelf(ModBlocks.STRIPPED_HESPERIDES_WOOD);
        dropSelf(ModBlocks.HESPERIDES_PLANKS);
        dropSelf(ModBlocks.HESPERIDES_STAIRS);
        add(ModBlocks.HESPERIDES_SLAB, createSlabItemTable(ModBlocks.HESPERIDES_SLAB));
        //dropSelf(ModBlocks.HESPERIDES_SLAB);
        dropSelf(ModBlocks.HESPERIDES_FENCE);
        dropSelf(ModBlocks.HESPERIDES_FENCE_GATE);
        add(ModBlocks.HESPERIDES_DOOR, createDoorTable(ModBlocks.HESPERIDES_DOOR)); //Для дорс отдельный генератор
        dropSelf(ModBlocks.HESPERIDES_TRAPDOOR);
        dropSelf(ModBlocks.HESPERIDES_PRESSURE_PLATE);
        dropSelf(ModBlocks.HESPERIDES_BUTTON);
        dropSelf(ModBlocks.HESPERIDES_SHELF);
        dropSelf(ModBlocks.HESPERIDES_SIGN);
        dropSelf(ModBlocks.HESPERIDES_HANGING_SIGN);

        //dropSelf(ModBlocks.GOLDEN_PETALS);
        //смотри не в датагене
        //ручная генерация луттейбла

//====================================================КРОПС===================================================================
        this.add(ModBlocks.MERCURILLIA_CROP, this.createCropDrops(ModBlocks.MERCURILLIA_CROP, ModItems.FRUM_FRUM, ModItems.MERCURILLIA_SEEDS,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.MERCURILLIA_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlocks.AGE, ModCropBlocks.MAX_AGE))));

        this.add(ModBlocks.BEAN_CROP, this.createCropDrops(ModBlocks.BEAN_CROP, ModItems.BEANS, ModItems.BEAN_POD,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BEAN_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlocks.AGE, ModCropBlocks.MAX_AGE))));

        //this.add(ModBlocks.RICE_CROP, this.createCropDrops(ModBlocks.RICE_CROP, ModItems.RICE_SHOOT, ModItems.RICE_SHOOT,
        //        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RICE_CROP)
        //                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModWaterCropBlocks.AGE, ModWaterCropBlocks.MAX_AGE))));
        this.add(ModBlocks.RICE_CROP, this.applyExplosionDecay(ModBlocks.RICE_CROP,
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                LootItem.lootTableItem(ModItems.RICE_SHOOT)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RICE_CROP)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(ModWaterCropBlocks.AGE, ModWaterCropBlocks.MAX_AGE)))
                        )
                )
        ));

        this.add(ModBlocks.LOTUS_CROP, this.applyExplosionDecay(ModBlocks.LOTUS_CROP,
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                LootItem.lootTableItem(ModItems.LOTUS)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LOTUS_CROP)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(ModWaterCropBlocks.AGE, ModWaterCropBlocks.MAX_AGE)))
                        )
                )
        ));

        this.add(ModBlocks.ADVACADO_CROP, this.applyExplosionDecay(ModBlocks.ADVACADO_CROP,
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                LootItem.lootTableItem(ModItems.ADVACADO)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ADVACADO_CROP)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(ModWaterCropBlocks.AGE, ModWaterCropBlocks.MAX_AGE)))
                        )
                )
        ));

        this.add(ModBlocks.YELLOW_ARKADY_CROP, this.applyExplosionDecay(ModBlocks.YELLOW_ARKADY_CROP,
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                LootItem.lootTableItem(ModItems.YELLOW_ARKADY_THORN)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.YELLOW_ARKADY_CROP)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(ModWaterCropBlocks.AGE, ModWaterCropBlocks.MAX_AGE)))
                        )
                )
        ));


        dropSelf(ModBlocks.RICE_STEM);
        dropSelf(ModBlocks.LOTUS_STEM);
        dropSelf(ModBlocks.ADVACADO_STEM);
        dropSelf(ModBlocks.YELLOW_ARKADY_STEM);

//=====================================================БЕРРИ БУШ КУСТ==================================================
        this.add(ModBlocks.GREEN_APPLE_BERRY_BUSH, (block) -> (LootTable.Builder)
                this.applyExplosionDecay(block, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GREEN_APPLE_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(ModBerryBushBlocks.AGE, 3)))
                                .add(LootItem.lootTableItem(ModItems.GREEN_APPLE))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(ModBlocks.GREEN_APPLE_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(ModBerryBushBlocks.AGE, 2)))
                                .add(LootItem.lootTableItem(ModItems.GREEN_APPLE))
                                .apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))));

        this.add(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH, (block) -> (LootTable.Builder)
                this.applyExplosionDecay(block, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(ModBerryBushBlocks.AGE, 3)))
                                .add(LootItem.lootTableItem(ModItems.MAKOSH_BERRIES))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(ModBerryBushBlocks.AGE, 2)))
                                .add(LootItem.lootTableItem(ModItems.MAKOSH_BERRIES))
                                .apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))));

    }

//================================================================================================================================================
    //Кастомный генератор
    //Умножение Орес
    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return  this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))
        ));
    }

}