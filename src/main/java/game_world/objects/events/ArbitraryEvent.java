package game_world.objects.events;

import io.InputValidator;

public class ArbitraryEvent extends Event {

    /**
     * Test Event (not to be implemented), use for creating new types of Events
     */

    public ArbitraryEvent(String name, long priority) {
        this.name = name;
        this.type = "Arbitrary";
        this.priority = priority;
    }

    @Override
    public void execute() {

    }
}