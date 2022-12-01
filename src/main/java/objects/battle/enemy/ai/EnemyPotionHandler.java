package objects.battle.enemy.ai;

import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;

public class EnemyPotionHandler implements EnemyActionHandler{
    private EnemyPotion enemyPotion;


    public EnemyPotionHandler(EnemyPotion enemyPotion){
        this.enemyPotion = enemyPotion;
    }


    @Override
    public void useAction(EnemyFacade enemy, Player player) {
        enemy.changeHealth(this.enemyPotion.getHp());
    }

    @Override
    public void useAction(BossFacade boss, Player player){
        boss.changeHealth(this.enemyPotion.getHp());
    }
}
