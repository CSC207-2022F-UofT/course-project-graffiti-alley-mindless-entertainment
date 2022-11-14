import Enemy_Entities.Boss;
import Enemy_Entities.Gimmick;

public class AttackGimmick implements Gimmick {

    public AttackGimmick(){
        super();
    }

    @Override
    public boolean check_gimmick(Boss boss) {
        if(boss.getHealth() < 15){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean use_gimmick(Boss boss) {
        if(check_gimmick(boss)){
            for(Skill skill: boss.skills){
                int i = skill.getdamage();
                skill.setdamage((int)Math.ceil(i * 1.2));
            }
            return true;
        } else{
            return false;
        }
    }
}
