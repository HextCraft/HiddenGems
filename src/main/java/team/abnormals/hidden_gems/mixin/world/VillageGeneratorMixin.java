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

import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.VillageGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(VillageGenerator.class)
public class VillageGeneratorMixin {

    @Inject(method = "addPieces(Lnet/minecraft/world/gen/chunk/ChunkGenerator;Lnet/minecraft/structure/StructureManager;Lnet/minecraft/util/math/BlockPos;Ljava/util/List;Lnet/minecraft/world/gen/ChunkRandom;Lnet/minecraft/world/gen/feature/VillageFeatureConfig;)V", at = @At(value = "HEAD"))
    private static void addPieces(ChunkGenerator<?> chunkGenerator_1, StructureManager structureManager_1, BlockPos blockPos_1, List<StructurePiece> list_1, ChunkRandom chunkRandom_1, VillageFeatureConfig villageFeatureConfig_1, CallbackInfo info) {
//        SwampVillageData.initialize();
    }

}