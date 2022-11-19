package interfaces;

public interface InputValidator {
    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    public String parseAndValidate(String input);
}

