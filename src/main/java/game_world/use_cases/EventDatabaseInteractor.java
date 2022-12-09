package game_world.use_cases;

import database.managers.EventDataManager;
import database.entities.ArbitraryEventData;
import database.entities.EncounterEventData;
import database.entities.ItemPickUpEventData;
import database.entities.QuestGiverEventData;
import game_world.factories.EventFactory;
import game_world.events.Event;
import game_world.entities.EventType;

import java.util.ArrayList;

public class EventDatabaseInteractor {

    private final EventDataManager database;
    private final EventFactory eventFactory;

    public EventDatabaseInteractor(EventFactory eventFactory) {
        this.database = new EventDataManager();
        this.eventFactory = eventFactory;
    }

    /**
     * @param names of events to be generated
     * @return array of events to be added to Area
     */
    public ArrayList<Event> getEventsFromArea(ArrayList<String> names) {
        ArrayList<Event> events = new ArrayList<>();
        for (String name : names) {
            events.add(createEvent(name));
        }
        return events;
    }

    /**
     * Generates new event object
     * @return the new event generated
     * @param name name of Event to be searched
     */
    private Event createEvent(String name) {
        EventType type = this.database.fetchEventType(name);
        Event newEvent;

        if (type == EventType.ENCOUNTER) {
            EncounterEventData data = this.database.fetchEncounterEvent("name", name);
            newEvent = eventFactory.createEncounterEvent(data);
        }
        else if (type == EventType.ITEM_PICKUP) {
            ItemPickUpEventData data = this.database.fetchItemPickUpEvent("name", name);
            newEvent = eventFactory.createItemPickUpEvent(data);
        }
        else if (type == EventType.QUEST_GIVER) {
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
