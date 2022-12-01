package game;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import switch_managers.ManagerControllerImpl;
import core.StateManager;
import switch_managers.ManagerController;
import io.InputHandler;
import io.InputHandlerImpl;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;
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
        //should change to a mainMenuManager when one gets created
        return new PlayerCreatorManager();
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

        return managerController;
    }
}
