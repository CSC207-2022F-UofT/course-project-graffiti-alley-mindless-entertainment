package core;

import io.InputValidator;

public abstract class StateManager{

    protected State currState;
    protected boolean isDone=false;

    abstract protected State nextState(String input);

    abstract public void initialize();

    /**
     * @return whether the state is done or not
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Executes whenever currState is not awaiting input.
     */
    public void preInput() {
        currState.preInput();
        boolean currPreInput = currState.isDone();
        if (currPreInput) {
            this.currState = this.nextState("");
            if (this.currState == null) {
                this.isDone = true;
            }
        }
    }

    /**
     * Executes whenever currState is awaiting input.
     * @param input from the user
     */
    public void postInput(String input) {
        currState.postInput(input);
        boolean currPostInput = currState.isDone();
        if (currPostInput) {
            this.currState = this.nextState(input);
            if (this.currState == null) {
                this.isDone = true;
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
