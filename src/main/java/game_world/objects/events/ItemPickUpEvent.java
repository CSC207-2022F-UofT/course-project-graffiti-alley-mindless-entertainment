package game_world.objects.events;

import io.InputValidator;

public class ItemPickUpEvent extends Event {

    /**
     * Event executes when there is an item to be picked up (to be implemented)
     */

    public ItemPickUpEvent(String name, long priority) {
        this.name = name;
        this.type = "Item Pick-Up";
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
