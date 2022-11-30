package objects.battle.enemy.ai;

import objects.character.BossFacade;
import objects.character.EnemyFacade;

public class EnemyPotionHandler {
    private EnemyPotion enemyPotion;


    public EnemyPotionHandler(EnemyPotion enemyPotion){
        this.enemyPotion = enemyPotion;
    }


    public void usePotion(EnemyFacade enemy){
        enemy.changeHealth(this.enemyPotion.getHp());
    }

    public void usePotion(BossFacade boss){
        boss.changeHealth(this.enemyPotion.getHp());
    }
}
