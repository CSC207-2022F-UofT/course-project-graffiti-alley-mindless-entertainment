package game_world.factories;

import database.factories.QuestGiverEventFactory;
import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import database.objects.QuestGiverEventData;
import game_world.managers.EventManager;
import game_world.objects.events.ArbitraryEvent;
import game_world.objects.events.EncounterEvent;
import game_world.objects.events.ItemPickUpEvent;
import game_world.objects.events.QuestGiverEvent;
import game_world.factories.ItemPickUpEventFactory;
import objects.inventory.Inventory;
import quests.Quest;

public class EventFactory {
    public ItemPickUpEventFactory itemPickUpEventFactory;
    private QuestGiverEventFactory questGiverEventFactory;

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
