package game_world.events;

import game_world.use_cases.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

public class ArbitraryEvent extends Event {

    /**
     * Test Event (not to be implemented), use for creating new types of Events
     */

    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    public ArbitraryEvent(String name) {
        this.name = name;
        this.type = "Arbitrary";
        this.inputValidator = new WorldInputValidator();
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("This is an arbitrary event. Press enter to continue.");
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
