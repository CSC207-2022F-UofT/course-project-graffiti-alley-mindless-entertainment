package database.managers;

import database.factories.AIDataFactory;
import database.objects.AIData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AIDataManager extends DatabaseManager {

    public AIDataFactory dataFactory;

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
