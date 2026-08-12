package zver.nohonor.client.avatar_layers.hanahaki;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;

public class HanahakiModelLayers {

    public static final ModelLayerLocation BASE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hanahaki/base"), "main");

    private HanahakiModelLayers() {}

}