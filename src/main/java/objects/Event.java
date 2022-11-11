package objects;

import java.util.Optional;

public abstract class Event {

    private String eventType;
    private int eventState;

    public Event nextEvent;

    public Event() {
        this.eventState = 0;
    }
}
