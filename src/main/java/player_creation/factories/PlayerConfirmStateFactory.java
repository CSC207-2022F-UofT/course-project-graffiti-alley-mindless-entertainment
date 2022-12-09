package player_creation.factories;

import player_creation.states.PlayerConfirmState;

/**
 * A factory class for creating new PlayerConfirmStates. Used to avoid dependencies in PlayerCreatorManager.
 */
public class PlayerConfirmStateFactory {

    /**
     * @return A new PlayerConfirmState.
     */
    public PlayerConfirmState createPlayerConfirmState() {
        return new PlayerConfirmState();
    }
}
