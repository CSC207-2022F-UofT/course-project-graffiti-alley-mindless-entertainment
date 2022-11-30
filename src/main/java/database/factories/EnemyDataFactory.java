package database.factories;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import database.objects.EnemyData;

public class EnemyDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return EnemyData with all instance attributes converted from jsonObject
     */
    public EnemyData createEnemyData(JSONObject jsonObject) {
        ArrayList<String> skills = new ArrayList<>();
        for (Object obj: (JSONArray) jsonObject.get("skills"))
            skills.add((String) obj);

        if (jsonObject.containsKey("gimmick")) {
            return new EnemyData(
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("type"),
                    skills,
                    (String) jsonObject.get("reputation"),
                    (String) jsonObject.get("speed"),
                    (String) jsonObject.get("ai"),
                    (String) jsonObject.get("potion"),
                    (String) jsonObject.get("gimmick")
            );
        }
        else {
            return new EnemyData(
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("type"),
                    skills,
                    (String) jsonObject.get("reputation"),
                    (String) jsonObject.get("speed"),
                    (String) jsonObject.get("ai"),
                    (String) jsonObject.get("potion")
            );
        }
    }

}
