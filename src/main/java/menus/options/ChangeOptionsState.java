package menus.options;

import interfaces.InputValidator;
import interfaces.State;
import options.Options;

/**
 * Use case to change the options based on user input.
 */
public class ChangeOptionsState implements State {

    /**
     * options: Entity for game options
     * isDone: whether the state is done
     * awaitingInput: whether the state is waiting for user input
     * xxxCommand: extracted constants for user commands.
     */

    private final Options options;
    private boolean isDone = false;
    private boolean awaitingInput = false;

    private final String textSpeedCommand;

    private final String autoSaveCommand;

    private final String quitCommand;

    private final String changeCommand;

    /**
     * @param options stored options of the game. Injected dependency.
     */
    public ChangeOptionsState(Options options) {
        this.options = options;
        this.textSpeedCommand = "textSpeed";
        this.autoSaveCommand = "autoSave";
        this.quitCommand = "quit";
        this.changeCommand = "change";
        //this.inputValidator = new ChoiceInputValidator();
    }

    /**
     * Executes when not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        //use OutputHandler to display text here
        //ask which setting to change
    }

    /**
     * Executes when awaiting input from the user
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
        //actually change the setting depending on the input.
        String[] inputarr = input.split(" ");
        String command = inputarr[0];
        if (command.equals(quitCommand)) {
            isDone = true;
            return;
        } else if (command.equals(changeCommand)) {
            if (inputarr.length != 3) {
                //say input invalid
                return;
            }
            String option = inputarr[1];
            String value = inputarr[2];
            boolean success = false;
            if (option.equals(textSpeedCommand)) {
                success = attemptTextSpeedChange(value);
            } else if (option.equals(autoSaveCommand)) {
                success = attemptAutoSaveChange(value);
            }

            if (success) {
                //say change successful
                awaitingInput = false;
            }
        } else {
            //say input invalid
        }

    }


    /**
     * If value is a valid input, change enableAutoSave to value.
     * @param value new value of autoSave.
     * @return whether the input was valid
     */
    private boolean attemptAutoSaveChange(String value) {
        if (value.toLowerCase().equals("true")) {
            options.setEnableAutoSave(true);
        }
        else if (value.toLowerCase().equals("false")) {
            options.setEnableAutoSave(false);
        } else {
            //say input invalid
            return false;
        }
        return true;
    }

    /**
     * If value is a valid input, change textSpeed to value.
     * @param value new value of textSpeed.
     * @return whether the input was valid.
     */
    private boolean attemptTextSpeedChange(String value) {
        if (isInt(value)) {
            int textSpeed = Integer.parseInt(value);
            options.setTextSpeed(textSpeed);
        } else {
            //say input invalid
            return false;
        }
        return true;
    }

    /**
     * @param value any string
     * @return whether value is a parseable integer
     */
    private boolean isInt(String value) {
        return value.matches("-?\\d+");
    }

    /**
     * @return whether the state is awaiting input
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * @return whether the state needs input
     */
    @Override
    public boolean awaitInput() {
        return awaitingInput;
    }

    /**
     * do not validate input
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
