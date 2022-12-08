package main_menu.states;

import io.InputValidator;
import main_menu.input_validators.NewGameInputValidator;
import org.junit.jupiter.api.Test;


class NewGameStateTest {

    @Test
    void preInput() {
        NewGameState newGame = new NewGameState();
        newGame.preInput();
        assert(newGame.awaitInput());
        assert(!newGame.isDone());
    }

    @Test
    void postInput() {
        NewGameState newGame = new NewGameState();
        newGame.postInput("return");
        assert(!newGame.awaitInput());
        assert(newGame.isDone());
    }

    @Test
    void getInputValidator() {
        NewGameState newGame = new NewGameState();
        InputValidator validator = newGame.getInputValidator();
        assert(validator instanceof NewGameInputValidator);
    }
}