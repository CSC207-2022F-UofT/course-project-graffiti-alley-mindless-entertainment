package switch_managers.handlers;

import core.StateManager;
import main_menu.MainMenuManager;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventHandler;
import switch_managers.SwitchEventType;

public class MainMenuEventHandler implements SwitchEventHandler {
    /** SwitchEventHandler for the main menu. Aids Shell in switching StateManagers while the main menu is running.
     * Attributes:
     * mainMenuManager: A MainMenuManager.
     */
    private final MainMenuManager mainMenuManager;

    public MainMenuEventHandler(MainMenuManager mainMenuManager) {
        // Initializes a new MainMenuEventHandler with mainMenuManager.
        this.mainMenuManager = mainMenuManager;
    }

    @Override
    public StateManager handleSwitchEvent(SwitchEventType eventType, StateManager currManager) {
        // Returns a StateManager based on the eventType inputted. Returns null if the eventType cannot be handled.
        switch (eventType) {
            case NEW_GAME:
                return new PlayerCreatorManager();
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
