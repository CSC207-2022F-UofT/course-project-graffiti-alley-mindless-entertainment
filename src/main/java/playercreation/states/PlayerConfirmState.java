package playercreation.states;

import io.InputValidator;
import interfaces.State;
import io.Output;
import io.OutputHandler;
import playercreation.PlayerCreatorInputValidator;
import playercreation.PlayerQuestion;

/**
 * A class for the user to either confirm or return to the previous question during Player creation at the start
 * of the game.
 */
public class PlayerConfirmState implements State {
    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A PlayerCreatorInputValidator that is used to validate the user's input for confirming or
     *                 returning to the previous question.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInputValidator inputValidator;

    /**
     * Initializes a new PlayerConfirmState that has not been completed and is not awaiting input.
     */
    public PlayerConfirmState() {
        this.awaitInput = false;
        this.isDone = false;
        this.inputValidator = new PlayerCreatorInputValidator(PlayerQuestion.CONFIRM);
    }

    /**
     * Utilizes OutputHandler to ask the user if they would like to confirm their decision or return to the previous
     * question.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("Are you satisfied with your choice? Type 'confirm' if you are, or 'return' if you" +
                " would like to return to the previous question.");
    }

    /**
     * Assumes the input has been parsed and validated already. Executes after receiving input from the user.
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
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
     * @return The PlayerCreatorInputValidator of this PlayerConfirmState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
