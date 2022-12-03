package database.managers;

import database.DatabaseHelper;
import database.factories.SkillDataFactory;
import database.objects.SkillData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SkillDataManager extends DatabaseManager {

    private final SkillDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @return SkillData with all data from json converted to String/long variables
     */
    public SkillData fetchSkillData(String name) {
        JSONArray skillsData = (JSONArray) super.fullDatabase.get("skills");
        JSONObject skillData = databaseHelper.searchJSONArray(skillsData, "name", name);
        assert skillData != null;
        return this.dataFactory.createSkillData(skillData);
    }

    public SkillDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/SkillDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new SkillDataFactory();
    }
}
