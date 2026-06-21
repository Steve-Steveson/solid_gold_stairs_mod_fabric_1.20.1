package net.steveson.solidgoldstairs.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.steveson.solidgoldstairs.util.ModTags;

public class PoweredSlabBlock extends SlabBlock {
    public PoweredSlabBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return state.get(TYPE) != SlabType.TOP;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(TYPE) == SlabType.DOUBLE && world.getBlockState(pos.offset(direction.getOpposite())).getBlock() == Blocks.COMPARATOR) {
            return 15;
        }
        if (state.get(TYPE) == SlabType.BOTTOM && world.getBlockState(pos.offset(direction.getOpposite())).getBlock() == Blocks.COMPARATOR) {
            return 7;
        }
        return 0;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(TYPE) == SlabType.DOUBLE) {
            return 15;
        }
        if (state.get(TYPE) == SlabType.BOTTOM && direction != Direction.DOWN) {
            return 7;
        }
        if (state.get(TYPE) == SlabType.TOP) {
            if (direction == Direction.DOWN) {
                return 7;
            }
            if (!world.getBlockState(pos.offset(direction.getOpposite())).isIn(ModTags.Blocks.LOW_REDSTONE_COMPONENTS)) {
                return 7;
            }
        }
        return 0;
    }
}