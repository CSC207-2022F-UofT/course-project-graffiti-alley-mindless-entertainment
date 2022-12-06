package game;

import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import main_menu.MainMenuManager;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import playercreation.PlayerCreatorManager;
import switch_managers.ManagerController;
import switch_managers.ManagerControllerImpl;
import switch_managers.SwitchEventManager;
import switch_managers.handlers.MainMenuEventHandler;
import switch_managers.handlers.PauseResumeEventHandler;
import switch_managers.handlers.StartGameEventHandler;

/**
 * Used to create the manager controller for the game.
 */
public class ManagerControllerFactory {

    private final ManagerController managerController;
    private final SwitchEventManager switchEventManager;
    public ManagerControllerFactory() {
        switchEventManager = new SwitchEventManager();
        managerController = new ManagerControllerImpl(switchEventManager);

    }

    /**
     * Creates the manager controller and all switch event handlers.
     * Should only be called once per initialization.
     * @return the manager controller to pass to the shell.
     */
    ManagerController createManagerController() {

        createPauseResumeEventHandler();
        createStartGameEventHandler();
        createMainMenuEventHandler();

        return managerController;
    }

    /**
     * Creates the main menu event handler.
     */
    void createMainMenuEventHandler() {
        MainMenuManager mainMenuManager = new MainMenuManager();
        managerController.addManager(mainMenuManager);

        PlayerCreatorManager playerCreatorManager = new PlayerCreatorManager();
        managerController.addManager(playerCreatorManager);

        MainMenuEventHandler mainMenuEventHandler = new MainMenuEventHandler(mainMenuManager, playerCreatorManager);
        switchEventManager.addSwitchEventHandler(mainMenuEventHandler);
    }

    /**
     * Creates the start game event handler.
     */
    void createStartGameEventHandler() {
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager);
        managerController.addManager(areaManager);

        StartGameEventHandler startGameEventHandler = new StartGameEventHandler(areaManager);
        switchEventManager.addSwitchEventHandler(startGameEventHandler);
    }

    /**
     * Creates the pause resume event handler.
     */
    void createPauseResumeEventHandler() {
        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        PauseMenuManager pauseMenuManager = new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);
        managerController.addManager(pauseMenuManager);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        switchEventManager.addSwitchEventHandler(pauseResumeEventHandler);
    }
}