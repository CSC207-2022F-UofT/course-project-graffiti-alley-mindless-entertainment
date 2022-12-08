package battle.enemy.ai;

import battlestates.BattleChoiceType;
import objects.battle.SkillType;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.battle.enemy.ai.EnemyPotionHandler;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.EnemyFighter;
import objects.character.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class EnemyActionHandlerTest {

    @Test
    @DisplayName("This is a test for enemy action handler")
    public void EnemyPotionHandlerTest1(){
        Player player = new Player("Yasu", SkillType.AIR);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter enemyFacade = enemyFactory.createEnemy("goblin");
        EnemyPotionHandler potion = new EnemyPotionHandler(enemyFacade.getPotion());
        enemyFacade.changeHealth(-90);
        EnemyActionHandler action = enemyFacade.enemyAction(BattleChoiceType.SKILLS);
        action.useAction(enemyFacade, player);
        Assertions.assertEquals(20, enemyFacade.getHealth());
        potion.useAction(enemyFacade, player);
        Assertions.assertEquals(30, enemyFacade.getHealth());
    }

    @Test
    @DisplayName("This is a test for enemy action handler when the object is boss")
    public void EnemyPotionHandlerTest2(){
        Player player = new Player("Yasu", SkillType.EARTH);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter bossFacade = enemyFactory.createEnemy("goblin warrior");
        EnemyPotionHandler skill = new EnemyPotionHandler(bossFacade.getPotion());
        bossFacade.changeHealth(-90);
        EnemyActionHandler action = bossFacade.enemyAction(BattleChoiceType.SKILLS);
        action.useAction(bossFacade, player);
        boolean check = player.getCurrHealth() == 75 || bossFacade.getHealth() == 30;
        Assertions.assertTrue(check);
        Player player2 = new Player("Yasu", SkillType.EARTH);
        EnemyFighter bossFacade2 = enemyFactory.createEnemy("goblin warrior");
        skill.useAction(bossFacade2, player2);
        boolean check2 = player.getCurrHealth() == 75 || bossFacade.getHealth() == 30;
        Assertions.assertTrue(check2);
    }
}
