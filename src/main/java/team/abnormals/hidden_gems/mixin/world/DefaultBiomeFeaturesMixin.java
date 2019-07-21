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

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
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

}