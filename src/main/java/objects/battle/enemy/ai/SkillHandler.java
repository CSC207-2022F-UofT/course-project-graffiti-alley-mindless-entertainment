package objects.battle.enemy.ai;

import objects.battle.Skill;
import objects.battle.SkillType;

public class SkillHandler {
    protected int calculateDamage(Skill skill, SkillType type) {
        int damage = skill.getDamage();

        if (hasTypeAdv(skill.getType(), type)) {
            damage *= 1.2;
        }
        if (hasTypeAdv(type, skill.getType())) {
            damage *= 0.8;
        }
        return Math.max((int) damage, 0);
    }


    protected boolean hasTypeAdv(SkillType base, SkillType comparedTo) {
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
