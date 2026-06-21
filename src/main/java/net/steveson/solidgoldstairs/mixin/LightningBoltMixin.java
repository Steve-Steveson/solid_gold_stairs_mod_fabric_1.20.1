package net.steveson.solidgoldstairs.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steveson.solidgoldstairs.block.custom.SteveHasWeatheringCopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Optional;

@Mixin(LightningEntity.class)
public abstract class LightningBoltMixin extends Entity {
    public LightningBoltMixin(EntityType<?> type, World world) {
        super(type, world);
    }

	@Inject(method = "cleanOxidation", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z",
            shift = At.Shift.AFTER))
	private static void clearCopperOnLightningStrike(World world, BlockPos pos, CallbackInfo ci, @Local(ordinal = 1) BlockPos blockPos) {
        BlockState blockStateRedux =  world.getBlockState(blockPos);
//        System.out.println("THIS IS A TEST " + blockPos);
//        System.out.println("THIS IS A TEST " + blockStateRedux);
        if (blockStateRedux.getBlock() instanceof SteveHasWeatheringCopper) {
            world.setBlockState(blockPos, SteveHasWeatheringCopper.getFirstBlock(world.getBlockState(blockPos).getBlock()).getStateWithProperties(blockStateRedux));
        }
	}

    @Inject(method = "cleanOxidationAround(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Ljava/util/Optional;", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/block/Oxidizable;getDecreasedOxidationState(Lnet/minecraft/block/BlockState;)Ljava/util/Optional;"),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private static void randomStepCleaningCopper(World world, BlockPos pos, CallbackInfoReturnable<Optional<BlockPos>> cir, Iterator var2, BlockPos blockPos, BlockState blockState) {
        if (blockState.getBlock() instanceof SteveHasWeatheringCopper) {
            SteveHasWeatheringCopper copperBlock = (SteveHasWeatheringCopper) blockState.getBlock();
            copperBlock.getPreviousBlockGeneric(blockState.getBlock()).ifPresent((previousBlock)-> {
                world.setBlockState(blockPos, previousBlock.getStateWithProperties(blockState));
            });
        }
    }
}