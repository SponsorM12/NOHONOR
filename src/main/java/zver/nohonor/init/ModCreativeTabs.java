package zver.nohonor.init;

import zver.nohonor.NOHONOR;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.entity.boat.ModBoats;
import zver.nohonor.item.ModItems;

public class ModCreativeTabs {

    public static final ResourceKey<CreativeModeTab> NOHONOR_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "nohonor_tab")
    );

    public static final CreativeModeTab NOHONOR_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SYMBOL_OF_THE_UNIVERSE))
            .title(Component.translatable("creativeTab.nohonor"))
            .backgroundTexture(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "textures/gui/container/creative/tab_items.png"))
            .displayItems((params, output) -> {
                //===================ИТЕМС==================
                //=================МАТЕРИАЛЫ=================
                output.accept(ModItems.SEA_STONE);
                output.accept(ModItems.YELLOW_ARKADY_THORN);
                output.accept(ModItems.YELLOW_ARKADY_TRUNK);
                output.accept(ModItems.BLACK_BONE);
                output.accept(ModItems.CHARRED_STONE);
                output.accept(ModItems.PYRITE);
                output.accept(ModItems.BLACK_RESIN_CLUMP);
                output.accept(ModItems.PEOV);
                output.accept(ModItems.ION_SPHERE);
                output.accept(ModItems.GALENA);
                output.accept(ModItems.BAUXITE);
                output.accept(ModItems.SPODUMENE);
                output.accept(ModItems.LOTUS);
                output.accept(ModItems.FRUM_FRUM);
                output.accept(ModItems.BISMUTHIN);
                output.accept(ModItems.BISMUTH_SYNTHETIC);
                output.accept(ModItems.KERASENE);
                output.accept(ModItems.DISENTGILIL);
                output.accept(ModItems.FAZAMISANTROL);
                output.accept(ModItems.AUERIENNE);

                //============ВАЛЮТА====================
                output.accept(ModItems.PEARL_GARANT);
                output.accept(ModItems.PEARL_TITAN);

                //============МЕТАЛЛЫ + МАТЕРИАЛЫ============
                output.accept(ModItems.RAW_CAST_IRON);
                output.accept(ModItems.CAST_IRON_INGOT);
                output.accept(ModItems.CAST_IRON_NUGGET);
                output.accept(ModItems.RAW_WHITE_CAST_IRON);
                output.accept(ModItems.WHITE_CAST_IRON_INGOT);
                output.accept(ModItems.WHITE_CAST_IRON_NUGGET);
                output.accept(ModItems.RAW_MALLEABLE_CAST_IRON);
                output.accept(ModItems.MALLEABLE_CAST_IRON_INGOT);
                output.accept(ModItems.MALLEABLE_CAST_IRON_NUGGET);
                output.accept(ModItems.RAW_UKLAD);
                output.accept(ModItems.UKLAD_INGOT);
                output.accept(ModItems.UKLAD_NUGGET);
                output.accept(ModItems.RAW_CAST_BULAT);
                output.accept(ModItems.CAST_BULAT_INGOT);
                output.accept(ModItems.CAST_BULAT_NUGGET);
                output.accept(ModItems.RAW_PLYMBLUM);
                output.accept(ModItems.PLYMBLUM_INGOT);
                output.accept(ModItems.PLYMBLUM_NUGGET);
                output.accept(ModItems.RAW_PEARL_SILVER);
                output.accept(ModItems.PEARL_SILVER_INGOT);
                output.accept(ModItems.PEARL_SILVER_NUGGET);
                output.accept(ModItems.RAW_ZUBETS);
                output.accept(ModItems.ZUBETS_INGOT);
                output.accept(ModItems.ZUBETS_NUGGET);
                output.accept(ModItems.RAW_GLINIY);
                output.accept(ModItems.GLINIY_INGOT);
                output.accept(ModItems.GLINIY_NUGGET);
                output.accept(ModItems.RAW_TITANIUM);
                output.accept(ModItems.TITANIUM_INGOT);
                output.accept(ModItems.TITANIUM_NUGGET);
                output.accept(ModItems.RAW_LYUTYY);
                output.accept(ModItems.LYUTYY_INGOT);
                output.accept(ModItems.LYUTYY_NUGGET);
                output.accept(ModItems.RAW_CHROMIUM);
                output.accept(ModItems.CHROMIUM_INGOT);
                output.accept(ModItems.CHROMIUM_NUGGET);
                output.accept(ModItems.RAW_SHCHERBARUNE);
                output.accept(ModItems.SHCHERBARUNE);
                output.accept(ModItems.SHCHERBARUNE_SHARD);
                output.accept(ModItems.RAW_LUMEL);
                output.accept(ModItems.LUMEL_INGOT);
                output.accept(ModItems.LUMEL_NUGGET);
                output.accept(ModItems.RAW_BISMUTH);
                output.accept(ModItems.BISMUTH);
                output.accept(ModItems.BISMUTH_NUGGET);

                //==============СПЛАВЫ===================
                output.accept(ModItems.RAW_KOLDOVSKAYA_BRASS);
                output.accept(ModItems.KOLDOVSKAYA_BRASS_INGOT);
                output.accept(ModItems.KOLDOVSKAYA_BRASS_NUGGET);
                output.accept(ModItems.RAW_KARELITE);
                output.accept(ModItems.KARELITE_INGOT);
                output.accept(ModItems.KARELITE_NUGGET);
                output.accept(ModItems.RAW_KHRAMOVAYA_STEEL);
                output.accept(ModItems.KHRAMOVAYA_STEEL_INGOT);
                output.accept(ModItems.KHRAMOVAYA_STEEL_NUGGET);
                output.accept(ModItems.RAW_VIVARIUM);
                output.accept(ModItems.VIVARIUM_INGOT);
                output.accept(ModItems.VIVARIUM_NUGGET);
                output.accept(ModItems.RAW_HELLESTEROY);
                output.accept(ModItems.HELLESTEROY_INGOT);
                output.accept(ModItems.HELLESTEROY_NUGGET);
                output.accept(ModItems.RAW_DURANSTEEL);
                output.accept(ModItems.DURANSTEEL_INGOT);
                output.accept(ModItems.DURANSTEEL_NUGGET);
                output.accept(ModItems.RAW_NOUS);
                output.accept(ModItems.NOUS_INGOT);
                output.accept(ModItems.NOUS_NUGGET);

                output.accept(ModItems.STAR_IRON_INGOT);
                output.accept(ModItems.STAR_IRON_NUGGET);

                //============СОКРОВИЩА И ИНОЕ===============
                output.accept(ModItems.GOLDEN_KEY);
                output.accept(ModItems.STAR_KEY);
                output.accept(ModItems.SYMBOL_OF_THE_UNIVERSE);

                //===============ЕДА==========================
                output.accept(ModItems.NUTRITIONAL_JELLY);
                output.accept(ModItems.HEARTY_JELLY);
                output.accept(ModItems.ROTTEN_JELLY);
                output.accept(ModItems.SPOILED_JELLY);
                output.accept(ModItems.GREEN_APPLE);
                output.accept(ModItems.MAKOSH_BERRIES);
                output.accept(ModItems.SHAWARMA);
                output.accept(ModItems.RICE_SHOOT);
                output.accept(ModItems.RICE);
                output.accept(ModItems.BEAN_POD);
                output.accept(ModItems.BEANS);
                output.accept(ModItems.ADVACADO_SEED);
                output.accept(ModItems.ADVACADO);
                output.accept(ModItems.ONIGIRI);
                output.accept(ModItems.SUSHI);
                output.accept(ModItems.MEBER_APPLE);
                output.accept(ModItems.SPACE_WATERMELON);

                //==============ДРУГОЕ=============
                output.accept(ModItems.ARROW_RED);
                output.accept(ModItems.ARROW_GREEN);
                output.accept(ModItems.ARROW_BLUE);
                output.accept(ModItems.ARROW_YELLOW);

                output.accept(ModItems.MUSIC_DISC_AME_IRO_RONDO);
                output.accept(ModItems.MUSIC_DISC_FULL_CONFESSION);
                output.accept(ModItems.MUSIC_DISC_MY_ONLY_CHANCE);
                output.accept(ModItems.MUSIC_DISC_V_MOYEY_GOLOVE);
                output.accept(ModItems.MUSIC_DISC_LOST_MY_PIECES);
                output.accept(ModItems.DISC_FRAGMENT_LOST_MY_PIECES);

                output.accept(ModItems.MERCURILLIA_SEEDS);

                //=====================БЛОКИ======================
                //==================ОБЫЧНЫЕ БЛОКИ=================
                output.accept(ModBlocks.MEGAHAROSH_BLOCK.asItem());
                output.accept(ModBlocks.LEDLAMP.asItem());

                //==================ДЕКОРАТИВНЫЕ=================
                output.accept(ModBlocks.PLUSHE_SHARK.asItem());

                //=================ХРАМОВАЯ
                output.accept(ModBlocks.KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.KHRAMOVAYA_STONE_STAIRS.asItem());
                output.accept(ModBlocks.KHRAMOVAYA_STONE_SLAB.asItem());
                output.accept(ModBlocks.KHRAMOVAYA_STONE_WALL.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem());
                output.accept(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL.asItem());
                output.accept(ModBlocks.CUT_KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.CHISELED_KHRAMOVAYA_STONE_BRICKS.asItem());
                output.accept(ModBlocks.KHRAMOVAYA_STONE_BRICKS.asItem());
                output.accept(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS.asItem());
                output.accept(ModBlocks.KHRAMOVAYA_STONE_LAMP.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB.asItem());
                output.accept(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL.asItem());
                output.accept(ModBlocks.DARK_CUT_KHRAMOVAYA_STONE.asItem());
                output.accept(ModBlocks.DARK_KHRAMOVAYA_STONE_LAMP.asItem());

                //====================РУДЫ===========================
                output.accept(ModBlocks.PYRITE_ORE.asItem());
                output.accept(ModBlocks.DEEPSLATE_PYRITE_ORE.asItem());
                output.accept(ModBlocks.GALENA_ORE.asItem());
                output.accept(ModBlocks.DEEPSLATE_GALENA_ORE.asItem());
                output.accept(ModBlocks.BAUXITE_ORE.asItem());
                output.accept(ModBlocks.DEEPSLATE_BAUXITE_ORE.asItem());
                output.accept(ModBlocks.SPODUMENE_ORE.asItem());
                output.accept(ModBlocks.DEEPSLATE_SPODUMENE_ORE.asItem());
                output.accept(ModBlocks.NETHER_LUMEL_ORE.asItem());
                output.accept(ModBlocks.NETHER_SHCHERBARUNE_ORE.asItem());
                output.accept(ModBlocks.END_STONE_BISMUTH_ORE.asItem());

                //=========ДЕРЕВЯННЫЕ БЛОКИ И ПРОИЗВОДНЫЕ============
                output.accept(ModBlocks.HESPERIDES_SAPLING.asItem());
                output.accept(ModBlocks.HESPERIDES_LEAVES.asItem());
                output.accept(ModBlocks.HESPERIDES_LOG.asItem());
                output.accept(ModBlocks.HESPERIDES_WOOD.asItem());
                output.accept(ModBlocks.STRIPPED_HESPERIDES_LOG.asItem());
                output.accept(ModBlocks.STRIPPED_HESPERIDES_WOOD.asItem());
                output.accept(ModBlocks.HESPERIDES_PLANKS.asItem());
                output.accept(ModBlocks.HESPERIDES_STAIRS.asItem());
                output.accept(ModBlocks.HESPERIDES_SLAB.asItem());
                output.accept(ModBlocks.HESPERIDES_FENCE.asItem());
                output.accept(ModBlocks.HESPERIDES_FENCE_GATE.asItem());
                output.accept(ModBlocks.HESPERIDES_DOOR.asItem());
                output.accept(ModBlocks.HESPERIDES_TRAPDOOR.asItem());
                output.accept(ModBlocks.HESPERIDES_PRESSURE_PLATE.asItem());
                output.accept(ModBlocks.HESPERIDES_BUTTON.asItem());
                output.accept(ModBlocks.HESPERIDES_SHELF.asItem());
                output.accept(ModBlocks.HESPERIDES_SIGN.asItem());
                output.accept(ModBlocks.HESPERIDES_HANGING_SIGN.asItem());
                output.accept(ModItems.HESPERIDES_BOAT);
                output.accept(ModItems.HESPERIDES_CHEST_BOAT);
                output.accept(ModBlocks.GOLDEN_PETALS.asItem());

                //=========================ОРУЖИЕ====================
                output.accept(ModItems.PEARL_SILVER_SWORD);
                output.accept(ModItems.PEARL_SILVER_SPEAR);
                output.accept(ModItems.PEARL_SILVER_MACE);

                //=======================ИНСТРУМЕНТЫ========================
                output.accept(ModItems.PEARL_SILVER_PICKAXE);
                output.accept(ModItems.PEARL_SILVER_SHOVEL);
                output.accept(ModItems.PEARL_SILVER_AXE);
                output.accept(ModItems.PEARL_SILVER_HOE);

                //=========================БРОНЯ============================
                output.accept(ModItems.STORM_ELYTRA);
                output.accept(ModItems.EXTERMINATION_ELYTRA);
                output.accept(ModItems.PEARL_SILVER_HELMET);
                output.accept(ModItems.PEARL_SILVER_CHESTPLATE);
                output.accept(ModItems.PEARL_SILVER_LEGGINGS);
                output.accept(ModItems.PEARL_SILVER_BOOTS);

                output.accept(ModItems.PEARL_SILVER_HORSE_ARMOR);
                output.accept(ModItems.PEARL_SILVER_WOLF_ARMOR);
                output.accept(ModItems.PEARL_SILVER_NAUTILUS_ARMOR);

                //==========================БАКЕТ================================
                output.accept(ModItems.ACID_BUCKET);

                //сюдааааааааааааа
            })
            .build();

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                NOHONOR_TAB_KEY,
                NOHONOR_TAB
        );
        NOHONOR.LOGGER.info("Registering Mod Creative Tabs " + NOHONOR.MOD_ID);
    }
}