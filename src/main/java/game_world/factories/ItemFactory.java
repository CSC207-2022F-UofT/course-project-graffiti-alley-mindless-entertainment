package game_world.factories;

import objects.character.Player;
import objects.item.*;

/**
 * A factory class to create an item.
 */
public class ItemFactory {

    /**
     *
     * @param itemType type of item
     * @return Item object based on the itemType
     */
    public Item createItem(String itemType){
        switch (itemType) {
            case "Sword":
                return new Sword(Player.getLevel());
            case "Potion":
                return new Potion(Player.getLevel());
            case "Armor":
                return new Armor(Player.getLevel());
        }
        return null;
    }
}
