package game_world.factories;

import database.objects.ItemPickUpEventData;
import game_world.objects.events.*;
import objects.inventory.Inventory;

/**
 * Factory design pattern, used to create an ItemPickUpEvent, and avoid introducing the Inventory dependency.
 */
public class ItemPickUpEventFactory {

    public Inventory inventory;

    public ItemPickUpEventFactory(Inventory inventory){
        this.inventory = inventory;
    }

    public ItemPickUpEvent createItem(ItemPickUpEventData data){
        return new ItemPickUpEvent(data.name, data.item, data.text, inventory);
    }
}
