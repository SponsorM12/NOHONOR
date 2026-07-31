package zver.nohonor.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.Nullable;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

public class TenacityDrainEffect extends MobEffect {
    //Затрагивает стойкость
    //Мгновенное осушение Стойкости
    private static final float DRAIN_AMOUNT = 5f;

    public TenacityDrainEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantaneous() {
        return true;
    }

    //путь питья/сплэша/лингеринг
    @Override
    public void applyInstantaneousEffect(ServerLevel level, @Nullable Entity source, @Nullable Entity owner, LivingEntity mob, int amplification, double scale) {
        drain(mob, amplification, scale);
    }

    //путь стрелы
    //срабатывает при добавлении эффекта синхронно, не завязана на duration/тики
    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        super.onEffectStarted(entity, amplifier);
        drain(entity, amplifier, 1.0D);
    }

    private void drain(LivingEntity mob, int amplifier, double scale) {
        if (mob instanceof Player player) {
            TenacityData tenacityData = (TenacityData) player;
            float amountToDrain = (float) (DRAIN_AMOUNT * (amplifier + 1) * scale);
            tenacityData.setTenacity(tenacityData.getTenacity() - amountToDrain);
        }
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        drain(entity, amplifier, 1.0D);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount > 0 && tickCount % 20 == 0; //объяснить!?
    }

}