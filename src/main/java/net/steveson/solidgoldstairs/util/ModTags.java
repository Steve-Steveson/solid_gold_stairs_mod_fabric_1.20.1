package net.steveson.solidgoldstairs.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.steveson.solidgoldstairs.SolidGoldStairsMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LOW_REDSTONE_COMPONENTS = tag("low_redstone_components");

        private static TagKey<Block> tag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(SolidGoldStairsMod.MOD_ID, name));

        }
    }
}
