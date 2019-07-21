package team.abnormals.hidden_gems.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CaveCarver;

public class HGCarvers {

    public static final Carver<ProbabilityConfig> CAVE = Registry.register(Registry.CARVER, new Identifier("hidden_gems:carver"),
            new CaveCarver(ProbabilityConfig::deserialize, 256));

}
