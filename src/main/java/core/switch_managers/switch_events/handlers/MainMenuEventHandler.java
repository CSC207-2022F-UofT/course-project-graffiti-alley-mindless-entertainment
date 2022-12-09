package core.switch_managers.switch_events.handlers;

import core.StateManager;
import core.switch_managers.switch_events.SwitchEventHandler;
import core.switch_managers.switch_events.SwitchEventType;
import main_menu.MainMenuManager;
import player_creation.PlayerCreatorManager;

/**
 * SwitchEventHandler for the main menu. Aids Shell in switching StateManagers while the main menu is running.
 */
public class MainMenuEventHandler implements SwitchEventHandler {
    /**
     * mainMenuManager: A MainMenuManager.
     * playerCreatorManager: A PlayerCreatorManager.
     */
    private final MainMenuManager mainMenuManager;
    private final PlayerCreatorManager playerCreatorManager;

    /**
     * Initializes a new MainMenuEventHandler with mainMenuManager.
     * @param mainMenuManager The MainMenuManager of this MainMenuEventHandler.
     * @param playerCreatorManager The PlayerCreatorManager of this MainMenuEventHandler.
     */
    public MainMenuEventHandler(MainMenuManager mainMenuManager, PlayerCreatorManager playerCreatorManager) {
        this.mainMenuManager = mainMenuManager;
        this.playerCreatorManager = playerCreatorManager;
    }

    /**
     * Gives the next StateManager to Shell based on user inputs.
     * @param eventType The switch event to handle.
     * @param currManager The current manager.
     * @return A StateManager based on the eventType inputted. Returns null if the eventType cannot be handled.
     */
    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        switch (eventType) {
            case NEW_GAME:
                return this.playerCreatorManager;
            case MAIN_MENU:
            case END_GAME:
                return mainMenuManager;
            default:
                return null;
        }
    }
}
