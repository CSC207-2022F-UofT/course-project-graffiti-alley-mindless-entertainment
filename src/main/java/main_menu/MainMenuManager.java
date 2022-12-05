package main_menu;

import core.StateManager;
import interfaces.State;
import main_menu.factories.MainMenuFactory;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.SwitchEventType;

/**
 * A manager for the main menu.
 */
public class MainMenuManager extends StateManager {
    /**
     * currState: The current state of the main menu.
     * currStateEnum: Keeps track of the current state of the main menu using the MainMenuOptions enum.
     * menuFactory: The MainMenuFactory. Used to create new States for the main menu while switching States.
     */
    private State currState;
    private MainMenuOptions currStateEnum;
    private final MainMenuFactory menuFactory;

    /**
     * Initializes a new MainMenuManager.
     */
    public MainMenuManager() {
        this.menuFactory = new MainMenuFactory();
        initialize();
    }

    /**
     * Switches the main menu state to the next state based on user input. Assumes input has already been parsed
     * and validated by InputHandler.
     * @param input The input from the user.
     * @return The next State to switch to, or null if the MainMenuManager has no more States to return from the
     *         user input.
     */
    @Override
    protected State nextState(String input) {
        if (currStateEnum == MainMenuOptions.MAINMENU) {
            switch (input) {
                case "new":
                    this.currState = this.menuFactory.createNewGameState();
                    this.currStateEnum = MainMenuOptions.NEW;
                    return this.currState;
                case "load":
                    this.currState = this.menuFactory.createLoadGameState();
                    this.currStateEnum = MainMenuOptions.LOAD;
                    return this.currState;
                case "quit":
                    this.currState = this.menuFactory.createQuitState();
                    this.currStateEnum = MainMenuOptions.QUIT;
                    return this.currState;
            }
        }
        else if (currStateEnum == MainMenuOptions.NEW) {
            if (input.equals("start")) {
                // Switches to the PlayerCreatorManager to start a new game.
                SwitchEventMediator mediator = SwitchEventMediatorProxy.getInstance();
                mediator.store(SwitchEventType.NEW_GAME);
            }
            else if (input.equals("return")) {
                this.currState = this.menuFactory.createMainMenuState();
                this.currStateEnum = MainMenuOptions.MAINMENU;
                return this.currState;
            }
        }
        else if (currStateEnum == MainMenuOptions.LOAD) {
            // Awaiting saving implementation. Will make a loop here to calculate how many saved games there are and
            // load the proper saved game unless the user chooses to return to the main menu.
            if (input.equals("return")) {
                // Returns to the main menu.
                this.currState = this.menuFactory.createMainMenuState();
                this.currStateEnum = MainMenuOptions.MAINMENU;
                return this.currState;
            }

        }
        else if (currStateEnum == MainMenuOptions.QUIT) {
            if (input.equals("return")) {
                this.currState = this.menuFactory.createMainMenuState();
                this.currStateEnum = MainMenuOptions.MAINMENU;
                return this.currState;
            }
            else if (input.equals("quit")) {
                // Shell quits the game
                return null;
            }
        }
        return null;
    }

    /**
     * Initializes the first State of the MainMenuManager, which is the MainMenuState.
     */
    @Override
    public void initialize() {
        this.currState = this.menuFactory.createMainMenuState();
        this.currStateEnum = MainMenuOptions.MAINMENU;
    }
}
