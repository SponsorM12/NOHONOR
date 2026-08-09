package zver.nohonor.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiData;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiVariants;

public class HanahakiEffect extends MobEffect {
    //Чисто косметический эффект. Никакой игровой логики — только выбор варианта цветка.

    public HanahakiEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onEffectStarted(LivingEntity mob, int amplifier) {
        super.onEffectStarted(mob, amplifier);

        if (mob.level().isClientSide()) {
            return;
        }

        if (!(mob instanceof Player player)) {
            return;
        }

        HanahakiData data = (HanahakiData) player;
        if (data.getHanahakiVariant() == null) {
            data.setHanahakiVariant(HanahakiVariants.pickRandom(mob.getRandom()));
        }
    }

    @Override
    public void onMobRemoved(ServerLevel level, LivingEntity mob, int amplifier, Entity.RemovalReason reason) {
        super.onMobRemoved(level, mob, amplifier, reason);
        if (mob instanceof Player player) {
            ((HanahakiData) player).setHanahakiVariant(null);
        }
    }

}