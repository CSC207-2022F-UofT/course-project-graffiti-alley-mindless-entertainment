import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.validators.objects.areas.OneWayArea;
import org.junit.jupiter.api.Test;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager);
        assert areaManager.getCurrentArea().getName().equals("[GAME]");
        areaManager.getToNextArea(((OneWayArea) areaManager.getCurrentArea()).next);
        assert areaManager.getCurrentArea().getName().equals("Beach 1");
    }

}
