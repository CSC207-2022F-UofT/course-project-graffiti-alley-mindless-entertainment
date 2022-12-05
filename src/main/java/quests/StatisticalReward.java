package quests;

import objects.character.Player;

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
     * Distributes the reward by changing the corresponding player's statistic by the amount defined.
     * @param receiver: player that will receive the reward when distributed.
     */
    @Override
    public void distribute(Player receiver) {
        switch (this.statistic) {
            // case where the receiver gets extra health from the reward.
            case HEALTH:
                receiver.changeCurrHealth(this.value);
                break;
            // case where the receiver gets extra experience from the reward.
            case EXPERIENCE:
                receiver.changeExperience(this.value);
                break;
            // case where the receiver gets extra levels from the reward.
            case LEVEL:
                receiver.changeLevel(this.value);
                break;
            // case where the receiver gets extra money from the reward.
            case MONEY:
                receiver.changeMoney(this.value);
            default:
                break;
        }
    }
}