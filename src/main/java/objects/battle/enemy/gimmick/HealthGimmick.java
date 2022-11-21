package objects.battle.enemy.gimmick;


import objects.battle.enemy.EnemyInfo;

public class HealthGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;

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
    public void useGimmick(){
        this.enemyInfo.setHealth(this.enemyInfo.getMaxHealth());
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

