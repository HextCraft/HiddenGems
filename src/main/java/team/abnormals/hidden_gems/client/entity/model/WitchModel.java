package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelWitch - Undefined
 * Created using Tabula 7.0.1
 */
public class WitchModel extends EntityModel {
    public Cuboid Head;
    public Cuboid Body;
    public Cuboid Cloak;
    public Cuboid RightLeg;
    public Cuboid LeftLeg;
    public Cuboid MiddleClosedArm;
    public Cuboid RightOpenArm;
    public Cuboid LeftOpenArm;
    public Cuboid Nose;
    public Cuboid Hat1;
    public Cuboid Hat2;
    public Cuboid Hat3;
    public Cuboid RightClosedArm;
    public Cuboid LeftClosedArm;

    public WitchModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightLeg = new Cuboid(this, 0, 16);
        this.RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.MiddleClosedArm = new Cuboid(this, 38, 12);
        this.MiddleClosedArm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.MiddleClosedArm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(MiddleClosedArm, -0.7853981633974483F, 0.0F, 0.0F);
        this.Hat2 = new Cuboid(this, 32, 39);
        this.Hat2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Hat2.addBox(-4.0F, -5.0F, 0.0F, 8, 5, 8, 0.0F);
        this.setRotateAngle(Hat2, -0.20943951023931953F, 0.0F, 0.0F);
        this.Nose = new Cuboid(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -3.0F, -4.0F);
        this.Nose.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.Body = new Cuboid(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.LeftOpenArm = new Cuboid(this, 44, 20);
        this.LeftOpenArm.mirror = true;
        this.LeftOpenArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftOpenArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightOpenArm = new Cuboid(this, 44, 20);
        this.RightOpenArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightOpenArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LeftClosedArm = new Cuboid(this, 32, 0);
        this.LeftClosedArm.mirror = true;
        this.LeftClosedArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftClosedArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.LeftLeg = new Cuboid(this, 0, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Hat3 = new Cuboid(this, 48, 3);
        this.Hat3.setRotationPoint(0.0F, -5.0F, 2.0F);
        this.Hat3.addBox(-2.0F, -5.0F, 0.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(Hat3, -0.4363323129985824F, 0.0F, 0.0F);
        this.Cloak = new Cuboid(this, 0, 34);
        this.Cloak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Cloak.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Hat1 = new Cuboid(this, 24, 52);
        this.Hat1.setRotationPoint(0.0F, -7.0F, -4.0F);
        this.Hat1.addBox(-5.0F, -2.0F, -1.0F, 10, 2, 10, 0.0F);
        this.setRotateAngle(Hat1, -0.12217304763960307F, 0.0F, 0.0F);
        this.RightClosedArm = new Cuboid(this, 32, 0);
        this.RightClosedArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightClosedArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.Hat1.addChild(this.Hat2);
        this.Head.addChild(this.Nose);
        this.MiddleClosedArm.addChild(this.LeftClosedArm);
        this.Hat2.addChild(this.Hat3);
        this.Head.addChild(this.Hat1);
        this.MiddleClosedArm.addChild(this.RightClosedArm);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.RightLeg.render(f5);
        this.MiddleClosedArm.render(f5);
        this.Body.render(f5);
        this.LeftOpenArm.render(f5);
        this.RightOpenArm.render(f5);
        this.Head.render(f5);
        this.LeftLeg.render(f5);
        this.Cloak.render(f5);
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
