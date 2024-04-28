package me.jacktench.jsbtw.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockSpeedStone extends Block
{
    public BlockSpeedStone(Properties properties)
    {
        super(properties);
    }

    // Apply speed effect when block is stepped on.
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
    {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10));
        }
        super.stepOn(level, pos, state, entity);
    }
}
