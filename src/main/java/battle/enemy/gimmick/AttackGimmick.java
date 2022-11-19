package battle.enemy.gimmick;

import objects.character.Boss;
import Enemy_Entities.Gimmick;

public class AttackGimmick implements Gimmick {
    private EnemyInfo enemyInfo;

    /**
     * This is a constructor of attack gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public AttackGimmick(EnemyInfo enemyInfo){
        this.enemyInfo = enemyInfo;
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick() {
        if(this.enemyInfo.getHealth() < 15){
            return true;
        } else{
            return false;
        }
    }

    /**
     * This method uses attack gimmick which increase the damage of the enemy's skills by 1.2
     */
    public void useGimmick() {
        for(Skill skill: this.enemyInfo.getSkills){
            int i = skill.getDamage();
            skill.setDamage((int)Math.ceil(i * 1.2));
        }
    }
}
