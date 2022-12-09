package core.switch_managers;

import pause_menu.MenuStateFactory;
import pause_menu.PauseMenuManager;
import org.junit.jupiter.api.Test;
import core.switch_managers.switch_events.SwitchEventManager;
import core.switch_managers.switch_events.SwitchEventType;
import core.switch_managers.switch_events.handlers.PauseResumeEventHandler;

class SwitchEventManagerTest {

    @Test
    void switchManagers() {
        SwitchEventManager managerController = new SwitchEventManager();

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) == null);

        MenuStateFactory menuStateFactory = new MenuStateFactory(null, null, null, null);
        PauseMenuManager pauseMenuManager = new PauseMenuManager(menuStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) != null);
    }
}