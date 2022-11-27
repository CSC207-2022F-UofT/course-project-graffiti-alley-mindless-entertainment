import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import game_world.validators.objects.areas.OneWayArea;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    @Test
    void testEventManagerMethods() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager);
        assert areaManager.getCurrentArea().events.get(0).name.equals("test");
        assert areaManager.getCurrentArea().events.get(1).name.equals("test 2");
        areaManager.getToNextArea(((OneWayArea) areaManager.getCurrentArea()).next);
        assert areaManager.getCurrentArea().events.get(0).name.equals("test 3");
    }

}
