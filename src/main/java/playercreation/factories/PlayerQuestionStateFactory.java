package playercreation.factories;

import interfaces.State;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;
import playercreation.states.PlayerQuestionState;

/**
 * A factory class for creating new PlayerQuestionStates. Used to avoid dependencies in PlayerCreatorManager.
 */
public class PlayerQuestionStateFactory {
    /**
     * interactor: The PlayerCreatorInteractor that saves the Player information.
     */
    private final PlayerCreatorInteractor interactor;

    /**
     * Constructs a new PlayerQuestionState with an empty PlayerCreatorInteractor.
     */
    public PlayerQuestionStateFactory() {
        this.interactor = new PlayerCreatorInteractor();
    }

    /**
     * Creates new PlayerQuestionStates based on input.
     * @param currQuestion The current question being asked of the user.
     * @return A new PlayerQuestionState with params currQuestion and this.interactor.
     */
    public State createPlayerQuestionState(PlayerQuestion currQuestion) {
        // Returns a new PlayerQuestionState utilizing currQuestion.
        return new PlayerQuestionState(currQuestion, this.interactor);
    }
}
