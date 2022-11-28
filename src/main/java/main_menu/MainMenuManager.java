package main_menu;

import core.StateManager;
import interfaces.State;
import main_menu.factories.MainMenuFactory;
import main_menu.states.LoadGameState;
import main_menu.states.MainMenuState;
import main_menu.states.NewGameState;
import main_menu.states.QuitState;

public class MainMenuManager extends StateManager {
    /** A manager for the main menu.
     * Attributes:
     * currState: The current state of the main menu.
     * menuFactory: The MainMenuFactory. Used to create new States for the main menu while switching States.
     */
    private State currState;
    private final MainMenuFactory menuFactory;

    public MainMenuManager() {
        // Initializes a new MainMenuManager.
        this.menuFactory = new MainMenuFactory();
        initialize();
    }

    @Override
    protected State nextState(String input) {
        // Switches the main menu state to the next state based on user input. Assumes input has already been parsed
        // and validated by InputHandler.
        if (currState instanceof MainMenuState) {
            if (input.equals("new")) {
                this.currState = this.menuFactory.createNewGameState();
                return this.currState;
            }
            else if (input.equals("load")) {
                this.currState = this.menuFactory.createLoadGameState();
                return this.currState;
            }
            else if (input.equals("quit")) {
                this.currState = this.menuFactory.createQuitState();
                return this.currState;
            }
        }
        else if (currState instanceof NewGameState || currState instanceof LoadGameState) {
            if (input.equals("save1") ||
                    input.equals("save2") ||
                    input.equals("save3")) {
                // Shell switches to PlayerCreatorManager to start a new game.
                return null;
            }
            else if (input.equals("return")) {
                this.currState = this.menuFactory.createMainMenuState();
                return this.currState;
            }
        }
        else if (currState instanceof QuitState) {
            if (input.equals("return")) {
                this.currState = this.menuFactory.createMainMenuState();
                return this.currState;
            }
            else if (input.equals("quit")) {
                // Shell quits the game
                return null;
            }
        }
        return null;
    }

    @Override
    public void initialize() {
        // Initializes the first State of the MainMenuManager, which is the MainMenuState.
        this.currState = this.menuFactory.createMainMenuState();
    }
}
