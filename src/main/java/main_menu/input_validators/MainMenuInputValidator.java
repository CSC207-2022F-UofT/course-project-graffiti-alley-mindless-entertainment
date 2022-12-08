package main_menu.input_validators;

import io.InputValidator;
import main_menu.MainMenuOptions;

/**
 * A class for validating input while the main menu is running.
 */
public class MainMenuInputValidator implements InputValidator {

    /**
     * Initializes a new MainMenuInputValidator.
     */
    public MainMenuInputValidator() {
    }

    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.equalsIgnoreCase(MainMenuOptions.NEW.toString()) ||
                input.equalsIgnoreCase(MainMenuOptions.LOAD.toString())) {
            return input.toLowerCase();
        }
        else {
            return null;
        }
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the response is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (!(input.equalsIgnoreCase(MainMenuOptions.NEW.toString())) &&
                !(input.equalsIgnoreCase(MainMenuOptions.LOAD.toString()))) {
            return "Please choose one of the main menu options.";
        }
        return null;
    }
}
