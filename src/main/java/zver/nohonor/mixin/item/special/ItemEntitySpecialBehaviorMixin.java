package zver.nohonor.mixin.item.special;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.item.special.SpecialItemBehavior;

@Mixin(ItemEntity.class)
public abstract class ItemEntitySpecialBehaviorMixin {

    private static final int SLOW_PATH_INTERVAL = 20;

    @Inject(method = "tick", at = @At("TAIL"))
    private void nohonor$dispatchSpecialBehavior(CallbackInfo ci) {
        ItemEntity self = (ItemEntity) (Object) this;

        if (!(self.level() instanceof ServerLevel serverLevel)) return;

        if (!(self.getItem().getItem() instanceof SpecialItemBehavior special)) return;

        special.onEveryTick(self, serverLevel);

        if (serverLevel.getGameTime() % SLOW_PATH_INTERVAL == 0) {
            special.onWorldTick(self, serverLevel);
        }
    }

}
