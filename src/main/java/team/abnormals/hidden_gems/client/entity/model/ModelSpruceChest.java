package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelSpruceChest - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelSpruceChest extends EntityModel {
    public Cuboid Lid;
    public Cuboid Box;
    public Cuboid Handle;

    public ModelSpruceChest() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Handle = new Cuboid(this, 0, 0);
        this.Handle.setRotationPoint(7.0F, -1.0F, -14.0F);
        this.Handle.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 0, 0.0F);
        this.setRotateAngle(Handle, -0.2181661564992912F, 0.0F, 0.0F);
        this.Box = new Cuboid(this, 0, 19);
        this.Box.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.Box.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.Lid = new Cuboid(this, 0, 0);
        this.Lid.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.Lid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.Lid.addChild(this.Handle);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Box.render(f5);
        this.Lid.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(Cuboid modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }
}
