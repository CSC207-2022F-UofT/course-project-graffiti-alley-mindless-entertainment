package game;

import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.AreaManager;
import game_world.managers.EventManager;
import main_menu.MainMenuManager;
import menus.MenuStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
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

    private final GameEntities gameEntities;

    public ManagerControllerFactory(GameEntities gameEntities) {
        switchEventManager = new SwitchEventManager();
        managerController = new ManagerControllerImpl(switchEventManager);
        this.gameEntities = gameEntities;

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

        PlayerCreatorManager playerCreatorManager = new PlayerCreatorManager(gameEntities.getPlayer());
        managerController.addManager(playerCreatorManager);

        MainMenuEventHandler mainMenuEventHandler = new MainMenuEventHandler(mainMenuManager, playerCreatorManager);
        switchEventManager.addSwitchEventHandler(mainMenuEventHandler);
    }

    /**
     * Creates the start game event handler.
     */
    void createStartGameEventHandler() {
        Inventory inventory = gameEntities.getInventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);
        EventManager eventManager = new EventManager(itemPickUpEventFactory);
        AreaManager areaManager = new AreaManager(eventManager, gameEntities.getLocation());
        managerController.addManager(areaManager);

        StartGameEventHandler startGameEventHandler = new StartGameEventHandler(areaManager);
        switchEventManager.addSwitchEventHandler(startGameEventHandler);
    }

    /**
     * Creates the pause resume event handler.
     */
    void createPauseResumeEventHandler() {
        Inventory inventory = gameEntities.getInventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory(gameEntities.getOptions());
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);
        managerController.addManager(pauseMenuManager);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        switchEventManager.addSwitchEventHandler(pauseResumeEventHandler);
    }
}