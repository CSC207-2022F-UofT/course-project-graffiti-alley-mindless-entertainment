package main_menu;

import core.StateManager;
import interfaces.State;

public class MainMenuManager extends StateManager {
    /** A manager for the main menu.
     * Attributes:
     * currState: The current state of the main menu.
     */
    private State currState;

    public MainMenuManager() {
        // Initializes a new MainMenuManager.
        initialize();
    }

    @Override
    protected State nextState(String input) {
        return null;
    }

    @Override
    public void initialize() {
        // Initializes the first State of the MainMenuManager

    }
}
