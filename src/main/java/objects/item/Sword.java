package objects.item;

/**
 *
 */
public class Sword extends Item {

    /**
     * Initializes new Sword item based on the level of player.
     * @param level level of the player
     */
    public Sword(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " SWORD");
        this.setAbility("Grant " + this.getLevel() + " Damage");
        this.setPrice(this.getLevel() + 5);
    }
}