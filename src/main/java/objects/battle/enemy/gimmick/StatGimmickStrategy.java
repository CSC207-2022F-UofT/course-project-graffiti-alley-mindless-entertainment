package objects.battle.enemy.gimmick;

import objects.battle.Skill;

public class StatGimmickStrategy implements GimmickStrategy{
    /** This class is the Gimmick use case that uses gimmick.
     * Attribute: gimmick that has been used
     */
    private StatGimmickEntity gimmick;

    /** This is the constructor of the UseGimmick class that takes gimmick as a parameter
     * @param gimmick: gimmick that has been used
     */
    public StatGimmickStrategy(StatGimmickEntity gimmick){
        this.gimmick = gimmick;
    }

    /** This is a method that actually use the gimmick that is given in the constructor.
     * @return boolean: if return true if the gimmick is successfully used.
     */
    public boolean useGimmick(){
        if(!this.gimmick.getUsedGimmick() && gimmick.getEnemyInfo().getHealth() <= gimmick.getTriggerHealth()){
            GimmickType gimmickType = this.gimmick.getName();
            if(gimmickType == GimmickType.TYPE){
                useType();
            } else if (gimmickType == GimmickType.ATTACK) {
                useAttack();
            } else if (gimmickType == GimmickType.SPEED) {
                useSpeed();
            }else {
                useHealth();
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
