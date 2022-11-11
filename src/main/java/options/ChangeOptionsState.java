package options;

import interfaces.InputValidator;
import interfaces.State;

public class ChangeOptionsState implements State {

    /**
     * @return whether the state is done
     */
    @Override
    public boolean preInput() {
        return false;
    }

    /**
     * @param input from the user
     * @return whether the state is done
     */
    @Override
    public boolean postInput(String input) {
        return false;
    }

    /**
     * @return whether the state needs input
     */
    @Override
    public boolean awaitInput() {
        return false;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
