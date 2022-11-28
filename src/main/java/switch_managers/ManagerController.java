package switch_managers;

import core.StateManager;

/**
 * Manager Controller Interface
 * Used to handle switches between managers.
 */
public interface ManagerController {
    public StateManager switchManagers(SwitchEventType type, StateManager currManager);
}