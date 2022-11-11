package objects.character;

public abstract class Character {
    /** An abstract class for all Character entities. Includes methods for getting and setting the name attribute.
     * Attributes:
     * name: The name of this Character.
     */
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        // Returns the name of this Character.
        return this.name;
    }

    public void changeName(String newName) {
        // Changes the name of this Character to newName.
        this.name = newName;
    }
}
