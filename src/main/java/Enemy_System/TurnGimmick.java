import Enemy_Entities.Boss;
import Enemy_Entities.Gimmick;

public class TurnGimmick extends Gimmick { //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    public TurnGimmick(){
        super();
    }

    public boolean use_gimmick(Boss boss){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        if(check_gimmick(boss)){
            Skill i = boss.skills.get(0);

            boss.set_health(100);
            boss.used_Gimmick(); //since the boss used gimmick
            return true;
        } else{
            return false;
        }
    }

    public boolean check_gimmick(Boss boss){
        if(boss.getHealth() < 25){
            return true;
        } else{
            return false;
        }
    }
}
