package battlestates.states;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.character.EnemyFacade;
import objects.character.Player;

public class EnemyTurnState implements State {
    private Player user;
    private EnemyFacade foe;
    private boolean done = false;
    private String userAction;

    public EnemyTurnState(Player user, EnemyFacade foe, String userAction) {
        this.user = user;
        this.foe = foe;
        this.userAction = userAction;
    }
    @Override
    public void preInput() {
        EnemyActionHandler action = foe.enemyAction(userAction);

        action.useAction(foe, user);

//        String action = foe.enemyAction(this.userAction);
//        PlayerSkillHandler playerSkillHandler = new PlayerSkillHandler();
//
//        // If the EnemyFacade uses a skill
//        if (action.equals("use skill")) {
//            int max = foe.getSkills().size() - 1;
//            int min = 0;
//            int skillIndex = (int) Math.floor(Math.random()*(max-min+1)+min);
//
//            // Outputs and uses the chosen skill
//            Skill chosenSkill = foe.getSkill(skillIndex);
//            OutputHandlerImpl.getScreen().generateText(foe.getName() + " used " + chosenSkill.getName() +
//                    " to do " + playerSkillHandler.useSkill(chosenSkill, user, foe) + " damage!");
//        }
//        // TEMPORARY SOLUTION: Just heal flat amount of 20
//        if (action.equals("use potion")) {
//            int hpIncrease = 20;
//            foe.changeHealth(hpIncrease);
//            OutputHandlerImpl.getScreen().generateText(foe.getName() + " used a potion to heal " +
//                    hpIncrease + " health!");
//        }

        foe.changeSpeed(-20); // Speed tax per turn
        this.done = true;
    }

    /**
     * EnemyTurnState does not need input from the user.
     * @param input from the user
     * Executes when the state is awaiting input
     */
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
