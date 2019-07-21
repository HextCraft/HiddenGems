package team.abnormals.hidden_gems.item;

import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import team.abnormals.hidden_gems.init.HGItems;

public class PhantomElytraItem extends ElytraItem {

    public PhantomElytraItem() {
        super(new Settings().maxDamage(432).group(ItemGroup.TRANSPORTATION).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean canRepair(ItemStack itemStack_1, ItemStack itemStack_2) {
        return itemStack_1.getItem() == HGItems.PHANTOM_LEATHER;
    }

}
