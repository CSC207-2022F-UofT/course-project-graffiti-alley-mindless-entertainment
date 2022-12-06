package switch_managers;

import core.StateManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ManagerController.
 */
public class ManagerControllerImpl implements ManagerController{
    SwitchEventManager switchEventManager;
    List<StateManager> managers;

    public ManagerControllerImpl(SwitchEventManager switchEventManager) {
        this.switchEventManager = switchEventManager;
        this.managers = new ArrayList<>();
    }

    /**
     * @param manager The manager to add to the manager controller.
     */
    @Override
    public void addManager(StateManager manager) {
        managers.add(manager);
    }


    /**
     * @param type        the switch event that starts the switch
     * @param currManager the current manager
     * @return the manager to switch to
     */
    @Override
    public StateManager switchManagers(SwitchEventType type, StateManager currManager) {
        return switchEventManager.switchManagers(type, currManager);
    }

    /**
     * Initializes all the managers.
     * Used when starting a game.
     */
    @Override
    public void initializeAll() {
        for (StateManager manager: managers) {
            manager.initialize();
        }
    }
}
