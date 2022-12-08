package worldgen;

import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.AreaManager;
import game_world.managers.AreaUseCase;
import game_world.managers.EventManager;
import game_world.objects.Area;
import game_world.objects.Location;
import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    @Test
    void testEventManagerMethods() {
        Inventory inventory = new Inventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);
        EventManager eventManager = new EventManager(itemPickUpEventFactory);
        AreaManager areaManager = new AreaManager(eventManager, new Location());
    }

}
