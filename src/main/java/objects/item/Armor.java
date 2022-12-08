package objects.item;

/**
 * Entity for Armor. Inherits an abstract class Item.
 */
public class Armor extends Item {

    /**
     * Initializes new Armor Item based on the level of player.
     * @param level level of the user.
     */
    public Armor(int level) {
        super(level);
        this.setName("LEVEL " + (this.getLevel() + 1) + " ARMOR");
        this.setAbility("Gain " + (this.getLevel() + 1) * 10 + " Armor");
        this.setPrice(this.getLevel() + 3);
    }
}