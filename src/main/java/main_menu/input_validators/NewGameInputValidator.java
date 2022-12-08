package main_menu.input_validators;

import io.InputValidator;
import main_menu.MainMenuOptions;

/**
 * A class for validating input while creating a new game.
 */
public class NewGameInputValidator implements InputValidator {

    /**
     * Initializes a new NewGameInputValidator.
     */
    public NewGameInputValidator() {
    }

    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.equalsIgnoreCase(MainMenuOptions.START.toString()) ||
                input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) {
            return input.toLowerCase();
        } else {
            return null;
        }
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input the invalid user input
     * @return A String error message based on the input, or null if the response is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (!(input.equalsIgnoreCase(MainMenuOptions.START.toString())) &&
                !(input.equalsIgnoreCase(MainMenuOptions.RETURN.toString()))) {
            return "Please choose to start the game or return to the main menu.";
        } else {
            return null;
        }
    }
}
