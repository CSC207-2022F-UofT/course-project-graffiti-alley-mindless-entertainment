package database.managers;

import database.factories.AreaDataFactory;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import database.objects.AreaData;

public class AreaDataManager extends DatabaseManager {

    public AreaDataFactory dataFactory;

    /**
     * @return AreaData with all data from json converted to variables
     */
    public AreaData fetchArea(String id) {
        JSONObject textData = (JSONObject) super.fullDatabase.get("texts");
        assert(textData.containsKey(id));

        JSONObject areaData = (JSONObject) textData.get(id);
        return this.dataFactory.createAreaData(areaData, id);
    }

    public AreaDataManager() {
        this.dataFactory = new AreaDataFactory();
    }
}
