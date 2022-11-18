package objects.Enemy_system.EnemyAI;

import java.util.Random;

public class SmartAI implements EnemyAI{
    private EnemyInfo enemyInfo;
    private int attackChance;

    public SmartAI(EnemyInfo enemyInfo, int attackChance){
        this.enemyInfo = enemyInfo;
        this.attackChance = attackChance;
    }

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
