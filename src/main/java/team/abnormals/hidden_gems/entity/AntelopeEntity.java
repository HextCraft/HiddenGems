package team.abnormals.hidden_gems.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AntelopeEntity extends MobEntityWithAi {

    public AntelopeEntity(EntityType<? extends MobEntityWithAi> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.add(0, new FleeEntityGoal<>(this, WolfEntity.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.add(0, new FleeEntityGoal<>(this, HostileEntity.class, 8.0F, 2.2D, 2.2D));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(13.0F);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(10.0F);
    }

}