package zver.nohonor.mixin.damage_type;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.damage_type.ModDamageTypes;

@Mixin(LivingEntity.class)
public abstract class LivingEntityPureDamageMixin {
    //Логика Чистого урона
    //Игнорируем броню
    @Inject(method = "getDamageAfterArmorAbsorb", at = @At("HEAD"), cancellable = true)
    private void nohonor$bypassArmorForPure(DamageSource source, float damage, CallbackInfoReturnable<Float> cir) {
        if (source.is(ModDamageTypes.PURE)) {
            //Возвращаем полный урон без расчета снижения от брони
            cir.setReturnValue(damage);
        }
    }

    //Игнорируем чары Защиты и зелья Сопротивления
    @Inject(method = "getDamageAfterMagicAbsorb", at = @At("HEAD"), cancellable = true)
    private void nohonor$bypassMagicForPure(DamageSource source, float damage, CallbackInfoReturnable<Float> cir) {
        if (source.is(ModDamageTypes.PURE)) {
            //Возвращаем полный урон без расчета снижения от чар
            cir.setReturnValue(damage);
        }
    }
}
