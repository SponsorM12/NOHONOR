package zver.nohonor.client.mixin.avatar_layers.custom.hanahaki;

import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import zver.nohonor.client.avatar_layers.hanahaki.HanahakiRenderStateAccessor;

@Mixin(AvatarRenderState.class)
public abstract class AvatarRenderStateMixin implements HanahakiRenderStateAccessor {

    @Unique
    private @Nullable String nohonor$hanahakiVariant;

    @Override
    public @Nullable String nohonor$getHanahakiVariant() {
        return this.nohonor$hanahakiVariant;
    }

    @Override
    public void nohonor$setHanahakiVariant(@Nullable String variant) {
        this.nohonor$hanahakiVariant = variant;
    }

}