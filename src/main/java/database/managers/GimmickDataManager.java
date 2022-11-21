package database.managers;

import database.factories.GimmickDataFactory;
import database.objects.GimmickData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GimmickDataManager extends DatabaseManager {

    public GimmickDataFactory dataFactory;

    /**
     * Helper function to search JSON arrays
     * @param jsonArray initial jsonArray to iterate through
     * @return null if key-value pair does not exist in jsonArray, otherwise returns jsonObject of key-value pair
     */
    private JSONObject searchJSONArray(JSONArray jsonArray, String key, Object value) {
        for (Object obj: jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(key).equals(value)) {
                return jsonObject;
            }
        }
        return null;
    }

    /**
     * @return GimmickData with all data from json converted to variables
     */
    public GimmickData fetchGimmickData(String name) {
        JSONArray GimmicksData = (JSONArray) super.fullDatabase.get("gimmicks");
        JSONObject GimmickData = searchJSONArray(GimmicksData, "name", name);
        assert GimmickData != null;
        return this.dataFactory.createGimmickData(GimmickData);
    }

    public GimmickDataManager() {
        this.dataFactory = new GimmickDataFactory();
    }
}
