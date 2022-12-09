package main_menu.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.input_validators.MainMenuInputValidator;

/**
 * The default State of the main menu. Gives the user options to start a new game, load saved games, enter the
 * options, or quit the game.
 */
public class MainMenuState implements State {
    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A s that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final MainMenuInputValidator inputValidator;

    /**
     * Initializes a new MainMenuState.
     */
    public MainMenuState() {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new MainMenuInputValidator();
    }

    /**
     * Uses OutputHandler to set up the main menu and give options to the user.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("PACT: A Text-Based Adventure Game" + "\n" +
                "Welcome to the world of PACT! You are currently at the main menu." + "\n" +
                "Type 'new' if you would like to start a new game." + "\n" +
                "Type 'load' if you would like to load a previous game." + "\n" +
                "Type 'exit' if you would like to quit the game.");
    }

    /**
     * Assumes input has already been parsed and validated.
     * @param input From the user.
     * Executes when the state is awaiting input.
     */
    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
    }

    /**
     * @return Boolean awaitInput.
     */
    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    /**
     * @return Boolean isDone.
     */
    @Override
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * @return The MainMenuInputValidator of this MainMenuState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }

}
