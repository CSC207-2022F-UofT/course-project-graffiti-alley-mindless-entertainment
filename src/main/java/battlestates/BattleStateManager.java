package battlestates;

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

    public BattleStateManager(Player user, Area currArea) throws Exception {
        this.user = user;
        this.currArea = currArea;
        EnemyFactory enemyFactory = new EnemyFactory();
        this.foe = (Enemy) enemyFactory.createEnemy("goblin"); // Temporary, use-case needed once decide which enemy
    }

    /**
     * Returns the next state based on the current state. If either enemy or user are dead, ends battle and
     * provides win or lose state accordingly.
     * @param input string input to dictate the next state, currently unused
     * @return the state that comes next in the battle.
     */
    @Override
    protected State nextState(String input) {
        boolean userNext = user.getSpeed() >= foe.getSpeed();
        State chosenState;

        // Win condition
        if (!foe.checkAlive()) {
            chosenState = new WinBattleState(user, foe);
            user.changeSpeed(100);
        }
        // Lose condition
        else if (this.user.getCurrHealth() <= 0) {
            chosenState = new LoseBattleState(user, foe);
            user.changeSpeed(100);
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

    /**
     * Calls the preinput function from the current state.
     * If the current state is done moves onto the next state.
     * When the current state is done and is a Win/Lose state, battle ends.
     * TEMPORARY, instead of battle ending for losing, resets health.
     */
    @Override
    public void preInput() {
        currState.preInput();
        boolean currStateDone = currState.isDone();

        if (currStateDone) {
            this.currState = this.nextState("");
            if (this.currState instanceof WinBattleState) {
                this.isDone = true;
            }
        }
    }

    /**
     * Passes on the user input from the shell to the current state.
     * If the current state is done moves onto the next state.
     * When the current state is done and is a Win/Lose state, battle ends.
     * TEMPORARY, instead of battle ending for losing, resets health.
     *
     * @param input User input given by the shell
     */
    @Override
    public void postInput(String input) {
        currState.postInput(input);
        boolean currStateDone = currState.isDone();

        if (currStateDone) {
            this.currState = this.nextState(input);
            if (this.currState instanceof WinBattleState) {
                this.isDone = true;
            }
        }
    }

    @Override
    public void initialize() {

    }
}
