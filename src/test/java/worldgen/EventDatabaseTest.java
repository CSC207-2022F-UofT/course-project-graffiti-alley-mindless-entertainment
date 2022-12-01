package worldgen;

import database.managers.AreaDataManager;
import database.managers.EventDataManager;
import database.objects.AreaData;
import database.objects.EventData;
import org.junit.jupiter.api.Test;

public class EventDatabaseTest {

    @Test
    void testJSONConversionToEventData() {
        EventDataManager database = new EventDataManager();
        EventData test1 = database.fetchEvent("name", "test");
        assert test1.name.equals("test");
        assert test1.type.equals("Arbitrary");
    }

}
