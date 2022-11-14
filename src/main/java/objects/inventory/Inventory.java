package objects.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    /** A class for Inventory. Includes getter and setter for inventory, and functions like viewInventory,
     * addItem, removeItem, and useItem.
     * Attributes:
     * inventory: the list of items the user have
     */

    private List<Item> inventory;

    public Inventory() {
        /*
        Initialize new inventory.
         */
        this.inventory = new ArrayList<>();
    }

    public List<Item> getInventory() {
        /*
        Getter for inventory.
         */
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        /*
        Setter for inventory.
         */
        this.inventory = inventory;
    }

    public void viewInventory(){
        /*
        Displays(print) all items with stats in the inventory.
         */
        for(int i = 0; i < inventory.size(); i++){
            inventory.get(i).getStats();
        }
    }

    public void addItem(Item item){
        /*
        Add an item to inventory if the inventory is not full. Call viewInventory() if the inventory is full,
        so the player can remove an item.
         */
        if (inventory.size() > 5){
            System.out.println("Your inventory is full. View inventory and remove an item");
            viewInventory();
        }
        else{
            inventory.add(item);
        }
    }

    public boolean checkItem(String itemName){
        /*
        Return whether the item is in the inventory.
         */

        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }

    public void removeItem(String itemName){
        /*
        Remove an item if the item exists in the inventory.
         */
        if (checkItem(itemName)) {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getName().equals(itemName)) {
                    inventory.remove(i);
                    break;
                }
            }
        }
        else{
            System.out.println("The item does not exist in your inventory.");
        }
    }

    public String useITem(String itemName) {
        /*
        Return ability of item if the item is in inventory, return null otherwise.
         */
        if (checkItem(itemName)) {
            for (Item item : inventory) {
                if (item.getName().equals(itemName)) {
                    return item.getAbility();
                }
            }
        }
        else {
            System.out.println("The item does not exist in your inventory");
        }
        return null;

    }
}
