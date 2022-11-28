package switch_managers.handlers;

import core.StateManager;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventType;

class PauseResumeEventHandlerTest {

    @Test
    void handleSwitchEvent() {
        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        PauseMenuManager pauseMenuManager = new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);

        PauseResumeEventHandler pauseResumeEventHandler = new PauseResumeEventHandler(pauseMenuManager);

        PlayerCreatorManager creatorManager = new PlayerCreatorManager();

        StateManager pauseSwitch = pauseResumeEventHandler.handleSwitchEvent(SwitchEventType.PAUSE, creatorManager);

        assert (pauseSwitch == pauseMenuManager);

        StateManager resumeSwitch = pauseResumeEventHandler.handleSwitchEvent(SwitchEventType.RESUME, pauseMenuManager);

        assert(resumeSwitch == creatorManager);
    }
}