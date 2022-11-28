package objects.QuestSystem;

import org.json.simple.JSONObject;

import java.util.List;

/**
 * This class contains the factory for creating elements in the Quest System (quests, tasks, rewards).
 */
public class QuestDataFactory {

    /**
     *
     * @param jsonObject JSONObject with all information regarding event
     * @return SkillData with all instance attributes converted from jsonObject
     */
    public Quest createQuest(JSONObject jsonObject) {
        return new Quest(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("description"),
                //!!! how do I do for the Bystander? Do I have to create new Bystander?
                null,
                createReward((JSONObject) jsonObject.get("reward")),
                getTasks((JSONObject) jsonObject.get("tasks"))
        );
    }

    /**
     * Returns the lists of tasks for the Quest.
     */
    //!!!
    public List<Task> getTasks(JSONObject jsonObject) {
        return null;
    }

    /**
     *
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
     * Returns a new statistical task.
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
     * Returns a new reward using information in JSON Object.
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
     * Returns a new Statistical Reward using information in JSON Object.
     */
    public StatisticalReward createStatisticalReward(JSONObject jsonObject) {
        return new StatisticalReward(
                getStatistics((String) jsonObject.get("statistic")),
                (int) jsonObject.get("value")
        );
    }

    //!!! not very sure if having this method is bad practice or not.
    /**
     * Returns the corresponding player's statistic.
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
