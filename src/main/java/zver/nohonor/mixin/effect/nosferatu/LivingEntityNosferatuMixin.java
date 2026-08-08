package zver.nohonor.mixin.effect.nosferatu;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityNosferatuMixin {
    //Вампиризм
    @Shadow public abstract float getHealth(); //never used
    @Shadow public abstract float getAbsorptionAmount();//never used

    @Inject(method = "actuallyHurt", at = @At("HEAD"))
    private void nohonor$applyNosferatuLifesteal(ServerLevel level, DamageSource source, float dmg, CallbackInfo ci) {
        LivingEntity victim = (LivingEntity) (Object) this;

        if (dmg <= 0.0f || victim.isDeadOrDying()) {
            return;
        }

        Entity attacker = source.getEntity();
        Entity directEntity = source.getDirectEntity();
        //зачем здесь двойная if напомни?
        if (attacker instanceof LivingEntity livingAttacker && attacker == directEntity) {
            if (livingAttacker.hasEffect(ModEffects.NOSFERATU)) {

                int amplifier = livingAttacker.getEffect(ModEffects.NOSFERATU).getAmplifier();
                int effectLevel = amplifier + 1;

                float damageAfterAbsorption = Math.max(0.0f, dmg - victim.getAbsorptionAmount());
                float actualHpLost = Math.min(victim.getHealth(), damageAfterAbsorption);

                if (actualHpLost > 0) {
                    float healPercentage = 0.125f * effectLevel;
                    float healAmount = actualHpLost * healPercentage;

                    if (healAmount > 0) {
                        livingAttacker.heal(healAmount);
                    }
                }
            }
        }

    }

}