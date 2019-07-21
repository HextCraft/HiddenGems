package team.abnormals.hidden_gems.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import team.abnormals.abnormalib.api.Climbable;

public class RopeBlock extends Block implements Climbable {

    private static final VoxelShape AABB = Block.createCuboidShape(0.375, 0, 0.375, 0.625, 1, 0.625);

    public RopeBlock() {
        super(FabricBlockSettings.of(Material.WOOL).hardness(0.5F).sounds(BlockSoundGroup.WOOL).build());
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if(hand_1 == Hand.MAIN_HAND) {
            ItemStack stack = playerEntity_1.getStackInHand(hand_1);
            if(stack.getItem() == Item.fromBlock(this)) {
                if(pullDown(world_1, blockPos_1)) {
                    if(!playerEntity_1.isCreative())
                        stack.decrement(1);

                    world_1.playSound(null, blockPos_1, soundGroup.getPlaceSound(), SoundCategory.BLOCKS, 0.5F, 1F);
                    return true;
                }
            } else {
                if(pullUp(world_1, blockPos_1)) {
                    if(!playerEntity_1.isCreative()) {
                        if(!playerEntity_1.giveItemStack(new ItemStack(this)))
                            playerEntity_1.dropItem(new ItemStack(this), false);
                    }

                    world_1.playSound(null, blockPos_1, soundGroup.getBreakSound(), SoundCategory.BLOCKS, 0.5F, 1F);
                    return true;
                }
            }
        }

        return super.activate(blockState_1, world_1, blockPos_1, playerEntity_1, hand_1, blockHitResult_1);
    }

    public boolean pullUp(World world, BlockPos pos) {
        BlockPos basePos = pos;

        while(true) {
            pos = pos.down();
            BlockState state = world.getBlockState(pos);
            if(state.getBlock() != this)
                break;
        }

        BlockPos ropePos = pos.up();
        if(ropePos.equals(basePos))
            return false;

        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        world.setBlockState(ropePos, Blocks.AIR.getDefaultState());
        moveBlock(world, pos, ropePos);

        return true;
    }

    public boolean pullDown(World world, BlockPos pos) {
        boolean can;
        boolean endRope = false;
        boolean wasAirAtEnd = false;

        do {
            pos = pos.down();
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if(block == this)
                continue;

            if(endRope) {
                can = wasAirAtEnd || world.isAir(pos)/* || block.isReplaceable(world, pos)*/;
                break;
            }

            endRope = true;
            wasAirAtEnd = world.isAir(pos);
        } while(true);

        if(can) {
            BlockPos ropePos = pos.up();
            moveBlock(world, ropePos, pos);

            BlockState ropePosState = world.getBlockState(ropePos);
            Block ropePosBlock = ropePosState.getBlock();

            if(world.isAir(ropePos)/* || ropePosBlock.isReplaceable(world, ropePos)*/) {
                world.setBlockState(ropePos, getDefaultState());
                return true;
            }
        }

        return false;
    }

    private void moveBlock(World world, BlockPos srcPos, BlockPos dstPos) {
        BlockState state = world.getBlockState(srcPos);
        Block block = state.getBlock();

        if(block.getHardness(state, world, srcPos) == -1 || !block.canPlaceAt(state, world, dstPos) || block.isAir(state))
            return;

        BlockEntity tile = world.getBlockEntity(srcPos);
        if(tile != null && !world.isClient) {
            tile.invalidate();
            tile.setPos(dstPos);

//            world.setBlockEntity(srcPos, block.createTileEntity(world, state));
        }

        world.setBlockState(srcPos, Blocks.AIR.getDefaultState());
        world.setBlockState(dstPos, state);

        if(tile != null && !world.isClient) {
            tile.validate();
            world.setBlockEntity(dstPos, tile);

            tile.resetBlock();
            /*if(block instanceof ChestBlock)
                ((ChestBlock) block).(world, dstPos, state);*/
        }

        world.updateNeighbors(dstPos, block);
    }

    @Override
    public boolean canPlaceAt(BlockState blockState_1, ViewableWorld viewableWorld_1, BlockPos blockPos_1) {
        BlockPos posUp = blockPos_1.up();
        BlockState stateUp = viewableWorld_1.getBlockState(posUp);
        Block block = stateUp.getBlock();

        return block == this || block.isFullOpaque(stateUp, viewableWorld_1, posUp);
    }

    @Override
    public void neighborUpdate(BlockState blockState_1, World world_1, BlockPos blockPos_1, Block block_1, BlockPos blockPos_2, boolean boolean_1) {
        if (!canPlaceAt(blockState_1, world_1, blockPos_1)) {
            world_1.playGlobalEvent(2001, blockPos_1, Block.getRawIdFromState(world_1.getBlockState(blockPos_1)));
            dropStack(world_1, blockPos_1, new ItemStack(this, 0));
            world_1.setBlockState(blockPos_1, Blocks.AIR.getDefaultState());
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return AABB;
    }

    @Override
    public boolean isOpaque(BlockState blockState_1) {
        return false;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }

    /*@Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return face != EnumFacing.UP && face != EnumFacing.DOWN ? BlockFaceShape.UNDEFINED : BlockFaceShape.CENTER;
    }*/

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public ClimbBehavior canClimb(LivingEntity livingEntity, BlockState blockState, BlockPos blockPos) {
        return ClimbBehavior.True;
    }

    @Override
    public String getFallDeathSuffix() {
        return "rope";
    }

}
