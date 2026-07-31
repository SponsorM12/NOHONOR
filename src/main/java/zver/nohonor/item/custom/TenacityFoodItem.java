package zver.nohonor.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import zver.nohonor.stat.ModStats;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

public class TenacityFoodItem extends Item {
    private final float tenacityRestoreAmount;

    // В конструктор добавляем параметр количества восстанавливаемой стойкости
    public TenacityFoodItem(Properties properties, float tenacityRestoreAmount) {
        super(properties);
        this.tenacityRestoreAmount = tenacityRestoreAmount;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        if (!level.isClientSide() && entityLiving instanceof Player player) {
            TenacityData tenacityData = (TenacityData) player;
            float currentTenacity = tenacityData.getTenacity();
            float maxTenacity = tenacityData.getMaxTenacity(); // Берем из твоего интерфейса

            // 1. Считаем, сколько реально можно восстановить (чтобы не уйти за MAX_TENACITY)
            float actualRestored = Math.min(this.tenacityRestoreAmount, maxTenacity - currentTenacity);

            // 2. Устанавливаем новое значение стойкости
            tenacityData.setTenacity(currentTenacity + actualRestored);
            //tenacityData.setTenacity(currentTenacity + this.tenacityRestoreAmount);

            // 3. Записываем статистику (округляем float до int)
            int statAmount = Math.round(actualRestored);
            if (statAmount > 0) {
                player.awardStat(ModStats.TENACITY_RESTORED, statAmount);
            }
        }

        return super.finishUsingItem(stack, level, entityLiving);
    }
}