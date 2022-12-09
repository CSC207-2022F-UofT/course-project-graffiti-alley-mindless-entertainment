package battle;

import battle.entities.BattleChoiceType;
import battle.factories.BattleStateFactory;
import battle.states.BattleAskingState;
import core.StateManager;
import game_world.entities.Location;
import game_world.events.EncounterEvent;
import game_world.events.Event;
import core.State;
import battle.use_cases.BattleEntityInteractor;
import battle.factories.EnemyFactory;
import character.entities.Player;

public class BattleStateManager extends StateManager {
    /** Class that manages the Turn states during a battle encounter. In particular, the order of
     *  EnemyFacade and User turns. Uses PreBattle and PostBattle to determine set-up and results of battle.
     *  Attributes:
     *  user: Player object representing the user
     *  foe: EnemyFacade object representing who the user is battling
     */
    private final BattleEntityInteractor battleEntityInteractor;
    private final Location location;
    private BattleChoiceType currChoice;

    public BattleStateManager(Player user, Location location) {
        this.battleEntityInteractor = new BattleEntityInteractor(user);
        this.location = location;
        this.currChoice = BattleChoiceType.MENU;
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
        BattleStateFactory battleStateFactory = new BattleStateFactory(battleEntityInteractor);
        boolean userNext = battleEntityInteractor.userOutspeeds();
        State chosenState = null;

        if (battleEntityInteractor.isFoeDead()) {
            chosenState = battleStateFactory.createWinBattleState();
            this.isDone = true;
        }
        else if (battleEntityInteractor.isUserDead()) {
            chosenState = battleStateFactory.createLoseBattleState();
            this.isDone = true;
        }
        else {
            if (userNext) {
                switch (currChoice) {
                    case MENU:
                        chosenState = battleStateFactory.createBattleMenuState(currChoice);
                        break;
                    case SKILLS:
                        chosenState = battleStateFactory.createBattleSkillChoiceState(currChoice);
                        break;
                    case INVENTORY:
                        chosenState = battleStateFactory.createBattleItemChoiceState(currChoice);
                        break;
                }
            } else {
                chosenState = battleStateFactory.createEnemyTurnState(currChoice);
                currChoice = BattleChoiceType.MENU;
            }
        }
        return chosenState;
    }
    /**
     * Whether the state is done and ready to move to the next state
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
     * Whether the state is done and ready to move to the next state
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
        currState.postInput(input);
        if (currState instanceof BattleAskingState) {
            currChoice = ((BattleAskingState) currState).getCurrChoice();
        }
        boolean currPostInput = currState.isDone();
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }

    /**
     * Resets the manager to its constructed form, with the same player but new enemy depending on encounter
     */
    @Override
    public void initialize() {
        EnemyFactory enemyFactory = new EnemyFactory();
        Event currEvent = null;
        if (location != null) {
            currEvent = location.getCurrEvent();
        }
        String chosenEnemy = "goblin warrior";
        EncounterEvent encounterEvent;

        if (currEvent != null && currEvent.type.equals(("Encounter"))) {
            encounterEvent = (EncounterEvent) currEvent;
            chosenEnemy = encounterEvent.getNPC();
        }
        battleEntityInteractor.setFoe(enemyFactory.createEnemy(chosenEnemy));
        currState = nextState("");
    }
}
