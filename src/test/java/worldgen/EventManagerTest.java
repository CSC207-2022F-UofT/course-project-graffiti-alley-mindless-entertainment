package worldgen;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.objects.Location;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    @Test
    void testEventManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager, new Location());
    }

}
