package playercreation.states;

import io.InputValidator;
import interfaces.State;
import io.Output;
import io.OutputHandler;
import objects.battle.SkillType;
import playercreation.PlayerCreatorInputValidator;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;

/**
 * A class for the current question being asked of the Player. Implements State in order to take user input.
 */
public class PlayerQuestionState implements State {
    /**
     * currQuestion: The current question to be asked of the user. Is an enum of PlayerQuestion, either NAME,
     *               DESCRIPTION, or SKILLTYPE.
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * creatorInteractor: A PlayerCreatorInteractor that is used to store the information from the user until a
     *                    new Player is created at the start of the game.
     * inputValidator: A PlayerCreatorInputValidator that is used to validate the input from the user.
     */
    private final PlayerQuestion currQuestion;
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInteractor creatorInteractor;
    private final PlayerCreatorInputValidator inputValidator;

    /**
     * Initializes a new PlayerQuestionState.
     * @param currQuestion The current question to ask of the user. An enum of type PlayerQuestion.
     * @param creatorInteractor The PlayerCreatorInteractor that saves user input as player creation progresses.
     */
    public PlayerQuestionState(PlayerQuestion currQuestion, PlayerCreatorInteractor creatorInteractor) {
        this.currQuestion = currQuestion;
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerCreatorInputValidator(this.currQuestion);
    }

    /**
     * @return The current PlayerQuestion.
     */
    public PlayerQuestion getCurrQuestion() {
        return this.currQuestion;
    }

    /**
     * Utilizes OutputHandler to ask the user a question based on the currQuestion.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        if (this.currQuestion == PlayerQuestion.NAME) {
            output.generateText("Welcome, weary traveler. May I ask what your name is?");
        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {
            output.generateText("Nice to meet you! Would you mind telling me a bit about yourself?");
        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {
            output.generateText("I sense an aura of magic within you. If I may ask, which of the four elements do you" +
                    " command? Air, Earth, Fire, or Water?");
        }
    }

    /**
     * Saves uer-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been parsed
     * and validated by InputHandler.
     * @param input String input from the user, already parsed and validated.
     */
    @Override
    public void postInput(String input) {
        if (this.currQuestion == PlayerQuestion.NAME) {
            this.creatorInteractor.addName(input);
            this.isDone = true;
            this.awaitInput = false;
        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {
            this.creatorInteractor.addDescription(input);
            this.isDone = true;
            this.awaitInput = false;
        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {
            this.creatorInteractor.addSkillType(SkillType.valueOf(input.toUpperCase()));
            this.isDone = true;
            this.awaitInput = false;
        }
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
     * @return The PlayerCreatorInputValidator of this PlayerQuestionState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }

}
