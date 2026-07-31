// zver.nohonor.effect.custom.ScorchEffect
package zver.nohonor.effect.custom;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import zver.nohonor.NOHONOR;

public class ScorchEffect extends MobEffect {
    //ОЖОГ - снимает % максимального здоровья за уровень. Затрагивает атрибут
    public ScorchEffect(MobEffectCategory category, int color) {
        super(category, color);

        this.addAttributeModifier(
                Attributes.MAX_HEALTH,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "scorch_health_reduction"),
                -0.10, // -10% за каждый уровень (amplifier + 1)
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }

    //@Override
   // public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        //
   //     return  super.applyEffectTick(serverLevel, mob, amplification);
   // }

   // @Override
  //  public boolean shouldApplyEffectTickThisTick(int tickCount, int amplidication) {
  //      return true;
  //  }
}