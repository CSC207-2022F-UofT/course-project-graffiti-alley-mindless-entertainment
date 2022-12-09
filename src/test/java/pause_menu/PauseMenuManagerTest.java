package pause_menu;

import pause_menu.options.ChangeOptionsStateFactory;
import pause_menu.quests.QuestMenuFactory;
import pause_menu.save.SaveMenuStateFactory;
import character.entities.Player;
import inventory.entities.Inventory;
import pause_menu.inventory.InventoryStateFactory;
import pause_menu.options.Options;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quests.QuestInteractor;
import save.gateways.SaveGatewayImpl;
import save.use_cases.SaveInteractor;

class PauseMenuManagerTest {

    private Options options;
    private PauseMenuManager pauseMenuManager;

    @BeforeEach
    public void setup() {
        options = Options.getOptions();
        Inventory inventory = new Inventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory(options);
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(3, saveGateway);
        SaveMenuStateFactory saveMenuStateFactory = new SaveMenuStateFactory(saveInteractor);
        QuestInteractor questInteractor = new QuestInteractor(new Player("", null));
        QuestMenuFactory questMenuFactory = new QuestMenuFactory(questInteractor);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory, saveMenuStateFactory, questMenuFactory);
        pauseMenuManager = new PauseMenuManager(menuStateFactory);
    }

    @Test
    public void changeOptionsAndQuit() {

        pauseMenuManager.initialize();
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("options");

        pauseMenuManager.preInput();
        pauseMenuManager.postInput("change autoSave false");

        assert(!options.isEnableAutoSave());
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("return");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("return");
        assert(pauseMenuManager.isDone());
    }

    @Test
    public void viewInventoryAndQuit() {

        pauseMenuManager.initialize();
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("inventory");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("return");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("return");
        assert(pauseMenuManager.isDone());
    }

    @Test
    public void viewSaveAndQuit() {

        pauseMenuManager.initialize();
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("save");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("return");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        assert(pauseMenuManager.awaitInput());
        pauseMenuManager.postInput("return");
        assert(pauseMenuManager.isDone());
    }
}