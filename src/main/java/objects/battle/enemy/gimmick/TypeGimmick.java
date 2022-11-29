package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class TypeGimmick extends Gimmick{
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    //In this turn gimmick, whenever, the gimmick is triggered, only enemy
    // will attack in the next turn.
    private boolean GimmickUsed = false;
    /**
     * This is a constructor of type gimmick
     * @param enemyInfo: enemyInfo which has all the information about the enemy
     *
     */
    public TypeGimmick(EnemyInfo enemyInfo, int triggerHealth){
        super(enemyInfo, triggerHealth);
    }

}
