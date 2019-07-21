package team.abnormals.hidden_gems.init;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.utils.registry.EntityRegistryBuilder;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.entity.AntelopeEntity;
import team.abnormals.hidden_gems.entity.AxocordeEntity;
import team.abnormals.hidden_gems.entity.FlyingLanternEntity;

public class HGEntities {

    public static final EntityType<AntelopeEntity> ANTELOPE;
    public static final EntityType<AxocordeEntity> AXOCORDE;
    public static final EntityType<FlyingLanternEntity> FLYING_LANTERN;

    static {
        ANTELOPE = EntityRegistryBuilder.<AntelopeEntity>createBuilder(new Identifier(HiddenGems.MOD_ID, "antelope"))
                .entity(AntelopeEntity::new)
                .category(EntityCategory.AMBIENT)
                .egg(0x9b744d, 0x353837)
                .hasEgg(true)
                .dimensions(EntityDimensions.fixed(1.0F, 1.0F))
                .build();
        AXOCORDE = EntityRegistryBuilder.<AxocordeEntity>createBuilder(new Identifier(HiddenGems.MOD_ID, "axocorde"))
                .entity(AxocordeEntity::new)
                .category(EntityCategory.AMBIENT)
                .egg(0x9b744d, 0x353837)
                .hasEgg(true)
                .dimensions(EntityDimensions.fixed(1.0F, 1.0F))
                .build();
        FLYING_LANTERN = EntityRegistryBuilder
                .<FlyingLanternEntity>createBuilder(new Identifier(HiddenGems.MOD_ID, "flying_lantern"))
                .entity(FlyingLanternEntity::new)
                .category(EntityCategory.MISC)
                .dimensions(EntityDimensions.fixed(1.0F, 1.0F))
                .hasEgg(false)
                .build();
    }

}
