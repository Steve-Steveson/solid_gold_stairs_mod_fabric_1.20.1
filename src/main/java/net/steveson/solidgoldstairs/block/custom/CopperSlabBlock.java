package net.steveson.solidgoldstairs.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steveson.solidgoldstairs.block.ModBlocks;

import java.util.Optional;

public class CopperSlabBlock extends SlabBlock {
    private final Oxidizable.OxidationLevel weatheringState;

    public CopperSlabBlock(Oxidizable.OxidationLevel weatheringState, Settings settings) {
        super(settings);
        this.weatheringState = weatheringState;
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    /**
     * Gets the unwaxed variant of a waxed copper slab block.
     */
    public static Optional<Block> getUnwaxedBlock(Block block) {
        if (block == ModBlocks.WAXED_COPPER_SLAB) {
            return Optional.of(ModBlocks.COPPER_SLAB);
        } else if (block == ModBlocks.WAXED_EXPOSED_COPPER_SLAB) {
            return Optional.of(ModBlocks.EXPOSED_COPPER_SLAB);
        } else if (block == ModBlocks.WAXED_WEATHERED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WEATHERED_COPPER_SLAB);
        } else if (block == ModBlocks.WAXED_OXIDIZED_COPPER_SLAB) {
            return Optional.of(ModBlocks.OXIDIZED_COPPER_SLAB);
        }
        return Optional.empty();
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);

        // Check if player is using an axe on a waxed slab - dewax it
        if (stack.isIn(ItemTags.AXES)) {
            Optional<Block> unwaxedBlock = getUnwaxedBlock(state.getBlock());

            if (unwaxedBlock.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1, 1);
                world.syncWorldEvent(player, 3004, pos, 0); // WAX_OFF particles

                if (!world.isClient) {
                    BlockState newState = unwaxedBlock.get().getStateWithProperties(state);
                    world.setBlockState(pos, newState);
                    if (!player.isCreative()) {
                        stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    }
                }

                return ActionResult.success(world.isClient);
            }
        }

        return ActionResult.PASS;
    }
}
