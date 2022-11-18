package Enemy_system;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class TypeGimmick implements Enemy_system.Gimmick {
    private EnemyInfo enemyInfo;
    //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    public TypeGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)

        Type type = this.enemyInfo.getType();
        if(type == Type.WATER){
            this.enemyInfo.setType(Type.FIRE);
        } else if(type == Type.FIRE){
            this.enemyInfo.setType(Type.GRASS);
        } else if(type == Type.GRASS){
            this.enemyInfo.setType(Type.AIR);
        } else{
            this.enemyInfo.setType(Type.WATER);
        }
    }

    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 25){
            return true;
        } else{
            return false;
        }
    }
}
