package main_menu;

import io.InputValidator;

public class MainMenuInputValidator implements InputValidator {
    /** A class for validating input during Player creation at the start of the game.
     * Attributes:
     * currOption: The current option the main menu is in. An instance of the MainMenuOptions enum.
     */
    private final MainMenuOptions currOption;

    public MainMenuInputValidator(MainMenuOptions mainMenuOption) {
        // Initializes a new MainMenuInputValidator.
        this.currOption = mainMenuOption;
    }

    @Override
    public String parseAndValidate(String input) {
        // Validates and parses user input if valid, returns null if invalid.
        if (this.currOption == MainMenuOptions.MAINMENU) {
            // Ensures the input corresponds to one of the main menu options.
            if (input.equalsIgnoreCase(MainMenuOptions.NEW.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.LOAD.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.QUIT.toString())) {
                return input.toLowerCase();
            }
            else {
                return null;
            }
        }
        else if (this.currOption == MainMenuOptions.NEW || this.currOption == MainMenuOptions.LOAD) {
            // Ensures the input corresponds to one of the save slots or returning to the main menu.
            if (input.equalsIgnoreCase(MainMenuOptions.SAVE1.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.SAVE2.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.SAVE3.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) {
                return input.toLowerCase();
            }
            else {
                return null;
            }
        }
        else if (this.currOption == MainMenuOptions.QUIT) {
            // Ensures the input corresponds to either returning to the main menu or quitting the game.
            if (input.equalsIgnoreCase(MainMenuOptions.RETURN.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.QUIT.toString())) {
                return input.toLowerCase();
            }
            else {
                return null;
            }
        }
        return null;
    }
}
