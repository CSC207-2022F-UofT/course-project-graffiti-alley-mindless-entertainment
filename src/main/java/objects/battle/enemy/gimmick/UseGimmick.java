package objects.battle.enemy.gimmick;

import objects.battle.Skill;
import objects.battle.SkillType;

public class UseGimmick {
    /** This class is the Gimmick use case that uses gimmick.
     * Attribute: gimmick that has been used
     */
    private Gimmick gimmick;

    /** This is the constructor of the UseGimmick class that takes gimmick as a parameter
     * @param gimmick: gimmick that has been used
     */
    public UseGimmick(Gimmick gimmick){
        this.gimmick = gimmick;
    }

    /** This is a method that actually use the gimmick that is given in the constructor.
     * @return boolean: if return true if the gimmick is successfully used.
     */
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
        this.gimmick.getEnemyInfo().setType(this.gimmick.getType());
    }

    private void useSpeed(){
        this.gimmick.getEnemyInfo().changeSpeed(this.gimmick.getSpeedIncrease());
    }
}
