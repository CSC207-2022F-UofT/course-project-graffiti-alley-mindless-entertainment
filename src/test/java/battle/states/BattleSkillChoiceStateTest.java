package battle.states;

import battle.entities.BattleChoiceType;
import battle.use_cases.BattleEntityInteractor;
import battle.factories.EnemyFactory;
import battle.entities.Skill;
import battle.entities.SkillType;
import character.EnemyFighter;
import character.entities.Player;
import org.junit.Test;

public class BattleSkillChoiceStateTest {
    @Test
    public void skillChoiceStateTest() {
        Player user = new Player("", null);
        user.addSkill(new Skill("dummy", 0, 0, SkillType.EARTH));
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        BattleEntityInteractor bei = new BattleEntityInteractor(user, foe);
        BattleChoiceType action = BattleChoiceType.SKILLS;
        BattleSkillChoiceState test = new BattleSkillChoiceState(bei, action);

        assert(!test.awaitInput());
        assert(!test.isDone());
        test.preInput();
        assert(test.awaitInput());
        test.postInput("a");
        assert(user.getSpeed() == 90);
        assert(!test.awaitInput());
        assert(test.isDone());
    }
}
