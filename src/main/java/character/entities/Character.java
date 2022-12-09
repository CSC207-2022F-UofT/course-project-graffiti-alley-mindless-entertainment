package character.entities;

/**
 * An abstract class for all Character entities. Includes methods for getting and setting the name attribute.
 */
public abstract class Character {
    /**
     * name: The name of this Character.
     */
    private String name;

    /**
     * Initializes a new Character with name.
     * @param name The name of the Character.
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * @return The name of this Character.
     */
    public String getName() {
        // Returns the name of this Character.
        return this.name;
    }

    /**
     * @param newName The name to change the Character's name to.
     */
    public void changeName(String newName) {
        // Changes the name of this Character to newName.
        this.name = newName;
    }
}
