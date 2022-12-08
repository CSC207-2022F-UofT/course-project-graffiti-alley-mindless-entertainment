package switch_managers;

import menus.MenuStateFactory;
import menus.PauseMenuManager;
import org.junit.jupiter.api.Test;
import switch_managers.handlers.PauseResumeEventHandler;

class SwitchEventManagerTest {

    @Test
    void switchManagers() {
        SwitchEventManager managerController = new SwitchEventManager();

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) == null);

        MenuStateFactory menuStateFactory = new MenuStateFactory(null, null, null);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) != null);
    }
}