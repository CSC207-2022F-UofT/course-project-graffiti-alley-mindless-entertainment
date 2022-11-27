package game_world.objects.states;

import game_world.objects.Action;
import game_world.validators.AreaInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;

public class SelectionState implements State {

    private final AreaInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;
    private ArrayList<String> inputs;

    public SelectionState(ArrayList<String> inputs) {
        this.inputs = inputs;
        this.inputValidator = new AreaInputValidator(Action.LEAVING_AREA, inputs);
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("What would you like to do?");
        for (String input : inputs) {
            output.generateText("\t◈ " + input);
        }
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
        OutputHandler output = Output.getScreen();
        output.generateText("You decide to " + input + ".");
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
