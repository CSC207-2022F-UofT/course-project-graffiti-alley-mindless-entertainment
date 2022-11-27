package worldgen;

import database.managers.AreaDataManager;
import database.objects.AreaData;
import org.junit.jupiter.api.Test;

public class AreaDatabaseTest {

    @Test
    void testJSONConversionToAreaData() {
        AreaDataManager database = new AreaDataManager();
        AreaData introData = database.fetchArea("1");
        assert introData.next_ids.get(0).equals("2");
        assert introData.name.equals("[GAME]");
    }

}
