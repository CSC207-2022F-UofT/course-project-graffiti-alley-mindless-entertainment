package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class SpeedGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    private int speedIncrease;

    private boolean GimmickUsed = false;
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
    public boolean useGimmick() {
        if (!this.GimmickUsed && checkGimmick()) {
            this.enemyInfo.changeSpeed(this.speedIncrease);
            this.GimmickUsed = true;
            return true;
        } else {
            return false;
        }
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
