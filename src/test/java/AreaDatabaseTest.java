import database.managers.AreaDataManager;
import database.objects.AreaData;
import org.junit.jupiter.api.Test;

public class AreaDatabaseTest {

    @Test
    void testJSONConversionToAreaData() {
        AreaDataManager database = new AreaDataManager();
        AreaData introData = database.fetchArea("Introduction", "[GAME]");
        assert introData.next.equals("The Aqua Nation - Beach 1");
        assert introData.name.equals("[GAME]");
    }

}
