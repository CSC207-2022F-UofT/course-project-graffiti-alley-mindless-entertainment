package menus;

import menus.options.ChangeOptionsStateFactory;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
import options.Options;
import org.junit.jupiter.api.Test;

class PauseMenuManagerTest {

    @Test
    void changeOptionsAndQuit() {
        Options options = Options.getOptions();
        Inventory inventory = new Inventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);
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
}