package switch_managers;

import core.StateManager;

/**
 * Manager Controller Interface
 * Used to handle switches between managers.
 */
public interface ManagerController {
    /**
     * Iterates through the switchEventHandlers and calls handleSwitchEvent until one handler does not return null
     * Returns that StateManager.
     * @param type the switch event that starts the switch
     * @param currManager the current manager
     * @return the next manager
     */
    StateManager switchManagers(SwitchEventType type, StateManager currManager);

    /**
     * Initializes all the managers.
     * Used when starting a game.
     */
    void initializeAll();

    /**
     * @param manager The manager to add to the manager controller.
     */
    void addManager(StateManager manager);
}
