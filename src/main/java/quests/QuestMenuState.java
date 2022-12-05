package quests;

import interfaces.State;
import io.InputValidator;

public class QuestMenuState implements State {
    /**
     * Executes when the state is not awaiting input
     */
    @Override
    public void preInput() {

    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {

    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {
        return false;
    }

    /**
     * @return whether the state is done and ready to go to next state
     */
    @Override
    public boolean isDone() {
        return false;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
