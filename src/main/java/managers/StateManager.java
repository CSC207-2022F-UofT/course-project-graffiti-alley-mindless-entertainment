package managers;

import database.interfaces.InputValidator;
import database.interfaces.State;

public abstract class StateManager{

    protected State currState;
    protected boolean isDone=false;

    abstract public State nextState(String input);

    abstract public void initialize();

    public boolean isDone() {
        return this.isDone;
    }

    public void preInput() {
        currState.preInput();
        boolean currPreInput = currState.isDone();
        if (currPreInput) {
            this.currState = this.nextState("");
            if (this.currState == null) {
                this.isDone = true;
                return;
            }
        }
    }

    public void postInput(String input) {
        currState.postInput(input);
        boolean currPostInput = currState.isDone();
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
                return;
            }
        }
    }

    public boolean awaitInput() {
        return currState.awaitInput();
    }

    public InputValidator getInputValidator() {
        return currState.getInputValidator();
    }

}
