package objects.battle.enemy.ai;

import objects.battle.enemy.EnemyInfo;

import java.util.Objects;
import java.util.Random;



public class DefaultAI implements EnemyAI {

    /**
     * Default AI that decides enemy's action depending on the User's input.
     * It is considered as default which does not do special thing. So it just
     * responds to the player's input
     *
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
    public EnemyActionHandler respond(String input) {
        Random rand = new Random();
        if (Objects.equals(input, "use skill")) {
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
