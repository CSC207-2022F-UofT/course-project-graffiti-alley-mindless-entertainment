package objects.battle.enemy.ai;

import objects.battle.enemy.EnemyInfo;

import java.util.Objects;
import java.util.Random;

public class DefaultAI implements EnemyAI {

    private EnemyInfo enemyInfo;
    private int attackChance;

    private EnemyPotion potion;

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
    public EnemyAction respond(String input) {
        Random rand = new Random();
        if (Objects.equals(input, "use skill")) {
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if(int_random < this.attackChance){
                return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
            } else{
                return potion;
            }
        } else{
            return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
        }
    }
}
