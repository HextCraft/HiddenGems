package team.abnormals.hidden_gems.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GrateBlock extends Block {

    private static final VoxelShape AABB = Block.createCuboidShape(0F, 0.9375, 0F, 1F, 1F, 1F);

    public GrateBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(5.0F, 10.0F).sounds(BlockSoundGroup.METAL).build());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return AABB;
    }

    /*@Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    @Override
    public void addCollisionBoxToList(BlockState state, World worldIn, BlockPos pos, VoxelShape entityBox, List<VoxelShape> collidingBoxes, Entity entityIn, boolean isActualState) {
        if (entityIn instanceof ItemEntity)
            return;
        else if (entityIn instanceof AnimalEntity)
            addCollisionBoxToList(pos, entityBox, collidingBoxes, state.getCollisionShape(worldIn, pos). (0, 2, 0));
        else super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
    }
    
    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(BlockState state) {
        return false;
    }



    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos blockPos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }*/


    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }


}
