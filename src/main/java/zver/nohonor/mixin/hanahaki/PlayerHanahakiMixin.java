// zver/nohonor/mixin/hanahaki/PlayerHanahakiMixin.java
package zver.nohonor.mixin.hanahaki;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiData;

@Mixin(Player.class)
public abstract class PlayerHanahakiMixin implements HanahakiData {
    //ХАНАХАКИ
    //Пустая строка = вариант не выбран.
    //
    //ВАЖНО: никакого addAdditionalSaveData/readAdditionalSaveData здесь нет — и это осознанно.
    //Вариант цветка не имеет собственного жизненного цикла отдельно от самого эффекта:
    //пока MobEffectInstance активен (а он персистентен через штатный "active_effects"),
    //synced data просто живёт вместе с игроком в рамках сессии. Если бы мы сохраняли
    //это поле отдельно, оно могло бы пережить сам эффект при смерти/респавне —
    //ровно та же ловушка, которую мы разобрали на Shatter, только сделанная бы
    //своими руками на пустом месте, где в ней нет никакой необходимости.
    @Unique
    private static final EntityDataAccessor<String> HANAHAKI_VARIANT =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.STRING);

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void nohonor$defineHanahakiData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(HANAHAKI_VARIANT, "");
    }

    @Override
    public @Nullable String getHanahakiVariant() {
        Player self = (Player) (Object) this;
        String value = self.getEntityData().get(HANAHAKI_VARIANT);
        return value.isEmpty() ? null : value;
    }

    @Override
    public void setHanahakiVariant(@Nullable String variant) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(HANAHAKI_VARIANT, variant == null ? "" : variant);
    }
}