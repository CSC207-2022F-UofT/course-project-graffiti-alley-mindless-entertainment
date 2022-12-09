package core.switch_managers.switch_events;

import core.StateManager;

/**
 * SwitchEventHandler. Takes inspiration from the chain of responsibility pattern:
 * If the handler can handle the switch event, then it returns a StateManager, otherwise, returns null.
 * Used in conjunction with the ManagerController to handle all manager switching.
 */
public interface SwitchEventHandler {


    /**
     * @param eventType the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager);

}
