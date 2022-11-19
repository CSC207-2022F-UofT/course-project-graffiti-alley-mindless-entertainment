package objects.item;

/**
 *
 */
public class Potion extends Item {

    /**
     * Initializes new potion item based on the level of player.
     * @param level level of the player.
     */
    public Potion(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " POTION");
        this.setAbility("Heal " + this.getLevel() + " HP");
        this.setPrice(this.getLevel());
    }
}