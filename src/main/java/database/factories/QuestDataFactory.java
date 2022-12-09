package database.factories;

import database.entities.QuestData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * This class contains the methods needed to create a QuestData object, suing the factory design pattern.
 */
public class QuestDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return QuestData with all instance attributes converted from jsonObject
     */
    public QuestData createQuestData(JSONObject jsonObject) {
        ArrayList<String> taskTypes = new ArrayList<>();
        ArrayList<String> taskStatistics = new ArrayList<>();
        ArrayList<Long> taskValues = new ArrayList<>();
        for (Object obj : (JSONArray) jsonObject.get("tasks")) {
            JSONObject taskData = (JSONObject) obj;
            taskTypes.add((String) taskData.get("type"));
            taskStatistics.add((String) taskData.get("statistic"));
            taskValues.add((long) taskData.get("value"));
        }

        JSONObject rewardData = (JSONObject) jsonObject.get("reward");

        return new QuestData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("description"),
                (String) jsonObject.get("bystander"),
                (String) rewardData.get("type"),
                (String) rewardData.get("statistic"),
                (long) rewardData.get("value"),
                taskTypes, taskStatistics, taskValues
        );
    }
}