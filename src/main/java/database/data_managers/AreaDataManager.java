package database.data_managers;

import database.data_factories.AreaDataFactory;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import database.data_objects.AreaData;

public class AreaDataManager extends DatabaseManager {

    public AreaDataFactory dataFactory;

    /**
     * @return ArrayList of AreaData for all AreaData in Zone
     */
    public ArrayList<AreaData> fetchAreaList(String zone) {
        JSONObject textData = (JSONObject) super.fullDatabase.get("texts");
        assert(textData.containsKey(zone));

        JSONObject zoneData = (JSONObject) textData.get(zone);
        ArrayList<AreaData> areas = new ArrayList<>();
        for (Object areaName : zoneData.keySet()) {
            JSONObject areaData = (JSONObject) zoneData.get(areaName);
            areas.add(this.dataFactory.createAreaData(areaData, (String) areaName));
        }
        return areas;
    }

    /**
     * @return AreaData with all data from json converted to variables
     */
    public AreaData fetchArea(String zone, String name) {
        JSONObject textData = (JSONObject) super.fullDatabase.get("texts");
        assert(textData.containsKey(zone));

        JSONObject chapterData = (JSONObject) textData.get(zone);
        assert(chapterData.containsKey(name));

        JSONObject areaData = (JSONObject) chapterData.get(name);
        return this.dataFactory.createAreaData(areaData, name);
    }

    public AreaDataManager() {
        this.dataFactory = new AreaDataFactory();
    }
}
