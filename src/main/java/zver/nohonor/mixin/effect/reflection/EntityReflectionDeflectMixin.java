package zver.nohonor.mixin.effect.reflection;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Entity.class)
public abstract class EntityReflectionDeflectMixin {
    //deflection() объявлен в Entity, а не в Player — миксим сюда с проверкой типа,
    //тот же паттерн, что LivingEntityCurseMixin/LivingEntityImmunityMixin
    @Inject(method = "deflection", at = @At("HEAD"), cancellable = true)
    private void nohonor$deflectWhileReflecting(Projectile projectile, CallbackInfoReturnable<ProjectileDeflection> cir) {
        Entity self = (Entity) (Object) this;
        if (self instanceof Player player && player.hasEffect(ModEffects.REFLECTION)) {
            //Звук и логика отскока — дословно та же строка, что у Breeze.PROJECTILE_DEFLECTION
            self.level().playSound((Entity) null, self, SoundEvents.BREEZE_DEFLECT, self.getSoundSource(), 1.0F, 1.0F);
            cir.setReturnValue(ProjectileDeflection.REVERSE);
        }
    }

}
