package database.factories;

import database.objects.SkillData;
import org.json.simple.JSONObject;

public class SkillDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return SkillData with all instance attributes converted from jsonObject
     */
    public SkillData createSkillData(JSONObject jsonObject) {
        return new SkillData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (String) jsonObject.get("lag"),
                (String) jsonObject.get("damage")
        );
    }

}
