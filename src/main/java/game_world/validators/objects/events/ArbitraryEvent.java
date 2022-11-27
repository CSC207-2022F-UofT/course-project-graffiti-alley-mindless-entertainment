package game_world.validators.objects.events;

import io.InputValidator;

public class ArbitraryEvent extends Event {

    /**
     * Test Event (not to be implemented), use for creating new types of Events
     */

    public ArbitraryEvent(String name, long priority) {
        this.name = name;
        this.type = "Arbitrary";
        this.priority = priority;
        this.eventState = 0;
    }

    @Override
    public void execute() {

    }

    @Override
    public void preInput() {

    }

    @Override
    public void postInput(String input) {

    }

    @Override
    public boolean awaitInput() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
