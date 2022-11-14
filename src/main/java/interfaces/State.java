package interfaces;

public interface State {
    /**
     * @return whether the state is done and ready to move to the next state
     */
    public boolean preInput();

    /**
     * @param input from the user
     * @return whether the state is done and ready to move to the next state
     */
    public boolean postInput(String input);

    /**
     * @return whether the state is awaiting input
     */
    public boolean awaitInput();

    /**
     * @return the input validator for accepted inputs
     */
    public InputValidator getInputValidator();
}
