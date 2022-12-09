package playercreation.states;

import io.InputValidator;
import objects.character.Player;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorInteractor;
import playercreation.input_validators.PlayerNameValidator;

class PlayerNameStateTest {

    @Test
    void preInput() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerNameState a = new PlayerNameState(interactor);
        assert(!a.awaitInput());
        assert(!a.isDone());
        a.preInput();
        assert(a.awaitInput());
        assert(!a.isDone());
    }

    @Test
    void postInput() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerNameState a = new PlayerNameState(interactor);
        a.preInput();
        a.postInput("name");
        assert(!a.awaitInput());
        assert(a.isDone());
    }

    @Test
    void getInputValidator() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerNameState a = new PlayerNameState(interactor);
        InputValidator validator = a.getInputValidator();
        assert(validator instanceof PlayerNameValidator);
    }
}