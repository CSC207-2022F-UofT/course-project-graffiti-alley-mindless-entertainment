package battle.enemy.ai;

import objects.battle.enemy.ai.EnemyPotionHandler;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class EnemyPotionHandlerTest {

    @Test
    @DisplayName("This is a test for enemy action handler")
    public void EnemyPotionHandlerTest1(){
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFacade enemyFacade = (EnemyFacade) enemyFactory.createEnemy("goblin");
        EnemyPotionHandler potion = new EnemyPotionHandler(enemyFacade.getPotion());
        enemyFacade.changeHealth(-90);
        potion.usePotion(enemyFacade);
        Assertions.assertEquals(20, enemyFacade.getHealth());}

    @Test
    @DisplayName("This is a test for enemy action handler when the object is boss")
    public void EnemyPotionHandlerTest2(){
        EnemyFactory enemyFactory = new EnemyFactory();
        BossFacade bossFacade = (BossFacade) enemyFactory.createEnemy("goblin warrior");
        EnemyPotionHandler potion = new EnemyPotionHandler(bossFacade.getPotion());
        bossFacade.changeHealth(-90);
        potion.usePotion(bossFacade);
        Assertions.assertEquals(30, bossFacade.getHealth());}
}
