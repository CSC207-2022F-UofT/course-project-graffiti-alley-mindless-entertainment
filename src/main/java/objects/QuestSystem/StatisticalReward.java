package objects.QuestSystem;

/**
 * This class determines specifically how a reward affecting a player's statistics behaves.
 */
public class StatisticalReward extends Reward {
    /**
     * Attributes.
     */
    // Stores the player's numerical statistic that will be affected by this reward.
    private PlayersStatistics statistic;
    // Stores the amount by which the reward's receiver's chosen statistic is affected.
    private int value;

    /**
     * Constructor.
     */
    public StatisticalReward(PlayersStatistics statistic, int value) {
        this.statistic = statistic;
        this.value = value;
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
     * Returns the amount by which the player's statistic would be affected when reward is distributed.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Changes the amount by which the player's statistic would be affected when reward is distributed.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Distributes the reward by changing the corresponding player's statistic by the amount defined.
     */
    @Override
    protected void distribute(Player receiver) {
        switch (this.statistic) {
            // case where the receiver gets extra health from the reward.
            case HEALTH:
                receiver.changeCurrHealth(this.value);
                break;
            // case where the receiver gets extra experience from the reward.
            case EXPERIENCE:
                receiver.addExperience(this.experiencePoints);
                break;
            // case where the receiver gets extra levels from the reward.
            case LEVEL:
                receiver.addLevel(this.value);
                break;
            // case where the receiver gets extra money from the reward.
            case MONEY:
                receiver.changeMoney(this.value);
            default:
                break;
        }
    }
}
