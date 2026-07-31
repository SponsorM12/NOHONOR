package zver.nohonor.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

public class TenacityRegenEffect extends MobEffect {
    //Затрагивает стойкость
    //Реген Стойкости
    private static final float RESTORE_PER_SECOND = 1f;
    private static final int TICK_INTERVAL = 20;

    public TenacityRegenEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            TenacityData tenacityData = (TenacityData) player;
            tenacityData.setTenacity(tenacityData.getTenacity() + RESTORE_PER_SECOND * (amplifier + 1));
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % TICK_INTERVAL == 0;
    }
}