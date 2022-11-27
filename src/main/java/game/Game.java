package game;

import switch_managers.ManagerControllerImpl;
import core.StateManager;
import switch_managers.ManagerController;
import io.InputHandler;
import io.InputHandlerImpl;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import playercreation.PlayerCreatorManager;
import switch_managers.handlers.PauseResumeEventHandler;

public class Game {
    public static void main(String[] args) {

        Game g = new Game();
        g.startGame();

    }

    public void startGame() {
        InputHandler inputHandler = new InputHandlerImpl();
        ManagerController managerController = createManagerController();
        StateManager startingManager = getStartingManager();
        Shell s = new Shell(inputHandler, managerController, startingManager);
        s.startGame();
    }

    private StateManager getStartingManager() {
        //should change to a mainMenuManager when one gets created
        PlayerCreatorManager playerCreatorManager = new PlayerCreatorManager();
        //playerCreatorManager.initialize();
        return playerCreatorManager;
    }

    /**
     * Creates the manager controller and all switch event handlers.
     * @return the manager controller to pass to the shell.
     */
    public ManagerController createManagerController() {
        ManagerControllerImpl managerController = new ManagerControllerImpl();

        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        PauseMenuManager pauseMenuManager = new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        return managerController;
    }
}
