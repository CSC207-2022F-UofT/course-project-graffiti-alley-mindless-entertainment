package main_menu.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.input_validators.NewGameInputValidator;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.SwitchEventType;

/**
 * The State for starting a new game.
 */
public class NewGameState implements State {
    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A NewGameInputValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final NewGameInputValidator inputValidator;

    /**
     * Initializes a new NewGameState.
     */
    public NewGameState () {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new NewGameInputValidator();
    }

    /**
     * Asks the user if they would like to start a new game or return to the main menu. Utilizes OutputHandler.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Are you sure you would like to start a new game?" + "\n" +
                "Type 'start' if you would like to start a new game." + "\n" +
                "Type 'return' if you would like to return to the main menu.");
    }

    /**
     * Assumes input has already been parsed and validated.
     * @param input From the user.
     * Executes when the state is awaiting input.
     */
    @Override
    public void postInput(String input) {
        SwitchEventMediatorProxy.getInstance().store(SwitchEventType.NEW_GAME);
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
     * @return The NewGameInputValidator of this NewGameState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
