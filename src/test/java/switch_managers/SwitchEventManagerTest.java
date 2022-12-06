package switch_managers;

import menus.MenuStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
import org.junit.jupiter.api.Test;
import switch_managers.handlers.PauseResumeEventHandler;

class SwitchEventManagerTest {

    @Test
    void switchManagers() {
        SwitchEventManager managerController = new SwitchEventManager();

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) == null);

        Inventory inventory = new Inventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) != null);
    }
}