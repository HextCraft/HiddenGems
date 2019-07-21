package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelAntelope - Undefined
 * Created using Tabula 7.0.1
 */
public class AntelopeModel<T extends Entity> extends EntityModel<T> {
    public Cuboid RightFrontFoot;
    public Cuboid LeftFrontFoot;
    public Cuboid RightBackFoot;
    public Cuboid LeftBackFoot;
    public Cuboid Body;
    public Cuboid Neck;
    public Cuboid Head;
    public Cuboid Snout;
    public Cuboid RightAntler;
    public Cuboid LeftAntler;

    public AntelopeModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftBackFoot = new Cuboid(this, 50, 18);
        this.LeftBackFoot.setRotationPoint(3.0F, 12.0F, 15.0F);
        this.LeftBackFoot.addBox(-1.5F, -4.0F, -1.5F, 3, 16, 4, 0.0F);
        this.Body = new Cuboid(this, 0, 33);
        this.Body.setRotationPoint(0.0F, 6.0F, 16.1F);
        this.Body.addBox(-3.5F, -2.0F, -19.0F, 7, 9, 22, 0.0F);
        this.Neck = new Cuboid(this, 0, 40);
        this.Neck.setRotationPoint(0.0F, 6.0F, 1.0F);
        this.Neck.addBox(-2.0F, -10.0F, -4.0F, 4, 10, 5, 0.0F);
        this.setRotateAngle(Neck, 0.4363323129985824F, 0.0F, 0.0F);
        this.LeftFrontFoot = new Cuboid(this, 52, 38);
        this.LeftFrontFoot.setRotationPoint(2.5F, 12.0F, 0.0F);
        this.LeftFrontFoot.addBox(-1.5F, -2.0F, -1.5F, 3, 14, 3, 0.0F);
        this.Head = new Cuboid(this, 0, 19);
        this.Head.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.Head.addBox(-3.0F, -4.0F, -4.5F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Head, -0.2181661564992912F, 0.0F, 0.0F);
        this.LeftAntler = new Cuboid(this, 14, 0);
        this.LeftAntler.setRotationPoint(2.95F, 0.5F, 0.0F);
        this.LeftAntler.addBox(-6.0F, -12.0F, 0.0F, 6, 12, 0, 0.0F);
        this.setRotateAngle(LeftAntler, -0.4363323129985824F, 0.0F, 0.7853981633974483F);
        this.Snout = new Cuboid(this, 0, 31);
        this.Snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Snout.addBox(-2.0F, -2.0F, -9.5F, 4, 4, 5, 0.0F);
        this.RightFrontFoot = new Cuboid(this, 36, 38);
        this.RightFrontFoot.setRotationPoint(-2.5F, 12.0F, 0.0F);
        this.RightFrontFoot.addBox(-1.5F, -2.0F, -1.5F, 3, 14, 3, 0.0F);
        this.RightBackFoot = new Cuboid(this, 36, 18);
        this.RightBackFoot.setRotationPoint(-3.0F, 12.0F, 15.0F);
        this.RightBackFoot.addBox(-1.5F, -4.0F, -1.5F, 3, 16, 4, 0.0F);
        this.RightAntler = new Cuboid(this, 0, 0);
        this.RightAntler.setRotationPoint(-2.95F, 0.5F, 0.0F);
        this.RightAntler.addBox(0.0F, -12.0F, 0.0F, 6, 12, 0, 0.0F);
        this.setRotateAngle(RightAntler, -0.4363323129985824F, 0.0F, -0.7853981633974483F);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.LeftAntler);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.RightAntler);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.LeftBackFoot.render(f5);
        this.Body.render(f5);
        this.Neck.render(f5);
        this.LeftFrontFoot.render(f5);
        this.RightFrontFoot.render(f5);
        this.RightBackFoot.render(f5);
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
