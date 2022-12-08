package quests;

import objects.character.Player;

/**
 * This class contains the features of a task requiring the player to have a minimum amount of money in its wallet.
 */
public class StatisticalTask extends Task {
    /**
     * Attributes in addition to its parent class' attributes (name & isCompleted).
     */
    // Stores the player's numerical statistic that will be affected by this reward.
    private PlayersStatistics statistic;
    // Stores the amount of the statistic that the task's assignee needs to reach.
    private int value;

    /**
     * Constructor.
     */
    public StatisticalTask(PlayersStatistics statistic, int value) {
        this.statistic = statistic;
        this.value = value;
    }

    /**
     * Checks whether the statistic required for the task by the player responds to the requirement.
     * @param assignee: player that has been assigned the task.
     * @return true if it is the case, meaning that the task is completed.
     *         false, otherwise.
     */
    @Override
    public boolean isCompleted(Player assignee) {
        if (getPlayersStatistic(assignee) >= this.value) {
            this.isCompleted = true;
            return true;
        }
        return false;
    }

    /**
     * @param assignee: player that is assigned to the task in hand.
     * @return the corresponding player's statistic for this specific task.
     */
    private int getPlayersStatistic(Player assignee) {
        switch (this.statistic) {
            case HEALTH:
                return assignee.getCurrHealth();
            case EXPERIENCE:
                return assignee.getExperience();
            case LEVEL:
                return assignee.getLevel();
            case MONEY:
                return assignee.getMoney();
            default:
                return 0;
        }
    }

    /**
     * @return a string with the information for the task.
     */
    @Override
    public String toString() {
        return "statistic," + this.statistic.name() + "," + this.value + "," + this.isCompleted;
    }

    /**
     * Changes the attributes of this object using the parameter.
     * @param str: string containing all the information for this object's attributes.
     */
    @Override
    public void changesFromString(String str) {
        String[] rewardAttributes = str.split(",");

        this.statistic = PlayersStatistics.valueOf(rewardAttributes[1]);
        this.value = Integer.parseInt(rewardAttributes[2]);
        this.isCompleted = Boolean.parseBoolean(rewardAttributes[3]);
    }
}