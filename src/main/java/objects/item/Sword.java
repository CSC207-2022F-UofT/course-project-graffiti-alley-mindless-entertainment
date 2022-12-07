package objects.item;

/**
 * Entity for Sword Item. Inherits an abstract class Item.
 */
public class Sword extends Item {

    /**
     * Initializes new Sword item based on the level of player.
     * @param level level of the player
     */
    public Sword(int level) {
        super(level);
        this.setName("LEVEL " + (this.getLevel() + 1) + " SWORD");
        this.setAbility("Grant " + (this.getLevel() + 1) + " Damage");
        this.setPrice(this.getLevel() + 5);
    }
}