package game_world.objects.events;

import game_world.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemPickUpEvent extends Event {

    /**
     * Event executes when there is an item to be picked up (to be implemented)
     */

    private final String item;
    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    // change below for inputs u want
    private final ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(
            "yes", "no"
    ));

    public ItemPickUpEvent(String name, String item) {
        this.name = name;
        this.type = "Item Pick-Up";
        this.item = item;
        this.inputValidator = new WorldInputValidator(inputs);
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // change text below
        output.generateText("[ITEM PICK-UP EVENT] What would you like to do?");
        for (String input : inputs) {
            output.generateText("\t◈ " + input);
        }
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
        OutputHandler output = Output.getScreen();
        output.generateText("You decided to " + input + ".");
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
