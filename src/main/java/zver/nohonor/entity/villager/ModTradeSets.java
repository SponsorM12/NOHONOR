package zver.nohonor.entity.villager;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import zver.nohonor.NOHONOR;
import zver.nohonor.tag.ModTags;

import java.util.Optional;

public class ModTradeSets {
    public static final ResourceKey<TradeSet> HEAVY_BLACKSMITH_LEVEL_1 = create("heavy_blacksmith/level_1");
    public static final ResourceKey<TradeSet> HEAVY_BLACKSMITH_LEVEL_2 = create("heavy_blacksmith/level_2");
    public static final ResourceKey<TradeSet> HEAVY_BLACKSMITH_LEVEL_3 = create("heavy_blacksmith/level_3");
    public static final ResourceKey<TradeSet> HEAVY_BLACKSMITH_LEVEL_4 = create("heavy_blacksmith/level_4");
    public static final ResourceKey<TradeSet> HEAVY_BLACKSMITH_LEVEL_5 = create("heavy_blacksmith/level_5");

    public static void bootstrap(BootstrapContext<TradeSet> context) {
        register(context, HEAVY_BLACKSMITH_LEVEL_1, ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_1);
        register(context, HEAVY_BLACKSMITH_LEVEL_2, ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_2);
        register(context, HEAVY_BLACKSMITH_LEVEL_3, ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_3);
        register(context, HEAVY_BLACKSMITH_LEVEL_4, ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_4);
        register(context, HEAVY_BLACKSMITH_LEVEL_5, ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_5);

    }

    private static ResourceKey<TradeSet> create(final String id) {
        return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, id));
    }

    public static Holder.Reference<TradeSet> register(final BootstrapContext<TradeSet> context,
                                                      final ResourceKey<TradeSet> resourceKey, final TagKey<VillagerTrade> tradeTag) {
        return register(context, resourceKey, tradeTag, ConstantValue.exactly(2.0F));
    }

    public static Holder.Reference<TradeSet> register(final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey,
                                                      final TagKey<VillagerTrade> tradeTag, final NumberProvider numberProvider) {
        return context.register(resourceKey, new TradeSet(context.lookup(Registries.VILLAGER_TRADE).getOrThrow(tradeTag),
                numberProvider, false, Optional.of(resourceKey.identifier().withPrefix("trade_set/"))));
    }

}
