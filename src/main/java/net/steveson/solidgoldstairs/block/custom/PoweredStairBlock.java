package net.steveson.solidgoldstairs.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.steveson.solidgoldstairs.util.ModTags;

public class PoweredStairBlock extends StairsBlock {
    public PoweredStairBlock(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    // Needs to be true for getStrongRedstonePower to work. Is not directional.
    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(HALF) == BlockHalf.TOP) {
            if (direction == Direction.UP && world.getBlockState(pos.down()).isIn(ModTags.Blocks.LOW_REDSTONE_COMPONENTS)) {
                return 0;
            }
            if (state.get(FACING) == direction) {
                if (!world.getBlockState(pos.offset(direction.getOpposite())).isIn(ModTags.Blocks.LOW_REDSTONE_COMPONENTS)) {
                    return 11;
                }
                return 0;
            }
            if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                if (state.get(FACING).rotateYCounterclockwise() == direction) {
                    if (!world.getBlockState(pos.offset(direction.getOpposite())).isIn(ModTags.Blocks.LOW_REDSTONE_COMPONENTS)) {
                        return 11;
                    }
                    return 0;
                }
            }
            if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                if (state.get(FACING).rotateYClockwise() == direction) {
                    if (!world.getBlockState(pos.offset(direction.getOpposite())).isIn(ModTags.Blocks.LOW_REDSTONE_COMPONENTS)) {
                        return 11;
                    }
                    return 0;
                }
            }
        }
        return 11;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (world.getBlockState(pos.offset(direction.getOpposite())).getBlock() == Blocks.COMPARATOR) {
            if (state.get(HALF) == BlockHalf.TOP) {
                if (state.get(FACING) == direction) {
                    return 0;
                }
                if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    if (state.get(FACING).rotateYCounterclockwise() == direction) {
                        return 0;
                    }
                }
                if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    if (state.get(FACING).rotateYClockwise() == direction) {
                        return 0;
                    }
                }
            }
            return 11;
        }
        return 0;
    }
}
