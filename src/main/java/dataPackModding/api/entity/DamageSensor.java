package dataPackModding.api.entity;

public class DamageSensor {

    public Trigger triggers;

    public static class Trigger {

        public String cause;
        public boolean deals_damage;

    }

}
