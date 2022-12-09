package player_creation.input_validators;

import io.InputValidator;

/**
 * A class for validating the Player name at the start of the game.
 */
public class PlayerNameValidator implements InputValidator {

    /**
     * Initializes a new PlayerNameValidator.
     */
    public PlayerNameValidator() {}

    /**
     * Parses and validates input from the user.
     * @param input The user input to parse and validate.
     * @return The parsed String if valid input, null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.length() <= 20 && !(input.isEmpty()) && !(input.contains("|"))) {
            return input.toLowerCase();
        }
        return null;
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the name is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (input.length() > 20) {
            return "Please make names 20 characters or less.";
        }
        else if (input.isEmpty()) {
            return "Please type a valid name.";
        }
        else if (input.contains("|")) {
            return "| is not a supported character. Please try again.";
        }
        return null;
    }
}
