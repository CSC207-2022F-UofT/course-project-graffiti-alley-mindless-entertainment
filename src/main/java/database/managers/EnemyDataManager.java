package database.managers;

import database.factories.EnemyDataFactory;
import database.objects.EnemyData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EnemyDataManager extends DatabaseManager {

    public EnemyDataFactory dataFactory;

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
    public EnemyData fetchEnemyData(String name) {
        JSONArray enemiesData = (JSONArray) super.fullDatabase.get("enemies");
        JSONObject enemyData = searchJSONArray(enemiesData, "name", name);
        assert enemyData != null;
        return this.dataFactory.createEnemyData(enemyData);
    }

    public EnemyDataManager() {
        this.dataFactory = new EnemyDataFactory();
    }
}
