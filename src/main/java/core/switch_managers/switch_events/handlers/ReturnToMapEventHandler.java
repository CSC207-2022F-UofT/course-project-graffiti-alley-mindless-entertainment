package core.switch_managers.switch_events.handlers;

import core.StateManager;
import core.switch_managers.switch_events.SwitchEventHandler;
import core.switch_managers.switch_events.SwitchEventType;
import game_world.managers.AreaManager;

public class ReturnToMapEventHandler implements SwitchEventHandler {

    private final AreaManager areaManager;


    /**
     * @param areaManager the area manager.
     */
    public ReturnToMapEventHandler(AreaManager areaManager) {
        this.areaManager = areaManager;
    }

    /**
     * @param eventType the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        if (eventType == SwitchEventType.START_GAME || eventType == SwitchEventType.LOAD_GAME || eventType == SwitchEventType.BATTLE_END) {
            return areaManager;
        }
        return null;
    }
}
