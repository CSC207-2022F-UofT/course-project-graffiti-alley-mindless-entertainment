package database.factories;

import database.objects.AreaData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class AreaDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding area
     * @param name name of Area
     * @return AreaData with all instance attributes converted from jsonObject
     */
    public AreaData createAreaData(JSONObject jsonObject, String name) {
        ArrayList<String> texts = new ArrayList<>();
        for (Object obj: (JSONArray) jsonObject.get("texts"))
            texts.add((String) obj);

        ArrayList<String> events = new ArrayList<>();
        for (Object obj: (JSONArray) jsonObject.get("events"))
            events.add((String) obj);

        String type = (String) jsonObject.get("type");
        if (type.equals("One-Way")) {
            return new AreaData(
                    name,
                    type,
                    (String) jsonObject.get("speaker"),
                    texts,
                    (String) jsonObject.get("next"),
                    events
            );
        }
        else if (type.equals("Multi-Directional")) {
            JSONObject jsonOptions = (JSONObject) jsonObject.get("options");
            Set<String> options_keys = jsonOptions.keySet();
            Map<String, String> options = new HashMap<String, String>();
            for (String key : options_keys) {
                options.put(key, jsonOptions.get(key).toString());
            }
            return new AreaData(
                    name,
                    type,
                    (String) jsonObject.get("speaker"),
                    texts,
                    options,
                    events
            );
        }
        return null;
    }

}
