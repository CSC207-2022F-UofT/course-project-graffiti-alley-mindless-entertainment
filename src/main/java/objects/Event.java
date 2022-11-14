package objects;

import java.util.Optional;

public abstract class Event {

    private String eventType;
    private int eventState;

    private Optional<Event> nextEvent;

    public Event() {
        this.eventState = 0;
    }
}
