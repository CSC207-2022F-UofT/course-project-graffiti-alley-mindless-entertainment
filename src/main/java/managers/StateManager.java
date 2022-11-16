package managers;

import interfaces.InputValidator;
import interfaces.State;

public abstract class StateManager{

    private State currState;

    private boolean isDone;

    abstract public State nextState(String input);

    abstract public void initialize();

    public boolean isDone() {
        return this.isDone();
    }

    public void preInput() {
        boolean currPreInput = currState.preInput();
        if (currPreInput) {
            this.currState = this.nextState("");
            if (this.currState == null) {
                this.isDone = true;
                return;
            }
        }
        this.isDone = false;
    }

    public void postInput(String input) {
        boolean currPostInput = currState.postInput(input);
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
                return;
            }
        }
        this.isDone = false;
    }

    public boolean awaitInput() {
        return currState.awaitInput();
    }

    public InputValidator getInputValidator() {
        return currState.getInputValidator();
    }

}
