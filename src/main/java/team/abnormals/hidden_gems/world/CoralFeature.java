package team.abnormals.hidden_gems.world;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CarvingMaskDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import team.abnormals.hidden_gems.init.HGFeatures;

import java.util.Random;
import java.util.function.Function;

/**
 * @author - SmellyModder(Luke Tonon)
 */
public class CoralFeature extends Feature<DefaultFeatureConfig> {

	public CoralFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean generate(IWorld worldIn, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		return false;
	}
	
	public static void addAmmonites() {
		for(Biome biome : Biome.BIOMES) {
			if(biome.getCategory() == Category.OCEAN) {
				biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(HGFeatures.BRAIN_CORAL, FeatureConfig.DEFAULT, Decorator.CARVING_MASK, new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.0125F)));
			}
		}
	}
	
}