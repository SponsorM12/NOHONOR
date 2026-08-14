package zver.nohonor.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import zver.nohonor.custom_mechanics.reflection.ReflectionData;

public class ReflectionEffect extends MobEffect {
    //Механика отскока доступна любому LivingEntity (см. EntityReflectionDeflectMixin).
    //Визуальный барьер — только у игрока, синхронизируется собственным полем
    public ReflectionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    // ReflectionEffect.java — оба места, где сейчас true/false, дописать амплификатор
    @Override
    public void onEffectStarted(LivingEntity mob, int amplifier) {
        super.onEffectStarted(mob, amplifier);
        if (mob.level().isClientSide()) return;
        if (mob instanceof Player player) {
            ReflectionData data = (ReflectionData) player;
            data.setReflecting(true);
            data.setReflectionAmplifier(amplifier);
        }

    }

    @Override
    public void onMobRemoved(ServerLevel level, LivingEntity mob, int amplifier, Entity.RemovalReason reason) {
        super.onMobRemoved(level, mob, amplifier, reason);
        if (mob instanceof Player player) {
            ((ReflectionData) player).setReflecting(false);
        }
    }

}