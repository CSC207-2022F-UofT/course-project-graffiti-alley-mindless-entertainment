package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class AttackGimmick extends Gimmick{
    private double attackIncrease;
    private boolean GimmickUsed = false;

    /**
     * This is a constructor of attack gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public AttackGimmick(EnemyInfo enemyInfo, int triggerHealth, double attackIncrease){
        super(enemyInfo, triggerHealth);
        this.attackIncrease = attackIncrease;
    }

    public double getAttackIncrease(){
        return this.attackIncrease;
    }
}
