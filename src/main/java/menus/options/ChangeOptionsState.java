package menus.options;

import io.InputValidator;
import interfaces.State;
import io.Output;
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
        this.quitCommand = "return";
        this.changeCommand = "change";
    }

    /**
     * Executes when not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        StringBuilder textToDisplay = new StringBuilder("Options: \n");
        textToDisplay.append(this.autoSaveCommand).append(": ");
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        textToDisplay.append(options.isEnableAutoSave() ? ANSI_BLUE : "").append("true ").append(ANSI_RESET);
        textToDisplay.append(!options.isEnableAutoSave() ? ANSI_BLUE : "").append("false ").append(ANSI_RESET);

        textToDisplay.append("\n").append(this.textSpeedCommand).append(": ");

        int[] textSpeedOptions = {1, 2, 3, 4, 5};
        for (int textSpeedOption : textSpeedOptions) {
            textToDisplay.append(options.getTextSpeed() == textSpeedOption ? ANSI_BLUE : "")
                    .append(textSpeedOption).append(" ").append(ANSI_RESET);
        }

        textToDisplay.append("\nTo change options, enter `").append(changeCommand).append(" settingName").append(" newValue`");
        textToDisplay.append("\nTo go back, enter `").append(quitCommand).append("`");
        Output.getScreen().generateText(textToDisplay.toString());

    }

    /**
     * Executes when awaiting input from the user
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
        //actually change the setting depending on the input.
        String[] inputarr = input.trim().split("\\s+");
        String command = inputarr[0];
        if (command.equalsIgnoreCase(quitCommand)) {
            isDone = true;
        } else if (command.equalsIgnoreCase(changeCommand)) {
            if (inputarr.length != 3) {
                Output.getScreen().generateText("Please enter 3 words! e.g. `change autoSave true`");
                return;
            }
            attemptChangeOption(inputarr[1], inputarr[2]);
        } else {
            Output.getScreen().generateText("Please enter a valid command! e.g. `change autoSave true`");
        }

    }


    /**
     * Attempt to change Option option to parameter value
     * @param option The option to change
     * @param value The value to change option to
     */
    private void attemptChangeOption(String option, String value) {
        boolean success = false;
        if (option.equalsIgnoreCase(textSpeedCommand)) {
            success = attemptTextSpeedChange(value);
        } else if (option.equalsIgnoreCase(autoSaveCommand)) {
            success = attemptAutoSaveChange(value);
        } else {
            Output.getScreen().generateText("Please select a valid option!");
        }

        if (success) {
            Output.getScreen().generateText("Successfully changed settings!");
            awaitingInput = false;
        }
    }


    /**
     * If value is a valid input, change enableAutoSave to value.
     * @param value new value of autoSave.
     * @return whether the input was valid
     */
    private boolean attemptAutoSaveChange(String value) {
        if (value.equalsIgnoreCase("true")) {
            options.setEnableAutoSave(true);
        }
        else if (value.equalsIgnoreCase("false")) {
            options.setEnableAutoSave(false);
        } else {
            Output.getScreen().generateText("This is not a valid value for option "+autoSaveCommand+"!");
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
            if (textSpeed > 5 || textSpeed < 1) {
                Output.getScreen().generateText("This is not a valid value for option "+textSpeedCommand+"!");
                return false;
            }
            options.setTextSpeed(textSpeed);
        } else {
            Output.getScreen().generateText("This is not a valid value for option "+textSpeedCommand+"!");
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
