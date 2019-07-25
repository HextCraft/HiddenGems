package team.abnormals.hidden_gems.init;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.world.biome.BlossomForest;

import java.util.function.Consumer;

public class HGBiomes {

    public static Biome CANYON;
    public static Biome CANYON_CLIFFS;
    public static final Biome BLOSSOM_FOREST;

    static {
        BLOSSOM_FOREST = register("blossom_forest", new BlossomForest());
    }

    public static <T extends Biome> T register(String name, T biome) {
        return Registry.register(Registry.BIOME, new Identifier(HiddenGems.MOD_ID, name), biome);
    }

    private static void forEveryBiome(Consumer<Biome> biomes) {
        Registry.BIOME.forEach(biomes);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((rawId, id, biome) -> biomes.accept(biome));
    }

}
