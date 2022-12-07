package quests;

import objects.character.Player;
import save.SavableEntity;
import save.SaveEntityId;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages all the quests that are completed by the player.
 */
public class PlayerQuests implements SavableEntity {
    /**
     * Attributes.
     */
    // Stores the quests completed and ongoing in the game.
    private List<Quest> quests;


    /**
     * Constructor.
     */
    public PlayerQuests() {
        this.quests = new ArrayList<>();

    }

    /**
     * Adds the quest retrieved to the quest started by the player.
     * @param name of the quest
     */
    public void addNewQuest(String name) {
        this.quests.add(createQuest(name));
    }

    /**
     * Completes all the whenever possible.
     * @param player that attempts to complete the quest.
     */
    public void completeQuests(Player player) {
        for (Quest quest: this.quests) {
            // in case the quest is not yet completed.
            if (!quest.isCompleted()) {
                this.completeQuest(quest, player);
            }
            // case where quest is completed and reward not distributed.
            if (quest.isCompleted() && !quest.isRewardDistributed()) {
                quest.getReward().distribute(player);
            }
        }
    }

    /**
     * @param quest to be completed.
     * @param player that completes the quest.
     */
    public void completeQuest(Quest quest, Player player) {
        if (!quest.isCompleted()) {
            //attempts to complete the tasks.
            completeTasks(quest, player);
        }
    }

    /**
     * @param quest for which the tasks need to be completed.
     * @param player that attempts to complete the tasks from the quest.
     */
    public void completeTasks(Quest quest, Player player) {
        for (Task task: quest.getTasks()) {
            task.isCompleted(player);
        }
    }

    /**
     * @return a string representation of the object to be saved
     */
    @Override
    public String toSavableString() {
        String questsInformation;

        for (Quest quest: this.quests) {
            quest.
        }

        return questsInformation;
    }

    /**
     * @param str a string representation
     *            map the string representation to the corresponding object
     */
    @Override
    public void fromSavableString(String str) {

    }

    /**
     * @return the id of this entity in the saved entities list
     */
    @Override
    public SaveEntityId getId() {
        return null;
    }
}
