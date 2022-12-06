package game_world.factories;

import objects.character.Bystander;
import quests.*;
import database.objects.QuestData;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the methods to create a Quest using the information given by a QuestData object.
 */
public class QuestFactory {

    /**
     * @param data: contains all the information needed to create the quest.
     * @return the created quest using the information from data.
     */
    public Quest createQuest(QuestData data) {
        // !!! how to fetch the corresponding Bystander? – ask mahir.
        // !!! use another thing made by Marja-leena or something to getBystander –might be more sensible name)
        Bystander bystander = createBystander(data.bystander);
        Reward reward = createReward(data.rewardType, data.rewardStatistic, (int) data.rewardValue);
        List<Task> tasks = createTasks(data.tasksTypes, data.tasksStatistics, data.tasksValues);

        return new Quest(data.name, data.description, bystander, reward, tasks);
    }

    /**
     * @param type of the reward.
     * @param statistic: parameter for specific type of reward.
     * @param value: parameter for specific type of reward.
     * @return the created reward.
     */
    private Reward createReward(String type, String statistic, int value) {
        switch (type) {
            case "statistical":
                return createStatisticalReward(statistic, value);
            default:
                return null;
        }
    }

    /**
     * @param statistic: that is impacted by the reward.
     * @param value: value by which the statistic is impacted.
     * @return the created statistical reward.
     */
    private StatisticalReward createStatisticalReward(String statistic, int value) {
        return new StatisticalReward(PlayersStatistics.valueOf(statistic), value);
    }

    /**
     * @param tasksTypes: type of the tasks.
     * @param tasksStatistics: parameter for a specific type of tasks.
     * @param tasksValues: parameter for a specific type of tasks.
     * @return a list of all the created tasks.
     */
    private List<Task> createTasks(ArrayList<String> tasksTypes, ArrayList<String> tasksStatistics,
                                   ArrayList<Long> tasksValues) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < tasksTypes.size(); i++) {
            tasks.add(createTask(tasksTypes.get(i), tasksStatistics.get(i), tasksValues.get(i)));
        }

        return tasks;
    }

    /**
     * @param type of task
     * @param statistic: parameter for specific type of task.
     * @param value: parameter for specific type of task.
     * @return the created tasks using information given.
     */
    private Task createTask(String type, String statistic, int value) {
        switch (type) {
            case "statistical":
                return createStatisticalTask(statistic, value);
            default:
                return null;
        }
    }

    /**
     * @param statistic from player that will be checked.
     * @param value that needs to be obtained for given statistic.
     * @return the created statistical Task.
     */
    private StatisticalTask createStatisticalTask(String statistic, long value) {
        return new StatisticalTask(PlayersStatistics.valueOf(statistic), (int) value);
    }
}
