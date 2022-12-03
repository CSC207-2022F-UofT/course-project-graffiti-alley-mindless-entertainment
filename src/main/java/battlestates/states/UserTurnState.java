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
import objects.character.EnemyFacade;
import objects.character.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    private EnemyFacade foe;
    private boolean done = false;
    private List<String> skillList;
    private boolean awaitingInp = false;
    private InputValidator validator;
    private int questionNum = 0;
    private final OutputHandler output = Output.getScreen();
    private final List<String> menuList = Arrays.asList("Skills", "Inventory", "Stats");

    public UserTurnState(Player user, EnemyFacade foe) {
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
        switch (questionNum) {
            case 0:
                // Asking the user for input
                output.generateTextWithOptions("Select an option:", menuList);
                this.validator = new ChoiceInputValidator(menuList);
                break;
            case 1:
                output.generateTextWithOptions("Pick a skill:", skillList);
                this.validator = new ChoiceInputValidator(this.skillList);
                break;
            case 2:
                output.generateText("Inventory not implemented yet, try again.");
//            output.generateTextWithOptions("Pick an item", user.getInventory()); // No inventory yet
                break;
            case 3:
                output.generateText("Not implemented yet, try again.");
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
        String cleanInput = validator.parseAndValidate(input);
        if (cleanInput == null) {
            questionNum = -1;
            output.generateText("");
        }
        output.generateText("TESTING" + cleanInput);

        switch (questionNum) {
            case 0:
                if (cleanInput.equals("Skills")) {
                    questionNum = 1; // Redirects to asking which skill
                }
                if (cleanInput.equals("Inventory")) {
                    questionNum = 2;
                }
                if (cleanInput.equals("Stats")) {
                    String foeStats = "Name: " + foe.getName() +
                            " | HP: " + foe.getHealth() +
                            " | Speed: " + foe.getSpeed() +
                            " | Type: " + foe.getType();
                    String userStats = "Name: " + user.getName() +
                            " | HP: " + user.getCurrHealth() +
                            " | Speed: " + user.getSpeed() +
                            " | Type: " + user.getSkillType();
                    output.generateText("[ENEMY STATS] " + foeStats + "\n" +
                            "[PLAYER STATS]" + userStats + "\n");
                }
                break;
            case 1:
                SkillHelper skillHelper = new SkillHelper();
                Skill chosenSkill = skillHelper.findSkill(cleanInput, user.getSkillList());

                if (chosenSkill == null) {
                    output.generateText("That skill doesn't exist, please enter a valid skill.");
                } else {
                    PlayerSkillHandler skillHandler = new PlayerSkillHandler();
                    int damage = skillHandler.useSkill(chosenSkill, foe, user);

                    // Outputs and uses the chosen skill.
                    output.generateText(chosenSkill.getName() + " did " + damage + " damage!");

                    // Each turn takes 20 speed, preventing too many turns.
                    user.changeSpeed(user.getSpeed() - 20);

                    // Later change so that the state will stay to ask more questions like menu or inventory.
                    this.done = true;
                }
                break;
            case 2:
                questionNum = 0; // TEMP until inventory implementation
                break;
            default:
                questionNum = 0; // Redirects to Skill Inv question
        }
        output.generateText("POST TRIGGERED");
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
