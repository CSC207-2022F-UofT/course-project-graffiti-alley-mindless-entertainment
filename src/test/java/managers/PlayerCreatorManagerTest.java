package managers;

import database.interfaces.State;
import org.junit.jupiter.api.Test;
import playercreation.PlayerConfirmState;
import database.managers.PlayerCreatorManager;
import playercreation.PlayerQuestion;
import playercreation.PlayerQuestionState;

class PlayerCreatorManagerTest {

    @Test
    void initialize() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(a.getCurrState() instanceof PlayerQuestionState);
        assert(((PlayerQuestionState) a.getCurrState()).getCurrQuestion() == PlayerQuestion.NAME);
    }

    @Test
    void nextStateConfirmAfterName() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        State returnedState = a.nextState("MyName");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.CONFIRM);
        assert(returnedState instanceof PlayerConfirmState);
        assert(a.getCompletedQuestions().contains(PlayerQuestion.NAME));
    }

    @Test
    void nextStateDescriptionAfterConfirmedName() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        a.nextState("MyName");
        State returnedState = a.nextState("confirm");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.DESCRIPTION);
        assert(returnedState instanceof PlayerQuestionState);
        assert(a.getCompletedQuestions().contains(PlayerQuestion.NAME));
        assert(!a.getCompletedQuestions().contains(PlayerQuestion.DESCRIPTION));
        assert(!a.getCompletedQuestions().contains(PlayerQuestion.CONFIRM));
    }

    @Test
    void nextStateNameAfterReturnedConfirm() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        a.nextState("MyName");
        State returnedState = a.nextState("return");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.NAME);
        assert(returnedState instanceof PlayerQuestionState);
        assert(a.getCompletedQuestions().isEmpty());
    }

    @Test
    void nextStateSkillAfterConfirmedDescription() {
        PlayerCreatorManager a = new PlayerCreatorManager();
        a.nextState("MyName");
        a.nextState("confirm");
        a.nextState("MyDescription");
        State returnedState = a.nextState("confirm");
        assert(a.getCurrPlayerQuestion() == PlayerQuestion.SKILLTYPE);
        assert(returnedState instanceof PlayerQuestionState);
        assert(a.getCompletedQuestions().contains(PlayerQuestion.NAME));
        assert(a.getCompletedQuestions().contains(PlayerQuestion.DESCRIPTION));
        assert(!a.getCompletedQuestions().contains(PlayerQuestion.CONFIRM));
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
        assert(returnedState instanceof PlayerQuestionState);
        assert(a.getCompletedQuestions().contains(PlayerQuestion.NAME));
        assert(a.getCompletedQuestions().contains(PlayerQuestion.DESCRIPTION));
        assert(!a.getCompletedQuestions().contains(PlayerQuestion.CONFIRM));
        assert(!a.getCompletedQuestions().contains(PlayerQuestion.SKILLTYPE));
    }
}