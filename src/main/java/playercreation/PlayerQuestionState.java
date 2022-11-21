package playercreation;

import io.InputValidator;
import interfaces.State;
import objects.battle.SkillType;

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
        // Awaiting OutputHandler implementation.
        this.awaitInput = true;
        if (this.currQuestion == PlayerQuestion.NAME) {
            return;
        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {
            return;
        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {
            return;
        }
        else {
            return;
        }
    }

    @Override
    public void postInput(String input) {
        // Saves user-inputted Player attributes into the PlayerCreatorInteractor as long as the input is valid.
        if (this.inputValidator.validateInput(input)) {
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
                this.creatorInteractor.addSkillType(SkillType.valueOf(input));
                this.isDone = true;
                this.awaitInput = false;
            }
        }
        else {
            // Input is invalid, awaiting OutputHandler implementation to ask user for valid input.
            return;
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
