package switch_managers;

import core.StateManager;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller that handles switching between managers.
 * Takes inspiration from chain of responsibility pattern.
 */
public class ManagerControllerImpl implements ManagerController {


    /**
     * Switch event handlers that will be called when switching managers.
     */
    private final List<SwitchEventHandler> switchEventHandlers;

    public ManagerControllerImpl() {
        switchEventHandlers = new ArrayList<>();
    }


    /**
     * Adds a handler to the list of switch event handlers.
     * @param handler the handler to add
     */
    public void addSwitchEventHandler(SwitchEventHandler handler) {
        switchEventHandlers.add(handler);
    }
    /**
     * Iterates through the switchEventHandlers and calls handleSwitchEvent until one handler does not return null
     * Returns that StateManager.
     * @param eventType the switch event that starts the switch
     * @param currManager the current manager
     * @return the next manager
     */
    @Override
    public StateManager switchManagers(SwitchEventType eventType, StateManager currManager) {
        for (SwitchEventHandler handler: switchEventHandlers) {
            StateManager s = handler.handleSwitchEvent(eventType, currManager);
            if (s != null) {
                return s;
            }
        }
        return null;
    }
}
