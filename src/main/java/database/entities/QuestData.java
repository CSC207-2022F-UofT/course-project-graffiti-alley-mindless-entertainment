package database.entities;

import java.util.ArrayList;

/**
 * This class contains all information needed for the creation of a quest.
 */
public class QuestData {

    public final String name;
    public final String description;
    public final String bystander;

    public final String rewardType;
    public final String rewardStatistic;
    public final long rewardValue;

    public final ArrayList<String> tasksTypes;
    public final ArrayList<String> tasksStatistics;
    public final ArrayList<Long> tasksValues;

    /**
     * Constructor.
     */
    public QuestData(String name, String description, String bystander, String rewardType, String rewardStatistic,
                     long rewardValue, ArrayList<String> tasksTypes, ArrayList<String> tasksStatistics,
                     ArrayList<Long> tasksValues) {
        this.name = name;
        this.description = description;
        this.bystander = bystander;
        this.rewardType = rewardType;
        this.rewardStatistic = rewardStatistic;
        this.rewardValue = rewardValue;
        this.tasksTypes = tasksTypes;
        this.tasksStatistics = tasksStatistics;
        this.tasksValues = tasksValues;
    }
}
