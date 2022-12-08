package playercreation.states;

import io.InputValidator;
import objects.character.Player;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorInteractor;
import playercreation.input_validators.PlayerDescriptionValidator;

class PlayerDescriptionStateTest {

    @Test
    void preInput() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerDescriptionState a = new PlayerDescriptionState(interactor);
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
        PlayerDescriptionState a = new PlayerDescriptionState(interactor);
        a.preInput();
        a.postInput("description");
        assert(a.isDone());
        assert(!a.awaitInput());
    }

    @Test
    void getInputValidator() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerDescriptionState a = new PlayerDescriptionState(interactor);
        InputValidator validator = a.getInputValidator();
        assert(validator instanceof PlayerDescriptionValidator);
    }
}