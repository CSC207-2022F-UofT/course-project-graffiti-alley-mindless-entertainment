package battlestates.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import objects.battle.StatDisplayer;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.character.EnemyFacade;
import objects.character.EnemyFighter;
import objects.character.Player;

public class EnemyTurnState implements State {
    private Player user;
    private EnemyFighter foe;
    private boolean done = false;
    private boolean awaitingInput;
    private String userAction;

    public EnemyTurnState(Player user, EnemyFighter foe, String userAction) {
        this.user = user;
        this.foe = foe;
        this.userAction = userAction;
    }
    @Override
    public void preInput() {
        StatDisplayer statDisplayer = new StatDisplayer();
        OutputHandler output = Output.getScreen();

        foe.applyGimmick();
        EnemyActionHandler action = foe.enemyAction(userAction);

        statDisplayer.displayPreBar();
        output.generateText(foe.getName() + " outsped you!");
        action.useAction(foe, user);
        statDisplayer.displayPostBar();

        foe.changeSpeed(-20); // Speed tax per turn
        statDisplayer.displayStats(user, foe);
        this.awaitingInput = true;
    }

    /**
     * EnemyTurnState does not need input from the user, user needs to press enter to continue.
     * @param input from the user
     * Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        this.awaitingInput = false;
        this.done = true;
    }
    @Override
    public boolean awaitInput() {
        return this.awaitingInput;
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
