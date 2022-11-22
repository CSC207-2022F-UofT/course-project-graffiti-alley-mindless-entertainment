package objects.inventory;

import objects.item.*;
import java.util.ArrayList;

/**
 * A class for Inventory. Includes getter and setter for inventory, and functions like viewInventory,
 * addItem, removeItem, and useItem.
 */
public class Inventory {
    /**
     * Attribute:
     * inventory: list of items the user have
     */

    private ArrayList inventory;
    private final int maxSize = 5;

    /**
     * Initialize new inventory.
     */
    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Getter for inventory.
     */
    public ArrayList getInventory() {
        return inventory;
    }

    /**
     * Setter for inventory.
     */
    public void setInventory(ArrayList inventory) {
        this.inventory = inventory;
    }

    /**
     * @Return all items' name and their ability in the inventory as a string.
     */
    public String viewInventory(){
        String itemInfo = "";

        for(int i = 0; i < inventory.size(); i++){
            Item item = (Item) inventory.get(i);
            String[] stats = item.getStats();
            itemInfo = i + ". " + itemInfo + stats[0] + ": " + stats[1] + "\n";

        }
        return itemInfo;
    }

    /**
     * @param item to be added to inventory
     * @return whether item is added.
     */
    public boolean addItem(Item item){
        if (inventory.size() >= maxSize){
            return false;
        }
        else{
            inventory.add(item);
            return true;
        }
    }

    /**
     * Remove i-th item in inventory
     * @param i: i-th item in the inventory that is to be removed.
     * @return whether item is removed.
     */
    public boolean removeItem(int i){
            if (inventory.size() >= i){
                inventory.remove(i);
                return true;
        }
        return false;
    }

    /**
     * @param i-th item in the inventory to be used.
     * @return i-th item's ability in inventory, return null otherwise.
     */
    public String useItem(int i) {
        if (inventory.size() >= i){
            Item item = (Item) inventory.get(i);
            String ability = item.getAbility();
            removeItem(i);
            return ability;
        }
        return null;
    }
}
