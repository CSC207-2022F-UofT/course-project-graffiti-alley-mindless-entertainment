package database.managers;

import database.factories.EnemyDataFactory;
import database.objects.EnemyData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EnemyDataManager extends DatabaseManager {

    public EnemyDataFactory dataFactory;

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
