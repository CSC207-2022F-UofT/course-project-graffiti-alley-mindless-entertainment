package objects.battle.enemy.gimmick;


import objects.battle.Skill;
import objects.battle.enemy.EnemyInfo;

public class UseAttackGimmick implements UseGimmick{
    private AttackGimmick attackGimmick;

    /**
     * This is a constructor of attack gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public UseAttackGimmick(AttackGimmick attackGimmick){
        this.attackGimmick = attackGimmick;
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick() {
        if(this.attackGimmick.getEnemyInfo().getHealth() < this.attackGimmick.getTriggerHealth()){
            return true;
        } else{
            return false;
        }
    }

    /**
     * This method uses attack gimmick which increase the damage of the enemy's skills by 1.2
     */
    public boolean useGimmick() {
        if (!this.attackGimmick.getUsedGimmick() && checkGimmick()) {
            for(Skill skill: this.attackGimmick.getEnemyInfo().getSkills()){
                int i = skill.getDamage();
                skill.setDamage((int)Math.ceil(i * this.attackGimmick.getAttackIncrease()));
            }
            this.attackGimmick.usedGimmick();
            return true;
        } else {
            return false;
        }
    }
}
