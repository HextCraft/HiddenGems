package team.abnormals.hidden_gems.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.packet.EntitySpawnS2CPacket;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.abnormals.hidden_gems.entity.FlyingLanternEntity;
import team.abnormals.hidden_gems.init.HGEntities;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {
	@Shadow private ClientWorld world;

	@Inject(method = "onEntitySpawn", at = @At(value = "TAIL"))
	public void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo callbackInfo) {
		EntityType entityType = packet.getEntityTypeId();
		Entity entity = null;

		if(entityType == HGEntities.FLYING_LANTERN) {
            entity = FlyingLanternEntity.create(world, packet.getX(), packet.getY(), packet.getZ(), Block.getStateFromRawId(packet.getEntityData()));
		}

		if(entity != null) {
			double x = packet.getX();
			double y = packet.getY();
			double z = packet.getZ();
			entity.setPosition(x, y, z);
			entity.updateTrackedPosition(x, y, z);
			entity.pitch = (float)(packet.getPitch() * 360) / 250F;
			entity.yaw = (float)(packet.getYaw() * 360) / 250F;
			entity.setEntityId(packet.getId());
			entity.setUuid(packet.getUuid());
			world.addEntity(packet.getId(), entity);
		}
	}
}
