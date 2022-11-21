package playercreation;

import io.InputValidator;
import objects.battle.SkillType;

import java.util.Objects;

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
        // Validates user input for different situations during Player creation. Returns true if the input is valid,
        // false otherwise.
        if (currQuestion == PlayerQuestion.SKILLTYPE) {
            // Ensures the input corresponds to one of the SkillType enums.
            if (input.equalsIgnoreCase(SkillType.AIR.name())) {

            }

        }
        else if (currQuestion == PlayerQuestion.NAME) {
            // Ensures Player names are 20 characters or fewer, and not empty or blank.
            return (input.length() <= 20) && (!input.isEmpty()) && (!input.isBlank());
        }

        else if (currQuestion == PlayerQuestion.DESCRIPTION) {
            // Ensures Player descriptions are 200 characters or fewer, and not empty or blank.
            return (input.length() <= 200) && (!input.isEmpty()) && (!input.isBlank());
        }

        else if (currQuestion == PlayerQuestion.CONFIRM) {
            // Ensures the user inputted either "confirm" or "return" for confirming a response.
            return Objects.equals(input, "confirm") || Objects.equals(input, "return");
        }
        return false;
    }
}
