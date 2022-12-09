package objects.skill;

import objects.battle.skills.PlayerSkillHandler;
import objects.battle.skills.Skill;
import objects.battle.skills.SkillType;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.EnemyFighter;
import objects.character.Player;
import org.junit.Test;

public class PlayerSkillHandlerTest {
    @Test
    public void useSkillTest() {
        Player user = new Player("", SkillType.EARTH);
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        PlayerSkillHandler psh = new PlayerSkillHandler();
        Skill skill = new Skill("fireball", 10, 10, SkillType.EARTH);
        assert(psh.useSkill(skill, foe, user) == 10);
        assert(user.getCurrHealth() == 90);
    }
}
