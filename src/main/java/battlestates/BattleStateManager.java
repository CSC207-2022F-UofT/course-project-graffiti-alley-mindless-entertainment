package battlestates;

import battlestates.states.EnemyTurnState;
import battlestates.states.LoseBattleState;
import battlestates.states.UserTurnState;
import battlestates.states.WinBattleState;
import core.StateManager;
import game_world.objects.Location;
import game_world.objects.events.EncounterEvent;
import game_world.objects.events.Event;
import interfaces.State;
import io.Output;
import io.OutputHandler;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.factory.EnemyFactory;
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
    private Location location;

    public BattleStateManager(Player user, Location location) {
        this.user = user;
        this.location = location;
        initialize();
    }

    /**
     * Returns the next state based on the current state. If either EnemyFacade or user are dead, ends battle and
     * provides win or lose state accordingly.
     * @param input string input to dictate the next state, currently unused
     * @return the state that comes next in the battle. sometimes when the user enters the wrong number this class would be used to fix the difference between the se
     */
    @Override
    protected State nextState(String input) {
        boolean userNext = user.getSpeed() >= foe.getSpeed();
        State chosenState;

        if (!foe.checkAlive()) {
            chosenState = new WinBattleState(user, foe);
            this.isDone = true;
        }
        else if (user.getCurrHealth() <= 0) {
            chosenState = new LoseBattleState(user, foe);
            this.isDone = true;
        }
        else {
            if (userNext) {
                chosenState = new UserTurnState(user, foe);
            } else {
                chosenState = new EnemyTurnState(user, foe, input);
            }
        }
        return chosenState;
    }
    /**
     * @return whether the state is done and ready to move to the next state
     */
    @Override
    public void preInput() {
        currState.preInput();
        boolean currPreInput = currState.isDone();
        if (currPreInput) {
            this.currState = this.nextState("");
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }

    /**
     * @param input from the user
     * @return whether the state is done and ready to move to the next state
     */
    @Override
    public void postInput(String input) {
        currState.postInput(input);
        boolean currPostInput = currState.isDone();
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }

    @Override
    public void initialize() {
        EnemyFactory enemyFactory = new EnemyFactory();
        Event currEvent = location.getCurrEvent();
        String chosenEnemy = "goblin warrior";
        EncounterEvent encounterEvent;

        if (currEvent != null && currEvent.type.equals(("Encounter"))) {
            encounterEvent = (EncounterEvent) currEvent;
            chosenEnemy = encounterEvent.getNPC();
        }
        this.foe = enemyFactory.createEnemy(chosenEnemy);

        // TEMP: For demo purposes only! Will remove once Player gets starting skills
        user.addSkill(new Skill("torch", 20, 10, SkillType.FIRE));
        user.addSkill(new Skill("spit", 20, 10, SkillType.WATER));
        user.addSkill(new Skill("pebble throw", 20, 10, SkillType.EARTH));
        user.addSkill(new Skill("sneeze", 20, 10, SkillType.AIR));
        user.addSkill(new Skill("tsunami", 90, 40, SkillType.WATER));

        currState = nextState("");
    }
}
