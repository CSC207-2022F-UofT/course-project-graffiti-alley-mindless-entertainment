package game_world;

import database.managers.EventDataManager;
import database.entities.ArbitraryEventData;
import org.junit.jupiter.api.Test;

public class EventDatabaseTest {

    @Test
    void testJSONConversionToEventData() {
        EventDataManager database = new EventDataManager();
        ArbitraryEventData test1 = database.fetchArbitraryEvent("name", "test");
        assert test1.name.equals("test");
        assert test1.type.equals("Arbitrary");
    }

}
