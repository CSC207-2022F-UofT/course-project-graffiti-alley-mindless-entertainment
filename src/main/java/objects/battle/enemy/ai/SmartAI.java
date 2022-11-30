package objects.battle.enemy.ai;
import objects.battle.enemy.EnemyInfo;

import java.util.Objects;
import java.util.Random;

public class SmartAI implements EnemyAI {
    /**
     * This class is a subclass of enemyAI and overrides the respond() function
     * It is smart Ai that does decide the action depending on the enemy's health
     * and also the player's input.
     */
    private EnemyInfo enemyInfo;
    private int attackChance;
    private EnemyPotion potion;

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
    public EnemyAction respond(String input) {
        Random rand = new Random();
        if (this.enemyInfo.getHealth() < 30) {
            int upper = 101;
            int int_random = rand.nextInt(upper);
            if (int_random < 70) {
                return potion;
            } else if (this.enemyInfo.getHealth() > 60) {
                return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
            }
        } else {
            if(Objects.equals(input, "use potion")) {
                return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
            } else{
                Random r = new Random();
                int upperbound = 101;
                int int_r = r.nextInt(upperbound);
                if (int_r < this.attackChance) {
                    return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
                } else {
                    return potion;
                }
            }

        }
        return enemyInfo.getSkill(rand.nextInt(enemyInfo.getSkills().size()));
    }

}
