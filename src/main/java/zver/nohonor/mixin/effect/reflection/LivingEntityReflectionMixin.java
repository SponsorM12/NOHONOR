package zver.nohonor.mixin.effect.reflection;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.avatar_layers.reflection.ReflectionData;
import zver.nohonor.effect.ModEffects;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class LivingEntityReflectionMixin {

    @Inject(method = "onEffectsRemoved", at = @At("HEAD"))
    private void nohonor$clearReflectionOnRemoved(Collection<MobEffectInstance> effects, CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!(self instanceof Player player)) return;
        for (MobEffectInstance effect : effects) {
            if (effect.is(ModEffects.REFLECTION)) {
                ((ReflectionData) player).setReflecting(false);
                break;
            }
        }
    }

}