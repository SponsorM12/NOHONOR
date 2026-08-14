package zver.nohonor.item.special.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class LyutyyItem extends ModTooltipItems implements SpecialItemBehavior {

    public LyutyyItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public LyutyyItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public LyutyyItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public LyutyyItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.isInWater()) return;

        Vec3 pos = itemEntity.position();
        level.sendParticles(ParticleTypes.EXPLOSION, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
        level.playSound(null, pos.x, pos.y, pos.z, SoundEvents.GENERIC_EXPLODE,
                SoundSource.NEUTRAL, 1.0f, 1.0f);
        itemEntity.discard();
    }

}
