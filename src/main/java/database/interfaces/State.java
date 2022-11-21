package database.interfaces;

public interface State {
    /**
     * Executes when the state is not awaiting input
     */
    public void preInput();

    /**
     * @param input from the user
     * Executes when the state is awaiting input
     */
    public void postInput(String input);

    /**
     * @return whether the state is awaiting input
     */
    public boolean awaitInput();

    /**
     * @return whether the state is done and ready to go to next state
     */
    public boolean isDone();

    /**
     * @return the input validator for accepted inputs
     */
    public InputValidator getInputValidator();
}
