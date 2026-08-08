package zver.nohonor.client.entity;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.client.entity.gnome.GnomeEntityModel;

public class ModEntityModelLayers {
    public static final ModelLayerLocation GNOME = createMain("gnome");

    private static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name), "main");
    }

    public static void initialize() {
        ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.GNOME, GnomeEntityModel::getTexturedModelData);
    }
}
