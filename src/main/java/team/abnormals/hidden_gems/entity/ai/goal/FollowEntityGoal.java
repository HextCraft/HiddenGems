package team.abnormals.hidden_gems.entity.ai.goal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;

import java.util.List;

public class FollowEntityGoal extends Goal {
	private final int chance;
	private final Class<? extends Entity> targetClass;
	protected MobEntity owner;
	protected int followRange;
	protected Entity following;

	// TODO: fix this
	public FollowEntityGoal(MobEntity entity, int chance, Class<? extends Entity> targetClass) {
		this.owner = entity;
		this.chance = chance;
		EntityAttributeInstance attribute = entity.getAttributeInstance(EntityAttributes.FOLLOW_RANGE);
		this.followRange = attribute != null ? (int) attribute.getValue() : 20;
		this.targetClass = targetClass;
	}

	@Override
	public boolean canStart() {
		if(chance >= 0 && owner.getRand().nextInt(chance) != 0) {
			List<? extends Entity> entities = owner.world.getEntities(targetClass, owner.getBoundingBox().expand(followRange, 4, followRange));
			return !entities.isEmpty();
		}
		return false;
	}

	@Override
	public void start() {
		List<? extends Entity> entities = owner.world.getEntities(targetClass, owner.getBoundingBox().expand(followRange, 4, followRange));
		Entity nearest = entities.get(0);
		double distance = Double.MAX_VALUE;
		for(Entity entity : entities) {
			double dist = entity.squaredDistanceTo(owner);
			if (dist < distance) {
				distance = dist;
				nearest = entity;
			}
		}
		following = nearest;
		this.owner.getNavigation().startMovingTo(following, 80);
	}

	@Override
	public void stop() {
		following = null;
	}

	@Override
	public boolean shouldContinue() {
        if(following == null || !following.isAlive())  return false;
        if(following.squaredDistanceTo(owner) <= 3) return false;
        return true;
	}

	@Override
	public void tick() {
		//owner.getNavigation().startMovingTo(following, 80);
		super.tick();
	}
}
