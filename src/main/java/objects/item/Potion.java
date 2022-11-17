package objects.item;

import objects.item.Item;

public class Potion extends Item {

    public Potion(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " Potion");
        this.setAbility("Heal " + this.getLevel() + " HP");
        this.setPrice(this.getLevel());
    }
}
