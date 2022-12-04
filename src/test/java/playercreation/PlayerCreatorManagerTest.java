package playercreation;

import interfaces.State;
import org.junit.jupiter.api.Test;
import playercreation.states.*;

class PlayerCreatorManagerTest {

    @Test
    void initialize() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(a.getCurrState() instanceof PlayerNameState);
    }

    @Test
    void nextStateConfirmAfterName() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        State returnedState = a.nextState("MyName");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.CONFIRM);
        assert(returnedState instanceof PlayerConfirmState);
        assert(a.getCompletedQuestions() == 1);
    }

    @Test
    void nextStateDescriptionAfterConfirmedName() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        a.nextState("MyName");
        State returnedState = a.nextState("confirm");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.DESCRIPTION);
        assert(returnedState instanceof PlayerDescriptionState);
    }

    @Test
    void nextStateNameAfterReturnedConfirm() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        a.nextState("MyName");
        State returnedState = a.nextState("return");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(returnedState instanceof PlayerNameState);
        assert(a.getCompletedQuestions() == 0);
    }

    @Test
    void nextStateSkillAfterConfirmedDescription() {
        PlayerCreatorManager a = new PlayerCreatorManager();
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
        PlayerCreatorManager a = new PlayerCreatorManager();
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