package battlestates.states;

import battlestates.BattleChoiceType;
import core.ChoiceInputValidator;
import io.Output;
import objects.battle.BattleEntityInteractor;
import objects.battle.PlayerSkillHandler;
import objects.battle.Skill;
import objects.battle.StatDisplayer;
import objects.battle.enemy.SkillHelper;
import objects.character.EnemyFighter;
import objects.character.Player;

import java.awt.*;
import java.util.List;

public class BattleSkillChoiceState extends BattleAskingState {
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

                statDisplayer.displayPreBar();
                output.generateText(chosenSkill.getName() + " did " + damage + " damage!");
                statDisplayer.displayPostBar();
                statDisplayer.displayStats(user, foe);

                user.changeSpeed(-20);
            }
            this.awaitingInput = false;
            this.done = true;
        }
    }
}
