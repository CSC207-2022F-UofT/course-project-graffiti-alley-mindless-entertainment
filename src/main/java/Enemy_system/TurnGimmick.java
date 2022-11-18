package Enemy_system;

package Enemy_System;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class TurnGimmick implements Enemy_system.Gimmick {
    private EnemyInfo enemyInfo;
    private PlayerInfo playerInfo;
    //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    public TurnGimmick(EnemyInfo enemyInfo, PlayerInfo playerInfo){
        this.enemyInfo = enemyInfo;
        this.playerInfo = playerInfo;
    }

    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)

        Skill i = this.enemyInfo.skills.get(0);
        int damage = i.getDamage();
        this.playerInfo.changeHealth(-damage);
    }

    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 25){
            return true;
        } else{
            return false;
        }
    }
}
