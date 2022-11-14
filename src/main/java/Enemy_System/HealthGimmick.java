import Enemy_Entities.Boss;
import Enemy_Entities.Gimmick;

public class HealthGimmick implements Gimmick {

    public HealthGimmick(){
        super();
    }

    public boolean use_gimmick(Boss boss){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        if(check_gimmick(boss)){
            boss.set_health(100);
            boss.used_Gimmick(); //since the boss used gimmick
            return true;
        } else{
            return false;
        }
    }

    public boolean check_gimmick(Boss boss){
        if(boss.getHealth() < 20){
            return true;
        } else{
            return false;
        }
    }
}
