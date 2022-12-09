package character;

import battle.use_cases.BattleEntityInteractor;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import character.entities.Player;
import org.junit.Test;

public class BattleEntityInteractorTest {
    @Test
    public void entityTests() {
        Player user = new Player("", null);
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        BattleEntityInteractor bei = new BattleEntityInteractor(user, foe);
        assert(bei.getUser().equals(user));
        assert(bei.getFoe().equals(foe));
        assert(!bei.isFoeDead());
        assert(!bei.isUserDead());
        user.changeCurrHealth(-100);
        foe.changeHealth(-100);
        assert(bei.isUserDead());
        assert(bei.isFoeDead());
    }
}
