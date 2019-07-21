package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * Axocorde - Axoladdy
 * Created using Tabula 7.0.0
 */
public class AxocordeEntityModel<T extends Entity> extends EntityModel<T> {
    public Cuboid mane;
    public Cuboid head;
    public Cuboid Body;
    public Cuboid leftwing;
    public Cuboid rightwing;
    public Cuboid tail;
    public Cuboid lefttip;
    public Cuboid righttip;
    public Cuboid tfeathers;
    public Cuboid TopBeak;
    public Cuboid TopBeak_1;

    public AxocordeEntityModel() {
        this.textureWidth = 256;
        this.textureHeight = 150;
        this.rightwing = new Cuboid(this, 0, 113);
        this.rightwing.setRotationPoint(-16.0F, -3.0F, 0.0F);
        this.rightwing.addBox(-48.0F, -1.0F, 0.0F, 48, 4, 32, 0.0F);
        this.setRotateAngle(rightwing, 0.0F, 0.0F, 0.17453292519943295F);
        this.tfeathers = new Cuboid(this, 138, 82);
        this.tfeathers.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.tfeathers.addBox(-12.0F, 0.0F, 0.0F, 24, 2, 32, 0.0F);
        this.tail = new Cuboid(this, 120, 0);
        this.tail.setRotationPoint(0.0F, -4.0F, 48.0F);
        this.tail.addBox(-8.0F, 0.0F, 0.0F, 16, 6, 16, 0.0F);
        this.setRotateAngle(tail, 0.136659280431156F, 0.0F, 0.0F);
        this.TopBeak = new Cuboid(this, 13, 17);
        this.TopBeak.setRotationPoint(0.0F, -1.8F, -5.0F);
        this.TopBeak.addBox(-3.0F, 0.0F, -10.0F, 6, 4, 10, 0.0F);
        this.setRotateAngle(TopBeak, 0.40980330836826856F, 0.0F, 0.0F);
        this.head = new Cuboid(this, 210, 130);
        this.head.setRotationPoint(0.0F, 16.0F, -27.0F);
        this.head.addBox(-5.0F, -5.0F, -4.9F, 10, 10, 10, 0.0F);
        this.setRotateAngle(head, 0.40980330836826856F, -0.22759093446006054F, 0.0F);
        this.Body = new Cuboid(this, 0, 11);
        this.Body.setRotationPoint(0.0F, 1.0F, 11.0F);
        this.Body.addBox(-16.0F, -6.0F, 0.0F, 32, 12, 48, 0.0F);
        this.righttip = new Cuboid(this, 160, 45);
        this.righttip.setRotationPoint(-48.0F, 0.0F, 0.0F);
        this.righttip.addBox(-30.0F, 0.0F, 0.0F, 30, 2, 30, 0.0F);
        this.setRotateAngle(righttip, 0.0F, 0.0F, 0.17453292519943295F);
        this.mane = new Cuboid(this, 160, 120);
        this.mane.setRotationPoint(0.0F, 15.0F, -27.0F);
        this.mane.addBox(-6.0F, -6.0F, 5.0F, 12, 12, 6, 0.0F);
        this.setRotateAngle(mane, -0.045553093477052F, 0.0F, 0.0F);
        this.lefttip = new Cuboid(this, 160, 1);
        this.lefttip.setRotationPoint(48.0F, 0.0F, 0.0F);
        this.lefttip.addBox(0.0F, 0.0F, 0.0F, 30, 2, 30, 0.0F);
        this.setRotateAngle(lefttip, 0.0F, 0.0F, -0.17453292519943295F);
        this.TopBeak_1 = new Cuboid(this, 22, 40);
        this.TopBeak_1.setRotationPoint(0.0F, 4.0F, -2.0F);
        this.TopBeak_1.addBox(-3.0F, 0.0F, -4.0F, 6, 1, 5, 0.0F);
        this.leftwing = new Cuboid(this, 0, 74);
        this.leftwing.setRotationPoint(16.0F, -4.0F, 0.0F);
        this.leftwing.addBox(0.0F, 0.0F, 0.0F, 48, 4, 32, 0.0F);
        this.setRotateAngle(leftwing, 0.0F, 0.0F, -0.17453292519943295F);
        this.Body.addChild(this.rightwing);
        this.tail.addChild(this.tfeathers);
        this.Body.addChild(this.tail);
        this.head.addChild(this.TopBeak);
        this.mane.addChild(this.Body);
        this.rightwing.addChild(this.righttip);
        this.leftwing.addChild(this.lefttip);
        this.TopBeak.addChild(this.TopBeak_1);
        this.Body.addChild(this.leftwing);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.render(f5);
        this.mane.render(f5);
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
