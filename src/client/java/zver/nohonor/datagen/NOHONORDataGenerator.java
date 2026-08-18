package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import zver.nohonor.damage_type.ModDamageTypes;
import zver.nohonor.entity.villager.ModPOITags;
import zver.nohonor.entity.villager.ModTradeSets;
import zver.nohonor.entity.villager.ModVillagerTradeTags;
import zver.nohonor.entity.villager.ModVillagerTrades;
import zver.nohonor.sound.ModJukeboxSongs;
import zver.nohonor.world.feature.ModConfiguredFeatures;

public class NOHONORDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlocksTagsProvider::new);
        pack.addProvider(ModItemsTagsProvider::new);
        pack.addProvider(ModFluidsTagsProvider::new);
        pack.addProvider(ModEntityTypeTagsProvider::new);
        pack.addProvider(ModEquipmentAssetProvider::new);
        pack.addProvider(ModAdvancementProvider::new);
        pack.addProvider(ModSoundsProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModRegistryDataProvider::new);
        pack.addProvider(ModPaintingsTagsProvider::new);
        pack.addProvider(ModVillagerTradeTags::new);
        pack.addProvider(ModPOITags::new);

    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.JUKEBOX_SONG, ModJukeboxSongs::bootstrap);
        registryBuilder.add(Registries.PAINTING_VARIANT, ModPaintings::bootstrap);
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap);
        registryBuilder.add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap);
        registryBuilder.add(Registries.TRADE_SET, ModTradeSets::bootstrap);

    }
}