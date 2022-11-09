package managers;

import interfaces.InputValidator;
import interfaces.State;

public abstract class StateManager implements State {

    private State currentState;

    abstract public State nextState(String input) {
    }

    abstract public void initialize() {
    }

    public boolean preInput() {
        return currentState.preInput();
    }

    public boolean postInput(String input) {
        return currentState.postInput(input);
    }

    public boolean awaitInput() {
        return currentState.awaitInput();
    }

    public InputValidator getInputValidator() {
        return currentState.getInputValidator();
    }

}