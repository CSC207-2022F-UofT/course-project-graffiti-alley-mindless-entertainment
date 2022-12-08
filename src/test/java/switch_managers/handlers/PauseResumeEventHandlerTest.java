package switch_managers.handlers;

import core.StateManager;
import menus.MenuStateFactory;
import menus.PauseMenuManager;
import objects.character.Player;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorManager;
import switch_managers.SwitchEventType;

class PauseResumeEventHandlerTest {

    @Test
    void handleSwitchEvent() {
        MenuStateFactory menuStateFactory = new MenuStateFactory(null, null);
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