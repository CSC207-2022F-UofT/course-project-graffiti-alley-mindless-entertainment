package objects.battle.enemy.gimmick;

import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;


public class TypeGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.

    /**
     * This is a constructor of type gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public TypeGimmick(EnemyInfo enemyInfo, int triggerHealth){
        this.enemyInfo = enemyInfo;
        this.triggerHealth = triggerHealth;
    }

    /**
     * This method use type gimmick which changes the enemy's type
     */
    public void useGimmick(){

        SkillType type = this.enemyInfo.getType();
        if(type == SkillType.WATER){
            this.enemyInfo.setType(SkillType.FIRE);
        } else if(type == SkillType.FIRE){
            this.enemyInfo.setType(SkillType.EARTH);
        } else if(type == SkillType.EARTH){
            this.enemyInfo.setType(SkillType.AIR);
        } else{
            this.enemyInfo.setType(SkillType.WATER);
        }
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < this.triggerHealth){
            return true;
        } else{
            return false;
        }
    }
}
