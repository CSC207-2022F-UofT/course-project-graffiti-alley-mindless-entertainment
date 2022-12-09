package objects.inventory;

import objects.battle.BattleEntityInteractor;
import objects.item.UseItemHandler;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.EnemyFighter;
import objects.character.Player;
import objects.item.Armor;
import objects.item.Item;
import objects.item.Potion;
import objects.item.Sword;
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
