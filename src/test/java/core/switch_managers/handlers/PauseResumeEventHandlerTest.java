package core.switch_managers.handlers;

import core.StateManager;
import pause_menu.MenuStateFactory;
import pause_menu.PauseMenuManager;
import character.entities.Player;
import org.junit.jupiter.api.Test;
import player_creation.PlayerCreatorManager;
import core.switch_managers.switch_events.SwitchEventType;
import core.switch_managers.switch_events.handlers.PauseResumeEventHandler;

class PauseResumeEventHandlerTest {

    @Test
    void handleSwitchEvent() {
        MenuStateFactory menuStateFactory = new MenuStateFactory(null, null, null, null);
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