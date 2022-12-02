package core;

import io.InputValidator;
import interfaces.State;

public abstract class StateManager{

    protected State currState;
    protected boolean isDone=false;

    abstract protected State nextState(String input);

    abstract public void initialize() throws Exception;

    /**
     * @return whether the state is done or not
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * @return whether the state is done and ready to move to the next state
     */
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

    /**
     * @param input from the user
     * @return whether the state is done and ready to move to the next state
     */
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

    /**
     * @return whether the state is awaiting input
     */
    public boolean awaitInput() {
        return currState.awaitInput();
    }

    /**
     * @return the input validator for accepted inputs
     */
    public InputValidator getInputValidator() {
        return currState.getInputValidator();
    }

}
