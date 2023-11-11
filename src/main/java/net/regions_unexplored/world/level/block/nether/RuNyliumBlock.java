package net.regions_unexplored.world.level.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;

public class RuNyliumBlock extends NyliumBlock implements BonemealableBlock {
    private final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> bonemealfeature;

    public RuNyliumBlock(Properties properties, Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> bonemeal) {
        super(properties);
        this.bonemealfeature = bonemeal;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();

        this.bonemealfeature.value().place(level, chunkgenerator, random, blockPos);

    }
}