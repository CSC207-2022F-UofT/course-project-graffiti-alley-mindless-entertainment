package switch_managers.handlers;

import core.StateManager;
import game_world.managers.AreaManager;
import switch_managers.SwitchEventHandler;
import switch_managers.SwitchEventType;

public class StartGameEventHandler implements SwitchEventHandler {

    private final AreaManager areaManager;


    /**
     * @param areaManager the area manager.
     */
    public StartGameEventHandler(AreaManager areaManager) {
        this.areaManager = areaManager;
    }

    /**
     * @param eventType the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        if (eventType == SwitchEventType.START_GAME) {
            return areaManager;
        }
        return null;
    }
}
