package objects.Enemy_system.EnemyAI;

import java.util.Objects;
import java.util.Random;

public class DefaultAI implements EnemyAI{

    private EnemyInfo enemyInfo;
    private int attackChance;

    public DefaultAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
    }

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
