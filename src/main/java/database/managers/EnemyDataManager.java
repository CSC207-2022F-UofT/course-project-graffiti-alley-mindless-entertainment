package database.managers;

import database.DatabaseHelper;
import database.factories.EnemyDataFactory;
import database.objects.EnemyData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EnemyDataManager extends DatabaseManager {

    private final EnemyDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @return EnemyData with all data from json converted to String/long variables
     */
    public EnemyData fetchEnemyData(String name) {
        JSONArray enemiesData = (JSONArray) super.fullDatabase.get("enemies");
        JSONObject enemyData = databaseHelper.searchJSONArray(enemiesData, "name", name);
        assert enemyData != null;
        return this.dataFactory.createEnemyData(enemyData);
    }

    public EnemyDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/EnemyDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new EnemyDataFactory();
    }
}
