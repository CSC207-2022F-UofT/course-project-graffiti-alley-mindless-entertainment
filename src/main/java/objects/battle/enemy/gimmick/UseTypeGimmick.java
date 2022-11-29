package objects.battle.enemy.gimmick;

import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;


public class UseTypeGimmick implements UseGimmick{
    private TypeGimmick typeGimmick;

    /**
     * This is a constructor of type gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public UseTypeGimmick(TypeGimmick typeGimmick){
        this.typeGimmick = typeGimmick;
    }

    /**
     * This method use type gimmick which changes the enemy's type
     */
    public boolean useGimmick() {
        if (!this.typeGimmick.getUsedGimmick() && checkGimmick()) {
            SkillType type = this.typeGimmick.getEnemyInfo().getType();
            if(type == SkillType.WATER){
                this.typeGimmick.getEnemyInfo().setType(SkillType.FIRE);
            } else if(type == SkillType.FIRE){
                this.typeGimmick.getEnemyInfo().setType(SkillType.EARTH);
            } else if(type == SkillType.EARTH){
                this.typeGimmick.getEnemyInfo().setType(SkillType.AIR);
            } else{
                this.typeGimmick.getEnemyInfo().setType(SkillType.WATER);
            }
            this.typeGimmick.usedGimmick();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick(){
        if(this.typeGimmick.getEnemyInfo().getHealth() < this.typeGimmick.getTriggerHealth()){
            return true;
        } else{
            return false;
        }
    }
}
