package playercreation.factories;

import playercreation.states.PlayerConfirmState;

public class PlayerConfirmStateFactory {
    /** A factory class for creating new PlayerConfirmStates. Used to avoid dependencies in PlayerCreatorManager.
     */

    public PlayerConfirmState createPlayerConfirmState() {
        // Returns a new PlayerConfirmState.
        return new PlayerConfirmState();
    }
}
