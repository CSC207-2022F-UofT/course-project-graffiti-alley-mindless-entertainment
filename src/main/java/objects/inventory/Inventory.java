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
     * Return all items' name and their ability in the inventory as a string.
     */
    public String viewInventory(){
        String itemInfo = "";
        for(int i = 0; i < inventory.size(); i++){
            Item item = (Item) inventory.get(i);
            String[] stats = item.getStats();
            itemInfo = itemInfo + stats[0] + ": " + stats[1] + "\n";

        }
        return itemInfo;
    }

    /**
     * Add an item to inventory if the inventory is not full. Call viewInventory() if the inventory is full
     * so the player can remove an item. Return false if inventory is full.
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
     * Return whether the item is in the inventory.
     */

    public boolean checkItem(String itemName){
        for (int i = 0; i < inventory.size(); i++) {
            Item item = (Item) inventory.get(i);
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove an item and return true if the item exists in the inventory. Return false otherwise.
     */
    public boolean removeItem(String itemName){
        if (checkItem(itemName)) {
            for (int i = 0; i < inventory.size(); i++) {
                Item item = (Item) inventory.get(i);
                if (item.getName().equals(itemName)) {
                    inventory.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return ability of item if the item is in inventory, return null otherwise.
     */
    public String useItem(String itemName) {
        if (checkItem(itemName)) {
            for (int i = 0; i < inventory.size(); i++) {
                Item item = (Item) inventory.get(i);
                if (item.getName().equals(itemName)) {
                    String ability = item.getAbility();
                    inventory.remove(itemName);
                    return ability;
                }
            }
        }
        return null;
    }
}
