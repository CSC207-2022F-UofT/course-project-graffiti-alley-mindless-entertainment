package game;

import battlestates.BattleStateManager;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.AreaManager;
import game_world.managers.EventDatabaseInteractor;
import game_world.managers.EventManager;
import main_menu.MainMenuManager;
import menus.MenuStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import menus.save.SaveMenuStateFactory;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
import playercreation.PlayerCreatorManager;
import save.SaveInteractor;
import switch_managers.ManagerController;
import switch_managers.ManagerControllerImpl;
import switch_managers.SwitchEventManager;
import switch_managers.handlers.EncounterEventHandler;
import switch_managers.handlers.MainMenuEventHandler;
import switch_managers.handlers.PauseResumeEventHandler;
import switch_managers.handlers.ReturnToMapEventHandler;

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
        createReturnToMapEventHandler();
        createMainMenuEventHandler();
        createEncounterEventHandler();

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
    void createReturnToMapEventHandler() {
        Inventory inventory = gameEntities.getInventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);

        EventFactory eventFactory = new EventFactory(itemPickUpEventFactory);
        EventDatabaseInteractor eventDatabaseInteractor = new EventDatabaseInteractor(eventFactory);
        EventManager eventManager = new EventManager(eventDatabaseInteractor);
        AreaManager areaManager = new AreaManager(eventManager, gameEntities.getLocation());
        managerController.addManager(areaManager);

        ReturnToMapEventHandler startGameEventHandler = new ReturnToMapEventHandler(areaManager);
        switchEventManager.addSwitchEventHandler(startGameEventHandler);
    }

    /**
     * Creates the pause resume event handler.
     */
    void createPauseResumeEventHandler() {
        Inventory inventory = gameEntities.getInventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory(gameEntities.getOptions());
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        SaveInteractor saveInteractor = createSaveInteractor();
        SaveMenuStateFactory saveMenuStateFactory = new SaveMenuStateFactory(saveInteractor);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory, saveMenuStateFactory);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);
        managerController.addManager(pauseMenuManager);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        switchEventManager.addSwitchEventHandler(pauseResumeEventHandler);
    }

    /**
     * Use to create a save interactor.
     * @return the SaveInteractor.
     */
    SaveInteractor createSaveInteractor() {
        SaveInteractor saveInteractor = new SaveInteractor(3);
        saveInteractor.addSavableEntity(gameEntities.getLocation());
        saveInteractor.addSavableEntity(gameEntities.getInventory().new SaveInventory());
        saveInteractor.addSavableEntity(gameEntities.getOptions().new SaveOptions());
        saveInteractor.addSavableEntity(gameEntities.getPlayer().new SavePlayer());
        return saveInteractor;
    }

    /**
    * Creates the encounter event handler.
    */
    void createEncounterEventHandler() {
        BattleStateManager battleStateManager = new BattleStateManager(gameEntities.getPlayer(), gameEntities.getLocation());
        managerController.addManager(battleStateManager);

        EncounterEventHandler encounterEventHandler = new EncounterEventHandler(battleStateManager);

        switchEventManager.addSwitchEventHandler(encounterEventHandler);
    }
}