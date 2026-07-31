package zver.nohonor.datagen;

import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import zver.nohonor.NOHONOR;
import zver.nohonor.item.ModArmorMaterials;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class  ModEquipmentAssetProvider implements DataProvider {
    //Это для брони
    //Добавить объяснения

    private final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(ModArmorMaterials.PEARL_SILVER_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "pearl_silver"))
                        .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY,
                                new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "pearl_silver")))
                        .addLayers(EquipmentClientInfo.LayerType.WOLF_BODY,
                                new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "pearl_silver")))
                        .addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY,
                                new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "pearl_silver")))
                        .build());
    }

    @Override
    public CompletableFuture<?> run(final CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "NOHONOR Equipment Asset Provider";
    }

}
