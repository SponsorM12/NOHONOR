package zver.nohonor.client.reflection;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;

public class ReflectionModelLayers {

    public static final ModelLayerLocation SHROUD =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "reflection/shroud"), "main");

}