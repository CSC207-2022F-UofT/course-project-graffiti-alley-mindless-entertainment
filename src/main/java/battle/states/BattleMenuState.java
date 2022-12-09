package battle.states;

import battle.entities.BattleChoiceType;
import battle.use_cases.BattleEntityInteractor;
import battle.use_cases.StatDisplayer;

import java.util.Arrays;

public class BattleMenuState extends BattleAskingState{
    /**
     * BattleAskingState that covers the scenario where the user is to choose between
     * different menus, i.e. Skill or Inventory menu, or wants to look at Stats.
     */

    public BattleMenuState(BattleEntityInteractor fighters, BattleChoiceType prevChoice) {
        super(fighters, prevChoice, Arrays.asList("Skills", "Inventory", "Stats"));
    }

    /**
     * Asks the user for input on what action they should do
     */
    @Override
    public void preInput() {
        output.generateTextWithOptions("Select an option: ", this.options);
        this.awaitingInput = true;
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        String cleanInput = inputValidator.parseAndValidate(input);
        if (isValidInp(cleanInput)) {
            switch (cleanInput) {
                case "skills":
                    currChoice = BattleChoiceType.SKILLS;
                    this.done = true;
                    break;
                case "inventory":
                    currChoice = BattleChoiceType.INVENTORY;
                    this.done = true;
                    break;
                case "stats":
                    StatDisplayer statDisplayer = new StatDisplayer();
                    statDisplayer.displayStats(user, foe);
                    statDisplayer.displayStats(user.getSkillList());
                    break;
            }
            this.awaitingInput = false;
        }
    }

}
