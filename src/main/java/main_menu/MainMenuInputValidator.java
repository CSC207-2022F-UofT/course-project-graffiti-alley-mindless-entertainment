package main_menu;

import io.InputValidator;

/**
 * A class for validating input while the main menu is running.
 */
public class MainMenuInputValidator implements InputValidator {
    /**
     * Attributes:
     * currOption: The current option the main menu is in. An instance of the MainMenuOptions enum.
     */
    private final MainMenuOptions currOption;

    /**
     * Initializes a new MainMenuInputValidator.
     * @param mainMenuOption The MainMenuOption that is utilizing this MainMenuInputValidator.
     */
    public MainMenuInputValidator(MainMenuOptions mainMenuOption) {
        // Initializes a new MainMenuInputValidator.
        this.currOption = mainMenuOption;
    }

    /**
     * Validates and parses user input if valid.
     * @param input The user input to parse and validate.
     * @return A parsed lowercase String if valid, returns null if invalid.
     */
    @Override
    public String parseAndValidate(String input) {
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
        else if (this.currOption == MainMenuOptions.NEW) {
            // Ensures the input corresponds to starting a new game or returning to the main menu.
            if (input.equalsIgnoreCase(MainMenuOptions.START.toString()) ||
                    input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) {
                return input.toLowerCase();
            }
            else {
                return null;
            }
        }
        else if (this.currOption == MainMenuOptions.LOAD) {
            // Ensures the input corresponds to one of the save slots or returning to the main menu.
            // Awaiting saving implementation. Will make a loop here to calculate the number of save slots used and
            // will verify if the number given by the user is a valid save slot with a Player saved.
            if (input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) {
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

    /**
     * Gives a specific error message based on invalid user input.
     * @param input The invalid user input.
     * @return A String error message based on the input, or null if the response is not invalid.
     */
    @Override
    public String getErrorMessage(String input) {
        switch (this.currOption) {
            case MAINMENU:
                if (!(input.equalsIgnoreCase(MainMenuOptions.NEW.toString())) &&
                        !(input.equalsIgnoreCase(MainMenuOptions.LOAD.toString())) &&
                        !(input.equalsIgnoreCase(MainMenuOptions.QUIT.toString()))) {
                    return "Please choose one of the main menu options.";
                }
            case NEW:
                if (!(input.equalsIgnoreCase(MainMenuOptions.START.toString())) &&
                        !(input.equalsIgnoreCase(MainMenuOptions.RETURN.toString()))) {
                    return "Please choose to start the game or return to the main menu.";
                }
            case LOAD:
                if (!(input.equalsIgnoreCase(MainMenuOptions.RETURN.toString()))) {
                    return "Please choose to start a save file or return to the main menu.";
                }
            case QUIT:
                if (!(input.equalsIgnoreCase(MainMenuOptions.RETURN.toString())) &&
                        !(input.equalsIgnoreCase(MainMenuOptions.QUIT.toString()))) {
                    return "Please choose to quit the game or return to the main menu.";
                }
        }
        return null;
    }
}
