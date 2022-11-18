package Enemy_system;
import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class HealthGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    public HealthGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        this.enemyInfo.setHealth(100);
    }

    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 20){
            return true;
        } else{
            return false;
        }
    }
}

