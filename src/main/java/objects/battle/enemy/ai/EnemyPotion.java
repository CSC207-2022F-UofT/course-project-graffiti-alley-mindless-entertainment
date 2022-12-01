package objects.battle.enemy.ai;

public class EnemyPotion{
    /**
     * This class is only used by an enemy, and it is one of the enemy's actions.
     * This potion has instance attribute called hp which is the health that increases
     * if the enemy uses this potion.
     */
    private int hp;

    /**
     * This is a constructor of the EnemyPotion. It takes a hp as a parameter.
     */
    public EnemyPotion(int hp){
        this.hp = hp;
    }

    /**
     * This method returns the amount of health that the enemy potion can increase
     * @return the amount of health that the potion can increase in int
     */
    public int getHp(){
        return this.hp;
    }
}
