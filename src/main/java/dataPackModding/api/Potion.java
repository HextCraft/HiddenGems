package dataPackModding.api;

import dataPackModding.api.potion.EffectInstance;
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
}
