package quests;

import objects.character.Player;

/**
 * This class contains the abstract methods that need to be implemented in order to define a task.
 */
public abstract class Task {
    /**
     * Attribute.
     */
    // Stores whether the task has been completed.
    protected boolean isCompleted;

    /**
     * Constructor.
     */
    public Task() {
        this.isCompleted = false;
    }

    /**
     * @return whether the task is completed or not.
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Completes the task.
     * @return true if the task has been completed properly. Returns false otherwise.
     */
    public abstract boolean isCompleted(Player assignee);

    /**
     * @return a string with the information for the reward.
     */
    public abstract String toString();

    /**
     * Changes the attributes of this object using the parameter.
     * @param str: string containing all the information for this object's attributes.
     */
    public abstract void changesFromString(String str);
}