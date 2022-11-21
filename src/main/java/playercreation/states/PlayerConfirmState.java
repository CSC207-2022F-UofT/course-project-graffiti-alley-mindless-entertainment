package playercreation.states;

import io.InputValidator;
import interfaces.State;
import io.OutputHandlerImpl;
import playercreation.PlayerCreatorInputValidator;
import playercreation.PlayerQuestion;

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
        this.awaitInput = true;
        OutputHandlerImpl output = OutputHandlerImpl.getScreen();
        output.generateText("Are you satisfied with your choice? Type 'confirm' if you are, or 'return' if you" +
                " would like to return to the previous question.");
    }

    @Override
    public void postInput(String input) {
        // Assumes the input has been parsed and validated already.
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
