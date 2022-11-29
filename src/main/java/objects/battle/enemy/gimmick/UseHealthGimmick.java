package objects.battle.enemy.gimmick;


import objects.battle.enemy.EnemyInfo;

public class UseHealthGimmick implements UseGimmick{
    private HealthGimmick healthGimmick;

    /**
     * This is a constructor of health gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public UseHealthGimmick(HealthGimmick healthGimmick){
        this.healthGimmick = healthGimmick;
    }

    /**
     * This method uses health gimmick which fully heal the enemy's health
     */
    public boolean useGimmick() {
        if (!this.healthGimmick.getUsedGimmick() && checkGimmick()) {
            this.healthGimmick.getEnemyInfo().setHealth(this.healthGimmick.getEnemyInfo().getMaxHealth());
            this.healthGimmick.usedGimmick();
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
        if(this.healthGimmick.getEnemyInfo().getHealth() < this.healthGimmick.getTriggerHealth()){
            return true;
        } else{
            return false;
        }
    }
}

