package playercreation;

import interfaces.State;
import core.StateManager;
import objects.character.Player;
import playercreation.factories.PlayerConfirmStateFactory;
import playercreation.factories.PlayerQuestionStateFactory;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.SwitchEventType;

/** A controller class that helps create a new Player character at the beginning of the game.
 */
public class PlayerCreatorManager extends StateManager {
    /**
     * currPlayerQuestion: The current question about the Player character being asked of the user. An enum of
     *                     type PlayerQuestion.
     * currState: The current State saved in the PlayerCreatorManager.
     * completedQuestions: A counter of completed PlayerQuestions. Does not count completed CONFIRM questions.
     * questionStateFactory: A PlayerQuestionStateFactory used to create new questions for the user. Includes methods
     *                       for creating new PlayerNameStates, PlayerDescriptionStates, and PlayerSkillTypeStates.
     * confirmStateFactory: A PlayerConfirmStateFactory used to create new PlayerConfirmStates.
     * creatorInteractor: A PlayerCreatorInteractor to store the Player entity being created.
     * saveInteractor: A SaveInteractor used to save the Player after creation.
     */
    private PlayerQuestion currPlayerQuestion;
    private int completedQuestions;
    private final PlayerQuestionStateFactory questionStateFactory;
    private final PlayerConfirmStateFactory confirmStateFactory;

    /**
     * Initializes a new PlayerCreatorManager with creatorInteractor using player.
     * @param player The Player entity passed into the manager.
     */
    public PlayerCreatorManager(Player player) {
        this.completedQuestions = 0;
        PlayerCreatorInteractor creatorInteractor = new PlayerCreatorInteractor(player);
        this.questionStateFactory = new PlayerQuestionStateFactory(creatorInteractor);
        this.confirmStateFactory = new PlayerConfirmStateFactory();
        initialize();
    }

    /**
     * Helper method for the PlayerCreatorManager.
     */
    @Override
    public void initialize() {
        this.currPlayerQuestion = PlayerQuestion.NAME;
        currState = questionStateFactory.createPlayerNameState();
    }

    /**
     * @return The current PlayerQuestion being asked of the user.
     */
    public PlayerQuestion getCurrPlayerQuestion() {
        return this.currPlayerQuestion;
    }

    /**
     * @return The current State.
     */
    public State getCurrState() {
        return this.currState;
    }

    /**
     * @return The completed questions.
     */
    public int getCompletedQuestions() {
        return this.completedQuestions;
    }

    /**
     * Switches the question state to the next state in order to ask for input from the user. Assumes input has
     * already been parsed and validated by InputHandler.
     * @param input The input from the user, already parsed and validated.
     * @return The next State to be initialized. Returns null if this StateManager has completed asking all questions
     *         of the user to tell Shell to switch to the next StateManager.
     */
    @Override
    protected State nextState(String input) {
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
                    // User has confirmed the choice, uses stateDecider to switch to the next question State.
                    return this.stateDecider();
                }
            }
            else if (input.equals("return")) {
                // User wishes to return to the previous question, uses stateDecider to switch to the previous
                // question State.
                this.completedQuestions -= 1;
                return this.stateDecider();
            }
        }
        return null;
    }

    /**
     * Helper method for nextState. Changes currPlayerQuestion in order to match the currState.
     * @return The State for the question to be asked of the user, which depending on completedQuestions.
     *         0 = PlayerQuestion.NAME, 1 = PlayerQuestion.DESCRIPTION, 2 = PlayerQuestion.SKILLTYPE.
     */
    private State stateDecider() {
        if (this.completedQuestions == 0) {
            this.currPlayerQuestion = PlayerQuestion.NAME;
            this.currState = this.questionStateFactory.createPlayerNameState();
            return this.currState;
        }
        else if (this.completedQuestions == 1) {
            this.currPlayerQuestion = PlayerQuestion.DESCRIPTION;
            this.currState = this.questionStateFactory.createPlayerDescriptionState();
            return this.currState;
        }
        else if (this.completedQuestions == 2) {
            this.currPlayerQuestion = PlayerQuestion.SKILLTYPE;
            this.currState = this.questionStateFactory.createPlayerSkillTypeState();
            return this.currState;
        }
        return null;
    }
}
