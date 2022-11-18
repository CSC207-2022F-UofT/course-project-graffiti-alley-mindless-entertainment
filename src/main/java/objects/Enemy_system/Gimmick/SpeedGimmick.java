package objects.Enemy_system.Gimmick;

import objects.Enemy_system.Gimmick.Gimmick;package objects.charactoers.player;
public class SpeedGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    public SpeedGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        int newSpeed = Math.ceil(this.enemyInfo.getSpeed*0.5);
        this.enemyInfo.changeSpeed(newSpeed);
    }

    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 30){
            return true;
        } else{
            return false;
        }
    }
}
