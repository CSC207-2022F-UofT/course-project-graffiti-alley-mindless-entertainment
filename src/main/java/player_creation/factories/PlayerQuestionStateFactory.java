package player_creation.factories;

import core.State;
import player_creation.PlayerCreatorInteractor;
import player_creation.states.PlayerDescriptionState;
import player_creation.states.PlayerNameState;
import player_creation.states.PlayerSkillTypeState;

/**
 * A factory class for creating new questions for the user, including methods for creating new PlayerNameStates,
 * PlayerDescriptionStates, and PlayerSkillTypeStates. Used to avoid dependencies in PlayerCreatorManager.
 */
public class PlayerQuestionStateFactory {
    /**
     * interactor: The PlayerCreatorInteractor that saves the Player information.
     */
    private final PlayerCreatorInteractor interactor;

    /**
     * Constructs a new PlayerQuestionStateFactory with creatorInteractor.
     */
    public PlayerQuestionStateFactory(PlayerCreatorInteractor creatorInteractor) {
        this.interactor = creatorInteractor;
    }

    /**
     * Creates a new PlayerNameState.
     * @return A new PlayerNameState with param this.interactor.
     */
    public State createPlayerNameState() {
        return new PlayerNameState(this.interactor);
    }

    /**
     * Creates a new PlayerDescriptionState.
     * @return A new PlayerDescriptionState with param this.interactor.
     */
    public State createPlayerDescriptionState() {
        return new PlayerDescriptionState(this.interactor);
    }

    /**
     * Creates a new PlayerSkillTypeState.
     * @return A new PlayerSkillTypeState with param this.interactor.
     */
    public State createPlayerSkillTypeState() {
        return new PlayerSkillTypeState(this.interactor);
    }
}
