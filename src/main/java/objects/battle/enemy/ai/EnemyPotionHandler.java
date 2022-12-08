package objects.battle.enemy.ai;

import io.Output;
import io.OutputHandler;
import objects.character.EnemyFighter;
import objects.character.Player;

/**
 * This class is EnemyPotionHandler which handles the EnemyPotion. This is
 * a use case of EnemyPotion. It has useAction which uses the potion for the given enemy
 */
public class EnemyPotionHandler implements EnemyActionHandler{
    /**
     * enemyPotion: EnemyPotion object that the enemy has with the hp value that the potion can increase
     */
    private final EnemyPotion enemyPotion;


    /**
     * This is a constructor of the EnemyPotionHandler which takes EnemyPotion as a parameter.
     * @param enemyPotion that the enemy has
     */
    public EnemyPotionHandler(EnemyPotion enemyPotion){
        this.enemyPotion = enemyPotion;
    }

    /**
     * This method uses a potion for the enemy depending on the health value that the
     * potion has. This method has Player which is not used, but the EnemySkillHandler which
     * also implements the EnemyActionHandler uses Player, so it takes player as a parameter.
     * In this way, the controller who is using the EnemyActionHandler does not have to know
     * if the enemy used potion or skill.
     * @param enemy that uses potion
     * @param player of the game
     */
    @Override
    public void useAction(EnemyFighter enemy, Player player) {
        enemy.changeHealth(this.enemyPotion.getHp());
        OutputHandler output = Output.getScreen();
        output.generateText(enemy.getName() + " used a potion! Now " + enemy.getName() + " has " + enemy.getHealth() +
                " HP!");
    }

}
