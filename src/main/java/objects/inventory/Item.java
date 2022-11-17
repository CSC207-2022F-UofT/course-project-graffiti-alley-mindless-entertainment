package objects.inventory;

public class Item {
    /*
    A class for Item. Includes getter and setter for all attributes.
    Attributes:
    level: The level of player.
    type: The type of item (Armor, Weapon, Potion).
    name: The name of item.
    ability: The ability of item.
    price: The price of item.
     */
    public enum Type{
        /*
        More types could be added later.
         */
        Armor,
        Weapon,
        Potion
    }
    private int level;
    private Type type;
    private String name;
    private String ability;
    private int price;

    public Item(int level, Type type) {
        /*
        Initializes a new Item with level, type, name, ability, and price.
         */

        this.level = level;
        this.type = type;
        setAttributes();
    }

    public void setAttributes(){
        /*
        Set attributes name, ability, and price based on the level of player and the type of item.
        THIS will be modified after discussing with battle system.
         */
        switch (type){
            case Armor:
                this.name = "LEVEL " + this.level + " ARMOR";
                this.ability = " Grant " + this.level + " Armor";
                this.price = this.level + 5;
                break;

            case Weapon:
                this.name = "LEVEL " + this.level + " WEAPON";
                this.ability = " Grant " + this.level + " Damage";
                this.price = this.level + 5;
                break;

            case Potion:
                this.name = "LEVEL " + this.level + " POTION";
                this.ability = " Heal " + this.level + " HP";
                this.price = this.level + 5;
                break;

        }
    }

    public int getLevel() {
        /*
        Getter for level.
         */
        return level;
    }

    public Type getType() {
        /*
        Getter for type.
         */
        return type;
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

    public void setType(Type type) {
        /*
        Setter for type.
         */
        this.type = type;
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

    public void getStats(){
        /*
        Displays the name, ability, and price of item. The type and level are included in the name of item.
        This could be modified later.
         */
        System.out.println("------------ " + getName() + " ------------");
        System.out.println("Ability of Item:" + getAbility());
        System.out.println("Price of Item: " + getPrice());
    }

}