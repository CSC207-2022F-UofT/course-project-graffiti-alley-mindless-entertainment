package objects.battle.enemy.gimmick;

import io.Output;
import io.OutputHandler;
import objects.battle.Skill;
import objects.battle.SkillType;

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
    public void useGimmick(){
        if(!this.gimmick.getUsedGimmick() && gimmick.getEnemyInfo().getHealth() <= gimmick.getTriggerHealth()){
            GimmickType gimmickType = this.gimmick.getName();
            this.gimmick.usedGimmick();
            if(gimmickType == GimmickType.TYPE){
                useType();
            } else if (gimmickType == GimmickType.ATTACK) {
                useAttack();
            } else if (gimmickType == GimmickType.SPEED) {
                useSpeed();
            }else {
                useHealth();
            }

        }

    }

    private void useAttack(){
        for(Skill skill: this.gimmick.getEnemyInfo().getSkills()){
            int i = skill.getDamage();
            skill.setDamage((int)Math.ceil(i * this.gimmick.getAttackIncrease()));
            }
        OutputHandler output = Output.getScreen();
        output.generateText("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "damage of skills increased by " + this.gimmick.getAttackIncrease() + "!");
    }

    private void useHealth(){
        this.gimmick.getEnemyInfo().setHealth(this.gimmick.getEnemyInfo().getMaxHealth());
        OutputHandler output = Output.getScreen();
        output.generateText("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's health is fully healed!");
    }

    private void useType(){
        this.gimmick.getEnemyInfo().setType(this.gimmick.getType());
        String type;
        if(gimmick.getType() == SkillType.AIR){
            type = "air";
        } else if (gimmick.getType() == SkillType.EARTH) {
            type = "earth";
        } else if (gimmick.getType() == SkillType.FIRE) {
            type = "fire";
        } else{
            type = "water";
        }
        OutputHandler output = Output.getScreen();
        output.generateText("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's type changed to " + type + "!");
    }

    private void useSpeed(){
        this.gimmick.getEnemyInfo().changeSpeed(this.gimmick.getSpeedIncrease());
        OutputHandler output = Output.getScreen();
        output.generateText("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's speed increased by " + this.gimmick.getSpeedIncrease() + "!");
    }
}
