package objects.QuestSystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the factory for creating elements in the Quest System (quests, tasks, rewards).
 */
public class QuestDataFactory {

    /**
     * @param jsonArray: contains all the quests objects and information needed for their creation.
     * @return list of quests.
     */
    public List<Quest> createQuests(JSONArray jsonArray) {
        List<Quest> quests = new ArrayList<>();

        for (Object obj: jsonArray) {
            quests.add(this.createQuest((JSONObject) obj));
        }

        return quests;
    }

    /**
     * @param jsonObject: contains information regarding a quest
     * @return quest created.
     */
    public Quest createQuest(JSONObject jsonObject) {
        return new Quest(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("description"),
                //!!! how do I do for the Bystander? Do I have to create new Bystander?
                null,
                createReward((JSONObject) jsonObject.get("reward")),
                getTasks((JSONArray) jsonObject.get("tasks"))
        );
    }

    /**
     * @param jsonArray: contains the information about all the object for
     * @return lists of tasks for the Quest.
     */
    public List<Task> getTasks(JSONArray jsonArray) {
        List<Task> tasks = new ArrayList<>();

        for (Object obj: jsonArray) {
            tasks.add(createTask((JSONObject) obj));
        }

        return tasks;
    }

    /**
     * @param jsonObject: contains information for creation of task.
     * @return a new task
     */
    public Task createTask(JSONObject jsonObject) {
        switch (((String) jsonObject.get("type")).toLowerCase()) {
            case "statistical":
                return createStatisticalTask(jsonObject);
            default:
                return null;
        }
    }

    /**
     * @param jsonObject: contains information for creation of task.
     * @return a new statistical task.
     */
    public StatisticalTask createStatisticalTask(JSONObject jsonObject) {
        return new StatisticalTask(
                (String) jsonObject.get("name"),
                getStatistics((String) jsonObject.get("statistic")),
                (int) jsonObject.get("value"),
                (boolean) jsonObject.get("isEquality")
        );
    }

    /**
     * @param jsonObject: contains information for the reward.
     * @return  a new reward using information in JSON Object.
     */
    public Reward createReward(JSONObject jsonObject) {
        switch (((String) jsonObject.get("type")).toLowerCase()) {
            // case of statistical reward.
            case "statistical":
                return createStatisticalReward(jsonObject);
            //!!! need to add the case of inventory reward here.
            default:
                return null;
        }
    }

    /**
     * @param jsonObject: contains information for the reward.
     * @return a new Statistical Reward using information in JSON Object.
     */
    public StatisticalReward createStatisticalReward(JSONObject jsonObject) {
        return new StatisticalReward(
                getStatistics((String) jsonObject.get("statistic")),
                (int) jsonObject.get("value")
        );
    }

    //!!! not very sure if having this method is bad practice or not.
    /**
     * @param statistic: String containing player's statistic.
     * @return the corresponding player's statistic (type: PlayersStatistics).
     */
    private PlayersStatistics getStatistics(String statistic) {
        switch (statistic.toLowerCase()) {
            case "health":
                return PlayersStatistics.HEALTH;
            case "experience":
                return PlayersStatistics.EXPERIENCE;
            case "level":
                return PlayersStatistics.LEVEL;
            case "money":
                return PlayersStatistics.MONEY;
            default:
                return null;
        }
    }
}
