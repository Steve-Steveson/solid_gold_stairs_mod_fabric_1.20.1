package net.steveson.solidgoldstairs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.steveson.solidgoldstairs.block.ModBlocks;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.COAL_STAIRS)
                .add(ModBlocks.COAL_SLAB)
                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.GOLD_STAIRS)
                .add(ModBlocks.GOLD_SLAB)

                .add(ModBlocks.EMERALD_STAIRS)
                .add(ModBlocks.EMERALD_SLAB)
                .add(ModBlocks.LAPIS_STAIRS)
                .add(ModBlocks.LAPIS_SLAB)
                .add(ModBlocks.DIAMOND_STAIRS)
                .add(ModBlocks.DIAMOND_SLAB)
                .add(ModBlocks.NETHERITE_STAIRS)
                .add(ModBlocks.NETHERITE_SLAB)
                .add(ModBlocks.CHISELED_QUARTZ_STAIRS)
                .add(ModBlocks.CHISELED_QUARTZ_SLAB)
                .add(ModBlocks.QUARTZ_BRICK_STAIRS)
                .add(ModBlocks.QUARTZ_BRICK_SLAB)
                .add(ModBlocks.AMETHYST_STAIRS)
                .add(ModBlocks.AMETHYST_SLAB);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.LAPIS_STAIRS)
                .add(ModBlocks.LAPIS_SLAB);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLD_STAIRS)
                .add(ModBlocks.GOLD_SLAB)
                .add(ModBlocks.EMERALD_STAIRS)
                .add(ModBlocks.EMERALD_SLAB)
                .add(ModBlocks.DIAMOND_STAIRS)
                .add(ModBlocks.DIAMOND_SLAB);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHERITE_STAIRS)
                .add(ModBlocks.NETHERITE_SLAB);


        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.COAL_STAIRS)
                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.GOLD_STAIRS)

                .add(ModBlocks.EMERALD_STAIRS)
                .add(ModBlocks.LAPIS_STAIRS)
                .add(ModBlocks.DIAMOND_STAIRS)
                .add(ModBlocks.NETHERITE_STAIRS)
                .add(ModBlocks.CHISELED_QUARTZ_STAIRS)
                .add(ModBlocks.QUARTZ_BRICK_STAIRS)
                .add(ModBlocks.AMETHYST_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.COAL_SLAB)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.GOLD_SLAB)

                .add(ModBlocks.EMERALD_SLAB)
                .add(ModBlocks.LAPIS_SLAB)
                .add(ModBlocks.DIAMOND_SLAB)
                .add(ModBlocks.NETHERITE_SLAB)
                .add(ModBlocks.CHISELED_QUARTZ_SLAB)
                .add(ModBlocks.QUARTZ_BRICK_SLAB)
                .add(ModBlocks.AMETHYST_SLAB);


        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
                .add(ModBlocks.GOLD_STAIRS)
                .add(ModBlocks.GOLD_SLAB);
    }
}
