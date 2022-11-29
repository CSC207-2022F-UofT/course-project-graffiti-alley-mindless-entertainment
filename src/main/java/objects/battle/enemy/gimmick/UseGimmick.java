package objects.battle.enemy.gimmick;

import objects.battle.Skill;
import objects.battle.SkillType;

public class UseGimmick {
    private Gimmick gimmick;
    public UseGimmick(Gimmick gimmick){
        this.gimmick = gimmick;
    }

    public boolean useGimmick(){
        if(!this.gimmick.getUsedGimmick() && gimmick.getEnemyInfo().getHealth() <= gimmick.getTriggerHealth()){
            GimmickType gimmickType = this.gimmick.getName();
            if(gimmickType == GimmickType.HEALTH){
                useHealth();
            } else if (gimmickType == GimmickType.ATTACK) {
                useAttack();
            } else if (gimmickType == GimmickType.SPEED) {
                useSpeed();
            }else {
                useType();
            }
            this.gimmick.usedGimmick();
            return true;
        } else{
            return false;
        }

    }

    private void useAttack(){
        for(Skill skill: this.gimmick.getEnemyInfo().getSkills()){
            int i = skill.getDamage();
            skill.setDamage((int)Math.ceil(i * this.gimmick.getAttackIncrease()));
            }
    }

    private void useHealth(){
        this.gimmick.getEnemyInfo().setHealth(this.gimmick.getEnemyInfo().getMaxHealth());
    }

    private void useType(){
        SkillType type = this.gimmick.getEnemyInfo().getType();
        if(type == SkillType.WATER){
            this.gimmick.getEnemyInfo().setType(SkillType.FIRE);
        } else if(type == SkillType.FIRE){
            this.gimmick.getEnemyInfo().setType(SkillType.EARTH);
        } else if(type == SkillType.EARTH){
            this.gimmick.getEnemyInfo().setType(SkillType.AIR);
        } else{
            this.gimmick.getEnemyInfo().setType(SkillType.WATER);
        }
    }

    private void useSpeed(){
        this.gimmick.getEnemyInfo().changeSpeed(this.gimmick.getSpeedIncrease());
    }
}
