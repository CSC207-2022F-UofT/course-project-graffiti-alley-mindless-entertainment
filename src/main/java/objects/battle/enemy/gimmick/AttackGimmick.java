package objects.battle.enemy.gimmick;


import objects.battle.Skill;
import objects.battle.enemy.EnemyInfo;

public class AttackGimmick implements Gimmick {
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    private double attackIncrease;
    private boolean GimmickUsed = false;

    /**
     * This is a constructor of attack gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public AttackGimmick(EnemyInfo enemyInfo, int triggerHealth, double attackIncrease){
        this.enemyInfo = enemyInfo;
        this.attackIncrease = attackIncrease;
        this.triggerHealth = triggerHealth;
    }

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick() {
        if(this.enemyInfo.getHealth() < this.triggerHealth){
            return true;
        } else{
            return false;
        }
    }

    /**
     * This method uses attack gimmick which increase the damage of the enemy's skills by 1.2
     */
    public boolean useGimmick() {
        if (!this.GimmickUsed && checkGimmick()) {
            for(Skill skill: this.enemyInfo.getSkills()){
                int i = skill.getDamage();
                skill.setDamage((int)Math.ceil(i * this.attackIncrease));
            }
            this.GimmickUsed = true;
            return true;
        } else {
            return false;
        }
    }
}
