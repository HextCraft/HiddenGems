package team.abnormals.hidden_gems.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.world.World;

public class AxocordeEntity extends MobEntityWithAi {

    public AxocordeEntity(EntityType<? extends MobEntityWithAi> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected void initGoals() {
        super.initGoals();
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(10.0F);
    }

}