package objects.QuestSystem;

import objects.character.Player;

/**
 * This class contains the abstract methods that need to be implemented in order to define a task.
 */
public abstract class Task {
    /**
     * Attributes.
     */
    // Stores the name of the task.
    protected String name;
    // Stores whether the task has been completed.
     protected boolean isCompleted;

    /**
     * Constructor.
     */
    public Task(String name) {
        this.name = name;
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
}