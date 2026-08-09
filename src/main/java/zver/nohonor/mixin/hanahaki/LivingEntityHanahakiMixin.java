package zver.nohonor.mixin.hanahaki;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiData;
import zver.nohonor.effect.ModEffects;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class LivingEntityHanahakiMixin {
    //Закрывает "нормальные" пути снятия — истечение по времени, removeEffect,
    //removeAllEffects. Единственный путь, который сюда НЕ попадает — смерть,
    //там отдельно ловит HanahakiEffect.onMobRemoved
    @Inject(method = "onEffectsRemoved", at = @At("HEAD"))
    private void nohonor$clearHanahakiOnRemoved(Collection<MobEffectInstance> effects, CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!(self instanceof Player player)) {
            return;
        }
        for (MobEffectInstance effect : effects) {
            if (effect.is(ModEffects.HANAHAKI)) {
                ((HanahakiData) player).setHanahakiVariant(null);
                break;
            }
        }
    }
}