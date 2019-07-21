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
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.util.math.Direction;

public class NeutroniaCarvedMelonBlock extends HorizontalFacingBlock {
	public NeutroniaCarvedMelonBlock(boolean lit) {
		super(FabricBlockSettings.copy(Blocks.MELON).lightLevel(lit ? 15 : 0).build());
		setDefaultState(getStateFactory().getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH));
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return this.getDefaultState().with(HorizontalFacingBlock.FACING, itemPlacementContext_1.getPlayerLookDirection().getOpposite());
	}

	@Override
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(HorizontalFacingBlock.FACING);
	}
}
