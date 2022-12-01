package objects.battle.enemy.ai;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;

public class EnemySkillHandler implements EnemyActionHandler{
    private final Skill skill;

    public EnemySkillHandler(Skill skill){
        this.skill = skill;
    }
    @Override
    public void useAction(EnemyFacade enemy, Player player){
        int damage = calculateDamage(skill, enemy.getType());
        player.changeCurrHealth(-damage);
    }

    @Override
    public void useAction(BossFacade boss, Player player) {
        int damage = calculateDamage(skill, boss.getType());
        player.changeCurrHealth(-damage);
    }


    private int calculateDamage(Skill skill, SkillType type) {
        int damage = skill.getDamage();

        if (hasTypeAdv(skill.getType(), type)) {
            damage *= 1.2;
        }
        if (hasTypeAdv(type, skill.getType())) {
            damage *= 0.8;
        }
        return Math.max((int) damage, 0);
    }


    private boolean hasTypeAdv(SkillType base, SkillType comparedTo) {
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
