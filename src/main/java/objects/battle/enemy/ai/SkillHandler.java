package objects.battle.enemy.ai;

import objects.battle.Skill;
import objects.battle.SkillType;

public class SkillHandler {

    /**
     * This method calculates the damage to the opponent.
     * @param skill: skill that is used
     * @param type : type of the character that is attacked
     * @return the damage to a character with type in int
     */
    public int calculateDamage(Skill skill, SkillType type) {
        if (hasTypeAdv(skill.getType(), type)) {
            return ((int)Math.ceil(1.2 * skill.getDamage()));
        } else if (hasTypeAdv(type, skill.getType())) {
            return ((int)Math.ceil(0.8 * skill.getDamage()));
        }
        return skill.getDamage();
    }


    /**
     * This method determines if the attacker and defender has type advantage or not
     * @param base: SkillType of the type of the attacker.
     * @param comparedTo: SkillType of the defender.
     * @return boolean, and returns true if there is type advantage, and returns false otherwise
     *
     */
    public boolean hasTypeAdv(SkillType base, SkillType comparedTo) {
        switch (base) {
            case AIR:
                return comparedTo == SkillType.WATER;
            case EARTH:
                return comparedTo == SkillType.AIR;
            case FIRE:
                return comparedTo == SkillType.EARTH;
            case WATER:
                return comparedTo == SkillType.FIRE;
        }
        return false;
    }
}
