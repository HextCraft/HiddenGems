package team.abnormals.hidden_gems.mixin.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot var1);

    @Shadow protected int field_6239;

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public void initAi() {
        boolean boolean_1 = this.getFlag(7);
        if (boolean_1 && !this.onGround && !this.hasVehicle()) {
            ItemStack itemStack_1 = this.getEquippedStack(EquipmentSlot.CHEST);
            if (itemStack_1.getItem() instanceof ElytraItem && ElytraItem.isUsable(itemStack_1)) {
             boolean_1 = true;
             if (!this.world.isClient && (this.field_6239 + 1) % 20 == 0) {
                 itemStack_1.damage(1, (LivingEntity) (Object) this, (livingEntity_1) ->
                         livingEntity_1.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
             }
            } else {
             boolean_1 = false;
            }
        } else {
            boolean_1 = false;
        }

        if (!this.world.isClient) {
            this.setFlag(7, boolean_1);
        }

    }

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public void onEquipStack(ItemStack itemStack_1) {
        if (!itemStack_1.isEmpty()) {
            SoundEvent soundEvent_1 = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
            Item item_1 = itemStack_1.getItem();
            if (item_1 instanceof ArmorItem) {
             soundEvent_1 = ((ArmorItem) item_1).getMaterial().getEquipSound();
            } else if (item_1 instanceof ElytraItem) {
             soundEvent_1 = SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA;
            }

            this.playSound(soundEvent_1, 1.0F, 1.0F);
        }
    }

}
