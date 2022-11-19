package Battle.Enemy_system.EnemyAI;

import java.util.Random;

public class SmartAI implements EnemyAI {
    private EnemyInfo enemyInfo;
    private int attackChance;

    /**
     * This is a constructor of Smart AI
     * @param attackChance : chance of the enemy attacking in int
     * @param enemyInfo : information about the enemy in EnemyInfo
     */
    public SmartAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
    }

    /**
     * This method returns enemy's action depending on the user's action
     * It heals when the health is low, and attack when health is high.
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    @Override
    public String respond(String input) {
        if(this.enemyInfo.getHealth() < 10) {
            return "use potion";
        } else if (this.enemyInfo.getHealth() > 60) {
            return "use skill";

        } else {
            Random rand = new Random();
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if (int_random < this.attackChance) {
                return "use skill";
            } else {
                return "use potion";
            }
        }
    }
}
