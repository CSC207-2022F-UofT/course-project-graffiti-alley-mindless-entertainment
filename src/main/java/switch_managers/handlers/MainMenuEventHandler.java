package switch_managers.handlers;

import core.StateManager;
import main_menu.MainMenuManager;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventHandler;
import switch_managers.SwitchEventType;

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
            case LOAD_GAME:
                // Awaiting saving implementation to return an AreaManager based on information from a database.
                return null;
            case MAIN_MENU:
                return mainMenuManager;
            default:
                return null;
        }
    }
}
