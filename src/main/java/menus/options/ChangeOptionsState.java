package menus.options;

import interfaces.InputValidator;
import interfaces.State;

public class ChangeOptionsState implements State {

    /**
     * @return whether the state is done
     */
    @Override
    public void preInput() {
        //use OutputHandler to display text here
        //ask which setting to change
    }

    /**
     * @param input from the user
     * @return whether the state is done
     */
    @Override
    public void postInput(String input) {
        //actually change the setting depending on the input.
        return;
    }

    /**
     * @return whether the state is awaiting input
     */
    public boolean isDone() {
        return true;
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
