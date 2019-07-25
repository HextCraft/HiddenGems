package team.abnormals.hidden_gems.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class CoralBlocksSimplifier {

    private BlockState CORAL_BLOCK_BLOCK;
    private BlockState CORAL_BLOCK;
    private BlockState CORAL_FAN;
    private BlockState CORAL_WALL_FAN;
//    private BlockState CORAL_SHOWER;

    public CoralBlocksSimplifier(Block coralBlockBlock, Block coralBlock, Block coralFan, Block coralWallFan/*, Block coralShower*/) {
        CORAL_BLOCK_BLOCK = coralBlockBlock.getDefaultState();
        CORAL_BLOCK = coralBlock.getDefaultState();
        CORAL_FAN = coralFan.getDefaultState();
        CORAL_WALL_FAN = coralWallFan.getDefaultState();
//        CORAL_SHOWER = coralShower.getDefaultState();
    }

    public BlockState getCoralBlockBlock() {
        return CORAL_BLOCK_BLOCK;
    }

    public BlockState getCoralBlock() {
        return CORAL_BLOCK;
    }

    public BlockState getCoralFan() {
        return CORAL_FAN;
    }

    public BlockState getCoralWallFan() {
        return CORAL_WALL_FAN;
    }

    /*public BlockState getCoralShower() {
        return CORAL_SHOWER;
    }*/

}