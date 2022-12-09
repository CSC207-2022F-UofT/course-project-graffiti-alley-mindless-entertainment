package game_world.managers;

import game_world.entities.Area;
import game_world.events.Event;
import core.State;

import java.util.ArrayList;

public class EventManager {

    /**
     * Manages all matters regarding Events
     */

    private final ArrayList<Event> eventQueue;
    private final ArrayList<String> completedEvents;

    /**
     * Constructs EventManager
     */
    public EventManager() {
        this.eventQueue = new ArrayList<>();
        this.completedEvents = new ArrayList<>();
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
