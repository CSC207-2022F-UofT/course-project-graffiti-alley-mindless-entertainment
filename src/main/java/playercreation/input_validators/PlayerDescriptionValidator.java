package playercreation.input_validators;

import io.InputValidator;

/**
 * A class for validating the Player description at the start of the game.
 */
public class PlayerDescriptionValidator implements InputValidator {

    /**
     * Initializes a new PlayerDescriptionValidator.
     */
    public PlayerDescriptionValidator() {}

    /**
     * Parses and validates input from the user.
     * @param input The user input to parse and validate.
     * @return The parsed String if valid input, null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.length() <= 200 && !(input.isBlank()) && !(input.isEmpty()) && !(input.contains("|"))) {
            return input.toLowerCase();
        }
        return null;
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the description is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (input.length() > 200) {
            return "Please make descriptions 200 characters or less.";
        }
        else if (input.isEmpty() || input.isBlank()) {
            return "Please type a valid description.";
        }
        else if (input.contains("|")) {
            return "| is not a supported character. Please try again.";
        }
        return null;
    }
}
