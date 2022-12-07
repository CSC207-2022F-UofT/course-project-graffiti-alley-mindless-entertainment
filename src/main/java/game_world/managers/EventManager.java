package game_world.managers;

import database.managers.EventDataManager;

import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import database.objects.QuestGiverEventData;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.objects.Area;
import game_world.objects.events.Event;
import interfaces.State;
import objects.inventory.Inventory;

import java.util.ArrayList;

public class EventManager {

    /**
     * Manages all matters regarding Events
     */

    private ArrayList<Event> eventQueue;
    private ArrayList<String> completedEvents;
    private final EventDataManager database;
    private final EventFactory eventFactory;

    /**
     * Constructs EventManager
     * @param itemPickUpEventFactory itemPickUpEventFactory created to avoid introducing the Inventory dependency
     */
    public EventManager(ItemPickUpEventFactory itemPickUpEventFactory) {
        this.database = new EventDataManager();
        this.eventQueue = new ArrayList<>();
        this.completedEvents = new ArrayList<>();
        this.eventFactory = new EventFactory(itemPickUpEventFactory);
    }

    /**
     * Generates new event object
     * @return the new event generated
     * @param name name of Event to be searched
     * @param exec adds Event to eventQueue to be executed if set to true
     */
    public Event createEvent(String name, boolean exec) {
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

        if (exec)
            this.eventQueue.add(newEvent);
        return newEvent;
    }

    /**
     * @param names of events to be generated
     * @return array of events to be added to Area
     */
    public ArrayList<Event> getEventsFromArea(ArrayList<String> names) {
        ArrayList<Event> events = new ArrayList<>();
        for (String name : names) {
            events.add(this.createEvent(name, false));
        }
        return events;
    }

    /**
     * Adds all events of new area to event queue to be executed
     * @param area of the new area entered
     */
    public void areaEntered(Area area) {
        this.eventQueue.addAll(area.getEvents());
    }

    /**
     * Executes next event in queue
     * @return next State to be returned in nextState
     */
    public State getNextStateInQueue() {
        Event currEvent = this.eventQueue.get(0);
        while (this.completedEvents.contains(currEvent.name)) {
            this.eventQueue.remove(currEvent);
            if (this.eventQueue.size() == 0)
                return null;
            currEvent = this.eventQueue.get(0);
        }
        this.completedEvents.add(currEvent.name);
        this.eventQueue.remove(currEvent);
        return currEvent;
    }

    /**
     * @return true if the event queue contains no events
     */
    public boolean queueCleared() {
        return (this.eventQueue.size() == 0);
    }
}
