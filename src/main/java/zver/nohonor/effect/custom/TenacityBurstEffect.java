package zver.nohonor.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.Nullable;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

public class TenacityBurstEffect extends MobEffect {
    //Затрагивает стойкость
    //Мгновенное востановление Стойкости
    private static final float RESTORE_AMOUNT = 5f;

    public TenacityBurstEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantaneous() {
        return true;
    }

    //путь питья/сплэша/лингеринг
    @Override
    public void applyInstantaneousEffect(ServerLevel level, @Nullable Entity source, @Nullable Entity owner, LivingEntity mob, int amplification, double scale) {
        restore(mob, amplification, scale);
    }

    //путь стрелы
    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        super.onEffectStarted(entity, amplifier);
        restore(entity, amplifier, 1.0D);
    }

    private void restore(LivingEntity mob, int amplifier, double scale) {
        if (mob instanceof Player player) {
            TenacityData tenacityData = (TenacityData) player;
            float amountToRestore = (float) (RESTORE_AMOUNT * (amplifier + 1) * scale);
            tenacityData.setTenacity(tenacityData.getTenacity() + amountToRestore);
        }
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        restore(entity, amplifier, 1.0D);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount > 0 && tickCount % 20 == 0; //объяснить?
    }

}