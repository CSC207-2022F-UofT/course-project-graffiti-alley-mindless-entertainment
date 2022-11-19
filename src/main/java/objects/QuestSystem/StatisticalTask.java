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
    private NumericalStatistics statistic;
    // Stores the amount of the statistic that the task's assignee needs to reach.
    private int value;
    // Stores whether the
    // true: when player must have statistic == this.value, to complete the tasks,
    // & false: when the statistic >= this.value.
    private boolean isEquality;

    /**
     * Constructor.
     */
    public StatisticalTask(String name, NumericalStatistics statistic, int value, boolean isEquality) {
        super(name);
        this.statistic = statistic;
        this.value = value;
        this.isEquality = isEquality;
    }

    /**
     * Returns the player's statistic that would be affected by the reward (when received).
     */
    public NumericalStatistics getStatistic() {
        return this.statistic;
    }

    /**
     * Changes the type of reward (which player's statistic would be affected).
     */
    public void setStatistic(NumericalStatistics statistic) {
        this.statistic = statistic;
    }

    /**
     * Checks whether the player assigned to the task has at least this amount of money in wallet.
     * Returns true if the player who has been assigned to complete the tasks completed the task.
     * Returns false otherwise.
     */
    @Override
    public boolean isCompleted(Player assignee) {
        if (this.isEquality) {
            return isEquality(assignee);
        }
        else {
            return isNotEquality(assignee);
        }
    }

    public boolean isEquality(Player assignee) {
        switch (this.statistic) {
            case HEALTH:
                return isEqual(assignee.getCurrHealth());
                break;
            case EXPERIENCE:
                return isEqual(assignee.getExperience());
                break;
            case LEVEL:
                return isEqual(assignee.getLevel());
                break;
            case MONEY:
                return isEqual(assignee.getMoney());
                break;
            default:
                return false;
                break;
        }
    }

    public boolean isNotEquality(Player assignee) {
        switch (this.statistic) {
            case HEALTH:
                return isGreaterOrEqual(assignee.getCurrHealth());
            break;
            case EXPERIENCE:
                return isGreaterOrEqual(assignee.getExperience());
            break;
            case LEVEL:
                return isGreaterOrEqual(assignee.getLevel());
            break;
            case MONEY:
                return isGreaterOrEqual(assignee.getMoney());
            break;
            default:
                return false;
            break;
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