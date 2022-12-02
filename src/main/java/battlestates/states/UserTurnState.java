package battlestates.states;

import core.ChoiceInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import io.OutputHandlerImpl;
import objects.battle.Skill;
import objects.battle.PlayerSkillHandler;
import objects.battle.enemy.SkillHelper;
import objects.character.Enemy;
import objects.character.Player;

import java.util.Arrays;
import java.util.List;

public class UserTurnState implements State {
    /**
     * State which probes and determines what the user does on their turn during a battle.
     * Attributes:
     * user: Player object representing the user engaged in the battle
     * foe: Enemy object that the user is engaged in battle with
     * done: Boolean showing whether the state is done
     * skillList: String representation of the skills in user
     * awaitingInp: Boolean showing whether the state is waiting for input
     */
    private Player user;
    private Enemy foe;
    private boolean done = false;
    private List<String> skillList;
    private boolean awaitingInp = false;
    private InputValidator validator;
    private int questionNum = 0;

    public UserTurnState(Player user, Enemy foe) {
        // Will need to change later to accommodate other options, like inventory
        SkillHelper dummy = new SkillHelper();
        this.skillList = dummy.toSkillString(user.getSkillList());
        this.skillList.add("Back");
        this.user = user;
        this.foe = foe;
    }

    /**
     * Asks the user for input on what action they want to do.
     */
    @Override
    public void preInput() {
        OutputHandler output = Output.getScreen();

        if (questionNum == 0) {
            // Asking the user for input
            output.generateTextWithOptions("Select a menu", Arrays.asList("Skills", "Inventory"));
            this.validator = new ChoiceInputValidator(Arrays.asList("Skills", "Inventory"));
        }
        else if (questionNum == 1) {
            output.generateTextWithOptions("Pick a skill", );
            this.validator = new ChoiceInputValidator(this.skillList);
        }
        else if (questionNum == 2) {
            output.generateTextWithOptions("Pick an item," user.getInventory());
        }
        else {

        }
        awaitingInp = true;
    }

    /**
     * Applies the chosen skill based on the input from the user. Displays text
     * describing the action that took place. Changes user's speed accordingly.
     *
     * @param input from the user
     * Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        // VALIDATE THE INPUT FIRST
        SkillHelper dummy = new SkillHelper();
        Skill chosenSkill = dummy.findSkill(input, user.getSkillList());
        if (chosenSkill == null) {
            OutputHandlerImpl.getScreen().generateText("That skill doesn't exist, please enter a valid skill.");
        }
        else {
            PlayerSkillHandler skillHandler = new PlayerSkillHandler();
            int damage = skillHandler.useSkill(chosenSkill, foe, user);

            // Outputs and uses the chosen skill.
            OutputHandlerImpl.getScreen().generateText("You used " + chosenSkill.getName() +
                    " to do " + damage + " damage!");

            // Each turn takes 20 speed, preventing too many turns.
            user.changeSpeed(user.getSpeed() - 20);

            // Later change so that the state will stay to ask more questions like menu or inventory.
            this.done = true;
        }
    }

    @Override
    public boolean awaitInput() {
        return this.awaitingInp;
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
