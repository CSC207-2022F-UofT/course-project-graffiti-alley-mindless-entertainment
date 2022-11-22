package game_world.states;

import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;
import playercreation.states.PlayerQuestionState;

public class WorldStateFactory {
    /** A factory class for creating new WorldStates. Used to avoid dependencies in PlayerCreatorManager.
     * Attributes:
     * interactor: The PlayerCreatorInteractor that saves the Player information.
     */
    private final PlayerCreatorInteractor interactor;

    public WorldStateFactory() {
        // Constructs a new PlayerQuestionState with an empty PlayerCreatorInteractor.
        this.interactor = new PlayerCreatorInteractor();
    }

    public PlayerQuestionState createPlayerQuestionState(PlayerQuestion currQuestion) {
        // Returns a new PlayerQuestionState utilizing currQuestion.
        return new PlayerQuestionState(currQuestion, this.interactor);
    }
}
