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
        //Два слоя на одном child'е — тот же паттерн, что у ванильного head+hat:
        //внутренний слой (inflate 0.6) + внешний оверлей (inflate 0.7), обе части
        //рисуются одним CubeListBuilder'ом, цепочкой texOffs()+addBox()
        head.addOrReplaceChild(HANAHAKI, CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.6F))
                        .texOffs(32, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.7F)),
                PartPose.ZERO);
        //Текстура буквально как у слоя головы и шляпы с оригинальныйх текстур игрока
        return LayerDefinition.create(mesh, 64, 16);

    }

}