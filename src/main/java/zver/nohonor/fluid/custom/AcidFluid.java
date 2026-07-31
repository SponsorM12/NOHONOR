package zver.nohonor.fluid.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import zver.nohonor.block.ModBlocks;
import zver.nohonor.fluid.ModFluid;
import zver.nohonor.fluid.ModFluids;
import zver.nohonor.item.ModItems;
import zver.nohonor.tag.ModTags;

import java.util.function.Supplier;

public class AcidFluid extends ModFluid {
    //надо переписать из гаида инструкции

    public AcidFluid(boolean source) {
        super(source);
    }

    @Override
    public void animateTick(Level world, BlockPos pos, FluidState state, RandomSource random) {
        if (!state.isSource() && !state.getValue(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playLocalSound(
                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        SoundEvents.BUBBLE_COLUMN_WHIRLPOOL_AMBIENT,
                        SoundSource.AMBIENT,
                        random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F,
                        false);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER,
                    pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(),
                    0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void entityInside(Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier handler) {
        handler.apply(InsideBlockEffectType.EXTINGUISH);

        if (!(world instanceof ServerLevel serverLevel) || !(entity instanceof LivingEntity livingEntity)) return;

        if (world.getGameTime() % 20 == 0) {
            livingEntity.hurtServer(serverLevel, world.damageSources().magic(), 2.0F); //не забыть сделать свой тип урона
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 0));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
        }
    }

    @Override
    protected Supplier<? extends Fluid> stillFluid() {
        return () -> ModFluids.ACID_STILL;
    }

    @Override
    protected Supplier<? extends Fluid> flowingFluid() {
        return () -> ModFluids.ACID_FLOWING;
    }

    @Override
    protected Supplier<? extends Block> liquidBlock() {
        return () -> ModBlocks.ACID;
    }

    @Override
    protected Supplier<? extends Item> bucketItem() {
        return () -> ModItems.ACID_BUCKET;
    }

    @Override
    protected TagKey<Fluid> fluidTag() {
        return ModTags.Fluids.ACID;
    }
}