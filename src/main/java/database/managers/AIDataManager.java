package database.managers;

import database.factories.AIDataFactory;
import database.objects.AIData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AIDataManager extends DatabaseManager {

    public AIDataFactory dataFactory;

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
     * @return AIData with all data from json converted to variables
     */
    public AIData fetchAIData(String name) {
        JSONArray aisData = (JSONArray) super.fullDatabase.get("ai_data");
        JSONObject aiData = searchJSONArray(aisData, "name", name);
        assert aiData != null;
        return this.dataFactory.createAIData(aiData);
    }

    public AIDataManager() {
        this.dataFactory = new AIDataFactory();
    }
}
