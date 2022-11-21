package playercreation;

import io.InputValidator;
import objects.battle.SkillType;


public class PlayerCreatorInputValidator implements InputValidator {
    /** A class for validating input during Player creation at the start of the game.
     * Attributes:
     * currQuestion: The current question being asked of the user. An enum of type PlayerQuestion.
     */
    private final PlayerQuestion currQuestion;

    public PlayerCreatorInputValidator(PlayerQuestion currQuestion) {
        // Constructs a new PlayerCreatorInputValidator with currQuestion.
        this.currQuestion = currQuestion;
    }

    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (currQuestion == PlayerQuestion.SKILLTYPE) {
            // Ensures the input corresponds to one of the SkillType enums.
            if (input.equalsIgnoreCase(SkillType.AIR.toString())) {
                return input.toLowerCase();
            }
            else if (input.equalsIgnoreCase(SkillType.FIRE.toString())) {
                return input.toLowerCase();
            }
            else if (input.equalsIgnoreCase(SkillType.EARTH.toString())) {
                return input.toLowerCase();
            }
            else if (input.equalsIgnoreCase(SkillType.WATER.toString())) {
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
}
