package core;

import interfaces.ManagerController;
import menus.PauseMenuManager;
import playercreation.PlayerCreatorManager;

import java.util.ArrayList;
import java.util.List;

public class ManagerControllerImpl implements ManagerController {

    private List<SwitchEventHandler> switchEventHandlers;

    public ManagerControllerImpl() {
        switchEventHandlers = new ArrayList<>();
    }


    public void addSwitchEventHandler(SwitchEventHandler h) {
        switchEventHandlers.add(h);
    }
    /**
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
