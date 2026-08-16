package zver.nohonor.item.special.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class ShcherbaruneItem extends ModTooltipItems implements SpecialItemBehavior {
    //МЕРЦАНИЕ - редкий "мираж"-телепорт на короткое расстояние.
    //По духу цвета ILLUSION: руна нестабильна и слегка "гуляет" сама по себе,
    //пока лежит на земле - усложняет прицельный забег за дропом в PvP

    private static final int BLINK_CHANCE = 8;//1 из N медленных тиков
    private static final int BLINK_RADIUS = 2;//горизонтальный разброс телепорта
    private static final int MAX_ATTEMPTS = 5;//попыток найти безопасную точку

    public ShcherbaruneItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public ShcherbaruneItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public ShcherbaruneItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public ShcherbaruneItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.onGround()) return; //не мешаем полёту/падению - моргает только осевшая руна

        RandomSource random = level.getRandom();
        if (random.nextInt(BLINK_CHANCE) != 0) return;

        BlockPos origin = itemEntity.blockPosition();

        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            int dx = random.nextInt(BLINK_RADIUS * 2 + 1) - BLINK_RADIUS;
            int dz = random.nextInt(BLINK_RADIUS * 2 + 1) - BLINK_RADIUS;
            if (dx == 0 && dz == 0) continue;
            //Безопасную точку не нашли за MAX_ATTEMPTS - просто ждём следующего медленного тика
            BlockPos candidate = origin.offset(dx, 0, dz);

            //Не телепортируем в стену и не топим в лаве (в воду можно)
            if (!level.getBlockState(candidate).isAir()) continue;
            if (level.getFluidState(candidate).is(FluidTags.LAVA)) continue;
            if (level.getBlockState(candidate.below()).isAir()) continue;

            Vec3 from = itemEntity.position();
            Vec3 to = Vec3.atBottomCenterOf(candidate);

            //level.sendParticles(ParticleTypes.PORTAL, from.x, from.y + 0.25, from.z,
            //        12, 0.25, 0.25, 0.25, 0.05);

            itemEntity.setPos(to.x, to.y, to.z);

            //level.sendParticles(ParticleTypes.PORTAL, to.x, to.y + 0.25, to.z,
            //        12, 0.25, 0.25, 0.25, 0.05);
            level.playSound(null, candidate, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL,
                    0.4f, 2.8f + random.nextFloat() * 0.2f);

            itemEntity.hurtMarked = true; //форс синка позиции клиенту - меняем её не физикой
            return;
        }
    }

}