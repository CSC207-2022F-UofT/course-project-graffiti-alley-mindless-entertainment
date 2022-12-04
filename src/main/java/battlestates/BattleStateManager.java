package battlestates;

import battlestates.states.EnemyTurnState;
import battlestates.states.LoseBattleState;
import battlestates.states.UserTurnState;
import battlestates.states.WinBattleState;
import core.StateManager;
import interfaces.State;
import io.Output;
import io.OutputHandler;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.EnemyFacade;
import objects.character.EnemyFighter;
import objects.character.Player;

public class BattleStateManager extends StateManager {
    /** Class that manages the Turn states during a battle encounter. In particular, the order of
     *  EnemyFacade and User turns. Uses PreBattle and PostBattle to determine set-up and results of battle.
     *  Attributes:
     *  user: Player object representing the user
     *  foe: EnemyFacade object representing who the user is battling
     */
    private Player user;
    private EnemyFighter foe;
    private boolean awaitingInput = false;
    private final OutputHandler output = Output.getScreen();

    public BattleStateManager(Player user) {
        this.user = user;
        initialize();
    }

    /**
     * Returns the next state based on the current state. If either EnemyFacade or user are dead, ends battle and
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
        else if (user.getCurrHealth() <= 0) {
            chosenState = new LoseBattleState(user, foe);
            this.isDone = true;
        }
        // Normal battle turn ordering, characters can get multiple turns in a row if high enough speed.
        else {
            if (userNext) {
                output.generateText("You outsped the enemy. What would you like to do?");
                chosenState = new UserTurnState(user, foe);
            } else {
                output.generateText(foe.getName() + " outsped you!");
                chosenState = new EnemyTurnState(user, foe, input);
            }
            awaitingInput = chosenState.awaitInput();
        }
        return chosenState;
    }
    @Override
    public void preInput() {
        currState.preInput();
        awaitingInput = currState.awaitInput(); // Making sure await is updated
        boolean currPreInput = currState.isDone();
        if (currPreInput) {
            this.currState = this.nextState("");
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }
    @Override
    public void postInput(String input) {
        currState.postInput(input);
        awaitingInput = currState.awaitInput(); // Making sure await is updated
        boolean currPostInput = currState.isDone();
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }

    @Override
    public boolean awaitInput() {
        return awaitingInput;
    }
    @Override
    public void initialize() {
        EnemyFactory enemyFactory = new EnemyFactory();
        this.foe = enemyFactory.createEnemy("goblin"); // TEMP, later decide which enemy

        user.addSkill(new Skill("fireball", 20, 10, SkillType.FIRE));
        user.addSkill(new Skill("waterball", 20, 10, SkillType.WATER));

        currState = nextState("");
    }
}
