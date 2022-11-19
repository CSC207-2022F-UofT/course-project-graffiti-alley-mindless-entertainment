package managers;

import interfaces.State;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;
import playercreation.PlayerQuestionState;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreatorManager extends StateManager {
    /** A controller class that helps create a new Player character at the beginning of the game.
     * Attributes:
     * currPlayerQuestion: The current question about the Player character being asked of the user. An enum of
     *                     type PlayerQuestion.
     * completedQuestions: A List of completed PlayerQuestions that have already been filled by the user. Does not
     *                     include CONFIRM or RETURN.
     * confirmChoice: A string representing a user confirming the choice.
     * returnChoice: A string representing a user wanting to return to the previous question.
     * creatorInteractor: A PlayerCreatorInteractor that stores information about the Player until all questions have
     *                    been answered by the user.
     */

    private PlayerQuestion currPlayerQuestion;
    private List<PlayerQuestion> completedQuestions;
    private final String confirmChoice = "confirm";
    private final String returnChoice = "return";
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
        currState = new PlayerQuestionState(currPlayerQuestion);
    }

    @Override
    public State nextState(String input) {
        // Switches the question state to the next state in order to ask for more input from the user.

        if (currPlayerQuestion == PlayerQuestion.NAME ||
                currPlayerQuestion == PlayerQuestion.DESCRIPTION ||
                currPlayerQuestion == PlayerQuestion.SKILLTYPE) {
            // Switches the state to ask the user different questions about their Player.
            return null;

        }

        else if (currPlayerQuestion == PlayerQuestion.RETURN) {
            // Return to the previous state if the user is not satisfied with the previous decision.
            return null;

        }

        else if (currPlayerQuestion == PlayerQuestion.CONFIRM) {
            // Ask the user to confirm their choice.
            return null;

        }

        return null;
    }

}
