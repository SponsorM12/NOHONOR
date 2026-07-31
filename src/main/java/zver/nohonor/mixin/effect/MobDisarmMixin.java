package zver.nohonor.mixin.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Mob.class)
public abstract class MobDisarmMixin {
    //Обезоруживание
    //Для Моба
    @Inject(method = "doHurtTarget", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockMobMeleeAttackUnderDisarm(ServerLevel level, Entity target, CallbackInfoReturnable<Boolean> cir) {
        Mob self = (Mob) (Object) this;
        //Если на мобе висит эффект обезоруживания
        if (self.hasEffect(ModEffects.DISARM)) {
            //Отменяем атаку - Моб не нанесет урон и не вызовет эффекты при попадании
            cir.setReturnValue(false);
        }
    }
}