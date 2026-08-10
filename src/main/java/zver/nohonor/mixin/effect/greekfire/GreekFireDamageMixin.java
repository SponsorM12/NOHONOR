package zver.nohonor.mixin.effect.greekfire;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import zver.nohonor.effect.ModEffects;

@Mixin(Entity.class)
public abstract class GreekFireDamageMixin {
    //ГРЕЧЕСКИЙ ОГОНЬ
    //увеличиваем урон на +1 за уровень
    @ModifyArg(method = "baseTick", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/Entity;hurtServer(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)Z"),
            index = 2)
    private float nohonor$amplifyGreekFireDamage(float damage) {
        Entity self = (Entity) (Object) this;
        if (self instanceof LivingEntity living && living.hasEffect(ModEffects.GREEK_FIRE)) {
            int amplifier = living.getEffect(ModEffects.GREEK_FIRE).getAmplifier();
            return damage + (float) (amplifier + 1);
        }
        return damage;
    }

}