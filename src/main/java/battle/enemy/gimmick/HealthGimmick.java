package battle.enemy.gimmick;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class HealthGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    /**
     * This is a constructor of health gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public HealthGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    /**
     * This method uses health gimmick which fully heal the enemy's health
     */
    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        this.enemyInfo.setHealth(100);
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 20){
            return true;
        } else{
            return false;
        }
    }
}

