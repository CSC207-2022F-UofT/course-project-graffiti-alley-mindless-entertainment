package battlestates;

import battlestates.states.EnemyTurnState;
import battlestates.states.LoseBattleState;
import battlestates.states.UserTurnState;
import battlestates.states.WinBattleState;
import core.StateManager;
import game_world.objects.areas.Area;
import interfaces.State;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.Enemy;
import objects.character.Player;

public class BattleStateManager extends StateManager {
    /** Class that manages the Turn states during a battle encounter. In particular, the order of
     *  Enemy and User turns. Uses PreBattle and PostBattle to determine set-up and results of battle.
     *  Attributes:
     *  user: Player object representing the user
     *  foe: Enemy object representing who the user is battling
     */
    private Player user;
    private Area currArea;
    private Enemy foe;

    public BattleStateManager(Player user) {
        this.user = user;
    }

    /**
     * Returns the next state based on the current state. If either enemy or user are dead, ends battle and
     * provides win or lose state accordingly.
     * @param input string input to dictate the next state, currently unused
     * @return the state that comes next in the battle. someitmes when the user enters the wrong number this class would be used to fix the difference between the se
     */
    @Override
    protected State nextState(String input) {
        boolean userNext = user.getSpeed() >= foe.getSpeed();
        State chosenState;

        // Win condition
        if (!foe.checkAlive()) {
            chosenState = new WinBattleState(user, foe);
            this.isDone = true;
        }
        // Lose condition
        else if (this.user.getCurrHealth() <= 0) {
            chosenState = new LoseBattleState(user, foe);
            this.isDone = true;
        }
        // Normal battle turn ordering, characters can get multiple turns in a row if high enough speed.
        else {
            if (userNext) {
                chosenState = new UserTurnState(user, foe);
            }
            else {
                chosenState = new EnemyTurnState(user, foe, input);
            }
        }
        return chosenState;
    }
    @Override
    public void initialize() {
        EnemyFactory enemyFactory = new EnemyFactory();
        this.foe = enemyFactory.createEnemy("goblin"); // Temporary, use-case needed once decide which enemy
    }
}
