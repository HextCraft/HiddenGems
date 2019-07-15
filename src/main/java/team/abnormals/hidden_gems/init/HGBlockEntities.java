package team.abnormals.hidden_gems.init;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.block.entity.CampfireBlockEntity;
import team.abnormals.hidden_gems.block.entity.LecternBlockEntity;
import team.abnormals.hidden_gems.utils.enums.WoodType;

public class HGBlockEntities {

    public static BlockEntityType<CampfireBlockEntity>[] CAMPFIRES = new BlockEntityType[WoodType.VANILLA_WOODS.size()];
    public static BlockEntityType<LecternBlockEntity>[] LECTERNS = new BlockEntityType[WoodType.VANILLA_WOODS.size()];

    static {
        for(WoodType woodType : WoodType.VANILLA_WOODS) {
            if(woodType == WoodType.OAK) continue;
            CAMPFIRES[woodType.getIndex()] =
                    Registry.register(Registry.BLOCK_ENTITY, new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire_be", woodType.asString())),
                    BlockEntityType.Builder.create(() -> new CampfireBlockEntity(woodType), HGBlocks.CAMPFIRES[woodType.getIndex()]).build(null));
            LECTERNS[woodType.getIndex()] =
                    Registry.register(Registry.BLOCK_ENTITY, new Identifier(HiddenGems.MOD_ID, String.format("%s_lectern_be", woodType.asString())),
                            BlockEntityType.Builder.create(() -> new LecternBlockEntity(woodType), HGBlocks.LECTERNS[woodType.getIndex()]).build(null));
        }
    }

}
