package main_menu.states;

import io.InputValidator;
import main_menu.input_validators.MainMenuInputValidator;
import org.junit.jupiter.api.Test;


class MainMenuStateTest {

    @Test
    void preInput() {
        MainMenuState menu = new MainMenuState();
        menu.preInput();
        assert(menu.awaitInput());
        assert(!menu.isDone());
    }

    @Test
    void postInput() {
        MainMenuState menu = new MainMenuState();
        menu.postInput("load");
        assert(!menu.awaitInput());
        assert(menu.isDone());
    }

    @Test
    void getInputValidator() {
        MainMenuState menu = new MainMenuState();
        InputValidator validator = menu.getInputValidator();
        assert(validator instanceof MainMenuInputValidator);
    }
}