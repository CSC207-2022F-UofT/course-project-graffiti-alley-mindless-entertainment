package battlestates.states;

import battlestates.BattleChoiceType;
import core.ChoiceInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import objects.character.Player;

import java.util.List;

public abstract class BattleAskingState implements State {
    /**
     * Abstract class that probes for user input during a battle.
     *
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
    protected BattleChoiceType currChoice;
    protected final OutputHandler output = Output.getScreen();

    public BattleAskingState(Player user, BattleChoiceType prevChoice) {
        this.user = user;
        this.currChoice = prevChoice;
    }

    public BattleAskingState(Player user, BattleChoiceType prevChoice, List<String> options) {
        this.user = user;
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
    protected boolean isValidInp(String cleanInput) {
        if (cleanInput == null) {
            currChoice = BattleChoiceType.INVALID;
            output.generateText("Please enter valid input.");
            return false;
        }
        return true;
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