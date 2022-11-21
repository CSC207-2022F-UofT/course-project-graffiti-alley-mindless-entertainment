package objects.character;

public class Bystander extends Character {
    /** A class for the Bystander character.
     * Attributes:
     * name: The name of the Bystander.
     * hasQuest: True if the Bystander is involved in a Quest.
     */
    private String name;
    private boolean hasQuest;

    public Bystander(String name, boolean hasQuest) {
        // Creates a Bystander with name and hasQuest.
        super(name);
        this.hasQuest = hasQuest;
    }

    public boolean hasQuest() {
        // Returns true if this Bystander is involved in a Quest, and false otherwise.
        return this.hasQuest;
    }

    public void switchHasQuest() {
        // Switches hasQuest between true and false, or false and true.
        this.hasQuest = !this.hasQuest;
    }
}
