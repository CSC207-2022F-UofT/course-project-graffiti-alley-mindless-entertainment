package Enemy_system;

package Enemy_System;
import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class AttackGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    public AttackGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }


    public boolean checkGimmick() {
        if(this.enemyInfo.getHealth() < 15){
            return true;
        } else{
            return false;
        }
    }

    public void useGimmick() {
        for(Skill skill: this.enemyInfo.getSkills){
            int i = skill.getDamage();
            skill.setDamage((int)Math.ceil(i * 1.2));
        }
    }
}
