package quests;

import objects.character.*;

import java.util.List;

/**
 * This class contains a quest object that can be completed by
 */
public class Quest {

    /**
     * Attributes.
     */
    // Stores the name of the quest.
    private final String name;
    // Stores the description of the quest.
    private final String description;
    // Stores the status of the quest. If true: quest is completed. Otherwise, false: ongoing quest.
    private boolean isCompleted;
    // Stores the overseer (NPC) of the quest.
    private Bystander overseer;
    // Stores the list of tasks that need to be completed.
    private final List<Task> tasks;
    // Stores the reward that can be assigned by Quest Manager to the player, when quest is completed.
    private final Reward reward;
    // Stores whether the Reward has been received by the player.
    private boolean isRewardDistributed;

    /**
     * Constructors.
     */
    // Constructor requesting all the attributes to define a quest.
    public Quest(String name, String description, Bystander overseer, Reward reward, List<Task> tasks) {
        this.name = name;
        // Stores the description of the quest.
        this.description = description;
        this.isCompleted = false;
        this.setOverseer(overseer);
        this.reward = reward;
        this.tasks = tasks;
        this.isRewardDistributed = false;
    }

    /**
     * Sets a new overseer, to be assigned to this quest.
     * @param overseer: Bystander in charge of quest.
     */
    private void setOverseer(Bystander overseer) {
        // Checks whether the overseer is already assigned to a Quest or not.
        if (!overseer.hasQuest()) {
            // Sets the overseer as overseer of the quest.
            this.overseer = overseer;
            // Changes the status of overseer's
            this.overseer.switchHasQuest();
        }
    }

    /**
     * @return the lists of tasks that constitutes the quest.
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a new task to the list of tasks.
     * @param task to be added to the list of tasks in the quest.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * @return the reward for completing the quest completed.
     */
    public Reward getReward() {
        return this.reward;
    }

    /***
     * @return whether the reward for the quest has been distributed.
     */
    public boolean isRewardDistributed() { return this.isRewardDistributed; }


    /**
     * Checks whether the Quest is completed.
     *
     * @return true, if the status of the quest is completed.
     *         true, if all the quest's tasks are completed (in addition to change the quest's status to completed).
     *         false otherwise.
     */
    public boolean isCompleted() {
        // Checks whether the status is set to completed.
        if (this.isCompleted) {
            return true;
        } else if (areTasksCompleted()) {
            this.isCompleted = true;
            return true;
        }
        // Otherwise, quest is not completed.
        return false;
    }

    /**
     * Checks whether all the tasks in the quest have been completed.
     * @return true if all the tasks in the quest have been completed.
     *         false otherwise.
     */
    private boolean areTasksCompleted() {
        boolean areTasksCompleted = true;

        for (Task task : this.tasks) {
            areTasksCompleted = areTasksCompleted && task.isCompleted();
        }

        return areTasksCompleted;
    }

    /**
     * Changes the status of the reward's distribution to true.
     */
    public void distributeReward() {
        this.isRewardDistributed = true;
    }

    /**
     * @return String containing the quest's name & status.
     */
    @Override
    public String toString() {
        String str = this.name + ", status: ";
        if (this.isCompleted) {
            str += "completed.";
        } else {
            str += "on going.";
        }
        return str;
    }
}
