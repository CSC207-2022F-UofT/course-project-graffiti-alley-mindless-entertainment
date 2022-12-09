package core.switch_managers.switch_events.handlers;

import battle.BattleStateManager;
import core.StateManager;
import core.switch_managers.switch_events.SwitchEventHandler;
import core.switch_managers.switch_events.SwitchEventType;

public class EncounterEventHandler implements SwitchEventHandler {
    private final BattleStateManager battleStateManager;
    public EncounterEventHandler(BattleStateManager battleStateManager){
        this.battleStateManager = battleStateManager;
    }

    /**
     * @param eventType   the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        if (eventType == SwitchEventType.ENCOUNTER) {
            return battleStateManager;
        }
        return null;
    }
}
