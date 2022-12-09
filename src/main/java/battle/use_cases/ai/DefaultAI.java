package battle.use_cases.ai;

import battle.entities.BattleChoiceType;
import battle.entities.EnemyInfo;
import battle.entities.EnemyPotion;
import battle.use_cases.EnemyActionHandler;
import battle.use_cases.EnemyPotionHandler;
import battle.use_cases.EnemySkillHandler;

import java.util.Random;


/**
 * Default AI that decides enemy's action depending on the User's input.
 * It is considered as default which does not do special thing. So it just
 * responds to the player's input
 *
 */
public class DefaultAI implements EnemyAI {

    /**
     * enemyInfo: information about the enemy
     * attackChance: percentage of enemy attacking
     * potion: potion that the enemy has
     */

    private final EnemyInfo enemyInfo;
    private final int attackChance;

    private final EnemyPotion potion;

    /**
     * This is a constructor of Default AI
     * @param attackChance : chance of the enemy attacking in int
     * @param enemyInfo : information about the enemy in EnemyInfo
     */
    public DefaultAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
        this.potion = new EnemyPotion(10);
    }

    /**
     * This method returns enemy's action depending on the user's action
     * the enemy will attack according to the attackChance given in the constructor
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    @Override
    public EnemyActionHandler respond(BattleChoiceType input) {
        Random rand = new Random();
        if (input == BattleChoiceType.SKILLS) {
            int upperbound = 100;
            int int_random = rand.nextInt(upperbound);
            if(int_random < this.attackChance){
                return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
            } else{
                return new EnemyPotionHandler(potion);
            }
        } else{
            return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
        }
    }
}
