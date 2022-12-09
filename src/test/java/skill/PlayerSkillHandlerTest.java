package skill;

import battle.use_cases.PlayerSkillHandler;
import battle.entities.Skill;
import battle.entities.SkillType;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import character.entities.Player;
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
