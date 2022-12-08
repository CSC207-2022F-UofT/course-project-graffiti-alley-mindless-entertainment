package game_world.managers;

import game_world.factories.ItemPickUpEventFactory;
import game_world.objects.Area;
import game_world.objects.events.Event;
import interfaces.State;

import java.util.ArrayList;

public class EventManager {

    /**
     * Manages all matters regarding Events
     */

    private final ArrayList<Event> eventQueue;
    private final ArrayList<String> completedEvents;

    private final EventDatabaseInteractor databaseController;

    /**
     * Constructs EventManager
     */
    public EventManager(ItemPickUpEventFactory itemFactory) {
        this.eventQueue = new ArrayList<>();
        this.databaseController = new EventDatabaseInteractor(itemFactory);
        this.completedEvents = new ArrayList<>();
    }

    /**
     * @param names of events to be generated
     * @return array of events to be added to Area
     */
    public ArrayList<Event> getEventsFromArea(ArrayList<String> names) {
        ArrayList<Event> events = new ArrayList<>();
        for (String name : names) {
            events.add(databaseController.createEvent(name));
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
