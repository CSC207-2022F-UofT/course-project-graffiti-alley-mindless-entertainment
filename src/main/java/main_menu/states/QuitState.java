package main_menu.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.MainMenuInputValidator;
import main_menu.MainMenuOptions;

public class QuitState implements State {
    /** The State for quitting the game. Asks the user if they would like to quit the game or return to the main
     * menu.
     * Attributes:
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A MainMenuInputValidator that is used to validate the input from the user.
     */

    private boolean awaitInput;
    private boolean isDone;
    private final MainMenuInputValidator inputValidator;

    public QuitState() {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new MainMenuInputValidator(MainMenuOptions.QUIT);
    }

    @Override
    public void preInput() {
        // Asks the user if they would like to quit or return to the main menu utilizing OutputHandler.
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Are you sure you would like to quit the game?");
        output.generateText("Type 'quit' to close the game.");
        output.generateText("Type 'return' to return to the main menu.");
    }

    @Override
    public void postInput(String input) {
        // Assumes input has already been parsed and validated.
        this.isDone = true;
        this.awaitInput = false;
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
