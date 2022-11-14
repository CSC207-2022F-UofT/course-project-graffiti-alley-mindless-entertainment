package managers;

import interfaces.InputValidator;
import interfaces.State;

public abstract class StateManager implements State {

    private State currentState;
    private boolean isDone;

    abstract public State nextState(String input);

    abstract public void initialize();

    public boolean preInput() {
        if (currentState.preInput()) {
            this.nextState("");
        }
        return currentState.preInput();
    }

    public boolean postInput(String input) {
        if (currentState.postInput(input)) {
            this.nextState(input);
        }
        return currentState.postInput(input);
    }

    public boolean awaitInput() {
        return currentState.awaitInput();
    }

    public InputValidator getInputValidator() {
        return currentState.getInputValidator();
    }

}