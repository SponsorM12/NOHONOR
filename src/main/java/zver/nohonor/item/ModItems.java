package zver.nohonor.item;

import net.minecraft.util.Unit;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.entity.boat.ModBoats;
import zver.nohonor.fluid.ModFluids;
import zver.nohonor.item.custom.pearl_silver.PearlSilverAxeItem;
import zver.nohonor.item.custom.pearl_silver.PearlSilverSwordItem;
import zver.nohonor.item.custom.TenacityFoodItem;
import zver.nohonor.item.custom.pearl_silver.PearlSilverMaceItem;
import zver.nohonor.sound.ModJukeboxSongs;
import static zver.nohonor.utilit.TooltipHelper.*;

import java.util.function.Function;

//ПОРЯДОК СОЗДАНИЯ ПРОСТОГО ПРЕДМЕТА ЧТОБ НЕ ЗАБЫТь
//делаем:
//  public static final Item ИМЯ_КАПСОМ = registerItem("имя_мелко", Item::new, new Item.Properties());
//далее идем в ModModelProvider, там:
//  itemModelGenerators.generateFlatItem(ModItems.ИМЯ_КАПСОМ, ModelTemplates.FLAT_ITEM);
//далее идем в каталог lang, добовляем перевод
//Если нужно сделать с описанием, добовляем properties -> new ModTooltipItems("item.nohonor.имя_мелко.desc", properties):
//  public static final Item ИМЯ КАПСОМ = registerItem("имя_мелко",properties -> new ModTooltipItems("item.nohonor.имя_мелко.desc", properties),new Item.Properties());

public class ModItems {

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

//==========================================ДЛЯ АЧИВОК===============================================
    public static final Item BLESSING = registerItem(
            "blessing",properties -> new ModTooltipItems("item.nohonor.blessing.desc", properties),
            new Item.Properties().rarity(Rarity.EPIC));

//==========================================МАТЕРИАЛЫ============================================
    public static final Item SEA_STONE = registerItem(
            "sea_stone",properties -> new ModTooltipItems("item.nohonor.sea_stone.desc", properties),
            new Item.Properties().rarity(Rarity.RARE));

    public static final Item YELLOW_ARKADY_THORN = registerItem(
            "yellow_arkady_thorn",Item::new, new Item.Properties()
    );

    public static final Item YELLOW_ARKADY_TRUNK = registerItem(
            "yellow_arkady_trunk",
            properties -> new BlockItem(ModBlocks.YELLOW_ARKADY_STEM, properties),
            new Item.Properties()
    );

    public static final Item BLACK_BONE = registerItem(
            "black_bone", Item::new, new Item.Properties());

    public static final Item CHARRED_STONE = registerItem(
            "charred_stone", Item::new, new Item.Properties()
                    .fireResistant()
    );

    public static final Item PYRITE = registerItem(
            "pyrite", Item::new, new Item.Properties());

    public static final Item GALENA = registerItem(
            "galena",properties -> new ModTooltipItems("item.nohonor.galena.desc", properties),
            new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item BAUXITE = registerItem(
            "bauxite",properties -> new ModTooltipItems("item.nohonor.bauxite.desc", properties),
            new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item SPODUMENE = registerItem(
            "spodumene",properties -> new ModTooltipItems("item.nohonor.spodumene.desc", properties),
            new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item BLACK_RESIN_CLUMP = registerItem(
            "black_resin_clump",
            properties -> new ModTooltipItems("item.nohonor.black_resin_clump.desc", properties),
            new Item.Properties()
                    .food(ModFoods.BLANK_FOOD)
    );

    public static final Item PEOV = registerItem(
            "peov", Item::new, new Item.Properties());

    public static final Item ION_SPHERE = registerItem(
            "ion_sphere",
            properties -> new ModTooltipItems("item.nohonor.ion_sphere.desc", 2, properties),
            new Item.Properties()
                    .stacksTo(1)
    );

    public static final Item FRUM_FRUM = registerItem(
            "frum_frum",
            properties -> new ModTooltipItems("item.nohonor.frum_frum.desc", properties),
            new Item.Properties()
                    .food(ModFoods.FRUM_FRUM, ModFoods.FRUM_FRUM_CONSUMABLE)
    );

    public static final Item LOTUS = registerItem(
            "lotus",
            properties -> new BlockItem(ModBlocks.LOTUS_STEM, properties),
            new Item.Properties()
    );

    public static final Item BISMUTHIN = registerItem(
            "bismuthin", Item::new, new Item.Properties());

    public static final Item BISMUTH_SYNTHETIC = registerItem(
            "bismuth_synthetic", Item::new, new Item.Properties());

    public static final Item KERASENE = registerItem(
            "kerasene", Item::new, new Item.Properties());

    public static final Item DISENTGILIL = registerItem(
            "disentgilil", Item::new, new Item.Properties());

    public static final Item FAZAMISANTROL = registerItem(
            "fazamisantrol", Item::new, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
    );

    public static final Item AUERIENNE = registerItem(
            "auerienne", Item::new, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
    );

//=============================================ВАЛЮТА==========================================
    public static final Item PEARL_GARANT = registerItem(
            "pearl_garant", Item::new, new Item.Properties());

    public static final Item PEARL_TITAN = registerItem(
            "pearl_titan", Item::new, new Item.Properties());

//=========================================МЕТАЛЛ + МАТЕРИАЛЫ==========================================

    public static final Item RAW_CAST_IRON = registerItem(
            "raw_cast_iron", Item::new, new Item.Properties());

    public static final Item CAST_IRON_INGOT = registerItem(
            "cast_iron_ingot", Item::new, new Item.Properties());

    public static final Item CAST_IRON_NUGGET = registerItem(
            "cast_iron_nugget", Item::new, new Item.Properties());

    public static final Item RAW_WHITE_CAST_IRON = registerItem(
            "raw_white_cast_iron", Item::new, new Item.Properties());

    public static final Item WHITE_CAST_IRON_INGOT = registerItem(
            "white_cast_iron_ingot", Item::new, new Item.Properties());

    public static final Item WHITE_CAST_IRON_NUGGET = registerItem(
            "white_cast_iron_nugget", Item::new, new Item.Properties());

    public static final Item RAW_MALLEABLE_CAST_IRON = registerItem(
            "raw_malleable_cast_iron", Item::new, new Item.Properties());

    public static final Item MALLEABLE_CAST_IRON_INGOT = registerItem(
            "malleable_cast_iron_ingot", Item::new, new Item.Properties());

    public static final Item MALLEABLE_CAST_IRON_NUGGET = registerItem(
            "malleable_cast_iron_nugget", Item::new, new Item.Properties());

    public static final Item RAW_UKLAD = registerItem(
            "raw_uklad", Item::new, new Item.Properties());

    public static final Item UKLAD_INGOT = registerItem(
            "uklad_ingot", Item::new, new Item.Properties());

    public static final Item UKLAD_NUGGET = registerItem(
            "uklad_nugget", Item::new, new Item.Properties());

    public static final Item RAW_CAST_BULAT = registerItem(
            "raw_cast_bulat", Item::new, new Item.Properties());

    public static final Item CAST_BULAT_INGOT = registerItem(
            "cast_bulat_ingot", Item::new, new Item.Properties());

    public static final Item CAST_BULAT_NUGGET = registerItem(
            "cast_bulat_nugget", Item::new, new Item.Properties());

    public static final Item RAW_PLYMBLUM = registerItem("raw_plymblum",
            props -> new ModTooltipItems(MEDIUM_PURPLE, props),
            new Item.Properties()
    );

    public static final Item PLYMBLUM_INGOT = registerItem("plymblum_ingot",
            props -> new ModTooltipItems(MEDIUM_PURPLE, props),
            new Item.Properties()
    );

    public static final Item PLYMBLUM_NUGGET = registerItem("plymblum_nugget",
            props -> new ModTooltipItems(MEDIUM_PURPLE, props),
            new Item.Properties()
    );

    public static final Item RAW_PEARL_SILVER = registerItem(
            "raw_pearl_silver",properties -> new ModTooltipItems("item.nohonor.raw_pearl_silver.desc", 1, LAVENDER, properties),
            new Item.Properties()
    );

    public static final Item PEARL_SILVER_INGOT = registerItem("pearl_silver_ingot",
            props -> new ModTooltipItems(LAVENDER, props),
            new Item.Properties()
    );

    public static final Item PEARL_SILVER_NUGGET = registerItem("pearl_silver_nugget",
            props -> new ModTooltipItems(LAVENDER, props),
            new Item.Properties()
    );

    public static final Item RAW_ZUBETS = registerItem("raw_zubets",
            props -> new ModTooltipItems(EDWARD, props),
            new Item.Properties()
    );

    public static final Item ZUBETS_INGOT = registerItem("zubets_ingot",
            props -> new ModTooltipItems(EDWARD, props),
            new Item.Properties()
    );

    public static final Item ZUBETS_NUGGET = registerItem("zubets_nugget",
            props -> new ModTooltipItems(EDWARD, props),
            new Item.Properties()
    );

    public static final Item RAW_GLINIY = registerItem("raw_gliniy",
            props -> new ModTooltipItems(SUBMARINE, props),
            new Item.Properties()
    );

    public static final Item GLINIY_INGOT = registerItem("gliniy_ingot",
            props -> new ModTooltipItems(SUBMARINE, props),
            new Item.Properties()
    );

    public static final Item GLINIY_NUGGET = registerItem("gliniy_nugget",
            props -> new ModTooltipItems(SUBMARINE, props),
            new Item.Properties()
    );

    public static final Item RAW_TITANIUM = registerItem("raw_titanium",
            props -> new ModTooltipItems(CHETWODE, props),
            new Item.Properties()
    );

    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",
            props -> new ModTooltipItems(CHETWODE, props),
            new Item.Properties()
    );

    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget",
            props -> new ModTooltipItems(CHETWODE, props),
            new Item.Properties()
    );

    public static final Item RAW_LYUTYY = registerItem("raw_lyutyy",
            props -> new ModTooltipItems(HOPBUSH, props),
            new Item.Properties()
    );

    public static final Item LYUTYY_INGOT = registerItem("lyutyy_ingot",
            props -> new ModTooltipItems(HOPBUSH, props),
            new Item.Properties()
    );

    public static final Item LYUTYY_NUGGET = registerItem("lyutyy_nugget",
            props -> new ModTooltipItems(HOPBUSH, props),
            new Item.Properties()
    );

    public static final Item RAW_CHROMIUM = registerItem("raw_chromium",
            props -> new ModTooltipItems(PERFUME, props),
            new Item.Properties()
    );

    public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot",
            props -> new ModTooltipItems(PERFUME, props),
            new Item.Properties()
    );

    public static final Item CHROMIUM_NUGGET = registerItem("chromium_nugget",
            props -> new ModTooltipItems(PERFUME, props),
            new Item.Properties()
    );

    public static final Item RAW_LUMEL = registerItem(
            "raw_lumel",properties -> new ModTooltipItems("item.nohonor.raw_lumel.desc", 1, COLUMBIA, properties), new Item.Properties()
                    //.rarity(Rarity.RARE)
                    .fireResistant()
    );


    public static final Item LUMEL_INGOT = registerItem("lumel_ingot",
            props -> new ModTooltipItems(COLUMBIA, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item LUMEL_NUGGET = registerItem("lumel_nugget",
            props -> new ModTooltipItems(COLUMBIA, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item RAW_SHCHERBARUNE = registerItem("raw_shcherbarune",
            props -> new ModTooltipItems("item.nohonor.raw_shcherbarune.desc", 1, ILLUSION, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item SHCHERBARUNE = registerItem("shcherbarune",
            props -> new ModTooltipItems(ILLUSION, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item SHCHERBARUNE_SHARD = registerItem("shcherbarune_shard",
            props -> new ModTooltipItems(ILLUSION, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item RAW_BISMUTH = registerItem("raw_bismuth",
            props -> new ModTooltipItems("item.nohonor.raw_bismuth.desc", 1, VISTA, props),
            new Item.Properties()
    );

    public static final Item BISMUTH = registerItem("bismuth",
            props -> new ModTooltipItems(VISTA, props),
            new Item.Properties()
    );

    public static final Item BISMUTH_NUGGET = registerItem("bismuth_nugget",
            props -> new ModTooltipItems(VISTA, props),
            new Item.Properties()
    );

//=========================================СПЛАВЫ=============================================
    public static final Item RAW_KOLDOVSKAYA_BRASS = registerItem("raw_koldovskaya_brass",
            props -> new ModTooltipItems(CARAMEL, props),
            new Item.Properties()
    );

    public static final Item KOLDOVSKAYA_BRASS_INGOT = registerItem("koldovskaya_brass_ingot",
            props -> new ModTooltipItems(CARAMEL, props),
            new Item.Properties()
    );

    public static final Item KOLDOVSKAYA_BRASS_NUGGET = registerItem("koldovskaya_brass_nugget",
            props -> new ModTooltipItems(CARAMEL, props),
            new Item.Properties()
    );

    public static final Item RAW_KARELITE = registerItem("raw_karelite",
            props -> new ModTooltipItems(GOLD, props),
            new Item.Properties()
    );

    public static final Item KARELITE_INGOT = registerItem("karelite_ingot",
            props -> new ModTooltipItems(GOLD, props),
            new Item.Properties()
    );

    public static final Item KARELITE_NUGGET = registerItem("karelite_nugget",
            props -> new ModTooltipItems(GOLD, props),
            new Item.Properties()
    );

    public static final Item RAW_KHRAMOVAYA_STEEL = registerItem("raw_khramovaya_steel",
            props -> new ModTooltipItems(CUMULUS, props),
            new Item.Properties()
    );

    public static final Item KHRAMOVAYA_STEEL_INGOT = registerItem("khramovaya_steel_ingot",
            props -> new ModTooltipItems(CUMULUS, props),
            new Item.Properties()
    );

    public static final Item KHRAMOVAYA_STEEL_NUGGET = registerItem("khramovaya_steel_nugget",
            props -> new ModTooltipItems(CUMULUS, props),
            new Item.Properties()
    );

    public static final Item RAW_VIVARIUM = registerItem(
            "raw_vivarium",properties -> new ModTooltipItems("item.nohonor.raw_vivarium.desc", 2, MARGUERITE, properties), new Item.Properties()
                    .fireResistant()
    );

    public static final Item VIVARIUM_INGOT = registerItem("vivarium_ingot",
            props -> new ModTooltipItems(MARGUERITE, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item VIVARIUM_NUGGET = registerItem("vivarium_nugget",
            props -> new ModTooltipItems(MARGUERITE, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item RAW_HELLESTEROY = registerItem(
            "raw_hellesteroy",properties -> new ModTooltipItems("item.nohonor.raw_hellesteroy.desc", 1, CASABLANCA, properties), new Item.Properties()
                    .fireResistant()
    );

    public static final Item HELLESTEROY_INGOT = registerItem("hellesteroy_ingot",
            props -> new ModTooltipItems(CASABLANCA, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item HELLESTEROY_NUGGET = registerItem("hellesteroy_nugget",
            props -> new ModTooltipItems(CASABLANCA, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item RAW_DURANSTEEL = registerItem(
            "raw_duransteel",properties -> new ModTooltipItems("item.nohonor.raw_duransteel.desc", 1, ORCHID, properties), new Item.Properties()
                    .fireResistant()
    );

    public static final Item DURANSTEEL_INGOT = registerItem("duransteel_ingot",
            props -> new ModTooltipItems(ORCHID, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item DURANSTEEL_NUGGET = registerItem("duransteel_nugget",
            props -> new ModTooltipItems(ORCHID, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item RAW_NOUS = registerItem(
            "raw_nous",properties -> new ModTooltipItems("item.nohonor.raw_nous.desc", 1, LIPSTICK, properties), new Item.Properties()
                    .fireResistant()
    );

    public static final Item NOUS_INGOT = registerItem("nous_ingot",
            props -> new ModTooltipItems(LIPSTICK, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item NOUS_NUGGET = registerItem("nous_nugget",
            props -> new ModTooltipItems(LIPSTICK, props),
            new Item.Properties()
                    .fireResistant()
    );
//СЮДА!!!!!!!!!!!!!!!!!!
//СЮДА!!!!!!!!!!!!!!!!!!
//СЮДА!!!!!!!!!!!!!!!!!!
    public static final Item STAR_IRON_INGOT = registerItem("star_iron_ingot",
            props -> new ModTooltipItems(PERANO, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item STAR_IRON_NUGGET = registerItem("star_iron_nugget",
            props -> new ModTooltipItems(PERANO, props),
            new Item.Properties()
                    .fireResistant()
    );

//===========================================СОКРОВИЩА+=============================================
    public static final Item GOLDEN_KEY = registerItem("golden_key",
            props -> new ModTooltipItems(GOLD, props),
            new Item.Properties()
    );

    public static final Item STAR_KEY = registerItem("star_key",
            props -> new ModTooltipItems(PERANO, props),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item SYMBOL_OF_THE_UNIVERSE = registerItem("symbol_of_the_universe",
            props -> new ModTooltipItems(PERANO, props),
            new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
    );

//==============================================ЕДА=================================================
    public static final Item NUTRITIONAL_JELLY = registerItem(
            "nutritional_jelly",
            properties -> new ModTooltipItems("item.nohonor.nutritional_jelly.desc", 2, properties),
            new Item.Properties()
                    .food(ModFoods.NUTRITIONAL_JELLY, ModFoods.NUTRITIONAL_JELLY_CONSUMABLE)
    );

    public static final Item HEARTY_JELLY = registerItem(
            "hearty_jelly",
            properties -> new ModTooltipItems("item.nohonor.hearty_jelly.desc", properties),
            new Item.Properties()
                    .food(ModFoods.HEARTY_JELLY, ModFoods.HEARTY_JELLY_CONSUMABLE)
    );

    public static final Item ROTTEN_JELLY = registerItem(
            "rotten_jelly",
            properties -> new ModTooltipItems("item.nohonor.rotten_jelly.desc", properties),
            new Item.Properties()
                    .food(ModFoods.ROTTEN_JELLY, ModFoods.ROTTEN_JELLY_CONSUMABLE)
    );

    public static final Item SPOILED_JELLY = registerItem(
            "spoiled_jelly",
            properties -> new ModTooltipItems("item.nohonor.spoiled_jelly.desc", properties),
            new Item.Properties()
                    .food(ModFoods.SPOILED_JELLY, ModFoods.SPOILED_JELLY_CONSUMABLE)
    );

    public static final Item GREEN_APPLE = registerItem(
            "green_apple",
            properties -> new BlockItem(ModBlocks.GREEN_APPLE_BERRY_BUSH, properties),
            new Item.Properties()
                    .food(ModFoods.GREEN_APPLE)
    );

    public static final Item MAKOSH_BERRIES = registerItem(
            "makosh_berries",
            properties -> new BlockItem(ModBlocks.MAKOSH_BERRIES_BERRY_BUSH, properties),
            new Item.Properties()
                    .food(ModFoods.MAKOSH_BERRIES, ModFoods.MAKOSH_BERRIES_CONSUMABLE)
    );

    public static final Item SHAWARMA = registerItem(
            "shawarma", Item::new, new Item.Properties()
                    .food(ModFoods.SHAWARMA, ModFoods.SHAWARMA_CONSUMABLE)
    );

    public static final Item RICE_SHOOT = registerItem(
            "rice_shoot",
            properties -> new BlockItem(ModBlocks.RICE_STEM, properties),
            new Item.Properties()
                    .food(ModFoods.RICE_SHOOT)
    );

    public static final Item RICE = registerItem(
            "rice",
            properties -> new TenacityFoodItem(properties, 1f),
            new Item.Properties()
                    .food(ModFoods.RICE, ModFoods.RICE_CONSUMABLE)
    );

    public static final Item BEAN_POD = registerItem(
            "bean_pod",
            properties -> new BlockItem(ModBlocks.BEAN_CROP, properties),
            new Item.Properties()
    );

    public static final Item BEANS = registerItem(
            "beans",
            properties -> new TenacityFoodItem(properties, 1f),
            new Item.Properties()
                    .food(ModFoods.BLANK_FOOD, ModFoods.BEANS_CONSUMABLE)
    );

    public static final Item ADVACADO = registerItem(
            "advacado",
            properties -> new TenacityFoodItem(properties, 5f),
            new Item.Properties()
                    .food(ModFoods.ADVACADO, ModFoods.ADVACADO_COMSUMABLE)
                    .fireResistant()
    );

    public static final Item ADVACADO_SEED = registerItem(
            "advacado_seed",
            properties -> new BlockItem(ModBlocks.ADVACADO_STEM, properties),
            new Item.Properties()
                    .fireResistant()
    );

    public static final Item ONIGIRI = registerItem(
            "onigiri",
            properties -> new TenacityFoodItem(properties, 6f),
            new Item.Properties().food(ModFoods.ONIGIRI, ModFoods.ONIGIRI_CONSUMABLE)
    );

    public static final Item SUSHI = registerItem(
            "sushi",
            properties -> new TenacityFoodItem(properties, 3f),
            new Item.Properties().food(ModFoods.SUSHI, ModFoods.SUSHI_CONSUMABLE)
    );

    public static final Item MEBER_APPLE = registerItem(
            "meber_apple",
            properties -> new TenacityFoodItem(properties, 8f),
            new Item.Properties()
                    .food(ModFoods.MEBER_APPLE, ModFoods.MEBER_APPLE_CONSUMABLE)
    );

    public static final Item SPACE_WATERMELON = registerItem(
            "space_watermelon",
            properties -> new TenacityFoodItem(properties, 20f),
            new Item.Properties().food(ModFoods.SPACE_WATERMELON, ModFoods.SPACE_WATERMELON_CONSUMABLE)
    );

    //НЕ РАБОТАЕТ:
    //public static final Item SHAWARMA = registerItem(
    //        "shawarma",properties -> new Item(properties
    //                .food(ModFoods.SHAWARMA, ModFoods.SHAWARMA_CONSUMABLE)));

//============================================ИНОЕ-ДРУГОЕ==============================================
    public static final Item HESPERIDES_BOAT = registerItem(
            "hesperides_boat",
            properties -> new net.minecraft.world.item.BoatItem(ModBoats.HESPERIDES_BOAT, properties),
            new Item.Properties().stacksTo(1)
    );

    public static final Item HESPERIDES_CHEST_BOAT = registerItem(
            "hesperides_chest_boat",
            properties -> new net.minecraft.world.item.BoatItem(ModBoats.HESPERIDES_CHEST_BOAT, properties),
            new Item.Properties().stacksTo(1)
    );

    public static final Item ARROW_RED = registerItem(
            "arrow_red", Item::new, new Item.Properties());

    public static final Item ARROW_GREEN = registerItem(
            "arrow_green", Item::new, new Item.Properties());

    public static final Item ARROW_BLUE = registerItem(
            "arrow_blue", Item::new, new Item.Properties());

    public static final Item ARROW_YELLOW = registerItem(
            "arrow_yellow", Item::new, new Item.Properties());

    public static final Item MUSIC_DISC_AME_IRO_RONDO = registerItem(
            "music_disc_ame_iro_rondo",
            properties -> new Item(properties
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)),
            new Item.Properties()
                    .jukeboxPlayable(ModJukeboxSongs.AME_IRO_RONDO_KEY)
    );

    public static final Item MUSIC_DISC_FULL_CONFESSION = registerItem(
            "music_disc_full_confession",
            properties -> new Item(properties
                    .stacksTo(1)
                    .rarity(Rarity.RARE)),
            new Item.Properties()
                    .jukeboxPlayable(ModJukeboxSongs.FULL_CONFESSION_KEY)
    );

    public static final Item MUSIC_DISC_MY_ONLY_CHANCE = registerItem(
            "music_disc_my_only_chance",
            properties -> new Item(properties
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)),
            new Item.Properties()
                    .jukeboxPlayable(ModJukeboxSongs.MY_ONLY_CHANCE_KEY)
    );

    public static final Item MUSIC_DISC_V_MOYEY_GOLOVE = registerItem(
            "music_disc_v_moyey_golove",
            properties -> new Item(properties
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)),
            new Item.Properties()
                    .jukeboxPlayable(ModJukeboxSongs.V_MOYEY_GOLOVE_KEY)
    );

    public static final Item MUSIC_DISC_LOST_MY_PIECES = registerItem(
            "music_disc_lost_my_pieces",
            properties -> new ModTooltipItems("item.nohonor.music_disc_lost_my_pieces.desc", 3, properties
                    .jukeboxPlayable(ModJukeboxSongs.LOST_MY_PIECES_KEY)
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)),
            new Item.Properties()
    );

    public static final Item DISC_FRAGMENT_LOST_MY_PIECES = registerItem(
            "disc_fragment_lost_my_pieces",
            properties -> new ModTooltipItems("item.nohonor.disc_fragment_lost_my_pieces.desc", properties),
            new Item.Properties()
                    .fireResistant()
                    //.useItemDescriptionPrefix()
                    .rarity(Rarity.RARE)
    );

    public static final Item MERCURILLIA_SEEDS = registerItem(
            "mercurillia_seeds",
            properties -> new BlockItem(ModBlocks.MERCURILLIA_CROP, properties),
            new Item.Properties()
    );

//==========================================ОРУЖИЕ===================================================
//ДААААААААААААА!!!!!!!
//
     public static final Item PEARL_SILVER_SWORD = registerItem(
             "pearl_silver_sword", PearlSilverSwordItem::new, new Item.Properties()
                    .sword(ModToolMaterials.PEARL_SILVER,
                        3.5f, -2.4f)
                    .stacksTo(1)
     );

    public static final Item PEARL_SILVER_SPEAR = registerItem(
            "pearl_silver_spear",
            properties -> new Item(properties.spear(ModToolMaterials.PEARL_SILVER,
                    0.75f,
                    0.95f,
                    0.2f,
                    1.5f,
                    11.0f,
                    2.5f,
                    5.1f,
                    4.5f,
                    4.6f
            )),
            new Item.Properties()
    );

    //public static final Item MACE = registerItem(
    //        "mace",
    //        MaceItem::new,
     //       new Item.Properties()
    //                .rarity(Rarity.EPIC)
    //                .durability(500)
    //                .component(DataComponents.TOOL, MaceItem.createToolProperties())
    //                .repairable(BREEZE_ROD)
    //                .attributes(MaceItem.createAttributes())
     //               .enchantable(15)
    //                .component(DataComponents.WEAPON, new Weapon(1))
    //);

    //public class MaceItem extends Item {
    //	private static final int DEFAULT_ATTACK_DAMAGE = 5;
    //	private static final float DEFAULT_ATTACK_SPEED = -3.4F;
    //	public static final float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    //	private static final float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    //	public static final float SMASH_ATTACK_KNOCKBACK_RADIUS = 3.5F;
    //	private static final float SMASH_ATTACK_KNOCKBACK_POWER = 0.7F;

    public static final Item PEARL_SILVER_MACE = registerItem(
            "pearl_silver_mace", PearlSilverMaceItem::new, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .durability(ModToolMaterials.PEARL_SILVER.durability())
                    .component(DataComponents.TOOL, PearlSilverMaceItem.createToolProperties())
                    .component(DataComponents.WEAPON, new Weapon(2))
                    .repairable(ModItems.PEARL_SILVER_INGOT)
                    .enchantable(ModToolMaterials.PEARL_SILVER.enchantmentValue())
                    .attributes(PearlSilverMaceItem.createAttributes())
    );

    public static final Item PEARL_SILVER_PICKAXE = registerItem(
            "pearl_silver_pickaxe", Item::new, new Item.Properties()
                    .pickaxe(ModToolMaterials.PEARL_SILVER,
                            1.5f, -2.8f)
                    .stacksTo(1)
    );

    public static final Item PEARL_SILVER_SHOVEL = registerItem(
            "pearl_silver_shovel",
            properties -> new ShovelItem(ModToolMaterials.PEARL_SILVER,
                    2.0f,
                    -3.0f,
                    properties),
            new Item.Properties()
                    .stacksTo(1)
    );

    public static final Item PEARL_SILVER_AXE = registerItem(
            "pearl_silver_axe",
            properties -> new PearlSilverAxeItem(ModToolMaterials.PEARL_SILVER,
                    6.5f,
                    -3.2f,
                    properties),
            new Item.Properties()
                    .stacksTo(1)
    );

    public static final Item PEARL_SILVER_HOE = registerItem(
            "pearl_silver_hoe",
            properties -> new HoeItem(ModToolMaterials.PEARL_SILVER,
                    -2.0F,
                    -1.0F,
                    properties),
            new Item.Properties()
                    .stacksTo(1)
    );
//=========================================ОГНЕСТРЕЛ===========================================
//ПИСТОЛЕТЫ

//ПИСТОЛЕТЫ-пулеметы

//АВТОМАТЫ

//ПУЛЕМЕТЫ

//ДРОБОВИКИ

//ВИНТОВКИ

//СНАЙПЕРСКИЕ ВИНТОВКИ

//ГРАНАТОМЕТЫ

//ИНОЕ

//===========================================БРОНЯ=============================================
    public static final Item STORM_ELYTRA = registerItem("storm_elytra", Item::new,
            new Item.Properties()
                    .durability(850)
                    .rarity(Rarity.EPIC)
                    .<Unit>component(DataComponents.GLIDER, Unit.INSTANCE)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                            .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                            .setAsset(ModArmorMaterials.STORM_ELYTRA_KEY)
                            .setDamageOnHurt(false)
                            .build())
                    .repairable(Items.PHANTOM_MEMBRANE));

    public static final Item EXTERMINATION_ELYTRA = registerItem("extermination_elytra", Item::new,
            new Item.Properties()
                    .durability(388)
                    .rarity(Rarity.EPIC)
                    .<Unit>component(DataComponents.GLIDER, Unit.INSTANCE)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                            .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                            .setAsset(ModArmorMaterials.EXTERMINATION_ELYTRA_KEY)
                            .setDamageOnHurt(false)
                            .build())
                    .repairable(Items.PHANTOM_MEMBRANE));

    public static final Item PEARL_SILVER_HELMET = registerItem(
            "pearl_silver_helmet",
    properties -> new Item(properties.humanoidArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL, ArmorType.HELMET)),
            new Item.Properties()
        );
    public static final Item PEARL_SILVER_CHESTPLATE = registerItem(
            "pearl_silver_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL, ArmorType.CHESTPLATE)),
            new Item.Properties()
    );
    public static final Item PEARL_SILVER_LEGGINGS = registerItem(
            "pearl_silver_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL, ArmorType.LEGGINGS)),
            new Item.Properties()
    );
    public static final Item PEARL_SILVER_BOOTS = registerItem(
            "pearl_silver_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL, ArmorType.BOOTS)),
            new Item.Properties()
    );

    //=======================================ЖИВОТНАЯ БРОНЯ============================
    public static final Item PEARL_SILVER_HORSE_ARMOR = registerItem(
            "pearl_silver_horse_armor",
            properties -> new Item(properties.horseArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL)),
            new Item.Properties()
    );

    public static final Item PEARL_SILVER_WOLF_ARMOR = registerItem(
            "pearl_silver_wolf_armor",
            properties -> new Item(properties.wolfArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL)),
            new Item.Properties()
    );

    public static final Item PEARL_SILVER_NAUTILUS_ARMOR = registerItem(
            "pearl_silver_nautilus_armor",
            properties -> new Item(properties.nautilusArmor(ModArmorMaterials.PEARL_SILVER_MATERIAL)),
            new Item.Properties()
    );

//================================================БАКЕТ===================================================
    public static final Item ACID_BUCKET = registerItem(
            "acid_bucket",
            props -> new BucketItem(ModFluids.ACID_STILL, props),
            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
);

    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        //           |
        //          \|/
        //Создание колюча предмета
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));

        // Create the item instance.
        //           |
        //          \|/
        //Создание Экземпляра предмета
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        //           |
        //          \|/
        //Регистрация предмета
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Mod Items for " + NOHONOR.MOD_ID);
    }
}