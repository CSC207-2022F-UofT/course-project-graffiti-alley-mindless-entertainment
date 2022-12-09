package questSystem;

import game_world.objects.events.QuestGiverEvent;

import objects.character.Player;
import org.junit.jupiter.api.Test;
import quests.QuestInteractor;

/**
 * This class contains the tests to verify that QuestGiverEvent is functioning properly.
 */
public class QuestGiverEventTest {

    QuestGiverEvent getGenericQuestGiverEvent() {
        QuestInteractor questInteractor = new QuestInteractor(new Player("", null));
        return new QuestGiverEvent("name test", "quest test", "npc test", questInteractor);
    }

    /**
     * Executes test for QuestGiverEvent.getNPC().
     */
    @Test
    void getNPCtest() {
        assert (this.getGenericQuestGiverEvent().getNPC().equalsIgnoreCase("npc test"));
    }

    /**
     * Executes test for QuestGiverEvent.preInput()
     */
    @Test
    void isDoneAndAwaitingInputTest() {
        QuestGiverEvent event = getGenericQuestGiverEvent();

        assert (!event.awaitInput());
        assert (!event.isDone());

        event.preInput();
        assert (event.awaitInput());
        assert (!event.isDone());

        event.postInput("");
        assert (!event.awaitInput());
        assert (event.isDone());
    }
}
