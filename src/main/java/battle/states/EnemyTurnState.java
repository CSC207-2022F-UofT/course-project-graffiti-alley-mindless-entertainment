package battle.states;

import battle.entities.BattleChoiceType;
import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import battle.use_cases.StatDisplayer;
import battle.use_cases.EnemyActionHandler;
import character.EnemyFighter;
import character.entities.Player;

public class EnemyTurnState implements State {
    /**
     * Battle state that deals with the state where it is the enemy's turn. The enemy's
     * action is decided through the enemy's AI.
     * Attributes:
     * user: Player object representing the user participating in the battle
     * foe: EnemyFighter object representing the encountered foe of the battle
     * done: Whether this state is done and ready to move on
     * awaitingInput: Whether this state needs input from the user
     * userAction: Enum that allows foe to know what the user did beforehand.
     */
    private final Player user;
    private final EnemyFighter foe;
    private boolean done = false;
    private boolean awaitingInput;
    private final BattleChoiceType userAction;

    public EnemyTurnState(Player user, EnemyFighter foe, BattleChoiceType userAction) {
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

        output.generateText("Press Enter to move to the next turn.");
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
