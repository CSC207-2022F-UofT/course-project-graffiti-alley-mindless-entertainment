package game_world.objects.states;

import game_world.WorldInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

public class DialogueState implements State {

    /**
     * State for when there is dialogue to be shown on screen
     * Clicking enter will continue to next state
     */

    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;
    private String currentText;

    public DialogueState(String text) {
        this.currentText = text;
        this.inputValidator = new WorldInputValidator();
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText(this.currentText);
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
