package battle.enemy.gimmick;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class TypeGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    /**
     * This is a constructor of type gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public TypeGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    /**
     * This method use type gimmick which changes the enemy's type
     */
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

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 25){
            return true;
        } else{
            return false;
        }
    }
}
