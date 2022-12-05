package objects.QuestSystem;
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
    // Stores whether the task requires the player's statistic to be equal to the value inserted.
    // true: when player must have statistic == this.value, to complete the tasks,
    // & false: when the statistic >= this.value.
    private boolean isEquality;

    /**
     * Constructor.
     */
    public StatisticalTask(String name, PlayersStatistics statistic, int value, boolean isEquality) {
        super(name);
        this.statistic = statistic;
        this.value = value;
        this.isEquality = isEquality;
    }

    /**
     * Returns the player's statistic that would be affected by the reward (when received).
     */
    public PlayersStatistics getStatistic() {
        return this.statistic;
    }

    /**
     * Changes the type of reward (which player's statistic would be affected).
     */
    public void setStatistic(PlayersStatistics statistic) {
        this.statistic = statistic;
    }

    /**
     * Checks whether the statistic required for the task by the player responds to the requirement.
     * Returns true if it is the case, meaning that the task is completed.
     * Returns false, otherwise.
     */
    @Override
    public boolean isCompleted(Player assignee) {
        if (this.isEquality) {
            return isEqual(getPlayersStatistic(assignee));
        }
        else {
            return isGreaterOrEqual(getPlayersStatistic(assignee));
        }
    }

    /**
     * Returns the corresponding player's statistic for this specific task.
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
     * Checks whether the number is equal to the task's required value.
     * Return true if it is the case. Otherwise, returns false.
     */
    private boolean isEqual(int number) {
        return number == this.value;
    }

    /**
     * Checks whether the number is at least equal to the value required.
     * Returns true if it is the case. Otherwise, returns false.
     */
    private boolean isGreaterOrEqual(int number) {
        return number >= this.value;
    }
}