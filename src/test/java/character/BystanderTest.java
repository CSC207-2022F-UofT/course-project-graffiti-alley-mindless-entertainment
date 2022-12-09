package character;

import character.entities.Bystander;
import org.junit.jupiter.api.Test;

class BystanderTest {

    @Test
    void hasQuest() {
        Bystander b = new Bystander("b", true);
        assert(b.hasQuest());
    }

    @Test
    void switchHasQuestTrueToFalse() {
        Bystander b = new Bystander("b", true);
        b.switchHasQuest();
        assert(!b.hasQuest());
    }

    @Test
    void switchHasQuestFalseToTrue() {
        Bystander b = new Bystander("b", false);
        b.switchHasQuest();
        assert(b.hasQuest());
    }
}