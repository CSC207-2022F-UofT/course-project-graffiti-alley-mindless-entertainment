package playercreation;

import interfaces.InputValidator;
import interfaces.State;

public class PlayerQuestionState implements State {
    /** A class for the current question being asked of the Player. Implements State in order to take user input.
     * Attributes:
     * currQuestion: The current question to be asked of the user. Is an enum of PlayerQuestion, either NAME,
     *               DESCRIPTION, or SKILLTYPE.
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     */
    private final PlayerQuestion currQuestion;
    private boolean awaitInput;
    private boolean isDone;

    public PlayerQuestionState(PlayerQuestion currQuestion) {
        // Initializes a new PlayerQuestionState with currQuestion.
        this.currQuestion = currQuestion;
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        // Utilizes OutputHandler to ask the Player a question based on the currQuestion.
        this.awaitInput = true;
        if (this.currQuestion == PlayerQuestion.NAME) {

        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {

        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {

        }
        else {

        }
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
        return new PlayerCreatorInputValidator(currQuestion);
    }

}
