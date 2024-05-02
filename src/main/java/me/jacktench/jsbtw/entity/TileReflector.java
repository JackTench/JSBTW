package me.jacktench.jsbtw.entity;

import me.jacktench.jsbtw.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TileReflector extends BlockEntity
{
    public TileReflector(BlockEntityType<?> entity, BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.REFLECTOR.get(), pos, state);
    }
}
