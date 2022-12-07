package objects.inventory;

import objects.item.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for Inventory. Includes getter and setter for inventory, and functions like viewInventory,
 * addItem, removeItem, and useItem.
 */
public class Inventory {
    /**
     * Attribute:
     * inventory: list of items the user have
     */

    private ArrayList<Item> inventory;

    /**
     * Initialize new inventory.
     */
    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Getter for inventory.
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * Setter for inventory.
     */
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    /**
     * @Return all items' name and their ability in the inventory as a string.
     */
    public String viewInventory(){
        StringBuilder itemInfo = new StringBuilder();

        for(int i = 0; i < inventory.size(); i++){
            Item item = (Item) inventory.get(i);
            String[] stats = item.getStats();
            itemInfo.append(i).append(". ").append(stats[0]).append(": ").append(stats[1]).append("\n");

        }
        return itemInfo.toString();
    }

    /**
     * @Return list of item's name
     */
    public String viewItemList(){
        StringBuilder items = new StringBuilder();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = (Item) inventory.get(i);
            items.append(i).append(". ").append(item.getName()).append("\n");
        }
        return items.toString();
    }

    /**
     * @param item to be added to inventory
     * @return whether item is added.
     */
    public boolean addItem(Item item){
        int maxSize = 5;
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
        if (inventory.size() > i){
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
        if (inventory.size() > i){
            Item item = (Item) inventory.get(i);
            String ability = item.getAbility();
            removeItem(i);
            return ability;
        }
        return null;
    }

    /**
     * Uses the item in the inventory with the given name if found
     * @param name of the item wanted
     * @return true if the item is found, false if the item is not found
     */
    public String useItem(String name) {
        int index = findItem(name);
        if (index >= 0) {
            return useItem(index);
        }
        return null;
    }

    /**
     * Finds the index of the item given a name
     * @param name of the item wanted
     * @return -1 if not found, index of the item if found.
     */
    public int findItem(String name) {
        int index = -1;
        for (int i = 0; i < inventory.size(); i++) {
            index++;
            if (inventory.get(i).getName().equals(name)) {
                return index;
            }
        }
        return index;
    }

    /**
     * Returns the inventory as a list of the names of the items inside
     * @return the inventory as a list of strings
     */
    public List<String> toStringList() {
        List<String> stringInv = new ArrayList<>();
        for (Item item : inventory) {
            stringInv.add(item.getName());
        }
        return stringInv;
    }
}
