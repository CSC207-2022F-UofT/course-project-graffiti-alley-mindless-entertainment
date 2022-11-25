package core;

import javax.swing.plaf.nimbus.State;

public interface SwitchEventHandler {


    /**
     * @param eventType the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager);

}
