package team.abnormals.hidden_gems.world.biome;

import com.terraformersmc.terrestria.biome.builder.TerrestriaBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import team.abnormals.hidden_gems.init.HGBiomes;
import team.abnormals.hidden_gems.init.TerrestriaSurfaces;

import static com.terraformersmc.terrestria.biome.builder.DefaultFeature.*;
import static net.minecraft.world.gen.feature.MineshaftFeature.Type.NORMAL;

public class CanyonBiomes {
	public static void register() {
		HGBiomes.CANYON_CLIFFS = TerrestriaBiomes.register("canyon_cliffs", TerrestriaBiome.builder()
				.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.DESERT)
				.depth(0.0F)
				.scale(0.2F)
				.temperature(0.9F)
				.downfall(0.1F)
				.waterColor(0x4da5e3)
				.waterFogColor(0x24a0b0)
				.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DESERT_LAKES, DUNGEONS, MINEABLES, ORES, DISKS, DESERT_DEAD_BUSHES,
						DEFAULT_GRASS, DEFAULT_MUSHROOMS, DESERT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, NORMAL))
//				.addStructureFeature(TerrestriaFeatures.CANYON_CLIFF_STRUCTURE)
				.addDefaultSpawnEntries()
				.build());

		HGBiomes.CANYON = TerrestriaBiomes.register("canyon", TerrestriaBiome.builder()
				.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.DESERT)
				.depth(0.0F)
				.scale(0.2F)
				.temperature(0.9F)
				.downfall(0.1F)
				.waterColor(0x4da5e3)
				.waterFogColor(0x24a0b0)
				.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DESERT_LAKES, DUNGEONS, MINEABLES, ORES, DISKS, DESERT_DEAD_BUSHES,
						DEFAULT_GRASS, DEFAULT_MUSHROOMS, DESERT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, NORMAL))
				.addDefaultSpawnEntries()
				.build());
	}
}