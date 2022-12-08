package objects.battle.enemy.ai;
import battlestates.BattleChoiceType;
import objects.battle.enemy.EnemyInfo;

import java.util.Objects;
import java.util.Random;

/**
 * This class is a subclass of enemyAI and overrides the "respond()" function
 * It is smart Ai that does decide the action depending on the enemy's health
 * and also the player's input.
 */
public class SmartAI implements EnemyAI {
    /**
     * enemyInfo: information about this enemy who is using this AI
     * attackChance: chance of this enemy attacking the user in percentage
     *potion: EnemyPotion object that this enemy has
     */
    private final EnemyInfo enemyInfo;
    private final int attackChance;
    private final EnemyPotion potion;

    /**
     * This is a constructor of Smart AI
     * @param attackChance : chance of the enemy attacking in int
     * @param enemyInfo : information about the enemy in EnemyInfo
     */
    public SmartAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
        this.potion = new EnemyPotion(10);
    }

    /**
     * This method returns enemy's action depending on the user's action
     * It heals when the health is low, and attack when health is high.
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    @Override
    public EnemyActionHandler respond(BattleChoiceType input) {
        Random rand = new Random();
        if (this.enemyInfo.getHealth() < 30) {
            int upper = 100;
            int int_random = rand.nextInt(upper);
            if (int_random < 70) {
                return new EnemyPotionHandler(potion);
            } else if (this.enemyInfo.getHealth() > 60) {
                return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
            }
        } else {
            if(input == BattleChoiceType.INVENTORY) {
                return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
            } else{
                Random r = new Random();
                int upperbound = 100;
                int int_r = r.nextInt(upperbound);
                if (int_r < this.attackChance) {
                    return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
                } else {
                    return new EnemyPotionHandler(potion);
                }
            }

        }
        return new EnemySkillHandler(enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size())));
    }

}
