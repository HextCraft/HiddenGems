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

package team.abnormals.hidden_gems.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;
import team.abnormals.hidden_gems.block.entity.ChestBaseBlockEntity;
import team.abnormals.hidden_gems.init.HGBlockEntities;

public class ChestBaseBlock extends ChestBlock {

    private Identifier chestTexture;
    private Identifier doubleChestTexture;
    private Identifier trappedChestTexture;
    private Identifier trappedDoubleChestTexture;

    public ChestBaseBlock() {
        super(FabricBlockSettings.of(Material.STONE).hardness(3.0f).resistance(30.0f).build());
    }

    @Override
    public boolean hasBlockEntity() {
        return true;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView var1) {
        BlockEntityType.Builder<BlockEntity> type = BlockEntityType.Builder.create(ChestBaseBlockEntity::new, this);
        HGBlockEntities.register("chest_base_be_test", type);
        return new ChestBaseBlockEntity(type.build(null), this);
    }

    public Identifier getModelTexture() {
        return chestTexture;
    }

    public void setChestTexture(Identifier chestTexture) {
        this.chestTexture = chestTexture;
    }

    public Identifier getDoubleModelTexture() {
        return doubleChestTexture;
    }

    public void setDoubleChestTexture(Identifier doubleChestTexture) {
        this.doubleChestTexture = doubleChestTexture;
    }

}