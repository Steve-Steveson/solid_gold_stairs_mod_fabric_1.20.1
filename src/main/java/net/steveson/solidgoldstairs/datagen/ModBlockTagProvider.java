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

                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.GOLD_STAIRS)
                .add(ModBlocks.GOLD_SLAB)

                .add(ModBlocks.EMERALD_STAIRS)
                .add(ModBlocks.EMERALD_SLAB)
                .add(ModBlocks.LAPIS_STAIRS)
                .add(ModBlocks.LAPIS_SLAB)
                .add(ModBlocks.DIAMOND_STAIRS)
                .add(ModBlocks.DIAMOND_SLAB);

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
//        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.OPAL_STAIRS)
//                .add(ModBlocks.OPAL_SLAB);


        getOrCreateTagBuilder(BlockTags.STAIRS)

                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.GOLD_STAIRS)

                .add(ModBlocks.EMERALD_STAIRS)
                .add(ModBlocks.LAPIS_STAIRS)
                .add(ModBlocks.DIAMOND_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)

                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.GOLD_SLAB)

                .add(ModBlocks.EMERALD_SLAB)
                .add(ModBlocks.LAPIS_SLAB)
                .add(ModBlocks.DIAMOND_SLAB);


        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
                .add(ModBlocks.GOLD_STAIRS)
                .add(ModBlocks.GOLD_SLAB);
    }
}
