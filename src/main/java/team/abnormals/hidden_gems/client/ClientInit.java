package team.abnormals.hidden_gems.client;

import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;
import net.minecraft.util.Identifier;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.block.entity.LecternBlockEntity;
import team.abnormals.hidden_gems.client.renderer.LecternBlockEntityRenderer;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(LecternBlockEntity.class, new LecternBlockEntityRenderer());

        Artifice.registerAssets("hidden_gems:mod_resources", pack -> {
            pack.addBlockState(new Identifier("hidden_gems", "test_block"), blockStateBuilder ->
                    blockStateBuilder.variant("", variant -> variant.model(new Identifier("hidden_gems", "block/test_block"))));
            pack.addBlockModel(new Identifier("hidden_gems", "test_block"), modelBuilder -> {
                modelBuilder.parent(new Identifier("block/cube_all"));
                modelBuilder.texture("all", new Identifier("block/iron_ore"));
            });
            pack.addItemModel(new Identifier("hidden_gems", "test_block"), modelBuilder -> modelBuilder.parent(new Identifier("hidden_gems", "block/test_block")));
            pack.addTranslations(new Identifier(HiddenGems.MOD_ID, "en_us"), translationBuilder ->
                    translationBuilder.entry("block.hidden_gems.test_block", "Test Block"));
        });
    }
}
