package core.switch_managers.handlers;

import main_menu.MainMenuManager;
import character.entities.Player;
import org.junit.jupiter.api.Test;
import player_creation.PlayerCreatorManager;
import save.gateways.SaveGatewayImpl;
import save.use_cases.SaveInteractor;
import core.switch_managers.switch_events.SwitchEventType;
import core.switch_managers.switch_events.handlers.MainMenuEventHandler;


class MainMenuEventHandlerTest {

    @Test
    void handleSwitchEvent() {
        SaveGatewayImpl gateway = new SaveGatewayImpl();
        SaveInteractor save = new SaveInteractor(4, gateway);
        MainMenuManager mainMenuManager = new MainMenuManager(save);
        Player player = new Player("", null);
        PlayerCreatorManager playerManager = new PlayerCreatorManager(player);
        MainMenuEventHandler handler = new MainMenuEventHandler(mainMenuManager, playerManager);
        assert(handler.handleSwitchEvent(SwitchEventType.NEW_GAME, mainMenuManager) instanceof PlayerCreatorManager);
        assert(handler.handleSwitchEvent(SwitchEventType.MAIN_MENU, playerManager) instanceof MainMenuManager);
        assert(handler.handleSwitchEvent(SwitchEventType.END_GAME, mainMenuManager) instanceof MainMenuManager);
        assert(handler.handleSwitchEvent(SwitchEventType.BATTLE_END, mainMenuManager) == null);
    }
}