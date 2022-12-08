package quests;

import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

public class QuestMenuState implements State {
    /**
     * Attributes.
     */
    private final QuestInteractor questInteractor;
    private boolean isDone;
    private boolean isAwaitingInput;

    /**
     * Constructor.
     */
    public QuestMenuState(QuestInteractor questInteractor) {
        this.questInteractor = questInteractor;
        this.isDone = false;
        this.isAwaitingInput = false;
    }


    /**
     * Executes when the state is not awaiting input
     */
    @Override
    public void preInput() {
        // completes all the quests (update the quests that can be completed).
        questInteractor.completeQuests();

        // displays the quests.
        OutputHandler output = Output.getScreen();
        output.generateText("Here are your quests:");
        output.generateText(getQuestsStatuses());

        this.isAwaitingInput = true;
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        this.isAwaitingInput = false;
        this.isDone = true;
    }

    /**
     * @return a string containing all the quests in the game, accepted by the player.
     */
    private String getQuestsStatuses() {
        String str = "";

        for (Quest quest: this.questInteractor.getQuests()) {
            str += quest.toString();
        }

        return str;
    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {
        return this.isAwaitingInput;
    }

    /**
     * @return whether the state is done and ready to go to next State.
     */
    @Override
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * @return null, as not needed in this case.
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
