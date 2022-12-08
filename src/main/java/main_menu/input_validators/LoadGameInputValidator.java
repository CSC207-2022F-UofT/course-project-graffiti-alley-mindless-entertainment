package main_menu.input_validators;

import io.InputValidator;
import main_menu.MainMenuOptions;
import save.SaveInteractor;

/**
 * A class for validating input while loading a new game.
 */
public class LoadGameInputValidator implements InputValidator {
    /**
     * saveInteractor: The SaveInteractor of this LoadGameInputValidator. Used to validate the total number of slots
     *                 that the user can save in.
     */
    private final SaveInteractor saveInteractor;

    /**
     * Initializes a new LoadGameInputValidator.
     * @param saveInteractor The SaveInteractor for this LoadGameInputValidator.
     */
    public LoadGameInputValidator(SaveInteractor saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    /**
     * Validates and parses user input if valid.
     * @param input the user input to parse and validate
     * @return null if the given input is not valid, otherwise the parsed input
     */
    @Override
    public String parseAndValidate(String input) {
        if (input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) {
            return input.toLowerCase();
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            return null;
        }
        int slots = this.saveInteractor.getMaxSlots();
        for (int i = 0; i <= slots; i++) {
            if (Integer.parseInt(input) == i) {
                return input;
            }
        }
        return null;
    }

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the response is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        boolean validSlot = false;
        int slots = this.saveInteractor.getMaxSlots();
        for (int i = 0; i <= slots; i++) {
            if (Integer.parseInt(input) == i) {
                validSlot = true;
            }
        }
        if (!(input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) && !(validSlot)) {
            return "Please choose to open a save file or return to the main menu.";
        }
        else {
            return null;
        }
    }
}

