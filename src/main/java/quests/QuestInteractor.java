package quests;

import game_world.factories.QuestFactory;
import objects.character.Player;

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
     * @param quest to be completed.
     */
    private void completeQuest(Quest quest) {
        if (!quest.isCompleted()) {
            //attempts to complete the tasks.
            completeTasks(quest);
        }
    }

    /**
     * @param quest for which the tasks need to be completed.
     */
    public void completeTasks(Quest quest) {
        for (Task task: quest.getTasks()) {
            task.isCompleted(player);
        }
    }
}