package core;

import database.interfaces.InputValidator;

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
        String parsed = input.toUpperCase();
        if (parsed == "EXIT" || parsed == "PAUSE") {
            return parsed;
        }
        List<String> opt = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        if (opt.contains(parsed)) {
            return allowedInputs.get(opt.indexOf(parsed));
        }
        return null;
    }
}