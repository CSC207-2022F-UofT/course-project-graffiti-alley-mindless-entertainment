package player_creation;

import core.State;
import character.entities.Player;
import org.junit.jupiter.api.Test;
import player_creation.states.*;

class PlayerCreatorManagerTest {

    @Test
    void initialize() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(a.getCurrState() instanceof PlayerNameState);
    }

    @Test
    void nextStateConfirmAfterName() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        State returnedState = a.nextState("MyName");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.CONFIRM);
        assert(returnedState instanceof PlayerConfirmState);
        assert(a.getCompletedQuestions() == 1);
    }

    @Test
    void nextStateDescriptionAfterConfirmedName() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        a.nextState("MyName");
        State returnedState = a.nextState("confirm");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.DESCRIPTION);
        assert(returnedState instanceof PlayerDescriptionState);
    }

    @Test
    void nextStateNameAfterReturnedConfirm() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        a.nextState("MyName");
        State returnedState = a.nextState("return");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(returnedState instanceof PlayerNameState);
        assert(a.getCompletedQuestions() == 0);
    }

    @Test
    void nextStateSkillAfterConfirmedDescription() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        a.nextState("MyName");
        a.nextState("confirm");
        a.nextState("MyDescription");
        State returnedState = a.nextState("confirm");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.SKILLTYPE);
        assert(returnedState instanceof PlayerSkillTypeState);
        assert(a.getCompletedQuestions() == 2);
    }

    @Test
    void nextStateSkillAfterReturnedConfirm() {
        Player b = new Player("", null);
        PlayerCreatorManager a = new PlayerCreatorManager(b);
        a.nextState("MyName");
        a.nextState("confirm");
        a.nextState("MyDescription");
        a.nextState("confirm");
        a.nextState("air");
        State returnedState = a.nextState("return");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.SKILLTYPE);
        assert(returnedState instanceof PlayerSkillTypeState);
        assert(a.getCompletedQuestions() == 2);
    }
}