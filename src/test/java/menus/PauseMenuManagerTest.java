package menus;

import menus.options.ChangeOptionsStateFactory;
import menus.save.SaveMenuStateFactory;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
import options.Options;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import save.SaveInteractor;

class PauseMenuManagerTest {

    private Options options;
    private PauseMenuManager pauseMenuManager;

    @Before
    public void setup() {
        options = Options.getOptions();
        Inventory inventory = new Inventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory(options);
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        SaveInteractor saveInteractor = new SaveInteractor(3);
        SaveMenuStateFactory saveMenuStateFactory = new SaveMenuStateFactory(saveInteractor);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory, saveMenuStateFactory);
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