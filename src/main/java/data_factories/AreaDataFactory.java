package data_factories;

import data_objects.AreaData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AreaDataFactory {

    public AreaData createAreaData(JSONObject jsonObject, String name) {
        ArrayList<String> texts = new ArrayList<>();
        for (Object obj: (JSONArray) jsonObject.get("texts"))
            texts.add((String) obj);

        if (jsonObject.containsKey("next")) {
            return new AreaData(
                    name,
                    (String) jsonObject.get("speaker"),
                    texts,
                    (String) jsonObject.get("next")
            );
        }
        else if (jsonObject.containsKey("options")) {
            Set<String> options_keys = jsonObject.keySet();
            HashMap<String, String> options = new HashMap<>();
            for (String key : options_keys) {
                options.put(key, (String) jsonObject.get(key));
            }
            return new AreaData(
                    name,
                    (String) jsonObject.get("speaker"),
                    texts,
                    options
            );
        }
        return null;
    }

}
