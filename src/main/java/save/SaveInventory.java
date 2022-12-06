package save;

import objects.character.Player;
import objects.inventory.Inventory;
import objects.item.*;

public class SaveInventory implements SavableEntity {
    final Inventory inventory = Player.getInventory();
    @Override
    public String toSavableString() {
        if (inventory.getInventory().size() == 0) {
            return null;
        }
        else {
            return inventory.viewItemList();
        }
    }

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
                return new Sword(Integer.parseInt(level));
            case "POTION":
                return new Potion(Integer.parseInt(level));
            case "ARMOR":
                return new Armor(Integer.parseInt(level));
        }
        return null;
    }

    /**
     * @return the id of inventory in the saved entities list
     */
    @Override
    public SaveEntityId getId() {
        return SaveEntityId.INVENTORY_ID;
    }
}