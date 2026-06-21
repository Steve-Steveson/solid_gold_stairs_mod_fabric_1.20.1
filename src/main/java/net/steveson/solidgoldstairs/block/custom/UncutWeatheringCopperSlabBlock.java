package net.steveson.solidgoldstairs.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.steveson.solidgoldstairs.block.ModBlocks;
import net.steveson.solidgoldstairs.util.WeatheringHelper;

import java.util.Optional;

public class UncutWeatheringCopperSlabBlock extends SlabBlock implements Oxidizable, SteveHasWeatheringCopper {

    private final Oxidizable.OxidationLevel weatheringState;

    public UncutWeatheringCopperSlabBlock(OxidationLevel weatheringState, Settings settings) {
        super(settings);
        this.weatheringState = weatheringState;
    }

    /**
     * Provides "our own" oxidation chain for copper slabs.
     */
    public static Optional<Block> getNextBlock(Block block) {
        if (block == ModBlocks.COPPER_SLAB) {
            return Optional.of(ModBlocks.EXPOSED_COPPER_SLAB);
        } else if (block == ModBlocks.EXPOSED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WEATHERED_COPPER_SLAB);
        } else if (block == ModBlocks.WEATHERED_COPPER_SLAB) {
            return Optional.of(ModBlocks.OXIDIZED_COPPER_SLAB);
        }
        return Optional.empty();
    }

    /**
     * Gets the previous oxidation stage (for scraping with axe).
     */
    public static Optional<Block> getPreviousBlock(Block block) {
        if (block == ModBlocks.EXPOSED_COPPER_SLAB) {
            return Optional.of(ModBlocks.COPPER_SLAB);
        } else if (block == ModBlocks.WEATHERED_COPPER_SLAB) {
            return Optional.of(ModBlocks.EXPOSED_COPPER_SLAB);
        } else if (block == ModBlocks.OXIDIZED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WEATHERED_COPPER_SLAB);
        }
        return Optional.empty();
    }

    /**
     * Gets the waxed variant of a copper slab.
     */
    public static Optional<Block> getWaxedBlock(Block block) {
        if (block == ModBlocks.COPPER_SLAB) {
            return Optional.of(ModBlocks.WAXED_COPPER_SLAB);
        } else if (block == ModBlocks.EXPOSED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WAXED_EXPOSED_COPPER_SLAB);
        } else if (block == ModBlocks.WEATHERED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WAXED_WEATHERED_COPPER_SLAB);
        } else if (block == ModBlocks.OXIDIZED_COPPER_SLAB) {
            return Optional.of(ModBlocks.WAXED_OXIDIZED_COPPER_SLAB);
        }
        return Optional.empty();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);

        // Check if player is using an axe on a waxed slab - dewax it
        if (stack.isOf(Items.HONEYCOMB)) {
            Optional<Block> waxedBlock = getWaxedBlock(state.getBlock());

            if (waxedBlock.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1, 1);
                world.syncWorldEvent(player, 3003, pos, 0); // WAX_ON particles

                if (!world.isClient) {
                    BlockState newState = waxedBlock.get().getStateWithProperties(state);
                    world.setBlockState(pos, newState);
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                }

                return ActionResult.success(world.isClient);
            }
        }

        // Check if player is using an axe on a waxed slab - dewax it
        if (stack.isIn(ItemTags.AXES)) {
            Optional<Block> previousBlock = getPreviousBlock(state.getBlock());

            if (previousBlock.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1, 1);
                world.syncWorldEvent(player, 3005, pos, 0); // SCRAPE particles

                if (!world.isClient) {
                    BlockState newState = previousBlock.get().getStateWithProperties(state);
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

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        WeatheringHelper.tryWeather(state, world, pos, random, UncutWeatheringCopperSlabBlock::getNextBlock);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return WeatheringHelper.canWeather(state, UncutWeatheringCopperSlabBlock::getNextBlock);
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return getWeatheringState();
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    @Override
    public Optional<Block> getPreviousBlockGeneric(Block block) {
        return getPreviousBlock(block);
    }

    @Override
    public Optional<Block> getNextBlockGeneric(Block block) {
        return getNextBlock(block);
    }
}
