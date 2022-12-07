package worldgen;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.objects.Location;
import org.junit.jupiter.api.Test;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager, new Location());
        assert areaManager.getCurrentArea().getName().equals("[GAME]");
        areaManager.getToNextArea("2");
        assert areaManager.getCurrentArea().getName().equals("Beach 1");
    }

}
