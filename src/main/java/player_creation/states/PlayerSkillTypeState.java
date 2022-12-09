package player_creation.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import battle.entities.SkillType;
import player_creation.PlayerCreatorInteractor;
import player_creation.input_validators.PlayerSkillTypeValidator;

/**
 * A class for asking the user to give the Player a SkillType.
 */
public class PlayerSkillTypeState implements State {

    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * creatorInteractor: A PlayerCreatorInteractor that is used to store the information from the user until a
     *                    new Player is created at the start of the game.
     * inputValidator: A PlayerSkillTypeValidator that is used to validate the input from the user.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInteractor creatorInteractor;
    private final PlayerSkillTypeValidator inputValidator;

    /**
     * Initializes a new PlayerSkillTypeState.
     * @param creatorInteractor The PlayerCreatorInteractor that saves user input as player creation progresses.
     */
    public PlayerSkillTypeState(PlayerCreatorInteractor creatorInteractor) {
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerSkillTypeValidator();
    }

    /**
     * Utilizes OutputHandler to ask the user to input a SkillType.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("I sense an aura of magic within you. If I may ask, which of the four elements do you" +
                " command? Air, Earth, Fire, or Water?");
    }

    /**
     * Saves user-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been parsed
     * and validated by InputHandler.
     * @param input String input from the user, already parsed and validated.
     */
    @Override
    public void postInput(String input) {
        this.creatorInteractor.addSkillType(SkillType.valueOf(input.toUpperCase()));
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
     * @return The PlayerSkillTypeValidator of this PlayerSkillTypeState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
