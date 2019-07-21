package team.abnormals.hidden_gems.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LecternBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import team.abnormals.hidden_gems.block.entity.LecternBlockEntity;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import javax.annotation.Nullable;

public class BaseLecternBlock extends LecternBlock {

    private WoodType woodType;

    public BaseLecternBlock(WoodType woodType) {
        super(Block.Settings.copy(Blocks.LECTERN));
        this.woodType = woodType;
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockView blockView_1) {
        return new LecternBlockEntity(woodType);
    }

}