package zver.nohonor.client.entity.custom.gnome;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation; // Обязательный новый импорт
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import zver.nohonor.client.entity.EntityRenderState;

public class GnomeEntityModel extends EntityModel<EntityRenderState> {
    private final ModelPart head;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final KeyframeAnimation dancing;


    public GnomeEntityModel(ModelPart root) {
        super(root);
        // Привязываем переменные к узлам модели
        this.head = root.getChild(PartNames.HEAD);
        this.leftArm = this.head.getChild(PartNames.LEFT_ARM);   // именно через head, не root
        this.rightArm = this.head.getChild(PartNames.RIGHT_ARM);
        this.leftLeg = root.getChild(PartNames.LEFT_LEG);
        this.rightLeg = root.getChild(PartNames.RIGHT_LEG);
        this.dancing = GnomeAnimations.DANCING.bake(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition root = modelData.getRoot();

        //Узел HEAD
        PartDefinition head = root.addOrReplaceChild(
                PartNames.HEAD,
                CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 16).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F))
                        .texOffs(32, 0).mirror().addBox(-2.5F, -5.0F, 4.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                        .texOffs(32, 8).mirror().addBox(-2.5F, -5.0F, 4.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false),
                PartPose.offset(0.0F, 19.0F, 0.0F)
        );

        //дочерние элементы HEAD
        head.addOrReplaceChild(
                "left_antenna",
                CubeListBuilder.create().texOffs(48, 7).addBox(0.0F, -5.8839F, -2.5399F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, -4.0F, 0.0F, -0.6109F, 0.0F, 0.0F)
        );

        head.addOrReplaceChild(
                "right_antenna",
                CubeListBuilder.create().texOffs(48, 7).addBox(-1.0F, -5.8839F, -2.5399F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, -4.0F, 0.0F, -0.6109F, 0.0F, 0.0F)
        );

        head.addOrReplaceChild(
                PartNames.RIGHT_ARM,
                CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offsetAndRotation(-3.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.8727F)
        );

        head.addOrReplaceChild(
                PartNames.LEFT_ARM,
                CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offsetAndRotation(3.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.8727F)
        );

        //Ноги
        root.addOrReplaceChild(
                PartNames.RIGHT_LEG,
                CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.0F, 20.0F, 0.0F)
        );

        root.addOrReplaceChild(
                PartNames.LEFT_LEG,
                CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(-1.0F, 20.0F, 0.0F)
        );

        return LayerDefinition.create(modelData, 64, 32);
    }

    @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);

        if (state.dancingAnimationState.isStarted()) {
            this.dancing.apply(state.dancingAnimationState, state.ageInTicks);
        } else {
            this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
            this.head.yRot = state.yRot * Mth.DEG_TO_RAD;

            float limbSwingAmplitude = state.walkAnimationSpeed;
            float limbSwingAnimationProgress = state.walkAnimationPos;

            this.leftArm.xRot = Mth.cos(limbSwingAnimationProgress * 0.2f) * 1.0f * limbSwingAmplitude;
            this.rightArm.xRot = Mth.cos(limbSwingAnimationProgress * 0.2f + Mth.PI) * 1.0f * limbSwingAmplitude;
            this.leftLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.2f + Mth.PI) * 1.4f * limbSwingAmplitude;
            this.rightLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.2f) * 1.4f * limbSwingAmplitude;
        }
    }
}