package game_world.managers;

import database.managers.QuestDataManager;
import database.objects.QuestData;
import game_world.factories.QuestFactory;
import objects.character.Player;
import quests.Quest;
import quests.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages all the matters regarding Quests in the game.
 */
public class QuestManager {
    /**
     * Attributes.
     */
    private List<Quest> quests;
    private final QuestDataManager database;
    private final QuestFactory questFactory;


    /**
     * Constructor.
     */
    public QuestManager() {
        this.quests = new ArrayList<>();
        this.database = new QuestDataManager();
        this.questFactory = new QuestFactory();
    }

    /**
     * Generates new Quest object.
     * @param name of the quest.
     * @return Quest object corresponding to the Quest created from the name.
     */
    public Quest createQuest(String name) {
        QuestData data = this.database.fetchQuestData(name);
        return this.questFactory.createQuest(data);
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






}
