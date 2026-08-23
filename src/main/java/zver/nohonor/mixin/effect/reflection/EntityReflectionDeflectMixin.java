package zver.nohonor.mixin.effect.reflection;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.custom_mechanics.avatar_layers.reflection.ReflectionData;
import zver.nohonor.effect.ModEffects;

@Mixin(Entity.class)
public abstract class EntityReflectionDeflectMixin {

    @Inject(method = "deflection", at = @At("HEAD"), cancellable = true)
    private void nohonor$deflectWhileReflecting(Projectile projectile, CallbackInfoReturnable<ProjectileDeflection> cir) {
        Entity self = (Entity) (Object) this;

        boolean isReflecting = false;
        if (self instanceof ReflectionData reflectionData) {
            isReflecting = reflectionData.isReflecting();
        } else if (self instanceof LivingEntity living) {
            isReflecting = living.hasEffect(ModEffects.REFLECTION);
        }

        if (isReflecting) {
            self.level().playSound((Entity) null, self, SoundEvents.BREEZE_DEFLECT, self.getSoundSource(), 1.0F, 1.0F);

            // EntityReflectionDeflectMixin.java — читаем амплификатор из того же безопасного источника
            int amplifier = 0;
            if (self instanceof ReflectionData reflectionData) {
                amplifier = reflectionData.getReflectionAmplifier();
            } else if (self instanceof LivingEntity living) {
                MobEffectInstance effect = living.getEffect(ModEffects.REFLECTION);
                if (effect != null) amplifier = effect.getAmplifier();
            }

            final int finalAmplifier = amplifier;
            ProjectileDeflection customDeflection = (proj, entity, random) -> {
                //Небольшой разброс (170 +- 190) предотвращает мертвые петли между двумя сущностями
                float rotation = 170.0F + random.nextFloat() * 20.0F;

                //Расчет базового множителя
                double speedMultiplier = -0.5 * (1.0 + (finalAmplifier * 3.0));

                Vec3 currentMovement = proj.getDeltaMovement();
                Vec3 newMovement = currentMovement.scale(speedMultiplier);

                //Защита от бесконечного ускорения кап скорости = 16 блоковв тик
                double maxSpeed = 16.0;
                if (newMovement.lengthSqr() > maxSpeed * maxSpeed) {
                    newMovement = newMovement.normalize().scale(maxSpeed);
                }

                proj.setDeltaMovement(newMovement);
                proj.setYRot(proj.getYRot() + rotation);
                proj.yRotO += rotation;
                proj.needsSync = true;
            };

            cir.setReturnValue(customDeflection);
        }
    }

}