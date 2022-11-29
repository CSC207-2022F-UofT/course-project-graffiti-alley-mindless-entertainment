package objects.battle.enemy.gimmick;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;

public class Gimmick {
    private GimmickType name;
    private EnemyInfo enemyInfo;
    private int triggerHealth;
    private int speedIncrease;
    private double attackIncrease;
    private SkillType type;
    private boolean UsedGimmick = false;

    public Gimmick(GimmickType name, EnemyInfo enemyInfo, int triggerHealth, int speed,
                   double attack, SkillType type){
        this.name = name;
        this.enemyInfo = enemyInfo;
        this.triggerHealth = triggerHealth;
        this.attackIncrease = attack;
        this.type = type;
        this.speedIncrease = speed;
    }

    public void usedGimmick(){
        this.UsedGimmick = true;
    }

    public EnemyInfo getEnemyInfo(){
        return this.enemyInfo;
    }

    public int getTriggerHealth(){
        return this.triggerHealth;
    }

    public boolean getUsedGimmick(){
        return this.UsedGimmick;
    }

    public GimmickType getName(){
        return this.name;
    }

    public int getSpeedIncrease() {
        return this.speedIncrease;
    }

    public double getAttackIncrease() {
        return this.attackIncrease;
    }

    public SkillType getType(){
        return this.type;
    }
}
