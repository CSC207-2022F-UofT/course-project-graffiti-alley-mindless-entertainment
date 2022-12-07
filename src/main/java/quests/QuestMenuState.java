package quests;

import game_world.managers.QuestManager;
import interfaces.State;
import io.InputValidator;
import objects.character.Player;

/**
 *
 */
public class QuestMenuState implements State {
    /**
     * Attributes
     */
    private Player player;
    private QuestManager questManager;
    private boolean awaitingInput;
    private boolean isDone;


    public QuestMenuState(Player player) {
        this.player = player;
        this.questManager = new QuestManager();
        this.awaitingInput = false;
        this.isDone = false;
    }

    /**
     * Executes when the state is not awaiting input
     */
    @Override
    public void preInput() {
        this.questManager.completeQuests(this.player);
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        this.awaitingInput = false;
        this.isDone = true;

    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {
        return this.awaitingInput;
    }

    /**
     *
     * @return whether the state is done and ready to go to next state
     */
    @Override
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Not needed for this class.
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
