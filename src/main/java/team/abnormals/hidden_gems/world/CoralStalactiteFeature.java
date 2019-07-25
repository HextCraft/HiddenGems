package team.abnormals.hidden_gems.world;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import team.abnormals.hidden_gems.utils.MathUtil;

import java.util.Random;
import java.util.function.Function;

public class CoralStalactiteFeature extends CoralFeature {

	private CoralBlocksSimplifier coralBlocksSimplifier;

	public CoralStalactiteFeature(CoralBlocksSimplifier coralBlocksSimplifier, Function<Dynamic<?>, ? extends DefaultFeatureConfig> config) {
		super(config);
		this.coralBlocksSimplifier = coralBlocksSimplifier;
	}
	
	@Override
	public boolean generate(IWorld worldIn, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		return placeFeature(worldIn, rand, pos);
	}
	
	private boolean placeFeature(IWorld world, Random rand, BlockPos pos) {
		Direction randDirection = Direction.random(rand);
		if(randDirection == Direction.UP || randDirection == Direction.DOWN) {
			randDirection = rand.nextBoolean() ? Direction.NORTH : Direction.SOUTH;
		}
		if(isInRavine(world, pos, randDirection, rand) && pos.getY() >= 25) {
			for(int y = 0; y <= 8; y++) {
				BlockPos checkPos = pos.up(y);
				if(world.getBlockState(checkPos).getBlock() == Blocks.STONE) {
					int a = rand.nextInt(3) + 3;
					int b = 4;
					int c = rand.nextInt(5) + 4;
					MathUtil.Equation r = (theta) -> (Math.cos(b * theta) / c + 1) * a;
					for (int i = -(a / c + a); i < a / c + a; i++) {
						for (int j = -(a / c + a); j < a / c + a; j++) {
							BlockPos placingPos = pos.add(i, 0, j);
							if (world.getBlockState(placingPos).getMaterial().isReplaceable()) {
								return false;
							}
						}
					}
					createStalactiteLayer(world, checkPos.down(), a, b, c);
					return true;
				}
			}
		}
		return false;
	}
	
	public void createStalactiteLayer(IWorld world, BlockPos pos, int a, int b, int c) {
		MathUtil.Equation r = (theta) -> (Math.cos(b * theta) / c + 1) * a;
		for (int i = -(a / c + a); i < a / c + a; i++) {
			for (int j = -(a / c + a); j < a / c + a; j++) {
				double radius = r.compute(Math.atan2(j, i));
				BlockPos placingPos = pos.add(i, 0, j);
				if (world.getBlockState(placingPos).getMaterial().isReplaceable() && (i * i + j * j) < radius * radius || world.getBlockState(placingPos).getBlock() == coralBlocksSimplifier.getCoralWallFan().getBlock() && (i * i + j * j) < radius * radius) {
					world.setBlockState(placingPos, this.coralBlocksSimplifier.getCoralBlockBlock(), 2);
				}
			}
		}
	}
	
	public static boolean isInRavine(IWorld world, BlockPos pos, Direction randDirection, Random rand) {
		for(int i = 0; i < 19; i++) {
			BlockPos checkPos = pos.offset(randDirection, rand.nextInt(2) + 1).down(i);
			if(world.getBlockState(checkPos).getBlock() == Blocks.MAGMA_BLOCK || world.getBlockState(checkPos).getBlock() == Blocks.OBSIDIAN) {
				return true;
			} else if(!world.getBlockState(checkPos).getMaterial().isReplaceable()) {
				return false;
			}
		}
		return false;
	}

}