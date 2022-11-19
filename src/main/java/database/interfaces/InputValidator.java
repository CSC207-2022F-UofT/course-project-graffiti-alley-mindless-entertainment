package database.interfaces;

public interface InputValidator {
    /**
     * @param input the user input to validate
     * @return whether the given input is valid
     */
    public boolean validateInput(String input);
}
