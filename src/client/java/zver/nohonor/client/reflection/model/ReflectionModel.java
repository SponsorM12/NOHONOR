package zver.nohonor.client.reflection.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;

public class ReflectionModel extends EntityModel<AvatarRenderState> {
    private static final String BODY = "Body";
    private final ModelPart body;

    public ReflectionModel(ModelPart root) {
        super(root);
        this.body = root.getChild(BODY);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Перенесено из Blockbench (размер -8..16, CubeDeformation 3.0F)
        partdefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-8.0F, -8.0F, -8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(3.0F)),
                PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(AvatarRenderState state) {
        // Логика анимации поворота/сдвига, если нужна
    }

}