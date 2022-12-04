package switch_managers.handlers;

import core.StateManager;
import io.Message;
import io.Output;
import switch_managers.SwitchEventHandler;
import switch_managers.SwitchEventType;
import menus.PauseMenuManager;

/**
 * Handler for PAUSE and RESUME events.
 */
public class PauseResumeEventHandler implements SwitchEventHandler {

    /**
     * prevManager: the manager to return to after pausing.
     * pauseMenuManager: the manager for the pause menu.
     */
    private StateManager prevManager;

    private final PauseMenuManager pauseMenuManager;

    private Message lastMessage;
    /**
     * @param pauseMenuManager the pause menu manager.
     */
    public PauseResumeEventHandler(PauseMenuManager pauseMenuManager) {
        this.pauseMenuManager = pauseMenuManager;
    }

    /**
     * @param eventType the switch event to handle
     * @param currManager the current manager
     * @return the manager to switch to, or null if this handler cannot handle the event
     */
    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        switch (eventType) {
            case PAUSE:
                lastMessage = Output.getScreen().getLastMessage();
                prevManager = currManager;
                return pauseMenuManager;
            case RESUME:
                StateManager savePrevManager = prevManager;
                prevManager = null;
                Output.getScreen().generateText(lastMessage);
                lastMessage = null;
                return savePrevManager;
            default:
                return null;
        }
    }
}
