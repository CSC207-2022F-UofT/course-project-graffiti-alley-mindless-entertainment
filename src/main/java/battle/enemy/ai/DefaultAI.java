package battle.enemy.ai;

import java.util.Objects;
import java.util.Random;

public class DefaultAI implements EnemyAI {

    private EnemyInfo enemyInfo;
    private int attackChance;

    /**
     * This is a constructor of Default AI
     * @param attackChance : chance of the enemy attacking in int
     * @param enemyInfo : information about the enemy in EnemyInfo
     */
    public DefaultAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
    }

    /**
     * This method returns enemy's action depending on the user's action
     * the enemy will attack according to the attackChance given in the constructor
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    @Override
    public String respond(String input) {
        if (Objects.equals(input, "use skill")) {
            Random rand = new Random();
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if(int_random < this.attackChance){
                return "use skill";
            } else{
                return "use potion";
            }
        } else{
            return "use skill";
        }
    }
}
