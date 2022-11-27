package game_world.validators;

import game_world.objects.Action;
import io.InputValidator;

import java.util.ArrayList;


public class AreaInputValidator implements InputValidator {

    private final Action currentAction;
    private final ArrayList<String> possibleInputs;

    public AreaInputValidator(Action currentAction) {
        // Constructs a new PlayerCreatorInputValidator with currQuestion.
        this.currentAction = currentAction;
        this.possibleInputs = new ArrayList<>();
    }

    public AreaInputValidator(Action currentAction, ArrayList<String> possibleInputs) {
        // Constructs a new PlayerCreatorInputValidator with currQuestion.
        this.currentAction = currentAction;
        this.possibleInputs = possibleInputs;
    }

    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (currentAction == Action.ENTERING_AREA) {
            // Enter any key
            return "";
        }
        else if (currentAction == Action.LEAVING_AREA) {
            String lowerInput = input.toLowerCase();
            if (this.possibleInputs.contains(lowerInput)) {
                return lowerInput;
            }
        }
        return null;
    }
}
