package game_world.managers;

import core.StateManager;
import database.managers.EventDataManager;

import database.objects.EventData;
import game_world.objects.areas.Area;
import game_world.objects.events.ArbitraryEvent;
import game_world.objects.events.EncounterEvent;
import game_world.objects.events.ItemPickUpEvent;
import game_world.objects.events.Event;
import interfaces.State;

import java.util.ArrayList;

public class EventManager {

    /**
     * Manages all matters regarding Events
     */

    private ArrayList<Event> eventQueue;
    private EventDataManager database;

    public EventManager() {
        this.database = new EventDataManager();
        this.eventQueue = new ArrayList<>();
    }

    /**
     * Generates new event object
     * @return the new event generated
     * @param name name of Event to be searched
     * @param exec adds Event to eventQueue to be executed if set to true
     */
    public Event createEvent(String name, boolean exec) {
        EventData data = this.database.fetchEvent("name", name);
        Event newEvent;

        if (data.type.equals("Encounter")) {
            newEvent = new EncounterEvent(
                    data.name,
                    data.encounterType,
                    data.npc
            );
        }
        else if (data.type.equals("Item Pick-Up")) {
            newEvent = new ItemPickUpEvent(
                    data.name,
                    data.item
            );
        }
        else {
            newEvent = new ArbitraryEvent(
                    data.name
            );
        }

        if (exec)
            this.eventQueue.add(newEvent);
        return newEvent;
    }

    /**
     * Gets all names of events to be generated and returns an array of events to be added to Area
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
     */
    public void areaEntered(Area area) {
        this.eventQueue.addAll(area.getEvents());
    }

    /**
     * Executes next event in queue
     */
    public State getNextStateInQueue() {
        State nextState = this.eventQueue.get(0);
        this.eventQueue.remove(nextState);
        return nextState;
    }

    public boolean queueCleared() {
        return (this.eventQueue.size() == 0);
    }
}
