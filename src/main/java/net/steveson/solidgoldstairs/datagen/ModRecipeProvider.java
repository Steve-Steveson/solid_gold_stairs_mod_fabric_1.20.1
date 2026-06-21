package net.steveson.solidgoldstairs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.steveson.solidgoldstairs.SolidGoldStairsMod;
import net.steveson.solidgoldstairs.block.ModBlocks;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        stairsRecipes(Blocks.COAL_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_STAIRS, exporter);
        slabRecipes(Blocks.COAL_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_SLAB, exporter);
        stairsRecipes(Blocks.IRON_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_STAIRS, exporter);
        slabRecipes(Blocks.IRON_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SLAB, exporter);
        stairsRecipes(Blocks.GOLD_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_STAIRS, exporter);
        slabRecipes(Blocks.GOLD_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_SLAB, exporter);
        stairsRecipes(Blocks.REDSTONE_BLOCK, RecipeCategory.REDSTONE, ModBlocks.REDSTONE_STAIRS, exporter);
        slabRecipes(Blocks.REDSTONE_BLOCK, RecipeCategory.REDSTONE, ModBlocks.REDSTONE_SLAB, exporter);
        stairsRecipes(Blocks.EMERALD_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_STAIRS, exporter);
        slabRecipes(Blocks.EMERALD_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_SLAB, exporter);
        stairsRecipes(Blocks.LAPIS_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_STAIRS, exporter);
        slabRecipes(Blocks.LAPIS_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_SLAB, exporter);
        stairsRecipes(Blocks.DIAMOND_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIAMOND_STAIRS, exporter);
        slabRecipes(Blocks.DIAMOND_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIAMOND_SLAB, exporter);
        stairsRecipes(Blocks.NETHERITE_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERITE_STAIRS, exporter);
        slabRecipes(Blocks.NETHERITE_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERITE_SLAB, exporter);
        stairsRecipes(Blocks.CHISELED_QUARTZ_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_QUARTZ_STAIRS, exporter);
        slabRecipes(Blocks.CHISELED_QUARTZ_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_QUARTZ_SLAB, exporter);
        stairsRecipes(Blocks.QUARTZ_BRICKS, RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS, exporter);
        slabRecipes(Blocks.QUARTZ_BRICKS, RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB, exporter);
        stairsRecipes(Blocks.AMETHYST_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_STAIRS, exporter);
        slabRecipes(Blocks.AMETHYST_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_SLAB, exporter);

        stairsRecipes(Blocks.OXIDIZED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.WEATHERED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.EXPOSED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.WAXED_OXIDIZED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.WAXED_WEATHERED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.WAXED_EXPOSED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_COPPER_STAIRS, exporter);
        stairsRecipes(Blocks.WAXED_COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_STAIRS, exporter);

        slabRecipes(Blocks.OXIDIZED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.WEATHERED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.EXPOSED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_SLAB, exporter);
        slabRecipes(Blocks.WAXED_OXIDIZED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.WAXED_WEATHERED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.WAXED_EXPOSED_COPPER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_COPPER_SLAB, exporter);
        slabRecipes(Blocks.WAXED_COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_SLAB, exporter);

        waxCraftingRecipe(ModBlocks.OXIDIZED_COPPER_STAIRS, ModBlocks.WAXED_OXIDIZED_COPPER_STAIRS, exporter);
        waxCraftingRecipe(ModBlocks.WEATHERED_COPPER_STAIRS, ModBlocks.WAXED_WEATHERED_COPPER_STAIRS, exporter);
        waxCraftingRecipe(ModBlocks.EXPOSED_COPPER_STAIRS, ModBlocks.WAXED_EXPOSED_COPPER_STAIRS, exporter);
        waxCraftingRecipe(ModBlocks.COPPER_STAIRS, ModBlocks.WAXED_COPPER_STAIRS, exporter);
        waxCraftingRecipe(ModBlocks.OXIDIZED_COPPER_SLAB, ModBlocks.WAXED_OXIDIZED_COPPER_SLAB, exporter);
        waxCraftingRecipe(ModBlocks.WEATHERED_COPPER_SLAB, ModBlocks.WAXED_WEATHERED_COPPER_SLAB, exporter);
        waxCraftingRecipe(ModBlocks.EXPOSED_COPPER_SLAB, ModBlocks.WAXED_EXPOSED_COPPER_SLAB, exporter);
        waxCraftingRecipe(ModBlocks.COPPER_SLAB, ModBlocks.WAXED_COPPER_SLAB, exporter);
    }


    public static CraftingRecipeJsonBuilder createCategorizedStairsRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(category, output, 4).input('#', input).pattern("#  ").pattern("## ").pattern("###");
    }

    private static void stairsRecipes(Block input, RecipeCategory category, Block output, Consumer<RecipeJsonProvider> exporter) {
        createCategorizedStairsRecipe(category, output, Ingredient.ofItems(input))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(SolidGoldStairsMod.MOD_ID, "crafting/" + getRecipeName(output)));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(input), category, output)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(SolidGoldStairsMod.MOD_ID, "stonecutting/" + getRecipeName(output)));
    }
    private static void slabRecipes(Block input, RecipeCategory category, Block output, Consumer<RecipeJsonProvider> exporter) {
        createSlabRecipe(category, output, Ingredient.ofItems(input))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(SolidGoldStairsMod.MOD_ID, "crafting/" + getRecipeName(output)));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(input), category, output, 2)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(SolidGoldStairsMod.MOD_ID, "stonecutting/" + getRecipeName(output)));
    }

    private static void waxCraftingRecipe(Block input, Block output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output)
                .input(input)
                .input(Items.HONEYCOMB)
//                .group(reverseGroup)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(SolidGoldStairsMod.MOD_ID, "crafting/" + getRecipeName(output) + "_from_honeycomb"));
    }

}
