package zver.nohonor.mixin.effect;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Player.class)
public abstract class PlayerDisarmMixin {
    //Обезоруживание
    //Для игрока
    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockAttackUnderDisarm(Entity entity, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        if (self.hasEffect(ModEffects.DISARM)) {
            ci.cancel();
        }
    }

    @Inject(method = "stabAttack", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockStabAttackUnderDisarm(EquipmentSlot slot, Entity target, float baseDamage,
                                                    boolean dealsDamage, boolean dealsKnockback, boolean dismounts,
                                                    CallbackInfoReturnable<Boolean> cir) {
        Player self = (Player) (Object) this;
        if (self.hasEffect(ModEffects.DISARM)) {
            cir.setReturnValue(false);
        }
    }

}