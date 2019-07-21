package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelHawk - Undefined
 * Created using Tabula 7.0.1
 */
public class HawkModel extends EntityModel {
    public Cuboid Head;
    public Cuboid Body;
    public Cuboid Beak1;
    public Cuboid Beak2;
    public Cuboid RightWing;
    public Cuboid LeftWing;
    public Cuboid Tail;
    public Cuboid RightLeg;
    public Cuboid LeftLeg;

    public HawkModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.LeftWing = new Cuboid(this, 20, 20);
        this.LeftWing.mirror = true;
        this.LeftWing.setRotationPoint(2.75F, 1.25F, 0.5F);
        this.LeftWing.addBox(-0.5F, 0.0F, -2.5F, 1, 7, 5, 0.0F);
        this.setRotateAngle(LeftWing, 0.0F, -0.2617993877991494F, 0.0F);
        this.Body = new Cuboid(this, 0, 10);
        this.Body.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.Body.addBox(-2.5F, 0.0F, -2.0F, 5, 8, 4, 0.0F);
        this.setRotateAngle(Body, 0.5235987755982988F, 0.0F, 0.0F);
        this.Beak2 = new Cuboid(this, 22, 0);
        this.Beak2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beak2.addBox(-1.0F, 1.0F, -5.5F, 2, 1, 1, 0.0F);
        this.Tail = new Cuboid(this, -8, 24);
        this.Tail.setRotationPoint(0.0F, 7.5F, 2.0F);
        this.Tail.addBox(-4.0F, 0.0F, 0.0F, 8, 0, 8, 0.0F);
        this.setRotateAngle(Tail, -0.2617993877991494F, 0.0F, 0.0F);
        this.RightLeg = new Cuboid(this, 18, 6);
        this.RightLeg.setRotationPoint(-1.5F, 8.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(RightLeg, -0.5235987755982988F, 0.0F, 0.0F);
        this.LeftLeg = new Cuboid(this, 18, 6);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(2.0F, 8.0F, 0.0F);
        this.LeftLeg.addBox(-1.5F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(LeftLeg, -0.5235987755982988F, 0.0F, 0.0F);
        this.RightWing = new Cuboid(this, 20, 20);
        this.RightWing.setRotationPoint(-2.75F, 1.25F, 0.5F);
        this.RightWing.addBox(-0.5F, 0.0F, -2.5F, 1, 7, 5, 0.0F);
        this.setRotateAngle(RightWing, 0.0F, 0.2617993877991494F, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 6, 0.0F);
        this.Beak1 = new Cuboid(this, 14, 0);
        this.Beak1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beak1.addBox(-1.0F, -1.0F, -5.5F, 2, 2, 3, 0.0F);
        this.setRotateAngle(Beak1, 0.08726646259971647F, 0.0F, 0.0F);
        this.Body.addChild(this.LeftWing);
        this.Beak1.addChild(this.Beak2);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.RightLeg);
        this.Body.addChild(this.LeftLeg);
        this.Body.addChild(this.RightWing);
        this.Head.addChild(this.Beak1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.render(f5);
        this.Head.render(f5);
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
