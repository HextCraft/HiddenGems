package team.abnormals.hidden_gems.mixin.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.abnormals.hidden_gems.entity.FlyingLanternEntity;
import team.abnormals.hidden_gems.entity.ai.goal.FollowEntityGoal;

@Mixin(HostileEntity.class)
public abstract class HostileEntityMixin extends MobEntityWithAi {
	protected HostileEntityMixin(EntityType<? extends MobEntityWithAi> entityType_1, World world_1) {
		super(entityType_1, world_1);
	}

	@Inject(method = "<init>", at = @At("RETURN"))
	public void onConstruct(EntityType entityType, World world, CallbackInfo callbackInfo) {
		if(world != null && !world.isClient()) {
			//targetSelector.add(2, new FollowTargetGoal(this, FlyingLanternEntity.class, false));
			goalSelector.add(1, new FollowEntityGoal(this, 50, FlyingLanternEntity.class));
		}
	}
}
