package objects.item;

/**
 *
 */
public class Armor extends Item {

    /**
     * Initializes new Armor Item based on the level of player.
     * @param level level of the user.
     */
    public Armor(int level) {
        super(level);
        this.setName("LEVEL " + this.getLevel() + " ARMOR");
        this.setAbility("Gain " + this.getLevel() + " Armor");
        this.setPrice(this.getLevel() + 3);
    }
}