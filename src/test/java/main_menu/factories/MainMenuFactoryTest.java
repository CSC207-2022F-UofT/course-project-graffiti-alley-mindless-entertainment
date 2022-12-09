package main_menu.factories;

import core.State;
import main_menu.states.LoadGameState;
import main_menu.states.MainMenuState;
import main_menu.states.NewGameState;
import org.junit.jupiter.api.Test;
import save.gateways.SaveGatewayImpl;
import save.use_cases.SaveInteractor;

class MainMenuFactoryTest {

    @Test
    void createMainMenuState() {
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(2, saveGateway);
        MainMenuFactory factory = new MainMenuFactory(saveInteractor);
        State mainMenu = factory.createMainMenuState();
        assert(mainMenu != null);
        assert(mainMenu instanceof MainMenuState);
    }

    @Test
    void createLoadGameState() {
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(2, saveGateway);
        MainMenuFactory factory = new MainMenuFactory(saveInteractor);
        State loadState = factory.createLoadGameState();
        assert(loadState != null);
        assert(loadState instanceof LoadGameState);
    }

    @Test
    void createNewGameState() {
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(2, saveGateway);
        MainMenuFactory factory = new MainMenuFactory(saveInteractor);
        State newState = factory.createNewGameState();
        assert(newState != null);
        assert(newState instanceof NewGameState);
    }
}