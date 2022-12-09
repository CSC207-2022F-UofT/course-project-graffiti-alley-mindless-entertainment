package database.factories;

import database.entities.QuestGiverEventData;
import game_world.events.QuestGiverEvent;
import quests.QuestInteractor;

/**
 * This class manages the Creation of QuestGiverEvents.
 */
public class QuestGiverEventFactory {

    /**
     * Attributes.
     */
    private final QuestInteractor interactor;

    /**
     * Constructor.
     */
    public QuestGiverEventFactory(QuestInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * @return the new encounter event
     * @param data data from current QuestGiverEventData
     */
    public QuestGiverEvent createQuestGiverEvent(QuestGiverEventData data) {
        return new QuestGiverEvent(
                data.name,
                data.quest,
                data.npc,
                this.interactor
        );
    }

}
