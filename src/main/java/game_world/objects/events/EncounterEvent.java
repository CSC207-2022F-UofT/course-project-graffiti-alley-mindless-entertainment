package game_world.objects.events;

import game_world.objects.Action;
import game_world.validators.EventInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

public class EncounterEvent extends Event {

    /**
     * Event executes when there is an encounter between entities (to be implemented)
     */

    private final String encounterType;
    private final String npc;
    private final EventInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    public EncounterEvent(String name, String encounterType, String npc) {
        this.name = name;
        this.type = "Encounter";
        this.encounterType = encounterType;
        this.npc = npc;
        // change what input you want in eventInputValidator parseAndValidate
        this.inputValidator = new EventInputValidator(Action.ENCOUNTER);
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // change text below
        output.generateText("This is an Encounter event. Press enter to continue.");
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
    }

    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
