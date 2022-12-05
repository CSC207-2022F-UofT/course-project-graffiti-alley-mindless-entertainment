package switch_managers;

import core.StateManager;

import java.util.ArrayList;
import java.util.List;

public class ManagerControllerImpl implements ManagerController{
    SwitchEventManager switchEventManager;
    List<StateManager> managers;

    public ManagerControllerImpl(SwitchEventManager switchEventManager) {
        this.switchEventManager = switchEventManager;
        this.managers = new ArrayList<>();
    }

    @Override
    public void addManager(StateManager manager) {
        managers.add(manager);
    }


    @Override
    public StateManager switchManagers(SwitchEventType type, StateManager currManager) {
        return switchEventManager.switchManagers(type, currManager);
    }

    @Override
    public void initializeAll() {
        for (StateManager manager: managers) {
            manager.initialize();
        }
    }
}
