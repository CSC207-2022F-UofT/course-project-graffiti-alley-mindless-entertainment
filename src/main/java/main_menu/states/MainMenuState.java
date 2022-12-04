package main_menu.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
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
        // Uses OutputHandler to set up the main menu and give options to the user.
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("PACT: A Text-Based Adventure Game");
        output.generateText("Welcome to the world of PACT! You are currently at the main menu.");
        output.generateText("Type 'new' if you would like to start a new game.");
        output.generateText("Type 'load' if you would like to load a previous game.");
        output.generateText("Type 'quit' if you would like to quit the game.");
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
