package managers;

import database.interfaces.State;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;
import playercreation.PlayerQuestionState;
import playercreation.PlayerConfirmState;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerCreatorManager extends StateManager {
    /** A controller class that helps create a new Player character at the beginning of the game.
     * Attributes:
     * currPlayerQuestion: The current question about the Player character being asked of the user. An enum of
     *                     type PlayerQuestion.
     * completedQuestions: A List of completed PlayerQuestions that have already been filled by the user. Does not
     *                     include CONFIRM or COMPLETE.
     * creatorInteractor: A PlayerCreatorInteractor that stores information about the Player until all questions have
     *                    been answered by the user.
     */

    private PlayerQuestion currPlayerQuestion;
    private final ArrayList<PlayerQuestion> completedQuestions;
    private final PlayerCreatorInteractor creatorInteractor;

    public PlayerCreatorManager() {
        // Initializes a new PlayerCreatorManager.
        this.completedQuestions = new ArrayList<>();
        this.creatorInteractor = new PlayerCreatorInteractor();
        initialize();
    }

    @Override
    public void initialize() {
        // Initializes the PlayerCreatorManager.
        currPlayerQuestion = PlayerQuestion.NAME;
        currState = new PlayerQuestionState(currPlayerQuestion, this.creatorInteractor);
    }

    public PlayerQuestion getCurrPlayerQuestion() {
        // Return the current PlayerQuestion.
        return this.currPlayerQuestion;
    }

    public State getCurrState() {
        // Return the current State.
        return this.currState;
    }

    public ArrayList<PlayerQuestion> getCompletedQuestions() {
        // Return the completedQuestions.
        return this.completedQuestions;
    }

    @Override
    public State nextState(String input) {
        // Switches the question state to the next state in order to ask for more input from the user.
        String confirmChoice = "confirm";
        String returnChoice = "return";
        if (currPlayerQuestion == PlayerQuestion.NAME ||
                currPlayerQuestion == PlayerQuestion.DESCRIPTION ||
                currPlayerQuestion == PlayerQuestion.SKILLTYPE) {
            // Switches the state to confirm if the user confirms the choice.
            this.completedQuestions.add(currPlayerQuestion);
            currPlayerQuestion = PlayerQuestion.CONFIRM;
            return new PlayerConfirmState();
        }

        else if (currPlayerQuestion == PlayerQuestion.CONFIRM) {
            // Switches states to the next question if the user confirms their choice, or to return to the previous
            // question if the user is not happy with their choice.
            if (Objects.equals(input, confirmChoice)) {
                if (completedQuestions.size() == 1) {
                    currPlayerQuestion = PlayerQuestion.DESCRIPTION;
                    return new PlayerQuestionState(currPlayerQuestion, this.creatorInteractor);
                }
                else if (completedQuestions.size() == 2) {
                    currPlayerQuestion = PlayerQuestion.SKILLTYPE;
                    return new PlayerQuestionState(currPlayerQuestion, this.creatorInteractor);
                }
                else if (completedQuestions.size() == 3) {
                    // PlayerCreatorManager has asked all questions, and Shell switches to a different Manager to start
                    // the game.
                    // Awaiting Shell implementation.
                    return null;
                }
            }
            else if (Objects.equals(input, returnChoice)) {
                // Return to the previous state since the user did not confirm the previous decision.
                int lastIndex = completedQuestions.size() - 1;
                currPlayerQuestion = completedQuestions.remove(lastIndex);
                return new PlayerQuestionState(currPlayerQuestion, this.creatorInteractor);
            }

        }

        return null;
    }

}
