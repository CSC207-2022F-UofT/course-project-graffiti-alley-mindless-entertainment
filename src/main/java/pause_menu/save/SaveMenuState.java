package pause_menu.save;

import core.State;
import io.InputValidator;
import io.Output;
import save.use_cases.SaveInteractor;

/**
    Implements State to save menu
 */
public class SaveMenuState implements State {

    /**
     * awaitingInput: whether the state is waiting for user input
     * isDone: whether the state is done
     * interactor: the SaveInteractor to interact with saving options
     */
    private boolean awaitingInput = false;
    private boolean isDone = false;
    private final SaveInteractor interactor;

    public SaveMenuState(SaveInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Executes when the state is not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        Output.getScreen().generateText(interactor.getSlotsStatus());
        String textToDisplay = "Options: \n" + "To return to the previous menu: return\n" +
                "To save to files: save + slot #";
        Output.getScreen().generateText(textToDisplay);
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        String[] inputArr = input.trim().split("\\s+");
        String command = inputArr[0];
        if (command.equalsIgnoreCase("return")) {
            isDone = true;
            return;
        }
        if (command.equalsIgnoreCase("save")) {
            if (inputArr.length != 2) {
                Output.getScreen().generateText("Please enter an argument for Save command:" +
                        " the slot to be saved to");
                return;
            }
            String slot = inputArr[1];
            if (!isInt(slot)) {
                Output.getScreen().generateText("Please enter an integer for the slot to be saved to.");
                return;
            }
            int s = Integer.parseInt(slot);
            if (s == 0) {
                Output.getScreen().generateText("Slot #0 is reserved for autosave.");
            }
            if (s < 1 || s > interactor.getMaxSlots()) {
                Output.getScreen().generateText("Please enter a valid slot.");
                return;
            }
            interactor.saveAtSlot(s);
            awaitingInput = false;
            return;
        }
        Output.getScreen().generateText("Please enter a valid command! e.g. `return` or 'save 1'");
    }

    /**
     * @return whether the state is awaiting input
     */
    @Override
    public boolean awaitInput() {
        return awaitingInput;
    }

    /**
     * @return whether the state is done and ready to go to next state
     */
    @Override
    public boolean isDone() {
        return isDone;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }

    /**
     * @param value any string
     * @return whether value is a parseable integer
     */
    private boolean isInt(String value) {
        return value.matches("-?\\d+");
    }
}
