package zver.nohonor.client.entity.boat;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.entity.boat.ModBoats;

public class ModBoatRenderer {

    public static final ModelLayerLocation HESPERIDES_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "boat/hesperides"), "main");

    public static final ModelLayerLocation HESPERIDES_CHEST_BOAT_LAYER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "chest_boat/hesperides"), "main");

    public static void initialize() {
        ModelLayerRegistry.registerModelLayer(
                HESPERIDES_BOAT_LAYER,
                BoatModel::createBoatModel
        );
        ModelLayerRegistry.registerModelLayer(
                HESPERIDES_CHEST_BOAT_LAYER,
                BoatModel::createChestBoatModel
        );

        //Обычная лодка
        EntityRendererRegistry.register(
                ModBoats.HESPERIDES_BOAT,
                context -> new BoatRenderer(context, HESPERIDES_BOAT_LAYER)
        );
        //Чест боат
        EntityRendererRegistry.register(
                ModBoats.HESPERIDES_CHEST_BOAT,
                context -> new BoatRenderer(context, HESPERIDES_CHEST_BOAT_LAYER)
        );
    }
}