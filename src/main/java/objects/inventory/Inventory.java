package objects.inventory;

<<<<<<< HEAD
import objects.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
=======
import java.util.ArrayList;
>>>>>>> main
import java.util.List;

public class Inventory {
    /** A class for Inventory. Includes getter and setter for inventory, and functions like viewInventory,
     * addItem, removeItem, and useItem.
<<<<<<< HEAD
     * Attribute:
     * inventory: list of items the user have
     */

    private List<Item> inventory;
    private final int maxSize = 5;
=======
     * Attributes:
     * inventory: the list of items the user have
     */

    private List<Item> inventory;
>>>>>>> main

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

<<<<<<< HEAD
    public HashMap<String, String> viewInventory(){
        /*
        Return all items' name and their ability pair {name, ability} in the inventory as a map.
         */
        HashMap<String, String> inventoryMap = new HashMap<>();
        for(int i = 0; i < inventory.size(); i++){
            String[] stats = inventory.get(i).getStats();
            inventoryMap.put(stats[0], stats[1]);
        }
        return inventoryMap;
    }

    public boolean addItem(Item item){
        /*
        Add an item to inventory if the inventory is not full. Call viewInventory() if the inventory is full,
        so the player can remove an item. Return false if inventory is full.
         */
        if (inventory.size() > maxSize){
            viewInventory();
            return false;
        }
        else{
            inventory.add(item);
            return true;
=======
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
>>>>>>> main
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
<<<<<<< HEAD
        return false;
    }

    public boolean removeItem(String itemName){
        /*
        Remove an item and return true if the item exists in the inventory. Return false otherwise.
=======

        return false;
    }

    public void removeItem(String itemName){
        /*
        Remove an item if the item exists in the inventory.
>>>>>>> main
         */
        if (checkItem(itemName)) {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getName().equals(itemName)) {
                    inventory.remove(i);
<<<<<<< HEAD
                    return true;
                }
            }
        }
        return false;
    }

    public String useItem(String itemName) {
=======
                    break;
                }
            }
        }
        else{
            System.out.println("The item does not exist in your inventory.");
        }
    }

    public String useITem(String itemName) {
>>>>>>> main
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
<<<<<<< HEAD
        return null;
    }
}
=======
        else {
            System.out.println("The item does not exist in your inventory");
        }
        return null;
    }

}
>>>>>>> main
