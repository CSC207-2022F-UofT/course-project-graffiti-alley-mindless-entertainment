package game_world.factories;

import database.entities.ItemPickUpEventData;
import game_world.entities.events.*;
import game_world.events.ItemPickUpEvent;
import inventory.entities.Inventory;

/**
 * Factory design pattern, used to create an ItemPickUpEvent, and avoid introducing the Inventory dependency.
 */
public class ItemPickUpEventFactory {

    public final Inventory inventory;

    public ItemPickUpEventFactory(Inventory inventory){
        this.inventory = inventory;
    }

    public ItemPickUpEvent createItem(ItemPickUpEventData data){
        return new ItemPickUpEvent(data.name, data.item, data.text, inventory);
    }
}
