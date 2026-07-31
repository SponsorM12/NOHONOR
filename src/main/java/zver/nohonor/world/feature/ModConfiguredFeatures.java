package zver.nohonor.world.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> HESPERIDES_TREE = key("hesperides_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELM_TREE = key("elm_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Регистрация дерева Hesperides
        register(context, HESPERIDES_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
                new CherryTrunkPlacer(
                        5, 1, 1,
                        ConstantInt.of(3),
                        ConstantInt.of(2),
                        UniformInt.of(-2, 0),
                        ConstantInt.of(1)
                ),
                BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25f, 0.25f, 0.16666667f, 0.33333334f),
                new TwoLayersFeatureSize(1, 0, 2),
                BlockStateProvider.simple(Blocks.DIRT) // ← новый обязательный belowTrunkProvider
        ).ignoreVines().build());

        // Регистрация дерева Elm
        //register(context, ELM_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
        //        BlockStateProvider.simple(ModBlocks.ELM_LOG),
        //        new CherryTrunkPlacer(
        //                7,
        //                1,
        //                1,
        //                ConstantInt.of(3),
        //                ConstantInt.of(2),
        //                UniformInt.of(-2, 0),
        //                ConstantInt.of(1)
        //        ),
        //        BlockStateProvider.simple(ModBlocks.ELM_LEAVES),
        //        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25f, 0.25f, 0.16666667f, 0.33333334f),
        //        new TwoLayersFeatureSize(1, 0, 2)
        //).ignoreVines().build());
    }

    //Нужно перенести это хз в readme
    //Параметры которые можно менять:
    //StraightTrunkPlacer(baseHeight, heightRandA, heightRandB) — итоговая высота = base + rand(0..A) + rand(0..B)
    //BlobFoliagePlacer(radius, offset, height) — шарообразная крона. Вместо BlobFoliagePlacer можно использовать:
    //
    //AcaciaFoliagePlacer — плоская крона как акация
    //FancyFoliagePlacer — большое ветвистое дерево
    //CherryFoliagePlacer — крона как у вишни

    //==========================================ПРИМЕРЫ================================================
    //Дефолт смешное квадратное дерево
    //new TreeConfiguration.TreeConfigurationBuilder(
    //                        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG), // блок ствола
    //                        new StraightTrunkPlacer(5, 2, 0), // тип ствола: прямой, baseHeight=5, рандом +0..+2
    //                        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES), // блок листвы
    //                        new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), // тип листвы: шар, радиус=3, смещение=0, высота=3
    //                        new TwoLayersFeatureSize(1, 0, 1)// ограничение размера: нижний слой=1, верхний=1
    //                ).build()

    //Маленькое дерево
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new StraightTrunkPlacer(2, 1, 0),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
    //        new TwoLayersFeatureSize(0, 0, 0)
    //).build()

    //Березоподобное высокое
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new StraightTrunkPlacer(5, 2, 0),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
    //        new TwoLayersFeatureSize(1, 0, 1)
    //).build()

    //Акациаподобное
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new ForkingTrunkPlacer(5, 2, 2),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new AcaciaFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
    //        new TwoLayersFeatureSize(1, 0, 2)
    //).build()

    //Дуб фенси, чтобы это не значило
    // new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new FancyTrunkPlacer(3, 11, 0),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
    //        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
    //).build()

    //Вишнеподобное широкая свисающая крона
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new CherryTrunkPlacer(7, 1, 0,
    //                ConstantInt.of(2),
    //                UniformInt.of(2, 4),
    //                UniformInt.of(-1, 1),
    //                UniformInt.of(-3, -1)
    //        ),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new CherryFoliagePlacer(
    //                ConstantInt.of(4), ConstantInt.of(0),
    //                ConstantInt.of(5), 0.25f, 0.5f, 0.16666667f, 0.33333334f
    //        ),
    //        new TwoLayersFeatureSize(1, 0, 2)
    //).build()

    //Дерево аля большой дуб
    //entries.add(ModConfiguredFeatures.HESPERIDES_TREE, new ConfiguredFeature<>(
    //        Feature.TREE,
    //       new TreeConfiguration.TreeConfigurationBuilder(
    //                BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //               new FancyTrunkPlacer(6, 14, 3),                    // ещё толще и ветвистее
    //               BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //               new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), // широкая красивая крона
    //               new TwoLayersFeatureSize(1, 0, 2, OptionalInt.of(4)) // важно для Fancy
    //      )
    //              .ignoreVines() // убираем лианы, если не нужны
    //               .build()
    //));

    //Мега 2x2
    //entries.add(ModConfiguredFeatures.HESPERIDES_TREE, new ConfiguredFeature<>(
    //Feature.TREE,
    //        new TreeConfiguration.TreeConfigurationBuilder(
    //                BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //                new MegaJungleTrunkPlacer(10, 3, 19),   // или DarkOakTrunkPlacer
    //                BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //                new FancyFoliagePlacer(ConstantInt.of(4), ConstantInt.of(5), 6),
    //                new TwoLayersFeatureSize(1, 1, 2)
    //        ).build()
    //));

    //Мега-ель 2x2
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new CherryTrunkPlacer(7, 1, 0,
    //                ConstantInt.of(2),
    //                UniformInt.of(2, 4),
    //                UniformInt.of(-1, 1),
    //                UniformInt.of(-3, -1)
    //        ),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new CherryFoliagePlacer(
    //                ConstantInt.of(4), ConstantInt.of(0),
    //                ConstantInt.of(5), 0.25f, 0.5f, 0.16666667f, 0.33333334f
    //        ),
    //        new TwoLayersFeatureSize(1, 0, 2)
    //).build()

    //Мега-джунгли 2x2
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new MegaJungleTrunkPlacer(10, 2, 19),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new JungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
    //        new TwoLayersFeatureSize(1, 1, 2)
    //)
    //.decorators(List.of(
    //        new TrunkVineDecorator(),      // лианы на стволе
    //        new LeafVineDecorator(0.25f),  // лианы на листве
    //        new BeehiveDecorator(0.0f)     // пчёлы (0.0f = нет)
    //))
    //.build()

    //Тёмный дуб 2x2
    //new TreeConfiguration.TreeConfigurationBuilder(
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LOG),
    //        new DarkOakTrunkPlacer(6, 2, 1),
    //        BlockStateProvider.simple(ModBlocks.HESPERIDES_LEAVES),
    //        new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
    //        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
    //).build()

    //Для мега-деревьев (2x2) не забудь передать ключ в первый аргумент TreeGrower — megaTree, а не tree:
    //public static final TreeGrower HESPERIDES = new TreeGrower(
    //        "nohonor:hesperides",
    //        Optional.of(ModConfiguredFeatures.HESPERIDES_MEGA_TREE), // megaTree — 2x2
    //        Optional.of(ModConfiguredFeatures.HESPERIDES_TREE),      // обычное
    //        Optional.empty()
    //);

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }

}