package player_creation.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import player_creation.PlayerCreatorInteractor;
import player_creation.input_validators.PlayerDescriptionValidator;

/**
 * A class for asking the user to describe the Player.
 */
public class PlayerDescriptionState implements State {

    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * creatorInteractor: A PlayerCreatorInteractor that is used to store the information from the user until a
     *                    new Player is created at the start of the game.
     * inputValidator: A PlayerDescriptionValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInteractor creatorInteractor;
    private final PlayerDescriptionValidator inputValidator;

    /**
     * Initializes a new PlayerDescriptionState.
     * @param creatorInteractor The PlayerCreatorInteractor that saves user input as player creation progresses.
     */
    public PlayerDescriptionState(PlayerCreatorInteractor creatorInteractor) {
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerDescriptionValidator();
    }

    /**
     * Utilizes OutputHandler to ask the user to input a description.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Nice to meet you! Would you mind telling me a bit about yourself?");
    }

    /**
     * Saves user-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been parsed
     * and validated by InputHandler.
     * @param input String input from the user, already parsed and validated.
     */
    @Override
    public void postInput(String input) {
        this.creatorInteractor.addDescription(input);
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
     * @return The PlayerDescriptionValidator of this PlayerDescriptionState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
