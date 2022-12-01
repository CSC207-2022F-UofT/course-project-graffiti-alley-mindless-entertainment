package battle.enemy.ai;

import objects.battle.SkillType;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.battle.enemy.ai.EnemyPotionHandler;
import objects.battle.enemy.ai.EnemySkillHandler;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
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
        EnemyFacade enemyFacade = (EnemyFacade) enemyFactory.createEnemy("goblin");
        EnemyPotionHandler potion = new EnemyPotionHandler(enemyFacade.getPotion());
        enemyFacade.changeHealth(-90);
        EnemyActionHandler action = enemyFacade.enemyAction("use skill");
        action.useAction(enemyFacade, player);
        Assertions.assertEquals(20, enemyFacade.getHealth());}

    @Test
    @DisplayName("This is a test for enemy action handler when the object is boss")
    public void EnemyPotionHandlerTest2(){
        Player player = new Player("Yasu", SkillType.EARTH);
        EnemyFactory enemyFactory = new EnemyFactory();
        BossFacade bossFacade = (BossFacade) enemyFactory.createEnemy("goblin warrior");
        EnemyPotionHandler potion = new EnemyPotionHandler(bossFacade.getPotion());
        bossFacade.changeHealth(-90);
        EnemyActionHandler action = bossFacade.enemyAction("use skill");
        action.useAction(bossFacade, player);
        boolean check = player.getCurrHealth() == 75 || bossFacade.getHealth() == 30;
        Assertions.assertTrue(check);}
}
