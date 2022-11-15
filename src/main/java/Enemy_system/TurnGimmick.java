package Enemy_system;

package Enemy_System;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class TurnGimmick implements Gimmick { //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    public TurnGimmick(){
        super();
    }

    public boolean use_gimmick(Boss boss, Player player){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        if(check_gimmick(boss)){
            Skill i = boss.skills.get(0);
            int damage = i.getDamage();
            player.changeHealth(-damage);
            boss.usedGimmick();
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
