package team.abnormals.hidden_gems.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class PhasingEnchantment extends Enchantment {

    public PhasingEnchantment(Weight enchantment$Weight_1, EquipmentSlot... equipmentSlots_1) {
        super(enchantment$Weight_1, EnchantmentTarget.WEARABLE, equipmentSlots_1);
    }

    public int getMinimumPower(int int_1) {
        return 5 + int_1 * 7;
    }

    public int method_20742(int int_1) {
        return 50;
    }

    @Override
    public int getMaximumLevel() {
        return 2;
    }

}
