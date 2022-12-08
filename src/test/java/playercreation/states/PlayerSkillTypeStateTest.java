package playercreation.states;

import io.InputValidator;
import objects.character.Player;
import org.junit.jupiter.api.Test;
import playercreation.PlayerCreatorInteractor;
import playercreation.input_validators.PlayerSkillTypeValidator;

class PlayerSkillTypeStateTest {

    @Test
    void preInput() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerSkillTypeState a = new PlayerSkillTypeState(interactor);
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
        PlayerSkillTypeState a = new PlayerSkillTypeState(interactor);
        a.preInput();
        a.postInput("air");
        assert(!a.awaitInput());
        assert(a.isDone());
    }

    @Test
    void getInputValidator() {
        Player player = new Player("", null);
        PlayerCreatorInteractor interactor = new PlayerCreatorInteractor(player);
        PlayerSkillTypeState a = new PlayerSkillTypeState(interactor);
        InputValidator validator = a.getInputValidator();
        assert(validator instanceof PlayerSkillTypeValidator);
    }
}