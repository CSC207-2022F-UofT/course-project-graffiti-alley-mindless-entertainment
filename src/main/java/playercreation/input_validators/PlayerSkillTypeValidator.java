package playercreation.input_validators;

import io.InputValidator;
import objects.battle.SkillType;

/**
 * A class for validating the Player's SkillType at the start of the game.
 */
public class PlayerSkillTypeValidator implements InputValidator {

    /**
     * Initializes a new PlayerSkillTypeValidator.
     */
    public PlayerSkillTypeValidator() {}

    /**
     * Parses and validates input from the user.
     * @param input The user input to parse and validate.
     * @return The parsed String if valid input, null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
        if ((input.equalsIgnoreCase(SkillType.FIRE.toString())) ||
                (input.equalsIgnoreCase(SkillType.AIR.toString())) ||
                (input.equalsIgnoreCase(SkillType.EARTH.toString())) ||
                (input.equalsIgnoreCase(SkillType.WATER.toString()))) {
            return input.toLowerCase();
        }
        return null;
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the skill type is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        if (!(input.equalsIgnoreCase(SkillType.FIRE.toString())) &&
                !(input.equalsIgnoreCase(SkillType.AIR.toString())) &&
                !(input.equalsIgnoreCase(SkillType.EARTH.toString())) &&
                !(input.equalsIgnoreCase(SkillType.WATER.toString()))) {
            return "Please type a valid skill type: Air, Earth, Fire, or Water.";
        }
        return null;
    }
}
