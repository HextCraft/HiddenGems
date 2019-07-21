package team.abnormals.hidden_gems.init;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import team.abnormals.hidden_gems.world.CoralShelfBlocksSimplifier;
import team.abnormals.hidden_gems.world.CoralShelfFeature;

public class HGFeatures {

    public static final Feature<DefaultFeatureConfig> BRAIN_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.BRAIN_CORAL_BLOCK, Blocks.BRAIN_CORAL,Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );

    /*public static final Feature<DefaultFeatureConfig> PRISMARINE_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.FIRE_CORAL_BLOCK, Blocks.FIRE_CORAL,Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );

    public static final Feature<DefaultFeatureConfig> PRISMARINE_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.FIRE_CORAL_BLOCK, Blocks.FIRE_CORAL,Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );

    public static final Feature<DefaultFeatureConfig> PRISMARINE_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.FIRE_CORAL_BLOCK, Blocks.FIRE_CORAL,Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );

    public static final Feature<DefaultFeatureConfig> PRISMARINE_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.FIRE_CORAL_BLOCK, Blocks.FIRE_CORAL,Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );

    public static final Feature<DefaultFeatureConfig> PRISMARINE_CORAL_SHELF = new CoralShelfFeature(
            new CoralShelfBlocksSimplifier(Blocks.FIRE_CORAL_BLOCK, Blocks.FIRE_CORAL,Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN),
            DefaultFeatureConfig::deserialize
    );*/

}
