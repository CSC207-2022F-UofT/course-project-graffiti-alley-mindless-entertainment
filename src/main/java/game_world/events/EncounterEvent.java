package game_world.events;

import game_world.use_cases.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import core.switch_managers.switch_events.SwitchEventMediator;
import core.switch_managers.switch_events.SwitchEventMediatorProxy;
import core.switch_managers.switch_events.SwitchEventType;

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

    public String getNPC() {
        return this.npc;
    }

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
        StringBuilder newMessage = new StringBuilder("[ENCOUNTER EVENT] You encountered an enemy! Would you like to fight it?");
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
        if (input.equals("yes")) {
            SwitchEventMediator s = SwitchEventMediatorProxy.getInstance();
            s.store(SwitchEventType.ENCOUNTER);
            output.generateText("BATTLE HAS BEGUN! Your enemy is: " + npc);
        }
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
