package switch_managers.handlers;

import core.StateManager;
import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventHandler;
import switch_managers.SwitchEventType;

public class PlayerCreatorEventHandler implements SwitchEventHandler {
    /** A SwitchEventHandler for player creation. Aids Shell in switching StateManagers when player creation is
     * finished running.
     * Attributes:
     * playerCreatorManager: A PlayerCreatorManager.
     */
    private final PlayerCreatorManager playerCreatorManager;

    public PlayerCreatorEventHandler(PlayerCreatorManager playerCreatorManager) {
        // Initializes a new PlayerCreatorEventHandler with playerCreatorManager.
        this.playerCreatorManager = playerCreatorManager;
    }

    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        // Returns a StateManager based on the eventType inputted. Returns null if the eventType cannot be handled.
        switch (eventType) {
            case NEW_GAME:
                return this.playerCreatorManager;
            case PLAYER_CREATED:
                EventManager eventManager = new EventManager();
                return new AreaManager(eventManager);
            default:
                return null;
        }
    }
}
