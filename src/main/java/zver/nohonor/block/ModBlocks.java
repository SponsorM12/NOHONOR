package zver.nohonor.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import zver.nohonor.NOHONOR;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import zver.nohonor.block.custom.*;
import zver.nohonor.block.custom.hellesteroy_block.HellesteroyBlock;
import zver.nohonor.block.custom.lumel_block.LumelBlock;
import zver.nohonor.block.custom.pedestal.PedestalBlock;
import zver.nohonor.block.custom.plush.PlushBlocks;
import zver.nohonor.block.custom.vivarium_block.VivariumBlock;
import zver.nohonor.fluid.ModFluids;
import zver.nohonor.item.ModItems;
import zver.nohonor.item.special.custom.HellesteroyItem;
import zver.nohonor.tag.ModTags;
import zver.nohonor.world.tree.ModTreeGrowers;

import java.util.Optional;
import java.util.function.Function;

public class ModBlocks {

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

//========================================ДЕКОРАТИВНЫЕ БЛОКИ============================================
//МЕГАХАРОШ
    public static final Block MEGAHAROSH_BLOCK = register(
            "megaharosh_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(0.5f, 5.0f),
            true
    );

    public static final Block LEDLAMP = register(
            "ledlamp",
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.GLASS)
                    .strength(0.3f, 2.0f)
                    .lightLevel(statex -> 15),
            true
    );

//=======================================ЖЕЛЕЗНЫЕ БЛОКИ===============================================
    //NETHERITE_BLOCK = register(BlockItemIds.NETHERITE_BLOCK,
    // BlockBehaviour.Properties.of()
    // .mapColor(MapColor.COLOR_BLACK)
    // .requiresCorrectToolForDrops()
    // .strength(50.0F, 1200.0F)
    // .sound(SoundType.NETHERITE_BLOCK));

    //GOLD_BLOCK = register(BlockItemIds.GOLD_BLOCK, Properties.of()
    // .mapColor(MapColor.GOLD)
    // .instrument(NoteBlockInstrument.BELL)
    // .requiresCorrectToolForDrops()
    // .strength(3.0F, 6.0F)
    // .sound(SoundType.METAL));

    public static final Block PYRITE_BLOCK = register(
            "pyrite_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .strength(3.0f, 5.0f),
            true
    );

    public static final Block GLINIY_BLOCK = register(
        "gliniy_block",
        Block::new,
        BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .strength(3.0f, 6.0f),
        true
    );

    public static final Block TITANIUM_BLOCK = register(
            "titanium_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .strength(3.5f, 7.0f),
            true
    );

    public static final Block LUMEL_BLOCK = register(
            "lumel_block",
            LumelBlock::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .strength(6f, 12f),
            true
    );

    public static final Block KARELITE_BLOCK = register(
            "karelite_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .strength(5f, 6.0f),
            true
    );

    public static final Block HELLESTEROY_BLOCK = register(
            "hellesteroy_block",
            HellesteroyBlock::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .strength(40f, 16f),
            true
    );

    public static final Block VIVARIUM_BLOCK = register(
            "vivarium_block",
            VivariumBlock::new,
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .strength(40f, 16f),
            false
    );


//==============================================ПЛЮШ============================================
    public static final Block PLUSHE_SHARK = register(
            "plushe_shark",
            properties -> new PlushBlocks(properties),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOL)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    .strength(0.1f, 5.0f),
            true
    );

    public static final Block PLUSHE_WHALE = register(
            "plushe_whale",
            properties -> new PlushBlocks(properties),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOL)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    .strength(0.1f, 5.0f),
            true
    );

//==============================================ХРАМОВЫЕ БЛОКИ==================================================
//public static final Block BLACKSTONE = register(
//		"blackstone",
//		BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)
//	);
//	public static final Block BLACKSTONE_STAIRS = registerLegacyStair("blackstone_stairs", BLACKSTONE);
//	public static final Block BLACKSTONE_WALL = register("blackstone_wall", WallBlock::new, BlockBehaviour.Properties.ofLegacyCopy(BLACKSTONE).forceSolidOn());
//	public static final Block BLACKSTONE_SLAB = register(
//		"blackstone_slab", SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(BLACKSTONE).strength(2.0F, 6.0F)
//	);
//	public static final Block POLISHED_BLACKSTONE = register("polished_blackstone", BlockBehaviour.Properties.ofLegacyCopy(BLACKSTONE).strength(2.0F, 6.0F));
//	public static final Block POLISHED_BLACKSTONE_BRICKS = register(
//		"polished_blackstone_bricks", BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE).strength(1.5F, 6.0F)
//	);
//	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICKS = register(
//		"cracked_polished_blackstone_bricks", BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE_BRICKS)
//	);
//	public static final Block CHISELED_POLISHED_BLACKSTONE = register(
//		"chiseled_polished_blackstone", BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE).strength(1.5F, 6.0F)
//	);
//	public static final Block POLISHED_BLACKSTONE_BRICK_SLAB = register(
//		"polished_blackstone_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE_BRICKS).strength(2.0F, 6.0F)
//	);
//	public static final Block POLISHED_BLACKSTONE_BRICK_STAIRS = registerLegacyStair("polished_blackstone_brick_stairs", POLISHED_BLACKSTONE_BRICKS);
//	public static final Block POLISHED_BLACKSTONE_BRICK_WALL = register(
//		"polished_blackstone_brick_wall", WallBlock::new, BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE_BRICKS).forceSolidOn()
//	);
//	public static final Block GILDED_BLACKSTONE = register(
//		"gilded_blackstone", BlockBehaviour.Properties.ofLegacyCopy(BLACKSTONE).sound(SoundType.GILDED_BLACKSTONE)
//	);
//	public static final Block POLISHED_BLACKSTONE_STAIRS = registerLegacyStair("polished_blackstone_stairs", POLISHED_BLACKSTONE);
//	public static final Block POLISHED_BLACKSTONE_SLAB = register(
//		"polished_blackstone_slab", SlabBlock::new, BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE)
//	);
//	public static final Block POLISHED_BLACKSTONE_PRESSURE_PLATE = register(
//		"polished_blackstone_pressure_plate",
//		p -> new PressurePlateBlock(BlockSetType.POLISHED_BLACKSTONE, p),
//		BlockBehaviour.Properties.of()
//			.mapColor(MapColor.COLOR_BLACK)
//			.forceSolidOn()
//			.instrument(NoteBlockInstrument.BASEDRUM)
//			.noCollision()
//			.strength(0.5F)
//			.pushReaction(PushReaction.DESTROY)
//	);
//	public static final Block POLISHED_BLACKSTONE_BUTTON = register(
//		"polished_blackstone_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), buttonProperties()
//	);
//	public static final Block POLISHED_BLACKSTONE_WALL = register(
//		"polished_blackstone_wall", WallBlock::new, BlockBehaviour.Properties.ofLegacyCopy(POLISHED_BLACKSTONE).forceSolidOn()
//	);
//

    public static final Block KHRAMOVAYA_STONE = register(
            "khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.ANCIENT_DEBRIS)
                    .requiresCorrectToolForDrops()
                    .strength(2.0f)
                    .explosionResistance(8.0f),
            true
    );

    public static final Block KHRAMOVAYA_STONE_STAIRS = register(
            "khramovaya_stone_stairs",
            properties -> new StairBlock(KHRAMOVAYA_STONE.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block KHRAMOVAYA_STONE_SLAB = register(
            "khramovaya_stone_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block KHRAMOVAYA_STONE_WALL = register(
            "khramovaya_stone_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE = register(
            "polished_khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_STAIRS = register(
            "polished_khramovaya_stone_stairs",
            properties -> new StairBlock(POLISHED_KHRAMOVAYA_STONE.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_SLAB = register(
            "polished_khramovaya_stone_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_WALL = register(
            "polished_khramovaya_stone_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE = register(
            "polished_khramovaya_stone_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.STONE, properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE)
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .pushReaction(PushReaction.DESTROY)
                    .noCollision(),

            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BUTTON = register(
            "polished_khramovaya_stone_button",
            properties -> new ButtonBlock(BlockSetType.STONE, 120, properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE)
                    .strength(0.5f)
                    //.noOcclusion()
                    .noCollision(),
            true
    );


    public static final Block CHISELED_POLISHED_KHRAMOVAYA_STONE = register(
            "chiseled_polished_khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BRICKS = register(
            "polished_khramovaya_stone_bricks",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS = register(
            "polished_khramovaya_stone_bricks_stairs",
            properties -> new StairBlock(POLISHED_KHRAMOVAYA_STONE_BRICKS.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB = register(
            "polished_khramovaya_stone_bricks_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL = register(
            "polished_khramovaya_stone_bricks_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block CUT_KHRAMOVAYA_STONE = register(
            "cut_khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block CHISELED_KHRAMOVAYA_STONE_BRICKS = register(
            "chiseled_khramovaya_stone_bricks",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block KHRAMOVAYA_STONE_BRICKS = register(
            "khramovaya_stone_bricks",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block POLISHED_KHRAMOVAYA_STONE_BIG_BRICKS = register(
            "polished_khramovaya_stone_big_bricks",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final BlockFamily KHRAMOVAYA_STONE_FAMILY =
            new BlockFamily.Builder(ModBlocks.KHRAMOVAYA_STONE)
                    //.polished(ModBlocks.POLISHED_KHRAMOVAYA_STONE)
                    //.chiseled(ModBlocks.CHISELED_POLISHED_KHRAMOVAYA_STONE)
                    .stairs(ModBlocks.KHRAMOVAYA_STONE_STAIRS)
                    .slab(ModBlocks.KHRAMOVAYA_STONE_SLAB)
                    .wall(ModBlocks.KHRAMOVAYA_STONE_WALL)
                    .getFamily();

    public static final BlockFamily POLISHED_KHRAMOVAYA_STONE_FAMILY =
            new BlockFamily.Builder(ModBlocks.POLISHED_KHRAMOVAYA_STONE)
                    //.bricks(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS)
                    .stairs(ModBlocks.POLISHED_KHRAMOVAYA_STONE_STAIRS)
                    .slab(ModBlocks.POLISHED_KHRAMOVAYA_STONE_SLAB)
                    .wall(ModBlocks.POLISHED_KHRAMOVAYA_STONE_WALL)
                    .pressurePlate(ModBlocks.POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE)
                    .button(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BUTTON)
                    .getFamily();

    public static final BlockFamily POLISHED_KHRAMOVAYA_STONE_BRICKS_FAMILY =
            new BlockFamily.Builder(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS)
                    .stairs(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS)
                    .slab(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB)
                    .wall(ModBlocks.POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL)
                    .getFamily();

    public static final Block KHRAMOVAYA_STONE_LAMP = register(
            "khramovaya_stone_lamp",
            properties -> new ModLampBlock(properties.strength(0.5f)
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(ModLampBlock.CLICKED) ? 15 : 0)),
            BlockBehaviour.Properties.of(),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE = register(
            "dark_polished_khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS = register(
            "dark_polished_khramovaya_stone_stairs",
            properties -> new StairBlock(DARK_POLISHED_KHRAMOVAYA_STONE.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_SLAB = register(
            "dark_polished_khramovaya_stone_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_WALL = register(
            "dark_polished_khramovaya_stone_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE = register(
            "dark_polished_khramovaya_stone_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.STONE, properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE)
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .pushReaction(PushReaction.DESTROY)
                    .noCollision(),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON = register(
            "dark_polished_khramovaya_stone_button",
            properties -> new ButtonBlock(BlockSetType.STONE, 120, properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE)
                    .strength(0.5f)
                    //.noOcclusion()
                    .noCollision(),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS = register(
            "dark_polished_khramovaya_stone_bricks",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS = register(
            "dark_polished_khramovaya_stone_bricks_stairs",
            properties -> new StairBlock(DARK_POLISHED_KHRAMOVAYA_STONE.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB = register(
            "dark_polished_khramovaya_stone_bricks_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL = register(
            "dark_polished_khramovaya_stone_bricks_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

    public static final Block DARK_CUT_KHRAMOVAYA_STONE = register(
            "dark_cut_khramovaya_stone",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(ModBlocks.KHRAMOVAYA_STONE)
                    .lightLevel(statex -> 1), //уровень света просто так
            true
    );

    public static final Block DARK_KHRAMOVAYA_STONE_LAMP = register(
            "dark_khramovaya_stone_lamp",
            properties -> new ModLampBlock(properties.strength(0.5f)
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(ModLampBlock.CLICKED) ? 13 : 0)),
            BlockBehaviour.Properties.of(),
            true
    );

    public static final BlockFamily DARK_POLISHED_KHRAMOVAYA_STONE_FAMILY =
            new BlockFamily.Builder(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE)
                    .stairs(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_STAIRS)
                    .slab(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_SLAB)
                    .wall(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_WALL)
                    .pressurePlate(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_PRESSURE_PLATE)
                    .button(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BUTTON)
                    .getFamily();

    public static final BlockFamily DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_FAMILY =
            new BlockFamily.Builder(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS)
                    .stairs(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_STAIRS)
                    .slab(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_SLAB)
                    .wall(ModBlocks.DARK_POLISHED_KHRAMOVAYA_STONE_BRICKS_WALL)
                    .getFamily();

    public static final Block PEDESTAL = register(
            "pedestal",
            properties -> new PedestalBlock(properties),
            BlockBehaviour.Properties.ofFullCopy(KHRAMOVAYA_STONE),
            true
    );

//=====================================================РУДЫ======================================================
//КОЛЧЕДАН
    public static final Block PYRITE_ORE = register(
        "pyrite_ore",
        Block::new,
        BlockBehaviour.Properties.of()
                .strength(3.0f)
                .requiresCorrectToolForDrops()
                .explosionResistance(3.0f)
                .sound(SoundType.STONE),
        true
    );

    public static final Block DEEPSLATE_PYRITE_ORE = register(
            "deepslate_pyrite_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.DEEPSLATE),
            true
    );

//ГАЛЕНА
    public static final Block GALENA_ORE = register(
            "galena_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.STONE),
            true
    );

    public static final Block DEEPSLATE_GALENA_ORE = register(
            "deepslate_galena_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.DEEPSLATE),
            true
    );

//БОКСИТ
    public static final Block BAUXITE_ORE = register(
            "bauxite_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.STONE),
            true
    );

    public static final Block DEEPSLATE_BAUXITE_ORE = register(
            "deepslate_bauxite_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.DEEPSLATE),
            true
    );

//СПОДУМЕН
    public static final Block SPODUMENE_ORE = register(
            "spodumene_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.STONE),
            true
    );

    public static final Block DEEPSLATE_SPODUMENE_ORE = register(
            "deepslate_spodumene_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(3.0f)
                    .sound(SoundType.DEEPSLATE),
            true
    );

//КРОКОИТ
    public static final Block END_STONE_CROCOITE_ORE = register(
            "end_stone_crocoite_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.0f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(9.0f)
                    .sound(SoundType.STONE),
            true
    );

//РУДА ЛЮМЕЛЯ
    public static final Block NETHER_LUMEL_ORE = register(
        "nether_lumel_ore",
        Block::new,
        BlockBehaviour.Properties.of()
                .strength(3.0f)
                .requiresCorrectToolForDrops()
                .explosionResistance(3.0f)
                .sound(SoundType.NETHER_ORE),
        true
    );

//РУДА ЩЕРБАРУНЫ
    public static final Block NETHER_SHCHERBARUNE_ORE = register(
        "nether_shcherbarune_ore",
        Block::new,
        BlockBehaviour.Properties.of()
                .strength(3.0f)
                .requiresCorrectToolForDrops()
                .explosionResistance(3.0f)
                .sound(SoundType.NETHER_ORE),
        true
    );

//РУДА ВИСМУТА
    public static final Block END_STONE_BISMUTH_ORE = register(
        "end_stone_bismuth_ore",
        Block::new,
        BlockBehaviour.Properties.of()
                .strength(4.0f)
                .requiresCorrectToolForDrops()
                .explosionResistance(9.0f)
                .sound(SoundType.STONE),
        true
    );

//================================================ГЕСПЕРИДА===========================================
//==================================САПЛИНГ ГЕСПЕРИДЫ
    public static final Block HESPERIDES_SAPLING = register(
            "hesperides_sapling",
            properties -> new ModSaplingBlocks(ModTreeGrowers.HESPERIDES, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SAPLING)
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY),
            true
    );

    //public static final Block ELM_SAPLING = register(
    //        "elm_sapling",
    //        properties -> new ModSaplingBlocks(ModTreeGrowers.ELM, properties),
    //        BlockBehaviour.Properties.of()
    //                .noCollision()
    //                .randomTicks()
    //                .instabreak()
    //                .sound(SoundType.GRASS)
    //                .pushReaction(PushReaction.DESTROY),
    //        true
    //);
//====================================ПОТ САПЛИНГ ГЕСПЕРИДЫ
    public static final Block POTTED_HESPERIDES_SAPLING = register(
            "potted_hesperides_sapling",
            properties -> new FlowerPotBlock(HESPERIDES_SAPLING, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING),
            false
    );

    //    OAK_SAPLING = register("oak_sapling", (p) -> new SaplingBlock(TreeGrower.OAK, p), Properties.of().mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));
//POTTED_OAK_SAPLING = register("potted_oak_sapling", (p) -> new FlowerPotBlock(OAK_SAPLING, p), flowerPotProperties());

//===================================ЛИСТВА ГЕСПЕРИДЫ
//OAK_LEAVES = register("oak_leaves", (p) -> new TintedParticleLeavesBlock(0.01F, p),
//leavesProperties(SoundType.GRASS));
    public static final Block HESPERIDES_LEAVES = register(
            "hesperides_leaves",
              ModLeavesBlocks::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GOLD)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .isSuffocating((s, g, p) -> false)
                    .isViewBlocking((s, g, p) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY),
            true
    );

//=================================ЛОГ ГЕСПЕРИДЫ
//OAK_LOG = register("oak_log", RotatedPillarBlock::new,
// logProperties(MapColor.WOOD, MapColor.PODZOL, SoundType.WOOD));
    public static final Block HESPERIDES_LOG = register(
            "hesperides_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .ignitedByLava(),
            true
    );
//===============================ЦЕЛЬНОЕ ДЕРЕВО ГЕСПЕРИДЫ
    public static final Block HESPERIDES_WOOD = register(
            "hesperides_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .ignitedByLava(),
            true
    );
//==============================СТРИП ЛОГ ГЕСПЕРИДЫ
//STRIPPED_OAK_WOOD = register("stripped_oak_wood", RotatedPillarBlock::new, Properties.of()
// .mapColor(MapColor.WOOD)
// .instrument(NoteBlockInstrument.BASS)
// .strength(2.0F)
// .sound(SoundType.WOOD)
// .ignitedByLava());
    public static final Block STRIPPED_HESPERIDES_LOG = register(
            "stripped_hesperides_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .ignitedByLava(),
            true
    );
//==============================СТРИП ЦЕЛЬНОЕ ДЕРЕВО ГЕСПЕРИДЫ
    public static final Block STRIPPED_HESPERIDES_WOOD = register(
            "stripped_hesperides_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .ignitedByLava(),
            true
    );
//============================ПЛАНКС ДОСКИ ГЕСПЕРИДЫ
//OAK_PLANKS = register("oak_planks", Properties.of()
// .mapColor(MapColor.WOOD)
// .instrument(NoteBlockInstrument.BASS)
// .strength(2.0F, 3.0F)
// .sound(SoundType.WOOD)
// .ignitedByLava());
    public static final Block HESPERIDES_PLANKS = register(
            "hesperides_planks",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .instrument(NoteBlockInstrument.BASS)
                    .ignitedByLava(),
            true
    );
//=====================================ЛЕСТНИЦА ГЕСПЕРИДЫ
//OAK_STAIRS = registerLegacyStair("oak_stairs", OAK_PLANKS);
    public static final Block HESPERIDES_STAIRS = register(
            "hesperides_stairs",
            properties -> new StairBlock(HESPERIDES_PLANKS.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS),
            true
    );
//====================================СЛАБ ГЕСПЕРИДЫ
//OAK_SLAB = register("oak_slab", SlabBlock::new, Properties.of()
// .mapColor(MapColor.WOOD)
// .instrument(NoteBlockInstrument.BASS)
// .strength(2.0F, 3.0F)
// .sound(SoundType.WOOD)
// .ignitedByLava());
    public static final Block HESPERIDES_SLAB = register(
            "hesperides_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS),
            true
    );
//=======================================ЗАБОР ГЕСПЕРИДЫ
//PALE_OAK_FENCE = register("pale_oak_fence",FenceBlock::new, BlockBehaviour.Properties.of()
// .mapColor(PALE_OAK_PLANKS.defaultMapColor())
// .instrument(NoteBlockInstrument.BASS)
// .strength(2.0F, 3.0F)
// .ignitedByLava()
// .sound(SoundType.WOOD));
    public static final Block HESPERIDES_FENCE = register(
            "hesperides_fence",
            FenceBlock::new,
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS),
            true
    );

//=================================ВОРОТА ГЕСПЕРИДЫ
//PALE_OAK_FENCE_GATE = register("pale_oak_fence_gate", (p) -> new FenceGateBlock(WoodType.PALE_OAK, p),
// Properties.of()
// .mapColor(PALE_OAK_PLANKS.defaultMapColor())
// .forceSolidOn()
// .instrument(NoteBlockInstrument.BASS)
// .strength(2.0F, 3.0F)
// .ignitedByLava());
    public static final Block HESPERIDES_FENCE_GATE = register(
            "hesperides_fence_gate",
            properties -> new FenceGateBlock(ModWoodTypes.HESPERIDES, properties),
            //BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
                    .strength(2.0f, 3.0f),
            true
    );
//====================================ДВЕРЬ ГЕСПЕРИДЫ

    //public static final Block HESPERIDES_DOOR = register(
            //"hesperides_door",
          //  properties -> new DoorBlock(ModWoodTypes.HESPERIDES_SET_TYPE, properties),
        //    BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_DOOR)
             //       .strength(3.0f)
           //         .noOcclusion() //Это типа для прозрачных текстур чтоб рендер не ломался
         //           .ignitedByLava()
       //             .pushReaction(PushReaction.DESTROY),
     //       true
   // );

    public static final Block HESPERIDES_DOOR = register(
            "hesperides_door",
            properties -> new DoorBlock(ModWoodTypes.HESPERIDES_SET_TYPE, properties),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CHERRY_WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0f)
                    .noOcclusion()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY),
            //true
            false
    );

//===================================ТРАПДОР ГЕСПЕРИДЫ
//OAK_TRAPDOOR = register("oak_trapdoor", (p) -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.of()
// .mapColor(MapColor.WOOD)
// .instrument(NoteBlockInstrument.BASS)
// .strength(3.0F)
// .noOcclusion()
// .isValidSpawn(Blocks::never)
// .ignitedByLava());
    public static final Block HESPERIDES_TRAPDOOR = register(
            "hesperides_trapdoor",
            properties -> new TrapDoorBlock(ModWoodTypes.HESPERIDES_SET_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS)
                    .strength(3.0f)
                    .isValidSpawn(Blocks::never)
                    .noOcclusion(),
            true
    );
//==================================НАЖИМНАЯ ПЛИТЫА ГЕСПРЕРИДЫ
//OAK_PRESSURE_PLATE = register("oak_pressure_plate", (p) -> new PressurePlateBlock(BlockSetType.OAK, p),
// Properties.of()
// .mapColor(OAK_PLANKS
// .defaultMapColor())
// .forceSolidOn()
// .instrument(NoteBlockInstrument.BASS)
// .noCollision()
// .strength(0.5F)
// .ignitedByLava()
// .pushReaction(PushReaction.DESTROY));
    public static final Block HESPERIDES_PRESSURE_PLATE = register(
            "hesperides_pressure_plate",
            properties -> new PressurePlateBlock(ModWoodTypes.HESPERIDES_SET_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS)
                    .strength(0.5f)
                    .forceSolidOn()
                    .pushReaction(PushReaction.DESTROY)
                    .noCollision(),
            true
    );
//=====================================КНОПКА ГЕСПЕРИДЫ
//OAK_BUTTON = register("oak_button", (p) -> new ButtonBlock(BlockSetType.OAK, 30, p),
// buttonProperties());
    public static final Block HESPERIDES_BUTTON = register(
            "hesperides_button",
            properties -> new ButtonBlock(ModWoodTypes.HESPERIDES_SET_TYPE, 60, properties),
            BlockBehaviour.Properties.ofFullCopy(HESPERIDES_PLANKS)
                    .strength(0.5f)
                    //.noOcclusion()
                    .noCollision(),
            true
    );
//============================ШКАФ ГЕСПЕРИДЫ. СМОТРИ ТАК ЖЕ ModShelfBlocks
//OAK_SHELF = register("oak_shelf", ShelfBlock::new, Properties.of()
// .mapColor(OAK_PLANKS
// .defaultMapColor())
// .instrument(NoteBlockInstrument.BASS)
// .sound(SoundType.SHELF)
// .ignitedByLava()
// .strength(2.0F, 3.0F));
    public static final Block HESPERIDES_SHELF = register(
            "hesperides_shelf",
            ModShelfBlocks::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SHELF)
                    .sound(SoundType.SHELF)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava(),
            true
    );

//====================================ТАБЛИЧКА ГЕСПЕРИДЫ
//OAK_SIGN = register("oak_sign", (p) -> new StandingSignBlock(WoodType.OAK, p),
// Properties.of()
// .mapColor(MapColor.WOOD)
// .forceSolidOn()
// .instrument(NoteBlockInstrument.BASS)
// .noCollision()
// .strength(1.0F)
// .ignitedByLava());
    public static final Block HESPERIDES_SIGN = register(
            "hesperides_sign",
            properties -> new StandingSignBlock(ModWoodTypes.HESPERIDES, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SIGN)
                    .sound(SoundType.CHERRY_WOOD)
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
                    .ignitedByLava(),
            false
    );

//==================================НАСТЕННАЯ ТАБЛИЧКА ГЕСПЕРИДЫ
//OAK_WALL_SIGN = register("oak_wall_sign", (p) -> new WallSignBlock(WoodType.OAK, p), wallVariant(OAK_SIGN, true)
// .mapColor(MapColor.WOOD)
// .forceSolidOn()
// .instrument(NoteBlockInstrument.BASS)
// .noCollision()
// .strength(1.0F)
// .ignitedByLava());
    public static final Block HESPERIDES_WALL_SIGN = register(
            "hesperides_wall_sign",
            properties -> new WallSignBlock(ModWoodTypes.HESPERIDES, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WALL_SIGN)
                    .sound(SoundType.CHERRY_WOOD)
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
                    .ignitedByLava()
                    .overrideLootTable(Optional.of(
                            ResourceKey.create(Registries.LOOT_TABLE,
                                    Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "blocks/hesperides_sign"))
                    )),
            false
    );

//===============================НАВЕСНАЯ ТАБЛИЧКА ГЕСПЕРИДЫ
    public static final Block HESPERIDES_HANGING_SIGN = register(
            "hesperides_hanging_sign",
            properties -> new CeilingHangingSignBlock(ModWoodTypes.HESPERIDES, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
                    .sound(SoundType.CHERRY_WOOD_HANGING_SIGN)
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
                    .ignitedByLava(),
            false
    );
    //OAK_HANGING_SIGN = register(BlockItemIds.OAK_HANGING_SIGN,
    //                            (p) -> new CeilingHangingSignBlock(WoodType.OAK, p),
    //Properties.of().mapColor(OAK_LOG.defaultMapColor()).forceSolidOn().
    //instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());


//==================================НАСТЕННАЯ НАВЕСНАЯ ТАБЛИЧКА ГЕСПЕРИДЫ
    public static final Block HESPERIDES_WALL_HANGING_SIGN = register(
            "hesperides_wall_hanging_sign",
            properties -> new WallHangingSignBlock(ModWoodTypes.HESPERIDES, properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)
                    .sound(SoundType.CHERRY_WOOD_HANGING_SIGN)
                    .forceSolidOn()
                    .noCollision()
                    .strength(1.0F)
                    .ignitedByLava()
                    .overrideLootTable(Optional.of(
                            ResourceKey.create(Registries.LOOT_TABLE,
                                    Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "blocks/hesperides_hanging_sign"))
                    )),
            false
    );

    //OAK_WALL_HANGING_SIGN = register("oak_wall_hanging_sign", (p) -> new WallHangingSignBlock(WoodType.OAK, p),
// wallVariant(OAK_HANGING_SIGN, true)
// .mapColor(OAK_LOG.defaultMapColor())
// .forceSolidOn()
// .instrument(NoteBlockInstrument.BASS)
// .noCollision()
// .strength(1.0F)
// .ignitedByLava());

//=====================================ДЛЯ ДАТАГЕНА=========================================
    //public static final BlockFamily HESPERIDES_FAMILY =
    //    new BlockFamily.Builder(ModBlocks.HESPERIDES_PLANKS)
    //            .stairs(ModBlocks.HESPERIDES_STAIRS)
    //            .slab(ModBlocks.HESPERIDES_SLAB)
    //            .fence(ModBlocks.HESPERIDES_FENCE)
    //            .fenceGate(ModBlocks.HESPERIDES_FENCE_GATE)
    //            .button(ModBlocks.HESPERIDES_BUTTON)
    //            .pressurePlate(ModBlocks.HESPERIDES_PRESSURE_PLATE)
    //            .door(ModBlocks.HESPERIDES_DOOR)
    //            .trapdoor(ModBlocks.HESPERIDES_TRAPDOOR)
    //            .sign(ModBlocks.HESPERIDES_SIGN, ModBlocks.HESPERIDES_WALL_SIGN)
    //            .hangingSign(ModBlocks.HESPERIDES_HANGING_SIGN, ModBlocks.HESPERIDES_WALL_HANGING_SIGN)
    //            .getFamily();

    public static final BlockFamily HESPERIDES_FAMILY =
            BlockFamilies.familyBuilder(ModBlocks.HESPERIDES_PLANKS)
                    .stairs(ModBlocks.HESPERIDES_STAIRS)
                    .slab(ModBlocks.HESPERIDES_SLAB)
                    .fence(ModBlocks.HESPERIDES_FENCE)
                    .fenceGate(ModBlocks.HESPERIDES_FENCE_GATE)
                    .button(ModBlocks.HESPERIDES_BUTTON)
                    .pressurePlate(ModBlocks.HESPERIDES_PRESSURE_PLATE)
                    .door(ModBlocks.HESPERIDES_DOOR)
                    .trapdoor(ModBlocks.HESPERIDES_TRAPDOOR)
                    .sign(ModBlocks.HESPERIDES_SIGN, ModBlocks.HESPERIDES_WALL_SIGN)
                    .strippedLog(ModBlocks.STRIPPED_HESPERIDES_LOG)
                    .hangingSign(ModBlocks.HESPERIDES_HANGING_SIGN, ModBlocks.HESPERIDES_WALL_HANGING_SIGN)
                    .getFamily();

//====================================БЕДФЛОВЕРС================================================
    //WILDFLOWERS = register("wildflowers", FlowerBedBlock::new, Properties.of()
    // .mapColor(MapColor.PLANT)
    // .noCollision()
    // .sound(SoundType.PINK_PETALS)
    // .pushReaction(PushReaction.DESTROY));
    //
    public static final Block GOLDEN_PETALS = register(
            "golden_petals",
            FlowerBedBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS)
                    .sound(SoundType.PINK_PETALS)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .noCollision()
                    .instabreak(),
              true
);

//===================================================КРОПС=======================================================
    public static final Block MERCURILLIA_CROP = register(
        "mercurillia_crop",
        properties -> new ModCropBlocks(properties, () -> ModItems.MERCURILLIA_SEEDS),
        BlockBehaviour.Properties.of()
                .sound(SoundType.CROP)
                .randomTicks()
                .noCollision()
                .pushReaction(PushReaction.DESTROY),
        false
);

    public static final Block BEAN_CROP = register(
            "bean_crop",
            properties -> new ModCropBlocks(properties, () -> ModItems.BEAN_POD),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

//================================================ВАТЕР КРОПС===================================================
    //public static final Block RICE_CROP = register(
    //        "rice_crop",
    //        // Используем лямбду, передаем свойства и указываем, какие предметы/блоки связаны с рисом
    //        ModWaterCropBlocks::new,
    //        BlockBehaviour.Properties.of()
    //                .sound(SoundType.CROP)
    //                .randomTicks()
    //                .instabreak()
    //                .noCollision()
    //                .pushReaction(PushReaction.DESTROY),
    //        false
    //);

    //public static final Block RICE_STEM = register(
    //        "rice_stem",
    //        // Передаем свойства и указываем верхнюю часть для стебля риса
    //        ModWaterStemBlocks::new,
    //        BlockBehaviour.Properties.of()
     //               .sound(SoundType.CROP)
    //                .randomTicks()
    //                .instabreak()
    //                .noCollision()
    //                .pushReaction(PushReaction.DESTROY),
    //        false
    //);

    public static final Block RICE_CROP = register(
            "rice_crop",
            properties -> new ModWaterCropBlocks(properties, () -> ModItems.RICE_SHOOT, () -> ModBlocks.RICE_STEM),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block RICE_STEM = register(
            "rice_stem",
            properties -> new ModWaterStemBlocks(
                    properties,
                    () -> ModBlocks.RICE_CROP,
                    () -> Fluids.WATER, //аргумент: сама жидкость
                    FluidTags.WATER,    //аргумент: тег жидкости
                    () -> new Block[]{Blocks.CLAY, Blocks.MUD} // 5-й аргумент: допустимая почва
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    //  public static final Block RICE_STEM = register(
    //          "rice_stem",
    //          properties -> new ModWaterStemBlocks(properties, () -> ModBlocks.RICE_CROP),
    //           BlockBehaviour.Properties.of()
    //                   .sound(SoundType.CROP).randomTicks().instabreak().noCollision()
    //                   .pushReaction(PushReaction.DESTROY),
//            false
//);

    public static final Block LOTUS_CROP = register(
            "lotus_crop",
            properties -> new ModWaterCropBlocks(properties, () -> ModItems.LOTUS, () -> ModBlocks.LOTUS_STEM),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block LOTUS_STEM = register(
            "lotus_stem",
            properties -> new ModWaterStemBlocks(
                    properties,
                    () -> ModBlocks.LOTUS_CROP,
                    () -> Fluids.WATER,
                    FluidTags.WATER,
                    () -> new Block[]{Blocks.CLAY, Blocks.MUD}
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

 //   public static final Block LOTUS_STEM = register(
 //           "lotus_stem",
 //           properties -> new ModWaterStemBlocks(properties, () -> ModBlocks.LOTUS_CROP),
//            BlockBehaviour.Properties.of()
//                    .sound(SoundType.CROP).randomTicks().instabreak().noCollision()
//                    .pushReaction(PushReaction.DESTROY),
//            false
//);

    public static final Block ADVACADO_CROP = register(
            "advacado_crop",
            properties -> new ModWaterCropBlocks(properties, () -> ModItems.ADVACADO_SEED, () -> ModBlocks.ADVACADO_STEM),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block ADVACADO_STEM = register(
            "advacado_stem",
            properties -> new ModWaterStemBlocks(
                    properties,
                    () -> ModBlocks.ADVACADO_CROP,
                    () -> Fluids.LAVA,
                    FluidTags.LAVA,
                    () -> new Block[]{Blocks.MAGMA_BLOCK}
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block YELLOW_ARKADY_CROP = register(
            "yellow_arkady_crop",
            properties -> new ModWaterCropBlocks(properties, () -> ModItems.YELLOW_ARKADY_TRUNK, () -> ModBlocks.YELLOW_ARKADY_STEM),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block YELLOW_ARKADY_STEM = register(
            "yellow_arkady_stem",
            properties -> new ModWaterStemBlocks(
                    properties,
                    () -> ModBlocks.YELLOW_ARKADY_CROP,
                    () -> ModFluids.ACID_STILL,
                    ModTags.Fluids.ACID,
                    () -> new Block[]{Blocks.SULFUR}
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.CROP)
                    .randomTicks()
                    .instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

//===================================================СВИТ БУШ==================================================
    public static final Block GREEN_APPLE_BERRY_BUSH = register(
            "green_apple_berry_bush",
            properties -> new ModBerryBushBlocks(properties, () -> ModItems.GREEN_APPLE), // Указываем яблоко
            BlockBehaviour.Properties.of()
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .randomTicks()
                    //.instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

    public static final Block MAKOSH_BERRIES_BERRY_BUSH = register(
            "makosh_berries_berry_bush",
            properties -> new ModBerryBushBlocks(properties, () -> ModItems.MAKOSH_BERRIES), // Указываем ягоды Макош
            BlockBehaviour.Properties.of()
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .randomTicks()
                    //.instabreak()
                    .noCollision()
                    .pushReaction(PushReaction.DESTROY),
            false
    );

//===================================================ЛИКВИД========================================================

    public static final Block ACID = register(
            "acid",
            (props) -> new LiquidBlock(ModFluids.ACID_STILL, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER),
            false
    );

//=================================================================================================================
//====================================================РГИСТРАЦИЯ======================================================
    private static Block register(
            String name,
            Function<BlockBehaviour.Properties,
            Block> blockFactory,
            BlockBehaviour.Properties settings,
            boolean shouldRegisterItem) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
    }

    public static void initialize() {
//======================================ИНИЦИАЛИЗАЦИЯ=========================================
//=========================================СТРИП ЛОГС=====================================
        StrippableBlockRegistry.register(HESPERIDES_LOG, STRIPPED_HESPERIDES_LOG);
        StrippableBlockRegistry.register(HESPERIDES_WOOD, STRIPPED_HESPERIDES_WOOD);

//=========================================ДВЕРЬ========================================
        ResourceKey<Item> doorItemKey = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hesperides_door"));
        Registry.register(BuiltInRegistries.ITEM, doorItemKey,
                new DoubleHighBlockItem(
                        HESPERIDES_DOOR,
                        new Item.Properties().setId(doorItemKey).useBlockDescriptionPrefix()
                )
        );

//========================================ОБЫЧНАЯ ТАБЛИЧКА=====================================
        ResourceKey<Item> signItemKey = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hesperides_sign"));
        Registry.register(BuiltInRegistries.ITEM, signItemKey,
                new SignItem(
                        HESPERIDES_SIGN,
                        HESPERIDES_WALL_SIGN,
                        new Item.Properties().setId(signItemKey).stacksTo(16)
                )
        );

//===========================================НАВЕСНАЯ ТАБЛИЧКА============================================
        ResourceKey<Item> hangingSignItemKey = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hesperides_hanging_sign"));
        Registry.register(BuiltInRegistries.ITEM, hangingSignItemKey,
                new HangingSignItem(
                        HESPERIDES_HANGING_SIGN,
                        HESPERIDES_WALL_HANGING_SIGN,
                        new Item.Properties().setId(hangingSignItemKey).stacksTo(16)
                )
        );

        //БЛОК ЭНТИТИ
        BlockEntityTypes.SIGN.addValidBlock(HESPERIDES_SIGN);
        BlockEntityTypes.SIGN.addValidBlock(HESPERIDES_WALL_SIGN);
        BlockEntityTypes.HANGING_SIGN.addValidBlock(HESPERIDES_HANGING_SIGN);
        BlockEntityTypes.HANGING_SIGN.addValidBlock(HESPERIDES_WALL_HANGING_SIGN);
        BlockEntityTypes.SHELF.addValidBlock(HESPERIDES_SHELF);

        //ПОДЖИГ
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        //burn chance 5, spread chance 5 - как у ванильного дерева
        registry.add(HESPERIDES_LOG, 5, 5);
        registry.add(HESPERIDES_WOOD, 5, 5);
        registry.add(STRIPPED_HESPERIDES_LOG, 5, 5);
        registry.add(STRIPPED_HESPERIDES_WOOD, 5, 5);
        //5, 20 - как у ванильных досок
        registry.add(HESPERIDES_PLANKS, 5, 20);
        registry.add(HESPERIDES_STAIRS, 5, 20);
        registry.add(HESPERIDES_SLAB, 5, 20);
        registry.add(HESPERIDES_FENCE, 5, 20);
        registry.add(HESPERIDES_FENCE_GATE, 5, 20);
        registry.add(HESPERIDES_DOOR, 5, 20);
        registry.add(HESPERIDES_TRAPDOOR, 5, 20);
        registry.add(HESPERIDES_PRESSURE_PLATE, 5, 20);
        registry.add(HESPERIDES_BUTTON, 5, 20);
        registry.add(HESPERIDES_SHELF, 5, 20);
        registry.add(HESPERIDES_SIGN, 20, 5);
        registry.add(HESPERIDES_WALL_SIGN, 20, 5);
        registry.add(HESPERIDES_HANGING_SIGN, 20, 5);
        registry.add(HESPERIDES_WALL_HANGING_SIGN, 20, 5);
        //30, 60 - листва
        registry.add(HESPERIDES_LEAVES, 30, 60);
        //60, 100 - фловербедс
        registry.add(GOLDEN_PETALS, 60, 100);

        NOHONOR.LOGGER.info("Registering Mod Blocks for " + NOHONOR.MOD_ID);

    }
}