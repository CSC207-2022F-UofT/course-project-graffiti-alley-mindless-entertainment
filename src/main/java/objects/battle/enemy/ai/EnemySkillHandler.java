package objects.battle.enemy.ai;

import io.Output;
import io.OutputHandler;
import objects.battle.skills.Skill;
import objects.character.EnemyFighter;
import objects.character.Player;

/**
 * This class is a use case for the EnemySkill which calculates the damage
 * depending on the type advantage and actually updates the Player's stats.
 *
 */
public class EnemySkillHandler extends SkillHandler implements EnemyActionHandler{
    /**
     * skill: the skill that the enemy used
     */
    private final Skill skill;

    /**
     * This method is a constructor of the use case and takes skill as a
     * parameter.
     * @param skill: skill that the enemy used
     *
     */
    public EnemySkillHandler(Skill skill){
        this.skill = skill;
    }
    /**
     * This method calculates the damage to the user and
     * updates the stats
     * @param enemy: enemy that is attacking
     * @param player : player that is attacked
     */
    @Override
    public void useAction(EnemyFighter enemy, Player player){
        int damage = calculateDamage(skill, enemy.getType());
        player.changeCurrHealth(-damage);
        enemy.changeSpeed(-skill.getLag());
        OutputHandler output = Output.getScreen();
        output.generateText(enemy.getName() + " has used " + this.skill.getName() + " with " + this.skill.getDamage()
                + " damage!");
    }



}
