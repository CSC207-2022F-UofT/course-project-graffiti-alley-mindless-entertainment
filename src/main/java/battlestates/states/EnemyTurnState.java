package battlestates.states;

import interfaces.State;
import io.InputValidator;
import objects.battle.StatDisplayer;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.character.EnemyFacade;
import objects.character.Player;

public class EnemyTurnState implements State {
    private Player user;
    private EnemyFacade foe;
    private boolean done = false;
    private String userAction;

    public EnemyTurnState(Player user, EnemyFacade foe, String userAction) {
        this.user = user;
        this.foe = foe;
        this.userAction = userAction;
    }
    @Override
    public void preInput() {
        EnemyActionHandler action = foe.enemyAction(userAction);

        action.useAction(foe, user);

        StatDisplayer statDisplayer = new StatDisplayer();
        statDisplayer.displayStats(foe);
        statDisplayer.displayStats(user);

        foe.changeSpeed(-20); // Speed tax per turn
        this.done = true;
    }

    /**
     * EnemyTurnState does not need input from the user.
     * @param input from the user
     * Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
    }
    @Override
    public boolean awaitInput() {
        return false;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
