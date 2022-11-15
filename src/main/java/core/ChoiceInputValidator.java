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
     * @param input the user input to validate
     * @return whether the given input is valid
     */
    @Override
    public boolean validateInput(String input) {
        return allowedInputs.contains(input);
    }
}
