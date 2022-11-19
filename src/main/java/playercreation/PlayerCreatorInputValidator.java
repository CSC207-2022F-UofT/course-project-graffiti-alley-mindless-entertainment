package playercreation;

import interfaces.InputValidator;

import java.util.Objects;

public class PlayerCreatorInputValidator implements InputValidator {
    /** A class for validating input during Player creation at the start of the game.
     * Attributes:
     * currQuestion: The current question being asked of the user. Of type PlayerQuestion.
     */
    private final PlayerQuestion currQuestion;

    public PlayerCreatorInputValidator(PlayerQuestion currQuestion) {
        // Constructs a new PlayerCreatorInputValidator with currQuestion.
        this.currQuestion = currQuestion;
    }

    @Override
    public boolean validateInput(String input) {
        // Validates user input for different situations during Player creation. Returns true if the input is valid,
        // false otherwise.
        if (currQuestion == PlayerQuestion.SKILLTYPE) {
            // Waiting for SkillType implementation.
            return false;
        }
        else if (currQuestion == PlayerQuestion.CONFIRM) {
            return Objects.equals(input, "confirm") || Objects.equals(input, "return");
        }
        return false;
    }
}
