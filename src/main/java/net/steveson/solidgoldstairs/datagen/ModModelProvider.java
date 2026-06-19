package net.steveson.solidgoldstairs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;
import net.steveson.solidgoldstairs.block.ModBlocks;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


//        BlockStateModelGenerator.BlockTexturePool ironPool0 = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.IRON_BLOCK);
//
//        TextureMap ironMap = TextureMap.all(Blocks.IRON_BLOCK);
////        BlockStateModelGenerator.BlockTexturePool ironPool = new BlockStateModelGenerator.BlockTexturePool( ironMap ).base(Blocks.IRON_BLOCK, texturedModel.getModel());
//        BlockStateModelGenerator.BlockTexturePool ironPool = new BlockStateModelGenerator.BlockTexturePool( ironMap ));


//        blockStateModelGenerator.

//        TextureMap textures = TextureMap.all(Blocks.IRON_BLOCK);
//
//        Identifier stairsModel = Models.STAIRS.upload(
//                ModBlocks.IRON_STAIRS,
//                textures,
//                blockStateModelGenerator.modelCollector
//        );
//
//        Identifier innerModel = Models.INNER_STAIRS.upload(
//                ModBlocks.IRON_STAIRS,
//                textures,
//                blockStateModelGenerator.modelCollector
//        );
//
//        Identifier outerModel = Models.OUTER_STAIRS.upload(
//                ModBlocks.IRON_STAIRS,
//                textures,
//                blockStateModelGenerator.modelCollector
//        );
//
//        blockStateModelGenerator.blockStateCollector.accept(
//                BlockStateModelGenerator.createStairsBlockState(
//                        ModBlocks.IRON_STAIRS,
//                        innerModel,
//                        stairsModel,
//                        outerModel
//                )
//        );


        generateStairsModels(ModBlocks.IRON_STAIRS, blockStateModelGenerator, Blocks.IRON_BLOCK);

//        ironPool.slab(ModBlocks.IRON_SLAB);
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






    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
