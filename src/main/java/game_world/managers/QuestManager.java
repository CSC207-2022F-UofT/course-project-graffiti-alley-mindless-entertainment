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







}
