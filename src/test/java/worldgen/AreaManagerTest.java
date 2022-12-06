package worldgen;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import org.junit.jupiter.api.Test;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager, null);
        assert areaManager.getCurrentArea().getName().equals("[GAME]");
        areaManager.getToNextArea("2");
        assert areaManager.getCurrentArea().getName().equals("Beach 1");
    }

}
