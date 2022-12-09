package quests.use_cases;

import character.entities.Player;

/**
 * This class contains a general abstract implementation of a reward and methods that should be implemented.
 */
public abstract class Reward {
    /**
     * Distributes the reward to the receiving player. Will be defined depending on the more specific type of reward.
     */
    public abstract void distribute(Player receiver);

    /**
     * @return a string with the information for the reward.
     */
    @Override
    public abstract String toString();

    /**
     * Changes the attributes of this object using the parameter.
     * @param str: string containing all the information for this object's attributes.
     */
    public abstract void changesFromString(String str);
}