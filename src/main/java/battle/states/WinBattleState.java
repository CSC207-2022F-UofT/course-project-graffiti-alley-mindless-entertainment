package battle.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import character.EnemyFighter;
import character.entities.Player;
import core.switch_managers.switch_events.SwitchEventMediatorProxy;
import core.switch_managers.switch_events.SwitchEventType;

public class WinBattleState implements State {
    /** State which handles the result of a battle from BattleStateManager, thus ending the battle.
     *  Handles the case in where the user wins the battle, giving the user relevant stat changes and/or items
     *  Attributes:
     *  user: The Player that is participating in the battle
     *  foe: The EnemyFacade that the user is fighting
     *  done: represents whether the state is done
     */
    private final Player user;
    private final EnemyFighter foe;
    private boolean done = false;

    public WinBattleState(Player user, EnemyFighter foe) {
        this.user = user;
        this.foe = foe;
    }

    /**
     * Gives exp, loot, and reputation changes to the player.
     */
    @Override
    public void preInput() {
        OutputHandler output = Output.getScreen();
        int expGain = 100; // Will be changed later depending on final exp mechanic
        // int repChange = foe.getReputation();

        // expGain = foe.getExp() * expModifier // Something along the lines of this in the future
        user.changeExperience(expGain);
        // Something that adds loot into the user's inventory, so far no loot table.
        // user.changeReputation(repChange); // Currently no implementation

        String winText = foe.getName() + " has been defeated! You earned " + expGain
                + " experience points, unless you cheated ;)";
        output.generateText(winText);
        user.changeSpeed(100 - user.getSpeed()); // Resets speed to 100

        this.done = true;
        SwitchEventMediatorProxy.getInstance().store(SwitchEventType.BATTLE_END); // Moves to a new event
    }

    @Override
    public void postInput(String input) {

    }
    @Override
    public boolean awaitInput() {
        return false;
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
