package core;

import interfaces.InputValidator;

import java.util.Arrays;
import java.util.List;

public class ChoiceInputValidator implements InputValidator {

    /**
     * allowedInputs: The inputs the program will allow from the user.
     */
    List<String> allowedInputs;

    public ChoiceInputValidator(List<String> allowedInputs) {
        this.allowedInputs = allowedInputs;
    }

    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    @Override
    public String parseAndValidate(String input) {
        List<String> opt = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        if (opt.contains(input)) {
            return allowedInputs.get(opt.indexOf(input)).toLowerCase();
        }
        for (String option: allowedInputs) {
            if (option.toLowerCase() == input) {
                return input;
            }
        }
        return null;
    }
}