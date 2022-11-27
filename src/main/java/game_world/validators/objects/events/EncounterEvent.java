package game_world.validators.objects.events;

import io.InputValidator;

public class EncounterEvent extends Event {

    /**
     * Event executes when there is an encounter between entities (to be implemented)
     */

    public EncounterEvent(String name, long priority) {
        this.name = name;
        this.type = "Encounter";
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
