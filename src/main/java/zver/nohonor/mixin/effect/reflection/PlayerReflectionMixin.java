package zver.nohonor.mixin.effect.reflection;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.reflection.ReflectionData;
import zver.nohonor.effect.ModEffects;

@Mixin(Player.class)
public abstract class PlayerReflectionMixin implements ReflectionData {
    @Unique
    private static final EntityDataAccessor<Boolean> REFLECTING =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.BOOLEAN);

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void nohonor$defineReflectionData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(REFLECTING, false);
    }

    @Override
    public boolean isReflecting() {
        Player self = (Player) (Object) this;
        return self.getEntityData().get(REFLECTING);
    }

    @Override
    public void setReflecting(boolean reflecting) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(REFLECTING, reflecting);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$resyncReflectionOnLoad(ValueInput input, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        this.setReflecting(self.hasEffect(ModEffects.REFLECTION));
    }

}