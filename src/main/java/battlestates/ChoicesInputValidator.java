package battlestates;

import io.InputValidator;

import java.util.List;

public class ChoicesInputValidator implements InputValidator {

    private List<String> options;

    public ChoicesInputValidator(List<String> options) {
        this.options = options;
    }
    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    @Override
    public String parseAndValidate(String input) {
        String cleaned = input.toLowerCase().strip();
        Character choice = cleaned.charAt(0);
        int choiceIndex = 65 - (int) choice;

        if (choiceIndex < options.size() - 1 && choiceIndex >= 0) {
            // ASCII 65 -> 90 are 'A' -> 'Z'
            return options.get(choiceIndex);
        }
        return null;
    }
}
