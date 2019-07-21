package team.abnormals.hidden_gems.mixin.client.color.item;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.item.DyeableItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.abnormals.hidden_gems.init.HGItems;

@Mixin(ItemColors.class)
public class ItemColorsMixin {

    @Inject(method = "create(Lnet/minecraft/client/color/block/BlockColors;)Lnet/minecraft/client/color/item/ItemColors;", at = @At("RETURN"))
    private static void createItemColors(BlockColors blockColors_1, CallbackInfoReturnable callbackInfo) {
        ItemColors itemColors_1_hg = new ItemColors();
        itemColors_1_hg.register((itemStack_1, int_1) ->
                int_1 > 0 ? -1 : ((DyeableItem)itemStack_1.getItem())
                        .getColor(itemStack_1), HGItems.PHANTOM_LEATHER_HELMET, HGItems.PHANTOM_LEATHER_CHESTPLATE,
                HGItems.PHANTOM_LEATHER_LEGGINGS, HGItems.PHANTOM_LEATHER_BOOTS);
    }

}
