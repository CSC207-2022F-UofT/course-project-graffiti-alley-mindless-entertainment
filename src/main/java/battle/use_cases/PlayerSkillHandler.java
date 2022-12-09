package battle.use_cases;

import battle.entities.Skill;
import character.EnemyFighter;
import character.entities.Player;

public class PlayerSkillHandler extends SkillHandler {
    public PlayerSkillHandler() {

    }

    /**
     * Applies the damage the user does to the foe using the skill.
     *
     * @param skill The skill being used to attack the enemy
     * @param foe The EnemyFacade being attacked by the user by skill
     * @param user The user attacking the enemy
     */
    public int useSkill(Skill skill, EnemyFighter foe, Player user) {
        int totalDamage = calculateDamage(skill, foe.getType());

        foe.changeHealth(-totalDamage);
        user.changeSpeed(-skill.getLag());

        return totalDamage;
    }
}
