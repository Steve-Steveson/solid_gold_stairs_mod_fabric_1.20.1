package net.steveson.solidgoldstairs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.steveson.solidgoldstairs.block.ModBlocks;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        generateStairsModels(ModBlocks.IRON_STAIRS, blockStateModelGenerator, Blocks.IRON_BLOCK);
        generateSlabModels(ModBlocks.IRON_SLAB, blockStateModelGenerator, Blocks.IRON_BLOCK);
        generateStairsModels(ModBlocks.GOLD_STAIRS, blockStateModelGenerator, Blocks.GOLD_BLOCK);
        generateSlabModels(ModBlocks.GOLD_SLAB, blockStateModelGenerator, Blocks.GOLD_BLOCK);

        generateStairsModels(ModBlocks.EMERALD_STAIRS, blockStateModelGenerator, Blocks.EMERALD_BLOCK);
        generateSlabModels(ModBlocks.EMERALD_SLAB, blockStateModelGenerator, Blocks.EMERALD_BLOCK);
        generateStairsModels(ModBlocks.LAPIS_STAIRS, blockStateModelGenerator, Blocks.LAPIS_BLOCK);
        generateSlabModels(ModBlocks.LAPIS_SLAB, blockStateModelGenerator, Blocks.LAPIS_BLOCK);
        generateStairsModels(ModBlocks.DIAMOND_STAIRS, blockStateModelGenerator, Blocks.DIAMOND_BLOCK);
        generateSlabModels(ModBlocks.DIAMOND_SLAB, blockStateModelGenerator, Blocks.DIAMOND_BLOCK);



        // chiseled quartz has different top texture
//        registerParentedItemModel(ModBlocks.)
        generateStairsModels(ModBlocks.QUARTZ_BRICK_STAIRS, blockStateModelGenerator, Blocks.QUARTZ_BRICKS);
        generateSlabModels(ModBlocks.QUARTZ_BRICK_SLAB, blockStateModelGenerator, Blocks.QUARTZ_BRICKS);
        generateStairsModels(ModBlocks.AMETHYST_STAIRS, blockStateModelGenerator, Blocks.AMETHYST_BLOCK);
        generateSlabModels(ModBlocks.AMETHYST_SLAB, blockStateModelGenerator, Blocks.AMETHYST_BLOCK);


    }



    public void generateStairsModels(Block newStair, BlockStateModelGenerator blockStateModelGenerator, Block inputblock) {
        TextureMap textures = TextureMap.all(inputblock);

        Identifier stairsModel = Models.STAIRS.upload(
                newStair,
                textures,
                blockStateModelGenerator.modelCollector
        );

        Identifier innerModel = Models.INNER_STAIRS.upload(
                newStair,
                textures,
                blockStateModelGenerator.modelCollector
        );

        Identifier outerModel = Models.OUTER_STAIRS.upload(
                newStair,
                textures,
                blockStateModelGenerator.modelCollector
        );

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createStairsBlockState(
                        newStair,
                        innerModel,
                        stairsModel,
                        outerModel
                )
        );
    }

    public void generateSlabModels(Block newSlab, BlockStateModelGenerator blockStateModelGenerator, Block inputblock) {
        TextureMap textures = TextureMap.all(inputblock);

        Identifier bottomModel = Models.SLAB.upload(
                newSlab,
                textures,
                blockStateModelGenerator.modelCollector
        );

        Identifier topModel = Models.SLAB_TOP.upload(
                newSlab,
                textures,
                blockStateModelGenerator.modelCollector
        );

        Identifier fullBlockModel =
                ModelIds.getBlockModelId(inputblock);

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSlabBlockState(
                        newSlab,
                        bottomModel,
                        topModel,
                        fullBlockModel
                )
        );
    }




    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
