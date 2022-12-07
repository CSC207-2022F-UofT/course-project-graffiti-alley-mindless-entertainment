package switch_managers.handlers;

import core.StateManager;
import menus.MenuStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import objects.character.Player;
import objects.inventory.Inventory;
import objects.inventory.InventoryStateFactory;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventType;

class PauseResumeEventHandlerTest {

    @Test
    void handleSwitchEvent() {
        Inventory inventory = new Inventory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        InventoryStateFactory inventoryStateFactory = new InventoryStateFactory(inventory);
        MenuStateFactory menuStateFactory = new MenuStateFactory(changeOptionsStateFactory, inventoryStateFactory);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);

        Player player = new Player("", null);
        PlayerCreatorManager creatorManager = new PlayerCreatorManager(player);

        StateManager pauseSwitch = pauseResumeEventHandler.handleSwitchEvent(SwitchEventType.PAUSE, creatorManager);

        assert (pauseSwitch == pauseMenuManager);

        StateManager resumeSwitch = pauseResumeEventHandler.handleSwitchEvent(SwitchEventType.RESUME, pauseMenuManager);

        assert(resumeSwitch == creatorManager);
    }
}