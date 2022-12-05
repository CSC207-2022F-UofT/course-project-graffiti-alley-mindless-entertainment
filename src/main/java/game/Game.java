package game;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import main_menu.MainMenuManager;
import playercreation.PlayerCreatorManager;
import switch_managers.ManagerControllerImpl;
import core.StateManager;
import switch_managers.ManagerController;
import io.InputHandler;
import io.InputHandlerImpl;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.handlers.MainMenuEventHandler;
import switch_managers.handlers.PauseResumeEventHandler;
import switch_managers.handlers.StartGameEventHandler;

public class Game {
    public static void main(String[] args) {

        Game g = new Game();
        g.startGame();

    }

    public void startGame() {
        InputHandler inputHandler = new InputHandlerImpl();
        ManagerController managerController = createManagerController();
        StateManager startingManager = getStartingManager();
        SwitchEventMediator switchEventMediator = SwitchEventMediatorProxy.getInstance();
        Shell s = new Shell(inputHandler, managerController, startingManager, switchEventMediator);
        s.startGame();
    }

    private StateManager getStartingManager() {
        return new MainMenuManager();
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
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        StartGameEventHandler startGameEventHandler = new StartGameEventHandler(areaManager);
        managerController.addSwitchEventHandler(startGameEventHandler);

        MainMenuManager mainMenuManager = new MainMenuManager();
        PlayerCreatorManager playerCreatorManager = new PlayerCreatorManager();
        MainMenuEventHandler mainMenuEventHandler = new MainMenuEventHandler(mainMenuManager, playerCreatorManager);
        managerController.addSwitchEventHandler(mainMenuEventHandler);

        return managerController;
    }
}
