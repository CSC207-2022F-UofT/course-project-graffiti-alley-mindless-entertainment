package main_menu;

import core.StateManager;
import core.State;
import main_menu.factories.MainMenuFactory;
import save.use_cases.SaveInteractor;
import core.switch_managers.switch_events.SwitchEventMediator;
import core.switch_managers.switch_events.SwitchEventMediatorProxy;
import core.switch_managers.switch_events.SwitchEventType;

/**
 * A manager for the main menu.
 */
public class MainMenuManager extends StateManager {
    /**
     * currState: The current state of the main menu.
     * currStateEnum: Keeps track of the current state of the main menu using the MainMenuOptions enum.
     * menuFactory: The MainMenuFactory. Used to create new States for the main menu while switching States.
     * saveInteractor: The SaveInteractor. Used to load saves from the database.
     */
    private MainMenuOptions currStateEnum;
    private final MainMenuFactory menuFactory;

    /**
     * Initializes a new MainMenuManager.
     * @param saveInteractor The SaveInteractor of this main menu manager.
     */
    public MainMenuManager(SaveInteractor saveInteractor) {
        this.menuFactory = new MainMenuFactory(saveInteractor);
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
            // Exiting case is handled by Shell.
            switch (input) {
                case "new":
                    this.currState = this.menuFactory.createNewGameState();
                    this.currStateEnum = MainMenuOptions.NEW;
                    return this.currState;
                case "load":
                    this.currState = this.menuFactory.createLoadGameState();
                    this.currStateEnum = MainMenuOptions.LOAD;
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
            if (input.equals("return")) {
                // Returns to the main menu.
                this.currState = this.menuFactory.createMainMenuState();
                this.currStateEnum = MainMenuOptions.MAINMENU;
                return this.currState;
            }
        }
        else if (input.equalsIgnoreCase("exit")) {
            SwitchEventMediator mediator = SwitchEventMediatorProxy.getInstance();
            mediator.store(SwitchEventType.END_GAME);
        }
        return null;
    }

    /**
     * Initializes the first State of the MainMenuManager, which is the MainMenuState.
     */
    @Override
    public void initialize() {
        currState = this.menuFactory.createMainMenuState();
        this.currStateEnum = MainMenuOptions.MAINMENU;
    }
}
