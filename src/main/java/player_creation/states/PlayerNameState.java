package player_creation.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import player_creation.PlayerCreatorInteractor;
import player_creation.input_validators.PlayerNameValidator;

/**
 * A class for asking the user to name the Player.
 */
public class PlayerNameState implements State {

    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * creatorInteractor: A PlayerCreatorInteractor that is used to store the information from the user until a
     *                    new Player is created at the start of the game.
     * inputValidator: A PlayerNameValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInteractor creatorInteractor;
    private final PlayerNameValidator inputValidator;

    /**
     * Initializes a new PlayerNameState.
     * @param creatorInteractor The PlayerCreatorInteractor that saves user input as player creation progresses.
     */
    public PlayerNameState(PlayerCreatorInteractor creatorInteractor) {
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerNameValidator();
    }

    /**
     * Utilizes OutputHandler to ask the user to input a name.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Welcome, weary traveler. May I ask what your name is?");
    }

    /**
     * Saves user-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been parsed
     * and validated by InputHandler.
     * @param input String input from the user, already parsed and validated.
     */
    @Override
    public void postInput(String input) {
        this.creatorInteractor.addName(input);
        this.isDone = true;
        this.awaitInput = false;
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
     * @return The PlayerNameValidator of this PlayerNameState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
