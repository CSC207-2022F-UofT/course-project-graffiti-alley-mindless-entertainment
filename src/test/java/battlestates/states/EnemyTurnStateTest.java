package battlestates.states;

import battlestates.BattleChoiceType;
import objects.battle.BattleEntityInteractor;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.EnemyFighter;
import objects.character.Player;
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
