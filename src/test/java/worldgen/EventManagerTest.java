package worldgen;

import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.objects.Location;
import game_world.objects.events.ItemPickUpEvent;
import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    @Test
    void testEventManagerMethods() {
        Inventory inventory = new Inventory();
        ItemPickUpEventFactory i = new ItemPickUpEventFactory(inventory);
        EventManager eventManager = new EventManager(i);
        AreaManager areaManager = new AreaManager(eventManager, new Location());
    }

}
