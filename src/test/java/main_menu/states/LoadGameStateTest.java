package main_menu.states;

import io.InputValidator;
import main_menu.input_validators.LoadGameInputValidator;
import org.junit.jupiter.api.Test;
import save.gateways.SaveGatewayImpl;
import save.use_cases.SaveInteractor;


class LoadGameStateTest {

    @Test
    void preInputCases() {
        SaveGatewayImpl gateway = new SaveGatewayImpl();
        SaveInteractor interactor = new SaveInteractor(3, gateway);
        LoadGameState load = new LoadGameState(interactor);
        load.preInput();
        assert(load.awaitInput());
        assert(!load.isDone());
    }

    @Test
    void postInputCases() {
        SaveGatewayImpl gateway = new SaveGatewayImpl();
        SaveInteractor interactor = new SaveInteractor(3, gateway);
        LoadGameState load = new LoadGameState(interactor);
        load.postInput("return");
        assert(!load.awaitInput());
        assert(load.isDone());
        LoadGameState load2 = new LoadGameState(interactor);
        load2.postInput("1");
        assert(!load2.awaitInput());
        assert(load2.isDone());
    }

    @Test
    void getInputValidatorCases() {
        SaveGatewayImpl gateway = new SaveGatewayImpl();
        SaveInteractor interactor = new SaveInteractor(3, gateway);
        LoadGameState load = new LoadGameState(interactor);
        InputValidator validator = load.getInputValidator();
        assert(validator instanceof LoadGameInputValidator);
    }
}