package team.abnormals.hidden_gems.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.enchantments.PhasingEnchantment;

public class HGEnchantments {

    public static final Enchantment PHASING;

    static {
        PHASING = Registry.register(Registry.ENCHANTMENT, new Identifier(HiddenGems.MOD_ID, "phasing"), new PhasingEnchantment(Enchantment.Weight.RARE, EquipmentSlot.CHEST));
    }

}
