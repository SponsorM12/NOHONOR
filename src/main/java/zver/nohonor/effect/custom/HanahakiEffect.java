// zver/nohonor/effect/custom/HanahakiEffect.java
package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiData;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiVariants;

public class HanahakiEffect extends MobEffect {
    //Чисто косметический эффект. Никакой игровой логики — только выбор варианта цветка.

    public HanahakiEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    //Вызывается и при первом наложении, и при повторном поверх активного — этим и пользуемся,
    //чтобы перевыбор происходил каждый раз (решили так сознательно)
    @Override
    public void onEffectStarted(LivingEntity mob, int amplifier) {
        super.onEffectStarted(mob, amplifier);

        //onEffectStarted вызывается и на клиенте тоже — если не отфильтровать,
        //сервер и клиент выберут РАЗНЫЕ варианты независимо друг от друга
        if (mob.level().isClientSide()) {
            return;
        }

        if (!(mob instanceof Player player)) {
            return; //пока только игроки
        }

        ((HanahakiData) player).setHanahakiVariant(HanahakiVariants.pickRandom(mob.getRandom()));
    }
}