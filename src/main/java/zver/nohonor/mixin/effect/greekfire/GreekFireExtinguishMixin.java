package zver.nohonor.mixin.effect.greekfire;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.effect.ModEffects;

@Mixin(Entity.class)
public abstract class GreekFireExtinguishMixin {
    //ГРЕЧЕСКИЙ ОГОНЬ
    //не даём тушить
    @Inject(method = "clearFire", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockExtinguish(CallbackInfo ci) {
        Entity self = (Entity) (Object) this;
        if (self.level() instanceof ServerLevel
                && self instanceof LivingEntity living
                && living.hasEffect(ModEffects.GREEK_FIRE)
                && living.getRemainingFireTicks() > 0
                && !living.fireImmune()) {
            ci.cancel();
        }
    }

}