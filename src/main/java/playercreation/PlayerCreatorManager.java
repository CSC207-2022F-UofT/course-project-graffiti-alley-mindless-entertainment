package playercreation;

import interfaces.State;
import core.StateManager;
import playercreation.factories.PlayerConfirmStateFactory;
import playercreation.factories.PlayerQuestionStateFactory;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.SwitchEventType;

public class PlayerCreatorManager extends StateManager {
    /** A controller class that helps create a new Player character at the beginning of the game.
     * Attributes:
     * currPlayerQuestion: The current question about the Player character being asked of the user. An enum of
     *                     type PlayerQuestion.
     * currState: The current State saved in the PlayerCreatorManager.
     * completedQuestions: A counter of completed PlayerQuestions. Does not count completed CONFIRM questions.
     * questionStateFactory: A PlayerQuestionStateFactory used to create new PlayerQuestionStates.
     * confirmStateFactory: A PlayerConfirmStateFactory used to create new PlayerConfirmStates.
     */

    private PlayerQuestion currPlayerQuestion;
    private int completedQuestions;
    private final PlayerQuestionStateFactory questionStateFactory;
    private final PlayerConfirmStateFactory confirmStateFactory;

    public PlayerCreatorManager() {
        // Initializes a new PlayerCreatorManager.
        this.completedQuestions = 0;
        this.questionStateFactory = new PlayerQuestionStateFactory();
        this.confirmStateFactory = new PlayerConfirmStateFactory();
        initialize();
    }

    @Override
    public void initialize() {
        // Initializes the PlayerCreatorManager.
        this.currPlayerQuestion = PlayerQuestion.NAME;
        currState = questionStateFactory.createPlayerQuestionState(currPlayerQuestion);
    }

    public PlayerQuestion getCurrPlayerQuestion() {
        // Return the current PlayerQuestion.
        return this.currPlayerQuestion;
    }

    public State getCurrState() {
        // Return the current State.
        return this.currState;
    }

    public int getCompletedQuestions() {
        // Return the completedQuestions.
        return this.completedQuestions;
    }

    @Override
    protected State nextState(String input) {
        // Switches the question state to the next state in order to ask for more input from the user. Assumes input
        // has already been parsed and validated by InputHandler.
        if (this.currPlayerQuestion == PlayerQuestion.NAME ||
                this.currPlayerQuestion == PlayerQuestion.DESCRIPTION ||
                this.currPlayerQuestion == PlayerQuestion.SKILLTYPE) {
            // Switches the state to confirm if the user confirms the choice.
            this.completedQuestions += 1;
            this.currPlayerQuestion = PlayerQuestion.CONFIRM;
            this.currState = this.confirmStateFactory.createPlayerConfirmState();
            return this.currState;
        } else if (currPlayerQuestion == PlayerQuestion.CONFIRM) {
            // Switches states to the next question if the user confirms their choice, or to return to the previous
            // question if the user is not happy with their choice.
            if (input.equals("confirm")) {
                if (this.completedQuestions == 3) {
                    // PlayerCreatorManager has asked all questions, and Shell switches to a different Manager to start
                    // the game.
                    SwitchEventMediator s = SwitchEventMediatorProxy.getInstance();
                    s.store(SwitchEventType.START_GAME);
                    return null;
                }
                else {
                    // User has confirmed the choice, uses stateDecider to switch to the next PlayerQuestionState.
                    return this.stateDecider();
                }
            }
            else if (input.equals("return")) {
                // User wishes to return to the previous question, uses stateDecider to switch to the previous
                // PlayerQuestionState.
                this.completedQuestions -= 1;
                return this.stateDecider();
            }
        }
        return null;
    }

    private State stateDecider() {
        // Helper method for nextState that returns a PlayerQuestionState depending on this.completedQuestions, and
        // changes currPlayerQuestion in order to match the PlayerQuestionState.
        // 0 = PlayerQuestion.NAME, 1 = PlayerQuestion.DESCRIPTION, 2 = PlayerQuestion.SKILLTYPE.
        if (this.completedQuestions == 0) {
            this.currPlayerQuestion = PlayerQuestion.NAME;
            this.currState = this.questionStateFactory.createPlayerQuestionState(this.currPlayerQuestion);
            return this.currState;
        }
        else if (this.completedQuestions == 1) {
            this.currPlayerQuestion = PlayerQuestion.DESCRIPTION;
            this.currState = this.questionStateFactory.createPlayerQuestionState(this.currPlayerQuestion);
            return this.currState;
        }
        else if (this.completedQuestions == 2) {
            this.currPlayerQuestion = PlayerQuestion.SKILLTYPE;
            this.currState = this.questionStateFactory.createPlayerQuestionState(this.currPlayerQuestion);
            return this.currState;
        }
        return null;
    }
}
