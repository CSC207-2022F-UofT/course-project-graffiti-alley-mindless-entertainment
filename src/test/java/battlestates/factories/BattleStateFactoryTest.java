package battlestates.factories;

import battlestates.BattleChoiceType;
import battlestates.states.*;
import interfaces.State;
import objects.battle.BattleEntityInteractor;
import objects.battle.enemy.factory.EnemyFactory;
import objects.battle.skills.Skill;
import objects.battle.skills.SkillType;
import objects.character.EnemyFighter;
import objects.character.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class BattleStateFactoryTest {
    @Test
    public void stateCreationTests() {
        Player user = new Player("", null);
        user.addSkill(new Skill("dummy", 0, 0, SkillType.EARTH));
        EnemyFighter foe = new EnemyFactory().createEnemy("goblin");
        BattleEntityInteractor bei = new BattleEntityInteractor(user, foe);
        BattleChoiceType choice = BattleChoiceType.MENU;
        BattleStateFactory factory = new BattleStateFactory(bei);

        State test = factory.createBattleMenuState(choice);
        assert(test instanceof BattleMenuState);
        test = factory.createWinBattleState();
        assert(test instanceof WinBattleState);
        test = factory.createLoseBattleState();
        assert(test instanceof LoseBattleState);
        test = factory.createBattleItemChoiceState(choice);
        assert(test instanceof BattleItemChoiceState);
        test = factory.createBattleSkillChoiceState(choice);
        assert(test instanceof BattleSkillChoiceState);
        test = factory.createEnemyTurnState(choice);
        assert(test instanceof EnemyTurnState);
    }

}
