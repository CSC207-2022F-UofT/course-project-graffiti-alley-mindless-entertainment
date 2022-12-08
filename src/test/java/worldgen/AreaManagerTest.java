package worldgen;

import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.*;
import game_world.objects.Location;
import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        Inventory inventory = new Inventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);
        EventFactory eventFactory = new EventFactory(itemPickUpEventFactory);
        EventDatabaseInteractor eventDatabaseInteractor = new EventDatabaseInteractor(eventFactory);
        EventManager eventManager = new EventManager(eventDatabaseInteractor);
        AreaDatabaseInteractor areaDatabaseInteractor = new AreaDatabaseInteractor(eventManager);
        AreaManager areaManager = new AreaManager(eventManager, areaDatabaseInteractor, new Location());
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("[GAME]");
        areaManager.getAreaUseCase().getToNextArea("1");
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("[GAME]");
    }

}
