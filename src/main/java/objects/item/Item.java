package objects.item;

public abstract class Item {
    /*
    A class for Item. Includes getter and setter for all attributes.
    Attributes:
    level: The level of player.
    name: The name of item.
    ability: The ability of item.
    price: The price of item.

     */

    private int level;
    private String name;
    private String ability;
    private int price;

    public Item(int level) {
        /*
        Initializes a new Item with level, type, an empty name, an ability, and 0 price.
         */

        this.level = level;
        this.ability = "";
        this.price = 0;
        this.name = "";
    }

    public int getLevel() {
        /*
        Getter for level.
         */
        return level;
    }


    public String getName() {
        /*
        Getter for name.
         */
        return name;
    }

    public String getAbility() {
        /*
        Getter for ability.
         */
        return ability;
    }

    public int getPrice() {
        /*
        Getter for price.
         */
        return price;
    }

    public void setLevel(int level) {
        /*
        Setter for level.
         */
        this.level = level;
    }

    public void setName(String name) {
        /*
        Setter for name.
         */
        this.name = name;
    }

    public void setAbility(String ability) {
        /*
        Setter for ability.
         */
        this.ability = ability;
    }

    public void setPrice(int price) {
        /*
        Setter for price.
         */
        this.price = price;
    }

    public String[] getStats() {
        /*
        Return item name and ability as a string array.
         */
        return new String[]{getName(), getAbility()};
    }
}
