package objects.QuestSystem;

import database.managers.DatabaseManager;
import objects.character.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the manager of all the quests that can be completed by the player.
 */
public class QuestManager extends DatabaseManager {
    /**
     * Attribute
     */
    // Stores the list of quests to be completed throughout the game.
    private List<Quest> quests;
    // Stores a quest factory.
    private QuestDataFactory factory;

    /**
     * Constructor.
     */
    public QuestManager() {
        this.factory = new QuestDataFactory();
        this.quests = new ArrayList<Quest>();
    }


    // description of the important method regrouping the whole thing::
    //
    // a method that regroups everything together:
    // when player input quest: show the whole menu
    // then display (output handler) -
    // player can choose on quest (number of it) to complete it.
    // quest goes into the process to be completed
    // .

    /**
     * Initializes the quests for the game.
     */
    public void initialize() {
        // fetches the data for the quest from the Json file storing the database.
        JSONArray questData = (JSONArray) super.fullDatabase.get("quests");

        this.initializeQuests(questData);
    }

    /**
     * Creates all the quests from the database.
     */
    private void initializeQuests(JSONArray jsonArray) {
        for (Object obj: jsonArray) {
            this.quests.add(factory.createQuest((JSONObject) obj));
        }
    }

    /**
     * Displays the quests and their statuses.
     */
    //!!! use the output handler.
    public void displayQuest() {
        // displays the quest status with this. this.questStatuses()
    }

    /**
     * Returns a String containing the statuses for all the quests.
     */
    private String questsStatuses() {
        String str = "";

        for (int i = 0; i < this.quests.size(); i++) {
            str += i + this.quests.get(i).toString() + "\n";
        }

        return str;
    }

    /**
     * Returns the quest number x.
     */
    public Quest getQuest(int x) {
        if (x < this.quests.size()) {
            return this.quests.get(x);
        }
        else {
            return null;
        }
    }

    /**
     * Attempts to completes a quest.
     */
    public void completeQuest(Quest quest, Player player) {
        if (quest.isCompleted() && !quest.isRewardDistributed()) {
            quest.getReward().distribute(player);
            quest.distributeReward();
        }
    }
}
