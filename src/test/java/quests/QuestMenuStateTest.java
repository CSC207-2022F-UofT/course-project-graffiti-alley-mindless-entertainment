package quests;

import character.entities.Player;
import pause_menu.quests.QuestMenuFactory;
import pause_menu.quests.QuestMenuState;

import org.junit.jupiter.api.Test;

/**
 * This class contains the tests for the QuestMenuState & QuestMenuFactory.
 */
public class QuestMenuStateTest {
    @Test
    void testPreInput() {
        QuestInteractor interactor = new QuestInteractor(new Player("name", null));
        QuestMenuState state = new QuestMenuState(interactor);
        state.preInput();
        assert (state.awaitInput());
        assert (!state.isDone());
    }

    @Test
    void testPostInput() {
        QuestInteractor interactor = new QuestInteractor(new Player("name", null));
        QuestMenuState state = new QuestMenuState(interactor);
        state.postInput("");
        assert (!state.awaitInput());
        assert (state.isDone());
    }

    @Test
    void testQuestMenuCreation() {
        // setting for the test
        QuestInteractor interactor = new QuestInteractor(new Player("", null));
        QuestMenuFactory factory = new QuestMenuFactory(interactor);
        // creation of state using factory
        QuestMenuState state = factory.createQuestMenuState();
        //checks that QuestMenuState works properly.
        state.preInput();
        assert (state.awaitInput());
        assert (!state.isDone());
        state.postInput("");
        assert (!state.awaitInput());
        assert (state.isDone());
    }
}
