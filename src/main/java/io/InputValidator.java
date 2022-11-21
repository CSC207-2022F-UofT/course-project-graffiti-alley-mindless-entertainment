package io;

public interface InputValidator {
    /**
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    public String parseAndValidate(String input);

    /**
     * @param input the invalid user input
     * @return the corresponding error message
     */
    public default String getErrorMessage(String input) {
        return "This is not one of the available options provided.";
    }
}

