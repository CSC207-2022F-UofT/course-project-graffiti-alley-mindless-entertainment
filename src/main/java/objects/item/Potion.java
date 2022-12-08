package objects.item;

/**
 * Entity for Potion Item. Inherits an abstract class Item.
 */
public class Potion extends Item {

    /**
     * Initializes new potion item based on the level of player.
     * @param level level of the player.
     */
    public Potion(int level) {
        super(level);
        this.setName("LEVEL " + (this.getLevel() + 1) + " POTION");
        this.setAbility("Heal " + (this.getLevel() + 1) * 10 + " HP");
        this.setPrice(this.getLevel());
    }
}