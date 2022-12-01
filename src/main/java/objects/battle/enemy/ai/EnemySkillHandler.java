package objects.battle.enemy.ai;

import objects.battle.Skill;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;

public class EnemySkillHandler extends SkillHandler implements EnemyActionHandler{
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

}
