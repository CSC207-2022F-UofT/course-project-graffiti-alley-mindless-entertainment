package objects.QuestSystem;

import objects.character.Player;

/**
 * This class contains a general abstract implementation of a reward and methods that should be implemented.
 */
public abstract class Reward {
    /**
     * Distributes the reward to the receiving player. Will be defined depending on the more specific type of reward.
     */
    protected abstract void distribute(Player receiver);
}