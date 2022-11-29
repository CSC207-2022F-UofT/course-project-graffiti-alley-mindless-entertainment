package objects.battle.enemy.gimmick;

import objects.battle.enemy.EnemyInfo;

public class SpeedGimmick extends Gimmick{
    private int speedIncrease;

    public SpeedGimmick(EnemyInfo enemyInfo, int triggerHealth, int speedIncrease){
        super(enemyInfo, triggerHealth);
        this.speedIncrease = speedIncrease;
    }

    public int getSpeedIncrease(){
        return this.speedIncrease;
    }
}
