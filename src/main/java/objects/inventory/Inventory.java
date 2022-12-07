package objects.inventory;

import objects.item.*;
import save.SavableEntity;
import save.SaveEntityId;

import java.util.ArrayList;

/**
 * A class for Inventory. Includes getter and setter for inventory, and functions like viewInventory,
 * addItem, removeItem, and useItem.
 */
public class Inventory implements SavableEntity {
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
            Item item = inventory.get(i);
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
            Item item = inventory.get(i);
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
            Item item = inventory.get(i);
            String ability = item.getAbility();
            removeItem(i);
            return ability;
        }
        return null;
    }

    /**
     * @return a string representation of inventory to be saved
     */
    @Override
    public String toSavableString() {
        if (inventory.size() == 0) {
            return "";
        }
        else {
            return this.viewItemList();
        }
    }
    /**
     * @param str a string representation of inventory
     * map the string representation to the corresponding object
     */
    @Override
    public void fromSavableString(String str) {
        inventory.clear();
        String[] items = str.split(System.lineSeparator());
        for (String item : items) {
            if (item.equals("")){
                return;
            }
            String[] itemDetails = item.split(" ");
            Item i = createItem(itemDetails[2], itemDetails[3]);
            this.addItem(i);
        }
    }

    /**
     * @param itemType type of item
     * @param level level of item
     * @return Item object
     */
    public static Item createItem(String level, String itemType) {
        switch (itemType){
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

