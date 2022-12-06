package save;

import objects.inventory.Inventory;
import objects.item.*;

public class SaveInventory implements SavableEntity {
    Inventory inventory;

    /**
     * Constructor for SaveInventory;
     */
    public SaveInventory(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * @return a string representation of inventory to be saved
     */
    @Override
    public String toSavableString() {
        if (inventory.getInventory().size() == 0) {
            return "";
        }
        else {
            return inventory.viewItemList();
        }
    }

    /**
     * @param str a string representation of inventory
     * map the string representation to the corresponding object
     */
    @Override
    public void fromSavableString(String str) {
       String[] items = str.split(System.lineSeparator());
       for (String item : items) {
           if (item.equals("")){
               return;
           }
           String[] itemDetails = item.split(" ");
           Item i = createItem(itemDetails[2], itemDetails[3]);
           inventory.addItem(i);
        }
    }

    /**
     * @param itemType type of item
     * @param level level of item
     * @return Item object
     */
    public Item createItem(String level, String itemType){
        switch (itemType) {
            case "SWORD":
                return new Sword(Integer.parseInt(level) - 1);
            case "POTION":
                return new Potion(Integer.parseInt(level) - 1);
            case "ARMOR":
                return new Armor(Integer.parseInt(level) - 1);
        }
        return null;
    }

    /**
     * @return the id of inventory in the saved entities list
     */
    @Override
    public SaveEntityId getId() {
        return SaveEntityId.INVENTORY;
    }
}
