package game_world.use_cases;

import io.InputValidator;

import java.util.ArrayList;


public class WorldInputValidator implements InputValidator {

    private final ArrayList<String> possibleInputs;


    public WorldInputValidator() {
        this.possibleInputs = new ArrayList<>();
    }

    public WorldInputValidator(ArrayList<String> possibleInputs) {
        this.possibleInputs = possibleInputs;
    }

    /**
     * @param input current input from the user
     * @return If the input exists in possible inputs or possible inputs is empty, validates string
     *         Otherwise user must input again, the input is not valid
     */
    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (this.possibleInputs.isEmpty()) {
            // Enter any key
            return "";
        }
        else {
            String lowerInput = input.toLowerCase();
            if (this.possibleInputs.contains(lowerInput) || this.possibleInputs.size() == 1) {
                return lowerInput;
            }
        }
        return null;
    }
}
