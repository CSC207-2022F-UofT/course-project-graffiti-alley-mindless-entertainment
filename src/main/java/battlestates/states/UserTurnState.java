package battlestates.states;

import core.ChoiceInputValidator;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import objects.battle.Skill;
import objects.battle.PlayerSkillHandler;
import objects.battle.StatDisplayer;
import objects.battle.enemy.SkillHelper;
import objects.character.EnemyFacade;
import objects.character.EnemyFighter;
import objects.character.Player;
import objects.inventory.Inventory;

import java.util.Arrays;
import java.util.List;

public class UserTurnState implements State {
    /**
     * State which probes and determines what the user does on their turn during a battle.
     * Attributes:
     * user: Player object representing the user engaged in the battle
     * foe: EnemyFacade object that the user is engaged in battle with
     * done: Boolean showing whether the state is done
     * skillList: String representation of the skills in user
     * awaitingInp: Boolean showing whether the state is waiting for input
     */
    private Player user;
    private EnemyFighter foe;
    private boolean done = false;
    private List<String> skillList;
    private List<String> invList;
    ;
    private boolean awaitingInp = false;
    private InputValidator validator;
    private int questionNum = 0;
    private final OutputHandler output = Output.getScreen();
    private final List<String> menuList = Arrays.asList("Skills", "Inventory", "Stats");

    public UserTurnState(Player user, EnemyFighter foe) {
        // Will need to change later to accommodate other options, like inventory
        SkillHelper dummy = new SkillHelper();
        this.skillList = dummy.toSkillString(user.getSkillList());
        this.skillList.add("Back");
        this.user = user;
        this.foe = foe;
        this.invList = this.user.getInventory().toStringList();
        this.invList.add("Back");
    }

    /**
     * Asks the user for input on what action they want to do.
     */
    @Override
    public void preInput() {
        switch (questionNum) {
            case 0:
                // Asking the user for input
                output.generateTextWithOptions("Select an option:", menuList);
                validator = new ChoiceInputValidator(menuList);
                break;
            case 1:
                output.generateTextWithOptions("Pick a skill:", skillList);
                validator = new ChoiceInputValidator(skillList);
                break;
            case 2:
                output.generateTextWithOptions("Pick an item:", invList);
                validator = new ChoiceInputValidator(invList);
                break;
            default:
                output.generateText("Not implemented yet, sorry try again.");
                break;
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
        StatDisplayer statDisplayer = new StatDisplayer();

        String cleanInput = validator.parseAndValidate(input);
        if (cleanInput == null) {
            questionNum = -1;
            output.generateText("Please enter valid input.");
        }

        switch (questionNum) {
            case 0:
                if (cleanInput.equals("skills")) {
                    questionNum = 1; // Redirects to asking which skill
                }
                if (cleanInput.equals("inventory")) {
                    questionNum = 2; // Redirects to asking which item
                }
                if (cleanInput.equals("stats")) {
                    statDisplayer.displayStats(user, foe);
                    statDisplayer.displayStats(user.getSkillList());
                }
                break;
            case 1:
                if (cleanInput.equals("back")) {
                    questionNum = 0; // Escape back to battle options
                    break;
                }

                // Setup
                SkillHelper skillHelper = new SkillHelper();
                Skill chosenSkill = skillHelper.findSkill(cleanInput, user.getSkillList());
                PlayerSkillHandler skillHandler = new PlayerSkillHandler();
                int damage = skillHandler.useSkill(chosenSkill, foe, user);

                // Outputs and uses the chosen skill.
                statDisplayer.displayPreBar();
                output.generateText(chosenSkill.getName() + " did " + damage + " damage!");
                statDisplayer.displayPostBar();
                statDisplayer.displayStats(user, foe);

                // Each turn takes 20 speed, preventing too many turns.
                user.changeSpeed(-20);

                this.done = true;
                break;
            case 2:
                if (cleanInput.equals("back")) {
                    questionNum = 0; // Escape back to battle options
                    break;
                }

                // Setup
                String chosenItem = cleanInput;

                // Outputs and uses the chosen item
                statDisplayer.displayPreBar();
                output.generateText(chosenItem);
                statDisplayer.displayPostBar();

                // Using items take only 10 speed
                user.changeSpeed(-10);

                this.done = true;
                break;
            default:
                questionNum = 0; // Redirects to Skill Inv question
        }
        awaitingInp = false;
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
        return this.validator;
    }
}
