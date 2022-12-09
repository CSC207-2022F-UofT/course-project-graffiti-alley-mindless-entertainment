package game_world.factories;

import character.entities.Player;
import entities.item.*;
import inventory.entities.item.Armor;
import inventory.entities.item.Item;
import inventory.entities.item.Potion;
import inventory.entities.item.Sword;

/**
 * A factory class to create an item.
 */
public class ItemFactory {

    /**
     * default constructor for ItemFactory
     */
    public ItemFactory(){
    }

    /**
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
