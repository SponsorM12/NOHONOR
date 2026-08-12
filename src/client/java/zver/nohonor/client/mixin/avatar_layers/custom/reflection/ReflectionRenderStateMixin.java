package zver.nohonor.client.mixin.avatar_layers.custom.reflection;

import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import zver.nohonor.client.avatar_layers.reflection.ReflectionRenderStateAccessor;

@Mixin(AvatarRenderState.class)
public abstract class ReflectionRenderStateMixin implements ReflectionRenderStateAccessor {

    @Unique
    private boolean nohonor$reflecting = false;

    @Override
    public boolean nohonor$isReflecting() {
        return this.nohonor$reflecting;
    }

    @Override
    public void nohonor$setReflecting(boolean reflecting) {
        this.nohonor$reflecting = reflecting;
    }

}