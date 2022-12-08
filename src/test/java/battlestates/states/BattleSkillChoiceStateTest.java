package battlestates.states;

import battlestates.BattleChoiceType;
import objects.battle.BattleEntityInteractor;
import objects.battle.enemy.factory.EnemyFactory;
import objects.battle.skills.Skill;
import objects.battle.skills.SkillType;
import objects.character.EnemyFighter;
import objects.character.Player;
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
