/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Team Abnormals
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package team.abnormals.hidden_gems.mixin.world;

import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DiskFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import team.abnormals.hidden_gems.init.HGCarvers;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public static void addLandCarvers(Biome biome_1) {
        biome_1.addCarver(GenerationStep.Carver.AIR, Biome.configureCarver(HGCarvers.CAVE, new ProbabilityConfig(0.14285715F)));
        biome_1.addCarver(GenerationStep.Carver.AIR, Biome.configureCarver(Carver.CANYON, new ProbabilityConfig(0.02F)));
    }

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public static void addMineables(Biome biome_1) {
        biome_1.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 0, 0, 256)));
        biome_1.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33), Decorator.COUNT_RANGE, new RangeDecoratorConfig(8, 0, 0, 256)));
        biome_1.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.DISK, new DiskFeatureConfig(Blocks.GRANITE.getDefaultState(), 7, 2, Lists.newArrayList(Blocks.GRANITE.getDefaultState())), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 0, 0, 80)));
        biome_1.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.DISK, new DiskFeatureConfig(Blocks.DIORITE.getDefaultState(), 7, 2, Lists.newArrayList(Blocks.DIORITE.getDefaultState())), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 0, 0, 80)));
        biome_1.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(Feature.DISK, new DiskFeatureConfig(Blocks.ANDESITE.getDefaultState(), 7, 2, Lists.newArrayList(Blocks.ANDESITE.getDefaultState())), Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 0, 0, 80)));
    }
}