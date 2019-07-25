package team.abnormals.hidden_gems.init;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.world.biome.BlossomForest;

import java.util.function.Consumer;

public class HGBiomes {

    public static Biome CANYON;
    public static Biome CANYON_CLIFFS;
    public static final Biome BLOSSOM_FOREST = new BlossomForest();

    static {
        register("blossom_forest", BLOSSOM_FOREST);
        forEveryFeature(feature -> HiddenGems.LOGGER.info("Found feature: " + Registry.FEATURE.getId(feature).toString()));
        forEveryBiome(biome -> HiddenGems.LOGGER.info("Found biome: " + Registry.BIOME.getId(biome).toString()));
    }

    public static void register(String name, Biome biome) {
        Registry.register(Registry.BIOME, new Identifier(HiddenGems.MOD_ID, name), biome);
    }

    private static void forEveryBiome(Consumer<Biome> biomes) {
        Registry.BIOME.forEach(biomes);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((rawId, id, biome) -> biomes.accept(biome));
    }

    private static void forEveryFeature(Consumer<Feature> features) {
        Registry.FEATURE.forEach(features);
        RegistryEntryAddedCallback.event(Registry.FEATURE).register((rawId, id, feature) -> features.accept(feature));
    }

}
