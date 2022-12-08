package battlestates;

import battlestates.factories.BattleStateFactory;
import battlestates.states.BattleAskingState;
import core.StateManager;
import game_world.objects.Location;
import game_world.objects.events.EncounterEvent;
import game_world.objects.events.Event;
import interfaces.State;
import objects.battle.BattleEntityInteractor;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.factory.EnemyFactory;
import objects.character.Player;

public class BattleStateManager extends StateManager {
    /** Class that manages the Turn states during a battle encounter. In particular, the order of
     *  EnemyFacade and User turns. Uses PreBattle and PostBattle to determine set-up and results of battle.
     *  Attributes:
     *  user: Player object representing the user
     *  foe: EnemyFacade object representing who the user is battling
     */
    private BattleEntityInteractor battleEntityInteractor;
    private Location location;
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
        State chosenState;

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
                chosenState = battleStateFactory.createUserTurnState();
                switch (currChoice) {
                    case MENU:
                        chosenState = battleStateFactory.createBattleMenuState(currChoice);
                        break;
                    case SKILLS:
                        chosenState = battleStateFactory.createBattleSkillChoiceState(currChoice);
                        break;
                    case INVENTORY:
                        // chosenState = new InventoryState // Something like this
                        currChoice = BattleChoiceType.MENU;
                        chosenState = battleStateFactory.createBattleMenuState(currChoice);
                        break;
                }
            } else {
                String command = "use potion";
                if (currChoice == BattleChoiceType.SKILLS) {
                    command = "use skill";
                }

                chosenState = battleStateFactory.createEnemyTurnState(command);
                currChoice = BattleChoiceType.MENU;
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

    @Override
    public void initialize() {
        EnemyFactory enemyFactory = new EnemyFactory();
        Event currEvent = location.getCurrentArea().getCurrEvent();
        String chosenEnemy = "goblin warrior";
        EncounterEvent encounterEvent;

        if (currEvent != null && currEvent.type.equals(("Encounter"))) {
            encounterEvent = (EncounterEvent) currEvent;
            chosenEnemy = encounterEvent.getNPC();
        }
        battleEntityInteractor.setFoe(enemyFactory.createEnemy(chosenEnemy));

        // TEMP: For demo purposes only! Will remove once Player gets starting skills
        battleEntityInteractor.getUser().addSkill(new Skill("torch", 20, 10, SkillType.FIRE));
        battleEntityInteractor.getUser().addSkill(new Skill("spit", 20, 10, SkillType.WATER));
        battleEntityInteractor.getUser().addSkill(new Skill("pebble throw", 20, 10, SkillType.EARTH));
        battleEntityInteractor.getUser().addSkill(new Skill("sneeze", 20, 10, SkillType.AIR));
        battleEntityInteractor.getUser().addSkill(new Skill("tsunami", 90, 40, SkillType.WATER));

        currState = nextState("");
    }
}
