package playercreation;

import interfaces.InputValidator;
import interfaces.State;

public class PlayerConfirmState implements State {

    @Override
    public void preInput() {

    }

    @Override
    public void postInput(String input) {

    }

    @Override
    public boolean awaitInput() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
