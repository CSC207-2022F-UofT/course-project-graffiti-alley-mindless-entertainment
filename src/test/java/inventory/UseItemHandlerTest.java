package inventory;

import battle.use_cases.BattleEntityInteractor;
import inventory.UseItemHandler;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import character.entities.Player;
import inventory.entities.item.Armor;
import inventory.entities.item.Item;
import inventory.entities.item.Potion;
import inventory.entities.item.Sword;
import org.junit.Test;

public class UseItemHandlerTest {
    @Test
    public void useItemAbilityTest() {
        Player user = new Player("", null);
        user.changeCurrHealth(-10);
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        BattleEntityInteractor bei = new BattleEntityInteractor(user, foe);
        Item sword = new Sword(0);
        Item potion = new Potion(0);
        Item armor = new Armor(0);
        int userPrevArmor = user.getArmor();
        UseItemHandler uih = new UseItemHandler(bei);
        uih.useItemAbility(sword);
        uih.useItemAbility(potion);
        uih.useItemAbility(armor);
        assert(user.getCurrHealth() == 100);
        assert(foe.getHealth() == 90);
        assert(userPrevArmor - user.getArmor() == 10);
    }
}
