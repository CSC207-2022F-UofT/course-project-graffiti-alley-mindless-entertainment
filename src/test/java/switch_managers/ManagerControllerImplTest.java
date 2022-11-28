package switch_managers;

import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import org.junit.jupiter.api.Test;
import switch_managers.handlers.PauseResumeEventHandler;

class ManagerControllerImplTest {

    @Test
    void switchManagers() {
        ManagerControllerImpl managerController = new ManagerControllerImpl();

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) == null);

        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        PauseMenuManager pauseMenuManager = new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);
        managerController.addSwitchEventHandler(pauseResumeEventHandler);

        assert(managerController.switchManagers(SwitchEventType.PAUSE, null) != null);
    }
}