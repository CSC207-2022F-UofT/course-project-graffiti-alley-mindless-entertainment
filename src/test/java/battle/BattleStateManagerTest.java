package battle;

import battle.states.BattleAskingState;
import battle.states.LoseBattleState;
import battle.states.WinBattleState;
import core.State;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import character.entities.Player;
import org.junit.Test;

public class BattleStateManagerTest {
    @Test
    void initializeTest() {
        Player user = new Player("", null);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter foe = enemyFactory.createEnemy("goblin warrior");
        BattleStateManager bsm = new BattleStateManager(user, null);
    }
    @Test
    void nextStateTest() {
        Player user = new Player("", null);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter foe = enemyFactory.createEnemy("goblin warrior");
        BattleStateManager bsm = new BattleStateManager(user, null);

        State testState = bsm.nextState("");
        assert(testState instanceof BattleAskingState);
        foe.changeHealth(100);
        testState = bsm.nextState("");
        assert(testState instanceof WinBattleState);
        user.changeCurrHealth(user.getMaxHealth());
        testState = bsm.nextState("");
        assert(testState instanceof LoseBattleState);
    }
}
