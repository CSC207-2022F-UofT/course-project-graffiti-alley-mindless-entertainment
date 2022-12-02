package game_world.managers;

import database.managers.EventDataManager;

import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import game_world.factories.EventFactory;
import game_world.objects.Area;
import game_world.objects.events.Event;
import interfaces.State;

import java.util.ArrayList;

public class EventManager {

    /**
     * Manages all matters regarding Events
     */

    private ArrayList<Event> eventQueue;
    private final EventDataManager database;
    private final EventFactory eventFactory;

    public EventManager() {
        this.database = new EventDataManager();
        this.eventQueue = new ArrayList<>();
        this.eventFactory = new EventFactory();
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
        State nextState = this.eventQueue.get(0);
        this.eventQueue.remove(nextState);
        return nextState;
    }

    /**
     * @return true if the event queue contains no events
     */
    public boolean queueCleared() {
        return (this.eventQueue.size() == 0);
    }
}
