package objects;

import java.util.Optional;

public abstract class Event {

    public String eventName;
    public String eventType;
    public Area eventArea;
    public int eventPriority;
    private int eventState;

    public Event nextEvent;

    public Event() {

        this.eventState = 0;
    }
}
