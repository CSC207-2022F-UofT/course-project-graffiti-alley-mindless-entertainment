package database.data_factories;

import database.data_objects.AreaData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class AreaDataFactory {

    public AreaData createAreaData(JSONObject jsonObject, String name) {
        ArrayList<String> texts = new ArrayList<>();
        for (Object obj: (JSONArray) jsonObject.get("texts"))
            texts.add((String) obj);

        String type = (String) jsonObject.get("type");
        if (type.equals("One-Way")) {
            return new AreaData(
                    name,
                    type,
                    (String) jsonObject.get("speaker"),
                    texts,
                    (String) jsonObject.get("next")
            );
        }
        else if (type.equals("Multi-Directional")) {
            Set<String> options_keys = jsonObject.keySet();
            Map<String, String> options = new HashMap<String, String>();
            for (String key : options_keys) {
                options.put(key, (String) jsonObject.get(key));
            }
            return new AreaData(
                    name,
                    type,
                    (String) jsonObject.get("speaker"),
                    texts,
                    options
            );
        }
        return null;
    }

}
