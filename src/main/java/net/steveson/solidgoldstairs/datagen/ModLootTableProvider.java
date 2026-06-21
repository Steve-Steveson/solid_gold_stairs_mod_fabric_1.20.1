package net.steveson.solidgoldstairs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.steveson.solidgoldstairs.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COAL_STAIRS);
        addDrop(ModBlocks.COAL_SLAB, slabDrops(ModBlocks.COAL_SLAB));
        addDrop(ModBlocks.IRON_STAIRS);
        addDrop(ModBlocks.IRON_SLAB, slabDrops(ModBlocks.IRON_SLAB));
        addDrop(ModBlocks.GOLD_STAIRS);
        addDrop(ModBlocks.GOLD_SLAB, slabDrops(ModBlocks.GOLD_SLAB));
        addDrop(ModBlocks.REDSTONE_STAIRS);
        addDrop(ModBlocks.REDSTONE_SLAB, slabDrops(ModBlocks.REDSTONE_SLAB));
        addDrop(ModBlocks.EMERALD_STAIRS);
        addDrop(ModBlocks.EMERALD_SLAB, slabDrops(ModBlocks.EMERALD_SLAB));
        addDrop(ModBlocks.LAPIS_STAIRS);
        addDrop(ModBlocks.LAPIS_SLAB, slabDrops(ModBlocks.LAPIS_SLAB));
        addDrop(ModBlocks.DIAMOND_STAIRS);
        addDrop(ModBlocks.DIAMOND_SLAB, slabDrops(ModBlocks.DIAMOND_SLAB));
        addDrop(ModBlocks.NETHERITE_STAIRS);
        addDrop(ModBlocks.NETHERITE_SLAB, slabDrops(ModBlocks.NETHERITE_SLAB));
        addDrop(ModBlocks.CHISELED_QUARTZ_STAIRS);
        addDrop(ModBlocks.CHISELED_QUARTZ_SLAB, slabDrops(ModBlocks.CHISELED_QUARTZ_SLAB));
        addDrop(ModBlocks.QUARTZ_BRICK_STAIRS);
        addDrop(ModBlocks.QUARTZ_BRICK_SLAB, slabDrops(ModBlocks.QUARTZ_BRICK_SLAB));
        addDrop(ModBlocks.AMETHYST_STAIRS);
        addDrop(ModBlocks.AMETHYST_SLAB, slabDrops(ModBlocks.AMETHYST_SLAB));

        addDrop(ModBlocks.OXIDIZED_COPPER_STAIRS);
        addDrop(ModBlocks.WEATHERED_COPPER_STAIRS);
        addDrop(ModBlocks.EXPOSED_COPPER_STAIRS);
        addDrop(ModBlocks.COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_COPPER_STAIRS);

        addDrop(ModBlocks.OXIDIZED_COPPER_SLAB, slabDrops(ModBlocks.OXIDIZED_COPPER_SLAB));
        addDrop(ModBlocks.WEATHERED_COPPER_SLAB, slabDrops(ModBlocks.WEATHERED_COPPER_SLAB));
        addDrop(ModBlocks.EXPOSED_COPPER_SLAB, slabDrops(ModBlocks.EXPOSED_COPPER_SLAB));
        addDrop(ModBlocks.COPPER_SLAB, slabDrops(ModBlocks.COPPER_SLAB));
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_SLAB, slabDrops(ModBlocks.WAXED_OXIDIZED_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_SLAB, slabDrops(ModBlocks.WAXED_WEATHERED_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_SLAB, slabDrops(ModBlocks.WAXED_EXPOSED_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_COPPER_SLAB, slabDrops(ModBlocks.WAXED_COPPER_SLAB));
    }
}
