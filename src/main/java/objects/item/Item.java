package objects.item;

/**
 * A class for Item. Includes getter and setter for all attributes.
 */
public abstract class Item {

    /**
     * level: The level of player.
     * name: The name of item.
     * ability: The ability of item.
     * price: The price of item.
     */

    private int level;
    private String name;
    private String ability;
    private int price;

    /**
     * Initializes new Item with level, type, an empty name, an ability, and 0 price.
     * @param level
     */
    public Item(int level) {
        this.level = level;
        this.ability = "";
        this.price = 0;
        this.name = "";
    }

    /**
     * Getter for level.
     * @return the level of item.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter for name.
     * @return the name of item.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for ability.
     * @return the ability of item.
     */
    public String getAbility() {
        return ability;
    }

    /**
     * Getter for price.
     * @return the price of item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for level.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Setter for name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for ability.
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    /**
     * Setter for price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Return item name and ability as a string array.
     * @return the name and ability of item as list of strings {item name, item ability}.
     */
    public String[] getStats() {
        return new String[]{getName(), getAbility()};
    }
}
