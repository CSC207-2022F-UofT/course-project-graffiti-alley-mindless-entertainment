package battlestates.factories;

import battlestates.BattleChoiceType;
import battlestates.states.*;
import interfaces.State;
import objects.battle.BattleEntityInteractor;

public class BattleStateFactory {
    /**
     * Factory to create Battle States to avoid dependencies
     * Attributes:
     * battleEntityInteractor: Interactor that deals with checking stats of user and foe in battle
     */
    public BattleEntityInteractor battleEntityInteractor;

    public BattleStateFactory(BattleEntityInteractor battleEntityInteractor) {
        this.battleEntityInteractor = battleEntityInteractor;
    }
    public State createWinBattleState() {
        return new WinBattleState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
    public State createLoseBattleState() {
        return new LoseBattleState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
    public State createEnemyTurnState(String input) {
        return new EnemyTurnState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe(), input);
    }
    public State createUserTurnState() {
        return new UserTurnState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
    public State createBattleMenuState(BattleChoiceType currChoice) {
        return new BattleMenuState(battleEntityInteractor, currChoice);
    }
    public State createBattleSkillChoiceState(BattleChoiceType currChoice) {
        return new BattleSkillChoiceState(battleEntityInteractor, currChoice);
    }

}
