package database.managers;

import database.factories.SkillDataFactory;
import database.objects.SkillData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SkillDataManager extends DatabaseManager {

    public SkillDataFactory dataFactory;

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
