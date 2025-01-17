package net.regions_unexplored.world.level.block.plant.other;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

public class KapokVinesBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(3.0D, 3.0D, 3.0D, 13.0D, 16.0D, 13.0D);

    public KapokVinesBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return NetherVines.getBlocksToGrowWhenBonemealed(random);
    }

    protected Block getBodyBlock() {
        return RuBlocks.KAPOK_VINES_PLANT.get();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.relative(this.growthDirection.getOpposite());
        BlockState blockState = level.getBlockState(blockPos);
        if (!this.canAttachTo(blockState)) {
            return false;
        } else {
            return blockState.is(this.getHeadBlock()) || blockState.is(this.getBodyBlock()) || blockState.is(BlockTags.LOGS)|| blockState.is(BlockTags.LEAVES);
        }
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }
}
