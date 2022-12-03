package playercreation;

import io.InputValidator;
import objects.battle.SkillType;

/**
 * A class for validating input during Player creation at the start of the game.
 */
public class PlayerCreatorInputValidator implements InputValidator {
    /**
     * currQuestion: The current question being asked of the user. An enum of type PlayerQuestion.
     */
    private final PlayerQuestion currQuestion;

    /**
     * Constructs a new PlayerCreatorInputValidator.
     * @param currQuestion The current question being asked of the user.
     */
    public PlayerCreatorInputValidator(PlayerQuestion currQuestion) {
        this.currQuestion = currQuestion;
    }

    /**
     * Validates and parses user input if valid, returns null if invalid.
     * @param input The user input to parse and validate.
     * @return The parsed String if valid input, null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
        if (currQuestion == PlayerQuestion.SKILLTYPE) {
            // Ensures the input corresponds to one of the SkillType enums.
            if (input.equalsIgnoreCase(SkillType.AIR.toString()) ||
                    input.equalsIgnoreCase(SkillType.FIRE.toString()) ||
                    input.equalsIgnoreCase(SkillType.EARTH.toString()) ||
                    input.equalsIgnoreCase(SkillType.WATER.toString())) {
                return input.toLowerCase();
            }
            else {
                return null;
            }
        }
        else if (currQuestion == PlayerQuestion.NAME) {
            // Ensures Player names are 20 characters or fewer, and not empty or blank.
            boolean notEmptyOrBlank = (!input.isEmpty()) && (!input.isBlank());
            if (input.length() <= 20) {
                if (notEmptyOrBlank) {
                    return input.toLowerCase();
                }
            }
            return null;
        }

        else if (currQuestion == PlayerQuestion.DESCRIPTION) {
            // Ensures Player descriptions are 200 characters or fewer, and not empty or blank.
            boolean notEmptyOrBlank = (!input.isEmpty()) && (!input.isBlank());
            if (input.length() <= 200) {
                if (notEmptyOrBlank) {
                    return input.toLowerCase();
                }
            }
            return null;
        }

        else if (currQuestion == PlayerQuestion.CONFIRM) {
            // Ensures the user inputted either "confirm" or "return" for confirming a response.
            if (input.equalsIgnoreCase("confirm")) {
                return input.toLowerCase();
            }
            else if (input.equalsIgnoreCase("return")) {
                return input.toLowerCase();
            }
            return null;
        }
        return null;
    }

    /**
     * Returns a specific error message based on the input and the current question.
     * @param input The invalid user input.
     * @return A String of a specific error message based on the invalid input.
     */
    @Override
    public String getErrorMessage(String input) {
        if (currQuestion == PlayerQuestion.NAME) {
            if (input.length() > 20) {
                return "Please make names 20 characters or less.";
            }
            else if (input.isEmpty() || input.isBlank()) {
                return "Please type a valid name.";
            }
        }
        else if (currQuestion == PlayerQuestion.DESCRIPTION) {
            if (input.length() > 200) {
                return "Please make descriptions 200 characters or less.";
            }
            else if (input.isEmpty() || input.isBlank()) {
                return "Please type a valid description.";
            }
        }
        else if (currQuestion == PlayerQuestion.SKILLTYPE) {
            if (!(input.equalsIgnoreCase(SkillType.FIRE.toString())) &&
                    !(input.equalsIgnoreCase(SkillType.AIR.toString())) &&
                    !(input.equalsIgnoreCase(SkillType.EARTH.toString())) &&
                    !(input.equalsIgnoreCase(SkillType.WATER.toString()))) {
                return "Please type a valid skill type: Air, Earth, Fire, or Water.";
            }
        }
        else if (currQuestion == PlayerQuestion.CONFIRM) {
            if (!(input.equalsIgnoreCase("confirm")) && !(input.equalsIgnoreCase("return"))) {
                return "Please confirm your response or return to the previous question.";
            }
        }
        return null;
    }
}
