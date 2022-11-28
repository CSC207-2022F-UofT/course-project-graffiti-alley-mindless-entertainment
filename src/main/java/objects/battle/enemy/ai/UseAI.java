package objects.battle.enemy.ai;

import objects.character.Boss;
import objects.character.Enemy;

public class UseAI {
    private Enemy enemy;

    public UseAI(Enemy enemy){
        this.enemy = enemy;
    }

    public UseAI(Boss boss){
        this.enemy = boss;
    }

    public EnemyAction respond(String input){
        return this.enemy.getEnemyAI().respond(input);
    }
}
