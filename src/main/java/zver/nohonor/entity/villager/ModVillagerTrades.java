package zver.nohonor.entity.villager;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.item.trading.VillagerTrades;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.item.ModItems;

import java.util.List;
import java.util.Optional;

public class ModVillagerTrades {
//==========================================================ФЕРМЕР===============================================================
    //                      формат имени:     ПРОФЕССИЯ_УРОВЕНЬ_ЗА-ЧТО_И-ЧТО=========тут аналогично, но это именно папки
    public static final ResourceKey<VillagerTrade> FARMER_1_EMERALD_BEAN = createKey("farmer/1/emerald_bean");
    public static final ResourceKey<VillagerTrade> FARMER_2_DIAMOND_RICE_SHOOT = createKey("farmer/2/diamond_rice_shoot");

//==========================================================КАМЕНЬЩИК==============================================================
    public static final ResourceKey<VillagerTrade> MASON_2_KHRAMOVAYA_STEEL_INGOT_EMERALD_POLISHED_KHRAMOVAYA_STONE = createKey("mason/2/khramovaya_steel_ingot_emerald_polished_khramovaya_stone");

//================================================БИБЛИОТЕКА БИБЛИОТЕКА===============================================================
    public static final ResourceKey<VillagerTrade> LIBRARIAN_1_LOTUS_EMERALD = createKey("librarian/1/pearl_lotus_emerald");
    public static final ResourceKey<VillagerTrade> LIBRARIAN_3_PEARL_GARANT_MENDING = createKey("librarian/3/pearl_garant_mending");

//====================================================СМИТ КУЗНЕЦ======================================================================
    public static final ResourceKey<VillagerTrade> COMMON_SMITH_2_PEARL_SILVER_INGOT_EMERALD = createKey("smith/2/pearl_silver_ingot_emerald");

//========================================================КЕЛЕРИК============================================================================
    public static final ResourceKey<VillagerTrade> CLERIC_5_KARELITE_INGOT_PEARL_GARANT = createKey("cleric/5/kaelite_ingot_pearl_garant");

//==================================================ТЯЖЕЛЫЙ КУЗНЕЦ======================================================================
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_1_BLACK_BONE_EMERALD = createKey("heavy_blacksmith/1/black_bone_emerald");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_1_BAUXITE_RAW_IRON = createKey("heavy_blacksmith/1/bauxite_raw_iron");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_2_CHARRED_STONE_EMERALD = createKey("heavy_blacksmith/2/charred_stone_emerald");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_2_GALENA_RAW_GOLD = createKey("heavy_blacksmith/2/galena_raw_gold");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_3_CAST_IRON_INGOT_CHARRED_STONE = createKey("heavy_blacksmith/3/cast_iron_ingot");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_3_SPODUMENE_BLACK_BONE = createKey("heavy_blacksmith/3/spodumene_black_bone");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_4_SHCHERBARUNE_PEARL_GARANT = createKey("heavy_blacksmith/4/shcherbarune_pearl_garant");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_4_LUMEL_INGOT_PEARL_GARANT = createKey("heavy_blacksmith/4/lumel_ingot_pearl_garant");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_5_PEARL_GARANT_NETHERITE_SCRAP = createKey("heavy_blacksmith/5/pearl_garant_netherite_scrap");
    public static final ResourceKey<VillagerTrade> HEAVY_BLACKSMITH_5_PEARL_GARANT_CAST_BULAT_INGOT = createKey("heavy_blacksmith/5/pearl_garant_cast_bulat_ingot");


//======================================================================================================================================
//======================================================================================================================================
    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantment = context.lookup(Registries.ENCHANTMENT);
//==========================================================ФЕРМЕР===============================================
        context.register(FARMER_1_EMERALD_BEAN, new VillagerTrade(
                new TradeCost(Items.EMERALD, 3),
                new ItemStackTemplate(ModItems.BEANS),
                12, 3, 0.01f,
                Optional.empty(), List.of()
        ));

        context.register(FARMER_2_DIAMOND_RICE_SHOOT, new VillagerTrade(
                new TradeCost(Items.DIAMOND, 6),
                new ItemStackTemplate(ModItems.RICE_SHOOT),
                6, 8, 0.05f,
                Optional.empty(), List.of()
        ));

//==========================================================КАМЕНЬЩИК=============================================
        context.register(MASON_2_KHRAMOVAYA_STEEL_INGOT_EMERALD_POLISHED_KHRAMOVAYA_STONE, new VillagerTrade(
                new TradeCost(ModItems.KHRAMOVAYA_STEEL_INGOT, 1),
                new ItemStackTemplate(ModBlocks.POLISHED_KHRAMOVAYA_STONE.asItem(), 12),
                4, 6, 0.05f,
                Optional.empty(), List.of()
        ));

//===================================================БИБЛИОТЕКА БИБЛИОТЕКА=======================================
        context.register(LIBRARIAN_1_LOTUS_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.LOTUS, 5),
                new ItemStackTemplate(Items.EMERALD, 1),
                12, 8, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(LIBRARIAN_3_PEARL_GARANT_MENDING, new VillagerTrade(
                new TradeCost(ModItems.PEARL_GARANT, 12),
                new ItemStackTemplate(Items.ENCHANTED_BOOK, 1),
                1, 24, 0.08f,
                Optional.empty(),
                VillagerTrades.enchantedBook(items,
                        HolderSet.direct(
                        enchantment.getOrThrow(Enchantments.MENDING
                        //enchantment.getOrThrow(Enchantments.BREACH))
                        )))

        ));

//======================================================СМИТ КУЗНЕЦ==============================================
        context.register(COMMON_SMITH_2_PEARL_SILVER_INGOT_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.PEARL_SILVER_INGOT, 7),
                new ItemStackTemplate(Items.EMERALD, 2),
                12, 8, 0.05f,
                Optional.empty(), List.of()
        ));

//=======================================================КЛЕРИК==================================================
        context.register(CLERIC_5_KARELITE_INGOT_PEARL_GARANT, new VillagerTrade(
                new TradeCost(ModItems.KARELITE_INGOT, 3),
                new ItemStackTemplate(ModItems.PEARL_GARANT, 1),
                16, 16, 0.06f,
                Optional.empty(), List.of()
        ));

//==================================================ТЯЖЕЛЫЙ КУЗНЕЦ==================================================
        context.register(HEAVY_BLACKSMITH_1_BAUXITE_RAW_IRON, new VillagerTrade(
                new TradeCost(ModItems.BAUXITE, 7),
                new ItemStackTemplate(Items.RAW_IRON, 1),
                12, 16, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_1_BLACK_BONE_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.BLACK_BONE, 5),
                new ItemStackTemplate(Items.EMERALD, 2),
                16, 8, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_2_CHARRED_STONE_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.CHARRED_STONE, 2),
                new ItemStackTemplate(Items.EMERALD, 1),
                16, 16, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_2_GALENA_RAW_GOLD, new VillagerTrade(
                new TradeCost(ModItems.GALENA, 9),
                new ItemStackTemplate(Items.RAW_GOLD, 2),
                16, 18, 0.06f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_3_CAST_IRON_INGOT_CHARRED_STONE, new VillagerTrade(
                new TradeCost(ModItems.CAST_IRON_INGOT, 3),
                new ItemStackTemplate(ModItems.CHARRED_STONE, 2),
                16, 8, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_3_SPODUMENE_BLACK_BONE, new VillagerTrade(
                new TradeCost(ModItems.SPODUMENE, 3),
                new ItemStackTemplate(ModItems.BLACK_BONE, 1),
                16, 8, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_4_LUMEL_INGOT_PEARL_GARANT, new VillagerTrade(
                new TradeCost(ModItems.LUMEL_INGOT, 20),
                new ItemStackTemplate(ModItems.PEARL_GARANT, 1),
                32, 20, 0.03f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_4_SHCHERBARUNE_PEARL_GARANT, new VillagerTrade(
                new TradeCost(ModItems.SHCHERBARUNE, 22),
                new ItemStackTemplate(ModItems.PEARL_GARANT, 1),
                32, 20, 0.03f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_5_PEARL_GARANT_NETHERITE_SCRAP, new VillagerTrade(
                new TradeCost(ModItems.PEARL_GARANT, 61),
                new ItemStackTemplate(Items.NETHERITE_SCRAP, 1),
                4, 18, 0.05f,
                Optional.empty(), List.of()
        ));

        context.register(HEAVY_BLACKSMITH_5_PEARL_GARANT_CAST_BULAT_INGOT, new VillagerTrade(
                new TradeCost(ModItems.PEARL_GARANT, 60),
                new ItemStackTemplate(ModItems.CAST_BULAT_INGOT, 1),
                8, 16, 0.05f,
                Optional.empty(), List.of()
        ));

    }



    private static ResourceKey<VillagerTrade> createKey(String name) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
    }

}
