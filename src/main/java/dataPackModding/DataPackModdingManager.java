package dataPackModding;

import com.google.gson.*;
import dataPackModding.api.ToolItem;
import dataPackModding.api.*;
import dataPackModding.minecraft.EntityImpl;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.*;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.Registry;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.hidden_gems.HiddenGems;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class DataPackModdingManager implements SimpleResourceReloadListener<DataPackModdingManager.RawData> {

    @Override
    public CompletableFuture<RawData> load(ResourceManager manager, Profiler profiler, Executor executor) {
        return CompletableFuture.supplyAsync(() -> new RawData(manager), executor);
    }

    @Override
    public CompletableFuture<Void> apply(RawData data, ResourceManager manager, Profiler profiler, Executor executor) {
        return CompletableFuture.runAsync(data::apply, executor);
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier(HiddenGems.MOD_ID, "data_pack_modding");
    }

    public void registerReloadListener() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(this);
    }

    public static class RawData {

        private static final Gson GSON = new GsonBuilder()
                .setPrettyPrinting()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(ItemStack.class, new ItemStackSerializer())
                .registerTypeAdapter(Identifier.class, (SimpleStringDeserializer<?>)Identifier::new)
                .setLenient()
                .create();

        List<FoodItem> foodItems = new ArrayList<>();
        List<ToolItem> toolItems = new ArrayList<>();
        List<Block> blocks = new ArrayList<>();
        List<Entity> entities = new ArrayList<>();
        List<Potion> potions = new ArrayList<>();

        RawData(ResourceManager manager) {
            for (Identifier id : manager.findResources("config/data_pack_modding", path -> path.endsWith(".json"))) {
                try {
                    InputStreamReader reader = new InputStreamReader(manager.getResource(id).getInputStream());
                    if (id.getPath().startsWith("config/data_pack_modding/food/"))
                        foodItems.add(GSON.fromJson(reader, FoodItem.class));
                    else if (id.getPath().startsWith("config/data_pack_modding/tools/"))
                        toolItems.add(GSON.fromJson(reader, ToolItem.class));
                    else if (id.getPath().startsWith("config/data_pack_modding/blocks/"))
                        blocks.add(GSON.fromJson(reader, Block.class));
                    else if (id.getPath().startsWith("config/data_pack_modding/entities/"))
                        entities.add(GSON.fromJson(reader, Entity.class));
                    else if (id.getPath().startsWith("config/data_pack_modding/potions/"))
                        potions.add(GSON.fromJson(reader, Potion.class));
                    else HiddenGems.LOGGER.warn("[HiddenGems:DataPackModdingManager] Unknown resource '{}'", id);
                } catch (JsonIOException | JsonSyntaxException ex) {
                    HiddenGems.LOGGER.error("[HiddenGems:DataPackModdingManager] Error while parsing resource '{}'", id, ex);
                } catch (IOException ex) {
                    HiddenGems.LOGGER.error("[HiddenGems:DataPackModdingManager] Error reading resource '{}'", id, ex);
                } catch (Exception ex) {
                    HiddenGems.LOGGER.error("[HiddenGems:DataPackModdingManager] Error loading resource '{}'", id, ex);
                }
            }
        }

        public void apply() {
            for(FoodItem foodItem : this.foodItems) {
                FoodComponent foodComponent = foodItem.components.food.getBuilder().build();
                if (foodItem.max_count == 0) foodItem.max_count = 64;
                Registry.ITEM.set(Registry.ITEM.getIds().size() + 1, foodItem.identifier, new Item(new Item.Settings()
                        .group(foodItem.getItemGroup())
                        .maxCount(foodItem.max_count)
                        .maxDamage(foodItem.components.use_duration)
                        .rarity(foodItem.getRarity())
                        .food(foodComponent)));
                System.out.println(String.format("Registered a food called %s", foodItem.identifier));
            }
            for(ToolItem toolItem : this.toolItems) {
                if (toolItem.max_count == 0) toolItem.max_count = 64;
                RegistryUtils.registerItem(new Item(new Item.Settings().group(toolItem.getItemGroup()).rarity(toolItem.getRarity())), toolItem.identifier);
                System.out.println(String.format("Registered a tool called %s", toolItem.identifier));
            }
            for(Block block : this.blocks) {
                RegistryUtils.register(new net.minecraft.block.Block(net.minecraft.block.Block.Settings.of(block.getMaterial())), block.identifier, block.getItemGroup());
                System.out.println(String.format("Registered a block called %s", block.identifier));
            }
            for(Entity entity : this.entities) {
                EntityType<EntityImpl> type = new EntityType<>(EntityImpl::new, entity.components.getCategory(),
                        false, entity.summonable, false, entity.spawnable, EntityDimensions.fixed(entity.components.collision_box.width, entity.components.collision_box.height));
                Registry.register(Registry.ENTITY_TYPE, entity.identifier, type);
                if (entity.spawnable) {
                    Registry.register(Registry.ITEM, new Identifier(entity.identifier.getNamespace(), String.format("%s_spawn_egg", entity.identifier.getPath())),
                            new SpawnEggItem(type, entity.spawn_egg_color_main, entity.spawn_egg_color_overlay, new Item.Settings().group(ItemGroup.MISC)));
                }
                System.out.println(String.format("Registered an entity called %s", entity.identifier));
            }
            for (Potion potion : this.potions) {
                if(potion != null) {
                    Registry.register(Registry.POTION, Objects.requireNonNull(potion).name,
                            new net.minecraft.potion.Potion(new StatusEffectInstance(Objects.requireNonNull(potion).getEffectType(), Objects.requireNonNull(potion).getEffects().duration,
                                    Objects.requireNonNull(potion).getEffects().amplifier)));
                    System.out.println(String.format("Registered a potion effect called %s", Objects.requireNonNull(potion).name));
                }
            }
        }

    }

    @FunctionalInterface
    public interface SimpleStringDeserializer<T> extends Function<String, T>, JsonDeserializer<T> {
        default T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return this.apply(json.getAsString());
        }
    }

}
