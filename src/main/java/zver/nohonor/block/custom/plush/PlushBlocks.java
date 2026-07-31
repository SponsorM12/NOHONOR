package zver.nohonor.block.custom.plush;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import zver.nohonor.sound.ModSounds;

public class PlushBlocks extends Block {
    //Свойство направления - север юг запад тд
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    //Стандартный хитбокс, при направлении севере
    public static final VoxelShape SHAPE_Z = Block.box(4, 0, 0, 12, 8, 16);

    //Повернутый хитбокс, на запад-восток инвертированы размеры
    public static final VoxelShape SHAPE_X = Block.box(0, 0, 4, 16, 8, 12);

    //Устанавливаем состояние по умолчанию
    //объяснить
    public PlushBlocks(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //Направленеи взгляда игрока - блок ставится навстерчу игроку лицом
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    //Вращение хитбокса
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        //Если блок смотрит на восток или запад, возвращаем форму, вытянутую по оси X
        if (direction.getAxis() == Direction.Axis.X) {
            return SHAPE_X;
        }
        //Иначе (север/юг) вытянутую по оси Z
        return SHAPE_Z;
    }

    //Эти методы нужны для правильной работы структур и команд
    //объяснить
    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    //@Override
    //public InteractionResult useOn(UseOnContext context) {
    //    Level level = context.getLevel();

   //     if..
    //    level.playSound(null, context.getClickedPos(), ModSounds.A, SoundSource.BLOCK, 1.0f,
    //            0.0f + level.getRandom().nextFloat() * 0.4f);
   // }

    //Метод взят из Хейбела - снижение урона от падения
    @Override
    public void fallOn(final Level level, final BlockState state, final BlockPos pos, final Entity entity, final double fallDistance) {
        entity.causeFallDamage(fallDistance, 0.2F, level.damageSources().fall());
    }

}