package Battle.Enemy_system.Gimmick;

import Battle.Enemy_system.Gimmick.Gimmick;package objects.charactoers.player;
public class SpeedGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    /**
     * This is a constructor of speed gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public SpeedGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    /**
     * This method uses speed gimmick which increases the enemy's speed
     */
    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        int newSpeed = Math.ceil(this.enemyInfo.getSpeed*0.5);
        this.enemyInfo.changeSpeed(newSpeed);
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 30){
            return true;
        } else{
            return false;
        }
    }
}
