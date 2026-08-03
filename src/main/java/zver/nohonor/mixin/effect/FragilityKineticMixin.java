package zver.nohonor.mixin.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class FragilityKineticMixin {

    private static final float FLY_INTO_WALL_MULTIPLIER = 2.0F;

    @ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), argsOnly = true)
    private float nohonor$amplifyKineticDamage(float dmg, ServerLevel level, DamageSource source) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (source.is(DamageTypes.FLY_INTO_WALL) && self.hasEffect(ModEffects.FRAGILITY)) {
            return dmg * FLY_INTO_WALL_MULTIPLIER;
        }
        return dmg;
    }
}