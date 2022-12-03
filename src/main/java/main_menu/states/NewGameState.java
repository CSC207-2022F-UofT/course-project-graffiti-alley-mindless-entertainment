package main_menu.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.MainMenuInputValidator;
import main_menu.MainMenuOptions;

public class NewGameState implements State {
    /** The State for starting a new game.
     * Attributes:
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A MainMenuInputValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final MainMenuInputValidator inputValidator;

    public NewGameState () {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new MainMenuInputValidator(MainMenuOptions.NEW);
    }

    @Override
    public void preInput() {
        // Asks the user if they would like to overwrite a save in a save slot or return to the main menu utilizing
        // OutputHandler.
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Are you sure you would like to start a new game?");
        output.generateText("Type 'start' if you would like to start a new game.");
        output.generateText("Type 'return' if you would like to return to the main menu.");
    }

    @Override
    public void postInput(String input) {
        // Assumes input has already been parsed and validated.
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