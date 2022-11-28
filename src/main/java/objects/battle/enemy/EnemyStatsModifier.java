package objects.battle.enemy;

import objects.character.Boss;
import objects.character.Enemy;

public class EnemyStatsModifier {
    private Enemy enemy;
    public EnemyStatsModifier(Enemy enemy){
        this.enemy = enemy;
    }

    public EnemyStatsModifier(Boss boss){
        this.enemy = boss;
    }

    /**
     * This function sets the enemy's health
     *
     * @param n: new health in int
     */
    public void setHealth(int n)
    {
        this.enemy.enemyInfo.setHealth(n);
    }

    /**
     * This method sets the enemy's speed
     *
     * @param speed: new speed in int
     */
    public void setSpeed(int speed)
    {
        this.enemy.enemyInfo.setSpeed(speed);
    }

    /**
     * This method changes the Enemy's health
     * if n is positive, it will increase the health and
     * if its negative, it will decrease the health
     *
     * @param n: the amount of health to change in int
     */
    public void changeHealth(int n){
        this.enemy.enemyInfo.changeHealth(n);
    }

    /**
     * This method decreases the enemy's speed
     *
     * @param n: the amount of speed that the enemy looses by using a skill
     *
     */
    public void changeSpeed(int n){
        this.enemy.enemyInfo.changeSpeed(n);
    }
}
