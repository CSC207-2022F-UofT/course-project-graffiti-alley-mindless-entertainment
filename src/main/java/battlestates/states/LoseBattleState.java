package battlestates.states;

import core.ChoiceInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import objects.character.EnemyFacade;
import objects.character.Player;

import java.util.ArrayList;
import java.util.List;

public class LoseBattleState implements State {
    /** State which handles the result of a battle from BattleStateManager, thus ending the battle.
     *  Handles the case in where the user loses the battle, giving the user different options to proceed.
     *  Attributes:
     *  user: The Player that is participating in the battle
     *  foe: The EnemyFacade that the user is fighting
     *  done: represents whether the state is done
     */
    private Player user;
    private EnemyFacade foe;
    private boolean done = false;
    private boolean awaitingInput = false;
    private InputValidator validator;
    private final OutputHandler output = Output.getScreen();


    public LoseBattleState(Player user, EnemyFacade foe) {
        this.user = user;
        this.foe = foe;
    }

    /**　
     * Gives the user options on what to do once battle is lost.
     */
    @Override
    public void preInput() {
        String displayText = "You lost the battle. How would you like to proceed?";
        List<String> loseOptions = new ArrayList<>(); // TEMPORARY options
        loseOptions.add("Cheat and heal to full");
        loseOptions.add("Pretend you won");

        output.generateTextWithOptions(displayText, loseOptions);
        this.validator = new ChoiceInputValidator(loseOptions);
        this.awaitingInput = true;
    }

    /**
     * Decides which route to go depending on what the user chooses
     * @param input from the user
     * Executes after state awaited input
     */
    @Override
    public void postInput(String input) {
        String cleanInput = validator.parseAndValidate(input);

        switch(cleanInput) {
            case "cheat and heal to full": // TEMP, continue the battle with full health
                this.user.changeCurrHealth(user.getMaxHealth());
                this.done = true;
                break;
            case "pretend you won": // TEMP, pretending to win
                this.user.changeCurrHealth(1);
                this.foe.setHealth(0);
                this.done = true;
                break;
            default:
                output.generateText("Please enter a valid input.");
        }
        user.changeSpeed(100-user.getSpeed());
    }
    @Override
    public boolean awaitInput() {
        return this.awaitingInput;
    }

    /**
     * @return whether LoseBattleState is done, true once preInput() is called
     */
    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
