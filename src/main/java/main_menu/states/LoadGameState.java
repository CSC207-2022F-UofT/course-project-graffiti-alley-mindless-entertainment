package main_menu.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.MainMenuInputValidator;
import main_menu.MainMenuOptions;

/**
 * The State for loading a previous game.
 */
public class LoadGameState implements State {
    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A MainMenuInputValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final MainMenuInputValidator inputValidator;

    /**
     * Initializes a new LoadGameState that is not completed and is not awaiting input.
     */
    public LoadGameState() {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new MainMenuInputValidator(MainMenuOptions.LOAD);
    }

    /**
     * Asks the user which save slot they would like to open, or if they would like to return to the main menu.
     * Utilizes OutputHandler.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // Can put a loop here once saving is implemented to show the user any saved game Player name and
        // description.
        // Awaiting saving implementation.
        output.generateText("Type 'return' if you would like to return to the main menu.");
    }

    /**
     * Assumes input has already been parsed and validated.
     * @param input From the user.
     * Executes when the state is awaiting input.
     */
    @Override
    public void postInput(String input) {
        // Awaiting saving implementation.
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
     * @return The MainMenuInputValidator of this LoadGameState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
