package playercreation.states;

import io.InputValidator;
import interfaces.State;
import io.Output;
import io.OutputHandler;
import objects.battle.SkillType;
import playercreation.PlayerCreatorInputValidator;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;

public class PlayerQuestionState implements State {
    /** A class for the current question being asked of the Player. Implements State in order to take user input.
     * Attributes:
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

    public PlayerQuestionState(PlayerQuestion currQuestion, PlayerCreatorInteractor creatorInteractor) {
        // Initializes a new PlayerQuestionState with currQuestion.
        this.currQuestion = currQuestion;
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerCreatorInputValidator(this.currQuestion);
    }

    public PlayerQuestion getCurrQuestion() {
        // Return the current PlayerQuestion.
        return this.currQuestion;
    }

    @Override
    public void preInput() {
        // Utilizes OutputHandler to ask the user a question based on the currQuestion.
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

    @Override
    public void postInput(String input) {
        // Saves user-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been
        // parsed and validated.
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
