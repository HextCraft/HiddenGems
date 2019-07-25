package team.abnormals.hidden_gems.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class BlossomForest extends Biome {

    public BlossomForest() {
        super(
                new Settings()
                        .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
                        .precipitation(Biomes.FOREST.getPrecipitation())
                        .category(Category.FOREST)
                        .depth(Biomes.FOREST.getDepth())
                        .scale(Biomes.FOREST.getScale())
                        .downfall(Biomes.FOREST.getRainfall())
                        .temperature(Biomes.FOREST.getTemperature())
                        .waterColor(Biomes.FOREST.getWaterColor())
                        .waterFogColor(Biomes.FOREST.getWaterFogColor())
                        .parent("null")
        );
    }

    @Override
    public int getFoliageColorAt(BlockPos blockPos_1) {
        return 0xd876c9;
    }

    @Override
    public int getGrassColorAt(BlockPos blockPos_1) {
        return 0xd876c9;
    }
}
