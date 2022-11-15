package Enemy_system;

package Enemy_System;
import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class AttackGimmick implements Gimmick {

    public AttackGimmick(){super();}


    public boolean check_gimmick(Boss boss, Player player) {
        if(boss.getHealth() < 15){
            return true;
        } else{
            return false;
        }
    }

    public boolean use_gimmick(Boss boss) {
        if(check_gimmick(boss)){
            for(Skill skill: boss.skills){
                int i = skill.getDamage();
                skill.setDamage((int)Math.ceil(i * 1.2));
            }
            return true;
        } else{
            return false;
        }
    }
}
