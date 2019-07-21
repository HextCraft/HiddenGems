package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * Yeti - AguilaDaddy
 * Created using Tabula 7.0.0
 */
public class Yeti extends EntityModel {
    public Cuboid shape1;
    public Cuboid shape1_1;
    public Cuboid shape3;
    public Cuboid shape1_2;
    public Cuboid shape1_3;
    public Cuboid shape9;
    public Cuboid shape1_4;
    public Cuboid shape1_5;
    public Cuboid shape14;

    public Yeti() {
        this.textureWidth = 84;
        this.textureHeight = 42;
        this.shape1_1 = new Cuboid(this, 0, 0);
        this.shape1_1.setRotationPoint(-2.5F, 15.0F, 7.0F);
        this.shape1_1.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F);
        this.shape3 = new Cuboid(this, 32, 0);
        this.shape3.setRotationPoint(0.0F, 9.0F, -4.0F);
        this.shape3.addBox(-4.0F, 0.0F, -2.0F, 8, 14, 4, 0.0F);
        this.setRotateAngle(shape3, 0.9560913642424937F, 0.0F, 0.0F);
        this.shape1_2 = new Cuboid(this, 56, 10);
        this.shape1_2.mirror = true;
        this.shape1_2.setRotationPoint(5.0F, 10.0F, -3.0F);
        this.shape1_2.addBox(-1.0F, -1.0F, -2.0F, 4, 6, 4, 0.0F);
        this.shape1 = new Cuboid(this, 0, 0);
        this.shape1.mirror = true;
        this.shape1.setRotationPoint(2.5F, 15.0F, 7.0F);
        this.shape1.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F);
        this.shape14 = new Cuboid(this, 17, 13);
        this.shape14.setRotationPoint(0.0F, 1.0F, -4.0F);
        this.shape14.addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
        this.shape1_4 = new Cuboid(this, 58, 20);
        this.shape1_4.mirror = true;
        this.shape1_4.setRotationPoint(1.0F, 5.0F, 0.0F);
        this.shape1_4.addBox(-2.5F, 0.0F, -2.5F, 5, 9, 5, 0.0F);
        this.shape1_3 = new Cuboid(this, 56, 10);
        this.shape1_3.setRotationPoint(-5.0F, 10.0F, -3.0F);
        this.shape1_3.addBox(-3.0F, -1.0F, -2.0F, 4, 6, 4, 0.0F);
        this.shape9 = new Cuboid(this, 0, 13);
        this.shape9.setRotationPoint(0.0F, 9.0F, -5.0F);
        this.shape9.addBox(-3.0F, -3.5F, -4.0F, 6, 7, 5, 0.0F);
        this.shape1_5 = new Cuboid(this, 58, 20);
        this.shape1_5.setRotationPoint(-1.0F, 5.0F, 0.0F);
        this.shape1_5.addBox(-2.5F, 0.0F, -2.5F, 5, 9, 5, 0.0F);
        this.shape9.addChild(this.shape14);
        this.shape1_2.addChild(this.shape1_4);
        this.shape1_3.addChild(this.shape1_5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.shape1_1.render(f5);
        this.shape3.render(f5);
        this.shape1_2.render(f5);
        this.shape1.render(f5);
        this.shape1_3.render(f5);
        this.shape9.render(f5);
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
