package zver.nohonor.client.hanahaki.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.model.player.PlayerModel;

public class HanahakiModel extends PlayerModel {
    private static final String HANAHAKI = "hanahaki";
    private final ModelPart hanahaki; //never used

    public HanahakiModel(ModelPart root) {
        super(root, false);
        this.hanahaki = this.head.getChild(HANAHAKI);
    }

    public static LayerDefinition createBaseLayer() {
        MeshDefinition mesh = PlayerModel.createMesh(CubeDeformation.NONE, false);
        PartDefinition root = mesh.getRoot().clearRecursively();
        PartDefinition head = root.getChild("head");
        head.addOrReplaceChild(HANAHAKI, CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(+0.7F)),
                PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }

}