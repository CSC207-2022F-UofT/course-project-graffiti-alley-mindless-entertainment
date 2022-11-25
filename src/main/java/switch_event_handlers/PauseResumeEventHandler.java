package switch_event_handlers;

import core.StateManager;
import core.SwitchEventHandler;
import core.SwitchEventType;
import menus.PauseMenuManager;

public class PauseResumeEventHandler implements SwitchEventHandler {

    /**
     * @param eventType   the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */

    private StateManager prevManager;

    private final PauseMenuManager pauseMenuManager;

    public PauseResumeEventHandler(PauseMenuManager pauseMenuManager) {
        this.pauseMenuManager = pauseMenuManager;
    }

    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        switch (eventType) {
            case PAUSE:
                prevManager = currManager;
                return pauseMenuManager;
            case RESUME:
                StateManager savePrevManager = prevManager;
                prevManager = null;
                return savePrevManager;
            default:
                return null;
        }
    }
}
