package dataPackModding.client;

import com.swordglowsblue.artifice.api.Artifice;
import dataPackModding.api.Block;
import dataPackModding.api.Entity;
import dataPackModding.api.Item;
import dataPackModding.api.Potion;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArtificeAssetGeneration implements ClientModInitializer {

    public static List<Item> items = new ArrayList<>();
    public static List<Block> blocks = new ArrayList<>();
    public static List<Entity> entities = new ArrayList<>();
    public static List<Potion> potions = new ArrayList<>();

    @Override
    public void onInitializeClient() {
        Artifice.registerAssets("client_side_resources", clientResourcePackBuilder -> {
            for (Item item : items) {
                clientResourcePackBuilder.addTranslations(new Identifier(item.identifier.getNamespace(), "en_us"), translationBuilder -> {
                    String formatted_name = StringUtils.capitalize(item.identifier.getPath());
                    translationBuilder.entry(String.format("item.%s.%s", item.identifier.getNamespace(), item.identifier.getPath()), formatted_name);
                });
                if (item.texture != null) {
                    clientResourcePackBuilder.addItemModel(new Identifier(item.identifier.getNamespace(), String.format("item/%s", item.identifier.getPath())), modelBuilder -> {
                        modelBuilder.parent(new Identifier("item/generated"));
                        modelBuilder.texture("layer0", item.texture);
                    });
                }
            }
        });
    }

}
