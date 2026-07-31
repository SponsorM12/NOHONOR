package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class ModBerryBushBlocks extends SweetBerryBushBlock {

    //Добавляем переменную для хранения предмета, который будет выпадать
    private final Supplier<Item> berryItem;

    //Добавляем Supplier<Item> в конструктор
    public ModBerryBushBlocks(Properties properties, Supplier<Item> berryItem) {
        super(properties);
        this.berryItem = berryItem;
    }

    //Возвращаем предмет из Supplier
    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData){
        return new ItemStack(this.berryItem.get());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int age = state.getValue(AGE);
        boolean isGrown = age == 3;
        if (age > 1) {
            int count = 1 + level.getRandom().nextInt(2);
            //При сборе урожая выдаем правильный предмет
            popResource(level, pos, new ItemStack(this.berryItem.get(), count + (isGrown ? 1 : 0)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                    1.0F, 0.8F + level.getRandom().nextFloat() * 0.4F);
            BlockState newState = state.setValue(AGE,1);
            level.setBlock(pos,newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.SUCCESS;

        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }
}