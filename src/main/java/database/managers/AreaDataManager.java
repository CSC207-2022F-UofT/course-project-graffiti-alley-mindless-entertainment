package database.managers;

import database.factories.AreaDataFactory;
import org.json.simple.JSONObject;

import database.entities.AreaData;

public class AreaDataManager extends DatabaseManager {

    private final AreaDataFactory dataFactory;

    /**
     * @param id of Area
     * @return AreaData with all data from json converted to String/long variables
     */
    public AreaData fetchArea(String id) {
        JSONObject textData = (JSONObject) super.fullDatabase.get("texts");
        assert(textData.containsKey(id));

        JSONObject areaData = (JSONObject) textData.get(id);
        return this.dataFactory.createAreaData(areaData, id);
    }

    public AreaDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/AreaDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.dataFactory = new AreaDataFactory();
    }
}
