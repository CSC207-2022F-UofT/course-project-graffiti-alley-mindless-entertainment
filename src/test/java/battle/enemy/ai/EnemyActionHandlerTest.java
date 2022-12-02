package battle.enemy.ai;

import objects.battle.SkillType;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.battle.enemy.ai.EnemyPotionHandler;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Objects;


public class EnemyActionHandlerTest {

    @Test
    @DisplayName("This is a test for enemy action handler")
    public void EnemyPotionHandlerTest1(){
        Player player = new Player("Yasu", SkillType.AIR);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFacade enemyFacade = enemyFactory.createEnemy("goblin");
        EnemyPotionHandler potion = new EnemyPotionHandler(enemyFacade.getPotion());
        enemyFacade.changeHealth(-90);
        EnemyActionHandler action = enemyFacade.enemyAction("use skill");
        String text = action.useAction(enemyFacade, player);
        Assertions.assertEquals(20, enemyFacade.getHealth());
        Assertions.assertEquals("Goblin warrior used a potion! Now goblin has 20 HP!", text);
    }

    @Test
    @DisplayName("This is a test for enemy action handler when the object is boss")
    public void EnemyPotionHandlerTest2(){
        Player player = new Player("Yasu", SkillType.EARTH);
        EnemyFactory enemyFactory = new EnemyFactory();
        BossFacade bossFacade = enemyFactory.createBoss("goblin warrior");
        EnemyPotionHandler potion = new EnemyPotionHandler(bossFacade.getPotion());
        bossFacade.changeHealth(-90);
        EnemyActionHandler action = bossFacade.enemyAction("use skill");
        String text = action.useAction(bossFacade, player);
        boolean check = player.getCurrHealth() == 75 || bossFacade.getHealth() == 30;
        boolean check2 = Objects.equals(text, "goblin warrior used a potion! Now goblin warrior has 30 HP!")
                || Objects.equals(text, "goblin warrior has used beam with 25 damage!");
        Assertions.assertTrue(check && check2);}
}
