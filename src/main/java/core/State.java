package core;

import io.InputValidator;

public interface State {
    /**
     * Executes when the state is not awaiting input
     */
    void preInput();

    /**
     * @param input from the user
     * Executes when the state is awaiting input
     */
    void postInput(String input);

    /**
     * @return whether the state is awaiting input
     */
    boolean awaitInput();

    /**
     * @return whether the state is done and ready to go to next state
     */
    boolean isDone();

    /**
     * @return the input validator for accepted inputs
     */
    InputValidator getInputValidator();
}
