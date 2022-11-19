package objects;

public class ArbitraryEvent extends Event {

    /**
     * Test Event (not to be implemented), use for creating new types of Events
     */

    public ArbitraryEvent(String name, int priority) {
        this.name = name;
        this.type = "Arbitrary";
        this.priority = priority;
        this.eventState = 0;
    }

    @Override
    public void execute() {

    }
}
