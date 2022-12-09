package battle.factories;

import battle.entities.BattleChoiceType;
import battle.states.*;
import core.State;
import battle.use_cases.BattleEntityInteractor;

public class BattleStateFactory {
    /**
     * Factory that creates Battle States needed to run an Encounter Event
     * Attributes:
     * battleEntityInteractor: Interactor that deals with checking stats of user and foe in battle
     */
    private final BattleEntityInteractor battleEntityInteractor;

    public BattleStateFactory(BattleEntityInteractor battleEntityInteractor) {
        this.battleEntityInteractor = battleEntityInteractor;
    }
    public State createWinBattleState() {
        return new WinBattleState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
    public State createLoseBattleState() {
        return new LoseBattleState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
    public State createEnemyTurnState(BattleChoiceType currChoice) {
        return new EnemyTurnState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe(), currChoice);
    }
    public State createBattleMenuState(BattleChoiceType currChoice) {
        return new BattleMenuState(battleEntityInteractor, currChoice);
    }
    public State createBattleSkillChoiceState(BattleChoiceType currChoice) {
        return new BattleSkillChoiceState(battleEntityInteractor, currChoice);
    }
    public State createBattleItemChoiceState(BattleChoiceType currChoice) {
        return new BattleItemChoiceState(battleEntityInteractor, currChoice);
    }
}
