package game_world.validators;

import game_world.objects.Action;
import io.InputValidator;


public class AreaInputValidator implements InputValidator {

    private final Action currentAction;

    public AreaInputValidator(Action currentAction) {
        // Constructs a new PlayerCreatorInputValidator with currQuestion.
        this.currentAction = currentAction;
    }

    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (currentAction == Action.ENTERING_AREA) {
            // Enter any key
            return "";
        }
        else if (currentAction == Action.LEAVING_AREA) {
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
