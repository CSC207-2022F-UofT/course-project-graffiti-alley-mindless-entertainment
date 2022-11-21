package database.managers;

import database.factories.SkillDataFactory;
import database.objects.SkillData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SkillDataManager extends DatabaseManager {

    public SkillDataFactory dataFactory;

    /**
     * Helper function to search JSON arrays
     * @param jsonArray initial jsonArray to iterate through
     * @return null if key-value pair does not exist in jsonArray, otherwise returns jsonObject of key-value pair
     */
    private JSONObject searchJSONArray(JSONArray jsonArray, String key, Object value) {
        for (Object obj: jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(key).equals(value)) {
                return jsonObject;
            }
        }
        return null;
    }

    /**
     * @return SkillData with all data from json converted to variables
     */
    public SkillData fetchSkillData(String name) {
        JSONArray skillsData = (JSONArray) super.fullDatabase.get("skills");
        JSONObject skillData = searchJSONArray(skillsData, "name", name);
        assert skillData != null;
        return this.dataFactory.createSkillData(skillData);
    }

    public SkillDataManager() {
        this.dataFactory = new SkillDataFactory();
    }
}
