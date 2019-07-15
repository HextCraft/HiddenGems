package team.abnormals.hidden_gems.init;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.hidden_gems.block.BaseLecternBlock;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.block.CampfireBlock;
import team.abnormals.hidden_gems.utils.enums.WoodType;

public class HGBlocks {

    public static Block[] CAMPFIRES = new Block[WoodType.VANILLA_WOODS.size()];
    public static Block[] BOOKSHELVES = new Block[WoodType.VANILLA_WOODS.size()];
    public static Block[] LECTERNS = new Block[WoodType.VANILLA_WOODS.size()];

    static {
        for (WoodType woodType : WoodType.VANILLA_WOODS) {
            if (woodType == WoodType.OAK) continue;
            BOOKSHELVES[woodType.getIndex()] = RegistryUtils.register(new Block(Block.Settings.of(Material.WOOD)), new Identifier(HiddenGems.MOD_ID, String.format("%s_bookshelf", woodType.asString())), ItemGroup.BUILDING_BLOCKS);
            CAMPFIRES[woodType.getIndex()] = RegistryUtils.register(new CampfireBlock(woodType, FabricBlockSettings.of(Material.WOOD, MaterialColor.SPRUCE).hardness(2.0F)
                    .sounds(BlockSoundGroup.WOOD).lightLevel(15).ticksRandomly().build()), new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire", woodType.asString())));
            LECTERNS[woodType.getIndex()] = RegistryUtils.register(new BaseLecternBlock(woodType, Block.Settings.copy(Blocks.LECTERN)), new Identifier(HiddenGems.MOD_ID, String.format("%s_lectern", woodType.asString())), ItemGroup.REDSTONE);
        }

        RegistryUtils.register(new Block(Block.Settings.copy(Blocks.STONE)), new Identifier(HiddenGems.MOD_ID, "test_block"), ItemGroup.BUILDING_BLOCKS);
    }

}