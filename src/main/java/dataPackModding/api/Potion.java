package dataPackModding.api;

import dataPackModding.api.potion.EffectInstance;
import dataPackModding.minecraft.StatusEffectImpl;
import net.minecraft.util.Identifier;

public class Potion {

    public Identifier name;
    public EffectInstance[] effects;

    public EffectInstance getEffects() {
        for(EffectInstance effectInstance : effects) {
            return effectInstance;
        }
        return null;
    }

    public StatusEffectImpl getEffectType() {
        for (EffectInstance instance : effects) {
            return new StatusEffectImpl(instance.getEffectType(), instance.color);
        }
        return null;
    }

}
