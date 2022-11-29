package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class UseSpeedGimmick implements UseGimmick{
    private SpeedGimmick speedGimmick;
    /**
     * This is a constructor of speed gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public UseSpeedGimmick(SpeedGimmick speedGimmick){
        this.speedGimmick = speedGimmick;
    }

    /**
     * This method uses speed gimmick which increases the enemy's speed
     */
    public boolean useGimmick() {
        if (!this.speedGimmick.getUsedGimmick() && checkGimmick()) {
            this.speedGimmick.getEnemyInfo().changeSpeed(this.speedGimmick.getSpeedIncrease());
            this.speedGimmick.usedGimmick();
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
        if(this.speedGimmick.getEnemyInfo().getHealth() < this.speedGimmick.getTriggerHealth()){
            return true;
        } else{
            return false;
        }
    }
}
