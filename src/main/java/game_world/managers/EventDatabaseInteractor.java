package game_world.managers;

import database.managers.EventDataManager;
import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import database.objects.QuestGiverEventData;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.objects.events.Event;

public class EventDatabaseInteractor {

    private final EventDataManager database;
    private final EventFactory eventFactory;

    public EventDatabaseInteractor(ItemPickUpEventFactory itemFactory) {
        this.database = new EventDataManager();
        this.eventFactory = new EventFactory(itemFactory);
    }

    /**
     * Generates new event object
     * @return the new event generated
     * @param name name of Event to be searched
     */
    public Event createEvent(String name) {
        String type = this.database.fetchEventType(name);
        Event newEvent;

        if (type.equals("Encounter")) {
            EncounterEventData data = this.database.fetchEncounterEvent("name", name);
            newEvent = eventFactory.createEncounterEvent(data);
        }
        else if (type.equals("Item Pick-Up")) {
            ItemPickUpEventData data = this.database.fetchItemPickUpEvent("name", name);
            newEvent = eventFactory.createItemPickUpEvent(data);
        }
        else if (type.equals("Quest Giver")) {
            QuestGiverEventData data = this.database.fetchQuestGiverEvent("name", name);
            newEvent = eventFactory.createQuestGiverEvent(data);
        }
        else {
            ArbitraryEventData data = this.database.fetchArbitraryEvent("name", name);
            newEvent = eventFactory.createArbitraryEvent(data);
        }

        return newEvent;
    }

}
