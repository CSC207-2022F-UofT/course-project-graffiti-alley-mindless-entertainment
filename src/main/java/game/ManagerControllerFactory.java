package game;

import battle.BattleStateManager;
import database.factories.QuestGiverEventFactory;
import game_world.factories.AreaFactory;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.use_cases.AreaDatabaseInteractor;
import game_world.managers.AreaManager;
import game_world.use_cases.EventDatabaseInteractor;
import game_world.managers.EventManager;
import game_world.entities.Location;
import main_menu.MainMenuManager;
import pause_menu.MenuStateFactory;
import pause_menu.PauseMenuManager;
import pause_menu.options.ChangeOptionsStateFactory;
import pause_menu.quests.QuestMenuFactory;
import pause_menu.save.SaveMenuStateFactory;
import character.entities.Player;
import inventory.entities.Inventory;
import pause_menu.inventory.InventoryStateFactory;
import player_creation.PlayerCreatorManager;
import quests.QuestInteractor;
import save.gateways.SaveGatewayImpl;
import save.use_cases.SaveInteractor;
import core.switch_managers.ManagerController;
import core.switch_managers.ManagerControllerImpl;
import core.switch_managers.switch_events.SwitchEventManager;
import core.switch_managers.switch_events.handlers.EncounterEventHandler;
import core.switch_managers.switch_events.handlers.MainMenuEventHandler;
import core.switch_managers.switch_events.handlers.PauseResumeEventHandler;
import core.switch_managers.switch_events.handlers.ReturnToMapEventHandler;

/**
 * Used to create the manager controller for the game.
 */
public class ManagerControllerFactory {

    private final ManagerController managerController;
    private final SwitchEventManager switchEventManager;

    private final AreaDatabaseInteractor areaDatabaseInteractor;
    private final QuestInteractor questInteractor;
    private final GameEntities gameEntities;
    private final SaveInteractor saveInteractor;

    public ManagerControllerFactory(GameEntities gameEntities) {
        switchEventManager = new SwitchEventManager();
        managerController = new ManagerControllerImpl(switchEventManager);
        this.gameEntities = gameEntities;
        questInteractor = new QuestInteractor(gameEntities.getPlayer());
        areaDatabaseInteractor = createAreaDatabaseInteractor();
        saveInteractor = createSaveInteractor();
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
        MainMenuManager mainMenuManager = new MainMenuManager(saveInteractor);
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
        EventManager eventManager = new EventManager();
        AreaManager areaManager = new AreaManager(eventManager, areaDatabaseInteractor, gameEntities.getLocation(), saveInteractor);
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
        SaveMenuStateFactory saveMenuStateFactory = new SaveMenuStateFactory(saveInteractor);
        QuestMenuFactory questMenuFactory = new QuestMenuFactory(questInteractor);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory, saveMenuStateFactory, questMenuFactory);
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
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        Location.SaveLocation saveLocation = gameEntities.getLocation().new SaveLocation(areaDatabaseInteractor);
        SaveInteractor saveInteractor = new SaveInteractor(3, saveGateway);
        saveInteractor.addSavableEntity(saveLocation);
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

    /**
     * Creates the area database interactor.
     * @return the area database interactor
     */
    AreaDatabaseInteractor createAreaDatabaseInteractor() {
        Inventory inventory = gameEntities.getInventory();
        Player.inventory = inventory;
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);

        EventFactory eventFactory = new EventFactory(itemPickUpEventFactory, new QuestGiverEventFactory(questInteractor));
        EventDatabaseInteractor eventDatabaseInteractor = new EventDatabaseInteractor(eventFactory);
        AreaFactory areaFactory = new AreaFactory(eventDatabaseInteractor);
        return new AreaDatabaseInteractor(areaFactory);
    }
}