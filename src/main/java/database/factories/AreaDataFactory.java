package database.factories;

import database.entities.AreaData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class AreaDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding area
     * @param id       id of Area
     * @return AreaData with all instance attributes converted from jsonObject
     */
    public AreaData createAreaData(JSONObject jsonObject, String id) {
        ArrayList<String> texts = new ArrayList<>();
        for (Object obj : (JSONArray) jsonObject.get("texts"))
            texts.add((String) obj);

        ArrayList<String> events = new ArrayList<>();
        for (Object obj : (JSONArray) jsonObject.get("events"))
            events.add((String) obj);

        JSONObject jsonOptions = (JSONObject) jsonObject.get("options");
        ArrayList<String> next_ids = new ArrayList<>(jsonOptions.keySet());
        ArrayList<String> next_options = new ArrayList<>(jsonOptions.values());

        return new AreaData(
                id,
                (String) jsonObject.get("name"),
                (String) jsonObject.get("speaker"),
                (String) jsonObject.get("zone"),
                texts,
                next_ids,
                next_options,
                events
        );
    }

}
