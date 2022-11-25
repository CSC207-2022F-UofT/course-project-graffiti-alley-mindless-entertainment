package interfaces;

import core.StateManager;
import core.SwitchEventType;

public interface ManagerController {
    public StateManager switchManagers(SwitchEventType type, StateManager currManager);
}
