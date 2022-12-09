package core;

import io.InputValidator;
import io.Output;

import java.util.List;

public class ChoiceState implements State {

    /*
     * This class is used to ask for a choice from a list of allowed choices.
     * choices: The list of choices the program is allowed to make.
     */

    List<String> choices;
    String textToDisplay;
    boolean awaitingInput = false;
    InputValidator inputValidator;

    boolean isDone = false;

    public ChoiceState(List<String> choices, List<String> choiceDisplayText) {
        this.choices = choices;
        textToDisplay = String.join("\n", choiceDisplayText);
        inputValidator = new ChoiceInputValidator(choices);

    }

    public ChoiceState(List<String> choices, String textToDisplay) {
        this.choices = choices;
        this.textToDisplay = textToDisplay;
        inputValidator = new ChoiceInputValidator(choices);
    }

    /**
     * Executes when the state is not awaiting input
     */
    @Override
    public void preInput() {
        Output.getScreen().generateTextWithOptions(textToDisplay, choices);
        awaitingInput = true;
    }

    /**
     * @param input from the user
     * Executes when the state is awaiting input
     * Nothing needs to be done. Manager will send the game to the next state.
     */
    @Override
    public void postInput(String input) {
        isDone = true;
    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {

        return awaitingInput;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public boolean isDone() {
        return isDone;
    }

}
