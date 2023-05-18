package net.regions_unexplored.world.level.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class PinkBioshroomGrower extends AbstractTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
         return RuTreeFeatures.GIANT_PINK_BIOSHROOM;
   }
}
