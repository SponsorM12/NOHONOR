package zver.nohonor.item.special.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class HellesteroyItem extends ModTooltipItems implements SpecialItemBehavior {

    // Зеркальные конструкторы — как в ModTooltipItems
    public HellesteroyItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public HellesteroyItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public HellesteroyItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public HellesteroyItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        if (level.isEmptyBlock(pos)) {
            level.setBlockAndUpdate(pos, Blocks.FIRE.defaultBlockState());
            level.playSound(context.getPlayer(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS,
                    1.0f, level.getRandom().nextFloat() * 0.4f + 0.8f);
            return InteractionResult.SUCCESS;
        } //Баг когда на 0.1 секунды появляется Огонь поверх Блока Огня
        return InteractionResult.PASS;
    }

    @Override
    public void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.onGround()) return;

        BlockPos feet = itemEntity.blockPosition();
        if (level.isEmptyBlock(feet) && !level.getBlockState(feet.below()).isAir()) {
            level.setBlockAndUpdate(feet, Blocks.FIRE.defaultBlockState());
        }
    }

}