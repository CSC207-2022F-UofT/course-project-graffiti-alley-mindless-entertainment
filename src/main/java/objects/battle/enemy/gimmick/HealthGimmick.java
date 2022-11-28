package objects.battle.enemy.gimmick;


import objects.battle.enemy.EnemyInfo;

public class HealthGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    private boolean GimmickUsed = false;

    /**
     * This is a constructor of health gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public HealthGimmick(EnemyInfo enemyInfo, int triggerHealth){
        this.enemyInfo = enemyInfo;
        this.triggerHealth = triggerHealth;
    }

    /**
     * This method uses health gimmick which fully heal the enemy's health
     */
    public boolean useGimmick() {
        if (!this.GimmickUsed && checkGimmick()) {
            this.enemyInfo.setHealth(this.enemyInfo.getMaxHealth());
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

