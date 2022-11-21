package playercreation.factories;

import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;
import playercreation.states.PlayerQuestionState;

public class PlayerQuestionStateFactory {
    /** A factory class for creating new PlayerQuestionStates. Used to avoid dependencies in PlayerCreatorManager.
     * Attributes:
     * interactor: The PlayerCreatorInteractor that saves the Player information.
     */
    private final PlayerCreatorInteractor interactor;

    public PlayerQuestionStateFactory() {
        // Constructs a new PlayerQuestionState with an empty PlayerCreatorInteractor.
        this.interactor = new PlayerCreatorInteractor();
    }

    public PlayerQuestionState createPlayerQuestionState(PlayerQuestion currQuestion) {
        // Returns a new PlayerQuestionState utilizing currQuestion.
        return new PlayerQuestionState(currQuestion, this.interactor);
    }
}
