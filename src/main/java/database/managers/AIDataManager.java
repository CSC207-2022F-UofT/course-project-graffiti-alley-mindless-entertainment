package database.managers;

import database.DatabaseHelper;
import database.factories.AIDataFactory;
import database.objects.AIData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AIDataManager extends DatabaseManager {

    private final AIDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @param name of AIData
     * @return AIData with all data from json converted to String/long variables
     */
    public AIData fetchAIData(String name) {
        JSONArray aisData = (JSONArray) super.fullDatabase.get("ai_data");
        JSONObject aiData = databaseHelper.searchJSONArray(aisData, "name", name);
        assert aiData != null;
        return this.dataFactory.createAIData(aiData);
    }

    public AIDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/AIDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new AIDataFactory();
    }
}
