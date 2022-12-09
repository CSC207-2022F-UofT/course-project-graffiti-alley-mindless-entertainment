package quests;

import game_world.factories.QuestFactory;
import character.entities.Player;
import quests.entities.PlayerQuests;
import quests.entities.Quest;
import quests.use_cases.Task;

import java.util.List;

/**
 * This class manages all the matters regarding Quests in the game.
 */
public class QuestInteractor {
    /**
     * Attributes.
     */
    private final PlayerQuests questsInGame;
    private final Player player;
    private final QuestFactory questFactory;


    /**
     * Constructor.
     */
    public QuestInteractor(Player player) {
        this.questsInGame = new PlayerQuests();
        this.player = player;
        this.questFactory = new QuestFactory();
    }


    /**
     * Adds a new quest to the player's quests.
     */
    public void addQuest(String name) {
        Quest quest = this.questFactory.createQuest(name);
        questsInGame.addNewQuest(quest);
    }

    /**
     * @return the quests in the game, accepted by the player.
     */
    public List<Quest> getQuests() {
        return this.questsInGame.getQuests();
    }


    /**
     * Completes all the whenever possible.
     */
    public void completeQuests() {
        for (Quest quest: this.questsInGame.getQuests()) {
            // in case the quest is not yet completed.
            if (!quest.isCompleted()) {
                this.completeQuest(quest);
            }
            // case where quest is completed and reward not distributed.
            if (quest.isCompleted() && !quest.isRewardDistributed()) {
                quest.getReward().distribute(player);
            }
        }
    }

    /**
     * Attempts to complete the tasks.
     * @param quest to be completed.
     */
    private void completeQuest(Quest quest) {
        if (areTasksCompleted(quest)) {
            quest.complete();
        }
    }

    /**
     * Checks whether all the tasks in the quest have been completed.
     * @param quest we want to check the tasks from.
     * @return true if all the tasks in the quest have been completed.
     *         false otherwise.
     */
    private boolean areTasksCompleted(Quest quest) {
        boolean areTasksCompleted = true;

        for (Task task : quest.getTasks()) {
            areTasksCompleted = areTasksCompleted && task.isCompleted();
        }

        return areTasksCompleted;
    }
}