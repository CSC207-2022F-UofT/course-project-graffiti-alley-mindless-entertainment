package objects.battle;

import objects.character.Player;

public class SkillHandler {
    public SkillHandler() {

    }
    /**
     * Returns whether a type advantage is present when base is being used on comparedTo.
     * Type advantages go as follows: AIR > WATER > FIRE > EARTH > AIR
     *
     * @param base The type that is being compared
     * @param comparedTo The type that base is being compared to
     * @return Whether base has a type advantage against type comparedTo
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
    }

    // CURRENTLY REDUNDANT CODE TEMPORARY SOLUTION, WILL NEED WRAPPER CLASS FOR BATTLE CHARACTERS LATER

    /**
     * Calculates damage done by skill to an enemy. Damage cannot be negative.
     *
     * @param skill Skill being used on enemy
     * @param foe Enemy skill is being used on
     * @return Damage the skill does to the enemy
     */
    public int calculateDamage(Skill skill, Enemy foe) {
        int damage = skill.getDamage();
        SkillType subjectType = foe.getType();

        if (hasTypeAdv(skill.getType(), subjectType)) {
            damage *= 1.2;
        }
        if (hasTypeAdv(subjectType, skill.getType())) {
            damage *= 0.8;
        }
        return Math.max((int) damage, 0);
    }

    /**
     * Calculates damage done to the user by a certain skill based type.
     * Damage cannot be negative.
     *
     * @param skill the skill that is being used
     * @param user the user that the skill is being used on
     * @return damage done to the user by the skill
     */
    public int calculateDamage(Skill skill, Player user) {
        double damage = skill.getDamage();
        SkillType subjectType = foe.getType();

        if (hasTypeAdv(skill.getType(), subjectType)) {
            damage *= 1.2;
        }
        if (hasTypeAdv(subjectType, skill.getType())) {
            damage *= 0.8;
        }

        return Math.max((int) damage, 0);
    }

    /**
     * Applies the damage the user does to the foe using the skill.
     *
     * @param skill The skill being used to attack the enemy
     * @param foe The enemy being attacked by the user by skill
     * @param user The user attacking the enemy
     */
    public int useSkill(Skill skill, Enemy foe, Player user) {
        int totalDamage = calculateDamage(skill, foe);

        foe.changeHealth(-totalDamage);
        user.changeSpeed(user.getSpeed() - skill.getLag());

        return totalDamage;
    }

    /**
     * Applies the damage the foe does to the user by the skill using calculateDamage and armor.
     *
     * @param skill Skill being used on the user
     * @param user The user being attacked by the enemy by skill
     * @param foe The enemy attacking the user
     */
    public int useSkill(Skill skill, Player user, Enemy foe) {
        int damage = calculateDamage(skill, user);
        int totalDamage = Math.max(0, damage - user.getArmor());

        user.changeCurrHealth((-1 * afterArmorDamage));
        user.changeArmor((-1 * (damage - totalDamage)));
        foe.setSpeed(foe.getSpeed() - skill.getLag());

        return totalDamage;
    }
}
