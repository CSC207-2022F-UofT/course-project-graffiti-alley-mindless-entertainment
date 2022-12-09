package game_world.factories;

import database.factories.QuestGiverEventFactory;
import database.entities.ArbitraryEventData;
import database.entities.EncounterEventData;
import database.entities.ItemPickUpEventData;
import database.entities.QuestGiverEventData;
import game_world.events.ArbitraryEvent;
import game_world.events.EncounterEvent;
import game_world.events.ItemPickUpEvent;
import game_world.events.QuestGiverEvent;

public class EventFactory {
    public final ItemPickUpEventFactory itemPickUpEventFactory;
    private final QuestGiverEventFactory questGiverEventFactory;

    /**
     * Constructs EventFactory
     * @param itemPickUpEventFactory itemPickUpEventFactory created to avoid introducing the Inventory dependency
     */
    public EventFactory(ItemPickUpEventFactory itemPickUpEventFactory, QuestGiverEventFactory questGiverEventFactory){
        this.itemPickUpEventFactory = itemPickUpEventFactory;
        this.questGiverEventFactory = questGiverEventFactory;
    }

    /**
     * @return the new arbitrary event
     * @param data data from current ArbitraryEventData
     */
    public ArbitraryEvent createArbitraryEvent(ArbitraryEventData data) {
        return new ArbitraryEvent(
                data.name
        );
    }

    /**
     * @return the new encounter event
     * @param data data from current EncounterEventData
     */
    public EncounterEvent createEncounterEvent(EncounterEventData data) {
        return new EncounterEvent(
                data.name,
                data.encounterType,
                data.npc
        );
    }

    /**
     * @return the new encounter event
     * @param data data from current QuestGiverEventData
     */
    public QuestGiverEvent createQuestGiverEvent(QuestGiverEventData data) {
        return this.questGiverEventFactory.createQuestGiverEvent(data);
    }

    /**
     * @return the new item pickup event
     * @param data data from current ItemPickUpEventData
     */
    public ItemPickUpEvent createItemPickUpEvent(ItemPickUpEventData data) {
        return itemPickUpEventFactory.createItem(data);
    }
}
