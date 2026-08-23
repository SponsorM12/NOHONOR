package zver.nohonor.mixin.hanahaki;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.avatar_layers.hanahaki.HanahakiData;

@Mixin(Player.class)
public abstract class PlayerHanahakiMixin implements HanahakiData {
    //Персистентность вернули: теперь HanahakiEffect.onMobRemoved и
    //LivingEntityHanahakiMixin.onEffectsRemoved гарантированно очищают это поле
    //при ЛЮБОМ снятии эффекта, включая смерть. Раз очистка надёжна на всех
    //путях — сохранённое значение больше не может пережить сам эффект
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

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$saveHanahaki(ValueOutput output, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        output.putString("nohonor:hanahaki_variant", self.getEntityData().get(HANAHAKI_VARIANT));
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$loadHanahaki(ValueInput input, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(HANAHAKI_VARIANT, input.getString("nohonor:hanahaki_variant").orElse(""));
    }
}