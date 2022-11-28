package database.managers;

import database.DatabaseHelper;
import database.factories.GimmickDataFactory;
import database.objects.GimmickData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GimmickDataManager extends DatabaseManager {

    private final GimmickDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @return GimmickData with all data from json converted to variables
     */
    public GimmickData fetchGimmickData(String name) {
        JSONArray GimmicksData = (JSONArray) super.fullDatabase.get("gimmicks");
        JSONObject GimmickData = databaseHelper.searchJSONArray(GimmicksData, "name", name);
        assert GimmickData != null;
        return this.dataFactory.createGimmickData(GimmickData);
    }

    public GimmickDataManager() {
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new GimmickDataFactory();
    }
}
