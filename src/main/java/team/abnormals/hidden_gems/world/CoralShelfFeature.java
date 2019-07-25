package team.abnormals.hidden_gems.world;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CoralWallFanBlock;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CarvingMaskDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import team.abnormals.hidden_gems.init.HGFeatures;
import team.abnormals.hidden_gems.utils.MathUtil;

import java.util.Random;
import java.util.function.Function;

public class CoralShelfFeature extends Feature<DefaultFeatureConfig> {
	private CoralBlocksSimplifier blocksSimplifier;

	public CoralShelfFeature(CoralBlocksSimplifier blocksSimplifier, Function<Dynamic<?>, ? extends DefaultFeatureConfig> config) {
		super(config);
		this.blocksSimplifier = blocksSimplifier;
	}

	public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		Direction direction = Direction.random(rand);
		if(direction == Direction.UP || direction == Direction.DOWN) {
			direction = rand.nextBoolean() ? Direction.NORTH : Direction.SOUTH;
		}
		if(this.shouldPlace(world, pos, direction, rand)) {
			int a = rand.nextInt(4) + 2;
		    int c = rand.nextInt(5) + 3;
		    int b = 4;
			if(rand.nextInt(6) < 2 && pos.getY() > 11) {
				pos = pos.offset(direction.getOpposite());
				this.addShelf(world, pos, rand, a, b, c);
				if(rand.nextBoolean()) {
					this.addShelf(world, pos.offset(direction.getOpposite()).up(rand.nextInt(2) + 2), rand, 3, 3, c + 1);
					if(rand.nextBoolean()) {
						this.addShelf(world, pos.offset(direction.getOpposite()).down(rand.nextInt(2) + 2), rand, 3, 4, c + 1);
					}
				}
			}
			return true;
		}
		return false;
	}

	public boolean shouldPlace(IWorld world, BlockPos pos, Direction randDirection, Random rand) {
		for(int i = 0; i < 13; i++) {
			BlockPos checkPos = pos.offset(randDirection, rand.nextInt(2) + 1).down(i);
			if(world.getBlockState(checkPos).getBlock() == Blocks.MAGMA_BLOCK || world.getBlockState(checkPos).getBlock() == Blocks.OBSIDIAN) {
				if(world.getBlockState(pos.offset(randDirection.getOpposite())).getBlock() == Blocks.STONE) {
					return true;
				}
			} else if(!world.getBlockState(checkPos).getMaterial().isReplaceable()) {
				return false;
			}
		}
		return false;
	}

	private void addShelf(IWorld world, BlockPos pos, Random rand, int a, int b, int c) {
		MathUtil.Equation r = (theta) -> (Math.cos(b * theta) / c + 1) * a;
		for (int i = -(a / c + a); i < a / c + a; i++) {
			for (int j = -(a / c + a); j < a / c + a; j++) {
				double radius = r.compute(Math.atan2(j , i));
				BlockPos placingPos = pos.add(i, 0, j);
				if (world.getBlockState(placingPos).getMaterial().isReplaceable() && (i * i + j * j) < radius * radius || world.getBlockState(placingPos).getBlock() instanceof CoralWallFanBlock && (i * i + j * j) < radius * radius) {
					world.setBlockState(placingPos, blocksSimplifier.getCoralBlockBlock(), 2);
					if(rand.nextBoolean()) {
						boolean gen = rand.nextBoolean();
						if(gen && world.getBlockState(placingPos.up()).getMaterial().isReplaceable()) {
							world.setBlockState(placingPos.up(), blocksSimplifier.getCoralBlock(), 2);
						} else if(!gen && world.getBlockState(placingPos.up()).getMaterial().isReplaceable()) {
							world.setBlockState(placingPos.up(), blocksSimplifier.getCoralFan(), 2);
						}
//						world.setBlockState(placingPos.down(), blocksSimplifier.getCoralShower(), 2);
						for(Direction direction : Direction.Type.HORIZONTAL) {
							if (rand.nextFloat() < 0.85F) {
				            	BlockPos blockpos1 = placingPos.offset(direction);
				            	if (world.getBlockState(blockpos1).getBlock() == Blocks.WATER) {
				            		BlockState blockstate1 = blocksSimplifier.getCoralWallFan().with(DeadCoralWallFanBlock.FACING, direction);
				            		world.setBlockState(blockpos1, blockstate1, 2);
				            	}
							}
				        }
					}
				}
			}
		}
	}

	public static void addToOceans() {
		for(Biome biome : Biome.BIOMES) {
			if (biome.getCategory() == Biome.Category.OCEAN) {
				biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.BRAIN_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
	//			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.PRISMARINE_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
	//			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.PRISMARINE_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
	//			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.PRISMARINE_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
	//			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.PRISMARINE_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
	//			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.PRISMARINE_CORAL_SHELF, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
			}
		}
	}

}