package zver.nohonor.datagen.villager;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
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

    }

}
