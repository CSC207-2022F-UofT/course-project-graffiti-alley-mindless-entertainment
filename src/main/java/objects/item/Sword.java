package objects.item;

import objects.item.Item;

public class Sword extends Item {

    public Sword(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " Sword");
        this.setAbility("Grant " + this.getLevel() + " Damage");
        this.setPrice(this.getLevel() + 5);
    }
}