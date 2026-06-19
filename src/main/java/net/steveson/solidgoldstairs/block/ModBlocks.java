package net.steveson.solidgoldstairs.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steveson.solidgoldstairs.SolidGoldStairsMod;

public class ModBlocks {

    public static final Block IRON_STAIRS = registerBlock("iron_stairs",
            new StairsBlock(Blocks.IRON_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block IRON_SLAB = registerBlock("iron_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block GOLD_STAIRS = registerBlock("gold_stairs",
            new StairsBlock(Blocks.GOLD_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block GOLD_SLAB = registerBlock("gold_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));



    public static final Block EMERALD_STAIRS = registerBlock("emerald_stairs",
            new StairsBlock(Blocks.EMERALD_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block EMERALD_SLAB = registerBlock("emerald_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));

    public static final Block LAPIS_STAIRS = registerBlock("lapis_stairs",
            new StairsBlock(Blocks.LAPIS_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)));
    public static final Block LAPIS_SLAB = registerBlock("lapis_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)));

    public static final Block DIAMOND_STAIRS = registerBlock("diamond_stairs",
            new StairsBlock(Blocks.DIAMOND_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block DIAMOND_SLAB = registerBlock("diamond_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));



    public static final Block CHISELED_QUARTZ_STAIRS = registerBlock("chiseled_quartz_stairs",
            new StairsBlock(Blocks.CHISELED_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CHISELED_QUARTZ_BLOCK)));
    public static final Block CHISELED_QUARTZ_SLAB = registerBlock("chiseled_quartz_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_QUARTZ_BLOCK)));

    public static final Block QUARTZ_BRICK_STAIRS = registerBlock("quartz_brick_stairs",
            new StairsBlock(Blocks.QUARTZ_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS)));
    public static final Block QUARTZ_BRICK_SLAB = registerBlock("quartz_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS)));

    public static final Block AMETHYST_STAIRS = registerBlock("amethyst_stairs",
            new StairsBlock(Blocks.AMETHYST_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block AMETHYST_SLAB = registerBlock("amethyst_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));






    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {

        entries.add(IRON_STAIRS);
        entries.add(IRON_SLAB);
        entries.add(GOLD_STAIRS);
        entries.add(GOLD_SLAB);

        entries.add(EMERALD_STAIRS);
        entries.add(EMERALD_SLAB);
        entries.add(LAPIS_STAIRS);
        entries.add(LAPIS_SLAB);
        entries.add(DIAMOND_STAIRS);
        entries.add(DIAMOND_SLAB);

        entries.add(CHISELED_QUARTZ_STAIRS);
        entries.add(CHISELED_QUARTZ_SLAB);
        entries.add(QUARTZ_BRICK_STAIRS);
        entries.add(QUARTZ_BRICK_SLAB);
        entries.add(AMETHYST_STAIRS);
        entries.add(AMETHYST_SLAB);


    }





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SolidGoldStairsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SolidGoldStairsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        SolidGoldStairsMod.LOGGER.info("Registering ModBlocks for " + SolidGoldStairsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksItemGroup);
    }
}
