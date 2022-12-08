package battlestates.factories;

import battlestates.states.WinBattleState;
import interfaces.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BattleStateFactoryTest {
    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public State createWinBattleStateTest() {

        return new WinBattleState(battleEntityInteractor.getUser(), battleEntityInteractor.getFoe());
    }
}
