package battlestates.states;

import interfaces.State;
import io.InputValidator;
import io.OutputHandlerImpl;
import objects.character.Enemy;
import objects.character.Player;

import java.util.ArrayList;
import java.util.List;

public class LoseBattleState implements State {
    /** State which handles the result of a battle from BattleStateManager, thus ending the battle.
     *  Handles the case in where the user loses the battle, giving the user different options to proceed.
     *  Attributes:
     *  user: The Player that is participating in the battle
     *  foe: The Enemy that the user is fighting
     *  done: represents whether the state is done
     */
    private Player user;
    private Enemy foe;
    private boolean done = false;
    private boolean awaitingInput = false;

    public LoseBattleState(Player user, Enemy foe) {
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

        OutputHandlerImpl.getScreen().generateTextWithOptions(displayText, loseOptions);
        this.awaitingInput = true;
    }

    /**
     * Decides which route to go depending on what the user chooses when they lost.
     * @param input from the user
     * Executes after state awaited input
     */
    @Override
    public void postInput(String input) {
        switch(input) {
            case "A": // TEMPORARY CASE, continue the battle with full health
                this.user.changeCurrHealth(user.getMaxHealth());
            case "B": // TEMPORARY CASE, pretending to win
                this.user.changeCurrHealth(1);
                this.foe.setHealth(0);
        }
        user.changeSpeed(100 - user.getSpeed());
        this.done = true;
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
