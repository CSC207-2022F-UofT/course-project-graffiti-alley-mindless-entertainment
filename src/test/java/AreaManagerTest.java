import database.managers.AreaDataManager;
import database.objects.AreaData;
import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.objects.areas.Area;
import game_world.objects.areas.MultiDirectionalArea;
import game_world.objects.areas.OneWayArea;
import org.junit.jupiter.api.Test;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager);
        assert areaManager.getCurrentArea().name.equals("[GAME]");
        areaManager.getToNextArea(((OneWayArea) areaManager.getCurrentArea()).next);
        assert areaManager.getCurrentArea().name.equals("Beach 1");
    }

}
