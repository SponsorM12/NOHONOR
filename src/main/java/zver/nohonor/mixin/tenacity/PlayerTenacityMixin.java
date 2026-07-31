package zver.nohonor.mixin.tenacity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

@Mixin(Player.class)
public abstract class PlayerTenacityMixin implements TenacityData {
    //СТОЙКОСТЬ
    //Применяется только на игрока
    //Не на мобов, это так и задумано
    @Unique
    private static final EntityDataAccessor<Float> TENACITY =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.FLOAT);

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void nohonor$defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(TENACITY, 0f);
    }

    @Override
    public float getTenacity() {
        Player self = (Player) (Object) this;
        return self.getEntityData().get(TENACITY);
    }

    @Override
    public void setTenacity(float tenacity) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(TENACITY, Math.clamp(tenacity, 0f, TenacityData.MAX_TENACITY));
    }

    @Override
    public float getMaxTenacity() {
        return TenacityData.MAX_TENACITY;
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$saveTenacity(ValueOutput output, CallbackInfo ci) {
        output.putFloat("nohonor:tenacity", this.getTenacity());
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$loadTenacity(ValueInput input, CallbackInfo ci) {
        this.setTenacity(input.getFloatOr("nohonor:tenacity", 0f));
    }

}