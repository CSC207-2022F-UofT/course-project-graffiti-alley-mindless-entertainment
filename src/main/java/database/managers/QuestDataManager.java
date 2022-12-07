package database.managers;

import database.DatabaseHelper;
import database.factories.QuestDataFactory;
import database.objects.QuestData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QuestDataManager extends DatabaseManager {

    private final QuestDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @return QuestData with all data from json converted to String/long variables
     */
    public QuestData fetchQuestData(String name) {
        JSONArray questsData = (JSONArray) super.fullDatabase.get("quests");
        JSONObject questData = databaseHelper.searchJSONArray(questsData, "name", name);
        assert questData != null;
        return this.dataFactory.createQuestData(questData);
    }

    public QuestDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/QuestDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new QuestDataFactory();
    }
}