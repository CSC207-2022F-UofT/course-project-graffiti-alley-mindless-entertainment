package character.entities;

/**
 * A class for the Bystander character.
 */
public class Bystander extends Character {
    /**
     * name: The name of the Bystander.
     * hasQuest: True if the Bystander is involved in a Quest.
     */
    private String name;
    private boolean hasQuest;

    /**
     * Initializes a Bystander with name and hasQuest.
     * @param name The name of the Bystander.
     * @param hasQuest True if the Bystander is associated with a quest, false otherwise.
     */
    public Bystander(String name, boolean hasQuest) {
        super(name);
        this.hasQuest = hasQuest;
    }

    /**
     * @return True if this Bystander is involved in a Quest, false otherwise.
     */
    public boolean hasQuest() {
        return this.hasQuest;
    }

    /**
     * Switches hasQuest between true and false, or false and true.
     */
    public void switchHasQuest() {
        this.hasQuest = !this.hasQuest;
    }
}
