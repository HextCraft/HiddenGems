package idk;

import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.minecraft.util.Identifier;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import java.io.IOException;

public class ModelGeneration {

    public static void main(String[] args) {
        try {
            ArtificeResourcePack.ofAssets(pack ->  {
                for (WoodType woodType : WoodType.VANILLA_WOODS) {
                    if(woodType == WoodType.OAK) continue;
                    pack.addBlockState(new Identifier(HiddenGems.MOD_ID, String.format("%s_bookshelf", woodType.asString())), blockStateBuilder -> {
                        blockStateBuilder.variant("", variant -> variant.model(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_bookshelf", woodType.asString()))));
                    });
                    pack.addBlockModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_bookshelf", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier("block/cube_column"))
                                    .texture("end", new Identifier(String.format("block/%s_planks", woodType.asString())))
                                    .texture("side", new Identifier(HiddenGems.MOD_ID, String.format("block/%s_bookshelf", woodType.asString())))
                    );
                    pack.addItemModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_bookshelf", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_bookshelf", woodType.asString()))));

                    //Lecterns
                    pack.addBlockState(new Identifier(HiddenGems.MOD_ID, String.format("%s_lectern", woodType.asString())), blockStateBuilder -> {
                        blockStateBuilder.variant("", variant -> variant.model(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_lectern", woodType.asString()))));
                    });
                    pack.addBlockModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_lectern", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier("block/lectern"))
                                    .texture("end", new Identifier(String.format("block/%s_planks", woodType.asString())))
                                    .texture("side", new Identifier(HiddenGems.MOD_ID, String.format("block/%s_lectern", woodType.asString())))
                    );
                    pack.addItemModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_lectern", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_lectern", woodType.asString()))));

                    //Campfires
                    pack.addBlockState(new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire", woodType.asString())), blockStateBuilder -> {
                        blockStateBuilder.variant("", variant -> variant.model(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_campfire", woodType.asString()))));
                    });
                    pack.addBlockModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier("block/campfire"))
                                    .texture("end", new Identifier(String.format("block/%s_planks", woodType.asString())))
                                    .texture("side", new Identifier(HiddenGems.MOD_ID, String.format("block/%s_campfire", woodType.asString())))
                    );
                    pack.addBlockModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire_off", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier("block/campfire_off"))
                                    .texture("end", new Identifier(String.format("block/%s_planks", woodType.asString())))
                                    .texture("side", new Identifier(HiddenGems.MOD_ID, String.format("block/%s_campfire", woodType.asString())))
                    );
                    pack.addItemModel(new Identifier(HiddenGems.MOD_ID, String.format("%s_campfire", woodType.asString())), modelBuilder ->
                            modelBuilder.parent(new Identifier(HiddenGems.MOD_ID, String.format("block/%s_campfire", woodType.asString()))));
                }
            }).dumpResources("src/main/resources/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
