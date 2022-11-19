package objects.QuestSystem;

import objects.character.Bystander;
import objects.character.Player;

import java.util.*;

/**
 * This class contains a quest object that can be completed by
 */
public class Quest {
    /**
     * Attributes.
      */
    // Stores the name of the quest.
    private String name;
    // Stores the description of the quest.
    private String description;
    // Stores the status of the quest. If true: quest is completed. Otherwise, false: ongoing quest.
    private boolean isCompleted;
    // Stores the overseer (NPC) of the quest.
    private Bystander overseer;
    // Stores the list of tasks that need to be completed.
    private List<Task> tasks;
    // Stores the reward that can be assigned by Quest Manager to the player, when quest is completed.
    private Reward reward;
    // Stores whether the Reward has been received by the player.
    private boolean isRewardDistributed;

    /**
     * Constructors.
     */
    // Constructor requesting all the attributes to define a quest.
    public Quest(String name, String description, Bystander overseer, Reward reward, List<Task> tasks) {
        // assigns name to the quest's name.
        this.name = name;
        // assigns description to the quest's description.
        this.description = description;
        // assigns false the quest status: just created, not started = not completed.
        this.isCompleted = false;
        // assigns the overseer to the quest.
        this.setOverseer(overseer);
        // assigns the reward that will be received for completing the quest.
        this.reward = reward;
        // assigns tasks to the list of tasks that need to be completed during the quest.
        this.tasks = tasks;
        // assigns false to the quest at the start, since quest not started = reward cannot be distributed.
        this.isRewardDistributed = false;
    }
    // Constructor requesting only a name, a description, an overseer.
    public Quest(String name, String description, Bystander overseer) {
        this(name, description, overseer, null, new ArrayList<Task>());
    }
    // Constructor only requesting a name and an overseer.
    public Quest(String name, Bystander overseer) {

        this(name, "", overseer, null, new ArrayList<Task>());
    }

    /**
     * Returns the name of the quest.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the quest.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the quest.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the quest.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the overseer affiliated to the quest.
     */
    public Bystander getOverseer() {
        return overseer;
    }

    /**
     * Sets a new overseer, to be assigned to this quest.
     */
    private boolean setOverseer(Bystander overseer) {
        // Checks whether the overseer is already assigned to a Quest or not.
        if (!overseer.hasQuest()) {
            // Sets the overseer as overseer of the quest.
            this.overseer = overseer;
            // Changes the status of overseer's
            this.overseer.switchQuestStatus();
            return true;
        }
        return false;
    }

    /**
     * Returns the lists of tasks that constitutes the quest.
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a new task to the list of tasks.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Returns the reward for completing the quest completed.
     */
    public Reward getReward() {
        return this.reward;
    }

    /**
     * Sets a new reward for the completion of the quest.
     */
    public void setReward(Reward reward) {
        this.reward = reward;
    }

    /***
     * Returns whether the reward for the quest has been distributed.
     */
    public boolean isRewardDistributed() { return this.isRewardDistributed; }


    /**
     * Checks whether the Quest is completed.
     *
     * Returns true, if the status of the quest is completed.
     * Returns true, if all the quest's tasks are completed (in addition to change the quest's status to completed).
     * Returns false otherwise.
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
     * Returns true if all the tasks in the quest have been completed.
     * Returns false otherwise.
     */
    private boolean areTasksCompleted() {
        boolean areTasksCompleted = true;

        for (int i = 0; i < this.tasks.size(); i++) {
            areTasksCompleted = areTasksCompleted && this.tasks.get(i).isCompleted();
        }

        return areTasksCompleted;
    }

    /**
     * Changes the status of the reward's distribution to true.
     */
    public void distributeReward() {
        this.isRewardDistributed = true;
    }
}