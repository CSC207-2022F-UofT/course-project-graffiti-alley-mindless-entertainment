package battle.states;

import battle.entities.BattleChoiceType;
import battle.use_cases.BattleEntityInteractor;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import character.entities.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EnemyTurnStateTest {
    @Test
    public void enemyTurnStateTest() {
        Player user = new Player("", null);
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        BattleEntityInteractor bei = new BattleEntityInteractor(user, foe);
        BattleChoiceType action = BattleChoiceType.SKILLS;
        EnemyTurnState test = new EnemyTurnState(bei.getUser(), bei.getFoe(), action);

        Assertions.assertFalse(test.awaitInput());
        Assertions.assertFalse(test.isDone());
        test.preInput();
        assert(foe.getSpeed() == 80);
        assert(test.awaitInput());
        test.postInput("");
        assert(!test.awaitInput());
        assert(test.isDone());
    }
}
