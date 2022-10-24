package interfaces;

public interface State {
    public boolean preInput();
    public boolean postInput(String input);
    public boolean awaitInput();
    public InputValidator getInputValidator();
}
