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

package team.abnormals.hidden_gems.mixin.entity;

import net.minecraft.entity.Bird;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ParrotEntity.class)
public abstract class ParrotEntityMixin extends TameableShoulderEntity implements Bird {

    @Shadow @Final private static TrackedData<Integer> ATTR_VARIANT;

    protected ParrotEntityMixin(EntityType<? extends TameableShoulderEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Shadow public abstract void setVariant(int int_1);

    /**
     * @author OliviaTheVampire
     */
    @javax.annotation.Nullable
    @Overwrite
    public EntityData initialize(IWorld iWorld_1, LocalDifficulty localDifficulty_1, SpawnType spawnType_1, EntityData entityData_1, CompoundTag compoundTag_1) {
        setVariant(this.random.nextInt(17));
        return super.initialize(iWorld_1, localDifficulty_1, spawnType_1, entityData_1, compoundTag_1);
    }

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public int getVariant() {
        return MathHelper.clamp(this.dataTracker.get(ATTR_VARIANT), 0, 16);
    }

}
