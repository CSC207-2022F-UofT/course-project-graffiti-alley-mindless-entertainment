package battlestates;

import interfaces.State;
import io.InputValidator;
import io.OutputHandlerImpl;
import objects.battle.Skill;
import objects.battle.SkillHandler;
import objects.character.Player;
import java.util.ArrayList;

public class EnemyTurnState implements State {
    private Player user;
    private Enemy foe;
    private boolean done = false;
    private String userAction;

    public EnemyTurnState(Player user, Enemy foe, String userAction) {
        this.user = user;
        this.foe = foe;
        this.userAction = userAction;
    }
    @Override
    public void preInput() {
        String action = foe.enemyAction(this.userAction);
        // If the enemy uses a skill
        if (action.equals("use skill")) {
            int max = size(foe.getSkills()) - 1;
            int min = 0;
            int skillIndex = (int) Math.floor(Math.random()*(max-min+1)+min);

            // Outputs and uses the chosen skill
            Skill chosenSkill = foe.getSkill(skillIndex);
            OutputHandlerImpl.getScreen().generateText(foe.getName() + " used " + chosenSkill.getName() +
                    " to do " + SkillHandler.useSkill(chosenSkill, user, foe) + " damage!");
        }
        // TEMPORARY SOLUTION: Just heal flat amount of 20
        if (action.equals("use potion")) {
            int hpIncrease = 20;
            foe.changeHealth(hpIncrease);
            OutputHandlerImpl.getScreen().generateText(foe.getName() + " used a potion to heal " +
                    hpIncrease + " health!");
        }
        foe.changeSpeed(-20);
    }

    /**
     * EnemyTurnState does not need input from the user.
     * @param input from the user
     * Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        this.done = true;
    }
    @Override
    public boolean awaitInput() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
