package game_world.validators;

import game_world.objects.Action;
import io.InputValidator;

import java.util.ArrayList;


public class EventInputValidator implements InputValidator {

    private final Action currentAction;
    private final ArrayList<String> possibleInputs;

    public EventInputValidator(Action currentAction) {
        this.currentAction = currentAction;
        this.possibleInputs = new ArrayList<>();
    }

    public EventInputValidator(Action currentAction, ArrayList<String> possibleInputs) {
        this.currentAction = currentAction;
        this.possibleInputs = possibleInputs;
    }

    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (currentAction == Action.ARBITRARY) {
            // Enter any key
            return "";
        }
        else {
            String lowerInput = input.toLowerCase();
            if (this.possibleInputs.contains(lowerInput)) {
                return lowerInput;
            }
            return null;
        }
    }
}
