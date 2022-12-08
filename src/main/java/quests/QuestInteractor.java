package quests;

import game_world.objects.events.QuestGiverEvent;
import objects.character.Player;
import quests.PlayerQuests;
import quests.Quest;
import quests.Task;

import java.util.List;

/**
 * This class manages all the matters regarding Quests in the game.
 */
public class QuestInteractor {
    /**
     * Attributes.
     */
    private PlayerQuests questsInGame;
    private Player player;


    /**
     * Constructor.
     */
    public QuestInteractor(Player player) {
        this.questsInGame = new PlayerQuests();
        this.player = player;
    }


    /**
     * Adds a new quest to the player's quests.
     */
    public void addQuest(QuestGiverEvent event) {
        //!!!
        questsInGame.addNewQuest(null);
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