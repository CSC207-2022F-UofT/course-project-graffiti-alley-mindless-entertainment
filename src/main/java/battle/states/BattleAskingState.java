package battle.states;

import battle.entities.BattleChoiceType;
import core.ChoiceInputValidator;
import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import battle.use_cases.BattleEntityInteractor;
import character.EnemyFighter;
import character.entities.Player;

import java.util.List;

public abstract class BattleAskingState implements State {
    /**
     * Abstract class that probes for user input during a battle.*
     * Attributes:
     * inputValidator: InputValidator for parsing input
     * options: List of strings for what options the user can pick from
     * awaitingInput: boolean representing when to ask wait for input
     * done: boolean representing when this state is finished
     * user: Player object representing the user being asked
     * choiceType: enum representing the choice the player made
     * output: OutputHandler for generating output
     */
    protected InputValidator inputValidator;
    protected List<String> options;
    protected Boolean awaitingInput = false;
    protected Boolean done = false;
    protected Player user;
    protected EnemyFighter foe;
    protected BattleChoiceType currChoice;
    protected final OutputHandler output = Output.getScreen();

    public BattleAskingState(BattleEntityInteractor fighters, BattleChoiceType prevChoice) {
        this.user = fighters.getUser();
        this.foe = fighters.getFoe();
        this.currChoice = prevChoice;
    }

    public BattleAskingState(BattleEntityInteractor fighters, BattleChoiceType prevChoice, List<String> options) {
        this.user = fighters.getUser();
        this.foe = fighters.getFoe();
        this.currChoice = prevChoice;
        this.options = options;
        this.inputValidator = new ChoiceInputValidator(options);
    }

    @Override
    public void preInput() {
        output.generateText("What would you like to do?");
        this.awaitingInput = true;
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        this.done = true;
    }

    /**
     * Returns whether the input is valid (not null), if not null then sets to INVALID
     * @param cleanInput parsed input from postInput()
     * @return whether or not the input is null
     */
    protected boolean isValidInp(String cleanInput) {
        if (cleanInput == null) {
            output.generateText("Please enter valid input.");
            return false;
        }
        return true;
    }
    public BattleChoiceType getCurrChoice() {
        return this.currChoice;
    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {
        return this.awaitingInput;
    }

    /**
     * @return whether the state is done and ready to go to next state
     */
    @Override
    public boolean isDone() {
        return this.done;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}