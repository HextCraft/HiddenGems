package team.abnormals.hidden_gems.init;

import net.minecraft.block.entity.BlockEntity;
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
        for (WoodType woodType : WoodType.VANILLA_WOODS) {
            if (woodType == WoodType.OAK) continue;
            CAMPFIRES[woodType.getIndex()] =
                    register(String.format("%s_campfire_be", woodType.asString()),
                            BlockEntityType.Builder.create(() -> new CampfireBlockEntity(woodType), HGBlocks.CAMPFIRES[woodType.getIndex()]));;
            LECTERNS[woodType.getIndex()] =
                    register(String.format("%s_lectern_be", woodType.asString()),
                            BlockEntityType.Builder.create(() -> new LecternBlockEntity(woodType), HGBlocks.LECTERNS[woodType.getIndex()]));;

        }
    }

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = builder.build(null);
        Registry.register(Registry.BLOCK_ENTITY, new Identifier(HiddenGems.MOD_ID, name), blockEntityType);
        return blockEntityType;
    }

}
