package player_creation.input_validators;

import io.InputValidator;

/**
 * A class for validating the user either confirming or returning to a previous question.
 */
public class PlayerConfirmValidator implements InputValidator {

    /**
     * Initializes a new PlayerConfirmValidator.
     */
    public PlayerConfirmValidator() {}

    /**
     * Parses and validates input from the user.
     * @param input The user input to parse and validate.
     * @return The parsed String if valid input, null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.equalsIgnoreCase("confirm") || input.equalsIgnoreCase("return")) {
            return input.toLowerCase();
        }
        return null;
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the response is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (!(input.equalsIgnoreCase("confirm")) && !(input.equalsIgnoreCase("return"))) {
            return "Please confirm your response or return to the previous question.";
        }
        return null;
    }
}
