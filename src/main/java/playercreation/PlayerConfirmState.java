package playercreation;

import database.interfaces.InputValidator;
import database.interfaces.State;

public class PlayerConfirmState implements State {
    /** A class for the user to either confirm or return to the previous question during Player creation at the
     * start of the game.
     * Attributes:
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A PlayerCreatorInputValidator that is used to validate the user's input for confirming or
     *                 returning to the previous question.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInputValidator inputValidator;

    public PlayerConfirmState() {
        // Initializes a new PlayerConfirmState that has not been completed and is not awaiting input.
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new PlayerCreatorInputValidator(PlayerQuestion.CONFIRM);
    }

    @Override
    public void preInput() {
        // Utilizes OutputHandler to ask the user if they would like to confirm their decision or return to the
        // previous question.
        // Awaiting OutputHandler implementation.
        this.awaitInput = true;
    }

    @Override
    public void postInput(String input) {
        // Takes user input and validates it using inputValidator.
        if (this.inputValidator.validateInput(input)) {
            this.awaitInput = false;
            this.isDone = true;
        }
        else {
            // Input is invalid, use OutputHandler to ask user to input valid statements.
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
