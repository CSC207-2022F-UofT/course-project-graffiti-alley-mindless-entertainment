package game_world.factories;

import database.managers.QuestDataManager;
import character.entities.Bystander;
import database.entities.QuestData;
import quests.entities.PlayersStatistics;
import quests.entities.Quest;
import quests.use_cases.Reward;
import quests.use_cases.StatisticalReward;
import quests.use_cases.StatisticalTask;
import quests.use_cases.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the methods to create a Quest using the information given by a QuestData object.
 */
public class QuestFactory {
    /**
     * Attribute.
     */
    private final QuestDataManager database = new QuestDataManager();

    /**
     * @param name of the quest.
     * @return quest in the database, corresponding ot hte name entered.
     */
    public Quest createQuest(String name) {
        QuestData data = this.database.fetchQuestData(name);
        return createQuest(data);
    }

    /**
     * @param data: contains all the information needed to create the quest.
     * @return the created quest using the information from data.
     */
    private Quest createQuest(QuestData data) {
        Bystander bystander = createBystander(data.bystander);      //!!! might be changed later on.
        Reward reward = createReward(data.rewardType, data.rewardStatistic, (int) data.rewardValue);
        List<Task> tasks = createTasks(data.tasksTypes, data.tasksStatistics, data.tasksValues);

        return new Quest(data.name, data.description, bystander, reward, tasks);
    }

    /**
     * @param name: name of the Bystander involved in the quest.
     * @return the Bystander object.
     */
    private Bystander createBystander(String name) {
        return new Bystander(name, false);          //!!! might need to be changed later
    }

    /**
     * @param type of the reward.
     * @param statistic: parameter for specific type of reward.
     * @param value: parameter for specific type of reward.
     * @return the created reward.
     */
    private Reward createReward(String type, String statistic, int value) {
        if ("statistical".equals(type)) {
            return createStatisticalReward(statistic, value);
        }
        return null;
    }

    /**
     * @param statistic: that is impacted by the reward.
     * @param value: value by which the statistic is impacted.
     * @return the created statistical reward.
     */
    private StatisticalReward createStatisticalReward(String statistic, int value) {
        return new StatisticalReward(PlayersStatistics.valueOf(statistic.toUpperCase()), value);
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
    private Task createTask(String type, String statistic, long value) {
        if ("statistical".equals(type)) {
            return createStatisticalTask(statistic, (int) value);
        }
        return null;
    }

    /**
     * @param statistic from player that will be checked.
     * @param value that needs to be obtained for given statistic.
     * @return the created statistical Task.
     */
    private StatisticalTask createStatisticalTask(String statistic, long value) {
        return new StatisticalTask(PlayersStatistics.valueOf(statistic.toUpperCase()), (int) value);
    }
}
