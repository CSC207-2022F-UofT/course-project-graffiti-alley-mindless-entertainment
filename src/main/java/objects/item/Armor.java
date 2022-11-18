package objects.item;

import objects.item.Item;

public class Armor extends Item {

    public Armor(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " ARMOR");
        this.setAbility("Gain " + this.getLevel() + " Armor");
        this.setPrice(this.getLevel() + 3);
    }
}