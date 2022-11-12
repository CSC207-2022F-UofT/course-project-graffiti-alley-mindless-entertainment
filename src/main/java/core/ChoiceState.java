package core;

import interfaces.InputValidator;
import interfaces.State;

import java.util.Arrays;
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

    public ChoiceState(List<String> choices, List<String> choiceDisplayText) {
        this.choices = choices;

        //this algorithm can be changed depending on how the text should display
        this.textToDisplay = String.join("\n", choiceDisplayText);
        inputValidator = new ChoiceInputValidator(choices);

    }

    public ChoiceState(List<String> choices, String textToDisplay) {
        this.choices = choices;
        this.textToDisplay = textToDisplay;
        inputValidator = new ChoiceInputValidator(choices);
    }

    /**
     * @return whether the state is done and ready to move to the next state
     */
    @Override
    public boolean preInput() {
        //display using Output handler text
        awaitingInput = true;
        return false;
    }

    /**
     * @param input from the user
     * @return whether the state is done and ready to move to the next state
     */
    @Override
    public boolean postInput(String input) {
        //nothing needs to be done. Manager will send the game to the next state.
        return true;
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
}
