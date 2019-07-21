package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * Necro - Undefined
 * Created using Tabula 7.0.1
 */
public class NecroModel extends EntityModel {
    public Cuboid Head;
    public Cuboid Nose;
    public Cuboid Hat;
    public Cuboid Robes;
    public Cuboid Body;
    public Cuboid RightArm;
    public Cuboid LeftArm;
    public Cuboid RightLeg;
    public Cuboid LeftLeg;
    public Cuboid MiddleCrossArm;
    public Cuboid RightCrossarm;
    public Cuboid LeftCrossArm;

    public NecroModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightLeg = new Cuboid(this, 0, 22);
        this.RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Body = new Cuboid(this, 16, 20);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.Nose = new Cuboid(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -4.0F);
        this.Nose.addBox(-1.0F, -1.0F, -2.0F, 2, 4, 2, 0.0F);
        this.RightCrossarm = new Cuboid(this, 44, 22);
        this.RightCrossarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.RightCrossarm.addBox(-8.0F, -5.0F, -1.0F, 4, 8, 4, 0.0F);
        this.Robes = new Cuboid(this, 0, 38);
        this.Robes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Robes.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Hat = new Cuboid(this, 32, 0);
        this.Hat.setRotationPoint(0.0F, -9.75F, 0.5F);
        this.Hat.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.5F);
        this.setRotateAngle(Hat, -0.17453292519943295F, 0.0F, 0.0F);
        this.LeftArm = new Cuboid(this, 40, 46);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightArm = new Cuboid(this, 40, 46);
        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.LeftCrossArm = new Cuboid(this, 44, 22);
        this.LeftCrossArm.mirror = true;
        this.LeftCrossArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.LeftCrossArm.addBox(4.0F, -5.0F, -1.0F, 4, 8, 4, 0.0F);
        this.LeftLeg = new Cuboid(this, 0, 22);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.MiddleCrossArm = new Cuboid(this, 40, 38);
        this.MiddleCrossArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.MiddleCrossArm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(MiddleCrossArm, -0.7853981633974483F, 0.0F, 0.0F);
        this.MiddleCrossArm.addChild(this.RightCrossarm);
        this.MiddleCrossArm.addChild(this.LeftCrossArm);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.RightLeg.render(f5);
        this.Body.render(f5);
        this.Nose.render(f5);
        this.Robes.render(f5);
        this.Hat.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.Head.render(f5);
        this.LeftLeg.render(f5);
        this.MiddleCrossArm.render(f5);
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
