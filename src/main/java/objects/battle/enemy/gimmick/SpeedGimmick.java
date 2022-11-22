package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class SpeedGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    private int speedIncrease;

    /**
     * This is a constructor of speed gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public SpeedGimmick(EnemyInfo enemyInfo, int triggerHealth, int speedIncrease){
        this.enemyInfo = enemyInfo;
        this.triggerHealth = triggerHealth;
        this.speedIncrease = speedIncrease;
    }

    /**
     * This method uses speed gimmick which increases the enemy's speed
     */
    public void useGimmick(){
        this.enemyInfo.changeSpeed(this.speedIncrease);
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < this.triggerHealth){
            return true;
        } else{
            return false;
        }
    }
}
