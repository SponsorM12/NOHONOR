package zver.nohonor.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import zver.nohonor.item.ModItems;

public class ModLootTableModifiers {
//Модификация луттейблов начниая от мобов и заканчивая даже сундуками
//=========================================КЛЮЧИ МОБЫ=========================================================
    private static final ResourceKey<LootTable> WITHER_SKELETON =
            ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/wither_skeleton"));

    private static final ResourceKey<LootTable> MAGMA_CUBE =
            ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/magma_cube"));

    private static final ResourceKey<LootTable> WARDEN =
            ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/warden"));

    // private static final ResourceKey<LootTable> ZOMBIE =
    //         ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/zombie"));

    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
//==============================================СУНДУКИ==============================================================
            //КЛАД
            if (key.equals(BuiltInLootTables.BURIED_TREASURE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.SEA_STONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))).setQuality(2).setWeight(3))
                        .add(EmptyLootItem.emptyItem().setWeight(1))
                );
            }
            //ДЖАНГЛ
            if (key.equals(BuiltInLootTables.JUNGLE_TEMPLE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLACK_RESIN_CLUMP)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .setQuality(2))
                );
            }
            //CОКРОВИЩНИЦА
            if (key.equals(BuiltInLootTables.SIMPLE_DUNGEON)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1, 2)) // случайно 1, 2, 3 или 4 броска
                        .add(LootItem.lootTableItem(Items.GOLD_BLOCK).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.KARELITE_INGOT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setQuality(2).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.PEARL_GARANT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setQuality(2).setWeight(3))
                );
            }
            //ЭНД ГОРОД
            if (key.equals(BuiltInLootTables.END_CITY_TREASURE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.RAW_BISMUTH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setQuality(2).setWeight(2))
                        .add(EmptyLootItem.emptyItem().setWeight(1))
                );
            }
            //ТРАЙЛ ЧЕМБЕРС
            //BuiltInLootTables.TRIAL_CHAMBERS_REWARD,
            //			LootTable.lootTable()
            //				.withPool(
            //					LootPool.lootPool()
            //						.setRolls(ConstantValue.exactly(1.0F))
            //						.add(NestedLootTable.lootTableReference(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE).setWeight(8))
            //						.add(NestedLootTable.lootTableReference(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON).setWeight(2))
            //				)
            //				.withPool(
            //					LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(NestedLootTable.lootTableReference(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON))
            //				)
            //				.withPool(
            //					LootPool.lootPool()
            //						.setRolls(ConstantValue.exactly(1.0F))
            //						.when(LootItemRandomChanceCondition.randomChance(0.25F))
            //						.add(NestedLootTable.lootTableReference(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE))
            //				)

//
            if (key.equals(BuiltInLootTables.SPAWNER_TRIAL_CHAMBER_CONSUMABLES)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.PEARL_GARANT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(19))
                );
            }

            //if (key.equals(BuiltInLootTables.SPAWNER_TRIAL_ITEMS_TO_DROP_WHEN_OMINOUS)) {
            //    tableBuilder.withPool(LootPool.lootPool()
            //    );
            //}


            // Вместо TRIAL_CHAMBERS_REWARD добавляем в REWARD_RARE
            if (key.equals(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.PEARL_GARANT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(19))
                );
            }

            if (key.equals(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.PEARL_TITAN)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(24))
                );
            }


//===============================================МОБЫ=====================================================
            //ВИЗЕР СКЕЛЕТ
            if (key.equals(WITHER_SKELETON)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLACK_BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                );
            }
            //МАГМА КУБ
            if (key.equals(MAGMA_CUBE)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.CHARRED_STONE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                );
            }

            //ВАРДЕН
            if (key.equals(WARDEN)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.ECHO_SHARD)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(1))
                );
            }

        });
    }
}