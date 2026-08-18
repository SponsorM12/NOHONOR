package zver.nohonor.entity.villager;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import zver.nohonor.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradeTags extends FabricTagsProvider<VillagerTrade> {

    public ModVillagerTradeTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registyLookupFuture) {
        super(output, Registries.VILLAGER_TRADE, registyLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(VillagerTradeTags.FARMER_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.FARMER_1_EMERALD_BEAN.identifier()));

        getOrCreateRawBuilder(VillagerTradeTags.MASON_LEVEL_2)
                .add(TagEntry.element(ModVillagerTrades.MASON_2_KHRAMOVAYA_STEEL_INGOT_EMERALD_POLISHED_KHRAMOVAYA_STONE.identifier()));

        getOrCreateRawBuilder(VillagerTradeTags.LIBRARIAN_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.LIBRARIAN_1_LOTUS_EMERALD.identifier()));
        getOrCreateRawBuilder(VillagerTradeTags.LIBRARIAN_LEVEL_3)
                .add(TagEntry.element(ModVillagerTrades.LIBRARIAN_3_PEARL_GARANT_MENDING.identifier()));

        getOrCreateRawBuilder(VillagerTradeTags.COMMON_SMITH_LEVEL_2)
                .add(TagEntry.element(ModVillagerTrades.COMMON_SMITH_2_PEARL_SILVER_INGOT_EMERALD.identifier()));

        getOrCreateRawBuilder(VillagerTradeTags.CLERIC_LEVEL_5)
                .add(TagEntry.element(ModVillagerTrades.CLERIC_5_KARELITE_INGOT_PEARL_GARANT.identifier()));

        getOrCreateRawBuilder(ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_1_BAUXITE_RAW_IRON.identifier()))
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_1_BLACK_BONE_EMERALD.identifier()));

        getOrCreateRawBuilder(ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_2)
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_2_CHARRED_STONE_EMERALD.identifier()))
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_2_GALENA_RAW_GOLD.identifier()));

        getOrCreateRawBuilder(ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_3)
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_3_CAST_IRON_INGOT_CHARRED_STONE.identifier()))
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_3_SPODUMENE_BLACK_BONE.identifier()));

        getOrCreateRawBuilder(ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_4)
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_4_LUMEL_INGOT_PEARL_GARANT.identifier()))
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_4_SHCHERBARUNE_PEARL_GARANT.identifier()));

        getOrCreateRawBuilder(ModTags.Trades.HEAVY_BLACKSMITH_LEVEL_5)
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_5_PEARL_GARANT_NETHERITE_SCRAP.identifier()))
                .add(TagEntry.element(ModVillagerTrades.HEAVY_BLACKSMITH_5_PEARL_GARANT_CAST_BULAT_INGOT.identifier()));

    }

}
