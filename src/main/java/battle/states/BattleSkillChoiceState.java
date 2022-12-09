package battle.states;

import battle.entities.BattleChoiceType;
import core.ChoiceInputValidator;
import battle.use_cases.BattleEntityInteractor;
import battle.use_cases.PlayerSkillHandler;
import battle.entities.Skill;
import battle.use_cases.StatDisplayer;
import battle.use_cases.SkillHelper;

public class BattleSkillChoiceState extends BattleAskingState {
    /**
     * BattleAskingState child class that asks for the skill the user wants to use from
     * their list of skills.
     * Attributes:
     * skillHelper: Use case that applies effects from the chosen skill onto the foe
     */
    private final SkillHelper skillHelper = new SkillHelper();

    public BattleSkillChoiceState(BattleEntityInteractor fighters, BattleChoiceType prevChoice) {
        super(fighters, prevChoice);
        this.user = fighters.getUser();
        this.foe = fighters.getFoe();
        this.options = skillHelper.toSkillString(user.getSkillList());
        this.options.add("Back");
        this.inputValidator = new ChoiceInputValidator(options);
    }
    @Override
    public void preInput() {
        output.generateTextWithOptions("Pick a skill to use: ", options);
        this.awaitingInput = true;
    }
    public void postInput(String input) {
        String cleanInput = inputValidator.parseAndValidate(input);
        if (isValidInp(cleanInput)) {
            if (cleanInput.equals("back")) {
                currChoice = BattleChoiceType.MENU;
            } else {
                StatDisplayer statDisplayer = new StatDisplayer();
                Skill chosenSkill = skillHelper.findSkill(cleanInput, user.getSkillList());
                PlayerSkillHandler skillHandler = new PlayerSkillHandler();
                int damage = skillHandler.useSkill(chosenSkill, foe, user);
                user.changeSpeed(-20);

                statDisplayer.displayPreBar();
                output.generateText(chosenSkill.getName() + " did " + damage + " damage!");
                statDisplayer.displayPostBar();
                statDisplayer.displayStats(user, foe);
            }
            this.awaitingInput = false;
            this.done = true;
        }
    }
}
