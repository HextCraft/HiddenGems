package dataPackModding.api.potion;

import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;

public class EffectInstance {

    public Identifier name;
    public int duration;
    public int amplifier;
    public String effect_type;
    public int color;

    public StatusEffectType getEffectType() {
        switch (effect_type) {
            case "beneficial":
                return StatusEffectType.BENEFICIAL;
            case "harmful":
                return StatusEffectType.HARMFUL;
            case "neutral":
            default:
                return StatusEffectType.NEUTRAL;
        }
    }

}
