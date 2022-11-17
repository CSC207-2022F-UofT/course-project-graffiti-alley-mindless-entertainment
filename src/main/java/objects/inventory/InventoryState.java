import interfaces.InputValidator;
import interfaces.State;

public class InventoryState implements State {
    InputValidator inputValidator;

    public InventoryState(){

    }

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