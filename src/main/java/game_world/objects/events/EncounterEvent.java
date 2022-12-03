package game_world.objects.events;

import game_world.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class EncounterEvent extends Event {

    /**
     * Event executes when there is an encounter between entities (to be implemented)
     */

    private final String encounterType;
    private final String npc;
    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    // change below for inputs u want
    private final ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(
            "yes", "no"
    ));

    public EncounterEvent(String name, String encounterType, String npc) {
        this.name = name;
        this.type = "Encounter";
        this.encounterType = encounterType;
        this.npc = npc;
        this.inputValidator = new WorldInputValidator(inputs);
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // change text below
        StringBuilder newMessage = new StringBuilder("[ENCOUNTER EVENT] What would you like to do?");
        for (String input : inputs) {
            newMessage.append("\n\t◈ ").append(input);
        }
        output.generateText(String.valueOf(newMessage));
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
        OutputHandler output = Output.getScreen();
        output.generateText("You decided to " + input + ".");
        // switch manager here
        /// SwitchEventMediator s = SwitchEventMediatorProxy.getInstance();
        /// s.store(SwitchEventType.--name of your switchevent--);
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
