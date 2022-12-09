package database.objects;

import java.util.ArrayList;

/**
 * This class contains all information needed for the creation of a quest.
 */
public class QuestData {

    public String name;
    public String description;
    public String bystander;

    public String rewardType;
    public String rewardStatistic;
    public long rewardValue;

    public ArrayList<String> tasksTypes;
    public ArrayList<String> tasksStatistics;
    public ArrayList<Long> tasksValues;

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
