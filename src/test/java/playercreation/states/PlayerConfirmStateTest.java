package playercreation.states;

import io.InputValidator;
import org.junit.jupiter.api.Test;
import playercreation.input_validators.PlayerConfirmValidator;

class PlayerConfirmStateTest {

    @Test
    void preInput() {
        PlayerConfirmState a = new PlayerConfirmState();
        a.preInput();
        assert(a.awaitInput());
        assert(!a.isDone());
    }

    @Test
    void postInput() {
        PlayerConfirmState a = new PlayerConfirmState();
        a.preInput();
        a.postInput("confirm");
        assert(!a.awaitInput());
        assert(a.isDone());
    }

    @Test
    void getInputValidator() {
        PlayerConfirmState a = new PlayerConfirmState();
        InputValidator validator = a.getInputValidator();
        assert(validator instanceof PlayerConfirmValidator);
    }
}