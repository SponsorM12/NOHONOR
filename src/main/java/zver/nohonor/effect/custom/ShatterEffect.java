package zver.nohonor.effect.custom;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import zver.nohonor.NOHONOR;

public class ShatterEffect extends MobEffect {
    //РАСКОЛ - снижает броню в % соотношении за уровень. Затрагивает атрибут.
    //Принцип действия как в Ожога, но этот меняется динамически, а так же он
    //снижает броню не от МАксимума, а от текущего значения
    public ShatterEffect(MobEffectCategory category, int color) {
        super(category, color);

        this.addAttributeModifier(
                Attributes.ARMOR,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "shatter_armor_reduction"),
                -0.20, // -20% за каждый уровень (amplifier + 1)
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }

    //@Override
    //public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {

        //

    //    return  super.applyEffectTick(serverLevel, mob, amplification);
    //}

    //@Override
    //public boolean shouldApplyEffectTickThisTick(int tickCount, int amplidication) {
    //    return true;
    //}

}
