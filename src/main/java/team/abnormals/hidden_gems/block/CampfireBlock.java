package team.abnormals.hidden_gems.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateFactory.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import team.abnormals.hidden_gems.block.entity.CampfireBlockEntity;
import team.abnormals.hidden_gems.init.HGBlockEntities;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class CampfireBlock extends BlockWithEntity implements Waterloggable {
    public static final BooleanProperty LIT;
    public static final BooleanProperty SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);

    static {
        LIT = Properties.LIT;
        SIGNAL_FIRE = Properties.SIGNAL_FIRE;
        WATERLOGGED = Properties.WATERLOGGED;
        FACING = Properties.HORIZONTAL_FACING;
    }

    public WoodType woodType;

    public CampfireBlock(WoodType woodType, Settings block$Settings_1) {
        super(block$Settings_1);
        this.woodType = woodType;
        this.setDefaultState(this.stateFactory.getDefaultState().with(LIT, true).with(SIGNAL_FIRE, false).with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    public static void spawnSmokeParticle(World world_1, BlockPos blockPos_1, boolean boolean_1, boolean boolean_2) {
        Random random_1 = world_1.getRandom();
        DefaultParticleType defaultParticleType_1 = boolean_1 ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
        world_1.addImportantParticle(defaultParticleType_1, true, (double) blockPos_1.getX() + 0.5D + random_1.nextDouble() / 3.0D * (double) (random_1.nextBoolean() ? 1 : -1), (double) blockPos_1.getY() + random_1.nextDouble() + random_1.nextDouble(), (double) blockPos_1.getZ() + 0.5D + random_1.nextDouble() / 3.0D * (double) (random_1.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        if (boolean_2) {
            world_1.addParticle(ParticleTypes.SMOKE, (double) blockPos_1.getX() + 0.25D + random_1.nextDouble() / 2.0D * (double) (random_1.nextBoolean() ? 1 : -1), (double) blockPos_1.getY() + 0.4D, (double) blockPos_1.getZ() + 0.25D + random_1.nextDouble() / 2.0D * (double) (random_1.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
        }

    }

    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if (blockState_1.get(LIT)) {
            BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
            if (blockEntity_1 instanceof CampfireBlockEntity) {
                CampfireBlockEntity campfireBlockEntity_1 = (CampfireBlockEntity) blockEntity_1;
                ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
                Optional<CampfireCookingRecipe> optional_1 = campfireBlockEntity_1.getRecipeFor(itemStack_1);
                if (optional_1.isPresent()) {
                    if (!world_1.isClient && campfireBlockEntity_1.addItem(playerEntity_1.abilities.creativeMode ? itemStack_1.copy() : itemStack_1, optional_1.get().getCookTime())) {
                        playerEntity_1.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
                    }

                    return true;
                }
            }
        }

        return false;
    }

    public void onEntityCollision(BlockState blockState_1, World world_1, BlockPos blockPos_1, Entity entity_1) {
        if (!entity_1.isFireImmune() && blockState_1.get(LIT) && entity_1 instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity_1)) {
            entity_1.damage(DamageSource.IN_FIRE, 1.0F);
        }

        super.onEntityCollision(blockState_1, world_1, blockPos_1, entity_1);
    }

    public void onBlockRemoved(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, boolean boolean_1) {
        if (blockState_1.getBlock() != blockState_2.getBlock()) {
            BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
            if (blockEntity_1 instanceof CampfireBlockEntity) {
                ItemScatterer.spawn(world_1, blockPos_1, ((CampfireBlockEntity) blockEntity_1).getItemsBeingCooked());
            }

            super.onBlockRemoved(blockState_1, world_1, blockPos_1, blockState_2, boolean_1);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        IWorld iWorld_1 = itemPlacementContext_1.getWorld();
        BlockPos blockPos_1 = itemPlacementContext_1.getBlockPos();
        boolean boolean_1 = iWorld_1.getFluidState(blockPos_1).getFluid() == Fluids.WATER;
        return this.getDefaultState().with(WATERLOGGED, boolean_1).with(SIGNAL_FIRE, this.doesBlockCauseSignalFire(iWorld_1.getBlockState(blockPos_1.down()))).with(LIT, !boolean_1).with(FACING, itemPlacementContext_1.getPlayerFacing());
    }

    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        if (blockState_1.get(WATERLOGGED)) {
            iWorld_1.getFluidTickScheduler().schedule(blockPos_1, Fluids.WATER, Fluids.WATER.getTickRate(iWorld_1));
        }

        return direction_1 == Direction.DOWN ? blockState_1.with(SIGNAL_FIRE, this.doesBlockCauseSignalFire(blockState_2)) : super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
    }

    private boolean doesBlockCauseSignalFire(BlockState blockState_1) {
        return blockState_1.getBlock() == Blocks.HAY_BLOCK;
    }

    public int getLuminance(BlockState blockState_1) {
        return blockState_1.get(LIT) ? super.getLuminance(blockState_1) : 0;
    }

    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return SHAPE;
    }

    public BlockRenderType getRenderType(BlockState blockState_1) {
        return BlockRenderType.MODEL;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        if (blockState_1.get(LIT)) {
            if (random_1.nextInt(10) == 0) {
                world_1.playSound((float) blockPos_1.getX() + 0.5F, (float) blockPos_1.getY() + 0.5F, (float) blockPos_1.getZ() + 0.5F, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + random_1.nextFloat(), random_1.nextFloat() * 0.7F + 0.6F, false);
            }

            if (random_1.nextInt(5) == 0) {
                for (int int_1 = 0; int_1 < random_1.nextInt(1) + 1; ++int_1) {
                    world_1.addParticle(ParticleTypes.LAVA, (float) blockPos_1.getX() + 0.5F, (float) blockPos_1.getY() + 0.5F, (float) blockPos_1.getZ() + 0.5F, random_1.nextFloat() / 2.0F, 5.0E-5D, random_1.nextFloat() / 2.0F);
                }
            }

        }
    }

    public boolean tryFillWithFluid(IWorld iWorld_1, BlockPos blockPos_1, BlockState blockState_1, FluidState fluidState_1) {
        if (!blockState_1.get(Properties.WATERLOGGED) && fluidState_1.getFluid() == Fluids.WATER) {
            boolean boolean_1 = blockState_1.get(LIT);
            if (boolean_1) {
                if (iWorld_1.isClient()) {
                    for (int int_1 = 0; int_1 < 20; ++int_1) {
                        spawnSmokeParticle(iWorld_1.getWorld(), blockPos_1, blockState_1.get(SIGNAL_FIRE), true);
                    }
                } else {
                    iWorld_1.playSound(null, blockPos_1, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                BlockEntity blockEntity_1 = iWorld_1.getBlockEntity(blockPos_1);
                if (blockEntity_1 instanceof CampfireBlockEntity) {
                    ((CampfireBlockEntity) blockEntity_1).spawnItemsBeingCooked();
                }
            }

            iWorld_1.setBlockState(blockPos_1, blockState_1.with(WATERLOGGED, true).with(LIT, false), 3);
            iWorld_1.getFluidTickScheduler().schedule(blockPos_1, fluidState_1.getFluid(), fluidState_1.getFluid().getTickRate(iWorld_1));
            return true;
        } else {
            return false;
        }
    }

    public void onProjectileHit(World world_1, BlockState blockState_1, BlockHitResult blockHitResult_1, Entity entity_1) {
        if (!world_1.isClient && entity_1 instanceof ProjectileEntity) {
            ProjectileEntity projectileEntity_1 = (ProjectileEntity) entity_1;
            if (projectileEntity_1.isOnFire() && !blockState_1.get(LIT) && !blockState_1.get(WATERLOGGED)) {
                BlockPos blockPos_1 = blockHitResult_1.getBlockPos();
                world_1.setBlockState(blockPos_1, blockState_1.with(Properties.LIT, true), 11);
            }
        }

    }

    public FluidState getFluidState(BlockState blockState_1) {
        return blockState_1.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(blockState_1);
    }

    public BlockState rotate(BlockState blockState_1, BlockRotation blockRotation_1) {
        return blockState_1.with(FACING, blockRotation_1.rotate(blockState_1.get(FACING)));
    }

    public BlockState mirror(BlockState blockState_1, BlockMirror blockMirror_1) {
        return blockState_1.rotate(blockMirror_1.getRotation(blockState_1.get(FACING)));
    }

    protected void appendProperties(Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    public BlockEntity createBlockEntity(BlockView blockView_1) {
        return new CampfireBlockEntity(HGBlockEntities.CAMPFIRES[woodType.getIndex()]);
    }

    public boolean canPlaceAtSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, BlockPlacementEnvironment blockPlacementEnvironment_1) {
        return false;
    }
}
