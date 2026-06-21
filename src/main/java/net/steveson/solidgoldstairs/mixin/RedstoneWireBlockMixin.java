package net.steveson.solidgoldstairs.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.Direction;
import net.steveson.solidgoldstairs.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.StairsBlock.*;

@Mixin(RedstoneWireBlock.class)
public class RedstoneWireBlockMixin {
    @Inject(method = "connectsTo(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z", at = @At(value = "HEAD"), cancellable = true)
    private static void connectsTo(BlockState state, Direction dir, CallbackInfoReturnable<Boolean> cir) {
        if (state.isOf(ModBlocks.REDSTONE_STAIRS)) {
            if (state.get(HALF) == BlockHalf.TOP) {
                if (state.get(FACING) == dir) {
                    cir.setReturnValue(false);
                }
                if (state.get(FACING).rotateYCounterclockwise() == dir && state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    cir.setReturnValue(false);
                }
                if (state.get(FACING).rotateYClockwise() == dir && state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
