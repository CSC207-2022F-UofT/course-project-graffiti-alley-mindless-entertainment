package objects.character;

public class Shopkeeper extends Character {
    /** A class for the Shopkeeper non-player character.
     * Attributes:
     * name: The name of the Shopkeeper.
     * inventory: The inventory of the Shopkeeper, including the items that may be sold to the Player. Waiting
     *            for implementation of Inventory.
     */
    private String name;

    public Shopkeeper(String name) {
        super(name);
    }

}
