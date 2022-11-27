package game_world.validators.objects.states;

import game_world.validators.objects.Action;
import game_world.validators.AreaInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

public class DialogueState implements State {

    private final AreaInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;
    private String currentText;
    public DialogueState(String text) {
        this.currentText = text;
        this.inputValidator = new AreaInputValidator(Action.ENTERING_AREA);
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
