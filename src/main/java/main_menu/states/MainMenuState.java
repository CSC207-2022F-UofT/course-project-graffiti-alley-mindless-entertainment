package main_menu.states;

import interfaces.State;
import io.InputValidator;
import main_menu.MainMenuInputValidator;
import main_menu.MainMenuOptions;

public class MainMenuState implements State {
    /** The default State of the main menu. Gives the user options to start a new game, load saved games, enter the
     * options, or quit the game.
     * Attributes:
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A MainMenuInputValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final MainMenuInputValidator inputValidator;

    public MainMenuState() {
        // Initializes a new MainMenuState.
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new MainMenuInputValidator(MainMenuOptions.MAINMENU);
    }

    @Override
    public void preInput() {

    }

    @Override
    public void postInput(String input) {

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
