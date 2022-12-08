package battlestates.states;

import battlestates.BattleChoiceType;
import objects.battle.BattleEntityInteractor;
import objects.battle.StatDisplayer;

import java.util.Arrays;

public class BattleMenuState extends BattleAskingState{
    /**
     * Constructs BattleMenuState using super and a preset menu list options.
     * @param prevChoice previous choice of BattleChoiceType
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
                    break;
                case "inventory":
                    currChoice = BattleChoiceType.INVENTORY;
                    break;
                case "stats":
                    StatDisplayer statDisplayer = new StatDisplayer();
                    statDisplayer.displayStats(user, foe);
                    statDisplayer.displayStats(user.getSkillList());
                    break;
            }
            this.awaitingInput = false;
            this.done = true;
        }
    }

}
