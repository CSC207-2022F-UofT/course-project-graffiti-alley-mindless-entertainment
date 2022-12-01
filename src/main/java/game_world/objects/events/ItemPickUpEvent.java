package game_world.objects.events;

import game_world.objects.Action;
import game_world.validators.EventInputValidator;
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
    private final EventInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    public ItemPickUpEvent(String name, String item) {
        this.name = name;
        this.type = "Item Pick-Up";
        this.item = item;
        // change what input you want in eventInputValidator parseAndValidate
        this.inputValidator = new EventInputValidator(Action.ITEM_PICKUP,
                new ArrayList<String>(Arrays.asList("yes", "no")));
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // change text below
        output.generateText("This is an Item Pick-Up event. Press enter to continue.");
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
